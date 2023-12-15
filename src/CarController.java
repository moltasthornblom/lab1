import javax.swing.*;
import java.awt.event.ActionEvent;

public class CarController {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String GAS = "gas";
    private static final String BRAKE = "brake";
    private static final String MOVE_LEFT = "move left";
    private static final String MOVE_RIGHT = "move right";
    static JLabel obj1 = new JLabel();

    int gasAmount = 1;

    CarView frame;

    public CarController(CarView frame) {
        this.frame = frame;
        initArrowControls();
        initButtonListeners();
    }

    // Code for moving the cars with arrows
    private void initArrowControls() {
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), GAS);
        obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), BRAKE);
        obj1.getActionMap().put(MOVE_LEFT, new MoveAction(MOVE_LEFT));
        obj1.getActionMap().put(MOVE_RIGHT, new MoveAction(MOVE_RIGHT));
        obj1.getActionMap().put(GAS, new MoveAction(GAS));
        obj1.getActionMap().put( BRAKE, new MoveAction(BRAKE));
        frame.add(obj1);
    }

    private void initButtonListeners() {
        frame.addGasSpinnerChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());
        frame.addGasButtonActionListener(e -> gas(gasAmount));
        frame.addBrakeButtonActionListener(e -> brake(gasAmount));
        frame.addTurnLeftButtonActionListener(e -> turnLeft());
        frame.addTurnRightButtonActionListener(e -> turnRight());
        frame.addTurboOffButtonActionListener(e -> turboOff());
        frame.addTurboOnButtonActionListener(e -> turboOn());
        frame.addLowerBedButtonActionListener(e -> lowerBed());
        frame.addLiftBedButtonActionListener(e -> liftBed());
        frame.addStartButtonActionListener(e -> startEngine());
        frame.addStopButtonActionListener(e -> stopEngine());
        frame.addAddCarButtonActionListener(e -> addCar());
        frame.addRemoveCarButtonActionListener(e -> removeCar());
    }

    // Class for moving the cars with arrows
    private class MoveAction extends AbstractAction {
        String action;

        public MoveAction(String action) {
            this.action = action;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (action) {
                case MOVE_RIGHT -> turnRight();
                case MOVE_LEFT -> turnLeft();
                case GAS -> gas(gasAmount);
                case BRAKE -> brake(gasAmount);
            }
            // Player can be detected by e.getSource() instead and call its own move method.
        }
    }


//    frame.gasButton.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            carC.gas(gasAmount);
//        }
//    });)

    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : CarFactory.getCars()) {
            car.gas(gas);
        }
    }

    public void turnRight() {
        for (Car car : CarFactory.getCars()) {
            car.turnRight();
        }
    }

    public void turnLeft() {
        for (Car car : CarFactory.getCars()) {
            car.turnLeft();
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : CarFactory.getCars()) {
            car.brake(gas);
        }
    }

    void turboOn() {
        for (Car car : CarFactory.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : CarFactory.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car car : CarFactory.getCars()) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(70);
            }
        }
    }

    void lowerBed() {
        for (Car car : CarFactory.getCars()) {
            if (car instanceof Scania) {
                ((Scania) car).alterFlatBedAngle(0);
            }
        }
    }

    void startEngine() {
        for (Car car : CarFactory.getCars()) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : CarFactory.getCars()) {
            car.stopEngine();
        }
    }

    void addCar() {
        if (CarFactory.getNrCars() < 10) {
            CarFactory.createSaab95();
        }
    }

    void removeCar() {
        CarFactory.removeCar();
    }
}
