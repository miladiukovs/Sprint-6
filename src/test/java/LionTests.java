import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class LionTests {

    private Feline mockFeline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        // Создаем мок-объект для Feline
        mockFeline = Mockito.mock(Feline.class);
        // Создаем экземпляр Lion, передавая мок-объект
        lion = new Lion("Самец", mockFeline) {
            @Override
            public int getKittens() {
                return mockFeline.getKittens();
            }

            @Override
            public List<String> getFood() throws Exception {
                return mockFeline.getFood("Хищник");
            }
        };
    }

    @Test
    public void testConstructorWithMale() throws Exception {
        Lion maleLion = new Lion("Самец", mockFeline);
        assertEquals(true, maleLion.doesHaveMane());
    }

    @Test
    public void testConstructorWithFemale() throws Exception {
        Lion femaleLion = new Lion("Самка", mockFeline);
        assertEquals(false, femaleLion.doesHaveMane());
    }

    @Test
    public void testConstructorWithInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный пол", mockFeline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void testGetKittens() {
        // Настраиваем мок-объект для метода getKittens
        when(mockFeline.getKittens()).thenReturn(3);

        // Проверяем, что метод getKittens возвращает ожидаемое значение
        assertEquals(3, lion.getKittens());
    }


    @Test
    public void testGetFood() throws Exception {
        // Настраиваем мок-объект для метода getFood
        List<String> expectedFood = Arrays.asList("Мясо", "Птица", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        // Проверяем, что метод getFood возвращает ожидаемое значение
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testGetFoodThrowsException() throws Exception {
        // Настраиваем мок-объект для генерации исключения
        when(mockFeline.getFood("Хищник")).thenThrow(new Exception("Ошибка получения пищи"));

        // Проверяем, что метод getFood выбрасывает исключение
        Exception exception = assertThrows(Exception.class, () -> {
            lion.getFood();
        });

        assertEquals("Ошибка получения пищи", exception.getMessage());
    }
}
