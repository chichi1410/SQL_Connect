/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.DAO;

import java.util.ArrayList;
import Bai_04_connectSQL_bookstore.Model.KhachHang;
import connect_jdbc.Database.JDBCUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class KhachHangDAO implements DAOInterface<KhachHang>{
    
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang t) {
        try {
            Connection con = JDBCUtil.getConnection();
            
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO nhansach.khachhang(ID , FullName , dateOfBirth , address)"
                    + "VALUES('"+t.getID()+"' , '"+t.getFullName()+"' , '"+t.getDateOfBirth()+"' ,'"+t.getAddress()+"')";
            int ketQua = st.executeUpdate(sql);
            
            System.out.println("ban da update " + sql);
            System.out.println("ban da thay doi "+ketQua +"dong");
            
            JDBCUtil.closeConnection(con);
     
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(KhachHang t) {
        try {
            Connection con = JDBCUtil.getConnection();
            
            Statement st = con.createStatement();
            
            String sql ="UPDATE nhasach.";
            
            int ketQua = st.executeUpdate(sql);
            System.out.println("ban da thao tac "+sql);
            System.out.println("ban da thay doi " + ketQua +" dong");
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int delete(KhachHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM nhasach.khachhang";
            ResultSet rs  =st.executeQuery(sql);
           while (rs.next()) {
                int ID = rs.getInt("ID");
                String fullName = rs.getString("FullName");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String address = rs.getString("address");

                KhachHang khachHang = new KhachHang(ID, fullName, (java.sql.Date) dateOfBirth, address);
                ketQua.add(khachHang);
                
            }
        } catch (Exception e) {
        }
        
        
        return ketQua;
    }

    @Override
    public KhachHang selectById(KhachHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
