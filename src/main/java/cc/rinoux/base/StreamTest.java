package cc.rinoux.base;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by rinoux on 2018/4/20.
 */
public class StreamTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/rinoux/Desktop/test.txt");
        OutputStream out = new BufferedOutputStream(fileOutputStream);
        out.write("xxxxxxxxx".getBytes());
        out.write("yyyyyyyyyy".getBytes());
        out.close();
    }
}
