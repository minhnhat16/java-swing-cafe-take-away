//nghia

package view;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import model.NhanVien;

/**
 *
 * @author nghia
 */
public class formQuanLy extends javax.swing.JFrame {

    /**
     * Creates new form QuanLy
     *
     */
    public static boolean formThongTinQLOpened = false;
    public static NhanVien ql;

    public formQuanLy() {
        initComponents();
        loadIcon();
        khoiTao();
//        System.out.println(getClass());

        //thêm các tab chức năng
        tabPaneNV.addTab("DANH SÁCH NHÂN VIÊN", new panelDSNV());
        tabPaneNV.addTab("CA NHÂN VIÊN", new panelCaNV());

        tabPaneQLHD.addTab("DANH SÁCH HÓA ĐƠN", new panelDSHD());
        tabPaneQLHD.addTab("LẬP HÓA ĐƠN", new panelLapHD());

        tabPaneMenu.addTab("DANH SÁCH THỰC ĐƠN", new panelDSTD());
        JScrollPane jsc = new JScrollPane(new panelCTTD());
        tabPaneMenu.addTab("CHI TIẾT THỰC ĐƠN", jsc);

        jTabbedPane5.addTab("DANH SÁCH PHIẾU NHẬP", new panelDSPN());
        jTabbedPane5.addTab("TẠO PHIẾU NHẬP", new panelTaoPN());

        jTabbedPane6.addTab("THỐNG KÊ CHI PHÍ", new panelThongKeChiPhi());
        jTabbedPane6.addTab("THỐNG KÊ DOANH THU", new panelThongKeDoanhThu());
        jTabbedPane6.addTab("THỐNG KÊ LỢI NHUẬN", new panelLoiNhuan());

        jTabbedPane2.addTab("NGUYÊN LIỆU", new panelNguyenLieu());
        jTabbedPane2.addTab("TỒN KHO", new panelTonKho());
    }

    private void khoiTao() {
        this.setLocationRelativeTo(null);
    }

