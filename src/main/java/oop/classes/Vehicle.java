package oop.classes;

public class Vehicle {
    private int weightPounds;
    private Engine engine;

    private Vehicle() {
    }

    public Vehicle(int weightPounds, Engine engine) {
        this.weightPounds = weightPounds;
        if(engine == null){
            throw new RuntimeException("Engine value is not set.");
        }
        this.engine = engine;
    }

    public int getWeightPounds() {
        return weightPounds;
    }

    public Engine getEngine() { return engine; }

    protected double getSpeedMph(double timeSec){
        double v = 2.0 * this.engine.getHorsePower()*746;
        v = v * timeSec * 32.174 / this.weightPounds;
        return  Math.round(Math.sqrt(v)*0.68);
    }

    public static Builder builder() {
        return new Vehicle.Builder();
    }

    public static class Builder {
        private final Vehicle instance = new Vehicle();

        private Builder() {
        }

        public Builder weightPounds(int weightPounds) {
            instance.weightPounds = weightPounds;
            return this;
        }

        public Builder Engine(Engine engine) {
            instance.engine = engine;
            return this;
        }


        public Vehicle build() {
            return instance;
        }
    }

}
