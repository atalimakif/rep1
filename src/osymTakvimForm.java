
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akif
 */
public class osymTakvimForm extends javax.swing.JFrame {
    ArrayList<String> duzeltilenTarihler = new ArrayList<String>();
    /**
     * Creates new form osymTakvimForm
     */
    public osymTakvimForm() {
        initComponents();
              
    }
    
    public void tarihAzalanSıradaUrlCekme()
    {
        duzeltilenTarihler = new ArrayList<String>();
        try {
            //ArrayList<String> sınavlars = new ArrayList<String>();
                        
            Document doc;
            
            doc = Jsoup.connect("http://www.osym.gov.tr/TR,8797/takvim.html").get();
            Elements sınavlar = doc.select("div.row div.col-sm-6"); /// ilk indexte sınav yoktur başlıklar vardır
            Elements tarihler = doc.select("div.row div.col-sm-2"); /// her sınava karşılık gelen 3 tane tarih vardır
            
            DefaultListModel dlm=new DefaultListModel();
            for(int i=sınavlar.size()-1,j=1;i>=0;i--,j++)
            {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                String deneme = tarihler.get(i*3).text().substring(0,10);
                String ay,yıl,gun,sınavTarihi;
                gun=deneme.substring(0,2);
                ay=deneme.substring(3,5);
                yıl=deneme.substring(6,10);
                sınavTarihi=yıl+ay+gun;
                String simdininTarihi= df.format(new Date());
                if(i==0)///başlık olan veri
                {
                    
                }
                else if(Integer.parseInt(simdininTarihi)>Integer.parseInt(sınavTarihi))
                {
                    dlm.addElement("(BİTMİŞ)   "/*+j*/+"-   "+sınavlar.get(i).text()); /// Jlist e elemanları ekleme
                    duzeltilenTarihler.add("SINAV TARİHİ :"+tarihler.get(i*3).text()+"\nBAŞVURU TARİHLERİ :"+tarihler.get(i*3+1).text()+"\nSONUÇ TARİHİ :"+tarihler.get(i*3+2).text());
                }
                else
                {   
                    dlm.addElement("(YAPILACAK)   "/*+j*/+"-   "+sınavlar.get(i).text()); /// Jlist e elemanları ekleme
                    duzeltilenTarihler.add("SINAV TARİHİ :"+tarihler.get(i*3).text()+"\nBAŞVURU TARİHLERİ :"+tarihler.get(i*3+1).text()+"\nSONUÇ TARİHİ :"+tarihler.get(i*3+2).text());
                }
            }
            
            jList2.setModel(dlm);
        } catch (IOException ex) {
            Logger.getLogger(osymTakvimForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tarihArtanSıradaUrlCekme()
    {
        duzeltilenTarihler = new ArrayList<String>();
        try {
            //ArrayList<String> sınavlars = new ArrayList<String>();
                        
            Document doc;
            
            doc = Jsoup.connect("http://www.osym.gov.tr/TR,8797/takvim.html").get();
            Elements sınavlar = doc.select("div.row div.col-sm-6"); /// ilk indexte sınav yoktur başlıklar vardır
            Elements tarihler = doc.select("div.row div.col-sm-2"); /// her sınava karşılık gelen 3 tane tarih vardır
            
            DefaultListModel dlm=new DefaultListModel();
            for(int i=0;i<sınavlar.size();i++)
            {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                String deneme = tarihler.get(i*3).text().substring(0,10);
                String ay,yıl,gun,sınavTarihi;
                gun=deneme.substring(0,2);
                ay=deneme.substring(3,5);
                yıl=deneme.substring(6,10);
                sınavTarihi=yıl+ay+gun;
                String simdininTarihi= df.format(new Date());
                if(i==0)///başlık olan veri
                {
                    
                }
                else if(Integer.parseInt(simdininTarihi)>Integer.parseInt(sınavTarihi))
                {
                   
                    dlm.addElement("(BİTMİŞ)   "/*+i*/+"-   "+sınavlar.get(i).text()); /// Jlist e elemanları ekleme
                    duzeltilenTarihler.add("SINAV TARİHİ :"+tarihler.get(i*3).text()+"\nBAŞVURU TARİHLERİ :"+tarihler.get(i*3+1).text()+"\nSONUÇ TARİHİ :"+tarihler.get(i*3+2).text());
                    
                }
                else///sınavlar.get(i).text()
                {   
                    dlm.addElement("(YAPILACAK)   "/*+i*/+"-   "+sınavlar.get(i).text()); /// Jlist e elemanları ekleme
                    duzeltilenTarihler.add("SINAV TARİHİ :"+tarihler.get(i*3).text()+"\nBAŞVURU TARİHLERİ :"+tarihler.get(i*3+1).text()+"\nSONUÇ TARİHİ :"+tarihler.get(i*3+2).text());
                }
            }
            jList2.setModel(dlm);
            
        } catch (IOException ex) {
            Logger.getLogger(osymTakvimForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        ArtanSıradaUrlCek = new javax.swing.JButton();
        AzalanSıradaUrlCek = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList2.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList2);

        jButton2.setText("SEÇİLEN SINAVIN TARİH BİLGİLERİNİ GÖRÜNTÜLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ArtanSıradaUrlCek.setText("SINAVLARI GEÇMİŞTEN BAŞLAYARAK LİSTELE");
        ArtanSıradaUrlCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtanSıradaUrlCekActionPerformed(evt);
            }
        });

        AzalanSıradaUrlCek.setText("SINAVLARI GELECEKTEN BAŞLAYARAK LİSTELE");
        AzalanSıradaUrlCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AzalanSıradaUrlCekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(ArtanSıradaUrlCek)
                .addGap(119, 119, 119)
                .addComponent(AzalanSıradaUrlCek)
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArtanSıradaUrlCek)
                    .addComponent(AzalanSıradaUrlCek))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null,duzeltilenTarihler.get(jList2.getSelectedIndex())  , "Tarih Bilgileri", JOptionPane.INFORMATION_MESSAGE);
               // TODO add your handling code here: 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ArtanSıradaUrlCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtanSıradaUrlCekActionPerformed
        tarihArtanSıradaUrlCekme(); // TODO add your handling code here:
    }//GEN-LAST:event_ArtanSıradaUrlCekActionPerformed

    private void AzalanSıradaUrlCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AzalanSıradaUrlCekActionPerformed
        tarihAzalanSıradaUrlCekme();        // TODO add your handling code here:
    }//GEN-LAST:event_AzalanSıradaUrlCekActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(osymTakvimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(osymTakvimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(osymTakvimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(osymTakvimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new osymTakvimForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArtanSıradaUrlCek;
    private javax.swing.JButton AzalanSıradaUrlCek;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
