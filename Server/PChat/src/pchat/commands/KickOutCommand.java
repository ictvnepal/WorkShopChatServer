/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

import java.io.IOException;
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
public class KickOutCommand extends AbstractCommand {
    public void executeCommand(Responder responder,DataObject dataObject,Socket client)
    {
        Socket clientSocket=null;
        ClientHandler clientHandler = ClientHandler.getInstance();
        Enumeration e = clientHandler.getClients(clientHandler.getRoomID(dataObject.getUserName())).elements();
        DataObject obj = new DataObject(CommandType.LOGOUT, "Logout", dataObject.getMessage());        
        while(e.hasMoreElements())
        {
            Client buddy = (Client)e.nextElement();
            if(buddy.getName().equals(dataObject.getMessage()))
            {
                responder.writeObject(buddy.getClient(), dataObject);
                clientSocket= buddy.getClient();
            }
            else
                responder.writeObject(buddy.getClient(), obj);
        }
        clientHandler.removeClient(clientSocket);
        try
        {
            clientSocket.close();
        }
        catch(IOException ex)
        {}
    }
    
}
