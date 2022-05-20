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
import model.ThongKeLoiNhuan;
import server.KetNoi;
import view.panelDSNV;



public class Dao_ThongKeLoiNhuan {
    
    
    //start , end : search chi phi between start->end 
    //start = null = vo cung be(vd :1/1/0001)
    //end =null = vo cung lon(+vd : 1/1/9999)
    //idea:sqldoanhthu( lấy doanh thu ) sqlchiphi (lấy chi phí) , sqlloinhuan: ghép sqldoanhthu và sqlloinhuan theo quầy và ngày(doanhthu) (doanhthu-chiphi)
    public static List<ThongKeLoiNhuan> layDanhSach(java.sql.Date start,java.sql.Date end){
        List<ThongKeLoiNhuan> list=new ArrayList<>();
        String sqldoanhthu="",sqlchiphi="",sqlloinhuan="";
        Connection connection;
        connection = KetNoi.layKetNoi();
        //don't have condition date
        if(start==null&&end==null){
        sqldoanhthu = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        sqlchiphi = "select sum(cpt.chiphi) as chiphi,cpt.MA_QUAY from( select PHIEU_NHAP.MA_QUAY ,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP )as cpt group by cpt.MA_QUAY";
        sqlloinhuan="select dt.MA_QUAY,dt.NGAY_TAO,(dt.doanhthu-cp.chiphi) as loinhuan from ("+sqldoanhthu+") as dt, ("+sqlchiphi+") as cp where dt.MA_QUAY=cp.MA_QUAY ";
        
        }
        else if(start == null){
        //don't have start date
        sqldoanhthu = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE HOA_DON.NGAY_TAO <='"+String.valueOf(end)+"' and HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        sqlchiphi = "select sum(cpt.chiphi) as chiphi,cpt.MA_QUAY from( select PHIEU_NHAP.MA_QUAY ,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE PHIEU_NHAP.NGAY_NHAP<='"+String.valueOf(end)+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP )as cpt group by cpt.MA_QUAY";
        sqlloinhuan="select dt.MA_QUAY,dt.NGAY_TAO,(dt.doanhthu-cp.chiphi) as loinhuan from ("+sqldoanhthu+") as dt, ("+sqlchiphi+") as cp where dt.MA_QUAY=cp.MA_QUAY";
       
        }else if(end == null){
            //don't have end date
        sqldoanhthu = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE HOA_DON.NGAY_TAO >='"+String.valueOf(start)+"' and HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        sqlchiphi = "select sum(cpt.chiphi) as chiphi,cpt.MA_QUAY from( select PHIEU_NHAP.MA_QUAY  ,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE PHIEU_NHAP.NGAY_NHAP>='"+String.valueOf(start)+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP )as cpt group by cpt.MA_QUAY";
        sqlloinhuan="select dt.MA_QUAY,dt.NGAY_TAO,(dt.doanhthu-cp.chiphi) as loinhuan from ("+sqldoanhthu+") as dt, ("+sqlchiphi+") as cp where dt.MA_QUAY=cp.MA_QUAY ";
       
        }else{
        // condition date between start and end
        sqldoanhthu = "select HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO,SUM(CT_HD.SO_LUONG_LY*CT_HD.GIA_TIEN) as doanhthu from CT_HD,HOA_DON WHERE (HOA_DON.NGAY_TAO BETWEEN '"+String.valueOf(start)+"' and '"+String.valueOf(end)+"') and HOA_DON.MA_HD=CT_HD.MA_HD GROUP BY HOA_DON.MA_QUAY,HOA_DON.NGAY_TAO";
        sqlchiphi = "select sum(cpt.chiphi) as chiphi,cpt.MA_QUAY from( select PHIEU_NHAP.MA_QUAY  ,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE (PHIEU_NHAP.NGAY_NHAP BETWEEN '"+String.valueOf(start)+"' and '"+String.valueOf(end)+"') and PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP )as cpt group by cpt.MA_QUAY";
        sqlloinhuan="select dt.MA_QUAY,dt.NGAY_TAO,(dt.doanhthu-cp.chiphi) as loinhuan from ("+sqldoanhthu+") as dt, ("+sqlchiphi+") as cp where dt.MA_QUAY=cp.MA_QUAY ";
        
        }
      
        
        //add to list
        Statement statement;
        try {
             System.out.println("--- doanh thu---");
            System.out.println(sqldoanhthu);
             System.out.println("--- chi phi---");
            System.out.println(sqlchiphi);
            System.out.println("---LOI NHUAN---");
              System.out.println(sqlloinhuan);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlloinhuan);
            System.out.println("---200-OK-Doanh--Thu---- ");
            while (rs.next()) {
                System.out.println("--- "+rs.getString(1));
                list.add(new ThongKeLoiNhuan(rs.getString(1),rs.getString(2),rs.getString(3)));
               
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

