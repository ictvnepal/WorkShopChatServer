/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

/**
 *
 * @author Sun-J
 */
public class GetAvatarImageCommand extends AbstractCommand{
    public void executeCommand()//Responder responder,DataObject dataObject,Socket client)
    {
       /* String avatarImage = AvatarProvider.getAvatarImage(
                Integer.parseInt(dataObject.getMessage()));
        if(avatarImage!=null)
        {
            ClientHandler clientHandler = ClientHandler.getInstance();
            clientHandler.setAvatarImage(dataObject.getUserName(), avatarImage);
            DataObject obj=new DataObject(Command.GET_AVATAR_IMAGE,avatarImage,dataObject.getUserName());
            responder.writeObject(client, obj);
        }
        else
        {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ExceptionLog.logErrorMessage("Command : GET_AVATAR_IMAGE\n" + 
                    AvatarProvider.getErrMsg() , 
                    sdf.format(cal.getTime()));
        }*/
    }
}
