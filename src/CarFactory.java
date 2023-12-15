import java.util.ArrayList;

public class CarFactory {

    private static final ArrayList<Car> cars = new ArrayList<>();

    public static ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public static void removeCar() {
        if(!cars.isEmpty()) {
            cars.get(0).destruct();
            cars.remove(0);
        }
    }

    public static int getNrCars() {
        return cars.size();
    }

    public static Car createSaab95() {
        Saab95 saab = new Saab95();
        cars.add(saab);
        return saab;
    }
    public static Car createVolvo240() {
        Volvo240 volvo = new Volvo240();
        cars.add(volvo);
        return volvo;
    }
    public static Car createCarTransport() {
        CarTransport carTransport = new CarTransport();
        cars.add(carTransport);
        return carTransport;
    }
}
