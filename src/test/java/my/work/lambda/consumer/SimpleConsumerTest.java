package my.work.lambda.consumer;

import my.work.ALogger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SimpleConsumerTest extends ALogger {

    @ParameterizedTest
    @MethodSource("getData")
    void whenCallConsume_thenCallOneConsumer(String expected) {
        SimpleConsumer.consume(expected);

        assertEquals(1, getMessagesSize());

        assertEquals(expected, getMessage(0));

        assertNotEquals(expected + System.currentTimeMillis(), getMessage(0));
    }

    @ParameterizedTest
    @MethodSource("getData")
    void whenCallConsumeAndThen_thenCallTwoConsumers(String expected) {
        SimpleConsumer.consumeAndThen(expected);

        assertEquals(2, getMessagesSize());

        assertEquals(expected, getMessage(0));

        assertEquals(expected, getMessage(1));

        assertNotEquals(expected + System.currentTimeMillis(), getMessage(0));
    }

    private static Stream<Arguments> getData() {
        return Stream.of(Arguments.of("hello"));
    }

}