/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author D e l l
 */
public class ThongKeDoanhThu {
    private String MA_QUAY;
    private String NGAY;
    private String DOANHTHU;

    public ThongKeDoanhThu(String MA_QUAY, String NGAY, String DOANHTHU) {
        this.MA_QUAY = MA_QUAY;
        this.NGAY = NGAY;
        this.DOANHTHU = DOANHTHU;
    }

    public String getMA_QUAY() {
        return MA_QUAY;
    }

    public void setMA_QUAY(String MA_QUAY) {
        this.MA_QUAY = MA_QUAY;
    }

    public String getNGAY() {
        return NGAY;
    }

    public void setNGAY(String NGAY) {
        this.NGAY = NGAY;
    }

    public String getDOANHTHU() {
        return DOANHTHU;
    }

    public void setDOANHTHU(String DOANHTHU) {
        this.DOANHTHU = DOANHTHU;
    }
    
}
