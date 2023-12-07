import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game {
    private final int delay = 1;
    CarView frame;
    CarController CarC;
    private Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Car> cars = CarC.getCars();
            for (Car car : cars) {
                car.move();
                // repaint() calls the paintComponent method of the panel
            }
            frame.drawPanel.draw(cars);

        }
    }

    public Game() {
        CarC = new CarController();
        Saab95 saab = new Saab95();
        CarTransport carTransport = new CarTransport();
        carTransport.setPositionY(40);
        saab.setPositionY(20);
        CarC.cars.add(new Volvo240());
        CarC.cars.add(saab);
        CarC.cars.add(carTransport);
        frame = new CarView("CarSim 1.0", CarC);
        timer.start();
    }
    public static void main(String[] args) {
        new Game();

    }
}
