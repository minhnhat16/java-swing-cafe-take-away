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
public class CaNhanVien {
    private int id;
    private int maNV;
    private String maCa;
    private String ngay;
    private int maQuay;

    public CaNhanVien(int maNV, String maCa, String ngay, int maQuay) {
        this.maNV = maNV;
        this.maCa = maCa;
        this.ngay = ngay;
        this.maQuay = maQuay;
    }

    public CaNhanVien() {
    }

    public CaNhanVien(int id, int maNV, String maCa, String ngay, int maQuay) {
        this.id = id;
        this.maNV = maNV;
        this.maCa = maCa;
        this.ngay = ngay;
        this.maQuay = maQuay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getMaQuay() {
        return maQuay;
    }

    public void setMaQuay(int maQuay) {
        this.maQuay = maQuay;
    }
}
