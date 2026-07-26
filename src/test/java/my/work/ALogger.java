package my.work;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;

public abstract class ALogger {

    private ListAppender<ILoggingEvent> appender;

    private Logger logger;

    protected abstract Class<?> getLoggedClass();

    @BeforeEach
    void setUp() {
        this.appender = new ListAppender<>();
        this.appender.start();

        this.logger = (Logger) LoggerFactory.getLogger(getLoggedClass());
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
