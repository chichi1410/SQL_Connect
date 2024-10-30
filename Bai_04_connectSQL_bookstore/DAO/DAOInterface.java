/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bai_04_connectSQL_bookstore.DAO;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DAOInterface<T>{
    
    public boolean insert(T t);
    
    public boolean update(T t);
    
    public boolean delete(T t);
    
    public ArrayList<T> selectAll();
    
    public T selectById(T t);
    
    public ArrayList<T> selectByCondition(String condition);
}
