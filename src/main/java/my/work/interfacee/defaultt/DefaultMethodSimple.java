package my.work.interfacee.defaultt;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultMethodSimple {

    public static void sortUsingCollections(List<String> list) {
        Collections.sort(list);
    }

    public static void sortUsingDefaultMethod(List<String> list) {
        list.sort(Comparator.naturalOrder());
    }

    public static void sortUsingNullSafeDefaultMethod(List<String> list) {
        list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
    }

}
