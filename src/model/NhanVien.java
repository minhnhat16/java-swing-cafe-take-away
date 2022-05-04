/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nghia
 */
public class NhanVien {
    private int maNV;
    private String ho;
    private String ten;
    private String diaChi;
    private String sdt;
    private boolean tt_nghi;
    private String tenTK;
    //theo lý là có list model hóa đơn
    //mà nên làm theo kiểu thuộc tính đầu nhiều chứa field là 1 thuộc tính bình thường

    public NhanVien(int maNV, String ho, String ten, String diaChi, String sdt, boolean tt_nghi, String tenTK) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tt_nghi = tt_nghi;
        this.tenTK = tenTK;
    }

    public NhanVien() {
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isTt_nghi() {
        return tt_nghi;
    }

    public void setTt_nghi(boolean tt_nghi) {
        this.tt_nghi = tt_nghi;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }
 
}
