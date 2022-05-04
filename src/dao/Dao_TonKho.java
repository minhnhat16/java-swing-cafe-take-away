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
import model.TaoPN;
import model.ThongKeTonKho;
import server.KetNoi;
import view.panelDSNV;

/**
 *
 * @author D e l l
 */
public class Dao_TonKho {
     //get ton kho
     public static List<ThongKeTonKho> DSThongKeTonKho(String TenNL,String Quay){
        List<ThongKeTonKho> list=new ArrayList<>();
        String sql;
        Connection connection;
        connection = KetNoi.layKetNoi();
        //null khi moi vao app . (get all )
        if(TenNL==null || Quay==null){
         sql = "";
      
        }else{
        //khi click vao btn kiem tra (get have condition)
         sql = "";
      
        }
        
       
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new ThongKeTonKho(rs.getString(1),rs.getString(2),Float.parseFloat(rs.getString(3)),rs.getString(4)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
