/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.Dao_NguyenLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.KetNoi;


public class Dao_CTPN {
     public static int themCTPN(String MA_PN,String MA_NL,float SO_LUONG_NL,int GIA_TIEN) {
         String sql = "insert into CT_PN values(?, ?, ?,?)";
        Connection con = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,MA_PN );
            ps.setString(2,MA_NL);
            ps.setFloat(3,SO_LUONG_NL);
            ps.setInt(4,GIA_TIEN);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
