package my.work.interfacee.defaultt;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultMethodPerson {

    private static final Comparator<Person> NAME_COMPARATOR = Comparator.comparing(Person::getName);

    private static final Comparator<Person> NUMBER_OF_PHONES_COMPARATOR = Comparator.comparingInt(person -> person.getPhones().size());

    public static List<Person> compareByName(List<Person> people) {
        people.sort(NAME_COMPARATOR);
        return people;
    }

    public static List<Person> compareByNameNullSafe(List<Person> people) {
        people.sort(Comparator.nullsFirst(NAME_COMPARATOR));
        return people;
    }

    public static List<Person> compareByNumberOfPhones(List<Person> people) {
        people.sort(NUMBER_OF_PHONES_COMPARATOR);
        return people;
    }

    public static List<Person> compareByNameAndNumberOfPhones(List<Person> people) {
        people.sort(NAME_COMPARATOR.thenComparing(NUMBER_OF_PHONES_COMPARATOR));
        return people;
    }

}
