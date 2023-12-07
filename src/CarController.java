import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CarController {


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : Car.cars) {
            car.gas(gas);
        }
    }

    public void turnRight() {
        for (Car car : Car.cars) {
            car.turnRight();
        }
    }

    public void turnLeft() {
        for (Car car : Car.cars) {
            car.turnLeft();
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : Car.cars) {
            car.brake(gas);
        }
    }

    void turboOn() {
        for (Car car : Car.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : Car.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBedButton() {
        for (Car car : Car.cars) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(70);
            }
        }
    }
    void lowerBedButton() {
        for (Car car : Car.cars) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(0);
            }
        }
    }

    void startEngine() {
        for (Car car : Car.cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : Car.cars) {
            car.stopEngine();
        }
    }
    void addCar() {
        new Saab95();

    }

    void removeCar() {
        Car.removeCar();
    }
}
