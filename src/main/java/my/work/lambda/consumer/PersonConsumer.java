package my.work.lambda.consumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class PersonConsumer {

    private static final Consumer<Person> ALL_INFO = System.out::println;

    private static final Consumer<Person> NAME_AND_AGE = person -> System.out.println(person.getName() + ":" + person.getAge());

    private static final Consumer<Person> PHONES = person -> System.out.println(person.getPhones());

    private static final BiConsumer<String, List<String>> NAME_AND_AGE_AND_PHONES = (nameAndAge, phones) ->
    {
        System.out.println(nameAndAge);
        System.out.println(phones);
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
