/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_jdbc.Test;


import connect_jdbc.Database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class test {

    public static void main(String[] args) {

        try {
            // B1 tao ket noi
            Connection connection = JDBCUtil.getConnection();
            System.out.println(connection);

            // B2 tao doi tuong statement
            Statement st = connection.createStatement();

            //B3 thực thi 1 câu lệnh sql
            String sql = "INSERT INTO nguoiDung (tenNguoiDung , matKhau , theLoai , maSinhVien, maNhanVien) "
                    + "VALUES (\"chichi \" , \"0984\" , \"Sinh Vien\" ,4,3);";

            int check = st.executeUpdate(sql);

            //B4 xu ly ket qua
            System.out.println("so dong thay doi : " + check);
            if (check > 0) {
                System.out.println("add data success");
            } else {
                System.out.println("add data false");
            }

            // B5 ngat ket noi
            JDBCUtil.closeConnection(connection);
            System.out.println(connection);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
