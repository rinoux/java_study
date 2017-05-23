package cc.rinoux.network;

import java.net.*;
import java.util.Enumeration;

/**
 * Created by rinoux on 2017/4/21.
 */
public class TestUrl {

    public static boolean isURLValid(String urlStr) {
        URL url;
        try {
            url = new URL(urlStr);
            HttpURLConnection connt = (HttpURLConnection)url.openConnection();
            connt.setRequestMethod("GET");
            String strMessage = connt.getResponseMessage();
            System.out.println("msg:" + strMessage);
            if (strMessage.compareTo("Not Found") == 0) {
                return false;
            }
            connt.disconnect();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws UnknownHostException, SocketException {
        System.out.println(isURLValid("http://192.168.99.239:8075/WebReport/ReportServer?op=resource&resource=com/fr/fs/web/css/iconfont.css"));


        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                System.out.println(i.getHostAddress());
            }
        }


    }
}
