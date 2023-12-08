import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    CarView frame;
    CarController CarC;
    DrawPanel drawPanel;

    private final int delay = 1;
    private final Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : Car.getCars()) {
                car.move();
            }
        }
    }

    public Game(String title, int width, int height) {
        CarC = new CarController();
        drawPanel =  new DrawPanel(width, height-240);
        frame = new CarView(title, CarC, drawPanel, width, height);

        Car.addObserver(drawPanel);

        CarFactory.createSaab95();
        Car volvo = CarFactory.createVolvo240();
        Car carTransport = CarFactory.createCarTransport();
        volvo.setPositionY(40);
        carTransport.setPositionY(60);

        timer.start();
    }
    public static void main(String[] args) {
        new Game("CarSim 1.0", 800, 800);
    }
}
