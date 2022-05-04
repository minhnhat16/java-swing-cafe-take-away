/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.NhanVien;
import model.CTHD;
import model.HoaDon;
import model.NguyenLieu;
import model.ThucDon;
import model.NhanVienCTTD;
import model.QuayCafe;
import model.TaiKhoan;
import server.KetNoi;
import view.panelLapHD;

/**
 *
 * @author nguye
 */
public class Dao_FormNhanVien {

    private Connection conn;

    public Dao_FormNhanVien() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=CafeTakeAway;" + "username=sa;password=123");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public static NhanVien layThongTinQL(String tenTK) {
        NhanVien nv = new NhanVien();
        String sql = "select ma_nv, ho, ten, dia_chi, sdt, nhan_vien.ten_tk from nhan_vien inner join tai_khoan on nhan_vien.ten_tk=tai_khoan.ten_tk where nhan_vien.ten_tk='" + tenTK + "' and tt_nghi='false'";
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                nv.setMaNV(rs.getInt("ma_nv"));
                nv.setHo(rs.getString("ho"));
                nv.setTen(rs.getString("ten"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTenTK(rs.getString("ten_tk"));
                nv.setTt_nghi(false);
            }
            return nv;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_FormNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addhoaDon(HoaDon hd) {
        String sql = "INSERT INTO HOA_DON(MA_HD, NGAY_TAO, MA_NV, MA_QUAY)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setString(2, hd.getNgayTao());
            ps.setInt(3, hd.getMaNV());
            ps.setInt(4, hd.getMaQuay());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return false;
    }

    public boolean addCTHD(CTHD cthd) {
        String sql = "INSERT INTO CT_HD(MA_HD, MA_TD, SO_LUONG_LY, GIA_TIEN)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cthd.getMaHD());
            ps.setInt(2, cthd.getMaTD());
            ps.setInt(3, cthd.getSoLuongLy());
            ps.setFloat(4, cthd.getGiaTien());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    public ArrayList<NguyenLieu> getListNL() {
        ArrayList<NguyenLieu> list = new ArrayList<>();
        String sql = "SELECT * FROM NGUYEN_LIEU";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguyenLieu nl = new NguyenLieu();
                nl.setMaNL(rs.getInt("MA_NL"));
                nl.setTenNL(rs.getString("TEN_NGUYEN_LIEU"));
                nl.setDonViTinh(rs.getString("DVT"));
                list.add(nl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListHD(String TUNGAY, String DENNGAY) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SET DATEFORMAT dmy\n"
                + "SELECT * FROM HOA_DON\n"
                + "WHERE NGAY_TAO BETWEEN '" + TUNGAY + "'AND '" + DENNGAY + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MA_HD"));
                hd.setNgayTao(rs.getString("NGAY_TAO"));
                hd.setMaNV(rs.getInt("MA_NV"));
                hd.setMaQuay(rs.getInt("MA_QUAY"));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListHDAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM HOA_DON";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MA_HD"));
                hd.setNgayTao(panelLapHD.getDate(rs.getString("NGAY_TAO")));
                hd.setMaNV(rs.getInt("MA_NV"));
                hd.setMaQuay(rs.getInt("MA_QUAY"));

                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<ThucDon> getListTD() {
        ArrayList<ThucDon> list = new ArrayList<>();
        String sql = "SELECT * FROM THUC_DON";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThucDon td = new ThucDon();
                td.setId(rs.getInt("MA_TD"));
                td.setTen(rs.getString("TEN_DO_UONG"));
                td.setGia(rs.getInt("GIA_TIEN"));
                list.add(td);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<QuayCafe> getListQUAYCAFE() {
        ArrayList<QuayCafe> list = new ArrayList<>();
        String sql = "SELECT MA_QUAY FROM QUAY_CAFE order by MA_QUAY asc";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuayCafe quaycafe = new QuayCafe();
                quaycafe.setMa(rs.getInt("MA_QUAY"));
                list.add(quaycafe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<NhanVienCTTD> findListTD(String TENDOUONG) {
        ArrayList<NhanVienCTTD> list = new ArrayList<>();
        String sql = "SELECT TEN_DO_UONG, CT_TD.MA_NL, SO_LUONG_CAN, TEN_NGUYEN_LIEU, DVT  FROM CT_TD, NGUYEN_LIEU, THUC_DON\n"
                + "WHERE CT_TD.MA_NL = NGUYEN_LIEU.MA_NL\n"
                + "AND CT_TD.MA_TD = THUC_DON.MA_TD\n"
                + "AND TEN_DO_UONG = N'" + TENDOUONG + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienCTTD cttd = new NhanVienCTTD();
                cttd.setTENDOUONG(rs.getString("TEN_DO_UONG"));
                cttd.setMANL(rs.getString("MA_NL"));
                cttd.setSOLUONG_CAN(rs.getFloat("SO_LUONG_CAN"));
                cttd.setTENNGUYENLIEU(rs.getString("TEN_NGUYEN_LIEU"));
                cttd.setDVT(rs.getString("DVT"));
                list.add(cttd);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public ThucDon findListTDwith(String TENDOUONG) {
        ThucDon tddk = new ThucDon();
        String sql = "SELECT * FROM THUC_DON\n"
                + "WHERE TEN_DO_UONG = N'" + TENDOUONG + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                tddk.setId(rs.getInt("MA_TD"));
                tddk.setTen(rs.getString("TEN_DO_UONG"));
                tddk.setGia(rs.getInt("GIA_TIEN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tddk;
    }

    public NhanVien getNhanVienTK(String taiKhoan) {
        NhanVien nv = new NhanVien();
        String sql = "SELECT * FROM NHAN_VIEN WHERE TEN_TK = '" + taiKhoan + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setMaNV(rs.getInt("MA_NV"));
                nv.setHo(rs.getString("HO"));
                nv.setTen(rs.getString("TEN"));
                nv.setDiaChi(rs.getString("DIA_CHI"));
                nv.setSdt(rs.getString("SDT"));
                nv.setTt_nghi(rs.getBoolean("TT_NGHI"));
                nv.setTenTK(rs.getString("TEN_TK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public boolean updateNHAN_VIEN(NhanVien nv) {
        String sql;
        sql = "UPDATE NHAN_VIEN \n"
                + "SET HO = N'" + nv.getHo()+ "', TEN = N'" + nv.getTen()+ "', DIA_CHI = N'" + nv.getDiaChi()+ "', SDT = '" + nv.getSdt()+ "' WHERE MA_NV = " + nv.getMaNV();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMATKHAUNV(NhanVien nv, TaiKhoan tk) {
        String sql;
        sql = "UPDATE TAI_KHOAN \n"
                + "SET MAT_KHAU = '" + tk.getMAT_KHAU() + "' WHERE TEN_TK = '" + nv.getTenTK()+ "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public TaiKhoan getTaiKhoan(NhanVien nv) {
        TaiKhoan tk = new TaiKhoan();
        String sql = "SELECT * FROM TAI_KHOAN WHERE TEN_TK = '" + nv.getTenTK()+ "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.setTEN_TK(rs.getString("TEN_TK"));
                tk.setMAT_KHAU(rs.getString("MAT_KHAU"));
                tk.setCHUC_VU(rs.getString("CHUC_VU"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
}
