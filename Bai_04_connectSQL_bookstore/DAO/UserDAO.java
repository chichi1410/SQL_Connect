/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.DAO;

import Bai_04_connectSQL_bookstore.Model.User;
import connect_jdbc.Database.JDBCUtil;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UserDAO implements DAOInterface<User>{
    
    public static UserDAO getInstance(){
        return new UserDAO();
    }

    @Override
    public int insert(User t) {
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO nhasach.user(userName , password , name)VALUES"
                    + "('"+t.getUserName()+"','"+t.getPassword()+"','"+t.getName()+"');";
            int ketQua = st.executeUpdate(sql);
            System.out.println("ban da thuc thi cau lenh : "+sql);
            System.out.println("ban da thay doi "+ketQua+" dong");
            
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    public int update(User t) {
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "UPDATE nhasach.user SET "
                  
                    + "password = '"+t.getPassword()+"'"
                    + ",name = '"+t.getName()+"' WHERE "
                    + " userName = '" +t.getUserName()+ "'";
            
            int ketQua = st.executeUpdate(sql);
            System.out.println("ban da update cau lenh " + sql);
            System.out.println("ban da thay doi "+ketQua+" dong");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User selectById(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
