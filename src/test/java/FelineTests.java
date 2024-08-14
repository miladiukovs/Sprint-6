import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FelineTests {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline() {
            @Override
            public List<String> getFood(String animalType) {
                return Arrays.asList("Мясо", "Рыба");
            }
        };

        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testEatMeatThrowsException() {
        Feline feline = new Feline() {
            @Override
            public List<String> getFood(String animalType) throws Exception {
                throw new Exception("Ошибка получения пищи");
            }
        };

        Exception exception = assertThrows(Exception.class, () -> {
            feline.eatMeat();
        });

        assertEquals("Ошибка получения пищи", exception.getMessage());
    }
}