package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * FormTTQL class
 */
public class formTTQL extends javax.swing.JFrame {

    /**
     * Creates new form formTTQL
     */
    public formTTQL() {
        initComponents();
    }

    public void thongTin() {
        textTen.setEnabled(true);
        textHo.setEnabled(true);
        textDiaChi.setEnabled(true);
        textSDT.setEnabled(true);

        textTen.setEditable(false);
        textHo.setEditable(false);
        textDiaChi.setEditable(false);
        textSDT.setEditable(false);
    }

    public void matKhau(boolean visible, boolean editable) {
        labelMKMoi.setVisible(visible);
        labelMatKhauCu.setVisible(visible);
        labelXacNhan.setVisible(visible);
        pwMKCu.setVisible(visible);
        pwMKMoi.setVisible(visible);
        pwXN.setVisible(visible);
        cbHienMK.setVisible(visible);

        if (visible) {
            pwMKCu.setEditable(editable);
            pwMKMoi.setEditable(editable);
            pwXN.setEditable(editable);
            cbHienMK.setEnabled(editable);
        }
    }

    public void nhanVien() {
        thongTin();
        matKhau(false, false);
        button();
    }

    public void button() {
        buttonChinhSua.setVisible(false);
        buttonLuu.setVisible(false);
        btnDoiMatKhau.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textHo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textSDT = new javax.swing.JTextField();
        labelMKMoi = new javax.swing.JLabel();
        pwMKMoi = new javax.swing.JPasswordField();
        labelXacNhan = new javax.swing.JLabel();
        pwXN = new javax.swing.JPasswordField();
        cbHienMK = new javax.swing.JCheckBox();
        labelMatKhauCu = new javax.swing.JLabel();
        pwMKCu = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        buttonLuu = new javax.swing.JButton();
        buttonChinhSua = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        buttonThoat = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setMinimumSize(new java.awt.Dimension(300, 250));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Mã Quản Lý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 25, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jTextField1.setEnabled(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 5, 0, 0);
        jPanel2.add(jTextField1, gridBagConstraints);

        jLabel2.setText("Họ Quản Lý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        textHo.setText("Họ Quản Lý");
        textHo.setEnabled(false);
        textHo.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(textHo, gridBagConstraints);

        jLabel3.setText("Tên Quản Lý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        textTen.setEnabled(false);
        textTen.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(textTen, gridBagConstraints);

        jLabel4.setText("Địa Chỉ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        textDiaChi.setEnabled(false);
        textDiaChi.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(textDiaChi, gridBagConstraints);

        jLabel5.setText("Số Điện Thoại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 40, 0);
        jPanel2.add(jLabel5, gridBagConstraints);

        textSDT.setEnabled(false);
        textSDT.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 40, 0);
        jPanel2.add(textSDT, gridBagConstraints);

        labelMKMoi.setText("Mật Khẩu Mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        jPanel2.add(labelMKMoi, gridBagConstraints);

        pwMKMoi.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(pwMKMoi, gridBagConstraints);

        labelXacNhan.setText("Xác Nhận");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        jPanel2.add(labelXacNhan, gridBagConstraints);

        pwXN.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(pwXN, gridBagConstraints);

        cbHienMK.setText("Hiển Thị Mật Khẩu");
        cbHienMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHienMKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(cbHienMK, gridBagConstraints);

        labelMatKhauCu.setText("Mật Khẩu Cũ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        jPanel2.add(labelMatKhauCu, gridBagConstraints);

        pwMKCu.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 157;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(pwMKCu, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 10));

        buttonLuu.setText("Lưu");
        buttonLuu.setVisible(false);
        buttonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLuuActionPerformed(evt);
            }
        });
        jPanel1.add(buttonLuu);

        buttonChinhSua.setText("Chỉnh Sửa");
        buttonChinhSua.setVisible(true);
        buttonChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChinhSuaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonChinhSua);

        btnDoiMatKhau.setText("Đổi Mật Khẩu");
        btnDoiMatKhau.setVisible(true);
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau);

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });
        jPanel1.add(buttonReset);

        buttonThoat.setText("Thoát");
        buttonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThoatActionPerformed(evt);
            }
        });
        jPanel1.add(buttonThoat);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }

    private void cbHienMKActionPerformed(ActionEvent evt) {
        if (cbHienMK.isSelected()) {
            pwMKCu.setEchoChar((char) 0);
            pwMKMoi.setEchoChar((char) 0);
            pwXN.setEchoChar((char) 0);
        } else {
            pwMKCu.setEchoChar('*');
            pwMKMoi.setEchoChar('*');
            pwXN.setEchoChar('*');
        }
    }

    private void buttonLuuActionPerformed(ActionEvent evt) {
        // Code to save user details and password change
        String mkCu = new String(pwMKCu.getPassword());
        String mkMoi = new String(pwMKMoi.getPassword());
        String xn = new String(pwXN.getPassword());

        if (!mkMoi.equals(xn)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới và xác nhận không khớp!");
            return;
        }

        // Assuming 'UserDAO' is a class that handles database operations for the user
        // Update user details and password
        // UserDAO.updateUserDetails(...);
        // UserDAO.updateUserPassword(mkCu, mkMoi);

        JOptionPane.showMessageDialog(this, "Lưu thông tin thành công!");

        // Reset form to default state
        buttonChinhSua.setVisible(true);
        buttonLuu.setVisible(false);
        btnDoiMatKhau.setVisible(true);
        thongTin();
        matKhau(false, false);
    }

    private void buttonChinhSuaActionPerformed(ActionEvent evt) {
        buttonChinhSua.setVisible(false);
        buttonLuu.setVisible(true);
        btnDoiMatKhau.setVisible(false);
        thongTin();
        textTen.setEditable(true);
        textHo.setEditable(true);
        textDiaChi.setEditable(true);
        textSDT.setEditable(true);
    }

    private void btnDoiMatKhauActionPerformed(ActionEvent evt) {
        buttonChinhSua.setVisible(false);
        buttonLuu.setVisible(true);
        btnDoiMatKhau.setVisible(false);
        matKhau(true, true);
    }

    private void buttonThoatActionPerformed(ActionEvent evt) {
        int response = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private void buttonResetActionPerformed(ActionEvent evt) {
        textTen.setText("");
        textHo.setText("");
        textDiaChi.setText("");
        textSDT.setText("");
        pwMKCu.setText("");
        pwMKMoi.setText("");
        pwXN.setText("");
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formTTQL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton buttonChinhSua;
    private javax.swing.JButton buttonLuu;
    private javax.swing.JButton buttonThoat;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JCheckBox cbHienMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelMKMoi;
    private javax.swing.JLabel labelMatKhauCu;
    private javax.swing.JLabel labelXacNhan;
    private javax.swing.JPasswordField pwMKMoi;
    private javax.swing.JPasswordField pwMKCu;
    private javax.swing.JPasswordField pwXN;
    private javax.swing.JTextField textDiaChi;
    private javax.swing.JTextField textHo;
    private javax.swing.JTextField textSDT;
    private javax.swing.JTextField textTen;
    // End of variables declaration
}
