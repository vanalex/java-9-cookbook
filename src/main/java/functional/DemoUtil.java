package functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoUtil {

    public static Function<Integer, Double> createMultiplyBy(double num){
        Function<Integer, Double> ourFunc = new Function<Integer, Double>(){
            public Double apply(Integer i){
                return i * num;
            }
        };
        return ourFunc;
    }

    public static Function<Double, Double> createSubtract(double num){
        Function<Double, Double> ourFunc = new Function<Double, Double>(){
            public Double apply(Double dbl){
                return dbl - num;
            }
        };
        return ourFunc;
    }

    public static Consumer<String> createTalker(String value){
        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s + value);
            }
        };
        return consumer;
    }

    public static Supplier<String> createResultSupplier(){
        Supplier<String> supplier = new Supplier<String>() {
            public String get() {
                String res = "Success";
                //Do something and return result – Success or Error.
                return res;
            }
        };
        return supplier;
    }

    public static Predicate<Double> createIsSmallerThan(double limit){
        Predicate<Double> pred = new Predicate<Double>() {
            public boolean test(Double num) {
                System.out.println("Test if " + num + " is smaller than " + limit);
                return num < limit;
            }
        };
        return pred;
    }

    public static Predicate<Double> createIsBiggerThan(double limit){
        Predicate<Double> pred = new Predicate<Double>() {
            public boolean test(Double num) {
                System.out.println("Test if " + num + " is bigger than " + limit);
                return num > limit;
            }
        };
        return pred;
    }
    public static Supplier<String> applyCompareAndSay(int i, Function<Integer, Double> func, Predicate<Double> isSmaller){
        Supplier<String> supplier = new Supplier<String>() {
            public String get() {
                double v = func.apply(i);
                return isSmaller.test(v)? v + " is smaller" : v + " is bigger";
            }
        };
        return supplier;
    }

    public static Supplier<String> applyCompareAndSay(int i, Function<Integer, Double> func, Predicate<Double> compare, String message){
        Supplier<String> supplier = new Supplier<String>() {
            public String get() {
                double v = func.apply(i);
                return (compare.test(v)? v + " is " : v + " is not ") + message;
            }
        };
        return supplier;
    }
}
