
public class CarController {



    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : Car.getCars()) {
            car.gas(gas);
        }
    }

    public void turnRight() {
        for (Car car : Car.getCars()) {
            car.turnRight();
        }
    }

    public void turnLeft() {
        for (Car car : Car.getCars()) {
            car.turnLeft();
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : Car.getCars()) {
            car.brake(gas);
        }
    }

    void turboOn() {
        for (Car car : Car.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : Car.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBedButton() {
        for (Car car : Car.getCars()) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(70);
            }
        }
    }

    void lowerBedButton() {
        for (Car car : Car.getCars()) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(0);
            }
        }
    }

    void startEngine() {
        for (Car car : Car.getCars()) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : Car.getCars()) {
            car.stopEngine();
        }
    }

    void addCar() {
        if (Car.getCars().size() < 10) {
            CarFactory.createSaab95();
        }
    }

    void removeCar() {
        Car.removeCar();
    }
}
