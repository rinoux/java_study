package cc.rinoux.algorithms.kmp;

/**
 * Created by rinoux on 2017/4/20.
 */
public class KMPDemo {

    /**
     * 计算模式串的跳转表
     *
     * @param pattern 模式串
     * @return 跳转表
     */
    private static int[] next(char[] pattern) {
        int[] next = new int[pattern.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < pattern.length - 1) {
            if (j == -1 || pattern[i] == pattern[j]) {
                i++;
                j++;
                if (pattern[i] != pattern[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 计算KMP匹配距离
     *
     * @param target 匹配目标
     * @param pattern 模式串
     * @return 匹配成功返回当前目标串下标
     *         匹配失败返回-1
     */
    public static int KMPIndex(char[] target, char[] pattern) {
        //首先计算出pattern的next{-1，-1，1，0，-1}
        int[] next = next(pattern);
        int i = 0;
        int j = 0;
        while (i <= target.length - 1 && j <= pattern.length - 1) {
            if (j == -1 || target[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < pattern.length) {
            return -1;
        } else
            return i - pattern.length; // 返回模式串在主串中的头下标
    }


    public static void main(String[] args) {
        char[] target = "abbabbbbcab".toCharArray();
        char[] pattern = "bbcab".toCharArray();//next{-1，-1，1，0，-1}

        System.out.println(KMPIndex(target, pattern));
    }
}
