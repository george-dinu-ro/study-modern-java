package my.work.lambda.supplier;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.lambda.Person;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonSupplier {

    private static final Supplier<Person> SUPPLIER = Person::new;

    public static Person get() {
        return SUPPLIER.get();
    }

}
