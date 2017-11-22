package cc.rinoux.base.file.ftp;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.w3c.dom.Document;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpDirEntry;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.util.Iterator;

/**
 * Created by rinoux on 2017/11/3.
 */
public class FtpTest {

    public static void main(String[] args) throws IOException {
        File file = new File("~/Desktop/fine-cloud-10.0.jar");
        System.out.println(file.toURI());

        SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory("org.xml.sax.driver");


        Document document = factory.createDocument("ftp://uftp@10.211.55.4/home/uftp/app1/WEB-INF/assets/chartmapsvg/user-defined/%E5%AE%89%E5%BE%BD%E7%9C%81.svg");

        System.out.println(document.getDocumentURI());

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
