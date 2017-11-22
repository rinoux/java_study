package cc.rinoux.game;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by rinoux on 2019-06-17.
 */
public class MergeData {


    public static void main(String[] args) {


    }



    //输出
    private static void writeData(ObjectOutputStream out, Object[][] data, int intSize, int doubleSize) throws IOException {
        int rowSize = data.length;
        out.writeInt(data.length);
        out.writeInt(intSize);
        out.writeInt(doubleSize);

        for (int i = 0; i < rowSize; i++) {
            Object[] row = data[i];
            for (int j = 0; j < intSize; j++) {
                out.writeInt((int) row[j]);
            }
            for (int j = intSize; j < row.length; j++) {
                out.writeDouble((double) row[j]);
            }

        }
    }
}
