package oop.inheritance;

public class Car extends Vehicle {
    private int passengersCount;

    public Car(int passengersCount, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.passengersCount = passengersCount;
    }
    public int getPassengersCount() {
        return this.passengersCount;
    }
}
