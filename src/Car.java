import java.awt.*;
import java.util.ArrayList;

public abstract class Car implements Movable{

    protected int nrDoors; // Number of doors on the car

    protected double enginePower; // Engine power of the car

    protected double currentSpeed; // The current speed of the car

    protected Color color; // Color of the car

    protected String modelName; // The car model name

    protected double direction = 0;

    protected double positionX = 0;
    protected double positionY = 0;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public void move() {
        positionX += currentSpeed * Math.cos(direction);
        positionY += currentSpeed * Math.sin(direction);
    }

    public void turnLeft() {
        direction += 10;

    }
    public void turnRight() {
        direction -= 10;

    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }



}
