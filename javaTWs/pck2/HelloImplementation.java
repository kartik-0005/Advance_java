//HelloImplementation.java
package pck2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class HelloImplementation extends UnicastRemoteObject implements HelloInterface {
    public HelloImplementation() throws RemoteException {
        super();
    }
    
    @Override
    public String sayHello() throws RemoteException {
        return "Hello, from the server!";
    }
    
}

