package functional;

import java.util.function.*;

public class DemoFunctional {

    public static void main(String...args){
        demo1();
    }

    public static void demo1(){
        Function<Integer, Double> ourFunction = new Function<Integer, Double>() {
            public Double apply(Integer i) {
                return i * 10.0;
            }
        };

        System.out.print(ourFunction.apply(2));

        Function<Vehicle, Double> anotherFunction = new Function<Vehicle, Double>() {
            public Double apply(Vehicle vehicle) {
                double timesecs = 2.0;
                return vehicle.getSpeedMph(timesecs);
            }
        };

        System.out.print("\nSpeed --> " + anotherFunction.apply(Vehicle.buildVehicle(3, 4)));

        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String s) {
                System.out.println("\nThe " + s + " is consumed.");
            }
        };

        consumer.accept("Hello!");

        Supplier<String> supplier = new Supplier<String>() {
            public String get() {
                return "Success";
            }
        };

        System.out.println(supplier.get());

        Predicate<Double> pred = new Predicate<Double>() {
            public boolean test(Double num) {
                System.out.println("Test if " + num + " is smaller than 20");
                return num < 20;
            }
        };

        System.out.println(pred.test(10.0) ? "10 is smaller": "10 is bigger");

        IntFunction<String> ifunction = new IntFunction<String>() {
            public String apply(int value) {
                return String.valueOf(value *10);
            }
        };

        System.out.println(ifunction.apply(2));

        BiFunction<String, Integer, Double> bifunc =
                new BiFunction<String, Integer, Double >() {
                    public Double apply(String s, Integer i) {
                        return (s.length() * 10d)/i;
                    }
                };
        System.out.println(bifunc.andThen(x->11d).apply("1",2));

        BinaryOperator<Integer> binfunc = new BinaryOperator<Integer>(){
            public Integer apply(Integer i, Integer j) {
                return i >= j ? i : j;
            }
        };
        System.out.println(binfunc.apply(1,2));
    }
}
