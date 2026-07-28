package my.work.lambda.consumer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.work.Person;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class PersonConsumer {

    private static final Consumer<Person> ALL_INFO = person -> log.info(person.toString());

    private static final Consumer<Person> NAME_AND_AGE = person -> log.info("{}:{}", person.getName(), person.getAge());

    private static final Consumer<Person> PHONES = person -> log.info(String.join(", ", person.getPhones()));

    private static final BiConsumer<String, List<String>> NAME_AND_AGE_AND_PHONES = (nameAndAge, phones) ->
    {
        log.info(nameAndAge);
        log.info(String.join(", ", phones));
    };

    public static void showAllInfo(List<Person> people) {
        people.forEach(ALL_INFO);
    }

    public static void showInfoSeparatelyWithConsumer(List<Person> people) {
        people.forEach(NAME_AND_AGE.andThen(PHONES));
    }

    public static void showInfoSeparatelyWithBiConsumer(List<Person> people) {
        people.forEach(person -> NAME_AND_AGE_AND_PHONES.accept("%s:%d".formatted(person.getName(), person.getAge()), person.getPhones()));
    }

    public static void showInfoSeparatelyWithAgeFilter(List<Person> people, int minAge) {
        people.forEach(person -> {
            if (person.getAge() >= minAge) {
                NAME_AND_AGE.andThen(PHONES).accept(person);
            }
        });
    }

}
