package cc.rinoux.filewatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("fth/test.txt");
        new File("fth").mkdir();
        file.createNewFile();
        /*FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[128];
        while (fis.read(b) > 0) {
            System.out.println(new String(b));
        }*/

        FileTest.class.getClassLoader().getResourceAsStream("xxx");
    }
}
