//nghia

package view;

import valid.MaxLength;
import dao.Dao_NhanVien;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import valid.Regex;
import valid.Valid;

/**
 *
 * @author nghia
 */
public class formThemNV extends javax.swing.JFrame {

    /**
     * Creates new form formThemNV
     */
    public formThemNV() {
        initComponents();
        labelLoiMatKhau.setText("");
        labelLoiTaiKhoan.setText("");
        labelLoiXacNhan.setText("");
        labelLoiSDT.setText("");
        labelLoiHo.setText("");
        labelLoiTen.setText("");
        labelLoiDiaChi.setText("");
        setMaxLength();
    }

    private void setMaxLength() {
        textDiaChi.setDocument(new MaxLength(100));
        textHoNhanVien.setDocument(new MaxLength(50));
        textMatKhau.setDocument(new MaxLength(30));
        textSDT.setDocument(new MaxLength(10));
        textTenNhanVien.setDocument(new MaxLength(30));
        textTenTaiKhoan.setDocument(new MaxLength(10));
        textXacNhan.setDocument(new MaxLength(30));
    }

    private int isHoValid() {
        if (textHoNhanVien.getText().trim().equals("")) {
            labelLoiHo.setText("Không được để trống!");
            return 0;
        } else {
            labelLoiHo.setText("");
            return 1;
        }
    }

    private int isTenValid() {
        if (textTenNhanVien.getText().trim().equals("")) {
            labelLoiTen.setText("Không được để trống!");
            return 0;
        } else {
            labelLoiTen.setText("");
            return 1;
        }
    }

    private int isTenTaiKhoanValid() {
        String tk = textTenTaiKhoan.getText().trim();
        if (tk.equals("")) {
            labelLoiTaiKhoan.setText("Không được để trống!");
            return 0;
        } else if (!Valid.isTextValid(tk, Regex.TAI_KHOAN)) {
            labelLoiTaiKhoan.setText("chỉ nhận [0-9][a-z][A-Z]_");
            return -1;
        } else {
            labelLoiTaiKhoan.setText("");
            return 1;
        }
    }

    private int isMatKhauValid() {
        char[] pw = textMatKhau.getPassword();
        if (pw.length == 0) {
            labelLoiMatKhau.setText("Không được để trống!");
            buttonLuu.setEnabled(false);
            return 0;
        } else if (pw.length < 4) {
            labelLoiMatKhau.setText("Tối thiểu 4 ký tự");
            buttonLuu.setEnabled(false);
            return -2;
        } else {
            labelLoiMatKhau.setText("");
            buttonLuu.setEnabled(true);
            return 1;
        }
    }

    private int isSDTValid() {
        String sdt = textSDT.getText().trim();
        if (sdt.equals("")) {
            labelLoiSDT.setText("Không được để trống!");
            return 0;
        } else if (!Valid.isTextValid(sdt, Regex.SDT)) {
            labelLoiSDT.setText("0xxxxxxxxx (10)");
            return -1;
        } else {
            labelLoiSDT.setText("");
            return 1;
        }
    }

    private int isXacNhanValid() {
        char[] pw = textMatKhau.getPassword();
        char[] xn = textXacNhan.getPassword();
        if (xn.length == 0) {
            labelLoiXacNhan.setText("Không được để trống!");
            return 0;
        } else if (!Arrays.equals(xn, pw)) {
            labelLoiXacNhan.setText("Mật khẩu không khớp");
            return -1;
        } else {
            labelLoiXacNhan.setText("");
            return 1;
        }
    }

