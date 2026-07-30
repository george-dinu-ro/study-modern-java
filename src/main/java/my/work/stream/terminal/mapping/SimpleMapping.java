package my.work.stream.terminal.mapping;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleMapping {

    public static List<String> mapping(List<String> input) {
        return input.stream()
                .collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
    }

}
