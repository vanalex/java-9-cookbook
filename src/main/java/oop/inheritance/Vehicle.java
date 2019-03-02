package oop.inheritance;

public class Vehicle {
    private int weightPounds, horsePower;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    public double getSpeedMph(double timeSec){
        double v = 2.0*this.horsePower*746;
        v = v*timeSec*32.174/weightPounds;
        return Math.round(Math.sqrt(v)*0.68);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "weightPounds=" + weightPounds +
                ", horsePower=" + horsePower +
                '}';
    }
}
