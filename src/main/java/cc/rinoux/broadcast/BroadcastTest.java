package cc.rinoux.broadcast;

import java.io.IOException;
import java.net.*;

public class BroadcastTest {
    public static class Client {
        public static void main(String[] args) {
            String message = "This is a broadcast message from client";
            try {
                DatagramSocket client = new DatagramSocket();
                //SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8888);
                SocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName("255.255.255.255"), 8888);

                client.bind(socketAddress);


                DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length());
                client.send(sendPacket);
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Server {
        public static void main(String[] args) {
            try {
                DatagramSocket server = new DatagramSocket(8888);
                DatagramPacket recvPacket = new DatagramPacket(new byte[1024], 1024);

                while (true) {
                    server.receive(recvPacket);
                    byte[] recvMsg = recvPacket.getData();
                    System.out.println("Receive msg from " + recvPacket.getAddress() + ":" + recvPacket.getPort() + ": " + new String(recvMsg));
                    server.send(recvPacket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}