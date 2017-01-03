
import com.mongodb.MongoClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import makaleYonetimiPackage.benzerlikStrategy;
import makaleYonetimiPackage.benzerlikStrategyDicesCoefficient;
import makaleYonetimiPackage.benzerlikStrategyJaccard;
import makaleYonetimiPackage.makale;
import makaleYonetimiPackage.makaleDaoMongodb;
import  makaleYonetimiPackage.makaleDao;


public class makaleYonetimiForm extends javax.swing.JFrame {
    DefaultListModel lm=new DefaultListModel();
    makale ilkMakale= new makale();
    makale ikinciMakale= new makale();
    public makaleYonetimiForm() {
        initComponents();
        lm.addElement("304571");
        lm.addElement("304585");
        lm.addElement("306102");
        lm.addElement("306103");
        lm.addElement("306105");
        lm.addElement("306109");
        lm.addElement("306119");
        lm.addElement("306124");
        lm.addElement("306112");
        lm.addElement("306115");
        makalelerjList.setModel(lm);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        makaleleriDByeAktarjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        makalelerjList = new javax.swing.JList<>();
        seçilenMakalejTextField = new javax.swing.JTextField();
        makaleyiEklejButton = new javax.swing.JButton();
        makaleyiSiljButton = new javax.swing.JButton();
        seçilenMakale1jButton = new javax.swing.JButton();
        seçilenMakale2jButton = new javax.swing.JButton();
        DBseçilenMakale1jLabel = new javax.swing.JLabel();
        DBseçilenMakale2jLabel = new javax.swing.JLabel();
        karşılaştırJaccardjButton = new javax.swing.JButton();
        karşılaştırDicesCoefficient = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        makaleleriDByeAktarjButton.setText("Listedeki Makaleleri işle ve DB'ye aktar");
        makaleleriDByeAktarjButton.setToolTipText("listedeki tüm makaleleri; csv dosyasından başlayıp, pdf box ile parse etmeye kadar olan tüm işlemleri halledip db ye makaleleri öyle atar");
        makaleleriDByeAktarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makaleleriDByeAktarjButtonActionPerformed(evt);
            }
        });

        makalelerjList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        makalelerjList.setToolTipText("");
        jScrollPane1.setViewportView(makalelerjList);

        makaleyiEklejButton.setText("Makaleyi Ekle");
        makaleyiEklejButton.setToolTipText("makaleyi listeye ekler");
        makaleyiEklejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makaleyiEklejButtonActionPerformed(evt);
            }
        });

        makaleyiSiljButton.setText("Makaleyi Sil");
        makaleyiSiljButton.setToolTipText("makaleyi sadece listeden siler");
        makaleyiSiljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makaleyiSiljButtonActionPerformed(evt);
            }
        });

        seçilenMakale1jButton.setText("DB'den seçilen makale 1");
        seçilenMakale1jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seçilenMakale1jButtonActionPerformed(evt);
            }
        });

        seçilenMakale2jButton.setText("DB'den seçilen makale 2");
        seçilenMakale2jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seçilenMakale2jButtonActionPerformed(evt);
            }
        });

        DBseçilenMakale1jLabel.setText("id = ");

        DBseçilenMakale2jLabel.setText("id = ");

        karşılaştırJaccardjButton.setText("Dice's Coefficient ile Karşılaştır");
        karşılaştırJaccardjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karşılaştırJaccardjButtonActionPerformed(evt);
            }
        });

        karşılaştırDicesCoefficient.setText("Jaccard ile Karşılaştır");
        karşılaştırDicesCoefficient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karşılaştırDicesCoefficientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(karşılaştırDicesCoefficient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(makaleleriDByeAktarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(makaleyiSiljButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(makaleyiEklejButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(seçilenMakalejTextField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(seçilenMakale1jButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DBseçilenMakale1jLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(seçilenMakale2jButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DBseçilenMakale2jLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(karşılaştırJaccardjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(seçilenMakalejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makaleyiEklejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makaleyiSiljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(makaleleriDByeAktarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seçilenMakale1jButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(DBseçilenMakale1jLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seçilenMakale2jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DBseçilenMakale2jLabel))
                .addGap(16, 16, 16)
                .addComponent(karşılaştırDicesCoefficient, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(karşılaştırJaccardjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makaleyiEklejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makaleyiEklejButtonActionPerformed
        lm.addElement(seçilenMakalejTextField.getText());
        makalelerjList.setModel(lm);
    }//GEN-LAST:event_makaleyiEklejButtonActionPerformed

    private void makaleyiSiljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makaleyiSiljButtonActionPerformed
        lm.removeElement(makalelerjList.getSelectedValue());
        makalelerjList.setModel(lm);
    }//GEN-LAST:event_makaleyiSiljButtonActionPerformed

    private void makaleleriDByeAktarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makaleleriDByeAktarjButtonActionPerformed

        try {
            ArrayList<String> makaleIdleri = new ArrayList<>() ; 
            for(int i =0;i<lm.getSize();i++)
            {
                makaleIdleri.add(lm.elementAt(i).toString());
            }
            makaleDao dao = new makaleDaoMongodb();
            dao.setAllMakaleToDatabase(makaleIdleri);
        } catch (IOException ex) {
            Logger.getLogger(makaleYonetimiForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_makaleleriDByeAktarjButtonActionPerformed

    private void seçilenMakale1jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seçilenMakale1jButtonActionPerformed

        try {
            makaleDao dao = new makaleDaoMongodb();
            ilkMakale=dao.getMakale(makalelerjList.getSelectedValue());
            DBseçilenMakale1jLabel.setText("id ="+ilkMakale.getId());
        } catch (IOException ex) {
            Logger.getLogger(makaleYonetimiForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_seçilenMakale1jButtonActionPerformed

    private void seçilenMakale2jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seçilenMakale2jButtonActionPerformed
        try {
            makaleDao dao = new makaleDaoMongodb();
            ikinciMakale=dao.getMakale(makalelerjList.getSelectedValue());
            DBseçilenMakale2jLabel.setText("id ="+ikinciMakale.getId());
        } catch (IOException ex) {
            Logger.getLogger(makaleYonetimiForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_seçilenMakale2jButtonActionPerformed

    private void karşılaştırJaccardjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karşılaştırJaccardjButtonActionPerformed
        benzerlikStrategy strategy = new benzerlikStrategyDicesCoefficient();
        double benzerlik = strategy.karşılaştır(ilkMakale.getContext(), ikinciMakale.getContext());
        JOptionPane.showMessageDialog(null, benzerlik , "Makalelerin Benzerlik Oranı", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_karşılaştırJaccardjButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
        MongoClient mongoClient=new MongoClient("localhost",27017);
        mongoClient.dropDatabase("NesneProjeDB");
      
    }//GEN-LAST:event_formWindowClosed

    private void karşılaştırDicesCoefficientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karşılaştırDicesCoefficientActionPerformed
        benzerlikStrategy strategy = new benzerlikStrategyJaccard();
        double benzerlik = strategy.karşılaştır(ilkMakale.getContext(), ikinciMakale.getContext());
        JOptionPane.showMessageDialog(null, benzerlik , "Makalelerin Benzerlik Oranı", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_karşılaştırDicesCoefficientActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(makaleYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(makaleYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(makaleYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(makaleYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new makaleYonetimiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DBseçilenMakale1jLabel;
    private javax.swing.JLabel DBseçilenMakale2jLabel;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton karşılaştırDicesCoefficient;
    private javax.swing.JButton karşılaştırJaccardjButton;
    private javax.swing.JButton makaleleriDByeAktarjButton;
    private javax.swing.JList<String> makalelerjList;
    private javax.swing.JButton makaleyiEklejButton;
    private javax.swing.JButton makaleyiSiljButton;
    private javax.swing.JButton seçilenMakale1jButton;
    private javax.swing.JButton seçilenMakale2jButton;
    private javax.swing.JTextField seçilenMakalejTextField;
    // End of variables declaration//GEN-END:variables
}
