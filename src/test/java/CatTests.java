import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CatTests {

    private Predator mockPredator;
    private Cat cat;

    @BeforeEach
    public void setUp() {
        // Создаем мок-объект для Predator
        mockPredator = Mockito.mock(Predator.class);
        // Передаем мок в конструктор Cat
        cat = new Cat((Feline) mockPredator);
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
        when(mockPredator.eatMeat()).thenReturn(expectedFood);

        // Проверяем, что метод getFood возвращает ожидаемое значение
        assertEquals(expectedFood, cat.getFood());
    }

    @Test
    public void testGetFoodThrowsException() throws Exception {
        // Настраиваем мок-объект для генерации исключения
        when(mockPredator.eatMeat()).thenThrow(new Exception("Ошибка при получении пищи"));

        // Проверяем, что метод getFood выбрасывает исключение
        Exception exception = assertThrows(Exception.class, () -> {
            cat.getFood();
        });

        assertEquals("Ошибка при получении пищи", exception.getMessage());
    }
}