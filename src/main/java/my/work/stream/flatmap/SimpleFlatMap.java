package my.work.stream.flatmap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleFlatMap {

    public static List<String> flatMap(List<List<String>> input) {
        return input.stream()
                .flatMap(Collection::stream)
                .toList();
    }

}
