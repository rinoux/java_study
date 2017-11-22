package cc.rinoux.jdknewidentity.jdk8.lamda;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2021/3/11
 */
public class SupplierTest {

    public static void main(String[] args) {

        System.out.println(handle("this is supplier test").orElse("can not be null."));
        System.out.println(handle(null).orElse("can not be null."));

    }

    public static Optional<String> handle(String s) {
        if (s != null) {
            return Optional.of(s);
        } else {
            return Optional.empty();
        }
    }


    public static String getOrDefault(String p, Supplier<String> supplier) {
        if (p == null) {
            return supplier.get();
        }

        return p;
    }
}
