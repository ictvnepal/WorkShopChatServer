/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.handler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import pchat.client.ClientHandler;
import pchat.commands.AbstractCommand;
import pchat.commands.CommandFactory;
import pchat.data.object.CommandType;
import pchat.data.object.DataObject;

/**
 *
 * @author Dixanta Bahadur Shrestha
 */
public class ClientListener extends Thread {

    private Socket client;
    private Responder responder;
    private ObjectInputStream objInStream;

    public ClientListener() {
    }

    public ClientListener(Socket client, Responder responder) {
        this.client = client;
        this.responder = responder;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                objInStream = new ObjectInputStream(client.getInputStream());
                DataObject data = (DataObject) objInStream.readObject();
                DataQueue dataQueue = new DataQueue(data, client);
                responder.queueMessage(dataQueue);
            }
        } catch (IOException ioe) {
            //cleaning here
            ClientHandler clientHandler = ClientHandler.getInstance();
            String name = clientHandler.getClientName(client);
            if(!name.equals(""))
            {
                AbstractCommand chatCommand=(AbstractCommand)CommandFactory.getCommand(CommandType.LOGOUT);
                chatCommand.executeCommand(responder, new DataObject(CommandType.LOGOUT, "Logout", name), client);
            }
        } catch (ClassNotFoundException cne) {
            
        }
    }
}
