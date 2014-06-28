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
 * @author ruman
 */
public class BlockUser {
    private int blockId;
    private int from;
    private int to;
    private Date blockDate;


    public BlockUser() {
    }

    public BlockUser(int blockId, int from, int to, Date blockDate) {
        this.blockId = blockId;
        this.from = from;
        this.to = to;
        this.blockDate = blockDate;
    }

    /**
     * @return the blockId
     */
    public int getBlockId() {
        return blockId;
    }

    /**
     * @param blockId the blockId to set
     */
    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    /**
     * @return the from
     */
    public int getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(int from) {
        this.from = from;
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
     * @return the blockDate
     */
    public Date getBlockDate() {
        return blockDate;
    }

    /**
     * @param blockDate the blockDate to set
     */
    public void setBlockDate(Date blockDate) {
        this.blockDate = blockDate;
    }

     public void save()
    {
        String sql="Insert into block_users(from,to,block_date) values(?,?,?)";
        try{
        DBConnection db=new DBConnection();
        db.open();
        db.addParameters(1,new Param(Type.String,getFrom()));
        db.addParameters(2,new Param(Type.String,getTo()));
        db.addParameters(3,new Param(Type.String,getBlockDate()));
        java.util.Date today = new java.util.Date();

        db.addParameters(4, new Param(Type.TimeStamp,new java.sql.Timestamp(today.getTime())));
         //db.addParameters(5,new Param(Type.Integer,getStatus()));
        db.execute(sql);
        db.close();
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static BlockUserList getAll()
    {
        BlockUserList blockUserList=new BlockUserList();
        String sql="SELECT * from block_users";
        try{
            DBConnection db=new DBConnection();
            db.open();

            ResultSet resultSet=db.fetch(sql);
            while(resultSet.next())
            {
                blockUserList.add(mapData(resultSet));
            }
            db.close();

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return blockUserList;
    }

    public static BlockUser mapData(ResultSet rs) throws SQLException
    {
        BlockUser blockUser=new BlockUser();
        blockUser.setBlockId((Integer)rs.getInt("block_id"));
        blockUser.setFrom((Integer)rs.getInt("from"));
        blockUser.setTo((Integer)rs.getInt("to"));
        blockUser.setBlockDate(rs.getDate("block_date"));
        return blockUser;
    }
    
    @Override
    public String toString() {
        return "BlockUser{" + "blockId=" + blockId + ", from=" + from + ", to=" + to + ", blockDate=" + blockDate + '}';
    }
    
}
