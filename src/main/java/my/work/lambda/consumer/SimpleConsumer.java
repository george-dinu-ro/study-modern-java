package my.work.lambda.consumer;

import java.util.function.Consumer;

public class SimpleConsumer {

    public static void consume(String info) {
        Consumer<String> consumer = System.out::println;
        consumer.accept(info);
    }

    public static void consumeAndThen(String string) {
        Consumer<String> consumer = System.out::println;
        consumer.andThen(consumer).accept(string);
    }

}
