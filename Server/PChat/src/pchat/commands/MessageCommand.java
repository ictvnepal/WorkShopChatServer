/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

import java.net.Socket;
import java.util.Enumeration;
import pchat.client.Client;
import pchat.client.ClientHandler;
import pchat.data.object.CommandType;
import pchat.data.object.DataObject;
import pchat.handler.Responder;

/**
 *
 * @author Shaw Nam
 */
public class MessageCommand extends AbstractCommand {
     public void executeCommand(Responder responder,DataObject dataObject,Socket client)
    {
        ClientHandler clientHandler = ClientHandler.getInstance();
        Enumeration e = clientHandler.getClientsInMyRoom(dataObject.getUserName()).elements();
        while(e.hasMoreElements())
        {
            Client buddy = (Client)e.nextElement();
            DataObject obj=new DataObject(CommandType.MESSAGE,dataObject.getMessage(),dataObject.getUserName());
            responder.writeObject(buddy.getClient(), obj);
        }
    }
    
}
