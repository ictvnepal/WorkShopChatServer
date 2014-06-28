/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import pchat.handler.ClientListener;
import pchat.handler.Responder;



/**
 *
 * @author forsell
 */


public class PChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            Properties configFile=new Properties();
            configFile.load(new FileInputStream("config.properties"));
            String port=configFile.getProperty("PORT");

            ServerSocket server=new ServerSocket(Integer.parseInt(port));
            System.out.println("Server is Runnint at :" + port);
            Responder responder=new Responder();
            responder.start();
            while(true)
            {
                Socket client=server.accept();
                System.out.println("Got Connection request from " +client);
                ClientListener clientListener=new ClientListener(client,responder);
                clientListener.start();
            }
            
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
