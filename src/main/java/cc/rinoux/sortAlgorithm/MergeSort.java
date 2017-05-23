package cc.rinoux.sortAlgorithm;

/**
 * Created by rinoux on 2017/3/24.
 */
public class MergeSort {
    /**
     * 合并相邻序列段
     * @param array 待排序列
     * @param low 第一段序列的起始下标
     * @param mid 第一段序列的结束下标
     * @param high 第二段序列的结束下标
     */
    private static void merge(int[] array, int low, int mid, int high) {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        /*
        用于存放两个序列的排序后结果
         */
        int[] temp = new int[high - low + 1];

        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
                k++;
            } else {
                temp[k] = array[j];
                j++;
                k++;
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            temp[k] = array[j];
            j++;
            k++;
        }

        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = temp[k];
        }
    }

    /**
     * 分段排序
     * @param array
     * @param gap
     * @param length
     */
    private static void groupAndMerge(int[] array, int gap, int length) {
        int i = 0;
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length) {
            merge(array, i, i + gap - 1, length - 1);
        }
    }

    public static void sort(int[] list) {
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            groupAndMerge(list, gap, list.length);
        }
    }

    public static void main(String[] args) {
        int[] array = { 15, 8, -5, 12, 5, 4, -2, 2, 7, 0, -1, 6, -3 , 9};

        MergeSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }

    }
}
