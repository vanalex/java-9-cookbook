package functional;

import java.util.function.Consumer;
import java.util.function.Function;

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

        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String s) {
                System.out.println("\nThe " + s + " is consumed.");
            }
        };

        consumer.accept("Hello!");

    }
}
