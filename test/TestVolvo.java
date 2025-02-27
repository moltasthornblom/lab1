import org.junit.Assert;
import org.junit.Test;

public class TestVolvo {
    @Test
    public void testGas () {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        double speed = bil.getCurrentSpeed();
        bil.gas(1);
        double speedAfterGas = bil.getCurrentSpeed();
        bil.stopEngine();
        Assert.assertTrue(speedAfterGas > speed);
    }

    @Test
    public void testBrake () {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        bil.gas(1);
        double speed = bil.getCurrentSpeed();
        bil.brake(1);
        double speedAfterBrake= bil.getCurrentSpeed();
        bil.stopEngine();
        Assert.assertTrue(speedAfterBrake < speed);
    }
}
