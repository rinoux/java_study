package cc.rinoux.ftp;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.net.InetSocketAddress;

public class FTPTest {

    public static void main(String[] args) {
        FtpClient client = FtpClient.create();
        try {
            client.connect(new InetSocketAddress("121.42.43.152", 22));
            InputStream inm = client.list("/");
            System.out.println(inm);

        } catch (FtpProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
