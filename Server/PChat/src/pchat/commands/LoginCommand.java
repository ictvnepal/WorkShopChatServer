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
public class LoginCommand extends AbstractCommand {
     public void executeCommand(Responder responder,DataObject dataObject,Socket client)
    {
        ClientHandler clientHandler = ClientHandler.getInstance();
        clientHandler.addClient(dataObject.getUserName());
        clientHandler.setClient(dataObject.getUserName(), client);
    }
    
}
