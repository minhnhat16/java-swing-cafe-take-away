//nghia

package view;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.KetNoi;

/**
 *
 * @author nghia
 */
public class dialogStartProgram extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     */
    private Thread thread;
    private static dialogStartProgram dialog;

    public dialogStartProgram(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        overRide();
        formDangNhap.loadImage(labelHinhAnh, labelHinhAnh.getWidth(),
                labelHinhAnh.getHeight(), "src\\icon\\java.jpg");
        start();
    }

    private void start() {
        thread = new Thread() {
            @Override
            public void run() {
                Random rd = new Random();
                int c;
                formDangNhap main;
                java.sql.Connection connection = null;
                for (int i = 0; progressStart.getValue() < 100;) {
                    if (progressStart.getValue() > 80 && progressStart.getValue() < 100) {
                        connection = KetNoi.layKetNoi();
                        if (connection == null) {
                            progressStart.setValue(100);
                            progressStart.setString("Không Thể Khởi Động Chương Trình");
                            break;
                        } else {
                            progressStart.setValue(100);
                            progressStart.setString("Starting Program");
                        }
                    } else {
                        c = rd.nextInt(8) + 1;
                        progressStart.setValue(i);
                        i += c;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(dialogStartProgram.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (connection != null) {
                    progressStart.setString("Starting Program");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(dialogStartProgram.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialog.dispose();
                    main = new formDangNhap();
                    main.setResizable(false);
                    main.setVisible(true);
                } else {
//                    System.out.println("den đay");
                    dialog.dispose();
                    System.exit(0);
                }
            }
        };
        thread.start();
    }

    private void overRide() {
        setLocationRelativeTo(null);
        setResizable(false);
        progressStart.setStringPainted(true);
        progressStart.setBackground(Color.GREEN);
        progressStart.setForeground(Color.black);

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
        progressStart = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        labelHinhAnh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        progressStart.setForeground(new java.awt.Color(0, 51, 255));
        progressStart.setPreferredSize(new java.awt.Dimension(400, 20));
        jPanel1.add(progressStart);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        evt.toString();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (var info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException/*ClassNotFoundException*/ | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogStartProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dialog = new dialogStartProgram(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.dispose();
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JProgressBar progressStart;
    // End of variables declaration//GEN-END:variables
}
