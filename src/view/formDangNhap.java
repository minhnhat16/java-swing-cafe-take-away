//nghia
package view;

import valid.MaxLength;
import dao.Dao_NhanVien;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import server.KetNoi;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import valid.Regex;
public class formDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    private char[] matKhau;
    private String taiKhoan;
    public static String taiKhoanNV;

    public formDangNhap() {
        initComponents();
        textTenDangNhap.setDocument(new MaxLength(10));
        textMatKhau.setDocument(new MaxLength(30));
        khoiTao();
        loadImage(labelPTIT, labelPTIT.getWidth(), labelPTIT.getHeight(), "src\\icon\\ptit.png");
    }

    private void khoiTao() {
        this.setLocationRelativeTo(null);
        textLoiTaiKhoan.setText("");
        textLoiMatKhau.setText("");
    }

    public static void loadImage(JLabel labelHinhAnh, int w, int h, String path) {
        try {
            File f = new File(path);
            Image i = ImageIO.read(f);
            labelHinhAnh.setIcon(new ImageIcon(
                    i.getScaledInstance(
                            w, h, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
        }
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        labelPTIT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelAbout = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        textTenDangNhap = new javax.swing.JTextField(new MaxLength(10), "Tên Đăng Nhập", 250);
        textMatKhau = new javax.swing.JPasswordField();
        checkHienMatKhau = new javax.swing.JCheckBox();
        buttonDangNhap = new javax.swing.JButton();
        textLoiTaiKhoan = new javax.swing.JLabel();
        textLoiMatKhau = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập");

        jLabel2.setFont(new java.awt.Font("sansserif", 2, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ CHUỖI CAFE MANG ĐI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelPTIT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPTIT, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(596, 50));

        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("@CopyRight 2024");

        labelAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/about-24.png"))); // NOI18N
        labelAbout.setToolTipText("About");
        labelAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAboutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addComponent(labelAbout)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setPreferredSize(new java.awt.Dimension(410, 240));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setMinimumSize(new java.awt.Dimension(450, 180));
        jPanel5.setPreferredSize(new java.awt.Dimension(450, 240));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        textTenDangNhap.setMinimumSize(new java.awt.Dimension(250, 30));
        textTenDangNhap.setPreferredSize(new java.awt.Dimension(250, 30));
        textTenDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTenDangNhapKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(textTenDangNhap, gridBagConstraints);

        textMatKhau.setMinimumSize(new java.awt.Dimension(250, 30));
        textMatKhau.setPreferredSize(new java.awt.Dimension(250, 30));
        textMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMatKhauKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(textMatKhau, gridBagConstraints);

        checkHienMatKhau.setForeground(new java.awt.Color(0, 102, 255));
        checkHienMatKhau.setText("Hiện Mật Khẩu");
        checkHienMatKhau.setPreferredSize(new java.awt.Dimension(120, 30));
        checkHienMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkHienMatKhauMouseClicked(evt);
            }
        });
        checkHienMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHienMatKhauActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(checkHienMatKhau, gridBagConstraints);

        buttonDangNhap.setForeground(new java.awt.Color(0, 102, 255));
        buttonDangNhap.setText("Đăng Nhập");
        buttonDangNhap.setMinimumSize(new java.awt.Dimension(250, 30));
        buttonDangNhap.setPreferredSize(new java.awt.Dimension(250, 30));
        buttonDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDangNhapMouseClicked(evt);
            }
        });
        buttonDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonDangNhapKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.9;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(buttonDangNhap, gridBagConstraints);

        textLoiTaiKhoan.setForeground(new java.awt.Color(255, 0, 0));
        textLoiTaiKhoan.setText("Tên Đăng Nhập Không Đúng");
        textLoiTaiKhoan.setMinimumSize(new java.awt.Dimension(250, 30));
        textLoiTaiKhoan.setPreferredSize(new java.awt.Dimension(250, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(textLoiTaiKhoan, gridBagConstraints);

        textLoiMatKhau.setForeground(new java.awt.Color(255, 0, 0));
        textLoiMatKhau.setText("Mật Khẩu Không Đúng");
        textLoiMatKhau.setMinimumSize(new java.awt.Dimension(250, 30));
        textLoiMatKhau.setPreferredSize(new java.awt.Dimension(250, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(textLoiMatKhau, gridBagConstraints);

        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Tên Đăng Nhập");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(jLabel4, gridBagConstraints);

        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Mật Khẩu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        jPanel5.add(jLabel5, gridBagConstraints);

        jPanel3.add(jPanel5, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean kiemTraTaiKhoan() {
        Connection connection;
        PreparedStatement p;
        ResultSet r;
        try {
            connection = KetNoi.layKetNoi();
            taiKhoan = textTenDangNhap.getText().trim();
            matKhau = textMatKhau.getPassword();//return char[]
            String sql = "select * from tai_khoan where ten_tk=? and mat_khau=?";
            p = connection.prepareStatement(sql);
            p.setString(1, taiKhoan);
            p.setString(2, new String(matKhau));
            r = p.executeQuery();
            if (r.next()) {
                return true;
            } else {
                textTenDangNhap.requestFocus();
                JOptionPane.showMessageDialog(rootPane, "Tài Khoản Hoặc Mật Khẩu Không Đúng");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private String kiemTraChucVu() {
        try {
            PreparedStatement p;
            Connection connection = KetNoi.layKetNoi();
            String sql;
            sql = "select CHUC_VU from TAI_KHOAN, NHAN_VIEN where TAI_KHOAN.TEN_TK=? and MAT_KHAU=? and TAI_KHOAN.TEN_TK=NHAN_VIEN.TEN_TK";
            p = connection.prepareStatement(sql);
            p.setString(1, taiKhoan);
            p.setString(2, new String(matKhau));
            ResultSet r = p.executeQuery();
            r.next();
            return r.getString("chuc_vu");
        } catch (SQLException ex) {
            Logger.getLogger(formDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NV";
    }

    private void dangNhap() {
        if (isAllValid()) {
            if (kiemTraTaiKhoan()) {
                if (kiemTraChucVu().equals("QL")) {
                    formQuanLy q = new formQuanLy();
                    this.dispose();
                    formQuanLy.ql=(Dao_NhanVien.layThongTinQL(taiKhoan));
                    q.setVisible(true);
                } else {
                    formNhanVien n = new formNhanVien();
                    this.dispose();
                    n.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Dữ liệu không đúng!");
        }
    }

    private int isTaiKhoanValid() {
        String tk = textTenDangNhap.getText().trim();
        if (tk.equals("")) {
            textLoiTaiKhoan.setText("Không được trống!");
            return 0;
        } else if (!valid.Valid.isTextValid(tk, Regex.W)) {
            textLoiTaiKhoan.setText("Chỉ Được Phép 0-9, a-z,_");
            return -1;
        } else {
            textLoiTaiKhoan.setText("");
            return 1;
        }
    }

    private int isMatKhauValid() {
        char[] mk = textMatKhau.getPassword();
        if (mk.length == 0) {
            textLoiMatKhau.setText("Không được trống!");
            return 0; //trống
        } else if (mk.length < 4) {
            textLoiMatKhau.setText("Mật khẩu tối thiểu 4 ký tự");
            return -2;
        } else {
            textLoiMatKhau.setText("");
            return 1; //hợp lệ
        }
    }

    private boolean isAllValid() {
        return isTaiKhoanValid() == 1 && isMatKhauValid() == 1;
    }

    private void buttonDangNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonDangNhapKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dangNhap();
        }
        taiKhoanNV = taiKhoan;
    }//GEN-LAST:event_buttonDangNhapKeyPressed

    private void labelAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAboutMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            formAbout a = new formAbout();
            a.setVisible(true);
        }
    }//GEN-LAST:event_labelAboutMouseClicked

    private void textTenDangNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTenDangNhapKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isTaiKhoanValid();
    }//GEN-LAST:event_textTenDangNhapKeyReleased

    private void textMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMatKhauKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isMatKhauValid();
    }//GEN-LAST:event_textMatKhauKeyReleased

    private void buttonDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDangNhapMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            dangNhap();
        }
        taiKhoanNV = taiKhoan;
    }//GEN-LAST:event_buttonDangNhapMouseClicked

    private void checkHienMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkHienMatKhauMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (checkHienMatKhau.isSelected()) {
                textMatKhau.setEchoChar((char) 0);
            } else {
                textMatKhau.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_checkHienMatKhauMouseClicked

    private void checkHienMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHienMatKhauActionPerformed
        // TODO add your handling code here:
        evt.toString();
        if (checkHienMatKhau.isSelected()) {
            textMatKhau.setEchoChar((char) 0);
        } else {
            textMatKhau.setEchoChar('*');
        }

    }//GEN-LAST:event_checkHienMatKhauActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDangNhap;
    private javax.swing.JCheckBox checkHienMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelAbout;
    private javax.swing.JLabel labelPTIT;
    private javax.swing.JLabel textLoiMatKhau;
    private javax.swing.JLabel textLoiTaiKhoan;
    private javax.swing.JPasswordField textMatKhau;
    private javax.swing.JTextField textTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
