import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ParallelTest {


    @DataProvider(parallel = true)
    public static Object[][] data() {
        return new Object[][]{

                {4, 5, 9},
                {4, 10, 14},
                {40, 50, 90},
                {4, -5, -10},
                {-4, 5, 1},
                {4, -5, -1}
        };
    }


    @Test(dataProvider = "data")
    public void testAdd(int a, int b, int expectedResult) {

        int result = a + b;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(result, expectedResult);
    }
}
