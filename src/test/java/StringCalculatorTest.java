import org.junit.Assert;
import org.junit.Test;
public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public  void TestAddition()
    {

        Assert.assertEquals(true,calculator.add(""));
        Assert.assertEquals(true,calculator.add("1"));
        Assert.assertEquals(true,calculator.add("1,1"));
        Assert.assertEquals(true,calculator.add("1,2,3,4"));
        Assert.assertEquals(true,calculator.add("1\n2,3"));
        Assert.assertEquals(true,calculator.add("//;\n1;2"));
        Assert.assertEquals(true,calculator.add("//4\n142"));
        Assert.assertEquals(false,calculator.add("-1,-2,-3,-4")); // Negative not allowed
        Assert.assertEquals(true,calculator.add("//;\n1000,1;2"));
        Assert.assertEquals(true,calculator.add("//***\n1***2***3"));
        Assert.assertEquals(false,calculator.add("//***\n1***2***3567676v gf")); //Invalid input

    }


}