    private boolean isAllValid() {
        if (isHoValid() == 1 && isTenValid() == 1 && isSDTValid() == 1
                && isTenTaiKhoanValid() == 1 && isMatKhauValid() == 1 && isXacNhanValid() == 1) {
            return true;
        } else {
            return false;
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel19 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textHoNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textTenNhanVien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textTenTaiKhoan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textMatKhau = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        textXacNhan = new javax.swing.JPasswordField();
        checkHienMatKhau = new javax.swing.JCheckBox();
        labelLoiTaiKhoan = new javax.swing.JLabel();
        labelLoiXacNhan = new javax.swing.JLabel();
        labelLoiMatKhau = new javax.swing.JLabel();
        labelLoiSDT = new javax.swing.JLabel();
        labelLoiHo = new javax.swing.JLabel();
        labelLoiTen = new javax.swing.JLabel();
        labelLoiDiaChi = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        buttonNhapLai = new javax.swing.JButton();
        buttonLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm Nhân Viên Mới");
        setMinimumSize(new java.awt.Dimension(550, 380));
        setSize(new java.awt.Dimension(600, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập Thông Tin Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel19.setMaximumSize(new java.awt.Dimension(550, 21474));
        jPanel19.setMinimumSize(new java.awt.Dimension(550, 200));
        jPanel19.setPreferredSize(new java.awt.Dimension(600, 200));
        java.awt.GridBagLayout jPanel19Layout = new java.awt.GridBagLayout();
        jPanel19Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel19Layout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        jPanel19.setLayout(jPanel19Layout);

        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Họ Nhân Viên");
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel19.add(jLabel4, gridBagConstraints);

        textHoNhanVien.setPreferredSize(new java.awt.Dimension(150, 30));
        textHoNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textHoNhanVienKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textHoNhanVien, gridBagConstraints);

        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tên Nhân Viên");
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel5, gridBagConstraints);

        textTenNhanVien.setPreferredSize(new java.awt.Dimension(150, 30));
        textTenNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTenNhanVienKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textTenNhanVien, gridBagConstraints);

        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Địa Chỉ");
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel6, gridBagConstraints);

