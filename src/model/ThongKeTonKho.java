/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author D e l l
 */
public class ThongKeTonKho {
    private String TenNL;
    private String DVT;
    private float SoLuongConLai;
    private String AddressQUAY;

    public ThongKeTonKho(String TenNL, String DVT, float SoLuongConLai, String AddressQUAY) {
        this.TenNL = TenNL;
        this.DVT = DVT;
        this.SoLuongConLai = SoLuongConLai;
        this.AddressQUAY = AddressQUAY;
    }

    public String getTenNL() {
        return TenNL;
    }

    public void setTenNL(String TenNL) {
        this.TenNL = TenNL;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public float getSoLuongConLai() {
        return SoLuongConLai;
    }

    public void setSoLuongConLai(float SoLuongConLai) {
        this.SoLuongConLai = SoLuongConLai;
    }

    public String getAddressQUAY() {
        return AddressQUAY;
    }

    public void setAddressQUAY(String AddressQUAY) {
        this.AddressQUAY = AddressQUAY;
    }
    
}
