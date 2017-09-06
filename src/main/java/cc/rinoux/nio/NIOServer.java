package cc.rinoux.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NIOServer {

    private static final int PORT = 9999;
    private static ServerSocketChannel server;
    //多路复用器／注册器
    private static Selector selector;
    private Map<SelectionKey, String> sessionMsg = new HashMap<>();

    //接受消息的buffer
    private ByteBuffer rcvBuffer = ByteBuffer.allocate(1024);
    //发送消息的buffer
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);

    public NIOServer(int port) throws IOException {
        server = ServerSocketChannel.open();
        //server.bind(new InetSocketAddress(port));
        server.socket().bind(new InetSocketAddress(port));
        server.configureBlocking(false);//设置为非阻塞

        //初始化selector
        selector = Selector.open();
        //注册selector到socket
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NIO 服务已经开始监听" + port);
    }


    public NIOServer() throws IOException {
        this(PORT);
    }

    public void listen() throws IOException {
        //轮询
        while (true) {
            //通过selector查看是否有注册事件
            int eventCount = selector.select();
            if (eventCount < 0) {
                continue;//继续轮询注册到selector的的channel
            }

           Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                process(selectionKey);
                selectionKeys.remove(selectionKey);
            }
        }
    }


    private void process(SelectionKey key) {
        SocketChannel client = null;
        try {
            //判断key是否有效
            if (key.isValid() && key.isAcceptable()) {
                server.accept();
                server.configureBlocking(false);
                client = (SocketChannel) key.channel();
                client.register(selector, SelectionKey.OP_READ);
            } else if (key.isValid() && key.isReadable()) {
                rcvBuffer.clear();
                client = (SocketChannel) key.channel();
                int len = client.read(rcvBuffer);
                if (len > 0) {
                    String msg = new String(rcvBuffer.array(), 0, len);
                    sessionMsg.put(key, msg);
                    client.register(selector, SelectionKey.OP_WRITE);//设置状态为写
                }
            } else if (key.isValid() && key.isWritable()) {
                //可写状态
                if (sessionMsg.containsKey(key)) {
                    sendBuffer.clear();
                    client = (SocketChannel) key.channel();
                    sendBuffer.put((sessionMsg.get(key) + "的信息已经处理").getBytes());
                    sendBuffer.flip();
                    client.write(sendBuffer);
                    client.register(selector, SelectionKey.OP_READ);
                }
            }
        } catch (Throwable ignored) {

        } finally {
            //为了客户端断线的时候，不会引起异常
            try {
                key.cancel();
                if (client != null) {
                    client.socket().close();
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws IOException {
        new NIOServer().listen();
    }
}
