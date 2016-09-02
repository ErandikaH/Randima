/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randimaexporters;

import backup.BackupAndRestore;
import buyer.BuyerForm;
import buyerPayment.ChequeForm;
import category.CategoryForm;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import grn.GrnForm;
import invoice.MakeOrder;
import item.ItemForm;
import java.io.File;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import order.OrderForm;
import orderDetail.OrderDetailForm;
import product.ProductForm;
import reporting.report.ReportView;
import reporting.report.Reports1;
import supplier.SupplierForm;
import supplierInvoice.MakeGrn;
import supplierPayment.CashForm;
import utility.DBCon;

/**
 *
 * @author PC
 */
public class MainMenu extends javax.swing.JFrame {

    private BuyerForm bf = null;
    private CashForm cf = null;//supplier
    private buyerPayment.CashForm bch = null;
    private buyerPayment.ChequeForm bpcf = null;
    private supplierPayment.ChequeForm scf = null;
    private CategoryForm caf = null;
    private GrnForm gf = null;
    private ItemForm iF = null;
    private OrderForm of = null;
    private OrderDetailForm odf = null;
    private ProductForm pf = null;
    private SupplierForm sf = null;
    private MakeOrder mo = null;
    private MakeGrn mg = null;
    private Reports1 r = null;

    /**
     * Creates new form MainMenu1
     */
    public MainMenu() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/randimaexporters/back2.jpg"));
        jXImagePanel1.setImage(icon.getImage());

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/randimaexporters/back10.jpg"));
        jXImagePanel2.setImage(icon1.getImage());

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/randimaexporters/back9.jpg"));
        jXImagePanel6.setImage(icon2.getImage());

        ImageIcon icon3 = new ImageIcon(getClass().getResource("/randimaexporters/back6.jpg"));
        jXImagePanel4.setImage(icon3.getImage());

        ImageIcon icon4 = new ImageIcon(getClass().getResource("/randimaexporters/back11.jpg"));
        jXImagePanel9.setImage(icon4.getImage());

        ImageIcon icon5 = new ImageIcon(getClass().getResource("/randimaexporters/back13_1.jpg"));
        jXImagePanel12.setImage(icon5.getImage());

        ImageIcon icon6 = new ImageIcon(getClass().getResource("/randimaexporters/back5.jpg"));
        jXImagePanel30.setImage(icon6.getImage());

        ImageIcon icon7 = new ImageIcon(getClass().getResource("/randimaexporters/back12.jpg"));
        jXImagePanel15.setImage(icon7.getImage());

        ImageIcon icon8 = new ImageIcon(getClass().getResource("/randimaexporters/back1.jpg"));
        jXImagePanel31.setImage(icon8.getImage());

        ImageIcon icon9 = new ImageIcon(getClass().getResource("/randimaexporters/back8.jpg"));
        jXImagePanel18.setImage(icon9.getImage());

        ImageIcon icon10 = new ImageIcon(getClass().getResource("/randimaexporters/back4.jpg"));
        jXImagePanel21.setImage(icon10.getImage());

        ImageIcon icon11 = new ImageIcon(getClass().getResource("/randimaexporters/back3.jpg"));
        jXImagePanel5.setImage(icon11.getImage());

        ImageIcon icon13 = new ImageIcon(getClass().getResource("/randimaexporters/back7.jpg"));
        jXImagePanel8.setImage(icon13.getImage());

        ImageIcon icon14 = new ImageIcon(getClass().getResource("/randimaexporters/backk.jpg"));
        jXImagePanel35.setImage(icon14.getImage());

        ImageIcon icon12 = new ImageIcon(getClass().getResource("/randimaexporters/back13.jpg"));
        jXImagePanel3.setImage(icon12.getImage());
        jXImagePanel7.setImage(icon12.getImage());
        jXImagePanel10.setImage(icon12.getImage());
        jXImagePanel13.setImage(icon12.getImage());
        jXImagePanel16.setImage(icon12.getImage());
        jXImagePanel19.setImage(icon12.getImage());
        jXImagePanel22.setImage(icon12.getImage());
        jXImagePanel36.setImage(icon12.getImage());


