package cc.rinoux.nio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;

/**
 * Created by rinoux on 2017/2/23.
 */
public class NIOTest {

    public NIOTest() throws IOException {
    }

    public void read() {

    }

    public static void main(String[] args) throws IOException {
        String fileName = "";
        InputStream in = new FileInputStream(fileName);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //获得channel的两种方式，open(Path path, OpenOption... options)和FileInputStream或Socket的getChannel()
        FileChannel fileChannelOpen = FileChannel.open(new File("").toPath());
        FileChannel fileChannelGet = new FileInputStream(fileName).getChannel();
        //map的作用是映射内存文件到MappedByteBuffer中
        MappedByteBuffer mbb = fileChannelOpen.map(FileChannel.MapMode.READ_ONLY, 0, fileChannelOpen.size());

        FileInputStream fileInputStream = new FileInputStream("filepath");
        fileInputStream.getChannel().read(buffer);//InputStream也可以获得channel

        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("xxxxx", 9000));
        socket.getChannel();//socket也有channel

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9000));

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 9000));

        DatagramChannel datagramChannel = DatagramChannel.open();

        RandomAccessFile randomAccessFile = new RandomAccessFile("filename", "r");
        FileChannel fileChannel1 = randomAccessFile.getChannel();


        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

        /**
         * 实现了InterruptibleChannel接口的channel可以被异步关闭或中断
         */
    }
}
