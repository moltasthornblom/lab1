import org.junit.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCar {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void Before() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testMove() {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        double posX = bil.getPositionX();
        bil.gas(1);
        bil.move();
        double posXAfterMove = bil.getPositionX();
        bil.stopEngine();
        Assert.assertTrue(posX < posXAfterMove);
    }
    @Test
    public void testTurnLeft() {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        double posX = bil.getPositionX();
        double posY = bil.getPositionY();
        bil.gas(1);
        bil.turnLeft();
        bil.move();
        double posXAfterTurn = bil.getPositionX();
        double posYAfterTurn = bil.getPositionY();
        bil.stopEngine();

        Assert.assertTrue((posXAfterTurn > posX) && (posYAfterTurn < posY));

    }
    @Test
    public void testTurnRight() {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        double posX = bil.getPositionX();
        double posY = bil.getPositionY();
        bil.gas(1);
        bil.turnRight();
        bil.move();
        double posXAfterTurn = bil.getPositionX();
        double posYAfterTurn = bil.getPositionY();
        bil.stopEngine();
        Assert.assertTrue((posXAfterTurn > posX) && (posYAfterTurn > posY));

    }
    @Test
    public void testGetNrDoors() {
        Volvo240 bil = new Volvo240();
        int nrDoors = bil.getNrDoors();
        Assert.assertEquals(nrDoors, 4);

    }
    @Test
    public void testGetEnginePower() {
        Volvo240 bil = new Volvo240();
        double enginePower = bil.getEnginePower();
        Assert.assertTrue(enginePower == 100.0);
    }
    @Test
    public void testGetColor() {
        Volvo240 bil = new Volvo240();
        Color color = bil.getColor();
        Assert.assertTrue(color.equals(Color.black));
    }
    @Test
    public void testSetColor() {
        Volvo240 bil = new Volvo240();
        bil.setColor(Color.red);
        Color color = bil.getColor();
        Assert.assertTrue(color.equals(Color.red));
    }

    @Test
    public void testTriggerBadRangeGas() {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        bil.gas(100);
        bil.stopEngine();
        Assert.assertEquals("Gas amount not within range [0,1]", outContent.toString());
    }
    @Test
    public void testTriggerBadRangeBrake() {
        Volvo240 bil = new Volvo240();
        bil.startEngine();
        bil.brake(100);
        bil.stopEngine();
        Assert.assertEquals("Brake amount not within range [0,1]", outContent.toString());
    }

    @After
    public void After() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}