import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class ParametrizedLionTest {

    private final String sexTest;
    private final boolean maneTest;
    private Feline mockFeline;

    public ParametrizedLionTest(String sexTest, boolean maneTest) {
        this.sexTest = sexTest;
        this.maneTest = maneTest;
    }

    @Parameterized.Parameters
    public static Object[][] lionParams() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        mockFeline = Mockito.mock(Feline.class);
    }

    @Mock
    Feline feline;


    @Test
    public void sexTest() throws Exception {
        Lion lion = new Lion(sexTest, mockFeline); // Передаем мок в конструктор
        Assert.assertEquals(maneTest, lion.doesHaveMane());
    }
}