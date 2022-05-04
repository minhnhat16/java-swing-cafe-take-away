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
public class CTTD {
    private int maTD;
    private int maNL;
    private float soLuongCan;

    public CTTD(int maTD, int maNL, float soLuongCan) {
        this.maTD = maTD;
        this.maNL = maNL;
        this.soLuongCan = soLuongCan;
    }

    public CTTD() {
    }

    public int getMaTD() {
        return maTD;
    }

    public void setMaTD(int maTD) {
        this.maTD = maTD;
    }

    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
    }

    public float getSoLuongCan() {
        return soLuongCan;
    }

    public void setSoLuongCan(float soLuongCan) {
        this.soLuongCan = soLuongCan;
    }

}
