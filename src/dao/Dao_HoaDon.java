/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CTHD;
import model.HoaDon;
import server.KetNoi;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author nghia
 */
public class Dao_HoaDon {
    public static int themHD(String maHD, String date, int maNV, int maQuay){
        String sql="insert hoa_don values(?, ?, ?, ?)";
        Connection con=KetNoi.layKetNoi();
        try {
            PreparedStatement ps=con.prepareCall(sql);
            ps.setString(1, maHD);
            ps.setString(2, date);
            ps.setInt(3, maNV);
            ps.setInt(4, maQuay);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static boolean lapHoaDon(String maHD, String date, int maNV, 
            int maQuay, List<CTHD> listCTHD){
        String sql="exec sp_them_hd ?, ?, ?, ?, ?, ?";
        try {
            SQLServerDataTable cthdTable=new SQLServerDataTable();
            cthdTable.addColumnMetadata("ma_hd", java.sql.Types.NCHAR);
            cthdTable.addColumnMetadata("ma_td", java.sql.Types.INTEGER);
            cthdTable.addColumnMetadata("so_luong_ly", java.sql.Types.INTEGER);
            cthdTable.addColumnMetadata("gia_tien", java.sql.Types.INTEGER);
            //thêm dữ liệu vào table
            for (CTHD cthd : listCTHD) {
                cthdTable.addRow(cthd.getMaHD(), cthd.getMaTD(), cthd.getSoLuongLy(), cthd.getGiaTien());
            }
            Connection con=KetNoi.layKetNoi();
            CallableStatement cs=con.prepareCall(sql);
            
            cs.setString(1, maHD);
            cs.setString(2, date);
            cs.setInt(3, maNV);
            cs.setInt(4, maQuay);
            cs.registerOutParameter(6, java.sql.Types.BIT);
            ((SQLServerCallableStatement) cs).setStructured(5, "DS_CTHD", cthdTable);
            
            cs.executeUpdate();
            return cs.getBoolean(6);
        } catch (SQLServerException ex) {
            Logger.getLogger(Dao_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static HoaDon layHoaDon(String maHD){
        String sql="Select * from hoa_don where ma_HD = '"+maHD+"'";
        Connection con=KetNoi.layKetNoi();
        HoaDon hd=new HoaDon();
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
            if (rs.next()) {
                hd.setMaHD(rs.getString(1));
                hd.setNgayTao(rs.getString(2));
                hd.setMaNV(rs.getInt(3));
                hd.setMaQuay(rs.getInt(4));
            }
            return hd;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
