import java.util.HashMap;
import java.util.Map;

public class Mechanic<T extends Car> {

    private final Map<Integer, T> carsInService = new HashMap<>();

    private int customerId = 0;
    private final int maxCapacity;
    public Mechanic(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public int handleCar(T car) {
        // If returned ID is -1, no car was handled
        if (carsInService.size() < maxCapacity) {
            customerId+=1;
            carsInService.put(customerId, car);
            return customerId;
        }
        return -1;
    }
    public T returnCar(int customerId) {
        T carToBeReturned = carsInService.get(customerId);
        carsInService.remove(customerId);
        return carToBeReturned;
    }

    public Map<Integer, T> getCarsInService() {
        return carsInService;
    }
}
