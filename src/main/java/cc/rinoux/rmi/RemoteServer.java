package cc.rinoux.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {
    public String sayHello() throws RemoteException;
}
