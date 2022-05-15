//nghia

package view;

import valid.MaxLength;
import dao.Dao_CTTD;
import dao.Dao_NguyenLieu;
import dao.Dao_ThucDon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.CTTD;
import model.NguyenLieu;
import model.ThucDon;
import valid.Regex;
import valid.Valid;

/**
 *
 * @author nghia
 */
public class panelCTTD extends javax.swing.JPanel {

    /**
     * Creates new form panelCTTD
     */
    private DefaultTableModel dtm;
    private List<CTTD> listCTTD;

    public panelCTTD() {
        initComponents();
        listCTTD = Dao_CTTD.layDS();
        tableCTTD.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        JTextField text = (JTextField) cbbTenTD.getEditor().getEditorComponent();
        text.setText("");
        text.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//                    System.out.println("esc key type");
                    cbbTenTD.setSelectedIndex(-1);
                } else {
                    setModelComboBoxTenDoUong(e);
                }
            }
        });
//        AutoCompleteDecorator.decorate(cbbTenTD);
        loadComboBoxQuay(Dao_NguyenLieu.layDS(), cbbNguyenLieu);
        cbbNguyenLieu.setSelectedIndex(-1);
        layDSCTTD(listCTTD);
        setMaxLength();
    }

    private void setMaxLength() {
        txtDonViTinh.setDocument(new MaxLength(40));
        txtSoLuongCan.setDocument(new MaxLength(15));
    }

    private void layDSCTTD(List<CTTD> list) {
        dtm = (DefaultTableModel) tableCTTD.getModel();
        dtm.setRowCount(0);
        for (CTTD ct : list) {
            dtm.addRow(new Object[]{
                Dao_ThucDon.layThucDon_Ma(ct.getMaTD()).getTen(),
                Dao_NguyenLieu.layNL(ct.getMaNL()).getTenNL(),
                Dao_NguyenLieu.layNL(ct.getMaNL()).getDonViTinh(),
                ct.getSoLuongCan()
            });
//            System.out.println(dao_ThucDon.layThucDon_Ma(ct.getMaTD()).getTen());
        }
    }

    public static void loadComboBoxQuay(List<NguyenLieu> list, JComboBox cbb) {
        cbb.removeAllItems();
        list.forEach((NguyenLieu q) -> {
            cbb.addItem(q.getTenNL());
        });
        cbb.setSelectedIndex(-1);
    }

    private int isTenDoUongValid() {
        if (cbbTenTD.getSelectedItem() == null) {
            return 0;
        } else {
            return 1; //đúng định dạng
        }
    }

    private int isTenNguyenLieuValid() {
        if (cbbNguyenLieu.getSelectedIndex() == -1) {
            return 0;
        } else {
            return 1;
        }
    }

    private int isSoLuongCan() {
        String slcan = txtSoLuongCan.getText().trim();
        if (slcan.equals("")) {
            return 0;
        } else if (!Valid.isTextValid(slcan, Regex.SLCAN)) {
            return -1;
        } else {
            return 1;
        }
    }

    //
    private boolean isAllValid() {
        if (isTenDoUongValid() == 1 && isTenNguyenLieuValid() == 1 && isSoLuongCan() == 1) {
            return true;
        } else if (isTenDoUongValid() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn đồ uống!");
            return false;
        } else if (isTenNguyenLieuValid() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nguyên liệu!");
            return false;
        } else if (isSoLuongCan() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng cần!");
            return false;
        } else if (isSoLuongCan() == -1) {
            JOptionPane.showMessageDialog(null, "không phải số!");
            return false;
        }
        return true;
    }

    //set đơn vị tính khi cbb thay đổi
    private void cbbTenDoUongItemChange(String item) {
        if (cbbNguyenLieu.getSelectedIndex() == -1) {
            txtDonViTinh.setText("");
        } else {
//            System.out.println("item " + item);
            String dvt = Dao_NguyenLieu.layNL(item).getDonViTinh();
            txtDonViTinh.setText(dvt);
//            System.out.println("DVT " + dvt);
        }
    }

    //set model dựa vào text
    private void setModelComboBoxTenDoUong(java.awt.event.KeyEvent evt) {
        String text = ((JTextField) evt.getSource()).getText();
//        System.out.println("text " + text);
        List<ThucDon> listThucDon = Dao_ThucDon.layDSTD_ten(text);
        String[] s;
        if (listThucDon != null && !listThucDon.isEmpty()) {
            s = new String[listThucDon.size()];
            for (int i = 0; i < listThucDon.size(); i++) {
                s[i] = listThucDon.get(i).getTen();
            }
            cbbTenTD.setModel(new DefaultComboBoxModel(s));
            cbbTenTD.setSelectedIndex(-1);
            ((JTextField) cbbTenTD.getEditor().getEditorComponent()).setText(text);
            cbbTenTD.showPopup();
        } else {
            s = new String[1];
            s[0] = "Không Tìm Thấy";
            cbbTenTD.setModel(new DefaultComboBoxModel(s));
            cbbTenTD.setSelectedIndex(-1);
            ((JTextField) cbbTenTD.getEditor().getEditorComponent()).setText(text);
            cbbTenTD.showPopup();
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

        jPanel79 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        cbbTenTD = new javax.swing.JComboBox<>();
        cbbNguyenLieu = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        btnThemCTTD = new javax.swing.JButton();
        btnSuaCTTD = new javax.swing.JButton();
        txtSoLuongCan = new javax.swing.JTextField();
        jPanel84 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tableCTTD = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel79.setMaximumSize(new java.awt.Dimension(500, 12312312));
        jPanel79.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel79.setPreferredSize(new java.awt.Dimension(300, 200));
        java.awt.GridBagLayout jPanel79Layout = new java.awt.GridBagLayout();
        jPanel79Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel79Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel79.setLayout(jPanel79Layout);

        jLabel62.setForeground(new java.awt.Color(0, 102, 204));
        jLabel62.setText("Tên Đồ Uống");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_LEADING;
        jPanel79.add(jLabel62, gridBagConstraints);

        cbbTenTD.setEditable(true);
        cbbTenTD.setPreferredSize(new java.awt.Dimension(200, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel79.add(cbbTenTD, gridBagConstraints);

        cbbNguyenLieu.setPreferredSize(new java.awt.Dimension(200, 28));
        cbbNguyenLieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNguyenLieuItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel79.add(cbbNguyenLieu, gridBagConstraints);

        jLabel63.setForeground(new java.awt.Color(0, 102, 204));
        jLabel63.setText("Tên Nguyên Liệu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel79.add(jLabel63, gridBagConstraints);

        jLabel64.setForeground(new java.awt.Color(0, 102, 204));
        jLabel64.setText("Đơn Vị Tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel79.add(jLabel64, gridBagConstraints);

        txtDonViTinh.setEditable(false);
        txtDonViTinh.setPreferredSize(new java.awt.Dimension(200, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel79.add(txtDonViTinh, gridBagConstraints);

        jLabel65.setForeground(new java.awt.Color(0, 102, 204));
        jLabel65.setText("Số Lượng Cần");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel79.add(jLabel65, gridBagConstraints);

        btnThemCTTD.setForeground(new java.awt.Color(0, 102, 204));
        btnThemCTTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy-disk-24.png"))); // NOI18N
        btnThemCTTD.setText("Thêm");
        btnThemCTTD.setPreferredSize(new java.awt.Dimension(90, 36));
        btnThemCTTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemCTTDMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        jPanel79.add(btnThemCTTD, gridBagConstraints);

        btnSuaCTTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-24.png"))); // NOI18N
        btnSuaCTTD.setText("Sửa");
        btnSuaCTTD.setPreferredSize(new java.awt.Dimension(90, 36));
        btnSuaCTTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaCTTDMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 16;
        jPanel79.add(btnSuaCTTD, gridBagConstraints);

        txtSoLuongCan.setPreferredSize(new java.awt.Dimension(200, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel79.add(txtSoLuongCan, gridBagConstraints);

        add(jPanel79);

        jPanel84.setPreferredSize(new java.awt.Dimension(550, 250));

        tableCTTD.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tableCTTD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Đồ Uống", "Tên Nguyên Liệu", "Đơn Vị Tính", "Số Lượng Cần"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCTTD.setToolTipText("Nhấn Nút Delete Trên Bàn Phím Để Xóa");
        tableCTTD.setRowHeight(18);
        tableCTTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCTTDMouseClicked(evt);
            }
        });
        tableCTTD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableCTTDKeyPressed(evt);
            }
        });
        jScrollPane17.setViewportView(tableCTTD);
        if (tableCTTD.getColumnModel().getColumnCount() > 0) {
            tableCTTD.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        add(jPanel84);
    }// </editor-fold>//GEN-END:initComponents

    private void tableCTTDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCTTDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int row = tableCTTD.getSelectedRow();
            if (row != -1) {
                int option = JOptionPane.showConfirmDialog(this, "Thao Tác Này Sẽ Xóa Dòng Đang Chọn!", "Bạn Có Muốn Xóa Không?", JOptionPane.WARNING_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    int maTD = Dao_ThucDon.layMa((String) tableCTTD.getValueAt(row, 0));
                    int maNL = Dao_NguyenLieu.layNL((String) tableCTTD.getValueAt(row, 1)).getMaNL();
                    if (Dao_CTTD.xoaCTTD(maTD, maNL) != 0) {
                        layDSCTTD(Dao_CTTD.layDS());
                        reset();
                        JOptionPane.showMessageDialog(this, "Đã Xóa!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Không Thể Xóa!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy Chọn Dòng Cần Xóa!");
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            reset();
        }
    }//GEN-LAST:event_tableCTTDKeyPressed

    private void cbbNguyenLieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNguyenLieuItemStateChanged
        // TODO add your handling code here:
//        System.out.println(cbbNguyenLieu.getSelectedIndex());
        if (cbbNguyenLieu.getSelectedIndex() != -1) {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
//                System.out.println("item change");
                String item = evt.getItem().toString();
                cbbTenDoUongItemChange(item);
            }
        }
    }//GEN-LAST:event_cbbNguyenLieuItemStateChanged

    private void layTuBangCTTD(int row) {
        String tenDoUong = (String) tableCTTD.getValueAt(row, 0);
        String tenNL = (String) tableCTTD.getValueAt(row, 1);
        float slCan = (float) tableCTTD.getValueAt(row, 3);
        cbbNguyenLieu.setSelectedItem(tenNL);
        cbbTenTD.setSelectedItem(tenDoUong);
        txtSoLuongCan.setText(slCan + "");

        cbbNguyenLieu.setEnabled(false);
        cbbNguyenLieu.setForeground(Color.WHITE);
        cbbTenTD.setEnabled(false);
        cbbTenTD.setForeground(Color.WHITE);
    }

    private void reset() {
        cbbNguyenLieu.setEnabled(true);
        cbbNguyenLieu.setForeground(Color.BLACK);
        cbbNguyenLieu.setSelectedIndex(-1);
        cbbTenTD.setEnabled(true);
        cbbTenTD.setForeground(Color.BLACK);
        cbbTenTD.setSelectedIndex(-1);
        txtDonViTinh.setText("");
        txtSoLuongCan.setText("");

        tableCTTD.clearSelection();
    }

    private void tableCTTDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCTTDMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int row = tableCTTD.getSelectedRow();
            if (row != -1) {
                layTuBangCTTD(row);
            }
        }
    }//GEN-LAST:event_tableCTTDMouseClicked

    private void btnThemCTTDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemCTTDMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (isAllValid()) {
                int maTD = Dao_ThucDon.layMa((String) cbbTenTD.getSelectedItem());
                int maNL = Dao_NguyenLieu.layNL((String) cbbNguyenLieu.getSelectedItem()).getMaNL();
                float slCan = Float.parseFloat(txtSoLuongCan.getText().trim());
                //kiểm tra tồn tại
                if (!Dao_CTTD.ktTonTai(maTD, maNL)) {
                    if (Dao_CTTD.themCTTD(maTD, maNL, slCan) != 0) {
                        listCTTD = Dao_CTTD.layDS();
                        layDSCTTD(Dao_CTTD.layDS());
                    } else {
                        JOptionPane.showMessageDialog(this, "Không Thể Thêm!\nTên Nguyên Liệu Và Tên Đồ Uống Bị Trùng!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Tên đồ uống này đã có nguyên liệu này rồi!");
                }
            }
        }
    }//GEN-LAST:event_btnThemCTTDMouseClicked

    private void btnSuaCTTDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaCTTDMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int row = tableCTTD.getSelectedRow();
            if (row != -1) {
                if (isAllValid()) {
                    int maTD = Dao_ThucDon.layMa((String) cbbTenTD.getSelectedItem());
                    int maNL = Dao_NguyenLieu.layNL((String) cbbNguyenLieu.getSelectedItem()).getMaNL();
                    float slCan = Float.parseFloat(txtSoLuongCan.getText().trim());
                    if (Dao_CTTD.suaCTTD(maTD, maNL, slCan) != 0) {
                        layDSCTTD(Dao_CTTD.layDS());
                        reset();
                        JOptionPane.showMessageDialog(this, "Cập Nhật Thành công!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Không Thể Cập Nhật!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nếu chưa chọn thì cho nút sửa mờ đi");
            }
        }
    }//GEN-LAST:event_btnSuaCTTDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaCTTD;
    private javax.swing.JButton btnThemCTTD;
    private javax.swing.JComboBox<String> cbbNguyenLieu;
    private javax.swing.JComboBox<String> cbbTenTD;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JTable tableCTTD;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtSoLuongCan;
    // End of variables declaration//GEN-END:variables
}
