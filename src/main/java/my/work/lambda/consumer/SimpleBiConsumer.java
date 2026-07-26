package my.work.lambda.consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class SimpleBiConsumer {

    private static final BiConsumer<String, Integer> BI_CONSUMER = (a, b) -> log.info("{}:{}", a, b);

    public static void consume(String string, Integer integer) {
        BI_CONSUMER.accept(string, integer);
    }

    public static void consumeAndThen(String string, Integer integer) {
        BI_CONSUMER.andThen(BI_CONSUMER).accept(string, integer);
    }

}
