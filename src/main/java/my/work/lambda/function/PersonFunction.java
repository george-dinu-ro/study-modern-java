package my.work.lambda.function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.lambda.Person;
import my.work.lambda.predicate.PersonPredicate;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFunction {

    private static final Function<Person, List<String>> GET_PHONES = Person::getPhones;

    private static final Function<Person, Integer> GET_PHONES_SIZE = person -> PersonFunction.GET_PHONES.apply(person).size();

    private static final Function<List<Person>, Map<String, Integer>> PEOPLE_WITH_PHONES_COUNT = people ->
            people.stream().
                    collect(Collectors.toMap(Person::getName, PersonFunction.GET_PHONES_SIZE));

    private static final Function<List<Person>, Map<String, Integer>> ADULTS_WITH_PHONES_COUNT = people ->
            people.stream()
                    .filter(PersonPredicate.IS_ADULT)
                    .collect(Collectors.toMap(Person::getName, PersonFunction.GET_PHONES_SIZE));

    private static final BiFunction<List<Person>, Predicate<Person>, Map<String, Integer>> ADULTS_WITH_PHONES_COUNT_BIFUNCTION = (people, isAdult) ->
            people.stream()
                    .filter(isAdult)
                    .collect(Collectors.toMap(Person::getName, PersonFunction.GET_PHONES_SIZE));

    public static Map<String, Integer> getPeopleWithPhonesCount(List<Person> people) {
        return PEOPLE_WITH_PHONES_COUNT.apply(people);
    }

    public static Map<String, Integer> getAdultsWithPhonesCount(List<Person> people) {
        return ADULTS_WITH_PHONES_COUNT.apply(people);
    }

    public static Map<String, Integer> getAdultsWithPhonesCountBiFunction(List<Person> people, Predicate<Person> predicate) {
        return ADULTS_WITH_PHONES_COUNT_BIFUNCTION.apply(people, predicate);
    }

}
