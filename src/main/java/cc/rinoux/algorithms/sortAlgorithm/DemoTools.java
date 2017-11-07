package cc.rinoux.algorithms.sortAlgorithm;

/**
 * Created by rinoux on 2016/12/22.
 */
public class DemoTools {

    /**
     * 互换位置
     * @param array
     * @param a
     * @param b
     */
    public static void swapPosition(int[] array, int a, int b) {
        if (array.length > 0) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;


        }
    }

    /**
     * 最大堆排序
     * @param array
     */
    public static void heapSort(int[] array) {
        new HeapSort(array).sort();
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        DemoTools.swapPosition(array, j, j + 1);
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     * @param array 数组
     */
    public static void rapidSort(int[] array) {
        RapidSort.rapidSort(array);
    }

    /**
     * 求以base为基底，value的对数
     * @param base 基底
     * @param value 值
     * @return 对数值
     */
    public static double logarithm(int base, int value) throws Exception {
        double t;
        if (base < 0 && value < 0) {
            t = Math.log(-value) / Math.log(-base);
            if (Math.pow(base, t) == value) {
                return t;
            }
        } else if (base < 0 && value > 0) {
            t = Math.log(value) / Math.log(-base);
            if (Math.pow(base, t) == value) {
                return t;
            } else throw new Exception();
        } else if (base > 0 && value < 0) {
            throw new IllegalStateException();
        }
        t =  Math.log(value) / Math.log(base);
        return t;
    }

    public static void main(String[] args) {
        try {
            System.out.println(logarithm(2, -8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
