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
public class GetMemberTypeCommand extends AbstractCommand{
    public void executeCommand()//Responder responder,DataObject dataObject,Socket client)
    {
        /*int memberType = AvatarProvider.getMemberType(
                dataObject.getMessage());
        if(memberType!=-1)
        {
            ClientHandler clientHandler = ClientHandler.getInstance();
            clientHandler.setMemberType(dataObject.getUserName(), memberType);
            
            DataObject obj=new DataObject(Command.GET_MEMBER_TYPE,Integer.toString(memberType),dataObject.getUserName());
            responder.writeObject(client, obj);
        }
        else
        {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ExceptionLog.logErrorMessage("Command : GET_MEMBER_TYPE\n" + 
                    AvatarProvider.getErrMsg() , 
                    sdf.format(cal.getTime()));
        }*/
    }
}
