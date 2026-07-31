package my.work.stream.terminal.minandmax;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMinByMaxBy {

    public static Optional<Person> minByAge(List<Person> people) {
        return people.stream()
                .min(Comparator.comparing(Person::getAge));
    }

    public static Optional<Person> maxByAge(List<Person> people) {
        return people.stream()
                .max(Comparator.comparing(Person::getAge));
    }

}
