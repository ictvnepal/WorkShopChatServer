/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

import java.net.Socket;
import java.util.StringTokenizer;
import pchat.client.Client;
import pchat.client.ClientHandler;
import pchat.constants.CommandConstant;
import pchat.data.object.CommandType;
import pchat.data.object.DataObject;
import pchat.handler.Responder;

/**
 *
 * @author Shaw Nam
 */
public class PrivateMessageCommand extends AbstractCommand {
    public void executeCommand(Responder responder,DataObject dataObject,Socket client)
    {
        StringTokenizer tokenizer = new StringTokenizer(dataObject.getMessage(), CommandConstant.FIRST_SEPARATOR);
        String messageTo = tokenizer.nextToken().toString();
        String message = tokenizer.nextToken().toString();

        Client obj = ClientHandler.getInstance().getClientObject(messageTo);
        
        responder.writeObject(obj.getClient(), new DataObject(CommandType.PRIVATE_MESSAGE, message, dataObject.getUserName()));
    }
    
}
