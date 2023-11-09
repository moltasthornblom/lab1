import org.junit.Assert;
import org.junit.Test;

public class TestSaab {
    @Test
    public void testGas () {
        Saab95 bil = new Saab95();
        bil.startEngine();
        double speed = bil.getCurrentSpeed();
        bil.gas(1);
        double speedAfterGas = bil.getCurrentSpeed();
        bil.stopEngine();
        Assert.assertTrue(speedAfterGas > speed);
    }

    @Test
    public void testBrake () {
        Saab95 bil = new Saab95();
        bil.startEngine();
        bil.gas(1);
        double speed = bil.getCurrentSpeed();
        bil.brake(1);
        double speedAfterBrake= bil.getCurrentSpeed();
        bil.stopEngine();
        Assert.assertTrue(speedAfterBrake < speed);
    }

    @Test
    public void testTurbo () {
        Saab95 bil = new Saab95();
        bil.startEngine();
        double speed = bil.getCurrentSpeed();
        bil.gas(1);
        double speedAfterGas = bil.getCurrentSpeed();
        bil.setTurboOn();
        bil.gas(1);
        bil.setTurboOff();
        double speedAfterTurbo = bil.getCurrentSpeed();
        bil.stopEngine();
        Assert.assertTrue((speedAfterGas-speed)<(speedAfterTurbo-speedAfterGas));

    }
    }
