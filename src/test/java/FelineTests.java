import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

public class FelineTests {

    @RunWith(MockitoJUnitRunner.class)
    public class EatMeatFelineTest {

        @Spy
        Feline feline;

        @Test
        public void eatMeatReturnsGetFood() throws Exception {
            feline.eatMeat();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        }
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
}