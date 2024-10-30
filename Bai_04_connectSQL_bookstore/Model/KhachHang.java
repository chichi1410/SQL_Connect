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
    private Date ngaySinh;
    private String address; 

    public KhachHang(int ID, String fullName, Date ngaySinh, String address) {
        this.ID = ID;
        this.fullName = fullName;
        this.ngaySinh = ngaySinh;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
