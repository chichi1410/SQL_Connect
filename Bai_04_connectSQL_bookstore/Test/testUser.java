/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Test;

import Bai_04_connectSQL_bookstore.DAO.UserDAO;
import Bai_04_connectSQL_bookstore.Model.User;

/**
 *
 * @author Admin
 */
public class testUser {
    public static void main(String[] args) {
        // insert
//        User user1 = new User("nguyenhoa", "1234", "nguyen dai hoa");
//        UserDAO.getInstance().insert(user1);
         for(int i=0 ; i<5 ; i++){
              User user1 = new User("nguyenhoa"+i, "1234"+i, "nguyen dai hoa "+i);
              UserDAO.getInstance().insert(user1);
         }

       // update
        User user2 = new User("nguyenhoa", "hoadz1234", "chichi xinh ne");
        UserDAO.getInstance().update(user2);
       
    }
}
