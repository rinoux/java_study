package cc.rinoux;

import java.io.*;
import java.net.URL;

/**
 * Created by rinoux on 2017/7/17.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String fileName = "text.txt";
        FileWriter writer = new FileWriter(fileName, true);
        InputStream data = new ByteArrayInputStream("nnnnnnn".getBytes());
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(raf.length());
        raf.write("xxxxxx".getBytes());
        raf.close();
        data.close();
    }
}
