/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.framework.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import pchat.framework.dal.DBConnection;
import pchat.framework.dal.Param;
import pchat.framework.dal.Type;

/**
 *
 * @author Aakash
 */
public class BannedUser {
    private int bannedId;
    private int userId;
    private int roomId;
    private Date bannedDate;

    public BannedUser() {
    }

    public BannedUser(int bannedId, int userId, int roomId, Date bannedDate) {
        this.bannedId = bannedId;
        this.userId = userId;
        this.roomId = roomId;
        this.bannedDate = bannedDate;
    }

    public int getBannedId() {
        return bannedId;
    }

    public void setBannedId(int bannedId) {
        this.bannedId = bannedId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
     public void save()
    {
        String sql="Insert into banned_users(banned_id,user_id,room_id,banned_date) values(?,?,?,?)";
        try{
        DBConnection db=new DBConnection();
        db.open();
        db.addParameters(1,new Param(Type.String,getBannedId()));
        db.addParameters(2,new Param(Type.String,getUserId()));
        db.addParameters(3,new Param(Type.String,getRoomId()));
        java.util.Date today = new java.util.Date();

        db.addParameters(4, new Param(Type.TimeStamp,new java.sql.Timestamp(today.getTime())));
        db.execute(sql);
        db.close();
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static BannedUserList getAll()
    {
        BannedUserList bannedUserList=new BannedUserList();
        String sql="SELECT * from banned_users";
        try{
            DBConnection db=new DBConnection();
            db.open();

            ResultSet resultSet=db.fetch(sql);
            while(resultSet.next())
            {
                bannedUserList.add(mapData(resultSet));
            }
            db.close();

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return bannedUserList;
    }

    public static BannedUser mapData(ResultSet rs) throws SQLException
    {
        BannedUser bannedUser=new BannedUser();
        bannedUser.setBannedId((Integer)rs.getInt("banned_id"));
        bannedUser.setUserId((Integer)rs.getInt("user_id"));
        bannedUser.setRoomId((Integer)rs.getInt("room_id"));
        
        return bannedUser;
    }

    @Override
    public String toString() {
        return "BannedUser{" + "bannedId=" + bannedId + ", userId=" + userId + ", roomId=" + roomId + ", bannedDate=" + bannedDate + '}';
    }
    
    
}
