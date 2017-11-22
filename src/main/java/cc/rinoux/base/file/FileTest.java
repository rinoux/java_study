package cc.rinoux.base.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("fth/test.txt");
        File dir = new File("fth/test/");


        FileChannel channel = new FileInputStream(file).getChannel();
        file.createNewFile();

        dir.mkdirs();


        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("相对路径：" + file.getPath());
        System.out.println("全路径:" + file.getCanonicalPath());

        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.getCanonicalPath());
        System.out.println(dir.getPath());
        System.out.println(dir.getName());
        /*FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[128];
        while (fis.read(b) > 0) {
            System.out.println(new String(b));
        }*/


        RandomAccessFile randomAccessFile = new RandomAccessFile("fth/test.txt", "rw");
        randomAccessFile.seek(10);
        randomAccessFile.write("我操你妈的".getBytes());

        FileTest.class.getClassLoader().getResourceAsStream("xxx");
    }
}
