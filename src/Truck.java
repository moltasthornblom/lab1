//Trucks are big not to be loaded on Car Transport.
import java.awt.*;

public abstract class Truck extends Car{


    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    protected double speedFactor(){
        return enginePower * 0.01;
    }

}
