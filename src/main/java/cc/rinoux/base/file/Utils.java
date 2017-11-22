package cc.rinoux.base.file;

/**
 * Created by rinoux on 2017/11/7.
 */
public class Utils {


    private static String getFileName(String filePath) {
        String[] slashes = filePath.split("/");
        if (slashes.length > 1) {
            String name = slashes[slashes.length - 1];
            return name;
        } else {
            return filePath;
        }
    }


    private static String getFileDir(String filePath) {
        int lastSlash = filePath.lastIndexOf("/");
        if (lastSlash > 0) {
            return filePath.substring(0, lastSlash);
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getFileName("/Users/rinoux/GITHUB/java_study/src/main/java/cc/rinoux/file/FileTest.java"));
        System.out.println(getFileDir("/Users/rinoux/GITHUB/java_study/src/main/java/cc/rinoux/file/FileTest.java"));
    }
}
