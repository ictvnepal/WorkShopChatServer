/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.commands;

import pchat.handler.Responder;
import java.net.Socket;
import pchat.data.object.DataObject;

/**
 *
 * @author forsell
 */
public abstract class AbstractCommand {
    
 public abstract void executeCommand(Responder responder,DataObject dataObject,Socket client);
 
}
