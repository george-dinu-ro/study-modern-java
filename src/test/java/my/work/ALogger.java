package my.work;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import my.work.lambda.consumer.SimpleConsumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;

public abstract class ALogger {

    private ListAppender<ILoggingEvent> appender;

    private Logger logger;

    @BeforeEach
    void setUp() {
        this.appender = new ListAppender<>();
        this.appender.start();

        this.logger = (Logger) LoggerFactory.getLogger(SimpleConsumer.class);
        this.logger.addAppender(this.appender);
    }

    @AfterEach
    void tearDown() {
        this.logger.detachAppender(this.appender);
    }

    protected int getMessagesSize() {
        return this.appender.list.size();
    }

    protected String getMessage(int index) {
        return this.appender.list.get(index).getFormattedMessage();
    }

}
