package my.work;

import org.junit.jupiter.params.provider.Arguments;

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
                                        .phones(List.of("*10", "*11", "*12"))
                                        .build(),
                                Person.builder()
                                        .name("Dan D.")
                                        .age(25)
                                        .phones(List.of("*21", "*22"))
                                        .build(),
                                Person.builder()
                                        .name("Marry M.")
                                        .age(32)
                                        .phones(List.of("*31"))
                                        .build(),
                                Person.builder()
                                        .name("Nick N.")
                                        .age(27)
                                        .phones(List.of("*41", "*42"))
                                        .build(),
                                Person.builder()
                                        .name("Eugen E.")
                                        .age(17)
                                        .phones(List.of("*51"))
                                        .build(),
                                Person.builder()
                                        .name("Larry L.")
                                        .age(30)
                                        .phones(Collections.emptyList())
                                        .build(),
                                Person.builder()
                                        .name("Bob B.")
                                        .age(16)
                                        .phones(Collections.emptyList())
                                        .build())));
    }

}
