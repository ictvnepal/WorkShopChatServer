package pchat.data.object;
import pchat.data.object.CommandType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sun-J
 */
public class DataObject implements java.io.Serializable {
    private CommandType command;
    private String message;
    private String userName;

    public DataObject() {
    }

    public DataObject(CommandType command, String message,String userName) {
        this.command = command;
        this.message = message;
        this.userName=userName;
    }

    public CommandType getCommand() {
        return command;
    }

    public void setCommand(CommandType command) {
        this.command = command;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }    
}
