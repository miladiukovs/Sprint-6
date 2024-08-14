import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class ParametrizedLionTest {

    private final String sexTest;
    private final boolean maneTest;

    @Mock
    Feline feline;

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

    @Test
    public void sexTest() throws Exception {
        Lion lion = new Lion(sexTest, feline);
        Assert.assertEquals(maneTest, lion.doesHaveMane());
    }
}