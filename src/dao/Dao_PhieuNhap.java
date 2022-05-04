/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.Dao_NguyenLieu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaoPN;
import model.ThongKePhieuNhap;
import server.KetNoi;
import view.panelDSNV;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

/**
 *
 * @author D e l l
 */
public class Dao_PhieuNhap {
     //start , end : search chi phi between start->end 
    //start = null = vo cung be(vd :1/1/0001)
    //end =null = vo cung lon(+vd : 1/1/9999)
    public static List<ThongKePhieuNhap> layDanhSachThongKe(String MA_QUAY,String MA_NV){
        List<ThongKePhieuNhap> list=new ArrayList<>();
        String sql;
        Connection connection;
        connection = KetNoi.layKetNoi();
        //don't have condition
        if(MA_QUAY==null&&MA_NV==null){
        sql = "select PHIEU_NHAP.MA_PN,PHIEU_NHAP.NGAY_NHAP,PHIEU_NHAP.MA_NV,PHIEU_NHAP.MA_QUAY,CT_PN.MA_NL,CT_PN.SO_LUONG_NL,(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as TIEN from PHIEU_NHAP,CT_PN where PHIEU_NHAP.MA_PN=CT_PN.MA_PN";
        }else if(MA_QUAY == null){
        //don't have MA_QUAY 
        
        sql = "select PHIEU_NHAP.MA_PN,PHIEU_NHAP.NGAY_NHAP,PHIEU_NHAP.MA_NV,PHIEU_NHAP.MA_QUAY,CT_PN.MA_NL,CT_PN.SO_LUONG_NL,(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as TIEN from PHIEU_NHAP,CT_PN where PHIEU_NHAP.MA_NV='"+MA_NV+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN";
        
        }else if(MA_NV == null){
            //don't have MA_NV
        sql = "select PHIEU_NHAP.MA_PN,PHIEU_NHAP.NGAY_NHAP,PHIEU_NHAP.MA_NV,PHIEU_NHAP.MA_QUAY,CT_PN.MA_NL,CT_PN.SO_LUONG_NL,(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as TIEN from PHIEU_NHAP,CT_PN where PHIEU_NHAP.MA_QUAY='"+MA_QUAY+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN";
        
        }else{
        // condition MA_NV and MA_QUAY
         sql = "select PHIEU_NHAP.MA_PN,PHIEU_NHAP.NGAY_NHAP,PHIEU_NHAP.MA_NV,PHIEU_NHAP.MA_QUAY,CT_PN.MA_NL,CT_PN.SO_LUONG_NL,(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as TIEN from PHIEU_NHAP,CT_PN where PHIEU_NHAP.MA_QUAY='"+MA_QUAY+"' and PHIEU_NHAP.MA_NV='"+MA_NV+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN";
          
        }
      
        Statement statement;
        try {
            
            System.out.println(sql);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("---200-OK-Phieu - Nhap---- ");
            while (rs.next()) {
                list.add(new ThongKePhieuNhap(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//     public static List<TaoPN> layDanhSachPhieuNhap(){
//        List<TaoPN> list=new ArrayList<>();
//        String sql;
//        Connection connection;
//        connection = KetNoi.layKetNoi();
//      
//        sql = "select NGUYEN_LIEU.MA_NL,NGUYEN_LIEU.TEN_NGUYEN_LIEU,NGUYEN_LIEU.DVT,CT_PN.SO_LUONG_NL,CT_PN.GIA_TIEN from NGUYEN_LIEU,CT_PN where NGUYEN_LIEU.MA_NL=CT_PN.MA_NL";
//      
//       
//        Statement statement;
//        try {
//            
//            System.out.println(sql);
//            statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("---200-OK-Tao phieu nhap---- ");
//            while (rs.next()) {
//                list.add(new TaoPN(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
//            }
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    
    
     //get all ma phieu nhap 
     public static List<TaoPN> layAllMaPhieuNhap(){
        List<TaoPN> list=new ArrayList<>();
        String sql;
        Connection connection;
        connection = KetNoi.layKetNoi();
      
        sql = "select PHIEU_NHAP.MA_PN from PHIEU_NHAP";
      
       
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new TaoPN(rs.getString(1)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     //Them Phieu Nhap
      public static int themPhieuNhap(String MA_PN,String NgayNhap,int MaNV,int MA_QUAY) {
         String sql = "insert into PHIEU_NHAP values(?, ?, ?,?)";
        Connection con = KetNoi.layKetNoi();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,MA_PN );
            ps.setString(2,NgayNhap);
            ps.setInt(3,MaNV);
            ps.setInt(4,MA_QUAY);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
