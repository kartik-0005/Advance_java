//HelloImplementation.java
package pck2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class tw10_interface extends UnicastRemoteObject implements HelloInterface {
    public tw10_interface() throws RemoteException {
        super();
    }
    
    @Override
    public String sayHello() throws RemoteException {
        return "Hello, from the server!";
    }
    
}

