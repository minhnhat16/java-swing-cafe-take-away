/*
 Kết nối với cơ sở dữ liệu
 */
package server;

import view.dialogThongBaoKetNoi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author nghia
 */
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KetNoi {

    public static Connection layKetNoi() {
        FileReader fr;
        Properties p;
        String url;
        String user;
        String password;
        String databaseName;
        String port;
        Connection connection = null;
        try {
            fr = new FileReader(new File("URL Connection.properties"));
            p = new Properties();
            p.load(fr);
            user = p.getProperty("Username");
            password = p.getProperty("Password");
            databaseName = p.getProperty("DatabaseName");
            port = p.getProperty("Port");
            url = "jdbc:sqlserver://localhost:" + port + ";databaseName=" + databaseName;
            if (user.equals("") || password.equals("")) {
                new dialogThongBaoKetNoi(null, true, "Tài Khoản Truy Cập Server Không Thấy").setVisible(true);
            }else if (databaseName.equals("")) {
                new dialogThongBaoKetNoi(null, true, "Không Tìm Thấy DataBase").setVisible(true);
            }else if (port.equals("")) {
                new dialogThongBaoKetNoi(null, true, "Cổng kết nối rỗng!").setVisible(true);
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Kết Nối Tới Máy Chủ Không Thành Công");
//            System.out.println(ex.toString());
            new dialogThongBaoKetNoi(null, true, ex.toString()).setVisible(true);
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Không Tìm Thấy Driver");
            new dialogThongBaoKetNoi(null, true, ex.toString()).setVisible(true);
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Không Tìm Thấy File Cấu Hình");
            new dialogThongBaoKetNoi(null, true, ex.toString()).setVisible(true);
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Nạp Thuộc Tính Thất Bại");
            new dialogThongBaoKetNoi(null, true, ex.toString()).setVisible(true);
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
