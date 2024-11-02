/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.DAO;

import Bai_04_connectSQL_bookstore.Model.Book;
import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;
import connect_jdbc.Database.JDBCUtil;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class BookDAO implements DAOInterface<Book> {

    public static BookDAO getInstance() {
        return new BookDAO();
    }

    @Override
    public int insert(Book t) {
        try {
            // b1 tao conect
            Connection con = JDBCUtil.getConnection();
            // tao doi tuong statement
            Statement st = con.createStatement();
            // tao 1 cau lenh sql
            String sql = "  INSERT INTO nhasach.book(ID ,bookName , sellingPrice , yearOfPublication )"
                    + "VALUES('"+t.getID()+"','"+t.getBookName()+"','"+t.getSellingPrice()+"','"+t.getYearOfPublication()+"')";

            int ketQua = st.executeUpdate(sql);
            // B4
            System.out.println("ban da thuc thi : " + sql);
            System.out.println("co " + ketQua + " bi thay doi");

            //B5
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return 0;
       
    }

    @Override
    public int update(Book t) {
         try {
            // b1 tao conect
            Connection con = JDBCUtil.getConnection();
            // tao doi tuong statement
            Statement st = con.createStatement();
            // tao 1 cau lenh sql
          String sql = "UPDATE nhasach.book " +
             "SET `bookName` = '" + t.getBookName() + "', " +
             "sellingPrice = " + t.getSellingPrice() + ", " +
             "yearOfPublication = " + t.getYearOfPublication() + " " +
             "WHERE ID = '" + t.getID() + "'";


            int ketQua = st.executeUpdate(sql);
            // B4
            System.out.println("ban da thuc thi : " + sql);
            System.out.println("co " + ketQua + " dong bi thay doi");

            //B5
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
         return 0;
    }

    @Override
    public int delete(Book t) {
                 try {
            // b1 tao conect
            Connection con = JDBCUtil.getConnection();
            // tao doi tuong statement
            Statement st = con.createStatement();
            // tao 1 cau lenh sql
            String sql = "DELETE FROM nhasach.book WHERE ID = '" + t.getID() + "'";


            int ketQua = st.executeUpdate(sql);
            // B4
            System.out.println("ban da thuc thi : " + sql);
            System.out.println("co " + ketQua + " dong bi thay doi");

            //B5
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
         return 0;
    }

    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book> ketQua = new ArrayList<Book>();
            try {
            // b1 tao conect
            Connection con = JDBCUtil.getConnection();
            // tao doi tuong statement
            Statement st = con.createStatement();
            // tao 1 cau lenh sql
            String sql = "SELECT *FROM nhasach.book";


            ResultSet rs = st.executeQuery(sql);
            // B4
            while(rs.next()){
                String ID = rs.getString("ID");
                String bookName = rs.getString("bookName");
                float sellingPrice = rs.getFloat("sellingPrice");
                int yearOfPublication = rs.getInt("yearOfPublication");
                Book book = new Book(ID, bookName, sellingPrice, yearOfPublication);
               ketQua.add(book);
            }
            

            //B5
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
         return ketQua;
    
    }

    @Override
    public Book selectById(Book t) {
       Book ketQua = null;
            try {
            // b1 tao conect
            Connection con = JDBCUtil.getConnection();
            // tao doi tuong statement
            Statement st = con.createStatement();
            // tao 1 cau lenh sql
            String sql = "SELECT * FROM nhasach.book WHERE ID ='"+t.getID()+"'";


            ResultSet rs = st.executeQuery(sql);
            // B4
            while(rs.next()){
                String ID = rs.getString("ID");
                String bookName = rs.getString("bookName");
                float sellingPrice = rs.getFloat("sellingPrice");
                int yearOfPublication = rs.getInt("yearOfPublication");
               ketQua = new Book(ID, bookName, sellingPrice, yearOfPublication);
               
            }
            

            //B5
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
         return ketQua;
    
    }

    @Override
    public ArrayList<Book> selectByCondition(String condition) {
          ArrayList<Book> ketQua = new ArrayList<Book>();
            try {
            // b1 tao conect
            Connection con = JDBCUtil.getConnection();
            // tao doi tuong statement
            Statement st = con.createStatement();
            // tao 1 cau lenh sql
            String sql = "SELECT *FROM nhasach.book WHERE "+condition;


            ResultSet rs = st.executeQuery(sql);
            // B4
            while(rs.next()){
                String ID = rs.getString("ID");
                String bookName = rs.getString("bookName");
                float sellingPrice = rs.getFloat("sellingPrice");
                int yearOfPublication = rs.getInt("yearOfPublication");
                Book book = new Book(ID, bookName, sellingPrice, yearOfPublication);
               ketQua.add(book);
            }
            

            //B5
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
         return ketQua;
    
    }

}
