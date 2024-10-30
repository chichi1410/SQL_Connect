/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Test;

import Bai_04_connectSQL_bookstore.Database.JDBC_Database;
import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        
        try {
            // b1 tao connect
             Connection connection = JDBC_Database.getConnection();
             // b2  tao doi tuong statement
             Statement st = connection.createStatement();
             // b3 thuc thi cau lenh SQL 
             String sql = "  ";
             int check = st.executeUpdate(sql);
             // B4 xu ly ket qua
             System.out.println("so dong thay doi : " + check);
             if(check > 0){
                 System.out.println("add data success");
             }else{
                 System.out.println("add false");
             }
             
        } catch (Exception e) {
        }
    }
}
