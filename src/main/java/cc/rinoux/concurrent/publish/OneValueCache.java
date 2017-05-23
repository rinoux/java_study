package cc.rinoux.concurrent.publish;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by rinoux on 2017/3/6.
 */
public class OneValueCache {

    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger lastNumber, BigInteger[] factors) {
        this.lastNumber = lastNumber;
        this.lastFactors = Arrays.copyOf(factors, factors.length);
    }
    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        }
        return Arrays.copyOf(lastFactors, lastFactors.length);
    }


    public static void main(String[] args) {
        System.out.println(0.06+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(303.1/1000);
    }

}
