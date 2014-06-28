/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

import java.net.Socket;
import pchat.client.ClientHandler;
import pchat.data.object.DataObject;
import pchat.handler.Responder;

/**
 *
 * @author forsell
 */
public class LoginCommand extends AbstractCommand {

    @Override
    public void executeCommand(Responder responder, DataObject dataObject, Socket client) {
        ClientHandler clientHandler = ClientHandler.getInstance();
        clientHandler.addClient(dataObject.getUserName());
        clientHandler.setClient(dataObject.getUserName(), client);
    }
    
}
