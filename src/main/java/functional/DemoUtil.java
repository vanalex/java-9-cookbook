package functional;

import java.util.function.Consumer;
import java.util.function.Function;

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
}
