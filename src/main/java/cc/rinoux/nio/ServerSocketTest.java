package cc.rinoux.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by rinoux on 2017/6/6.
 */
public class ServerSocketTest {

    private final static int PORT = 10096;

    private ServerSocketChannel server;

    private volatile boolean pause;

    private Selector readSelector;
    private Selector connSelector;


    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel  = ServerSocketChannel.open();
        ServerSocket serverSocket = channel.socket();
        serverSocket.bind(new InetSocketAddress(10009));

        ByteBuffer buffer = ByteBuffer.wrap(new byte[8096]);

        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT
                 | SelectionKey.OP_CONNECT
                 | SelectionKey.OP_READ
                 | SelectionKey.OP_WRITE);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator itr = selectionKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey key = (SelectionKey) itr.next();
                if (key.isAcceptable()) {
                }
            }

        }
    }
}
