//nghia
package view;

import dao.Dao_NhanVien;
import valid.MaxLength;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.NhanVien;
import valid.Regex;
import valid.Valid;

/**
 *
 * @author nghia
 */
public class formThongTinQL extends javax.swing.JFrame {

    /**
     * Creates new form FormThongTinQL
     *
     * @param ql
     */
    private NhanVien ql;

    public formThongTinQL(NhanVien ql) {
        initComponents();
        this.ql = ql;
        overRide();
//        System.out.println("đã load được thông tin quản lý " + ql.getTenTK());
        setMaxLength();
        loadThongTinQL();
    }

    public NhanVien getQl() {
        return ql;
    }

    public void setQl(NhanVien ql) {
        this.ql = ql;
    }

    private void loadThongTinQL() {
//        System.out.println("load thông tin quản lý lên form " + ql.getMaNV());
        txtMaQL.setText(ql.getMaNV() + "");
        txtDiaChi.setText(ql.getDiaChi());
        txtHo.setText(ql.getHo());
        txtTen.setText(ql.getTen());
        txtSDT.setText(ql.getSdt());
    }

    private void overRide() {
        setLocationRelativeTo(null);
        HoError.setText("");
        TenError.setText("");
        SDTError.setText("");
        DiaChiError.setText("");
        MKCError.setText("");
        MKMError.setText("");
        XNError.setText("");
    }

    private void setMaxLength() {
        txtDiaChi.setDocument(new MaxLength(100));
        txtHo.setDocument(new MaxLength(50));
        txtSDT.setDocument(new MaxLength(10));
        txtTen.setDocument(new MaxLength(30));

        MKC.setDocument(new MaxLength(30));
        MKmoi.setDocument(new MaxLength(30));
        XNMK.setDocument(new MaxLength(30));
    }

    public void thongTin() {
        txtTen.setEnabled(true);
        txtHo.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtSDT.setEnabled(true);

        txtTen.setEditable(false);
        txtHo.setEditable(false);
        txtDiaChi.setEditable(false);
        txtSDT.setEditable(false);
    }

    public void matKhau(boolean visable, boolean editable) {
        labelMKMoi.setVisible(visable);
        labelMatKhauCu.setVisible(visable);
        labelXacNhan.setVisible(visable);
        MKC.setVisible(visable);
        MKmoi.setVisible(visable);
        XNMK.setVisible(visable);
        cbHienMK.setVisible(visable);

        if (visable) {
            MKC.setEnabled(editable);
            MKmoi.setEnabled(editable);
            XNMK.setEnabled(editable);

            MKC.setEditable(editable);
            MKmoi.setEditable(editable);
            XNMK.setEditable(editable);
            cbHienMK.setEnabled(editable);
        }

    }

    public void button() {
        buttonChinhSua.setVisible(false);
        buttonLuu.setVisible(false);
        btnDoiMatKhau.setVisible(false);
    }

    public void nhanVien() {
        thongTin();
        matKhau(false, false); //không cho thấy
        button();
    }

    private void resetMK() {
        MKC.setText("");
        MKmoi.setText("");
        XNMK.setText("");
    }

    private int isHoValid() {
        if (txtHo.getText().trim().equals("")) {
            HoError.setText("Không được trống!");
            return 0;
        } else {
            HoError.setText("");
            return 1;
        }
    }

    private int isTenValid() {
        if (txtTen.getText().trim().equals("")) {
            TenError.setText("Không được trống!");
            return 0;
        } else {
            TenError.setText("");
            return 1;
        }
    }

    private int isSDTValid() {
        String sdt = txtSDT.getText().trim();
        if (sdt.equals("")) {
            SDTError.setText("Không được trống!");
            return 0;
        } else if (Valid.isTextValid(sdt, Regex.SDT)) {
            SDTError.setText("0xxxxxxxxx");
            return -1;
        } else {
            SDTError.setText("");
            return 1;
        }
    }

    private int isMatKhauCuValid() {
        char[] mk = MKC.getPassword();
        if (mk.length == 0) {
            MKCError.setText("Không được trống!");
            buttonLuu.setEnabled(false);
            return 0; //trống
        } else if (mk.length < 4) {
            MKCError.setText("Mật khẩu tối thiểu 4 ký tự");
            buttonLuu.setEnabled(false);
            return -2;
        } else {
            MKCError.setText("");
            buttonLuu.setEnabled(true);
            return 1; //hợp lệ
        }
    }

