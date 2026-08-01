package my.work;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class PersonStorage {

    public static Stream<Arguments> getPeople() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Person.builder()
                                        .name("John J.")
                                        .age(20)
                                        .status("student")
                                        .phones(List.of("*10", "*11", "*12"))
                                        .build(),
                                Person.builder()
                                        .name("Dan D.")
                                        .age(25)
                                        .status("employee")
                                        .phones(List.of("*21", "*22"))
                                        .build(),
                                Person.builder()
                                        .name("Marry M.")
                                        .age(32)
                                        .status("employee")
                                        .phones(List.of("*31"))
                                        .build(),
                                Person.builder()
                                        .name("Nick N.")
                                        .age(27)
                                        .status("employee")
                                        .phones(List.of("*41", "*42"))
                                        .build(),
                                Person.builder()
                                        .name("Eugen E.")
                                        .age(17)
                                        .status("high-school")
                                        .phones(List.of("*51"))
                                        .build(),
                                Person.builder()
                                        .name("Larry L.")
                                        .age(30)
                                        .status("employee")
                                        .phones(Collections.emptyList())
                                        .build(),
                                Person.builder()
                                        .name("Bob B.")
                                        .age(16)
                                        .status("high-school")
                                        .phones(Collections.emptyList())
                                        .build())));
    }

    public static Stream<Arguments> getPeopleWithNull() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                Person.builder()
                                        .name("John J.")
                                        .age(20)
                                        .status("student")
                                        .phones(List.of("*10", "*11", "*12"))
                                        .build(),
                                Person.builder()
                                        .name("Dan D.")
                                        .age(25)
                                        .status("employee")
                                        .phones(List.of("*21", "*22"))
                                        .build(),
                                Person.builder()
                                        .name("Marry M.")
                                        .age(32)
                                        .status("employee")
                                        .phones(List.of("*31"))
                                        .build(),
                                null,
                                Person.builder()
                                        .name("Nick N.")
                                        .age(27)
                                        .status("employee")
                                        .phones(List.of("*41", "*42"))
                                        .build(),
                                Person.builder()
                                        .name("Eugen E.")
                                        .age(17)
                                        .status("high-school")
                                        .phones(List.of("*51"))
                                        .build(),
                                Person.builder()
                                        .name("Larry L.")
                                        .age(30)
                                        .status("employee")
                                        .phones(Collections.emptyList())
                                        .build(),
                                Person.builder()
                                        .name("Bob B.")
                                        .age(16)
                                        .status("high-school")
                                        .phones(Collections.emptyList())
                                        .build())));
    }

}
