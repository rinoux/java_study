package cc.rinoux.file.ftp;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpDirEntry;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Iterator;

/**
 * Created by rinoux on 2017/11/3.
 */
public class FtpTest {

    public static void main(String[] args) {
        try {
            FtpClient ftp = FtpClient.create(new InetSocketAddress("env.finedevelop.com", 58321));
            ftp.login("fr", "ilovejava".toCharArray());


            listFiles(ftp);
            //getFile(ftp, "/ssopcmd.xlsx", "opcmd.xlsx");

            //removeFile(ftp, "/搭街坊屌.cpt");




        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void listFiles(FtpClient client) throws IOException, FtpProtocolException {
        Iterator<FtpDirEntry> itr = client.listFiles("/");
        while (itr.hasNext()) {
            System.out.println(itr.next().getName());
        }
    }


    private static void getFile(FtpClient client, String name, String dest) {
        try {
            File file = new File(dest);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(dest);
            client.getFile(name, fos);

            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FtpProtocolException e) {
            e.printStackTrace();
        }

    }


    private static void removeFile(FtpClient client, String file) throws IOException, FtpProtocolException {
        client.deleteFile(file);
    }
}