    private int isMatKhauMoiValid() {
        char[] mk = MKmoi.getPassword();
        if (mk.length == 0) {
            MKMError.setText("Không được trống!");
            buttonLuu.setEnabled(false);
            return 0; //trống
        } else if (mk.length < 4) {
            MKMError.setText("Mật khẩu tối thiểu 4 ký tự");
            buttonLuu.setEnabled(false);
            return -2;
        } else {
            MKMError.setText("");
            buttonLuu.setEnabled(true);
            return 1; //hợp lệ
        }
    }

    private int isXacNhanValid() {
        char[] pw = MKmoi.getPassword();
        char[] xn = XNMK.getPassword();
        if (xn.length == 0) {
            XNError.setText("Không được để trống!");
            buttonLuu.setEnabled(false);
            return 0;
        } else if (!Arrays.equals(xn, pw)) {
//            System.out.println(Arrays.toString(pw));
//            System.out.println(Arrays.toString(xn));
            XNError.setText("Mật khẩu không khớp");
            buttonLuu.setEnabled(false);
            return -1;
        } else {
            XNError.setText("");
            buttonLuu.setEnabled(true);
            return 1;
        }
    }

    private boolean isAllValid() {
//        return isHoValid() == 1 && isTenValid() == 1 && isSDTValid() == 1;
        //nếu đúng định dạng true
        if (doiMatKhau()) {
            if (isHoValid() == 1 && isTenValid() == 1 && isSDTValid() == 1
                    && isMatKhauCuValid() == 1 && isMatKhauMoiValid() == 1
                    && isXacNhanValid() == 1) {
                return true;
            }
        } else {
            return isHoValid() == 1 && isTenValid() == 1 && isSDTValid() == 1;
        }
        return false;
    }

