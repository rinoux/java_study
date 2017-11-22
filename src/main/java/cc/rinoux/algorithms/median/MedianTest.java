package cc.rinoux.algorithms.median;

import cc.rinoux.algorithms.sortAlgorithm.HeapSort;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.KthSelector;

import java.util.Random;

/**
 * Created by rinoux on 2019-06-21.
 */
public class MedianTest {

    public static void main(String[] args) {

        Random random = new Random();
        double[] array = new double[10000000];
        int[] values = new int[10000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
            values[i] = (int) array[i];
        }


        long start = System.currentTimeMillis();

        Median median = new Median();
        System.out.println((int) median.evaluate(array));

        System.out.println(System.currentTimeMillis() - start);


        long start1 = System.currentTimeMillis();
        new HeapSort(values).sort();
        System.out.println(values[5000000]);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();

        System.out.println(getMedian(values, 100000));
        System.out.println(System.currentTimeMillis() - start2);
    }


    private static int getMedian(int[] values, int max) {

        int pivot = max / 2;


        int diff = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < values.length / 2; i++) {
            if (values[i] - pivot == 0) {
                left = values[i];
                break;
            } else if (values[i] - pivot < diff) {
                diff = values[i] - pivot;
                left = values[i];
            }

        }


        for (int i = values.length / 2; i < values.length; i++) {
            if (values[i] - pivot == 0) {
                right = values[i];
                break;
            } else if (values[i] - pivot < diff) {
                diff = values[i] - pivot;
                right = values[i];
            }

        }

        return left + (right - left);
    }


    protected double estimate(double[] work, int[] pivotsHeap, double pos, int length, KthSelector selector) {
        double fpos = FastMath.floor(pos);
        int intPos = (int)fpos;
        double dif = pos - fpos;
        if (pos < 1.0D) {
            return selector.select(work, pivotsHeap, 0);
        } else if (pos >= (double)length) {
            return selector.select(work, pivotsHeap, length - 1);
        } else {
            double lower = selector.select(work, pivotsHeap, intPos - 1);
            double upper = selector.select(work, pivotsHeap, intPos);
            return lower + dif * (upper - lower);
        }
    }

}
