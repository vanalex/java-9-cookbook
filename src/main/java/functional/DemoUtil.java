package functional;

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
}
