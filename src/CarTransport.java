import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck{
    private boolean flatBedDown = false;
    private final double distanceMult = 2; //Distance form Truck to unload car
    private final int maxCapacity = 8;
    private final ArrayList<PassengerCar> loadedCars = new ArrayList<>();

    public CarTransport() {
            super(2, Color.blue, 200, "CarTransport");
    }

    @Override
    public void gas(double amount) {
        if(!flatBedDown) {
            super.gas(amount);
        }
    }

    public void setFlatBedDown() {
        if(currentSpeed == 0)
            flatBedDown = true;
    }
    public void setFlatBedUp() {
        if(currentSpeed == 0)
            flatBedDown = false;
    }

    @Override
    public void move() {
        super.move();
        for(PassengerCar car : loadedCars) {
            car.setPositionX(this.getPositionX());
            car.setPositionY(this.getPositionY());
        }
    }
    public void loadCar(PassengerCar car) {
        //Check if car close
        if(flatBedDown) {
            double carX = car.getPositionX();
            double carY = car.getPositionY();

            if(Math.abs(carX - this.getPositionX()) < 5 && Math.abs(carY - this.getPositionY()) < 5) {
                if(loadedCars.size() <= maxCapacity) {
                    car.setPositionX(this.getPositionX());
                    car.setPositionY(this.getPositionY());
                    loadedCars.add(car);
                }
            }
        }
    }
    public void unloadCar() {
        //Check ramp down
        if(flatBedDown) {
            int lastCarIndex = loadedCars.size() - 1;
            PassengerCar carToBeUnloaded = loadedCars.get(lastCarIndex);
            loadedCars.remove(lastCarIndex);

            //Calculate position of unloaded car
            double posX = this.getPositionX();
            double posY = this.getPositionY();
            double direction = this.getDirection();
            double newX = posX - (Math.cos(direction)*distanceMult);
            double newY = posY - (Math.sin(direction)*distanceMult);
            carToBeUnloaded.setPositionX(newX);
            carToBeUnloaded.setPositionY(newY);

        }
    }

    public ArrayList<PassengerCar> getLoadedCars() {
        return loadedCars;
    }
}
