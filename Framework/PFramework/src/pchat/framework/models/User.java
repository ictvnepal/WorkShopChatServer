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
import pchat.framework.dal.DBConnection;
import pchat.framework.dal.Param;
import pchat.framework.dal.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author forsell
 */
public class User {

    private int userId;
    private String userName;
    private String email;
    private String password;
    private int status;

    public User() {
    }

    public User(int userId, String userName, String email, String password, int status) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public void save()
    {
        String sql="Insert into users(username,email,password,created_date,status) values(?,?,?,?,?)";
        try{
        DBConnection db=new DBConnection();
        db.open();
        db.addParameters(1,new Param(Type.String,getUserName()));
        db.addParameters(2,new Param(Type.String,getEmail()));
        db.addParameters(3,new Param(Type.String,getPassword()));
        java.util.Date today = new java.util.Date();

        db.addParameters(4, new Param(Type.TimeStamp,new java.sql.Timestamp(today.getTime())));
         db.addParameters(5,new Param(Type.Integer,getStatus()));
        db.execute(sql);
        db.close();
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static UserList getAll()
    {
        UserList userList=new UserList();
        String sql="SELECT * from users";
        try{
            DBConnection db=new DBConnection();
            db.open();

            ResultSet resultSet=db.fetch(sql);
            while(resultSet.next())
            {
                userList.add(mapData(resultSet));
            }
            db.close();

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public static User mapData(ResultSet rs) throws SQLException
    {
        User user=new User();
        user.setUserId((Integer)rs.getInt("user_id"));
        user.setUserName(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setStatus((Integer)rs.getInt("status"));
        return user;
    }
    
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + "userName=" + userName + "email=" + email + "password=" + password + "status=" + status + '}';
    }

    

    

}