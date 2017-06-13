package cc.rinoux;

import java.util.List;
import java.util.Map;

/**
 * Created by rinoux on 2017/1/10.
 */
public class Utils {

    public static int getLevenshteinDistance(String str1, String str2) {
        char[] a = str1.toCharArray(), b = str2.toCharArray();
        int[][] distance = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < a.length; i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i < b.length; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i < a.length + 1; i++) {
            char currentA = a[i - 1];
            for (int j = 1; j < b.length + 1; j++) {
                char currentB = b[j - 1];
                if (currentA == currentB) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = min(distance[i][j - 1], distance[i - 1][j], distance[i -1][j - 1]) + 1;
                }
            }
        }

        return distance[a.length][b.length];
    }

    private static int min(int a, int b, int c) {
        int min = a;
        if (b < a) min = b;
        if (c < min) min = c;
        return min;
    }


    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }

    public static void main(String[] args) {
        //System.out.println(getLevenshteinDistance("abcd", "abc"));
        System.out.println(gbEncoding("该"));
    }


    public static Map zip(List target, Object... keys) {
        return null;
    }
}
