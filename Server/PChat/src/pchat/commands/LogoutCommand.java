/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

/**
 *
 * @author Shaw Nam
 */
public class LogoutCommand extends AbstractCommand {
      public void executeCommand(Responder responder,DataObject dataObject,Socket client)
    {
        ClientHandler clientHandler = ClientHandler.getInstance();
        Enumeration e = clientHandler.getClientsInMyRoom(dataObject.getUserName()).elements();
        while(e.hasMoreElements())
        {
            Client buddy = (Client)e.nextElement();
            responder.writeObject(buddy.getClient(), dataObject);
        }
        clientHandler.removeClient(client);
    }
    
}
