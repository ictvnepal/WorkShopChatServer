/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.handler;

import java.net.Socket;
import pchat.data.object.DataObject;

/**
 *
 * @author Sun-J
 */
public class DataQueue {

    private DataObject dataObject;
    private Socket socket;

    public DataQueue(DataObject dataObject, Socket socket) {
        this.dataObject = dataObject;
        this.socket = socket;
    }

    public DataQueue() {
    }

    public DataObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}