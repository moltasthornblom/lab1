import org.junit.Assert;
import org.junit.Test;

public class TestScania {
    @Test
    public void testGas() {
        Scania bil = new Scania();
        bil.gas(1);
        double speed = bil.getCurrentSpeed();
        Assert.assertTrue(speed > 0);
    }
    @Test
    public void testGasWithFlatBedUp() {
        Scania bil = new Scania();
        bil.alterFlatBedAngle(10);
        bil.gas(1);
        double speed = bil.getCurrentSpeed();
        Assert.assertTrue(speed == 0);
    }
    @Test
    public void testAlterFlatBedAngle() {
        Scania bil = new Scania();
        bil.alterFlatBedAngle(20);
        double angle = bil.getFlatBedAngle();
        Assert.assertTrue(angle == 20 );
    }
    @Test
    public void testAlterFlatBedAngleBad() {
        Scania bil = new Scania();
        bil.alterFlatBedAngle(200);
        double angle = bil.getFlatBedAngle();
        Assert.assertTrue(angle == 0 );
    }
}
