package my.work.lambda.consumer;

import my.work.ALogger;
import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonConsumerTest extends ALogger {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallShowAllInfo_thenCallToStringMethod(List<Person> people) {
        PersonConsumer.showAllInfo(people);

        var expected = List.of(
                "Person(name=John J., age=20, status=student, car=Optional.empty, phones=[*10, *11, *12])",
                "Person(name=Dan D., age=25, status=employee, car=Optional.empty, phones=[*21, *22])",
                "Person(name=Marry M., age=32, status=employee, car=Optional.empty, phones=[*31])",
                "Person(name=Nick N., age=27, status=employee, car=Optional.empty, phones=[*41, *42])",
                "Person(name=Eugen E., age=17, status=high-school, car=Optional.empty, phones=[*51])",
                "Person(name=Larry L., age=30, status=employee, car=Optional.empty, phones=[])",
                "Person(name=Bob B., age=16, status=high-school, car=Optional.empty, phones=[])");

        assertEquals(expected.size(), getMessagesSize());

        IntStream
                .range(0, getMessagesSize())
                .forEach(i -> assertEquals(expected.get(i), getMessage(i)));

        assertNotEquals(expected.getFirst() + System.currentTimeMillis(), getMessage(0));
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallShowInfoSeparatelyWithConsumer_thenCall2Consumers(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithConsumer(people);

        var expected = List.of(
                "John J.:20",
                "*10, *11, *12",
                "Dan D.:25",
                "*21, *22",
                "Marry M.:32",
                "*31",
                "Nick N.:27",
                "*41, *42",
                "Eugen E.:17",
                "*51",
                "Larry L.:30",
                "",
                "Bob B.:16",
                "");

        assertEquals(expected.size(), getMessagesSize());

        IntStream
                .range(0, getMessagesSize())
                .forEach(i -> assertEquals(expected.get(i), getMessage(i)));

        assertNotEquals(expected.getFirst() + System.currentTimeMillis(), getMessage(0));
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallShowInfoSeparatelyWithBiConsumer_thenCallBiConsumer(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithBiConsumer(people);

        var expected = List.of(
                "John J.:20",
                "*10, *11, *12",
                "Dan D.:25",
                "*21, *22",
                "Marry M.:32",
                "*31",
                "Nick N.:27",
                "*41, *42",
                "Eugen E.:17",
                "*51",
                "Larry L.:30",
                "",
                "Bob B.:16",
                "");

        assertEquals(expected.size(), getMessagesSize());

        IntStream
                .range(0, getMessagesSize())
                .forEach(i -> assertEquals(expected.get(i), getMessage(i)));

        assertNotEquals(expected.getFirst() + System.currentTimeMillis(), getMessage(0));
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallShowInfoSeparatelyWithAgeFilter_thenCall2ConsumersWithAgeFilter(List<Person> people) {
        PersonConsumer.showInfoSeparatelyWithAgeFilter(people, 27);

        var expected = List.of(
                "Marry M.:32",
                "*31",
                "Nick N.:27",
                "*41, *42",
                "Larry L.:30",
                "");

        assertEquals(expected.size(), getMessagesSize());

        IntStream
                .range(0, getMessagesSize())
                .forEach(i -> assertEquals(expected.get(i), getMessage(i)));

        assertNotEquals(expected.getFirst() + System.currentTimeMillis(), getMessage(0));
    }

    @Override
    protected Class<?> getLoggedClass() {
        return PersonConsumer.class;
    }

}