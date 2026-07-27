package my.work.lambda.supplier;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleSupplier {

    private static final Supplier<Integer> SUPPLIER = () -> new Random().nextInt();

    public static Integer nextInt() {
        return SUPPLIER.get();
    }

}
