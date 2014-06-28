/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

import java.util.Hashtable;
import pchat.data.object.CommandType;

/**
 *
 * @author Sun-J
 */
public class CommandFactory {
    private static Hashtable commands=initialize();
    
    private static Hashtable initialize()
    {
       Hashtable commandTable=new Hashtable();
       commandTable.put(CommandType.LOGIN,new LoginCommand());
       commandTable.put(CommandType.LOGOUT,new LogoutCommand());
       /*commandTable.put(CommandType.GET_ROOM_IMAGE,new GetRoomImageCommand());
       commandTable.put(CommandType.GET_AVATAR_IMAGE,new GetAvatarImageCommand());
       commandTable.put(CommandType.MOVEAVATAR,new MoveAvatarCommand());
       commandTable.put(CommandType.GET_MEMBER_TYPE,new GetMemberTypeCommand());
       commandTable.put(CommandType.GET_ROOM_USERS,new GetRoomUsersCommand());
       commandTable.put(CommandType.MESSAGE,new MessageCommand());
       commandTable.put(CommandType.BLOCK_USER,new BlockUserCommand());
       commandTable.put(CommandType.UNBLOCK_USER,new UnblockUserCommand());
       commandTable.put(CommandType.KICK_USER,new KickOutCommand());
       
       commandTable.put(CommandType.CHANGE_AVATAR,new ChangeAvatarCommand());
       commandTable.put(CommandType.AWAY,new AwayCommand());
       commandTable.put(CommandType.PRIVATE_MESSAGE, new PrivateMessageCommand());*/
       return commandTable;
    }
    
    public static boolean isCommand(CommandType cmd)
    {
        return commands.containsKey(cmd);
    }
    
    public static AbstractCommand getCommand(CommandType cmd)
    {
        return (AbstractCommand)commands.get(cmd);
    }

    
}
