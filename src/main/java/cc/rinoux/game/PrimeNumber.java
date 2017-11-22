package cc.rinoux.game;

/**
 * @author rinoux
 * @version 10.0
 * Created by rinoux on 2019/11/12
 */
public class PrimeNumber {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ":" + isPrime(i));
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
