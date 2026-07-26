package my.work.lambda.consumer;

import my.work.ALogger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonConsumerTest extends ALogger {

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowAllInfo_thenCallToStringMethod(List<Person> people) {
        PersonConsumer.showAllInfo(people);

        var expected = List.of(
                "Person(name=John J., age=20, phones=[*10, *11, *12])",
                "Person(name=Dan D., age=25, phones=[*21, *22])",
                "Person(name=Marry M., age=30, phones=[*31])",
                "Person(name=Nick N., age=27, phones=[*41, *42])"
        );

        assertEquals(4, getMessagesSize());

        assertEquals(expected.getFirst(), getMessage(0));

        assertEquals(expected.get(1), getMessage(1));

        assertEquals(expected.get(2), getMessage(2));

        assertEquals(expected.getLast(), getMessage(3));

        assertNotEquals(expected.getFirst() + System.currentTimeMillis(), getMessage(0));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowInfoSeparatelyWithConsumer_thenCall2Consumers(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithConsumer(people);

        var expected = List.of(
                "John J.:20",
                "*10, *11, *12",
                "Dan D.:25",
                "*21, *22",
                "Marry M.:30",
                "*31",
                "Nick N.:27",
                "*41, *42"
        );

        assertEquals(8, getMessagesSize());

        assertEquals(expected.getFirst(), getMessage(0));

        assertEquals(expected.get(1), getMessage(1));

        assertEquals(expected.get(2), getMessage(2));

        assertEquals(expected.get(3), getMessage(3));

        assertEquals(expected.get(4), getMessage(4));

        assertEquals(expected.get(5), getMessage(5));

        assertEquals(expected.get(6), getMessage(6));

        assertEquals(expected.getLast(), getMessage(7));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowInfoSeparatelyWithBiConsumer_thenCallBiConsumer(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithBiConsumer(people);

        var expected = List.of(
                "John J.:20",
                "*10, *11, *12",
                "Dan D.:25",
                "*21, *22",
                "Marry M.:30",
                "*31",
                "Nick N.:27",
                "*41, *42"
        );

        assertEquals(8, getMessagesSize());

        assertEquals(expected.getFirst(), getMessage(0));

        assertEquals(expected.get(1), getMessage(1));

        assertEquals(expected.get(2), getMessage(2));

        assertEquals(expected.get(3), getMessage(3));

        assertEquals(expected.get(4), getMessage(4));

        assertEquals(expected.get(5), getMessage(5));

        assertEquals(expected.get(6), getMessage(6));

        assertEquals(expected.getLast(), getMessage(7));
    }

    @ParameterizedTest
    @MethodSource("getPeople")
    void whenCallShowInfoSeparatelyWithAgeFilter_thenCall2ConsumersWithAgeFilter(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithAgeFilter(people, 27);

        var expected = List.of(
                "Marry M.:30",
                "*31",
                "Nick N.:27",
                "*41, *42");

        assertEquals(4, getMessagesSize());

        assertEquals(expected.getFirst(), getMessage(0));

        assertEquals(expected.get(1), getMessage(1));

        assertEquals(expected.get(2), getMessage(2));

        assertEquals(expected.getLast(), getMessage(3));
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

    @Override
    protected Class<?> getLoggedClass() {
        return PersonConsumer.class;
    }

}