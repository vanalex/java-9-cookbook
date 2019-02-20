package oop.interfaceexample;

public class Main {

    public static void main(String arg[]) {
        demo1_poundsAndKg();
        demo2_kgToPounds();

        Float.compare(1.0f, 2.0f);
    }

    public static void demo1_poundsAndKg() {
        int horsePower = 246;
        Truck truck = FactoryVehicle.buildTruck(3300, 4000, horsePower);

        System.out.println("Payload in pounds: " + truck.getPayloadPounds());
        System.out.println("Payload in kg: " + truck.getPayloadKg());
    }

    public static void demo2_kgToPounds() {
        int horsePower = 246;
        int payload = Truck.convertKgToPounds(1500);
        int vehicleWeight = Truck.convertKgToPounds(1800);

        Truck truck = FactoryVehicle.buildTruck(payload, vehicleWeight, horsePower);

        System.out.println("Payload in pounds: " + truck.getPayloadPounds());
        int kg = truck.getPayloadKg();
        System.out.println("Payload converted to kg: " + kg);
        System.out.println("Payload converted back to pounds: " + Truck.convertKgToPounds(kg));

        System.out.println("Weight in pounds: " + vehicleWeight);
        kg = Truck.convertPoundsToKg(vehicleWeight);
        System.out.println("Weight converted to kg: " + kg);
        System.out.println("Weight converted back to pounds: " + Truck.convertKgToPounds(kg));
    }

}