    private boolean doiMatKhau() {
        return MKC.isEnabled() && MKmoi.isEnabled() && XNMK.isEnabled();
        //true nếu đổi
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

        jPanel1 = new javax.swing.JPanel();
        buttonLuu = new javax.swing.JButton();
        buttonChinhSua = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        buttonThoat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaQL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        labelMKMoi = new javax.swing.JLabel();
        MKmoi = new javax.swing.JPasswordField();
        labelXacNhan = new javax.swing.JLabel();
        XNMK = new javax.swing.JPasswordField();
        cbHienMK = new javax.swing.JCheckBox();
        labelMatKhauCu = new javax.swing.JLabel();
        MKC = new javax.swing.JPasswordField();
        HoError = new javax.swing.JLabel();
        TenError = new javax.swing.JLabel();
        MKCError = new javax.swing.JLabel();
        DiaChiError = new javax.swing.JLabel();
        MKMError = new javax.swing.JLabel();
        XNError = new javax.swing.JLabel();
        SDTError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 48));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        buttonLuu.setForeground(new java.awt.Color(0, 102, 204));
        buttonLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy-disk-16.png"))); // NOI18N
        buttonLuu.setText("Lưu");
        buttonLuu.setEnabled(false);
        buttonLuu.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLuuMouseClicked(evt);
            }
        });
        jPanel1.add(buttonLuu);

        buttonChinhSua.setForeground(new java.awt.Color(0, 102, 204));
        buttonChinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-info-16.png"))); // NOI18N
        buttonChinhSua.setText("Chỉnh Sửa");
        buttonChinhSua.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonChinhSuaMouseClicked(evt);
            }
        });
        jPanel1.add(buttonChinhSua);

        btnDoiMatKhau.setForeground(new java.awt.Color(0, 102, 204));
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset-password-16.png"))); // NOI18N
        btnDoiMatKhau.setText("Đổi Mật Khẩu");
        btnDoiMatKhau.setPreferredSize(new java.awt.Dimension(125, 30));
        btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMouseClicked(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau);

        buttonThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit-16.png"))); // NOI18N
        buttonThoat.setText("Thoát");
        buttonThoat.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonThoatMouseClicked(evt);
            }
        });
        jPanel1.add(buttonThoat);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setMinimumSize(new java.awt.Dimension(300, 250));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Mã Quản Lý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jLabel1, gridBagConstraints);

        txtMaQL.setEnabled(false);
        txtMaQL.setMinimumSize(new java.awt.Dimension(140, 28));
        txtMaQL.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel2.add(txtMaQL, gridBagConstraints);

        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Họ Quản Lý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jLabel2, gridBagConstraints);

        txtHo.setEnabled(false);
        txtHo.setMinimumSize(new java.awt.Dimension(140, 28));
        txtHo.setPreferredSize(new java.awt.Dimension(140, 28));
        txtHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel2.add(txtHo, gridBagConstraints);

        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Tên Quản Lý");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLabel3, gridBagConstraints);

        txtTen.setEnabled(false);
        txtTen.setMinimumSize(new java.awt.Dimension(140, 28));
        txtTen.setPreferredSize(new java.awt.Dimension(140, 28));
        txtTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel2.add(txtTen, gridBagConstraints);

        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("Địa Chỉ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jLabel4, gridBagConstraints);

        txtDiaChi.setEnabled(false);
        txtDiaChi.setMinimumSize(new java.awt.Dimension(140, 28));
        txtDiaChi.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        jPanel2.add(txtDiaChi, gridBagConstraints);

        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("Số Điện Thoại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel2.add(jLabel5, gridBagConstraints);

        txtSDT.setEnabled(false);
        txtSDT.setMinimumSize(new java.awt.Dimension(140, 28));
        txtSDT.setPreferredSize(new java.awt.Dimension(140, 28));
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        jPanel2.add(txtSDT, gridBagConstraints);

        labelMKMoi.setForeground(new java.awt.Color(0, 102, 204));
        labelMKMoi.setText("Mật Khẩu Mới");
        labelMKMoi.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel2.add(labelMKMoi, gridBagConstraints);

        MKmoi.setEnabled(false);
        MKmoi.setMinimumSize(new java.awt.Dimension(0, 0));
        MKmoi.setPreferredSize(new java.awt.Dimension(140, 28));
        MKmoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MKmoiKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPanel2.add(MKmoi, gridBagConstraints);

        labelXacNhan.setForeground(new java.awt.Color(0, 102, 204));
        labelXacNhan.setText("Xác Nhận");
        labelXacNhan.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel2.add(labelXacNhan, gridBagConstraints);

        XNMK.setEnabled(false);
        XNMK.setMinimumSize(new java.awt.Dimension(0, 0));
        XNMK.setPreferredSize(new java.awt.Dimension(140, 28));
        XNMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                XNMKKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        jPanel2.add(XNMK, gridBagConstraints);

        cbHienMK.setForeground(new java.awt.Color(0, 102, 204));
        cbHienMK.setText("Hiện Mật Khẩu");
        cbHienMK.setEnabled(false);
        cbHienMK.setMinimumSize(new java.awt.Dimension(0, 0));
        cbHienMK.setPreferredSize(new java.awt.Dimension(140, 28));
        cbHienMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbHienMKMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        jPanel2.add(cbHienMK, gridBagConstraints);

        labelMatKhauCu.setForeground(new java.awt.Color(0, 102, 204));
        labelMatKhauCu.setText("Mật Khẩu Cũ");
        labelMatKhauCu.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel2.add(labelMatKhauCu, gridBagConstraints);

        MKC.setEnabled(false);
        MKC.setMinimumSize(new java.awt.Dimension(0, 0));
        MKC.setPreferredSize(new java.awt.Dimension(140, 28));
        MKC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MKCKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel2.add(MKC, gridBagConstraints);

        HoError.setForeground(new java.awt.Color(255, 0, 0));
        HoError.setText("jLabel6");
        HoError.setMinimumSize(new java.awt.Dimension(140, 28));
        HoError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel2.add(HoError, gridBagConstraints);

        TenError.setForeground(new java.awt.Color(255, 0, 0));
        TenError.setText("jLabel7");
        TenError.setMinimumSize(new java.awt.Dimension(140, 28));
        TenError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        jPanel2.add(TenError, gridBagConstraints);

        MKCError.setForeground(new java.awt.Color(255, 0, 0));
        MKCError.setText("jLabel8");
        MKCError.setMinimumSize(new java.awt.Dimension(0, 0));
        MKCError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel2.add(MKCError, gridBagConstraints);

        DiaChiError.setForeground(new java.awt.Color(255, 0, 0));
        DiaChiError.setText("jLabel9");
        DiaChiError.setMinimumSize(new java.awt.Dimension(140, 28));
        DiaChiError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jPanel2.add(DiaChiError, gridBagConstraints);

        MKMError.setForeground(new java.awt.Color(255, 0, 0));
        MKMError.setText("jLabel10");
        MKMError.setMinimumSize(new java.awt.Dimension(0, 0));
        MKMError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        jPanel2.add(MKMError, gridBagConstraints);

        XNError.setForeground(new java.awt.Color(255, 0, 0));
        XNError.setText("jLabel11");
        XNError.setMinimumSize(new java.awt.Dimension(0, 0));
        XNError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        jPanel2.add(XNError, gridBagConstraints);

        SDTError.setForeground(new java.awt.Color(255, 0, 0));
        SDTError.setText("jLabel12");
        SDTError.setMinimumSize(new java.awt.Dimension(140, 28));
        SDTError.setPreferredSize(new java.awt.Dimension(140, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        jPanel2.add(SDTError, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonChinhSuaMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            buttonLuu.setEnabled(true);
            txtHo.setEnabled(true);
            txtTen.setEnabled(true);
            txtDiaChi.setEnabled(true);
            txtSDT.setEnabled(true);
        }
    }//GEN-LAST:event_buttonChinhSuaMouseClicked

    private void buttonThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonThoatMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            formQuanLy.formThongTinQLOpened = false;
            this.dispose();
        }
    }//GEN-LAST:event_buttonThoatMouseClicked

    private void btnDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
//            System.out.println("doi mat khau");
            buttonLuu.setEnabled(true);
            matKhau(true, true);
        }
    }//GEN-LAST:event_btnDoiMatKhauMouseClicked

    private void buttonLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLuuMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (buttonLuu.isEnabled()) {
                if (isAllValid()) {
                    String ho = txtHo.getText().trim().toUpperCase();
                    String ten = txtTen.getText().trim().toUpperCase();
                    String diaChi = txtDiaChi.getText().trim().toUpperCase();
                    String sdt = txtSDT.getText().trim();
                    String matKhau;
//                    if (MKmoi.getPassword().length != 0) {
                    matKhau = new String(MKmoi.getPassword());
                    if (doiMatKhau()) {
                        if (!Dao_NhanVien.dungMK(ql.getTenTK(), new String(MKC.getPassword()))) {
                            MKCError.setText("Mật khẩu cũ không đúng!");
                            System.out.println("");
                            return;
                        }
                    }
//                    } else {
//                        matKhau = "";
//                    }
                    if (Dao_NhanVien.suaQuanLy(ql.getMaNV(), ho, ten,
                            diaChi, sdt, matKhau) != 0) {
                        JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
                        ql.setHo(txtHo.getText().trim().toUpperCase());
                        ql.setTen(txtTen.getText().trim().toUpperCase());
                        ql.setDiaChi(txtDiaChi.getText().trim().toUpperCase());
                        ql.setSdt(txtSDT.getText().trim());
                        loadThongTinQL();
                        resetMK();

                        matKhau(true, false); //ẩn tính năng đổi mật khẩu
                    } else {
                        JOptionPane.showMessageDialog(null, "", "Cập Nhật Thất Bại", JOptionPane.WARNING_MESSAGE);
                        panelDSNV.layDSNV(Dao_NhanVien.layDanhSach());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thông tin không đúng!");
                }

            }
        }
    }//GEN-LAST:event_buttonLuuMouseClicked

    private void cbHienMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbHienMKMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (cbHienMK.isSelected()) {
                MKC.setEchoChar((char) 0);
                XNMK.setEchoChar((char) 0);
                MKmoi.setEchoChar((char) 0);
            } else {
                MKC.setEchoChar('*');
                MKmoi.setEchoChar('*');
                XNMK.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_cbHienMKMouseClicked

    private void MKmoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MKmoiKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isMatKhauMoiValid();
    }//GEN-LAST:event_MKmoiKeyReleased

    private void MKCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MKCKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isMatKhauCuValid();
    }//GEN-LAST:event_MKCKeyReleased

    private void XNMKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_XNMKKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isXacNhanValid();
    }//GEN-LAST:event_XNMKKeyReleased

    private void txtHoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isHoValid();
    }//GEN-LAST:event_txtHoKeyReleased

    private void txtTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isTenValid();
    }//GEN-LAST:event_txtTenKeyReleased

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        // TODO add your handling code here:
        evt.toString();
        isSDTValid();
    }//GEN-LAST:event_txtSDTKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        evt.toString();
        formQuanLy.formThongTinQLOpened = false;
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DiaChiError;
    private javax.swing.JLabel HoError;
    private javax.swing.JPasswordField MKC;
    private javax.swing.JLabel MKCError;
    private javax.swing.JLabel MKMError;
    private javax.swing.JPasswordField MKmoi;
    private javax.swing.JLabel SDTError;
    private javax.swing.JLabel TenError;
    private javax.swing.JLabel XNError;
    private javax.swing.JPasswordField XNMK;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton buttonChinhSua;
    private javax.swing.JButton buttonLuu;
    private javax.swing.JButton buttonThoat;
    private javax.swing.JCheckBox cbHienMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelMKMoi;
    private javax.swing.JLabel labelMatKhauCu;
    private javax.swing.JLabel labelXacNhan;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaQL;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
