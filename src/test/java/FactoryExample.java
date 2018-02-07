import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryExample {

    private int a, b, expectedResult;

    @Factory( //
            dataProviderClass = ParallelTest.class,
            dataProvider = "data"
    )
    public FactoryExample(int a, int b, int expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
    }

    @Test()
    public void testAdd() {

        int result = a + b;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(result, expectedResult);
    }
}
