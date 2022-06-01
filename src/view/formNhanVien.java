/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Dao_FormNhanVien;
import dao.Dao_NhanVien;
import model.HoaDon;
import model.NguyenLieu;
import model.ThucDon;
import model.NhanVienCTTD;
import model.CTHD;
import model.QuayCafe;
import model.NhanVien;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author nghia
 */
public class formNhanVien extends javax.swing.JFrame {

    private Connection conn;
    private ArrayList<HoaDon> dshd;
    private ArrayList<NguyenLieu> dsnl;
    private ArrayList<ThucDon> dstd;
    private ArrayList<ThucDon> dstddk;
    private ArrayList<NhanVienCTTD> cttd;
    private ArrayList<CTHD> dscthd;
    private ArrayList<QuayCafe> dsquaycafe;
    DefaultTableModel model;

    public formNhanVien() {
        initComponents();
        dsnl = new Dao_FormNhanVien().getListNL();
        dstd = new Dao_FormNhanVien().getListTD();
        dscthd = new ArrayList<>();
        dshd = new ArrayList<>();
        dshd = new Dao_FormNhanVien().getListHDAll();
        dsquaycafe = new Dao_FormNhanVien().getListQUAYCAFE();
        showTableNguyenLieu();
        showTableThucDon();
        showComboTENDOUONGData();
        showComboMAQUAY();
        showTableDSHD();
        overRide();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        txtNGAYLAP.setText(strDate);
    }

    private void showTableThucDon() {
        int i = 1;
        model = (DefaultTableModel) tableThucDon.getModel();
        for (ThucDon td : dstd) {
            model.addRow(new Object[]{
                i++, td.getTen(), td.getGia()
            });
        }
    }

    private void showComboTENDOUONGData() {
        for (ThucDon td : dstd) {
            comboTenDoUong.addItem(td.getTen());
            comboTENDOUONG.addItem(td.getTen());
        }
    }

    private void showComboMAQUAY() {
        for (QuayCafe quaycafe : dsquaycafe) {
            comboMAQUAY.addItem(Integer.toString(quaycafe.getMa()));
        }
    }

    private void showTableDSHD() {
        model = (DefaultTableModel) tableDSHD.getModel();
        model.setRowCount(0);
        for (HoaDon hd : dshd) {
            model.addRow(new Object[]{
                hd.getMaHD(), hd.getNgayTao(), hd.getMaNV(), hd.getMaQuay()
            });
        }
    }

    private void showTableNguyenLieu() {
        model = (DefaultTableModel) tableNguyenLieu.getModel();
        for (NguyenLieu nl : dsnl) {
            model.addRow(new Object[]{
                nl.getMaNL(), nl.getTenNL(), nl.getDonViTinh()
            });
        }
    }

