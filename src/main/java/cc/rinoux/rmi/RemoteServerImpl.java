package cc.rinoux.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteServer {
    protected RemoteServerImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says hello";
    }


    public static void main(String[] args) {
        //TODO Rinoux:
        try {
            LocateRegistry.createRegistry(2020);
            RemoteServer service = new RemoteServerImpl();//创建远程对象
            //使用rmi包的Naming.bind将远程对象绑定到rmiregistry
            //客户根据绑定的名称在RMIregistry中搜索这个对象
            Naming.rebind("rmi://127.0.0.1:2020/RemoteHello", service);
            //lookup真实找到的是RemoteServerImpl_stub，从远程load
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
