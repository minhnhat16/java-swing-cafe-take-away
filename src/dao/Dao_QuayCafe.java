/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import server.KetNoi;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuayCafe;
import view.formThemQuay;

/**
 *
 * @author nghia
 */
public class Dao_QuayCafe {

    public static int themQuay(String duong, String kp, String phuong, String quan, String tp, int giaTien) {
        String sql = "insert into quay_cafe values(?,?,?,?,?,?,?)";
        Connection con = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, duong);
            ps.setString(2, kp);
            ps.setString(3, phuong);
            ps.setString(4, quan);
            ps.setString(5, tp);
            ps.setInt(6, giaTien);
            ps.setBoolean(7, true);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static List<QuayCafe> layDSQuay() {
        List<QuayCafe> list = new ArrayList<>();
        String sql;
        sql = "select * from quay_cafe where tt_hd = 'true'";
        Connection connection;
        connection = KetNoi.layKetNoi();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new QuayCafe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8)
                )
                );
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(formThemQuay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int xoaQuay(int ma) {
        String sql = "delete from Quay_cafe where ma_quay = " + ma;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int suaQuay(int ma, String duong, String kp, String phuong,
            String quan, String tp, int giaTien, boolean tt_hd) {
        String sql = "update quay_cafe set duong=?, khu_pho=?, phuong=?, quan=?, tinh_tp=?, gia_tien=?, tt_hd=? where ma_quay=" + ma;
        Connection c = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = c.prepareCall(sql);
            ps.setString(1, duong);
            ps.setString(2, kp);
            ps.setString(3, phuong);
            ps.setString(4, quan);
            ps.setString(5, tp);
            ps.setInt(6, giaTien);
            ps.setBoolean(7, tt_hd);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static QuayCafe layQuay(int maQuay) {
        QuayCafe q = new QuayCafe();
        String sql = "select * from quay_cafe where ma_quay=" + maQuay;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                q.setMa(maQuay);
                q.setDuong(rs.getString("duong"));
                q.setKp(rs.getString("khu_pho"));
                q.setPhuong(rs.getString("phuong"));
                q.setQuan(rs.getString("quan"));
                q.setTp(rs.getString("tinh_tp"));
            }
            return q;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<String> layDSDuong(String column) {
        List<String> list = new ArrayList<>();
        String sql;
        sql = "select distinct " + column + " from quay_cafe";
        Connection connection;
        connection = KetNoi.layKetNoi();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(formThemQuay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean daTonTai(String duong, String kp, String phuong, String quan, String tp) {
        String sql = "select * from quay_cafe where duong=? and khu_pho=? and phuong=? and quan=? and tinh_tp=? and tt_hd = 'true'";
        try (Connection con = KetNoi.layKetNoi()) {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, duong);
            ps.setString(2, kp);
            ps.setString(3, phuong);
            ps.setString(4, quan);
            ps.setString(5, tp);
            ResultSet rs = ps.executeQuery();
            boolean r = rs.next();
            System.out.println("quay da ton tai " + r);
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaLam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
