/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;






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
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
