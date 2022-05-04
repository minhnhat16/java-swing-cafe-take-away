/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import server.KetNoi;
import view.formThemNV;
import view.panelDSNV;

/**
 *
 * @author nghia
 */
public class Dao_NhanVien {
    public static int themNhanVien(String ho, String ten, String sdt,
            String diaChi, String taiKhoan, String matKhau) {
        Connection connection;
        CallableStatement cs;
        String sp = "exec sp_them_nhan_vien ?, ?, ?, ?, ?, ?, ?";
        try {
            connection = KetNoi.layKetNoi();
            cs = connection.prepareCall(sp);
            cs.setString(1, ho);
            cs.setString(2, ten);
            cs.setString(3, diaChi);
            cs.setString(4, sdt);
            cs.setString(5, taiKhoan);
            cs.setString(6, matKhau);
            cs.setString(7, "NV");
            
            return cs.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(formThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
    public static int suaNhanVien(int maNV, String ho, String ten, String diaChi,
            String sdt, boolean tt_nghi, String matKhau) {
        Connection connection;
        CallableStatement cs;
        String sp = "exec sp_sua_nhan_vien ?, ?, ?, ?, ?, ?, ?";
        try {
            connection = KetNoi.layKetNoi();
            cs = connection.prepareCall(sp);
            cs.setInt(1, maNV);
            cs.setString(2, ho);
            cs.setString(3, ten);
            cs.setString(4, diaChi);
            cs.setString(5, sdt);
            cs.setBoolean(6, tt_nghi);
            cs.setString(7, matKhau);
            
            return cs.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(formThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
    public static boolean xoaNhanVien(int maNV) {
        String sql = "exec sp_xoa_nhan_vien ?, ?";
        CallableStatement cs;
        Connection connection;
        connection = KetNoi.layKetNoi();
        try {
            cs = connection.prepareCall(sql);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.setInt(1, maNV);
            cs.executeUpdate();
//            System.out.println(cs.getInt(2));
            return cs.getInt(2) == 1;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static List<NhanVien> layDanhSach(){
        List<NhanVien> list=new ArrayList<>();
        String sql;
        sql = "select MA_NV, HO, TEN, DIA_CHI, SDT, TT_NGHI, TEN_TK from NHAN_VIEN WHERE TEN_TK != 'ADMIN' and tt_nghi = 'false'";
        Connection connection;
        connection = KetNoi.layKetNoi();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new NhanVien(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getString(7)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static NhanVien layDuLieuTuBang(int maNV){
        NhanVien nv = new NhanVien();
        String sql = "select * from Nhan_Vien where ma_nv=" + maNV + "and tt_nghi = 0";
        try {
            Connection con = KetNoi.layKetNoi();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                nv.setMaNV(r.getInt(1));
                nv.setHo(r.getString(2));
                nv.setTen(r.getString(3));
                nv.setDiaChi(r.getString(4));
                nv.setSdt(r.getString(5));
//                nv.setTt_nghi(r.getBoolean(6));
//                System.out.println("toi day");
//                System.out.println(r.getBoolean(6));
                
                if(r.getBoolean(6)){
                    nv.setTt_nghi(true);
                }else{
                    nv.setTt_nghi(false);
                }
//                System.out.println("Towis day");
                nv.setTenTK(r.getString(7));
            }
            return nv;
        } catch (SQLException ex) {
            
        }
        return nv;
    }
    
    public static List<NhanVien> timKiemNhanVien(String ten){
        List<NhanVien> list=new ArrayList<>();
        String sql="exec sp_tim_kiem_nhan_vien_theo_ten ?";
        CallableStatement cs;
        Connection connection;
        connection = KetNoi.layKetNoi();
        try {
            cs = connection.prepareCall(sql);
            cs.setString(1, ten);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                    list.add(new NhanVien(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getString(7)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static NhanVien layNhanVien(int manv){
        NhanVien nv=new NhanVien();
        String sql="select * from nhan_vien where ma_nv="+manv+" and ten_tk != 'admin'";
        Connection c=KetNoi.layKetNoi();
        try {
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {                
                nv.setMaNV(manv);
                nv.setHo(rs.getString("ho"));
                nv.setTen(rs.getString("ten"));
            }
            return nv;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean kiemTraTonTai(int maNV, boolean admin){
        String sql;
        sql = "select MA_NV, HO, TEN, DIA_CHI, SDT, TT_NGHI, TEN_TK from NHAN_VIEN WHERE tt_nghi = 'false' and ma_nv="+maNV;
        if (!admin) {
            sql = sql.concat(" and TEN_TK != 'ADMIN'");
        }
//        System.out.println(sql);
        Connection connection;
        connection = KetNoi.layKetNoi();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("Truy Vấn Có? "+rs.next());
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static NhanVien layThongTinQL(String tenTK){
        NhanVien nv=new NhanVien();
        String sql="select ma_nv, ho, ten, dia_chi, sdt, nhan_vien.ten_tk from nhan_vien inner join tai_khoan on nhan_vien.ten_tk=tai_khoan.ten_tk where nhan_vien.ten_tk='"+tenTK+"' and tt_nghi='false'";
        Connection c=KetNoi.layKetNoi();
        try {
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {                
                nv.setMaNV(rs.getInt("ma_nv"));
                nv.setHo(rs.getString("ho"));
                nv.setTen(rs.getString("ten"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTenTK(rs.getString("ten_tk"));
                nv.setTt_nghi(false);
            }
//            System.out.println("Đang lấy thông tin quản lý "+nv.getTenTK());
            return nv;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //không dùng
    public static boolean SDTDaTonTai(String sdt){
        String sql="select * from nhan_vien where sdt='"+sdt+"'";
        try (Connection con = KetNoi.layKetNoi()) {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaLam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean taiKhoanDaTonTai(String tk){
        String sql="select * from nhan_vien where ten_tk='"+tk+"'";
        try (Connection con = KetNoi.layKetNoi()) {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaLam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static int suaQuanLy(int maNV, String ho, String ten, String diaChi,
            String sdt, String matKhau){
        Connection connection;
        CallableStatement cs;
        String sp = "exec sp_sua_quan_ly ?, ?, ?, ?, ?, ?";
        try {
            connection = KetNoi.layKetNoi();
            cs = connection.prepareCall(sp);
            cs.setInt(1, maNV);
            cs.setString(2, ho);
            cs.setString(3, ten);
            cs.setString(4, diaChi);
            cs.setString(5, sdt);
            cs.setString(6, matKhau);
            
            return cs.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(formThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
    public static boolean dungMK(String tk, String mk){
        String sql;
        sql = "select * from tai_khoan where ten_tk='"+tk+"' and mat_khau='"+mk+"'";
        Connection connection;
        connection = KetNoi.layKetNoi();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("Truy Vấn Có? "+rs.next());
            return rs.next(); //true nếu đúng
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
