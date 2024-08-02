/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThucDon;
import server.KetNoi;

/**
 *
 * @author nghia
 */
public class Dao_ThucDon {

    private static boolean hasForeignKey(int id) {
        String sql = "SELECT COUNT(*) FROM some_table WHERE fk_column = ?";
        Connection c = KetNoi.layKetNoi();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static List<ThucDon> layDSTD() {
        List<ThucDon> list = new ArrayList<>();
        String sql = "select * from thuc_don";
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(new ThucDon(
                        rs.getInt("ma_td"),
                        rs.getString("ten_do_uong"),
                        rs.getInt("gia_tien")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int themThucDon(String ten, int gia) {
        String sql = "insert into thuc_don values(?, ?)";
        Connection c = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = c.prepareCall(sql);
            ps.setString(1, ten);
            ps.setInt(2, gia);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int xoaTD(int id) {
        String sql;
        sql = "delete from thuc_don where ma_td = " + id;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s;
            s = c.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public static int newXoaTD(int id) {
        // Kiểm tra sự tồn tại của khóa ngoại trước khi xóa
        if (hasForeignKey(id)) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.WARNING, "Không thể xóa vì tồn tại khóa ngoại tham chiếu");
            return -1; // Trả về -1 nếu tồn tại khóa ngoại
        }

        String sql = "DELETE FROM thuc_don WHERE ma_td = ?";
        Connection c = KetNoi.layKetNoi();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public static int suaTD(int id, String ten, int gia){
        String sql="update thuc_don set ten_do_uong=?, gia_tien=? where ma_td=?";
        Connection c=KetNoi.layKetNoi();
        try {
            PreparedStatement ps=c.prepareCall(sql);
            ps.setString(1, ten);
            ps.setInt(2, gia);
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static List<ThucDon> layDSTD_ten(String ten){
        System.out.println("tham so "+ten);
        if (ten.equals("")) {
            return null;
        }
        List<ThucDon> list=new ArrayList<>();
        String sql="select * from thuc_don where ten_do_uong like N'%"+ten+"%'";
        Connection c=KetNoi.layKetNoi();
        try {
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sql);
            System.out.println(list);
            while (rs.next()) {                
                list.add(new ThucDon(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                System.out.println(rs.getString(2));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int layMa(String ten){
        String sql="select ma_td from thuc_don where ten_do_uong=N'"+ten+"'";
        Connection con=KetNoi.layKetNoi();
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //theo mã
    public static ThucDon layThucDon_Ma(int maTD){
        ThucDon q=new ThucDon();
        String sql="select * from thuc_don where ma_td="+maTD;
        Connection c=KetNoi.layKetNoi();
        try {
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {                
                q.setId(maTD);
                q.setTen(rs.getString(2));
                q.setGia(rs.getInt(3));
            }
            return q;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean daTonTai(String ten){
        String sql="select * from thuc_don where ten_do_uong='"+ten+"'";
        Connection con=KetNoi.layKetNoi();
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
