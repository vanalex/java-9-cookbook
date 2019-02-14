package oop.innerclasses;

public class Main {

    public static void main(String... args) {
        double timeSec = 10.0;
        int engineHorsePower = 246;
        int vehicleWeightPounds = 4000;

        Vehicle vehicle = Vehicle.buildVehicle(vehicleWeightPounds, engineHorsePower);
        System.out.println("Vehicle speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");

        Vehicle1 vehicle1 = Vehicle1.buildVehicle(vehicleWeightPounds, engineHorsePower);
        System.out.println("Vehicle speed (" + timeSec + " sec) = " + vehicle1.getSpeedMph(timeSec) + " mph");

        Vehicle2 vehicle2 = new Vehicle2(vehicleWeightPounds, engineHorsePower);
        System.out.println("Vehicle speed (" + timeSec + " sec) = " + vehicle2.getSpeedMph(timeSec) + " mph");

        printTheSpeed(timeSec, vehicle);

        VehicleInterface vehicleObject = new VehicleInterface(){
            public double getSpeedMph(double timeSec){
                return -1.0d;
            }
        };
        printTheSpeed(timeSec, vehicleObject);

        printTheSpeed(timeSec, x -> 11.0 );
    }

    public static void printTheSpeed(double timeSec, Vehicle vehicle){
        System.out.println("Vehicle speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");
    }

    public static void printTheSpeed(double timeSec, VehicleInterface vehicle){
        System.out.println("Vehicle speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");
    }

    public interface VehicleInterface {
        public double getSpeedMph(double timeSec);
    }
}
