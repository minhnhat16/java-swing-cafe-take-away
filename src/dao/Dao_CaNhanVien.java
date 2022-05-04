/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CaNhanVien;
import server.KetNoi;

/**
 *
 * @author nghia
 */
public class Dao_CaNhanVien {

    public static int themCaNhanVien(int maNV, String maCa, String thu, int maQuay) {
        String sql = "insert into ca_nv values(?,?,?,?)";
        Connection c = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = c.prepareCall(sql);
            ps.setInt(1, maNV);
            ps.setString(2, maCa);
            ps.setString(3, thu);
            ps.setInt(4, maQuay);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static List<CaNhanVien> layDSCaNV(int maQuay) {
        List<CaNhanVien> list = new ArrayList<>();
        String sql = "select ma_nv, ma_ca, thu, ma_quay from ca_nv where ma_quay=" + maQuay;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(new CaNhanVien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int xoaCaNhanVien(String thu, String maCa, int maNV) {
        String sql = "Delete from CA_NV where ma_ca='" + maCa + "' and thu = '" + thu + "' and ma_nv=" + maNV;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int layID(String thu, String maCa, int maNV) {
        String sql = "Select ID from CA_NV where ma_ca='" + maCa + "' and thu = '" + thu + "' and ma_nv=" + maNV;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int capNhatCaNV(int id, String thu, String maCa, int maNV) {
        System.out.println(id);
        System.out.println(thu);
        System.out.println(maCa);
        System.out.println(maNV);
        String sql = "update ca_nv set thu=?, ma_ca=?, ma_nv=? where id=?";
        Connection c = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = c.prepareCall(sql);
            ps.setString(1, thu);
            ps.setString(2, maCa);
            ps.setInt(3, maNV);
            ps.setInt(4, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static boolean daTonTai(int maNV, String maCa, String thu) {
        String sql = "select * from ca_nv where ma_nv=? and ma_ca=? and thu=?";
        Connection con = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, maNV);
            ps.setString(2, maCa);
            ps.setString(3, thu);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CTTD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
