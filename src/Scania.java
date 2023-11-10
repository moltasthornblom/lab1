import java.awt.*;

public class Scania extends Car{

    private final static double loadFactor = 0.2;

    private double flatBedAngle = 0;

    public Scania(){
        super(2, Color.blue, 200, "Scania");
    }

    public void alterFlatBedAngle(double angle) {

        double newFlatBedAngle = flatBedAngle + angle;
        if((newFlatBedAngle <= 70) && (newFlatBedAngle >= 0) && (getCurrentSpeed() == 0)) {
            flatBedAngle = newFlatBedAngle;
        }
    }

    @Override
    public void gas(double amount) {
        if(flatBedAngle == 0) {
            super.gas(amount);
        }
    }
    public double getFlatBedAngle() {
        return flatBedAngle;
    }

    protected double speedFactor(){
        return enginePower * 0.01 * loadFactor;
    }

}
