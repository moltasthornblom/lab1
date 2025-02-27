import java.awt.*;

public class Scania extends Truck{

    private double flatBedAngle = 0;

    public Scania(){
        super(2, Color.blue, 50, "Scania");
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

}
