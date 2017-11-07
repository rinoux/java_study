package cc.rinoux.algorithms.sortAlgorithm;

/**
 * Created by rinoux on 2016/12/22.
 */
public class HeapSort {
    private final int[] heap;
    private int heapLength;

    public HeapSort(int[] heap) {
        this.heap = heap;
        heapLength = heap.length;
    }


    /**
     * 下标为i的元素的左、右、父节点
     */
    private int leftOf(int i) {
        return 2 * i;
    }

    private int rightOf(int i) {
        return 2 * i + 1;
    }

    private int parentOf(int i) {
        return (i - 1) / 2;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    /**
     * 从当前节点和其子节点开始查找最大值并放在
     * @param current 当前节点
     */
    private void maxHeapify(int current) {
        int left = leftOf(current);//当前节点的左子节点
        int right = rightOf(current);//当前节点的右子节点
        if (left >= heapLength || right >= heapLength) {
            return;
        }
        int largest = current;

        if (heap[left] > heap[current]) {
            //如果左子节点的元素大于当前节点的元素，令最大值节点为左子节点，反之为当前节点
            largest = left;
        }

        if (heap[right] > heap[largest]) {
            //如果右子节点的元素大于父节点或左兄弟节点的元素，令最大值节点为右子节点
            largest = right;
        }
        //保证当前节点和子节点相比较元素最大
        if (largest != current) {
            swap(largest, current);
            maxHeapify(largest);//递归
        }

    }

    /**
     * 建堆
     */
    private void buildMaxHeap() {
        //从叶子节点父代节点中的最左侧节点开始进行
        for (int i = heapLength / 2 - 1; i >= 0 ; i--) {
            maxHeapify(i);
        }
    }

    private void heapSort() {
        for (int i = 0; i < heap.length && heapLength > 0; i++) {
            swap(0, heapLength - 1);
            heapLength--;
            maxHeapify(0);
        }
    }

    public void sort() {
        buildMaxHeap();//保证每个从根节点到叶子节点上的数字是从小到大的顺序
        heapSort();//把每一个元素都和根节点交换在进行最大堆构建
    }

    public static void main(String[] args) {
        int[] array = { 15, 8, -5, 12, 5, 4, -2, 2, 7, 0, -1, 6, -3 , 9};

        new HeapSort(array).sort();



        for (int i = 0; i < array.length; i++) {
            System.out.printf(" " + array[i]);
        }
        // 这样，最大堆排序的时间复杂度为O(n*logn）

    }
}
