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
import model.ThongKeChiPhi;
import server.KetNoi;
import view.panelDSNV;

public class Dao_ThongKeChiPhi {
    
    
    //start , end : search chi phi between start->end 
    //start = null = vo cung be(vd :1/1/0001)
    //end =null = vo cung lon(+vd : 1/1/9999)
    public static List<ThongKeChiPhi> layDanhSach(java.sql.Date start,java.sql.Date end){
        List<ThongKeChiPhi> list=new ArrayList<>();
        String sql;
        Connection connection;
        connection = KetNoi.layKetNoi();
        //don't have condition date
        if(start==null&&end==null){
        sql = "select PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP";
        }else if(start == null){
        //don't have start date
         sql = "select PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE PHIEU_NHAP.NGAY_NHAP<='"+String.valueOf(end)+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP ";
         
        }else if(end == null){
        //don't have end date
         sql = "select PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE PHIEU_NHAP.NGAY_NHAP>='"+String.valueOf(start)+"' and PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP ";

        }else{
        // condition date between start and end
             sql = "select PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP,SUM(CT_PN.SO_LUONG_NL*CT_PN.GIA_TIEN) as chiphi from CT_PN,PHIEU_NHAP WHERE (PHIEU_NHAP.NGAY_NHAP BETWEEN '"+String.valueOf(start)+"' and '"+String.valueOf(end)+"') and PHIEU_NHAP.MA_PN=CT_PN.MA_PN GROUP BY PHIEU_NHAP.MA_QUAY,PHIEU_NHAP.NGAY_NHAP ";
          
        }
      
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("---200-OK---- ");
            while (rs.next()) {
                System.out.println("--- "+rs.getString(1));
                list.add(new ThongKeChiPhi(rs.getString(1),rs.getString(2),rs.getString(3)));
               
            }
            return list;//từ từ chia nhìn kkipj
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

