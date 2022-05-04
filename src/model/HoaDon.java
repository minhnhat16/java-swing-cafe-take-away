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
public class HoaDon {

    private String maHD;
    private String ngayTao;
    private int maNV;
    private int maQuay;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaQuay() {
        return maQuay;
    }

    public void setMaQuay(int maQuay) {
        this.maQuay = maQuay;
    }
    public static void main(String[] args) {
        HoaDon f=new HoaDon();
        System.out.println(f.getMaHD());
    }
}
