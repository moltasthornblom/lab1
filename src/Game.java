import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game {
    private final int delay = 1;

    private final int X = 800;
    private final int Y = 800;
    CarView frame;
    CarController CarC;
    private Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : Car.cars) {
                car.move();
            }

        }
    }

    public Game() {
        CarC = new CarController();
        DrawPanel drawPanel =  new DrawPanel(X, Y-240);
        frame = new CarView("CarSim 1.0", CarC, drawPanel, X, Y);
        Car.addObserver(drawPanel);
        new Saab95();
        Volvo240 volvo = new Volvo240();
        volvo.setPositionY(40);

        timer.start();
    }
    public static void main(String[] args) {
        new Game();

    }
}
