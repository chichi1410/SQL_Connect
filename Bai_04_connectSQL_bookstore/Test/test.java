/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Test;

import Bai_04_connectSQL_bookstore.DAO.BookDAO;
import Bai_04_connectSQL_bookstore.DAO.KhachHangDAO;
import Bai_04_connectSQL_bookstore.Database.JDBC_Database;
import Bai_04_connectSQL_bookstore.Model.Book;
import Bai_04_connectSQL_bookstore.Model.KhachHang;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class test {
    public static Date chuyenChuoi(String chuoi){
            try {
            return new SimpleDateFormat().parse(chuoi);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
        }
    public static void main(String[] args) {


          Book book8 = new Book("6757", "khai loc xoay", 100, 1998);
//          Book book1 = new Book("6576", "tam quoc chi", 100, 1998);
//          
        BookDAO.getInstance().insert(book8);
//          BookDAO.getInstance().insert(book1);
//          Book book3 = new Book("2323", "tay du ky", 100, 1890);
//          update sách
 //         BookDAO.getInstance().update(book8);
//          xoá sách
//          BookDAO.getInstance().delete(book1);

            // lấy toàn bộ sách ra
            ArrayList<Book> list = BookDAO.getInstance().selectAll();
            for (Book book : list) {
                System.out.println(book.toString());
            }
            
            System.out.println(" ----------------------------");
            // tìm kiếm sách có id 
            Book fint = new Book();
            fint.setID("2323");
            Book bookFint = BookDAO.getInstance().selectById(fint);
            System.out.println(bookFint);
            
            System.out.println(" ---------------------------");
              ArrayList<Book> list1 = BookDAO.getInstance().selectByCondition("sellingPrice > 40");
            for (Book book : list1) {
                System.out.println(book.toString());             
            }
           
            ////////
         

    }
}
