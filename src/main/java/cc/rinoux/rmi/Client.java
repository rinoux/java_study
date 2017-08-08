package cc.rinoux.rmi;

import java.rmi.Naming;

public class Client {
    public void go() {
        try {
            RemoteServer service = (RemoteServer) Naming.lookup("rmi://127.0.0.1:2020/RemoteHello");
            System.out.println(service.sayHello());
        } catch (Exception ignored) {

        }
    }


    public static void main(String[] args) {
        new Client().go();
    }
}
