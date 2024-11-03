/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Test;

import Bai_04_connectSQL_bookstore.DAO.UserDAO;
import Bai_04_connectSQL_bookstore.Model.User;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class testUser {
    public static void main(String[] args) {
        // insert
//        User user1 = new User("nguyenhoa", "1234", "nguyen dai hoa");
//        UserDAO.getInstance().insert(user1);
         for(int i=0 ; i<10 ; i++){
              User user1 = new User("nguyenhoa"+i, "1234"+i, "nguyen dai hoa "+i);
              UserDAO.getInstance().insert(user1);
         }

       // update
        User user2 = new User("nguyenhoa", "hoadz123", "chichine");
        UserDAO.getInstance().update(user2);
            
        // delete
        
//        for(int i=0 ; i<10 ; i++){
//            User user3 = new User("nguyenhoa"+i, "hoadz123", "chichi xinh ne");
//            UserDAO.getInstance().delete(user3);
//        }
        // select all
        System.out.println("--------------------------------------");
        System.out.println("------------select all user-----------");
          ArrayList<User> list= UserDAO.getInstance().selectAll();
          for (User get : list) {
              System.out.println(get.toString());
        }
       
        // find by username
        System.out.println("------------------------------------------------");
        System.out.println("find full name = username");
        User find = new User();
        find.setUserName("nguyenhoa0");
        
        User userfind = UserDAO.getInstance().selectById(find);
        System.out.println(userfind);
        
        // fint co dieu kien
        System.out.println("------------------------------------------------");
        System.out.println("tim user voi dieu kien password = 12341");
        ArrayList<User> findCondition = UserDAO.getInstance().selectByCondition("password = 12341");
        for (User user : findCondition) {
            System.out.println(user.toString());
        }
    }
}
