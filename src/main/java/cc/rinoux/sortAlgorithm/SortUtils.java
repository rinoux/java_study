package cc.rinoux.sortAlgorithm;

/**
 * Created by rinoux on 2017/3/24.
 */
public class SortUtils {

    public static void rapidSort(int[] array) {
        RapidSort.rapidSort(array);
    }

    public static void heapSort(int[] array) {
        new HeapSort(array).sort();
    }

    public static void mergeSort(int[] array) {
        MergeSort.sort(array);
    }

    public static void testSort(int[] array) {
        long times = 10000000;
        long s = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            rapidSort(array);
        }
        System.out.println("Rapid sort " + (System.currentTimeMillis() - s) + "ms");

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            heapSort(array);
        }
        System.out.println("Heap sort " + (System.currentTimeMillis() - s) + "ms");

        long s2 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            mergeSort(array);
        }
        System.out.println("Merge sort " + (System.currentTimeMillis() - s) + "ms");
    }

    public static void main(String[] args) {
        int array[] = {120, 15, 41, 8, -5, -256, 12, 5, 4, -2, 72, 2, 7, 0, -1, -91, 6, -3 , 9, 112, 17, 45, 88, -52, -26, 32, 55, 48, -20, 70, 29, 71, -87, -11, -921, 64, -35 , 89};
        testSort(array);
        /*
         * 数组长度38， 10000000次排序结果
         *
         * Rapid sort 7092ms
         * Heap sort 14260ms
         * Merge sort 27318ms
         */
    }

}