        setLocationRelativeTo(null);
    }

    private boolean isValidYear(String year) {

        if (year.isEmpty()) {
            return false;
        }

        if (year.length() > 5) {
            return false;
        }

        String st = year.substring(0, year.length());
        char[] digit = st.toCharArray();
        for (char ch : digit) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidDollar(String dollar) {

        if (dollar.isEmpty()) {
            return false;
        }

        char last = dollar.charAt(dollar.length() - 1);
        String previous = dollar.substring(0, dollar.length() - 1);

        if (!Character.isDigit(last) && !(last == '.' && !previous.contains("."))) {
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXImagePanel1 = new org.jdesktop.swingx.JXImagePanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jXImagePanel2 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel3 = new org.jdesktop.swingx.JXImagePanel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jXImagePanel6 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel7 = new org.jdesktop.swingx.JXImagePanel();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jXImagePanel9 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel10 = new org.jdesktop.swingx.JXImagePanel();
        jButton3 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jXImagePanel12 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel13 = new org.jdesktop.swingx.JXImagePanel();
        jButton4 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jXImagePanel15 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel16 = new org.jdesktop.swingx.JXImagePanel();
        jButton5 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jXImagePanel18 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel19 = new org.jdesktop.swingx.JXImagePanel();
        jButton6 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jXImagePanel21 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel22 = new org.jdesktop.swingx.JXImagePanel();
        jButton7 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jXImagePanel31 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel27 = new org.jdesktop.swingx.JXImagePanel();
        jLabel42 = new javax.swing.JLabel();
        jXImagePanel28 = new org.jdesktop.swingx.JXImagePanel();
        jLabel44 = new javax.swing.JLabel();
        jXImagePanel11 = new org.jdesktop.swingx.JXImagePanel();
        jButton11 = new javax.swing.JButton();
        jXImagePanel14 = new org.jdesktop.swingx.JXImagePanel();
        jButton12 = new javax.swing.JButton();
        jXImagePanel17 = new org.jdesktop.swingx.JXImagePanel();
        jButton8 = new javax.swing.JButton();
        jXImagePanel20 = new org.jdesktop.swingx.JXImagePanel();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jXImagePanel5 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel32 = new org.jdesktop.swingx.JXImagePanel();
        profitButton = new javax.swing.JButton();
        yearText = new javax.swing.JTextField();
        dollarText = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jXImagePanel23 = new org.jdesktop.swingx.JXImagePanel();
        valuableBuyerButton2 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jXImagePanel26 = new org.jdesktop.swingx.JXImagePanel();
        valuableProductButton = new javax.swing.JButton();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jXImagePanel34 = new org.jdesktop.swingx.JXImagePanel();
        movableProductButton = new javax.swing.JButton();
        jLabel100 = new javax.swing.JLabel();
        reportButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jXImagePanel30 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel24 = new org.jdesktop.swingx.JXImagePanel();
        backupButton = new javax.swing.JButton();
        restoreButton = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jXImagePanel4 = new org.jdesktop.swingx.JXImagePanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jXImagePanel8 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel37 = new org.jdesktop.swingx.JXImagePanel();
        jButton14 = new javax.swing.JButton();
        jXImagePanel38 = new org.jdesktop.swingx.JXImagePanel();
        jButton15 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jXImagePanel35 = new org.jdesktop.swingx.JXImagePanel();
        jXImagePanel36 = new org.jdesktop.swingx.JXImagePanel();
        jButton16 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jXImagePanel1.setPreferredSize(new java.awt.Dimension(826, 660));

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buyer Form");
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton1MouseMoved(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel3Layout = new javax.swing.GroupLayout(jXImagePanel3);
        jXImagePanel3.setLayout(jXImagePanel3Layout);
        jXImagePanel3Layout.setHorizontalGroup(
            jXImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel3Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(66, 66, 66))
        );
        jXImagePanel3Layout.setVerticalGroup(
            jXImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setText("Buyer Form Detail");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("*   Add Buyer");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("*   Delete Buyer");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("*   Search Buyer");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("*   Update Buyer");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("*   View Buyer");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Buyer ID");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Buyer Name");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Comapany Name");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Company Address");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Telephone");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("City");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Country");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("E -Mail");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Web site");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Buyer Title");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Fax");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setText("Postal code");

        javax.swing.GroupLayout jXImagePanel2Layout = new javax.swing.GroupLayout(jXImagePanel2);
        jXImagePanel2.setLayout(jXImagePanel2Layout);
        jXImagePanel2Layout.setHorizontalGroup(
            jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addGap(37, 37, 37))
            .addGroup(jXImagePanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jXImagePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        jXImagePanel2Layout.setVerticalGroup(
            jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(jXImagePanel2Layout.createSequentialGroup()
                        .addGroup(jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXImagePanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(jXImagePanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)))
                .addGap(0, 107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("     Buyer", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/1.jpg")), jPanel1); // NOI18N

        jXImagePanel7.setPreferredSize(new java.awt.Dimension(287, 68));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Orders");
        jButton2.setBorderPainted(false);
        jButton2.setEnabled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton2MouseMoved(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel7Layout = new javax.swing.GroupLayout(jXImagePanel7);
        jXImagePanel7.setLayout(jXImagePanel7Layout);
        jXImagePanel7Layout.setHorizontalGroup(
            jXImagePanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel7Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jButton2)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jXImagePanel7Layout.setVerticalGroup(
            jXImagePanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel23.setText("Orders");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setText("*   Add Order");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setText("*   Delete Order");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setText("*   Search Order");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setText("*   Update Order");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("*   View Order");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setText("Order ID");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setText("Order Date");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel31.setText("Status");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setText("Delivery Date");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel40.setText("Buyer ID");

        javax.swing.GroupLayout jXImagePanel6Layout = new javax.swing.GroupLayout(jXImagePanel6);
        jXImagePanel6.setLayout(jXImagePanel6Layout);
        jXImagePanel6Layout.setHorizontalGroup(
            jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
            .addGroup(jXImagePanel6Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jXImagePanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel6Layout.createSequentialGroup()
                        .addGroup(jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel6Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel29))
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel6Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))))
        );
        jXImagePanel6Layout.setVerticalGroup(
            jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel6Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel30)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel38))
                    .addGroup(jXImagePanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXImagePanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel40))
                            .addGroup(jXImagePanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)))
                .addGap(39, 39, 39)
                .addComponent(jLabel31)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    Orders", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/5.jpg")), jPanel3); // NOI18N

        jXImagePanel9.setPreferredSize(new java.awt.Dimension(526, 370));

        jXImagePanel10.setPreferredSize(new java.awt.Dimension(287, 68));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Order Detail Form");
        jButton3.setBorderPainted(false);
        jButton3.setEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton3MouseMoved(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel10Layout = new javax.swing.GroupLayout(jXImagePanel10);
        jXImagePanel10.setLayout(jXImagePanel10Layout);
        jXImagePanel10Layout.setHorizontalGroup(
            jXImagePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jXImagePanel10Layout.setVerticalGroup(
            jXImagePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel32.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Order Detail ");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("*   Add ");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("*   Delete ");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("*   Search ");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("*   Update ");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("*   View ");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel39.setText("Order ID");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setText("Product Code");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setText("Discount");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel45.setText("Container No");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel49.setText("Order Qty");

        jLabel160.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel160.setText("Unit Price");

        javax.swing.GroupLayout jXImagePanel9Layout = new javax.swing.GroupLayout(jXImagePanel9);
        jXImagePanel9.setLayout(jXImagePanel9Layout);
        jXImagePanel9Layout.setHorizontalGroup(
            jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel9Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jXImagePanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jXImagePanel9Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel160, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(90, 90, 90)
                .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel9Layout.createSequentialGroup()
                        .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel9Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel49)
                            .addComponent(jLabel43)))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jXImagePanel9Layout.setVerticalGroup(
            jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel9Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel160))
                    .addGroup(jXImagePanel9Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel9Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel34))
                            .addGroup(jXImagePanel9Layout.createSequentialGroup()
                                .addGroup(jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXImagePanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel49)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel45)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXImagePanel9Layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel35)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel37)))))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    OrderDetail", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/3.jpg")), jPanel4); // NOI18N

        jXImagePanel13.setPreferredSize(new java.awt.Dimension(287, 68));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Products");
        jButton4.setBorderPainted(false);
        jButton4.setEnabled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton4MouseMoved(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel13Layout = new javax.swing.GroupLayout(jXImagePanel13);
        jXImagePanel13.setLayout(jXImagePanel13Layout);
        jXImagePanel13Layout.setHorizontalGroup(
            jXImagePanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel13Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton4)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jXImagePanel13Layout.setVerticalGroup(
            jXImagePanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel52.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(237, 255, 0));
        jLabel52.setText("Product Detail");

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(237, 255, 0));
        jLabel53.setText("*   Add Product");

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(237, 255, 0));
        jLabel54.setText("*   Delete Product");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(237, 255, 0));
        jLabel55.setText("*   Search Product");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(237, 255, 0));
        jLabel56.setText("*   Update Product");

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(237, 255, 0));
        jLabel57.setText("*   View Product");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(237, 255, 0));
        jLabel58.setText("Product Code");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(237, 255, 0));
        jLabel59.setText("Description");

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(237, 255, 0));
        jLabel61.setText("Reorder Level");

        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(237, 255, 0));
        jLabel63.setText("Category ID");

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(237, 255, 0));
        jLabel64.setText("Grade");

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(237, 255, 0));
        jLabel65.setText("Unit Weight");

        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(237, 255, 0));
        jLabel67.setText("Unit Price");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(237, 255, 0));
        jLabel69.setText("Qty On Hand");

        javax.swing.GroupLayout jXImagePanel12Layout = new javax.swing.GroupLayout(jXImagePanel12);
        jXImagePanel12.setLayout(jXImagePanel12Layout);
        jXImagePanel12Layout.setHorizontalGroup(
            jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel12Layout.createSequentialGroup()
                .addGroup(jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel12Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(43, 43, 43)
                        .addGroup(jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)))
                    .addGroup(jXImagePanel12Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jXImagePanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );
        jXImagePanel12Layout.setVerticalGroup(
            jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel12Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel63)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel64)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel65))
                    .addGroup(jXImagePanel12Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel57))
                    .addGroup(jXImagePanel12Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel59)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel67)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel69)))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    Product", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/10.jpg")), jPanel5); // NOI18N

        jXImagePanel16.setPreferredSize(new java.awt.Dimension(287, 68));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Item");
        jButton5.setBorderPainted(false);
        jButton5.setEnabled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton5MouseMoved(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel16Layout = new javax.swing.GroupLayout(jXImagePanel16);
        jXImagePanel16.setLayout(jXImagePanel16Layout);
        jXImagePanel16Layout.setHorizontalGroup(
            jXImagePanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel16Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton5)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jXImagePanel16Layout.setVerticalGroup(
            jXImagePanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel16Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel70.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 0, 51));
        jLabel70.setText("Item Detail");

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 0, 51));
        jLabel71.setText("*   Add Item");

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 0, 51));
        jLabel72.setText("*   Delete Item");

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 0, 51));
        jLabel73.setText("*   Search Item");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 0, 51));
        jLabel74.setText("*   Update Item");

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 0, 51));
        jLabel75.setText("*   View Item");

        jLabel76.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 51));
        jLabel76.setText("Item Code");

        jLabel77.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 51));
        jLabel77.setText("Description");

        jLabel79.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 0, 51));
        jLabel79.setText("Qty On Hand");

        jLabel81.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 0, 51));
        jLabel81.setText("Reorder Level");

        jLabel85.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 0, 51));
        jLabel85.setText("Unit Price");

        javax.swing.GroupLayout jXImagePanel15Layout = new javax.swing.GroupLayout(jXImagePanel15);
        jXImagePanel15.setLayout(jXImagePanel15Layout);
        jXImagePanel15Layout.setHorizontalGroup(
            jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel15Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jXImagePanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel15Layout.createSequentialGroup()
                        .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel15Layout.createSequentialGroup()
                                .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(65, 65, 65)
                                .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel79)
                                    .addComponent(jLabel81)))
                            .addGroup(jXImagePanel15Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel77)))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel15Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        jXImagePanel15Layout.setVerticalGroup(
            jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel15Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel79)
                            .addComponent(jLabel76))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXImagePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel85)
                            .addComponent(jLabel81)))
                    .addGroup(jXImagePanel15Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel72))
                    .addGroup(jXImagePanel15Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel75)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel77)))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    Item", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/16.jpg")), jPanel6); // NOI18N

        jXImagePanel19.setPreferredSize(new java.awt.Dimension(287, 68));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Category");
        jButton6.setBorderPainted(false);
        jButton6.setEnabled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton6MouseMoved(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel19Layout = new javax.swing.GroupLayout(jXImagePanel19);
        jXImagePanel19.setLayout(jXImagePanel19Layout);
        jXImagePanel19Layout.setHorizontalGroup(
            jXImagePanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel19Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton6)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jXImagePanel19Layout.setVerticalGroup(
            jXImagePanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel88.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel88.setText("Category Detail");

        jLabel89.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel89.setText("*   Add Category");

        jLabel90.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel90.setText("*   Delete Category");

        jLabel91.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel91.setText("*   Search Category");

        jLabel92.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel92.setText("*   Update Category");

        jLabel93.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel93.setText("*   View Category");

        jLabel94.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel94.setText("Category ID");

        jLabel97.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel97.setText("Category Name");

        javax.swing.GroupLayout jXImagePanel18Layout = new javax.swing.GroupLayout(jXImagePanel18);
        jXImagePanel18.setLayout(jXImagePanel18Layout);
        jXImagePanel18Layout.setHorizontalGroup(
            jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel18Layout.createSequentialGroup()
                .addGroup(jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel18Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jXImagePanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel18Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel94)
                        .addGap(65, 65, 65)
                        .addGroup(jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXImagePanel18Layout.createSequentialGroup()
                                .addGroup(jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel90)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jLabel97)))))
                .addContainerGap(46, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        jXImagePanel18Layout.setVerticalGroup(
            jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel18Layout.createSequentialGroup()
                .addGroup(jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXImagePanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addGroup(jXImagePanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel94)
                            .addComponent(jLabel97)))
                    .addGroup(jXImagePanel18Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel93)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(" Category", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/2.jpg")), jPanel7); // NOI18N

        jXImagePanel22.setPreferredSize(new java.awt.Dimension(287, 68));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Supplier Form");
        jButton7.setBorderPainted(false);
        jButton7.setEnabled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton7MouseMoved(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel22Layout = new javax.swing.GroupLayout(jXImagePanel22);
        jXImagePanel22.setLayout(jXImagePanel22Layout);
        jXImagePanel22Layout.setHorizontalGroup(
            jXImagePanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel22Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton7)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jXImagePanel22Layout.setVerticalGroup(
            jXImagePanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel106.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel106.setText("Supplier Detail");

        jLabel107.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel107.setText("*   Add Supplier");

        jLabel108.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel108.setText("*   Delete Supplier");

        jLabel109.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel109.setText("*   Search Supplier");

        jLabel110.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel110.setText("*   Update Supplier");

        jLabel111.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel111.setText("*   View Supplier");

        jLabel112.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel112.setText("Sup ID");

        jLabel113.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel113.setText("Sup Name");

        jLabel115.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel115.setText("Address");

        jLabel116.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel116.setText("Company Name");

        jLabel117.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel117.setText("Telephone");

        jLabel119.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel119.setText("E -Mail");

        jLabel121.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel121.setText("City");

        javax.swing.GroupLayout jXImagePanel21Layout = new javax.swing.GroupLayout(jXImagePanel21);
        jXImagePanel21.setLayout(jXImagePanel21Layout);
        jXImagePanel21Layout.setHorizontalGroup(
            jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel21Layout.createSequentialGroup()
                .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel21Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jXImagePanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel21Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXImagePanel21Layout.createSequentialGroup()
                                .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel121, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(62, 62, 62)
                                .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel108)
                                    .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(60, 60, 60)
                                .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel117)
                                    .addComponent(jLabel119)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel21Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel116)
                                        .addGap(151, 151, 151))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84)))))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jXImagePanel21Layout.setVerticalGroup(
            jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel21Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel111))
                    .addGroup(jXImagePanel21Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel115)
                            .addComponent(jLabel112))
                        .addGap(18, 18, 18)
                        .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel113)
                            .addComponent(jLabel117))
                        .addGap(18, 18, 18)
                        .addGroup(jXImagePanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel121)
                            .addComponent(jLabel119)))
                    .addGroup(jXImagePanel21Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel108)))
                .addGap(18, 18, 18)
                .addComponent(jLabel116)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("   Supplier", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/12.jpg")), jPanel8); // NOI18N

        jXImagePanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setText("1.   Buyer Payments");

        javax.swing.GroupLayout jXImagePanel27Layout = new javax.swing.GroupLayout(jXImagePanel27);
        jXImagePanel27.setLayout(jXImagePanel27Layout);
        jXImagePanel27Layout.setHorizontalGroup(
            jXImagePanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(56, 56, 56))
        );
        jXImagePanel27Layout.setVerticalGroup(
            jXImagePanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(25, 25, 25))
        );

        jXImagePanel28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setText("2.   Supplier Payments");

        javax.swing.GroupLayout jXImagePanel28Layout = new javax.swing.GroupLayout(jXImagePanel28);
        jXImagePanel28.setLayout(jXImagePanel28Layout);
        jXImagePanel28Layout.setHorizontalGroup(
            jXImagePanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel28Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel44)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jXImagePanel28Layout.setVerticalGroup(
            jXImagePanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        jButton11.setBackground(new java.awt.Color(204, 255, 255));
        jButton11.setText("Cash Payment");
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel11Layout = new javax.swing.GroupLayout(jXImagePanel11);
        jXImagePanel11.setLayout(jXImagePanel11Layout);
        jXImagePanel11Layout.setHorizontalGroup(
            jXImagePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXImagePanel11Layout.setVerticalGroup(
            jXImagePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton11))
        );

        jButton12.setBackground(new java.awt.Color(204, 255, 255));
        jButton12.setText("Cheque Payment");
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel14Layout = new javax.swing.GroupLayout(jXImagePanel14);
        jXImagePanel14.setLayout(jXImagePanel14Layout);
        jXImagePanel14Layout.setHorizontalGroup(
            jXImagePanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel14Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jButton12))
        );
        jXImagePanel14Layout.setVerticalGroup(
            jXImagePanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton12))
        );

        jButton8.setBackground(new java.awt.Color(204, 255, 255));
        jButton8.setText("Cash Payment");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel17Layout = new javax.swing.GroupLayout(jXImagePanel17);
        jXImagePanel17.setLayout(jXImagePanel17Layout);
        jXImagePanel17Layout.setHorizontalGroup(
            jXImagePanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8))
        );
        jXImagePanel17Layout.setVerticalGroup(
            jXImagePanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8))
        );

        jButton9.setBackground(new java.awt.Color(204, 255, 255));
        jButton9.setText("Cheque Payment");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel20Layout = new javax.swing.GroupLayout(jXImagePanel20);
        jXImagePanel20.setLayout(jXImagePanel20Layout);
        jXImagePanel20Layout.setHorizontalGroup(
            jXImagePanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addContainerGap())
        );
        jXImagePanel20Layout.setVerticalGroup(
            jXImagePanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton9))
        );

        javax.swing.GroupLayout jXImagePanel31Layout = new javax.swing.GroupLayout(jXImagePanel31);
        jXImagePanel31.setLayout(jXImagePanel31Layout);
        jXImagePanel31Layout.setHorizontalGroup(
            jXImagePanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel31Layout.createSequentialGroup()
                .addGroup(jXImagePanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel31Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jXImagePanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXImagePanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXImagePanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jXImagePanel31Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jXImagePanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel31Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jXImagePanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXImagePanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel31Layout.createSequentialGroup()
                        .addComponent(jXImagePanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel31Layout.createSequentialGroup()
                        .addComponent(jXImagePanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
        );
        jXImagePanel31Layout.setVerticalGroup(
            jXImagePanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel31Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jXImagePanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jXImagePanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXImagePanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jXImagePanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jXImagePanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jXImagePanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    Payments", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/6.jpg")), jPanel9); // NOI18N

        jXImagePanel32.setBackground(new java.awt.Color(251, 212, 212));

        profitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        profitButton.setText("Annual Profit");
        profitButton.setBorderPainted(false);
        profitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitButtonActionPerformed(evt);
            }
        });

        yearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextActionPerformed(evt);
            }
        });

        dollarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dollarTextActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Year :");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Dollar Value :");

        javax.swing.GroupLayout jXImagePanel32Layout = new javax.swing.GroupLayout(jXImagePanel32);
        jXImagePanel32.setLayout(jXImagePanel32Layout);
        jXImagePanel32Layout.setHorizontalGroup(
            jXImagePanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jXImagePanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXImagePanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dollarText, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(yearText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXImagePanel32Layout.setVerticalGroup(
            jXImagePanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel32Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jXImagePanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXImagePanel32Layout.createSequentialGroup()
                        .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dollarText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel32Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel47))
                    .addGroup(jXImagePanel32Layout.createSequentialGroup()
                        .addComponent(profitButton)
                        .addGap(9, 9, 9)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jXImagePanel23.setBackground(new java.awt.Color(246, 246, 205));

        valuableBuyerButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valuableBuyerButton2.setText("Valuable Buyers");
        valuableBuyerButton2.setBorderPainted(false);
        valuableBuyerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valuableBuyerButton2ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("The First 5 Buyers who provided ");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel96.setText("the Company with the maximum Income");

        javax.swing.GroupLayout jXImagePanel23Layout = new javax.swing.GroupLayout(jXImagePanel23);
        jXImagePanel23.setLayout(jXImagePanel23Layout);
        jXImagePanel23Layout.setHorizontalGroup(
            jXImagePanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(valuableBuyerButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXImagePanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96)
                    .addComponent(jLabel62))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXImagePanel23Layout.setVerticalGroup(
            jXImagePanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel23Layout.createSequentialGroup()
                .addGroup(jXImagePanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel23Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(valuableBuyerButton2))
                    .addGroup(jXImagePanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel96)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jXImagePanel26.setBackground(new java.awt.Color(255, 233, 255));

        valuableProductButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valuableProductButton.setText("Valuable Products");
        valuableProductButton.setBorderPainted(false);
        valuableProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valuableProductButtonActionPerformed(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel98.setText("First 5 Products that yielded ");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel99.setText("the highest Income");

        javax.swing.GroupLayout jXImagePanel26Layout = new javax.swing.GroupLayout(jXImagePanel26);
        jXImagePanel26.setLayout(jXImagePanel26Layout);
        jXImagePanel26Layout.setHorizontalGroup(
            jXImagePanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valuableProductButton)
                .addGap(31, 31, 31)
                .addGroup(jXImagePanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXImagePanel26Layout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel98, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXImagePanel26Layout.setVerticalGroup(
            jXImagePanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel26Layout.createSequentialGroup()
                .addGroup(jXImagePanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel26Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel99))
                    .addGroup(jXImagePanel26Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(valuableProductButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jXImagePanel34.setBackground(new java.awt.Color(238, 221, 204));

        movableProductButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movableProductButton.setText("Movable Products");
        movableProductButton.setBorderPainted(false);
        movableProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movableProductButtonActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel100.setText("First 5 Products with the highest Demand");

        javax.swing.GroupLayout jXImagePanel34Layout = new javax.swing.GroupLayout(jXImagePanel34);
        jXImagePanel34.setLayout(jXImagePanel34Layout);
        jXImagePanel34Layout.setHorizontalGroup(
            jXImagePanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movableProductButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel100)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jXImagePanel34Layout.setVerticalGroup(
            jXImagePanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel34Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jXImagePanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movableProductButton)
                    .addComponent(jLabel100))
                .addContainerGap())
        );

        reportButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reportButton.setText("Other Reports");
        reportButton.setBorderPainted(false);
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel5Layout = new javax.swing.GroupLayout(jXImagePanel5);
        jXImagePanel5.setLayout(jXImagePanel5Layout);
        jXImagePanel5Layout.setHorizontalGroup(
            jXImagePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jXImagePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXImagePanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXImagePanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXImagePanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXImagePanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
            .addGroup(jXImagePanel5Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXImagePanel5Layout.setVerticalGroup(
            jXImagePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jXImagePanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXImagePanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXImagePanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXImagePanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(reportButton)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("   Reports", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/4.jpg")), jPanel10); // NOI18N

        backupButton.setText("Backup");
        backupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupButtonActionPerformed(evt);
            }
        });

        restoreButton.setText("Restore");
        restoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel24Layout = new javax.swing.GroupLayout(jXImagePanel24);
        jXImagePanel24.setLayout(jXImagePanel24Layout);
        jXImagePanel24Layout.setHorizontalGroup(
            jXImagePanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel24Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(restoreButton)
                .addGap(41, 41, 41))
            .addGroup(jXImagePanel24Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(backupButton)
                .addContainerGap())
        );
        jXImagePanel24Layout.setVerticalGroup(
            jXImagePanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel24Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(backupButton)
                .addGap(18, 18, 18)
                .addComponent(restoreButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jXImagePanel30Layout = new javax.swing.GroupLayout(jXImagePanel30);
        jXImagePanel30.setLayout(jXImagePanel30Layout);
        jXImagePanel30Layout.setHorizontalGroup(
            jXImagePanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel30Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jXImagePanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jXImagePanel30Layout.setVerticalGroup(
            jXImagePanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel30Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jXImagePanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Backup and Restore", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/8.jpg")), jPanel11); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Randima Exporters is popular as an\nexcellent cinnamon producer to the world\nmarket. It manufactures a wide range of\ncinnamon products. It has won the first\nplace in providing the finest and high quality\ncinnamon for USA in 2010 & 2011.\n\nMr. Rathnasiri the chairman started the\nindustry on his own. Later on he could\ndevelop the industry little by little and at\npresent, he has gained local & international\nreputation as a genuine cinnamon exporter.\nThe industry situated in an area where\ncinnamon cultivation Is, most widely done.\nIn Sri Lanka this are area is popular for\nfinest cinnamon products. This can be\nconsidered as the secret of this unique and\nspecific product. \n\nThe year 2005 was considered as the\ngolden year for the company as it was able\nto have affixations with many other\ncountries in the world, during that year. \n\nThis stability is still maintained through the\nproduction of unique splendid cinnamon\nwhich has an extra ordinary market for\nbuyers through the world. ");
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Company Name:  Randima Exporters \nMailing        Manamgoda,\n  Address   :  Batapola.\n\t       Sri Lanka.\n \nTele Phone  :\n\t(+94) 91 50 50 864\n\t(+94) 91 50 50 865\n\t(+94) 91 50 50 867 \nFax \t    :\n\t(+94) 91 50 50 837 \nMobile      :\n\t(+94) 77 3 582 467\n\t(+94) 77 2 833 767 \nWeb \t    :\n\tRandimaExporters.com  \neMail \t    :\n\trandima@randimaexporters.com \n");
        jScrollPane2.setViewportView(jTextArea2);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact Us");

        jButton10.setText("Edit");

        javax.swing.GroupLayout jXImagePanel4Layout = new javax.swing.GroupLayout(jXImagePanel4);
        jXImagePanel4.setLayout(jXImagePanel4Layout);
        jXImagePanel4Layout.setHorizontalGroup(
            jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10)
                    .addGroup(jXImagePanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jXImagePanel4Layout.setVerticalGroup(
            jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("About Us", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/17.jpg")), jPanel12); // NOI18N

        jXImagePanel37.setBackground(new java.awt.Color(255, 255, 255));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("Make Order");
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel37Layout = new javax.swing.GroupLayout(jXImagePanel37);
        jXImagePanel37.setLayout(jXImagePanel37Layout);
        jXImagePanel37Layout.setHorizontalGroup(
            jXImagePanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel37Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton14)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jXImagePanel37Layout.setVerticalGroup(
            jXImagePanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXImagePanel38.setBackground(new java.awt.Color(255, 255, 255));

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("Make GRN");
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel38Layout = new javax.swing.GroupLayout(jXImagePanel38);
        jXImagePanel38.setLayout(jXImagePanel38Layout);
        jXImagePanel38Layout.setHorizontalGroup(
            jXImagePanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel38Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton15)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jXImagePanel38Layout.setVerticalGroup(
            jXImagePanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jXImagePanel8Layout = new javax.swing.GroupLayout(jXImagePanel8);
        jXImagePanel8.setLayout(jXImagePanel8Layout);
        jXImagePanel8Layout.setHorizontalGroup(
            jXImagePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel8Layout.createSequentialGroup()
                .addGroup(jXImagePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel8Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jXImagePanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel8Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jXImagePanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jXImagePanel8Layout.setVerticalGroup(
            jXImagePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel8Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jXImagePanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jXImagePanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("  Invoice", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/20.jpg")), jPanel13); // NOI18N

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("GRN Form");
        jButton16.setBorderPainted(false);
        jButton16.setEnabled(false);
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton16MouseReleased(evt);
            }
        });
        jButton16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton16MouseMoved(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel36Layout = new javax.swing.GroupLayout(jXImagePanel36);
        jXImagePanel36.setLayout(jXImagePanel36Layout);
        jXImagePanel36Layout.setHorizontalGroup(
            jXImagePanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel36Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addGap(66, 66, 66))
        );
        jXImagePanel36Layout.setVerticalGroup(
            jXImagePanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel66.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel66.setText("GRN");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel68.setText("GRN ID");

        jLabel78.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel78.setText("Supplier ID");

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel80.setText("*   Add GRN");

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel82.setText("*   Delete GRN");

        jLabel83.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel83.setText("*   Update GRN");

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel84.setText("*   Search GRN");

        jLabel86.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel86.setText("*   View GRN");

        jLabel87.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel87.setText("Full Amount");

        jLabel95.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel95.setText("GRN Date");

        javax.swing.GroupLayout jXImagePanel35Layout = new javax.swing.GroupLayout(jXImagePanel35);
        jXImagePanel35.setLayout(jXImagePanel35Layout);
        jXImagePanel35Layout.setHorizontalGroup(
            jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel35Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel35Layout.createSequentialGroup()
                        .addGroup(jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(82, 82, 82)
                        .addGroup(jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel35Layout.createSequentialGroup()
                        .addComponent(jXImagePanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
            .addGroup(jXImagePanel35Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jXImagePanel35Layout.setVerticalGroup(
            jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel35Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jXImagePanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jXImagePanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel35Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel95)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel87))
                    .addGroup(jXImagePanel35Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel68)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel78))
                    .addGroup(jXImagePanel35Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel80)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel86)))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("    GRN", new javax.swing.ImageIcon(getClass().getResource("/randimaexporters/15.jpg")), jPanel14); // NOI18N

        jLabel1.setFont(new java.awt.Font("Cooper Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Randima Exporters");

        jLabel3.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Welcome !!!");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImagePanel1Layout = new javax.swing.GroupLayout(jXImagePanel1);
        jXImagePanel1.setLayout(jXImagePanel1Layout);
        jXImagePanel1Layout.setHorizontalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXImagePanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXImagePanel1Layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(30, 30, 30))))
        );
        jXImagePanel1Layout.setVerticalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXImagePanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXImagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
   }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseMoved
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton1MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu.this.setVisible(false);

        if (bf == null) {
            bf = new BuyerForm(null, true);
            bf.setVisible(true);
        } else {
            bf.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseMoved
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton2MouseMoved

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MainMenu.this.setVisible(false);

        if (of == null) {
            of = new OrderForm(null, true);
            of.setVisible(true);
        } else {
            of.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseMoved
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jButton3MouseMoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainMenu.this.setVisible(false);

        if (odf == null) {
            odf = new OrderDetailForm(null, true);
            odf.setVisible(true);
        } else {
            odf.setVisible(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseMoved
        jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton4MouseMoved

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MainMenu.this.setVisible(false);

        if (pf == null) {
            pf = new ProductForm(null, true);
            pf.setVisible(true);
        } else {
            pf.setVisible(true);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
   }//GEN-LAST:event_jButton5MouseReleased

    private void jButton5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseMoved
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jButton5MouseMoved

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        MainMenu.this.setVisible(false);

        if (iF == null) {
            iF = new ItemForm(null, true);
            iF.setVisible(true);
        } else {
            iF.setVisible(true);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
   }//GEN-LAST:event_jButton6MouseReleased

    private void jButton6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseMoved
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jButton6MouseMoved

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MainMenu.this.setVisible(false);

        if (caf == null) {
            caf = new CategoryForm(null, true);
            caf.setVisible(true);
        } else {
            caf.setVisible(true);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseMoved
        jButton7.setEnabled(true);
    }//GEN-LAST:event_jButton7MouseMoved

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        MainMenu.this.setVisible(false);

        if (sf == null) {
            sf = new SupplierForm(null, true);
            sf.setVisible(true);
        } else {
            sf.setVisible(true);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        MainMenu.this.setVisible(false);

        if (cf == null) {
            cf = new CashForm(null, true);
            cf.setVisible(true);
        } else {
            cf.setVisible(true);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        MainMenu.this.setVisible(false);

        if (scf == null) {
            scf = new supplierPayment.ChequeForm(null, true);
            scf.setVisible(true);
        } else {
            scf.setVisible(true);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        MainMenu.this.setVisible(false);

        if (bch == null) {
            bch = new buyerPayment.CashForm(null, true);
            bch.setVisible(true);
        } else {
            bch.setVisible(true);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        MainMenu.this.setVisible(false);

        if (bpcf == null) {
            bpcf = new buyerPayment.ChequeForm(null, true);
            bpcf.setVisible(true);
        } else {
            bpcf.setVisible(true);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        MainMenu.this.setVisible(false);

        if (mo == null) {
            mo = new MakeOrder(null, true);
            mo.setVisible(true);
        } else {
            mo.setVisible(true);
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        MainMenu.this.setVisible(false);

        if (mg == null) {
            mg = new MakeGrn(null, true);
            mg.setVisible(true);
        } else {
            mg.setVisible(true);
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16MouseReleased

    private void jButton16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseMoved
        jButton16.setEnabled(true);
    }//GEN-LAST:event_jButton16MouseMoved

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        MainMenu.this.setVisible(false);

        if (gf == null) {
            gf = new GrnForm(null, true);
            gf.setVisible(true);
        } else {
            gf.setVisible(true);
        }

    }//GEN-LAST:event_jButton16ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?");
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void profitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitButtonActionPerformed

        if (isValidYear(yearText.getText()) && isValidDollar(dollarText.getText())) {
            try {

                JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reporting/report/annualIncome.jrxml"));

                HashMap map = new HashMap();
                map.put("year", yearText.getText());
                map.put("dollarValue", Double.parseDouble(dollarText.getText()));

                JasperPrint print = JasperFillManager.fillReport(report, map, DBCon.getConnection());
                JasperViewer v = new JasperViewer(print);

                ReportView rv = new ReportView(null, true);
                rv.getContentPane().add(v.getContentPane());
                rv.pack();
                rv.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!isValidYear(yearText.getText())) {
            JOptionPane.showMessageDialog(this, "The Year already entered wrong.");
        } else if (!isValidDollar(dollarText.getText())) {
            JOptionPane.showMessageDialog(this, "The Dollar value already entered wrong.");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong Input..");
        }
    }//GEN-LAST:event_profitButtonActionPerformed

    private void valuableBuyerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valuableBuyerButton2ActionPerformed
        try {
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reporting/report/report17.jrxml"));

            JasperPrint print = JasperFillManager.fillReport(report, null, DBCon.getConnection());

            JasperViewer v = new JasperViewer(print);

            ReportView rv = new ReportView(null, true);
            rv.getContentPane().add(v.getContentPane());
            rv.pack();
            rv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Reports1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_valuableBuyerButton2ActionPerformed

    private void valuableProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valuableProductButtonActionPerformed
        try {
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reporting/report/report19.jrxml"));

            JasperPrint print = JasperFillManager.fillReport(report, null, DBCon.getConnection());

            JasperViewer v = new JasperViewer(print);

            ReportView rv = new ReportView(null, true);
            rv.getContentPane().add(v.getContentPane());
            rv.pack();
            rv.setVisible(true);

        } catch (JRException ex) {
        }
    }//GEN-LAST:event_valuableProductButtonActionPerformed

    private void movableProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movableProductButtonActionPerformed
        try {
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reporting/report/report9.jrxml"));

            JasperPrint print = JasperFillManager.fillReport(report, null, DBCon.getConnection());

            JasperViewer v = new JasperViewer(print);

            ReportView rv = new ReportView(null, true);
            rv.getContentPane().add(v.getContentPane());
            rv.pack();
            rv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Reports1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_movableProductButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed

        MainMenu.this.setVisible(false);

        if (r == null) {
            r = new Reports1(null, true);
            r.setVisible(true);
        } else {
            r.setVisible(true);
        }

    }//GEN-LAST:event_reportButtonActionPerformed

    private void yearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextActionPerformed

        if (!isValidYear(yearText.getText())) {
            JOptionPane.showMessageDialog(this, "The Year already entered wrong.");
            yearText.setText("");
        } else {
            dollarText.requestFocus();
        }

    }//GEN-LAST:event_yearTextActionPerformed

    private void dollarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dollarTextActionPerformed
        if (!isValidDollar(dollarText.getText())) {
            JOptionPane.showMessageDialog(this, "The Dollar value already entered wrong.");
            dollarText.setText("");
        } else {
            profitButton.requestFocus();
        }
    }//GEN-LAST:event_dollarTextActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int res = JOptionPane.showConfirmDialog(this, "Do you want to Exit ?");
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_formWindowClosing

    private void backupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupButtonActionPerformed
        //System.out.println(BackupAndRestore.backupDB("RandimaExporters", "root", "ijse", "D:\\db.sql"));
      
        
            
        //System.out.println(BackupAndRestore.backupDB("root","1234","RandimaExporters","E:/Randima/db.sql"));
       
    }//GEN-LAST:event_backupButtonActionPerformed

    private void restoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreButtonActionPerformed
        //System.out.println(new BackupAndRestore().restoreDB("root", "ijse", "D:\\db.sql"));
    }//GEN-LAST:event_restoreButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
                    } catch (ParseException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                new MainMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backupButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dollarText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel1;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel10;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel11;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel12;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel13;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel14;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel15;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel16;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel17;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel18;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel19;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel2;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel20;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel21;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel22;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel23;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel24;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel26;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel27;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel28;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel3;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel30;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel31;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel32;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel34;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel35;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel36;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel37;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel38;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel4;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel5;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel6;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel7;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel8;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel9;
    private javax.swing.JButton movableProductButton;
    private javax.swing.JButton profitButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JButton restoreButton;
    private javax.swing.JButton valuableBuyerButton2;
    private javax.swing.JButton valuableProductButton;
    private javax.swing.JTextField yearText;
    // End of variables declaration//GEN-END:variables
}
