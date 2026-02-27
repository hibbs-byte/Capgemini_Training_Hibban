import java.util.function.Consumer;

public class Consumerexample {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Consumer Innerclass");
        Consumer<Integer> consumer1 = number -> {
            System.out.println(number);
        };
        consumer1.accept(20);
    }
}

