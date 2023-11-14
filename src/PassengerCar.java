//PassengerCar Class assumes all subclasses are cars of reasonable size to load on a CarTransport
import java.awt.*;

public abstract class PassengerCar extends Car{
    public PassengerCar(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}
