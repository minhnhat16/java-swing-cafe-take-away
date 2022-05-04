/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class TaiKhoan {
    private String TEN_TK, MAT_KHAU, CHUC_VU;

    public void setCHUC_VU(String CHUC_VU) {
        this.CHUC_VU = CHUC_VU;
    }

    public String getCHUC_VU() {
        return CHUC_VU;
    }

    public void setMAT_KHAU(String MAT_KHAU) {
        this.MAT_KHAU = MAT_KHAU;
    }

    public String getMAT_KHAU() {
        return MAT_KHAU;
    }

    public void setTEN_TK(String TEN_TK) {
        this.TEN_TK = TEN_TK;
    }

    public String getTEN_TK() {
        return TEN_TK;
    }
    
}
