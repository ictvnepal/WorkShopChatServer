/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.framework.models;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import pchat.framework.dal.DBConnection;
import pchat.framework.dal.Param;
import pchat.framework.dal.Type;
/**
 *
 * @author Aakash
 */
public class Avatar {
    private int avatarId;
    private String avatarImage;

    public Avatar() {
    }

    public Avatar(int avatarId, String avatarImage) {
        this.avatarId = avatarId;
        this.avatarImage = avatarImage;
    }

    /**
     * @return the avatarId
     */
    public int getAvatarId() {
        return avatarId;
    }

    /**
     * @param avatarId the avatarId to set
     */
    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    /**
     * @return the avatarImage
     */
    public String getAvatarImage() {
        return avatarImage;
    }

    /**
     * @param avatarImage the avatarImage to set
     */
    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }
     public void save()
    {
        String sql="Insert into avatars(avatars_image) values(?)";
        try{
        DBConnection db=new DBConnection();
        db.open();
        db.addParameters(1,new Param(Type.String,getAvatarImage()));
        db.execute(sql);
        db.close();
        }catch(ClassNotFoundException | IOException | SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static AvatarList getAll()
    {
        AvatarList avatarList=new AvatarList();
        String sql="SELECT * from avatars";
        try{
            DBConnection db=new DBConnection();
            db.open();

            ResultSet resultSet=db.fetch(sql);
            while(resultSet.next())
            {
                avatarList.add(mapData(resultSet));
            }
            db.close();

        }catch(ClassNotFoundException | IOException | SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return avatarList;
    }

    public static Avatar mapData(ResultSet rs) throws SQLException
    {
        Avatar avatar=new Avatar();
        avatar.setAvatarId((Integer)rs.getInt("avatars_id"));
        avatar.setAvatarImage(rs.getString("avatars_image"));
        return avatar;
    }
    
    @Override
    public String toString() {
        return "User{" + "avatarId=" + avatarId + "avatarImage=" + avatarImage + '}';
    }

}