    private void loadIcon() {
        try {
            File f = new File("src/icon/ptit.png");
            Image i = ImageIO.read(f);
            iconPtit.setIcon(
                    new ImageIcon(
                            i.getScaledInstance(
                                    iconPtit.getWidth(),
                                    iconPtit.getHeight(),
                                    Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(formQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconPtit = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnThongTinQL = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tabPaneMainMenu = new javax.swing.JTabbedPane();
        tabQLNV = new javax.swing.JPanel();
        tabPaneNV = new javax.swing.JTabbedPane();
        tabQLHD = new javax.swing.JPanel();
        tabPaneQLHD = new javax.swing.JTabbedPane();
        tabMenu = new javax.swing.JPanel();
        tabPaneMenu = new javax.swing.JTabbedPane();
        tabPhieuNhap = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        tabThongKe = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        tabNguyenLieu = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setSize(new java.awt.Dimension(1200, 650));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(944, 100));

        iconPtit.setText("icon");
        iconPtit.setMaximumSize(new java.awt.Dimension(50, 40));
        iconPtit.setPreferredSize(new java.awt.Dimension(100, 100));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThongTinQL.setForeground(new java.awt.Color(0, 102, 255));
        btnThongTinQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/info-16.png"))); // NOI18N
        btnThongTinQL.setText("Thông Tin");
        btnThongTinQL.setToolTipText("Thông Tin Quản Lý");
        btnThongTinQL.setMaximumSize(new java.awt.Dimension(147, 28));
        btnThongTinQL.setMinimumSize(new java.awt.Dimension(147, 28));
        btnThongTinQL.setPreferredSize(new java.awt.Dimension(100, 28));
        btnThongTinQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongTinQLMouseClicked(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout-16.png"))); // NOI18N
        jButton2.setText("Đăng Xuất");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongTinQL, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThongTinQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setMinimumSize(new java.awt.Dimension(400, 113));
        jPanel12.setPreferredSize(new java.awt.Dimension(500, 98));

        labelTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(0, 51, 204));
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("QUẢN LÝ NHÂN VIÊN");
        labelTitle.setMinimumSize(new java.awt.Dimension(100, 26));
        labelTitle.setPreferredSize(new java.awt.Dimension(150, 26));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(iconPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(iconPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabPaneMainMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabPaneMainMenu.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPaneMainMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabPaneMainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabPaneMainMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tabPaneMainMenu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPaneMainMenuStateChanged(evt);
            }
        });

        tabPaneNV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabPaneNV.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout tabQLNVLayout = new javax.swing.GroupLayout(tabQLNV);
        tabQLNV.setLayout(tabQLNVLayout);
        tabQLNVLayout.setHorizontalGroup(
            tabQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneNV, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        tabQLNVLayout.setVerticalGroup(
            tabQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneNV, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabPaneMainMenu.addTab("", new javax.swing.ImageIcon(getClass().getResource("/icon/employees.png")), tabQLNV, "Quản Lý Nhân Viên"); // NOI18N

        tabPaneQLHD.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout tabQLHDLayout = new javax.swing.GroupLayout(tabQLHD);
        tabQLHD.setLayout(tabQLHDLayout);
        tabQLHDLayout.setHorizontalGroup(
            tabQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        tabQLHDLayout.setVerticalGroup(
            tabQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabPaneMainMenu.addTab("", new javax.swing.ImageIcon(getClass().getResource("/icon/bills.png")), tabQLHD, "Quản Lý Hóa Đơn"); // NOI18N

        tabPaneMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout tabMenuLayout = new javax.swing.GroupLayout(tabMenu);
        tabMenu.setLayout(tabMenuLayout);
        tabMenuLayout.setHorizontalGroup(
            tabMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        tabMenuLayout.setVerticalGroup(
            tabMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabPaneMainMenu.addTab("", new javax.swing.ImageIcon(getClass().getResource("/icon/drinks-menus.png")), tabMenu, "Quản Lý Menu"); // NOI18N

        jTabbedPane5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout tabPhieuNhapLayout = new javax.swing.GroupLayout(tabPhieuNhap);
        tabPhieuNhap.setLayout(tabPhieuNhapLayout);
        tabPhieuNhapLayout.setHorizontalGroup(
            tabPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        tabPhieuNhapLayout.setVerticalGroup(
            tabPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabPaneMainMenu.addTab("", new javax.swing.ImageIcon(getClass().getResource("/icon/receipts.png")), tabPhieuNhap, "Quản Lý Phiếu Nhập"); // NOI18N

        jTabbedPane6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout tabThongKeLayout = new javax.swing.GroupLayout(tabThongKe);
        tabThongKe.setLayout(tabThongKeLayout);
        tabThongKeLayout.setHorizontalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        tabThongKeLayout.setVerticalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabPaneMainMenu.addTab("", new javax.swing.ImageIcon(getClass().getResource("/icon/stats.png")), tabThongKe, "Thống Kê"); // NOI18N

        jTabbedPane2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout tabNguyenLieuLayout = new javax.swing.GroupLayout(tabNguyenLieu);
        tabNguyenLieu.setLayout(tabNguyenLieuLayout);
        tabNguyenLieuLayout.setHorizontalGroup(
            tabNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        tabNguyenLieuLayout.setVerticalGroup(
            tabNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabPaneMainMenu.addTab("", new javax.swing.ImageIcon(getClass().getResource("/icon/coffee-grinder.png")), tabNguyenLieu, "Nguyên Liệu"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPaneMainMenu)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPaneMainMenu)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongTinQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongTinQLMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (!formThongTinQLOpened) {
                formThongTinQL f = new formThongTinQL(ql);
                f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f.setVisible(true);
                formThongTinQLOpened = true;
            } else {
                JOptionPane.showMessageDialog(null, "Cửa Sổ Thông Tin Quản Lý Đã Mở!");
            }

        }
    }//GEN-LAST:event_btnThongTinQLMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        formDangNhap d = new formDangNhap();
        d.setLocationRelativeTo(this);
        d.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabPaneMainMenuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPaneMainMenuStateChanged
        // TODO add your handling code here:
//        System.out.println("state change");
        switch (tabPaneMainMenu.getSelectedIndex()) {
            case 0:
                labelTitle.setText("QUẢN LÝ NHÂN VIÊN");
                break;
            case 1:
                labelTitle.setText("QUẢN LÝ HÓA ĐƠN");
                break;
            case 2:
                labelTitle.setText("QUẢN LÝ THỰC ĐƠN");
                break;
            case 3:
                labelTitle.setText("QUẢN LÝ PHIẾU NHẬP");
                break;
            case 4:
                labelTitle.setText("THỐNG KÊ KẾT XUẤT");
                break;
            case 5:
                labelTitle.setText("QUẢN LÝ NGUYÊN LIỆU");
                break;
        }
    }//GEN-LAST:event_tabPaneMainMenuStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongTinQL;
    private javax.swing.JLabel iconPtit;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel tabMenu;
    private javax.swing.JPanel tabNguyenLieu;
    private javax.swing.JTabbedPane tabPaneMainMenu;
    private javax.swing.JTabbedPane tabPaneMenu;
    private javax.swing.JTabbedPane tabPaneNV;
    private javax.swing.JTabbedPane tabPaneQLHD;
    private javax.swing.JPanel tabPhieuNhap;
    private javax.swing.JPanel tabQLHD;
    private javax.swing.JPanel tabQLNV;
    private javax.swing.JPanel tabThongKe;
    // End of variables declaration//GEN-END:variables
}
