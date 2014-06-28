/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.handler;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import pchat.commands.AbstractCommand;
import pchat.commands.CommandFactory;
import pchat.data.object.DataObject;

/**
 *
 * @author Sun-J
 */
 public class Responder extends Thread {
   private Vector<DataQueue> requestQueue = new Vector<DataQueue>();

    public synchronized void writeObject(Socket client, DataObject data) {
        try {
            ObjectOutputStream objOutStream = new ObjectOutputStream(client.getOutputStream());
            objOutStream.writeObject(data);
            objOutStream.flush();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public synchronized void queueMessage(DataQueue dataQueue) {
        requestQueue.add(dataQueue);
        notify();
    }

    public synchronized DataQueue getMessegeFromQueue()
            throws InterruptedException {
        while (requestQueue.isEmpty()) {
            wait();
        }
        DataQueue dataQueue = (DataQueue) requestQueue.get(0);
        requestQueue.remove(dataQueue);
        return dataQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DataQueue dataQueue = getMessegeFromQueue();
                //String msg = "";
                DataObject data = dataQueue.getDataObject();
                //System.out.println(data.getCommand() + " : " + data.getMessage());
                if(CommandFactory.isCommand(data.getCommand()))
                {
                    AbstractCommand chatCommand=(AbstractCommand)CommandFactory.getCommand(data.getCommand());
                    chatCommand.executeCommand(this, data, dataQueue.getSocket());
                }                
            }
        } catch (InterruptedException ine) {
      
        }
    }
}
