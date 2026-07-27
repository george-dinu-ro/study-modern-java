package my.work.lambda.consumer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class SimpleConsumer {

    private static final Consumer<String> CONSUMER = log::info;

    public static void consume(String info) {
        CONSUMER.accept(info);
    }

    public static void consumeAndThen(String string) {
        CONSUMER.andThen(CONSUMER).accept(string);
    }

}
