/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchat.framework.models;

/**
 *
 * @author forsell
 */
public class Room {

    private int roomId;
    private String roomName;
    private String roomImage;

    public Room() {
    }

    public Room(int roomId, String roomName, String roomImage) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomImage = roomImage;
    }

    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * @return the roomImage
     */
    public String getRoomImage() {
        return roomImage;
    }

    /**
     * @param roomImage the roomImage to set
     */
    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

}
