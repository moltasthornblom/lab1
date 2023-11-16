import org.junit.Assert;
import org.junit.Test;

public class TestMechanic {

    @Test
    public void testHandleCarMechanic() {
        Mechanic<Saab95> mechanic = new Mechanic<>(2);

        Saab95 car1 = new Saab95();

        int car1Id = mechanic.handleCar(car1);

        Saab95 returnedCar = mechanic.returnCar(car1Id);

        Assert.assertTrue(car1 == returnedCar);

    }
    @Test
    public void testMaxCapacity() {
        Mechanic<Saab95> mechanic = new Mechanic<>(1);

        Saab95 car1 = new Saab95();
        Saab95 car2 = new Saab95();

        mechanic.handleCar(car1);
        mechanic.handleCar(car2);



        Assert.assertTrue(mechanic.getCarsInService().size() == 1);

    }

}
