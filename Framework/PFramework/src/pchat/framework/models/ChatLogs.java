/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.framework.models;

import java.io.IOException;
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
public class ChatLogs {
    private int chatLogId;
    private int userId;
    private String message;
    private int to;
    private Date loginDate;
    private boolean seen;
    private Date seenDate;
    private Date messageDate;

    public ChatLogs() {
    }

    /**
     * @return the chatLogId
     */
    public int getChatLogId() {
        return chatLogId;
    }

    /**
     * @param chatLogId the chatLogId to set
     */
    public void setChatLogId(int chatLogId) {
        this.chatLogId = chatLogId;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the to
     */
    public int getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(int to) {
        this.to = to;
    }

    /**
     * @return the login_date
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate the login_date to set
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * @return the seen
     */
    public boolean isSeen() {
        return seen;
    }

    /**
     * @param seen the seen to set
     */
    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    /**
     * @return the seenDate
     */
    public Date getSeenDate() {
        return seenDate;
    }

    /**
     * @param seenDate the seenDate to set
     */
    public void setSeenDate(Date seenDate) {
        this.seenDate = seenDate;
    }

    /**
     * @return the messageDate
     */
    public Date getMessageDate() {
        return messageDate;
    }

    /**
     * @param messageDate the messageDate to set
     */
    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
    
    public void save()
    {
        String sql="Insert into chat_logs(user_id,message,to,login_date,is_seen,seen_date,message_date) values(?,?,?,?,?,?,?)";
        try{
        DBConnection db=new DBConnection();
        db.open();
        db.addParameters(1,new Param(Type.Integer,getUserId()));
        db.addParameters(2,new Param(Type.String,getMessage()));
        db.addParameters(3,new Param(Type.Integer,getTo()));
        java.util.Date today = new java.util.Date();

        db.addParameters(4, new Param(Type.TimeStamp,new java.sql.Timestamp(today.getTime())));
        db.addParameters(5,new Param(Type.Boolean,isSeen()));
        db.addParameters(6, new Param(Type.TimeStamp,new java.sql.Timestamp(today.getTime())));
        db.addParameters(7, new Param(Type.TimeStamp,new java.sql.Timestamp(today.getTime())));
        db.execute(sql);
        db.close();
        }catch(ClassNotFoundException | IOException | SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public static ChatLogList getAll()
    {
        ChatLogList chatList=new ChatLogList();
        String sql="SELECT * from chat_logs";
        try{
            DBConnection db=new DBConnection();
            db.open();

            ResultSet resultSet=db.fetch(sql);
            while(resultSet.next())
            {
                chatList.add(mapData(resultSet));
            }
            db.close();

        }catch(ClassNotFoundException | IOException | SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return chatList;
    }

    public static ChatLogs mapData(ResultSet rs) throws SQLException
    {
        ChatLogs chatLog=new ChatLogs();
        chatLog.setUserId((Integer)rs.getInt("user_id"));
        chatLog.setMessage(rs.getString("message"));
        chatLog.setTo((Integer)rs.getInt("to"));
        chatLog.setLoginDate(rs.getDate("login_date"));
        chatLog.setSeen((Boolean)rs.getBoolean("is_seen"));
        chatLog.setSeenDate((Date)rs.getDate("seen_date"));
        chatLog.setMessageDate((Date)rs.getDate("message_date"));
        return chatLog;
        
    }
    

    @Override
    public String toString() {
        return "ChatLogs{" + "chatLogId=" + chatLogId + ", userId=" + userId + ", message=" + message + ", to=" + to + ", login_date=" + loginDate + ", seen=" + seen + ", seenDate=" + seenDate + ", messageDate=" + messageDate + '}';
    }
    
     
}
