/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04_connectSQL_bookstore.Model;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class KhachHang {
    private int ID;
    private String fullName;
    private Date dateOfBirth;
    private String address; 

    public KhachHang(int ID, String fullName, Date dateOfBirth, String address) {
        this.ID = ID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public KhachHang() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //

    @Override
    public String toString() {
        return "KhachHang{" + "ID=" + ID + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", address=" + address + '}';
    }
    
}
