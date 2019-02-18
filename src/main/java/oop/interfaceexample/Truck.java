package oop.interfaceexample;

public interface Truck extends Vehicle {
    int getPayloadPounds();
    default int getPayloadKg(){
        return convertPoundsToKg(getPayloadPounds());
    }

    static int convertPoundsToKg(int pounds){
        return (int) Math.round(0.454 * pounds);
    }

    static int convertKgToPounds(int kilograms){
        return (int) Math.round(2.205 * kilograms);
    }
}
