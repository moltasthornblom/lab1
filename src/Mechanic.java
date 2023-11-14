import java.util.HashMap;
import java.util.Map;

public class Mechanic<T> {

    private final Map<Integer, T> carsInService = new HashMap<>();

    private int customerId = 0;
    private int maxCapacity;
    public Mechanic(int maxCapacity) {

    }
    public int handleCar(T car) {
        customerId+=1;
        carsInService.put(customerId, car);
        return customerId;
    }
    public T returnCar(int customerId) {
        T carToBeReturned = carsInService.get(customerId);
        carsInService.remove(customerId);
        return carToBeReturned;
    }
}
