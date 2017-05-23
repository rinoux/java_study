package cc.rinoux.base;

import java.util.Random;

/**
 * Created by rinoux on 2017/1/4.
 */
public class RangeRandom extends Random {

    public static int random(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }
}
