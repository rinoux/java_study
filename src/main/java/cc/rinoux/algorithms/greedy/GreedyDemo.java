package cc.rinoux.algorithms.greedy;

/**
 * Created by rinoux on 2017/4/10.
 */
public class GreedyDemo {

    /**
     * 现在有个活动选择的问题如下：
     学校只有一个教室，下面表格i代表活动的编号，s代表活动开始时间，f代表活动结束时间.
     i | 1 2 3 4 5 6 7  8  9  10 11
     s | 1 3 0 5 3 5 6  8  8  2  12
     f | 4 5 6 7 9 9 10 11 12 14 16
     现在问题是怎么合理分配才能让教室利用最大化（求活动序列A）？
     */

    /**
     *
     * @param startPoints 所有活动的起点
     * @param finishPoints 所有活动的结束点
     * @param k 范围起点（第几个开始选）
     * @param n 范围终点（第几个结束）
     * @return
     */
    public static String ras(int[] startPoints, int[] finishPoints, int k, int n) {
        int m = k + 1;
        //思想是在k后面找一个起始时间在k的结束时间之后的活动m
        while (m <= n && startPoints[m] < finishPoints[k]) {
            m += 1;
        }
        if(m <= n) {
            return m + "," + ras(startPoints, finishPoints, m, n);
        }
        return "";
    }

    public static void main(String[] args) {

        int[] s = {0, 1, 3, 0, 5, 3, 5, 6, 8, 8 ,2, 12};
        int[] f = {0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14 ,16};

        System.out.println(ras(s, f, 0, 11));
    }
}
