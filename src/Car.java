import java.awt.*;

public abstract class Car implements Movable{

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car

    protected double currentSpeed; // The current speed of the car

    protected Color color; // Color of the car

    protected String modelName; // The car model name

    protected double direction = 0;

    private double positionX = 0;
    private double positionY = 0;
    private final double tenDegreesInRadians = (2 * Math.PI)/(36);
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

    public void turnAround() {
        direction += Math.PI;
    }

    public void turnLeft() {
        direction -= tenDegreesInRadians;

    }
    public void turnRight() {
        direction += tenDegreesInRadians;

    }

    protected double getDirection() {
        return direction;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public String getModelName() {
        return modelName;
    }

    protected void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    protected void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    protected abstract double speedFactor();
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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

    public void gas(double amount) {
        if (amount <= 1 && amount >= 0 ){
            incrementSpeed(amount);
        }
        else {
            System.out.print("Gas amount not within range [0,1]");
        }

    }

    public void brake(double amount){
        if (amount <= 1 && amount >= 0 ){
            decrementSpeed(amount);
        }
        else {
            System.out.print("Brake amount not within range [0,1]");
        }
    }

}
