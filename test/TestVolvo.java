import org.junit.Assert;
import org.junit.Test;

public class TestVolvo {
    @Test
    public void testGas () {
        Volvo240 bil = new Volvo240();
        double speed = bil.getCurrentSpeed();
        bil.gas(1);
        double speedAfterGas = bil.getCurrentSpeed();
        Assert.assertTrue(speedAfterGas > speed);
    }
}
