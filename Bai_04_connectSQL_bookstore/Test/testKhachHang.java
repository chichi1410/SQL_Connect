/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Test;

import Bai_04_connectSQL_bookstore.DAO.KhachHangDAO;
import java.util.ArrayList;
import Bai_04_connectSQL_bookstore.Model.KhachHang;
import Bai_04_connectSQL_bookstore.Model.Book;
import Bai_04_connectSQL_bookstore.DAO.BookDAO;

/**
 *
 * @author Admin
 */
public class testKhachHang {
    public static void main(String[] args) {
     ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
        for (KhachHang KH : list) {
            System.out.println(KH.toString());
        }
             
    }
}
