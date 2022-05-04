package model;
import java.io.Serializable;
import java.util.Date;

public class NhanVienCTTD implements Serializable {

    private String TENDOUONG, MANL, TENNGUYENLIEU, DVT;
    private float SOLUONG_CAN;

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getDVT() {
        return DVT;
    }

    public void setMANL(String MANL) {
        this.MANL = MANL;
    }

    public String getMANL() {
        return MANL;
    }

    public void setSOLUONG_CAN(float SOLUONG_CAN) {
        this.SOLUONG_CAN = SOLUONG_CAN;
    }

    public float getSOLUONG_CAN() {
        return SOLUONG_CAN;
    }

    public void setTENDOUONG(String TENDOUONG) {
        this.TENDOUONG = TENDOUONG;
    }

    public String getTENDOUONG() {
        return TENDOUONG;
    }

    public void setTENNGUYENLIEU(String TENNGUYENLIEU) {
        this.TENNGUYENLIEU = TENNGUYENLIEU;
    }

    public String getTENNGUYENLIEU() {
        return TENNGUYENLIEU;
    }
   
}
