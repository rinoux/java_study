package cc.rinoux;

/**
 * Created by rinoux on 2017/6/22.
 */
public class IterArray {


    public static void main(String[] args) {

        int[][] twoDimArray = {
                {1, 0, 3, 0},
                {5, 6, 0, 8},
                {0, 10}
        };


        int x = 0, y = 0;

        for (int i = x; i < twoDimArray.length; i++) {
            for (int j = y; j < twoDimArray[i].length; j++) {
                if (twoDimArray[i][j] != 0) {
                    //x = i + 1;
                    //y = j + 1;
                    System.out.println(twoDimArray[i][j]);
                }

            }
        }


    }
}
