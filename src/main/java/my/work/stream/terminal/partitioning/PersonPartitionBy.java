package my.work.stream.terminal.partitioning;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonPartitionBy {

    public static Map<Boolean, List<Person>> partitioningByAgeDefault(List<Person> people) {
        return people.stream()
                .collect(Collectors.partitioningBy(IS_ADULT));
    }

    public static Map<Boolean, Set<Person>> partitioningByAgeUsingSet(List<Person> people) {
        return people.stream()
                .collect(Collectors.partitioningBy(IS_ADULT, Collectors.toSet()));
    }

}