        textDiaChi.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textDiaChi, gridBagConstraints);

        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Số Điện Thoại");
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel7, gridBagConstraints);

        textSDT.setPreferredSize(new java.awt.Dimension(150, 30));
        textSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSDTKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textSDT, gridBagConstraints);

        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tên Tài Khoản");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel8, gridBagConstraints);

        textTenTaiKhoan.setPreferredSize(new java.awt.Dimension(150, 30));
        textTenTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTenTaiKhoanKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textTenTaiKhoan, gridBagConstraints);

        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mật Khẩu");
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel9, gridBagConstraints);

        textMatKhau.setPreferredSize(new java.awt.Dimension(150, 30));
        textMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMatKhauKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textMatKhau, gridBagConstraints);

        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Xác Nhận");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(jLabel10, gridBagConstraints);

        textXacNhan.setPreferredSize(new java.awt.Dimension(150, 30));
        textXacNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textXacNhanKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(textXacNhan, gridBagConstraints);

        checkHienMatKhau.setForeground(new java.awt.Color(0, 102, 204));
        checkHienMatKhau.setText("Hiện Mật Khẩu");
        checkHienMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkHienMatKhauMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(checkHienMatKhau, gridBagConstraints);

        labelLoiTaiKhoan.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiTaiKhoan.setText("Tài khoản đã tồn tại");
        labelLoiTaiKhoan.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(labelLoiTaiKhoan, gridBagConstraints);

        labelLoiXacNhan.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiXacNhan.setText("Xác nhận không đúng");
        labelLoiXacNhan.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(labelLoiXacNhan, gridBagConstraints);

        labelLoiMatKhau.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiMatKhau.setText("Mật khẩu tối thiểu 4 ký tự");
        labelLoiMatKhau.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(labelLoiMatKhau, gridBagConstraints);

        labelLoiSDT.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiSDT.setText("Số điện thoại đã tồn tại");
        labelLoiSDT.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel19.add(labelLoiSDT, gridBagConstraints);

        labelLoiHo.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiHo.setText("Không được trống");
        labelLoiHo.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(labelLoiHo, gridBagConstraints);

        labelLoiTen.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiTen.setText("Không được trống");
        labelLoiTen.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(labelLoiTen, gridBagConstraints);

        labelLoiDiaChi.setForeground(new java.awt.Color(255, 0, 0));
        labelLoiDiaChi.setText("Không đúng định dạng");
        labelLoiDiaChi.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel19.add(labelLoiDiaChi, gridBagConstraints);

        getContentPane().add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel18.setPreferredSize(new java.awt.Dimension(600, 60));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        buttonNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh-24.png"))); // NOI18N
        buttonNhapLai.setText("Nhập Lại");
        buttonNhapLai.setPreferredSize(new java.awt.Dimension(120, 40));
        buttonNhapLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNhapLaiMouseClicked(evt);
            }
        });
        jPanel18.add(buttonNhapLai);

        buttonLuu.setForeground(new java.awt.Color(0, 102, 204));
        buttonLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy-disk-24.png"))); // NOI18N
        buttonLuu.setText("Lưu Lại");
        buttonLuu.setPreferredSize(new java.awt.Dimension(120, 40));
        buttonLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLuuMouseClicked(evt);
            }
        });
        jPanel18.add(buttonLuu);

        getContentPane().add(jPanel18, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textTenTaiKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTenTaiKhoanKeyReleased
        // TODO add your handling code here:
        evt.toString();
        if (isTenTaiKhoanValid() == 1) {
            if (Dao_NhanVien.taiKhoanDaTonTai(textTenTaiKhoan.getText().trim())) {
                labelLoiTaiKhoan.setText("Tài khoản đã tồn tại");
                buttonLuu.setEnabled(false);
            } else {
                labelLoiTaiKhoan.setText("");
                buttonLuu.setEnabled(true);
            }
        }

    }//GEN-LAST:event_textTenTaiKhoanKeyReleased

    private void textMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMatKhauKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isMatKhauValid();
    }//GEN-LAST:event_textMatKhauKeyReleased

    private void textXacNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textXacNhanKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isXacNhanValid();
    }//GEN-LAST:event_textXacNhanKeyReleased

    private void textSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSDTKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isSDTValid();
    }//GEN-LAST:event_textSDTKeyReleased

    private void checkHienMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkHienMatKhauMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (checkHienMatKhau.isSelected()) {
                textMatKhau.setEchoChar((char) 0);
                textXacNhan.setEchoChar((char) 0);
            } else {
                textMatKhau.setEchoChar('*');
                textXacNhan.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_checkHienMatKhauMouseClicked

    private void buttonLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLuuMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (isAllValid() == false) {
                JOptionPane.showMessageDialog(this, "Nhập Liệu Không Đúng!");
            } else {
                String ho = textHoNhanVien.getText().trim().toUpperCase();
                String ten = textTenNhanVien.getText().trim().toUpperCase();
                String sdt = textSDT.getText().trim();
                String dc = textDiaChi.getText().trim().toUpperCase();
                String tk = textTenTaiKhoan.getText().trim();
                char[] mk = textMatKhau.getPassword();
                if (!Dao_NhanVien.taiKhoanDaTonTai(tk)) {
                    if (Dao_NhanVien.themNhanVien(ho, ten, sdt, dc, tk, new String(mk)) != 0) {
                        JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                        panelDSNV.layDSNV(Dao_NhanVien.layDanhSach());
                        panelCaNV.loadComboBoxNhanVien(Dao_NhanVien.layDanhSach());
                    } else {
                        JOptionPane.showMessageDialog(null, "", "Thêm Thất Bại", JOptionPane.WARNING_MESSAGE);
                        panelDSNV.layDSNV(Dao_NhanVien.layDanhSach());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Tài khoản này đã tồn tại!");
                }

            }

        }

    }//GEN-LAST:event_buttonLuuMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        evt.toString();
        panelDSNV.formThemNVOpened = false; //đóng
    }//GEN-LAST:event_formWindowClosing

    private void buttonNhapLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNhapLaiMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            textHoNhanVien.setText("");
            textDiaChi.setText("");
            textMatKhau.setText("");
            textSDT.setText("");
            textTenNhanVien.setText("");
            textXacNhan.setText("");
            textTenTaiKhoan.setText("");
            labelLoiMatKhau.setText("");
            labelLoiTaiKhoan.setText("");
            labelLoiXacNhan.setText("");
            labelLoiSDT.setText("");
        }
    }//GEN-LAST:event_buttonNhapLaiMouseClicked

    private void textHoNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHoNhanVienKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isHoValid();
    }//GEN-LAST:event_textHoNhanVienKeyReleased

    private void textTenNhanVienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTenNhanVienKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isTenValid();
    }//GEN-LAST:event_textTenNhanVienKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLuu;
    private javax.swing.JButton buttonNhapLai;
    private javax.swing.JCheckBox checkHienMatKhau;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JLabel labelLoiDiaChi;
    private javax.swing.JLabel labelLoiHo;
    private javax.swing.JLabel labelLoiMatKhau;
    private javax.swing.JLabel labelLoiSDT;
    private javax.swing.JLabel labelLoiTaiKhoan;
    private javax.swing.JLabel labelLoiTen;
    private javax.swing.JLabel labelLoiXacNhan;
    private javax.swing.JTextField textDiaChi;
    private javax.swing.JTextField textHoNhanVien;
    private javax.swing.JPasswordField textMatKhau;
    private javax.swing.JTextField textSDT;
    private javax.swing.JTextField textTenNhanVien;
    private javax.swing.JTextField textTenTaiKhoan;
    private javax.swing.JPasswordField textXacNhan;
    // End of variables declaration//GEN-END:variables
}
