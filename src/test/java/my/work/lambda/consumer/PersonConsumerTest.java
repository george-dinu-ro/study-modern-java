package my.work.lambda.consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonConsumerTest {

    private OutputStream outputStream;

    @BeforeEach
    void beforeEach() {
        this.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowAllInfo_thenCallToStringMethod(List<Person> people) {
        PersonConsumer.showAllInfo(people);

        var expected = """
                Person(name=John J., age=20, phones=[*10, *11, *12])
                Person(name=Dan D., age=25, phones=[*21, *22])
                Person(name=Marry M., age=30, phones=[*31])
                Person(name=Nick N., age=27, phones=[*41, *42])
                """;

        assertEquals(clean(expected), clean(outputStream.toString()));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowInfoSeparatelyWithConsumer_thenCall2Consumers(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithConsumer(people);

        var expected = """
                John J.:20
                [*10, *11, *12]
                Dan D.:25
                [*21, *22]
                Marry M.:30
                [*31]
                Nick N.:27
                [*41, *42]
                """;

        assertEquals(clean(expected), clean(outputStream.toString()));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowInfoSeparatelyWithBiConsumer_thenCallBiConsumer(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithBiConsumer(people);

        var expected = """
                John J.:20
                [*10, *11, *12]
                Dan D.:25
                [*21, *22]
                Marry M.:30
                [*31]
                Nick N.:27
                [*41, *42]
                """;

        assertEquals(clean(expected), clean(outputStream.toString()));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowInfoSeparatelyWithAgeFilter_thenCall2ConsumersWithAgeFilter(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithAgeFilter(people, 27);

        var expected = """
                Marry M.:30
                [*31]
                Nick N.:27
                [*41, *42]
                """;

        assertEquals(clean(expected), clean(outputStream.toString()));
    }

    private static String clean(String str) {
        return str.strip().replace("\r\n", "\n");
    }

    private static Stream<Arguments> getPeople() {
        return Stream.of(
                Arguments.of(
                        List.of(Person.builder()
                                        .name("John J.")
                                        .age(20)
                                        .phones(List.of("*10", "*11", "*12"))
                                        .build(),
                                Person.builder()
                                        .name("Dan D.")
                                        .age(25)
                                        .phones(List.of("*21", "*22"))
                                        .build(),
                                Person.builder()
                                        .name("Marry M.")
                                        .age(30)
                                        .phones(List.of("*31"))
                                        .build(),
                                Person.builder()
                                        .name("Nick N.")
                                        .age(27)
                                        .phones(List.of("*41", "*42"))
                                        .build())));
    }

}