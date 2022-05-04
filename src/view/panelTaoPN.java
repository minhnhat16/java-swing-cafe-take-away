/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Dao_CTPN;
import dao.Dao_NguyenLieu;
import dao.Dao_PhieuNhap;
import dao.Dao_QuayCafe;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NguyenLieu;
import model.TaoPN;
import model.QuayCafe;

/**
 *
 * @author nghia
 */
public final class panelTaoPN extends javax.swing.JPanel {

    private static DefaultTableModel dtm;
    private int sumMoney = 0; //tong tien
    private List<NguyenLieu> lsnguyenlieu;//lay danh sach nguyen lieu (ComboxNguyenLieu)
    private final List<TaoPN> lsThem;//Luu danh sach PN chua luu vao DB
    private Boolean p;

    public panelTaoPN() {
        initComponents();
        dtm = (DefaultTableModel) tablePhieuNhap.getModel();
        dtm.setRowCount(0);
        tablePhieuNhap.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        lsThem = new ArrayList<>();
        layDSTEN_NGUYEN_LIEU();
        layDSMAQUAY();
    }
    //get all list Ten Nguyen Lieu-> combox

    public void layDSTEN_NGUYEN_LIEU() {
        this.lsnguyenlieu = Dao_NguyenLieu.layDS();
        ComboxNguyenLieu.removeAllItems();
        if (!this.lsnguyenlieu.isEmpty()) {
            //IDE lag
            this.lsnguyenlieu.forEach(p -> {
                ComboxNguyenLieu.addItem(p.getTenNL());
            });
        }

    }

