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
public class QuayCafe {
    private int ma;
    private String duong;
    private String kp;
    private String phuong;
    private String quan;
    private String tp;
    private int giaTien;
    private boolean tt_hd;

    public QuayCafe(int ma, String duong, String kp, String phuong, String quan, String tp, int giaTien, boolean tt_hd) {
        this.ma = ma;
        this.duong = duong;
        this.kp = kp;
        this.phuong = phuong;
        this.quan = quan;
        this.tp = tp;
        this.giaTien = giaTien;
        this.tt_hd = tt_hd;
    }

    public QuayCafe() {
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public boolean isTt_hd() {
        return tt_hd;
    }

    public void setTt_hd(boolean tt_hd) {
        this.tt_hd = tt_hd;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }
}
