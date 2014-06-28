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
import pchat.constants.CommandConstant;
import pchat.data.object.CommandType;
import pchat.data.object.DataObject;
import pchat.handler.Responder;

/**
 *
 * @author Shaw Nam
 */
public class GetRoomUsersCommand extends AbstractCommand {
    


    @Override
    public void executeCommand(Responder responder, DataObject dataObject, Socket client) {
        ClientHandler clientHandler = ClientHandler.getInstance();
        Enumeration e = clientHandler.getClients(Integer.parseInt(dataObject.getMessage())).elements();
        String msg="";
        while(e.hasMoreElements())
        {
            Client obj = (Client)e.nextElement();
            if(!obj.getName().equals(dataObject.getUserName()))
                if(msg.equals(""))
                    msg = obj.getName() + CommandConstant.FIRST_SEPARATOR + 
                            obj.getMemberType() + CommandConstant.FIRST_SEPARATOR +
                            obj.getAvatarImage() + CommandConstant.FIRST_SEPARATOR +
                            obj.getPosition();
                else
                    msg = msg + CommandConstant.SECOND_SEPARATOR + 
                            obj.getName() + CommandConstant.FIRST_SEPARATOR + 
                            obj.getMemberType() + CommandConstant.FIRST_SEPARATOR +
                            obj.getAvatarImage() + CommandConstant.FIRST_SEPARATOR +
                            obj.getPosition();
                        
        }
        DataObject obj=new DataObject(CommandType.GET_ROOM_USERS,msg,dataObject.getUserName());
        responder.writeObject(client, obj);
        
        //We also broadcast new user here
        Client clientObj = clientHandler.getClientObject(dataObject.getUserName());
        Enumeration en = clientHandler.getClientsInMyRoom(dataObject.getUserName()).elements();
        while(en.hasMoreElements())
        {
            Client buddy = (Client)en.nextElement();
            DataObject objNewUser=new DataObject(CommandType.NEW_ROOM_USER, 
                    clientObj.getName() + CommandConstant.FIRST_SEPARATOR + 
                    clientObj.getMemberType() + CommandConstant.FIRST_SEPARATOR +
                    clientObj.getAvatarImage(),dataObject.getUserName());
            responder.writeObject(buddy.getClient(), objNewUser);
        }    }
    
}
