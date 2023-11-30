import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 1;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public ArrayList<Car> getCars() {
        return cars;
    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Saab95 saab = new Saab95();
        CarTransport carTransport = new CarTransport();
        carTransport.setPositionY(40);
        saab.setPositionY(20);
        cc.cars.add(new Volvo240());
        cc.cars.add(saab);
        cc.cars.add(carTransport);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    // Calls the gas method for each car once
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
