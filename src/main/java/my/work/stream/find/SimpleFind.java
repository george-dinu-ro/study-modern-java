package my.work.stream.find;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleFind {

    public static Optional<String> findFirst(List<String> input) {
        return input.stream().findFirst();
    }

    public static Optional<String> findAny(List<String> input) {
        return input.stream().findAny();
    }

}
