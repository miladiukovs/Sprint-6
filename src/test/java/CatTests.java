import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class CatTests {

    private Feline mockFeline; // Изменено на Feline
    private Cat cat;

    @Before
    public void setUp() {
        // Создаем мок-объект для Feline
        mockFeline = Mockito.mock(Feline.class);
        // Передаем мок в конструктор Cat
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        // Проверяем, что метод getSound возвращает "Мяу"
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsMeat() throws Exception {
        // Настраиваем мок-объект для метода eatMeat
        List<String> expectedFood = Arrays.asList("Мясо");
        when(mockFeline.eatMeat()).thenReturn(expectedFood); // Предполагаем, что eatMeat есть у Feline

        // Проверяем, что метод getFood возвращает ожидаемое значение
        assertEquals(expectedFood, cat.getFood());
    }

    @Test
    public void testGetFoodThrowsException() throws Exception {
        // Настраиваем мок-объект для генерации исключения
        when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка при получении пищи"));

        // Проверяем, что метод getFood выбрасывает исключение
        Exception exception = assertThrows(Exception.class, () -> {
            cat.getFood();
        });

        assertEquals("Ошибка при получении пищи", exception.getMessage());
    }
}


//надо написать моки на методы
//getSound
//getFood