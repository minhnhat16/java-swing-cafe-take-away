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
public class CTHD {
    private String maHD;
    private int maTD;
    private int soLuongLy;
    private int giaTien;

    public CTHD() {
    }

    public CTHD(String maHD, int maTD, int soLuongLy, int giaTien) {
        this.maHD = maHD;
        this.maTD = maTD;
        this.soLuongLy = soLuongLy;
        this.giaTien = giaTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getMaTD() {
        return maTD;
    }

    public void setMaTD(int maTD) {
        this.maTD = maTD;
    }

    public int getSoLuongLy() {
        return soLuongLy;
    }

    public void setSoLuongLy(int soLuongLy) {
        this.soLuongLy = soLuongLy;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }   
}
