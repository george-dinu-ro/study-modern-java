package my.work.number;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DuplicateRemover {

    public static List<Integer> removeDuplicatesImperative(List<Integer> list) {
        var result = new ArrayList<Integer>();

        for (var number : list) {
            if (!result.contains(number)) {
                result.add(number);
            }
        }

        return result;
    }

    public static List<Integer> removeDuplicatesEnhancedImperative(List<Integer> list) {
        var set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static List<Integer> removeDuplicatesDeclarative(List<Integer> list) {
        return list.stream().distinct().toList();
    }

}
