//nghia
package view;

import dao.Dao_NhanVien;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import java.sql.Connection;
import server.KetNoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

/**
 *
 * @author nghia
 */
public class panelDSNV extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    private static DefaultTableModel dtm;
    public static boolean formThongTinNVOpened = false;
    public static boolean formThemNVOpened = false;
//    private NhanVien nv;

    public panelDSNV() {
        initComponents();
        tableDSNV.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        layDSNV(Dao_NhanVien.layDanhSach());
    }

//    public NhanVien getNv() {
//        return nv;
//    }
//
//    public void setNv(NhanVien nv) {
//        this.nv = nv;
//    }
    public static final void layDSNV(List<NhanVien> list) {
        dtm = (DefaultTableModel) tableDSNV.getModel();
        dtm.setRowCount(0);
//        List<NhanVien> list=dao.dao_NhanVien.layDanhSach();
        list.forEach(nv -> {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getHo(),
                nv.getTen(),
                nv.getDiaChi(),
                nv.getSdt(),
                nv.isTt_nghi(),
                nv.getTenTK()
            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel7 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        buttonTimKiemNhanVien = new javax.swing.JButton();
        textTimKiemNhanVien = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        buttonSuaNhanVien = new javax.swing.JButton();
        buttonThem = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDSNV = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(812, 100));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Theo Họ Tên Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel16.setPreferredSize(new java.awt.Dimension(450, 70));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        buttonTimKiemNhanVien.setForeground(new java.awt.Color(0, 102, 204));
        buttonTimKiemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-24.png"))); // NOI18N
        buttonTimKiemNhanVien.setText("Tìm Kiếm");
        buttonTimKiemNhanVien.setMaximumSize(new java.awt.Dimension(200, 200));
        buttonTimKiemNhanVien.setMinimumSize(new java.awt.Dimension(120, 35));
        buttonTimKiemNhanVien.setPreferredSize(new java.awt.Dimension(120, 35));
        buttonTimKiemNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTimKiemNhanVienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel16.add(buttonTimKiemNhanVien, gridBagConstraints);

        textTimKiemNhanVien.setPreferredSize(new java.awt.Dimension(200, 35));
        textTimKiemNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTimKiemNhanVienKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel16.add(textTimKiemNhanVien, gridBagConstraints);

        jPanel7.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chỉnh Sửa Thông Tin", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel17.setMinimumSize(new java.awt.Dimension(300, 72));
        jPanel17.setPreferredSize(new java.awt.Dimension(400, 72));
        java.awt.GridBagLayout jPanel17Layout = new java.awt.GridBagLayout();
        jPanel17Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel17Layout.rowHeights = new int[] {0};
        jPanel17.setLayout(jPanel17Layout);

        buttonSuaNhanVien.setBackground(new java.awt.Color(153, 255, 102));
        buttonSuaNhanVien.setForeground(new java.awt.Color(0, 102, 204));
        buttonSuaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-info-16.png"))); // NOI18N
        buttonSuaNhanVien.setText("Sửa");
        buttonSuaNhanVien.setMinimumSize(new java.awt.Dimension(80, 35));
        buttonSuaNhanVien.setPreferredSize(new java.awt.Dimension(100, 35));
        buttonSuaNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSuaNhanVienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel17.add(buttonSuaNhanVien, gridBagConstraints);

        buttonThem.setForeground(new java.awt.Color(0, 102, 204));
        buttonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-16.png"))); // NOI18N
        buttonThem.setText("Thêm");
        buttonThem.setMinimumSize(new java.awt.Dimension(80, 35));
        buttonThem.setPreferredSize(new java.awt.Dimension(100, 35));
        buttonThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonThemMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel17.add(buttonThem, gridBagConstraints);

        buttonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-16.png"))); // NOI18N
        buttonXoa.setText("Xóa");
        buttonXoa.setMaximumSize(new java.awt.Dimension(100, 35));
        buttonXoa.setPreferredSize(new java.awt.Dimension(100, 35));
        buttonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXoaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel17.add(buttonXoa, gridBagConstraints);

        jPanel7.add(jPanel17, java.awt.BorderLayout.LINE_END);

        add(jPanel7, java.awt.BorderLayout.PAGE_START);

        tableDSNV.setAutoCreateRowSorter(true);
        tableDSNV.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tableDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ", "Tên", "Địa Chỉ", "Số Điện Thoại", "Nghỉ Việc", "Tên Tài Khoản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSNV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableDSNV.setRowHeight(18);
        tableDSNV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableDSNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableDSNVKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableDSNV);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        add(jPanel15, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSuaNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSuaNhanVienMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int row = tableDSNV.getSelectedRow();
            if (row != -1) {
                int maNV;
                maNV = (int) tableDSNV.getValueAt(row, 0);
                System.out.println(maNV);
                NhanVien n = Dao_NhanVien.layDuLieuTuBang(maNV);
//                if (n == null) {
//                    System.out.println("Lấy dữ liệu từ bảng có vấn đề");
//                }
//                System.out.println("Lấy dữ liệu từ bảng thành công");
                if (!formThongTinNVOpened) {
                    formThongTinNV t = new formThongTinNV(n);
                    t.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    t.nhanVien();
                    t.setSize(600, 350);
                    t.setVisible(true);

                    formThongTinNVOpened = true;//dánh đấu đẫ mở
                } else {
                    JOptionPane.showMessageDialog(this, "Cửa sổ thông tin nhân viên đã mở!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Chưa Có Dòng Nào Được Chọn");
            }
        }
    }//GEN-LAST:event_buttonSuaNhanVienMouseClicked

    public boolean nhanVienDaLapHoaDon(int manv) {
        String sql;
        Connection connection;
        Statement s;
        try {
            sql = "select COUNT(NHAN_VIEN.MA_NV) from NHAN_VIEN inner join HOA_DON "
                    + "on NHAN_VIEN.MA_NV=HOA_DON.MA_NV and NHAN_VIEN.MA_NV=" + manv;
            connection = KetNoi.layKetNoi();
            s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            System.out.println(rs.getInt(1));
            return rs.getInt(1) != 0;
        } catch (SQLException ex) {
            Logger.getLogger(panelDSNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        // TODO add your handling code here:
//        System.out.println(evt.getActionCommand());
        int index = tableDSNV.getSelectedRow();
//        System.out.println("Lỗi ở đây 0");
        if (index != -1) {
            int manv;
            manv = (int) tableDSNV.getValueAt(index, 0);
//            System.out.println("Lỗi ở đây 1");
            int i = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không",
                    "Xóa Nhân Viên", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
//                System.out.println("Lỗi ở đây 2");
                if (nhanVienDaLapHoaDon(manv)) {
                    JOptionPane.showMessageDialog(this,
                            "Nhân Viên Này Không Xóa Được\nChỉ Có Thể Chuyển Thành Trạng Thái Nghỉ\n Trong Mục Chỉnh Sửa Nhân Viên");
                } else {
                    if (Dao_NhanVien.xoaNhanVien(manv)) {
//                        JOptionPane.showMessageDialog(this, "Xóa Thành Công");
                        layDSNV(Dao_NhanVien.layDanhSach());
                        panelCaNV.loadComboBoxNhanVien(Dao_NhanVien.layDanhSach());
                    } else {
                        JOptionPane.showMessageDialog(this, "Không xóa được!\n Chỉ có thể chuyển sang trạng thái nghỉ");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa Có Dòng Nào Được Chọn");
        }
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonTimKiemNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTimKiemNhanVienMouseClicked
        // TODO add your handling code here:
//        System.out.println("mouse click");
//        if (evt.getButton() == MouseEvent.BUTTON1) {
//            JOptionPane.showMessageDialog(this, "mouse click");
//        } else {
//            JOptionPane.showMessageDialog(this, "!mouse click");
//        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            String ten = textTimKiemNhanVien.getText().trim();
//            System.out.println(ten);
            layDSNV(Dao_NhanVien.timKiemNhanVien(ten));
        }
    }//GEN-LAST:event_buttonTimKiemNhanVienMouseClicked

    private void tableDSNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableDSNVKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("tableDSNV Key ESC");
            tableDSNV.clearSelection();
        }
    }//GEN-LAST:event_tableDSNVKeyReleased

    private void textTimKiemNhanVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTimKiemNhanVienKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String ten = textTimKiemNhanVien.getText().trim();
            System.out.println(ten);
            layDSNV(Dao_NhanVien.timKiemNhanVien(ten));
        }
    }//GEN-LAST:event_textTimKiemNhanVienKeyPressed

    private void buttonThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonThemMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (!formThongTinNVOpened) {
                formThemNV f = new formThemNV();
                f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setVisible(true);
                formThemNVOpened = true; //đã mở
            } else {
                JOptionPane.showMessageDialog(this, "Cửa sổ thêm nhân viên đã được mở!");
            }
        }
    }//GEN-LAST:event_buttonThemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSuaNhanVien;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonTimKiemNhanVien;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable tableDSNV;
    private javax.swing.JTextField textTimKiemNhanVien;
    // End of variables declaration//GEN-END:variables
}
