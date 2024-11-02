/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Model;

/**
 *
 * @author Admin
 */
public class Book {
    private String ID;
    private String bookName;
    private float sellingPrice;
    private int yearOfPublication;
    
    public Book(){
        
    }
    public Book(String ID, String bookName, float sellingPrice, int yearOfPublication) {
        this.ID = ID;
        this.bookName = bookName;
        this.sellingPrice = sellingPrice;
        this.yearOfPublication = yearOfPublication;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" + "ID=" + ID + ", book Name=" + bookName + ", selling Price=" + sellingPrice + ", year Of Publication=" + yearOfPublication + '}';
    }
    
    
}
