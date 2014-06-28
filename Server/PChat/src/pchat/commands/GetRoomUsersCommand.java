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
public class GetRoomUsersCommand AbstractCommand {
     public void executeCommand(Responder responder,DataObject dataObject,Socket client)
    {
        ClientHandler clientHandler = ClientHandler.getInstance();
        Enumeration e = clientHandler.getClients(Integer.parseInt(dataObject.getMessage())).elements();
        String msg="";
        while(e.hasMoreElements())
        {
            Client obj = (Client)e.nextElement();
            if(!obj.getName().equals(dataObject.getUserName()))
                if(msg.equals(""))
                    msg = obj.getName() + ChatConstant.FIRST_SEPARATOR + 
                            obj.getMemberType() + ChatConstant.FIRST_SEPARATOR +
                            obj.getAvatarImage() + ChatConstant.FIRST_SEPARATOR +
                            obj.getPosition();
                else
                    msg = msg + ChatConstant.SECOND_SEPARATOR + 
                            obj.getName() + ChatConstant.FIRST_SEPARATOR + 
                            obj.getMemberType() + ChatConstant.FIRST_SEPARATOR +
                            obj.getAvatarImage() + ChatConstant.FIRST_SEPARATOR +
                            obj.getPosition();
                        
        }
        DataObject obj=new DataObject(Command.GET_ROOM_USERS,msg,dataObject.getUserName());
        responder.writeObject(client, obj);
        
        //We also broadcast new user here
        Client clientObj = clientHandler.getClientObject(dataObject.getUserName());
        Enumeration en = clientHandler.getClientsInMyRoom(dataObject.getUserName()).elements();
        while(en.hasMoreElements())
        {
            Client buddy = (Client)en.nextElement();
            DataObject objNewUser=new DataObject(Command.NEW_ROOM_USER, 
                    clientObj.getName() + ChatConstant.FIRST_SEPARATOR + 
                    clientObj.getMemberType() + ChatConstant.FIRST_SEPARATOR +
                    clientObj.getAvatarImage(),dataObject.getUserName());
            responder.writeObject(buddy.getClient(), objNewUser);
        }
    }
    
}
