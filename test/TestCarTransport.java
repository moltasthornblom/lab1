import org.junit.*;

public class TestCarTransport {

    @Test
    public void testLoadCar() {

        CarTransport transport = new CarTransport();

        PassengerCar car = new Volvo240();
        transport.setFlatBedDown();
        transport.loadCar(car);

        Assert.assertTrue(transport.getLoadedCars().get(0) == car);
    }

    @Test
    public void testLoadCarFarAway() {
        CarTransport transport = new CarTransport();

        PassengerCar car = new Volvo240();

        car.setPositionX(10);
        car.setPositionY(1);

        transport.setFlatBedDown();
        transport.loadCar(car);
        transport.setFlatBedUp();

        Assert.assertTrue(transport.getLoadedCars().isEmpty());
    }

    @Test
    public void testCarPositionLoaded() {
        CarTransport transport = new CarTransport();

        PassengerCar car = new Volvo240();

        double carPosX = car.getPositionX();
        double carPosY = car.getPositionY();

        transport.setFlatBedDown();
        transport.loadCar(car);
        transport.setFlatBedUp();

        transport.startEngine();
        transport.gas(1);
        transport.turnLeft();
        transport.move();

        Assert.assertTrue(car.getPositionX() != carPosX && car.getPositionY() != carPosY);
    }

    @Test
    public void unloadCarBehind() {
        CarTransport transport = new CarTransport();

        PassengerCar car = new Volvo240();

        transport.setFlatBedDown();
        transport.loadCar(car);
        transport.setFlatBedUp();

        transport.startEngine();
        transport.gas(1);
        transport.turnRight();
        transport.move();

        transport.brake(1);
        transport.brake(1);
        transport.setFlatBedDown();
        transport.unloadCar();

        double carPosX = car.getPositionX();
        double carPosY = car.getPositionY();

//        System.out.println(transport.getPositionX());
//        System.out.println(transport.getPositionY());
//        System.out.println(carPosX);
//        System.out.println(carPosY);

        Assert.assertTrue(transport.getPositionX() > carPosX && transport.getPositionY() < carPosY);
    }

}