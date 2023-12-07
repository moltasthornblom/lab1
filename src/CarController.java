import java.util.ArrayList;


public class CarController {
    ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return cars;
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    public void turnRight() {
        for (Car car : cars) {
            car.turnRight();
        }
    }

    public void turnLeft() {
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(gas);
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBedButton() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(70);
            }
        }
    }
    void lowerBedButton() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(0);
            }
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

}
