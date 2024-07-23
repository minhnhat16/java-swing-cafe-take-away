/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.NguyenLieu;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.KetNoi;
/**
 *
 * @author nghia
 */
public class Dao_NguyenLieu {
    public static Dao_NguyenLieu instance;
    //lấy ds
    public static List<NguyenLieu> layDS(){
        List<NguyenLieu> list=new ArrayList<>();
        String sql="select * from nguyen_lieu";
        Connection conn=KetNoi.layKetNoi();
        try {
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {                
                list.add(new NguyenLieu(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static NguyenLieu layNL(String ten){
        NguyenLieu nl=new NguyenLieu();
        String sql="select * from nguyen_lieu where ten_nguyen_lieu=N'"+ten+"'";
        Connection con=KetNoi.layKetNoi();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {                
                nl.setMaNL(rs.getInt(1));
                nl.setTenNL(rs.getString(2));
                nl.setDonViTinh(rs.getString(3));
            }
            return nl;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static NguyenLieu layNL(int maNL){
        NguyenLieu nl=new NguyenLieu();
        String sql="select * from nguyen_lieu where ma_NL="+maNL;
        Connection con=KetNoi.layKetNoi();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {                
                nl.setMaNL(rs.getInt(1));
                nl.setTenNL(rs.getString(2));
                nl.setDonViTinh(rs.getString(3));
            }
            return nl;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Trí
    public static List<NguyenLieu> layNLTheoTen(String ten){
        List<NguyenLieu> list = new ArrayList<>();
        String sql = "select * from nguyen_lieu where TEN_NGUYEN_LIEU=N'"+ten+"'";
        Connection con = KetNoi.layKetNoi();
        try {
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                list.add(new NguyenLieu(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //sửa nguyên liệu
    public static int suaNL(String nl, String ten_NL, String donViTinh){
        String sql="update nguyen_lieu set ten_nguyen_lieu=?, DVT=? where ma_NL=?";
        Connection c=KetNoi.layKetNoi();
        try {
            PreparedStatement ps=c.prepareCall(sql);
            ps.setString(1, ten_NL );
            ps.setString(2, donViTinh);
            ps.setString(3, nl);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //xoá nguyên liệu theo ma_NL
    public static int xoaNL(int nl ) {
        String sql;
        sql = "delete from nguyen_lieu where ma_NL = " + nl;
        Connection con = KetNoi.layKetNoi();
        try {
            Statement s;
            s = con.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //thêm nguyên liệu
    public static int luuNguyenLieu(String tenNL, String donViTinh){
        CallableStatement cs;
        String sql = "insert into nguyen_lieu values(?, ?)";
        Connection con = KetNoi.layKetNoi();
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, tenNL);
            cs.setString(2, donViTinh);
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static boolean IsMaNguyenLieuExists(Integer maNL){
        NguyenLieu nl=new NguyenLieu();
        String sql="select * from nguyen_lieu where ma_NL="+maNL;
        Connection con=KetNoi.layKetNoi();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {
                nl.setMaNL(rs.getInt(1));
                nl.setTenNL(rs.getString(2));
                nl.setDonViTinh(rs.getString(3));
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false    ;
    }
}