    //get all list MA QUAY -> combox
    public void layDSMAQUAY() {
        List<QuayCafe> ls = Dao_QuayCafe.layDSQuay();
        comboxQuay.removeAllItems();
        if (!ls.isEmpty()) {
            ls.forEach(pn -> {
                comboxQuay.addItem(
                        "QUAY " + pn.getMa()
                );
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel45 = new javax.swing.JPanel();
        comboxQuay = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txt_MaPhieuNhap = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        lbNgayLap = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        ComboxNguyenLieu = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        lb_summoney = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablePhieuNhap = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel45.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        comboxQuay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quầy 1" }));

        btnSave.setForeground(new java.awt.Color(0, 102, 204));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy-disk-16.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnThem.setForeground(new java.awt.Color(0, 102, 204));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-cart-16.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-16.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboxQuay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboxQuay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap())
        );

        add(jPanel45, java.awt.BorderLayout.LINE_END);

        jPanel46.setLayout(new javax.swing.BoxLayout(jPanel46, javax.swing.BoxLayout.Y_AXIS));

        jPanel55.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        jPanel55.setPreferredSize(new java.awt.Dimension(690, 120));
        jPanel55.setLayout(new javax.swing.BoxLayout(jPanel55, javax.swing.BoxLayout.X_AXIS));

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel56.setPreferredSize(new java.awt.Dimension(300, 190));
        jPanel56.setLayout(new java.awt.GridBagLayout());

        jLabel37.setForeground(new java.awt.Color(0, 102, 204));
        jLabel37.setText("Mã Phiếu Nhập");
        jLabel37.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel56.add(jLabel37, gridBagConstraints);

        txt_MaPhieuNhap.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_MaPhieuNhap.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel56.add(txt_MaPhieuNhap, gridBagConstraints);

        jLabel38.setForeground(new java.awt.Color(0, 102, 204));
        jLabel38.setText("Ngày Lập");
        jLabel38.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel56.add(jLabel38, gridBagConstraints);

        lbNgayLap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        lbNgayLap.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel56.add(lbNgayLap, gridBagConstraints);

        jPanel55.add(jPanel56);

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel57.setPreferredSize(new java.awt.Dimension(330, 190));
        jPanel57.setLayout(new java.awt.GridBagLayout());

        jLabel40.setForeground(new java.awt.Color(0, 102, 204));
        jLabel40.setText("Tên Nguyên Liệu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel57.add(jLabel40, gridBagConstraints);

        ComboxNguyenLieu.setEditable(true);
        ComboxNguyenLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cafe Hạt" }));
        ComboxNguyenLieu.setPreferredSize(new java.awt.Dimension(250, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 10;
        jPanel57.add(ComboxNguyenLieu, gridBagConstraints);

        jLabel41.setForeground(new java.awt.Color(0, 102, 204));
        jLabel41.setText("Số Lượng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel57.add(jLabel41, gridBagConstraints);

        txtSoLuong.setMinimumSize(new java.awt.Dimension(30, 19));
        txtSoLuong.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel57.add(txtSoLuong, gridBagConstraints);

        jLabel42.setForeground(new java.awt.Color(0, 102, 204));
        jLabel42.setText("Giá Tiền");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel57.add(jLabel42, gridBagConstraints);

        txtGiaTien.setMinimumSize(new java.awt.Dimension(30, 19));
        txtGiaTien.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        jPanel57.add(txtGiaTien, gridBagConstraints);

        jPanel55.add(jPanel57);

        jPanel46.add(jPanel55);

        jPanel58.setPreferredSize(new java.awt.Dimension(702, 250));
        jPanel58.setLayout(new javax.swing.BoxLayout(jPanel58, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel60.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel60.setPreferredSize(new java.awt.Dimension(702, 30));

        jLabel43.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 51, 51));
        jLabel43.setText("Tổng Tiền:");
        jLabel43.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel60.add(jLabel43);

        lb_summoney.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lb_summoney.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lb_summoney.setText("2,000,000");
        lb_summoney.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel60.add(lb_summoney);

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel45.setText("vnđ");
        jLabel45.setPreferredSize(new java.awt.Dimension(30, 20));
        jPanel60.add(jLabel45);

        jPanel58.add(jPanel60);

        tablePhieuNhap.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tablePhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nguyên Liệu", "Tên Nguyên Liệu", "Đơn Vị Tính", "Số Lượng/Khối Lượng", "Giá Tiền"
            }
        ));
        tablePhieuNhap.setRowHeight(18);
        tablePhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tablePhieuNhap);

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );

        jPanel58.add(jPanel59);

        jPanel46.add(jPanel58);

        add(jPanel46, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private void setInputEmpty() {
        txt_MaPhieuNhap.setText("");
        txtSoLuong.setText("");
        txtGiaTien.setText("");

    }

    public static String getDate(String ngay) {
        String[] a = ngay.split("-");
        return a[2] + "/" + a[1] + "/" + a[0];
    }

    private String getDateLocal() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //  Date now;
            String dateString = getDate(LocalDate.now().toString());
            System.out.println(LocalDate.now().toString());

            return dateString;
            // now=sdf.parse(dateString);
//            labelNgayLap.setText(sdf.format(now));
        } catch (Exception ex) {
            //Logger.getLogger(panelLapHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //kiem tra MA_PN co trong TABLE (khi click button them) va DB hay chua
    private boolean isExistMA_PN(String MAPN) {
        List<TaoPN> AllMAPN = Dao_PhieuNhap.layAllMaPhieuNhap();
        p = false;
        //kiem tra MA_PN trong DB
        if (!AllMAPN.isEmpty()) {
            AllMAPN.forEach(item -> {
                if (item.getMA_PHIEU_NHAP().toLowerCase().trim().equals(MAPN.toLowerCase().trim())) {
                    p = true;
                }

            });
        }

        //kiem tra MA_PN trong TABLE (chua dc luu vao DB khi click btnThem)
        if (!this.lsThem.isEmpty()) {
            this.lsThem.forEach(item -> {
                if (item.getMA_PHIEU_NHAP().toLowerCase().trim().equals(MAPN.toLowerCase().trim())) {
                    p = true;
                }

            });
        }
        return p;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ///LAY MA NHAN VIEN . ADD VO DB . VI DU MA_NV=1
        String maphieunhap = txt_MaPhieuNhap.getText();
        if (this.isExistMA_PN(maphieunhap)) {
            System.out.println("-(panelTaoPN.java Line:399)-THONG BAO MA PHIEU NHAP DA TON TAI");
            return;
        }
        int MA_NV = 101;

        int MA_QUAY = 1;

        String TenNguyenLieu = ComboxNguyenLieu.getSelectedItem().toString();
        int SoLuong = 0, GiaTien = 0;
        try {
            MA_QUAY = Integer.parseInt(comboxQuay.getSelectedItem().toString());
            SoLuong = Integer.parseInt(txtSoLuong.getText());
            GiaTien = Integer.parseInt(txtGiaTien.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
        //position selected of combox ten nguyen lieu
        int posSelectedNguyenLieu = ComboxNguyenLieu.getSelectedIndex();
        //lay thongtin nguyen lieu da selected (maNL,donViTinh,tenNL)
        NguyenLieu posNL = lsnguyenlieu.get(posSelectedNguyenLieu);

        lsThem.add(new TaoPN(maphieunhap, posNL.getMaNL()+"", TenNguyenLieu, posNL.getDonViTinh(), SoLuong, GiaTien, MA_NV, MA_QUAY, this.getDateLocal()));
        //Them tiep row trong table tao PN
        this.sumMoney = this.sumMoney + SoLuong * GiaTien;
        dtm.addRow(new Object[]{
            posNL.getMaNL(),
            TenNguyenLieu,
            posNL.getDonViTinh(),
            SoLuong,
            GiaTien
        });
        this.setInputEmpty();
        lb_summoney.setText(String.valueOf(this.sumMoney));
    }//GEN-LAST:event_btnThemActionPerformed

    //hien thi lsThem vao Table
    private void showDSThem() {
        dtm.setRowCount(0);
        this.sumMoney = 0;
        this.lsThem.forEach(item -> {
            this.sumMoney = this.sumMoney + item.getSO_LUONG() * item.getPRICE();
            dtm.addRow(new Object[]{
                item.getMA_NGUYEN_LIEU(),
                item.getTEN_NGUYEN_LIEU(),
                item.getD_VI(),
                item.getSO_LUONG(),
                item.getPRICE()
            });
        });
        lb_summoney.setText(String.valueOf(this.sumMoney));
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //btn save
        this.lsThem.forEach(item -> {
            if (Dao_PhieuNhap.themPhieuNhap(item.getMA_PHIEU_NHAP(), item.getNGAY_NHAP(), item.getMA_NV(), item.getMA_QUAY()) != 0) {
                Dao_CTPN.themCTPN(item.getMA_PHIEU_NHAP(), item.getMA_NGUYEN_LIEU(), item.getSO_LUONG(), item.getPRICE());
                System.out.println("---Them Thanh Cong Phieu Nhap ----");
                //the method removes all the elements from the arraylist

            } else {
                System.out.println("---Insert Phieu Nhap Fail ----");
            }
        });
        //Lam moi TABLE and List
        lsThem.removeAll(lsThem);
        dtm.setRowCount(0);
        this.sumMoney = 0;
        lb_summoney.setText(String.valueOf(this.sumMoney));
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tablePhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhieuNhapMouseClicked


    }//GEN-LAST:event_tablePhieuNhapMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Thuc hien Xoa row da chon 

        int rowSelectedInTable = tablePhieuNhap.getSelectedRow();
        //chua chon row trong table
        if (rowSelectedInTable == -1) {
            this.lsThem.remove(this.lsThem.size() - 1);
        } else {
            this.lsThem.remove(rowSelectedInTable);
        }
        this.showDSThem();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboxNguyenLieu;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> comboxQuay;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JLabel lbNgayLap;
    private javax.swing.JLabel lb_summoney;
    private javax.swing.JTable tablePhieuNhap;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txt_MaPhieuNhap;
    // End of variables declaration//GEN-END:variables
}
