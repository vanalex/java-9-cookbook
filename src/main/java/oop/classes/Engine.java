package oop.classes;

public class Engine {
    private int horsePower;

    private Engine(){

    }

    public Engine(int horsePower){
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public static Engine.Builder builder() {
        return new Engine.Builder();
    }

    public static class Builder {
        private final Engine instance = new Engine();

        private Builder() {
        }

        public Engine.Builder horsePower(int horsePower) {
            instance.horsePower = horsePower;
            return this;
        }

        public Engine build() {
            return instance;
        }
    }

}