    private void overRide() {
        this.setLocationRelativeTo(null);
        textTienLuong.setEditable(false);
        tableLapHoaDon.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        tableCTTD.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        tableDSHD.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        tableNguyenLieu.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        tableThucDon.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane4 = new javax.swing.JScrollPane();
        jFrame1 = new javax.swing.JFrame();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabLapHoaDon = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        comboMAQUAY = new javax.swing.JComboBox<>();
        LuuButton = new javax.swing.JButton();
        ThemButton = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        SuaButton = new javax.swing.JButton();
        huyButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtMAHD = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNGAYLAP = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        comboTENDOUONG = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        spinnerSoLuong = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableLapHoaDon = new javax.swing.JTable();
        tabHoaDonDaLap = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jDateTuNgay = new com.toedter.calendar.JDateChooser();
        jDateDenNgay = new com.toedter.calendar.JDateChooser();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDSHD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textTienLuong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tabThonTinThucDon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableCTTD = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        comboTenDoUong = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThucDon = new javax.swing.JTable();
        tabNguyenLieu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNguyenLieu = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        tabLapHoaDon.setLayout(new java.awt.BorderLayout());

        comboMAQUAY.setMinimumSize(new java.awt.Dimension(63, 25));
        comboMAQUAY.setPreferredSize(new java.awt.Dimension(63, 30));
        comboMAQUAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMAQUAYActionPerformed(evt);
            }
        });

        LuuButton.setForeground(new java.awt.Color(0, 102, 204));
        LuuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy-disk-16.png"))); // NOI18N
        LuuButton.setText("Lưu");
        LuuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuuButtonActionPerformed(evt);
            }
        });

        ThemButton.setForeground(new java.awt.Color(0, 102, 204));
        ThemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-cart-16.png"))); // NOI18N
        ThemButton.setText("Thêm");
        ThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemButtonActionPerformed(evt);
            }
        });

        XoaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-16.png"))); // NOI18N
        XoaButton.setText("Xóa");
        XoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaButtonActionPerformed(evt);
            }
        });

        SuaButton.setForeground(new java.awt.Color(0, 102, 204));
        SuaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh-16.png"))); // NOI18N
        SuaButton.setText("Sửa");
        SuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaButtonActionPerformed(evt);
            }
        });

        huyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel-16.png"))); // NOI18N
        huyButton.setText("Hủy");
        huyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quầy");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SuaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(XoaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThemButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(comboMAQUAY, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LuuButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(huyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMAQUAY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(huyButton)
                .addGap(18, 18, 18)
                .addComponent(SuaButton)
                .addGap(18, 18, 18)
                .addComponent(XoaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThemButton)
                .addGap(18, 18, 18)
                .addComponent(LuuButton)
                .addGap(24, 24, 24))
        );

        tabLapHoaDon.add(jPanel37, java.awt.BorderLayout.LINE_END);

        jPanel38.setLayout(new javax.swing.BoxLayout(jPanel38, javax.swing.BoxLayout.Y_AXIS));

        jPanel39.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        jPanel39.setPreferredSize(new java.awt.Dimension(690, 120));
        jPanel39.setLayout(new javax.swing.BoxLayout(jPanel39, javax.swing.BoxLayout.LINE_AXIS));

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel41.setMinimumSize(new java.awt.Dimension(300, 169));
        jPanel41.setPreferredSize(new java.awt.Dimension(300, 190));
        jPanel41.setLayout(new java.awt.GridBagLayout());

        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Mã Hóa Đơn");
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel41.add(jLabel20, gridBagConstraints);

        txtMAHD.setMinimumSize(new java.awt.Dimension(50, 20));
        txtMAHD.setPreferredSize(new java.awt.Dimension(100, 25));
        txtMAHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAHDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel41.add(txtMAHD, gridBagConstraints);

        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Ngày Lập");
        jLabel21.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel41.add(jLabel21, gridBagConstraints);

        txtNGAYLAP.setEditable(false);
        txtNGAYLAP.setPreferredSize(new java.awt.Dimension(100, 25));
        txtNGAYLAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNGAYLAPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel41.add(txtNGAYLAP, gridBagConstraints);

        jPanel39.add(jPanel41);

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chi Tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel42.setMinimumSize(new java.awt.Dimension(330, 190));
        jPanel42.setPreferredSize(new java.awt.Dimension(330, 190));
        jPanel42.setLayout(new java.awt.GridBagLayout());

        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("Tên Đồ Uống");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel42.add(jLabel23, gridBagConstraints);

        comboTENDOUONG.setFocusTraversalPolicyProvider(true);
        comboTENDOUONG.setPreferredSize(new java.awt.Dimension(150, 24));
        comboTENDOUONG.setVerifyInputWhenFocusTarget(false);
        comboTENDOUONG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTENDOUONGActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel42.add(comboTENDOUONG, gridBagConstraints);

        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("Số Lượng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel42.add(jLabel24, gridBagConstraints);

        spinnerSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerSoLuong.setMinimumSize(new java.awt.Dimension(50, 20));
        spinnerSoLuong.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel42.add(spinnerSoLuong, gridBagConstraints);

        jLabel25.setForeground(new java.awt.Color(0, 102, 204));
        jLabel25.setText("Giá");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel42.add(jLabel25, gridBagConstraints);

        txtGia.setEditable(false);
        txtGia.setPreferredSize(new java.awt.Dimension(150, 24));
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel42.add(txtGia, gridBagConstraints);

        jPanel39.add(jPanel42);

        jPanel38.add(jPanel39);

        jPanel40.setPreferredSize(new java.awt.Dimension(702, 250));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel61.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jPanel61.setMinimumSize(new java.awt.Dimension(344, 30));
        jPanel61.setPreferredSize(new java.awt.Dimension(702, 30));

        jLabel46.setForeground(new java.awt.Color(255, 0, 0));

        txtTongTien.setPreferredSize(new java.awt.Dimension(80, 25));

        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setText("Tổng Tiền: ");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel46))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel47))
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel40.add(jPanel61);

        tableLapHoaDon.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableLapHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thực đơn", "Số lượng", "Thành tiền"
            }
        ));
        tableLapHoaDon.setRowHeight(18);
        tableLapHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLapHoaDonMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tableLapHoaDon);

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel62);

        jPanel38.add(jPanel40);

        tabLapHoaDon.add(jPanel38, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Lập Hóa Đơn", tabLapHoaDon);

        tabHoaDonDaLap.setLayout(new java.awt.BorderLayout());

        jPanel35.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel35.setPreferredSize(new java.awt.Dimension(810, 50));
        java.awt.GridBagLayout jPanel35Layout = new java.awt.GridBagLayout();
        jPanel35Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel35Layout.rowHeights = new int[] {0};
        jPanel35.setLayout(jPanel35Layout);

        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Từ Ngày");
        jLabel18.setPreferredSize(new java.awt.Dimension(60, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel35.add(jLabel18, gridBagConstraints);

        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Đến Ngày");
        jLabel19.setMaximumSize(new java.awt.Dimension(1000, 222));
        jLabel19.setMinimumSize(new java.awt.Dimension(100, 26));
        jLabel19.setPreferredSize(new java.awt.Dimension(60, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel35.add(jLabel19, gridBagConstraints);

        jButton18.setForeground(new java.awt.Color(0, 102, 204));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass-16.png"))); // NOI18N
        jButton18.setText("Tìm Kiếm");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel35.add(jButton18, gridBagConstraints);

        jDateTuNgay.setPreferredSize(new java.awt.Dimension(120, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel35.add(jDateTuNgay, gridBagConstraints);

        jDateDenNgay.setPreferredSize(new java.awt.Dimension(120, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel35.add(jDateDenNgay, gridBagConstraints);

        tabHoaDonDaLap.add(jPanel35, java.awt.BorderLayout.PAGE_START);

        jPanel36.setLayout(new java.awt.BorderLayout());

        tableDSHD.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Lập", "Mã Nhân Viên", "Mã Quầy"
            }
        ));
        tableDSHD.setEnabled(false);
        tableDSHD.setRowHeight(18);
        jScrollPane5.setViewportView(tableDSHD);

        jPanel36.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(754, 40));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Tiền Lương");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabel2, gridBagConstraints);

        textTienLuong.setText("5,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel3.add(textTienLuong, gridBagConstraints);

        jLabel3.setText("VNĐ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabel3, gridBagConstraints);

        jPanel36.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        tabHoaDonDaLap.add(jPanel36, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Hóa Đơn Đã Lập", tabHoaDonDaLap);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setMaximumSize(new java.awt.Dimension(2147483647, 2000));
        jPanel10.setMinimumSize(new java.awt.Dimension(54, 200));
        jPanel10.setPreferredSize(new java.awt.Dimension(758, 200));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel11.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel11.setPreferredSize(new java.awt.Dimension(754, 100));

        tableCTTD.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableCTTD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Đồ Uống", "Mã Nguyên Liệu", "Tên Nguyên Liệu", "Đơn Vị Tính", "Số Lượng Cần"
            }
        ));
        tableCTTD.setEnabled(false);
        tableCTTD.setRowHeight(18);
        jScrollPane16.setViewportView(tableCTTD);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel12.setPreferredSize(new java.awt.Dimension(754, 50));

        jLabel59.setForeground(new java.awt.Color(0, 102, 204));
        jLabel59.setText("Tên Đồ Uống");
        jPanel12.add(jLabel59);

        comboTenDoUong.setPreferredSize(new java.awt.Dimension(200, 28));
        comboTenDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTenDoUongActionPerformed(evt);
            }
        });
        jPanel12.add(comboTenDoUong);

        jPanel10.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel9.add(jPanel10);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jPanel13.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel13.setPreferredSize(new java.awt.Dimension(758, 170));

        tableThucDon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableThucDon.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableThucDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Đồ Uống", "Giá Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableThucDon.setEnabled(false);
        tableThucDon.setRowHeight(18);
        jScrollPane1.setViewportView(tableThucDon);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel13);

        jScrollPane3.setViewportView(jPanel9);

        javax.swing.GroupLayout tabThonTinThucDonLayout = new javax.swing.GroupLayout(tabThonTinThucDon);
        tabThonTinThucDon.setLayout(tabThonTinThucDonLayout);
        tabThonTinThucDonLayout.setHorizontalGroup(
            tabThonTinThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThonTinThucDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabThonTinThucDonLayout.setVerticalGroup(
            tabThonTinThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThonTinThucDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Thực Đơn", tabThonTinThucDon);

        tableNguyenLieu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tableNguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nguyên Liệu", "Tên Nguyên Liệu", "Đơn Vị Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNguyenLieu.setEnabled(false);
        tableNguyenLieu.setFocusable(false);
        tableNguyenLieu.setOpaque(false);
        tableNguyenLieu.setRequestFocusEnabled(false);
        tableNguyenLieu.setRowHeight(18);
        tableNguyenLieu.setSurrendersFocusOnKeystroke(true);
        tableNguyenLieu.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tableNguyenLieu);

        javax.swing.GroupLayout tabNguyenLieuLayout = new javax.swing.GroupLayout(tabNguyenLieu);
        tabNguyenLieu.setLayout(tabNguyenLieuLayout);
        tabNguyenLieuLayout.setHorizontalGroup(
            tabNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNguyenLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabNguyenLieuLayout.setVerticalGroup(
            tabNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNguyenLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Nguyên Liệu", tabNguyenLieu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(58, 30));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu.png"))); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Thông Tin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Đăng Xuất");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Đổi mật khẩu");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setText("Quản Lý");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ThongTinNhanVien t = new ThongTinNhanVien();
        t.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        t.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        formDangNhap d = new formDangNhap();
        d.setLocationRelativeTo(this);
        d.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtMAHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMAHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMAHDActionPerformed

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        CTHD cthd = new CTHD();
        ThucDon tddk = new ThucDon();
        tddk = new Dao_FormNhanVien().findListTDwith((String) comboTENDOUONG.getSelectedItem());
        cthd.setMaHD(txtMAHD.getText());
        cthd.setMaTD(tddk.getId());
        cthd.setSoLuongLy((int) spinnerSoLuong.getValue());
        cthd.setGiaTien(tddk.getGia() * cthd.getSoLuongLy());
        dscthd.add(cthd);
        int indexThem = dscthd.size() - 1;
        if (kiemTraTrungMATD(indexThem) && dscthd.size() > 1) {
            dscthd.remove(dscthd.size() - 1);
            JOptionPane.showMessageDialog(rootPane, "Khong duoc them trung Do uong");
        }
        txtTongTien.setText(Integer.toString(tinhBill()));
        showTableCTHD();
    }//GEN-LAST:event_ThemButtonActionPerformed

    public int tinhBill() {
        int giaTien = 0;
        for (CTHD cthd : dscthd) {
            giaTien += cthd.getGiaTien();
        }
        return giaTien;
    }

    private void LuuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuuButtonActionPerformed
        //Them hoaDon
        HoaDon hd = new HoaDon();
        hd.setMaHD(txtMAHD.getText());
        hd.setNgayTao(panelLapHD.setDate(txtNGAYLAP.getText()));
        String taiKhoan = null;
        taiKhoan = formDangNhap.taiKhoanNV;
        NhanVien nv = new Dao_FormNhanVien().getNhanVienTK(taiKhoan);

        hd.setMaNV(nv.getMaNV());
        int selectedQuay = Integer.parseInt((String) comboMAQUAY.getSelectedItem());
        hd.setMaQuay(selectedQuay);
        if (!dscthd.isEmpty()) {
            if (new Dao_FormNhanVien().addhoaDon(hd)) {
                JOptionPane.showMessageDialog(rootPane, "Them hoa don thanh cong!");
                dshd.add(hd);
                addCTHD();
                huyHoaDon();

                //load ds hd
                dshd = new Dao_FormNhanVien().getListHDAll();
                showTableDSHD();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Khong the them vi trung MAHD! ");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm chi tiết hóa đơn!");
        }
    }//GEN-LAST:event_LuuButtonActionPerformed

    public void addCTHD() {
        for (CTHD cthd : dscthd) {
            new Dao_FormNhanVien().addCTHD(cthd);
        }
    }

    public void showTableCTHD() {
        model = (DefaultTableModel) tableLapHoaDon.getModel();
        ((DefaultTableModel) tableLapHoaDon.getModel()).setRowCount(0);
        for (CTHD cthd : dscthd) {
            model.addRow(new Object[]{
                cthd.getMaTD(), cthd.getSoLuongLy(), cthd.getGiaTien()
            });
        }

    }

    private void txtNGAYLAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNGAYLAPActionPerformed
        // TODO add your handling code here:
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
    }//GEN-LAST:event_txtNGAYLAPActionPerformed

    private void comboTenDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTenDoUongActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboTenDoUong.getSelectedItem();
        ((DefaultTableModel) tableCTTD.getModel()).setRowCount(0);
        model = (DefaultTableModel) tableCTTD.getModel();
        cttd = new Dao_FormNhanVien().findListTD(selectedItem);
        showTableCTTD();
    }//GEN-LAST:event_comboTenDoUongActionPerformed

    public void showTableCTTD() {
        for (NhanVienCTTD chitiet : cttd) {
            model.addRow(new Object[]{
                chitiet.getTENDOUONG(), chitiet.getMANL(), chitiet.getSOLUONG_CAN(), chitiet.getTENNGUYENLIEU(), chitiet.getDVT()
            });
        }
    }

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String TUNGAY = dateFormat.format(jDateTuNgay.getDate());
        String DENNGAY = dateFormat.format(jDateDenNgay.getDate());
        dshd = new Dao_FormNhanVien().getListHD(TUNGAY, DENNGAY);
        //in tim kiem
        ((DefaultTableModel) tableDSHD.getModel()).setRowCount(0);
        model = (DefaultTableModel) tableDSHD.getModel();
        showTableDSHD();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked

    }//GEN-LAST:event_jButton18MouseClicked

    private void tableLapHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLapHoaDonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tableLapHoaDonMouseClicked

    private void comboMAQUAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMAQUAYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMAQUAYActionPerformed

    private void comboTENDOUONGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTENDOUONGActionPerformed
        // TODO add your handling code here:
        ThucDon tddk = new ThucDon();
        tddk = new Dao_FormNhanVien().findListTDwith((String) comboTENDOUONG.getSelectedItem());
        txtGia.setText(Integer.toString(tddk.getGia()));
    }//GEN-LAST:event_comboTENDOUONGActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tableLapHoaDon.getModel();
        int i = tableLapHoaDon.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(rootPane, "Chon 1 dong de xoa!");
        } else if (dscthd.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Khong co thong tin de xoa!");
        } else {
            dscthd.remove(i);
            txtTongTien.setText(Integer.toString(tinhBill()));
            showTableCTHD();
        }
    }//GEN-LAST:event_XoaButtonActionPerformed

    private boolean kiemTraTrungMATD(int index) {
        model = (DefaultTableModel) tableLapHoaDon.getModel();
        int i = 0;
        for (CTHD cthd : dscthd) {
            if (dscthd.get(i).getMaTD() == dscthd.get(index).getMaTD()) {
                if (i == index) {
                    continue;
                }
                return true;
            }
            i++;
        }
        return false;
    }

    private boolean findIndex(int MATD, int index) {
        int i = 0;
        for (CTHD cthd : dscthd) {
            if (dscthd.get(i).getMaTD() == MATD && index != i) {
                return true;
            }
        }
        return false;
    }

    private boolean kiemTraTrungMATDSUA(int index1, int index2) {
        model = (DefaultTableModel) tableLapHoaDon.getModel();
        int i = 0;
        for (CTHD cthd : dscthd) {
            if (dscthd.get(i).getMaTD() == dscthd.get(index1).getMaTD()) {
                if (i == index2) {
                    continue;
                }
                return true;
            }
            i++;
        }
        return false;
    }

    private void SuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaButtonActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tableLapHoaDon.getModel();
        int i = tableLapHoaDon.getSelectedRow();
        ThucDon tddk = new ThucDon();
        tddk = new Dao_FormNhanVien().findListTDwith((String) comboTENDOUONG.getSelectedItem());
        CTHD cthdSua = new CTHD();
        cthdSua.setMaTD(tddk.getId());
        cthdSua.setSoLuongLy((Integer) spinnerSoLuong.getValue());
        cthdSua.setGiaTien(tddk.getGia() * (Integer) spinnerSoLuong.getValue());

        if (i == -1) {
            JOptionPane.showMessageDialog(rootPane, "Chon 1 dong de xoa!");
        } else if (dscthd.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Khong co thong tin de xoa!");
        } else if (findIndex(cthdSua.getMaTD(), i)) {
            JOptionPane.showMessageDialog(rootPane, "Khong the sua");
        } else {
            dscthd.set(i, cthdSua);
            showTableCTHD();
            txtTongTien.setText(Integer.toString(tinhBill()));
        }
    }//GEN-LAST:event_SuaButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        formDoiMatKhau t = new formDoiMatKhau();
        t.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        t.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void huyHoaDon() {
        txtMAHD.setText("");
        comboTENDOUONG.setSelectedIndex(0);
        spinnerSoLuong.setValue(1);
        dscthd.removeAll(dscthd);
        dshd.removeAll(dshd);
        ((DefaultTableModel) tableLapHoaDon.getModel()).setRowCount(0);
        txtTongTien.setText(Integer.toString(tinhBill()));
        showTableCTHD();
    }

    private void huyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("view.formNhanVien.huyButtonActionPerformed()");
        huyHoaDon();
    }//GEN-LAST:event_huyButtonActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jMenuItem4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            formThongTinQL f = new formThongTinQL(Dao_NhanVien.layThongTinQL("ADMIN"));
            f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            f.nhanVien();
            f.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4MouseReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formNhanVien().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LuuButton;
    private javax.swing.JButton SuaButton;
    private javax.swing.JButton ThemButton;
    private javax.swing.JButton XoaButton;
    private javax.swing.JComboBox<String> comboMAQUAY;
    private javax.swing.JComboBox<String> comboTENDOUONG;
    private javax.swing.JComboBox<String> comboTenDoUong;
    private javax.swing.JButton huyButton;
    private javax.swing.JButton jButton18;
    private com.toedter.calendar.JDateChooser jDateDenNgay;
    private com.toedter.calendar.JDateChooser jDateTuNgay;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner spinnerSoLuong;
    private javax.swing.JPanel tabHoaDonDaLap;
    private javax.swing.JPanel tabLapHoaDon;
    private javax.swing.JPanel tabNguyenLieu;
    private javax.swing.JPanel tabThonTinThucDon;
    private javax.swing.JTable tableCTTD;
    private javax.swing.JTable tableDSHD;
    private javax.swing.JTable tableLapHoaDon;
    private javax.swing.JTable tableNguyenLieu;
    private javax.swing.JTable tableThucDon;
    private javax.swing.JTextField textTienLuong;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMAHD;
    private javax.swing.JTextField txtNGAYLAP;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
