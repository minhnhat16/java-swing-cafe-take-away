/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author D e l l
 */
public class ThongKePhieuNhap {
    private String MA_PHIEU_NHAP;
    private String NGAY_NHAP;
    private String MA_NHAN_VIEN;
    private String MA_QUAY;
    private String MA_NGUYEN_LIEU;
    private String SO_LUONG;
    private String GIA_TIEN;

    public ThongKePhieuNhap(String MA_PHIEU_NHAP, String NGAY_NHAP, String MA_NHAN_VIEN, String MA_QUAY, String MA_NGUYEN_LIEU, String SO_LUONG, String GIA_TIEN) {
        this.MA_PHIEU_NHAP = MA_PHIEU_NHAP;
        this.NGAY_NHAP = NGAY_NHAP;
        this.MA_NHAN_VIEN = MA_NHAN_VIEN;
        this.MA_QUAY = MA_QUAY;
        this.MA_NGUYEN_LIEU = MA_NGUYEN_LIEU;
        this.SO_LUONG = SO_LUONG;
        this.GIA_TIEN = GIA_TIEN;
    }

    public String getMA_PHIEU_NHAP() {
        return MA_PHIEU_NHAP;
    }

    public void setMA_PHIEU_NHAP(String MA_PHIEU_NHAP) {
        this.MA_PHIEU_NHAP = MA_PHIEU_NHAP;
    }

    public String getNGAY_NHAP() {
        return NGAY_NHAP;
    }

    public void setNGAY_NHAP(String NGAY_NHAP) {
        this.NGAY_NHAP = NGAY_NHAP;
    }

    public String getMA_NHAN_VIEN() {
        return MA_NHAN_VIEN;
    }

    public void setMA_NHAN_VIEN(String MA_NHAN_VIEN) {
        this.MA_NHAN_VIEN = MA_NHAN_VIEN;
    }

    public String getMA_QUAY() {
        return MA_QUAY;
    }

    public void setMA_QUAY(String MA_QUAY) {
        this.MA_QUAY = MA_QUAY;
    }

    public String getMA_NGUYEN_LIEU() {
        return MA_NGUYEN_LIEU;
    }

    public void setMA_NGUYEN_LIEU(String MA_NGUYEN_LIEU) {
        this.MA_NGUYEN_LIEU = MA_NGUYEN_LIEU;
    }

    public String getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(String SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }

    public String getGIA_TIEN() {
        return GIA_TIEN;
    }

    public void setGIA_TIEN(String GIA_TIEN) {
        this.GIA_TIEN = GIA_TIEN;
    }
}
