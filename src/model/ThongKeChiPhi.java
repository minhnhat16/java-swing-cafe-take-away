/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author D e l l
 */
public class ThongKeChiPhi {
    private String MA_QUAY;
    private String NGAY;
    private String CHIPHI;

    public ThongKeChiPhi(String MA_QUAY, String NGAY, String CHIPHI) {
        this.MA_QUAY = MA_QUAY;
        this.NGAY = NGAY;
        this.CHIPHI = CHIPHI;
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

    public String getCHIPHI() {
        return CHIPHI;
    }

    public void setCHIPHI(String CHIPHI) {
        this.CHIPHI = CHIPHI;
    }
    
}
