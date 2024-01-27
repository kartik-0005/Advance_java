
//HelloClient.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck2;

import java.rmi.Naming;
public class tw10_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Lookup the remote object with the name "HelloService"
            HelloInterface helloObj = (HelloInterface) Naming.lookup("rmi://localhost:1099/HelloService");

            // Invoke the remote method and print the result
            String result = helloObj.sayHello();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}