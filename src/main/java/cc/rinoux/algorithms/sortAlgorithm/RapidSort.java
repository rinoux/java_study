package cc.rinoux.algorithms.sortAlgorithm;

/**
 * Created by rinoux on 2016/12/22.
 */
public class RapidSort {

    private static int partition(int[] array, int low, int high) {
        int flag = low;
        if(array[flag] > array[high]) {
            DemoTools.swapPosition(array, flag, high);
        }
        if(array[low] > array[high]) {
            DemoTools.swapPosition(array, low, high);
        }
        if(array[flag] > array[low]) {
            DemoTools.swapPosition(array, flag, low);
        }
        int key = array[low];

        while(low < high) {
            while(array[high] >= key && high > low) {
                high--;
            }
            array[low] = array[high];

            while(array[low] <= key && high>low) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }

    private static void sort(int[] array, int low, int high) {
        if(low >= high){
            return ;
        }
        int index = partition(array, low, high);
        sort(array, low, index - 1);
        sort(array, index + 1, high);
    }

    public static void rapidSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array  =  { 15, 8, -5, 12, 5, 4, -2, 2, 7, 0, -1, 6, -3 , 9};
        RapidSort.rapidSort(array);

        for (int i  =  0; i < array.length; i++) {
            System.out.printf(" " + array[i]);
        }
    }
}
