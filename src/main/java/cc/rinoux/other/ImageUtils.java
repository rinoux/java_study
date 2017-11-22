package cc.rinoux.other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rinoux on 2017/3/2.
 */
public class ImageUtils {

    /**
     * 转化图片为RGB565 bmp格式
     * @param filePath 待转图片文件
     * @param saveFileName bmp文件保存路径
     */
    public static void image2RGB565Bmp(String filePath, String saveFileName) {
        try {
            BufferedImage sourceImg = ImageIO.read(new File(filePath));
            int h = sourceImg.getHeight(), w = sourceImg.getWidth();
            int[] pixel = new int[w * h];
            PixelGrabber pixelGrabber = new PixelGrabber(sourceImg, 0, 0, w, h, pixel, 0, w);
            pixelGrabber.grabPixels();

            MemoryImageSource m = new MemoryImageSource(w, h, pixel, 0, w);
            Image image = Toolkit.getDefaultToolkit().createImage(m);
            BufferedImage buff = new BufferedImage(w, h, BufferedImage.TYPE_USHORT_565_RGB);
            buff.createGraphics().drawImage(image, 0, 0 ,null);
            ImageIO.write(buff, "bmp", new File(saveFileName));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean image2RGB565Bmp(InputStream in, String saveFileName) {
        try {
            BufferedImage sourceImg = ImageIO.read(in);
            int h = sourceImg.getHeight(), w = sourceImg.getWidth();
            int[] pixel = new int[w * h];
            PixelGrabber pixelGrabber = new PixelGrabber(sourceImg, 0, 0, w, h, pixel, 0, w);
            pixelGrabber.grabPixels();

            MemoryImageSource m = new MemoryImageSource(w, h, pixel, 0, w);
            Image image = Toolkit.getDefaultToolkit().createImage(m);
            BufferedImage buff = new BufferedImage(w, h, BufferedImage.TYPE_USHORT_565_RGB);
            buff.createGraphics().drawImage(image, 0, 0 ,null);
            ImageIO.write(buff, "bmp", new File(saveFileName));
        } catch (InterruptedException e) {
            return false;
        } catch (IOException e) {
            return false;
        }

        return true;
    }


}
