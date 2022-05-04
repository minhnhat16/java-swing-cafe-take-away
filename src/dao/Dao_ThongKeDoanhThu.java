/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThongKeDoanhThu;
import server.KetNoi;
import view.panelDSNV;



public class Dao_ThongKeDoanhThu {
    
    
    //start , end : search chi phi between start->end 
    //start = null = vo cung be(vd :1/1/0001)
    //end =null = vo cung lon(+vd : 1/1/9999)
    public static List<ThongKeDoanhThu> layDanhSach(java.sql.Date start,java.sql.Date end){
        List<ThongKeDoanhThu> list=new ArrayList<>();
        String sql;
        Connection connection;
        connection = KetNoi.layKetNoi();
        //don't have condition date
        if(start==null&&end==null){
        sql = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        }else if(start == null){
        //don't have start date
        
         sql = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE HOA_DON.NGAY_TAO <='"+String.valueOf(end)+"' and HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        }else if(end == null){
            //don't have end date
             sql = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE HOA_DON.NGAY_TAO >='"+String.valueOf(start)+"' and HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        }else{
        // condition date between start and end
             sql = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE (HOA_DON.NGAY_TAO BETWEEN '"+String.valueOf(start)+"' and '"+String.valueOf(end)+"') and HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
          
        }
      
        Statement statement;
        try {
            System.out.println(sql);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("---200-OK-Doanh--Thu---- ");
            while (rs.next()) {
                System.out.println("--- "+rs.getString(1));
                list.add(new ThongKeDoanhThu(rs.getString(1),rs.getString(2),rs.getString(3)));
               
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

