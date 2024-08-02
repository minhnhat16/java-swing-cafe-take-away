/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import server.KetNoi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CTTD;

public class Dao_CTTD {
    public static int themCTTD(int maTD, int maNL, float slCan){
        String sql="insert into ct_td values(?, ?, ?)";
        Connection con=KetNoi.layKetNoi();
        try {
            PreparedStatement ps=con.prepareCall(sql);
            ps.setInt(1, maTD);
            ps.setInt(2, maNL);
            ps.setFloat(3, slCan);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CTTD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static List<CTTD> layDS(){
        List<CTTD> list = new ArrayList<>();
        String sql = "select * from ct_td";
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(new CTTD(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThucDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean ktTonTai(int maTD, int maNL){
        String sql="select * from CT_TD where ma_td=? and ma_nl=?";
        Connection con=KetNoi.layKetNoi();
        try {
            PreparedStatement ps=con.prepareCall(sql);
            ps.setInt(1, maTD);
            ps.setInt(2, maNL);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CTTD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static int xoaCTTD(int maTD, int maNL){
        String sql;
        sql = "delete from ct_td where ma_td ="+maTD+" and ma_nl="+maNL;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s;
            s = c.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int suaCTTD(int maTD, int maNL, float slCan){
        String sql;
        sql = "update ct_td set so_luong_can="+slCan+" where ma_td ="+maTD+" and ma_nl="+maNL;
        Connection c = KetNoi.layKetNoi();
        try {
            Statement s;
            s = c.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_QuayCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
