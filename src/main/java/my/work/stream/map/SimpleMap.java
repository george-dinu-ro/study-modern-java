package my.work.stream.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleMap {

    public static List<String> map(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .toList();
    }

}
