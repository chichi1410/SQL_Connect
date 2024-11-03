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

import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class UserDAO implements DAOInterface<User>{
    
    public static UserDAO getInstance(){
        return new UserDAO();
    }

    
          // không nên sử dụng đối tượng statement
      // vì khi hacker truyền vào 1 câu lệnh sql thì sẽ đăng nhập được vào tk 
     // nào đó mà ko cần tk hay mật khẩu
     // X\' or 1=1; --    
    
//    @Override
//    public int insert(User t) {
//        try {
//            Connection con = JDBCUtil.getConnection();
//            Statement st = con.createStatement();
//            String sql = "INSERT INTO nhasach.user(userName , password , name)VALUES"
//                    + "('"+t.getUserName()+"','"+t.getPassword()+"','"+t.getName()+"');";
//            int ketQua = st.executeUpdate(sql);
//            System.out.println("ban da thuc thi cau lenh : "+sql);
//            System.out.println("ban da thay doi "+ketQua+" dong");
//            
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//        }
//        return 0;
//    }
    
//    để khắc phục ta sử dụng PreparedStatement thay thế cho statement
//    JDBC BÀI 8
    @Override
    public int insert(User t) {
        try {
            Connection con = JDBCUtil.getConnection();
           // Statement st = con.createStatement();
            String sql = "INSERT INTO nhasach.user(userName , password , name)VALUES"
                    + "(?,?,?);";
            
            // su dung ham nay de oan toan tranh bi atack bang sql
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,t.getUserName());
            pst.setString(2, t.getPassword());
            pst.setString(3, t.getName());
            
            
            int ketQua = pst.executeUpdate(sql);
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
            System.out.println("ban da update cau lenh :\n" + sql);
            System.out.println("ban da thay doi "+ketQua+" dong");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(User t) {
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE FROM nhasach.user WHERE userName = '" + t.getUserName()+"'; ";
            int ketQua = st.executeUpdate(sql);
            System.out.println("ban da thuc thi cau lenh :\n" +sql);
            System.out.println("ban da thay doi "+ketQua+" dong");
            
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM nhasach.user";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String name = rs.getString("name");
                
                User user = new User(userName, password, name);
                ketQua.add(user);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public User selectById(User t) {
        User ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM nhasach.user WHERE userName = '"+t.getUserName()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("name");
                ketQua = new User(name);
                
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM nhasach.user WHERE "+condition;
            
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String name = rs.getString("name");
                User user = new User(userName, password, name);
                ketQua.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
}
