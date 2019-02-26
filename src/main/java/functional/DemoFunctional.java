package functional;

import java.util.function.*;
import static functional.DemoUtil.createMultiplyBy;
import static functional.DemoUtil.applyCompareAndSay;
import static functional.DemoUtil.createIsBiggerThan;
import static functional.DemoUtil.createIsSmallerThan;
import static functional.DemoUtil.createResultSupplier;
import static functional.DemoUtil.createTalker;

public class DemoFunctional {

    public static void main(String...args){
        demo1();
        demo2();
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

    public static void demo2() {
        Function<Integer, Double> multiplyBy10 = createMultiplyBy(10d);
        System.out.println(multiplyBy10.apply(1));

        Function<Integer, Double> multiplyBy30 = createMultiplyBy(30d);
        System.out.println(multiplyBy30.apply(1));

        Function<Double, Double> subtract7 = DemoUtil.createSubtract(7.0);
        System.out.println(subtract7.apply(10.0));
        System.out.println(subtract7.apply(7.0));

        Consumer<String> sayHappyToSee = createTalker("Happy to see you again!");
        sayHappyToSee.accept("Hello!");

        Supplier<String> successOrFailure = createResultSupplier();
        System.out.println(successOrFailure.get());

        Predicate<Double> isSmallerThan20 = createIsSmallerThan(20d);
        System.out.println(isSmallerThan20.test(10d));

        Predicate<Double> isBiggerThan18 = createIsBiggerThan(18d);
        System.out.println(isBiggerThan18.test(10d));

        //We can pass the created functions as parameters:
        Supplier<String> compare1By10And20 = applyCompareAndSay(1, multiplyBy10, isSmallerThan20);
        System.out.println(compare1By10And20.get());

        Supplier<String> compare1By30And20 = applyCompareAndSay(1, multiplyBy30, isSmallerThan20, "bigger");
        System.out.println(compare1By30And20.get());

    }
}
