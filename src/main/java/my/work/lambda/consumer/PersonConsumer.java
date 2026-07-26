package my.work.lambda.consumer;

import java.util.List;
import java.util.function.Consumer;

public class PersonConsumer {

    private static final Consumer<Person> ALL_INFO = System.out::println;

    private static final Consumer<Person> NAME_AND_AGE = person -> System.out.println(person.getName() + ":" + person.getAge());

    private static final Consumer<Person> PHONES = person -> System.out.println(person.getPhones());

    public static void showAllInfo(List<Person> people) {
        people.forEach(ALL_INFO);
    }

    public static void showInfoSeparately(List<Person> people) {
        people.forEach(NAME_AND_AGE.andThen(PHONES));
    }

    public static void showInfoSeparatelyWithAgeFilter(List<Person> people, int minAge) {
        people.forEach(person -> {
            if (person.getAge() >= minAge) {
                NAME_AND_AGE.andThen(PHONES).accept(person);
            }
        });
    }

}
