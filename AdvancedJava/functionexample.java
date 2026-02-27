import java.util.function.Function;

public class Functionexample {
    public static void main(String[] args) {
        // Anonymous class implementation
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        System.out.println(function.apply(12)); // prints 144

        // Lambda implementation
        Function<Integer, Integer> function1 = number -> number * number;
        System.out.println(function1.apply(11)); // prints 121
    }
}
