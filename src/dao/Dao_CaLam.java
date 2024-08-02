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
import model.CaBan;
import server.KetNoi;
import view.formThemNV;
import view.panelDSNV;


public class Dao_CaLam {

    public static int themCaLam(String maCa, String gioBD, String gioKT) {
        Connection connection;
        CallableStatement cs;
        String sp = "exec sp_them_ca ?, ?, ?";
        try {
            connection = KetNoi.layKetNoi();
            cs = connection.prepareCall(sp);
            cs.setString(1, maCa);
            cs.setString(2, gioBD);
            cs.setString(3, gioKT);
            return cs.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(formThemNV.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public static List<CaBan> layDS() {
        List<CaBan> list = new ArrayList<>();
        String sql;
        sql = "select * from Ca_Ban";
        Connection connection;
        connection = KetNoi.layKetNoi();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new CaBan(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3))
                );
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean caDaPhan(String ca) {
        String sql;
        Connection connection;
        Statement s;
        try {
            sql = "select count(ca_ban.ma_ca) from ca_ban inner join ca_nv "
                    + "on ca_ban.ma_ca=ca_nv.ma_ca and ca_ban.ma_ca='" + ca + "'";
            connection = KetNoi.layKetNoi();
            s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            System.out.println(rs.getInt(1));
            return rs.getInt(1) != 0;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static int xoaCa(String ca) {
        String sql = "delete from ca_ban where ma_ca='" + ca + "'";
        Statement s;
        Connection connection;
        connection = KetNoi.layKetNoi();
        try {
            s = connection.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int suaCaBan(String ca, String gioBD, String gioKT) {
        String sql = "update ca_ban set gio_BD='"+gioBD+"', gio_KT='"+gioKT+"' where ma_ca='" + ca + "'";
        Statement s;
        Connection connection;
        connection = KetNoi.layKetNoi();
        try {
            s = connection.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static boolean daTonTai(String maCa){
        String sql="select * from ca_ban where ma_ca='"+maCa+"'";
        try (Connection con = KetNoi.layKetNoi()) {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CaLam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
