/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author D e l l
 */
public class TaoPN {
    String MA_PHIEU_NHAP;
    String MA_NGUYEN_LIEU;
    String TEN_NGUYEN_LIEU;
    String D_VI;
    String NGAY_NHAP;
    int MA_NV;
    int MA_QUAY;
    int SO_LUONG;
    int PRICE;

    public TaoPN(String MA_PHIEU_NHAP,String MA_NGUYEN_LIEU, String TEN_NGUYEN_LIEU, String D_VI, int SO_LUONG, int PRICE,int MA_NV,int MA_QUAY,String NGAY_NHAP) {
        this.MA_PHIEU_NHAP=MA_PHIEU_NHAP;
        this.MA_NGUYEN_LIEU = MA_NGUYEN_LIEU;
        this.TEN_NGUYEN_LIEU = TEN_NGUYEN_LIEU;
        this.D_VI = D_VI;
        this.SO_LUONG = SO_LUONG;
        this.PRICE = PRICE;
        this.MA_NV=MA_NV;
        this.MA_QUAY=MA_QUAY;
        this.NGAY_NHAP=NGAY_NHAP;
    }
    public TaoPN(String MA_NGUYEN_LIEU, String TEN_NGUYEN_LIEU, String D_VI, int SO_LUONG, int PRICE) {
        this.MA_NGUYEN_LIEU = MA_NGUYEN_LIEU;
        this.TEN_NGUYEN_LIEU = TEN_NGUYEN_LIEU;
        this.D_VI = D_VI;
        this.SO_LUONG = SO_LUONG;
        this.PRICE = PRICE;
    }
    public TaoPN(String MA_PHIEU_NHAP){
        this.MA_PHIEU_NHAP=MA_PHIEU_NHAP;
    }
    public String getNGAY_NHAP() {
        return NGAY_NHAP;
    }

    public int getMA_NV() {
        return MA_NV;
    }

    public int getMA_QUAY() {
        return MA_QUAY;
    }
    
    public String getMA_PHIEU_NHAP() {
        return MA_PHIEU_NHAP;
    }

    public void setMA_PHIEU_NHAP(String MA_PHIEU_NHAP) {
        this.MA_PHIEU_NHAP = MA_PHIEU_NHAP;
    }
    
    public String getMA_NGUYEN_LIEU() {
        return MA_NGUYEN_LIEU;
    }

    public void setMA_NGUYEN_LIEU(String MA_NGUYEN_LIEU) {
        this.MA_NGUYEN_LIEU = MA_NGUYEN_LIEU;
    }

    public String getTEN_NGUYEN_LIEU() {
        return TEN_NGUYEN_LIEU;
    }

    public void setTEN_NGUYEN_LIEU(String TEN_NGUYEN_LIEU) {
        this.TEN_NGUYEN_LIEU = TEN_NGUYEN_LIEU;
    }

    public String getD_VI() {
        return D_VI;
    }

    public void setD_VI(String D_VI) {
        this.D_VI = D_VI;
    }

    public int getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(int SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }
}
