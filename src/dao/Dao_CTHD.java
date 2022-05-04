/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.CTHD;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.KetNoi;

/**
 *
 * @author nghia
 */
public class Dao_CTHD {
    public static List<CTHD> layDS(){
        List<CTHD> list=new ArrayList<>();
        String sql="select * from ct_hd";
        Connection con=KetNoi.layKetNoi();
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {                
                list.add(new CTHD(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CTHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static List<CTHD> layDSTheoMaNV(int maNV){
        List<CTHD> list=new ArrayList<>();
        String sql="SELECT * FROM CT_HD INNER JOIN HOA_DON ON CT_HD.MA_HD=HOA_DON.MA_HD WHERE MA_NV="+maNV;
        Connection con=KetNoi.layKetNoi();
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {                
                list.add(new CTHD(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_CTHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
