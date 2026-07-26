package my.work.lambda.consumer;

import my.work.lambda.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SimpleConsumerTest {

    private OutputStream outputStream;

    @BeforeEach
    void beforeEach() {
        this.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void whenCallConsume_thenCallOneConsumer() {
        var expected = "hello";
        var unExpected = "bye";

        SimpleConsumer.consume(expected);

        var actual = StringUtil.cleanAndGet(outputStream.toString());

        assertEquals(expected, actual);
        assertNotEquals(unExpected, actual);
    }

    @Test
    void whenCallConsumeAndThen_thenCallTwoConsumers() {
        var input = "hello";
        var expected = """
                hello
                hello
                """;
        var unExpected = "bye";

        SimpleConsumer.consumeAndThen(input);

        var actual = StringUtil.cleanAndGet(outputStream.toString());

        assertEquals(StringUtil.cleanAndGet(expected), actual);
        assertNotEquals(unExpected, actual);
    }

}