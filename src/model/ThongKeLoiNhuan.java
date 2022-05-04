/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author D e l l
 */
public class ThongKeLoiNhuan {
    private String MA_QUAY;
    private String NGAY;
    private String LOINHUAN;

    public ThongKeLoiNhuan(String MA_QUAY, String NGAY, String LOINHUAN) {
        this.MA_QUAY = MA_QUAY;
        this.NGAY = NGAY;
        this.LOINHUAN = LOINHUAN;
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

    public String getLOINHUAN() {
        return LOINHUAN;
    }

    public void setLOINHUAN(String LOINHUAN) {
        this.LOINHUAN = LOINHUAN;
    }
    
}
