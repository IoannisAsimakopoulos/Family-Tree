/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvoptional1;

// Imports
    import static csvoptional1.Menu.id;
    import static csvoptional1.Menu.linesCounter;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.regex.Pattern;
    import javax.swing.JFileChooser;
    import javax.swing.JOptionPane;
// END of Imports

public class ReadFile extends javax.swing.JFrame {

    
    // Constactor
    public ReadFile() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Επιλέξτε το CSV αρχείο για μετατροπή");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField1.setFocusable(false);
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Όνομα αρχείου");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField2.setFocusable(false);
        jTextField2.setRequestFocusEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Θέση αρχείου");
        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField3.setFocusable(false);
        jTextField3.setRequestFocusEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        Final_Button_Enimerosi.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Final_Button_Enimerosi.setText("Mετατροπή CSV Αρχείου");
        Final_Button_Enimerosi.setAutoscrolls(true);
        Final_Button_Enimerosi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi.setFocusPainted(false);
        Final_Button_Enimerosi.setFocusable(false);
        Final_Button_Enimerosi.setRequestFocusEnabled(false);
        Final_Button_Enimerosi.setRolloverEnabled(false);
        Final_Button_Enimerosi.setSelected(true);
        Final_Button_Enimerosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_EnimerosiActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\john\\OneDrive\\Desktop\\CsvOptional\\Icons\\dots.png")); // NOI18N
        jToggleButton1.setSelected(true);
        jToggleButton1.setBorder(null);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setFocusable(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToggleButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jToggleButton1KeyPressed(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(null);
        jTextField11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField11.setEnabled(false);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(null);
        jTextField12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField12.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                            .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jTextField11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jTextField12)
                    .addComponent(jTextField3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed

        String fileName = jTextField11.getText();           // Όνομα αρχείου που επιλέξαμε
        String filePath = jTextField12.getText();           // Τοποθεσία αρχείου
        System.out.println("Όνομα Αρχείου: "+fileName);     // Μνμ Ονομασίας Αρχείου
        System.out.println(" ");                            // Κενό

        // Μνμ μη επιλογής αρχείου
        if((fileName.length()<1) && (filePath.length()<1))
        {
            // Μνμ για μή επιλεγμένο Αρχείο πρός μετατροπή
            JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε αρχείο για μετατροπή","Warning",
            JOptionPane.WARNING_MESSAGE);
        }

        // Επιλέχθηκε Αρχείο
        else
        {
            // if για επαλήθευση csv αρχείου
            String final3 = fileName.substring(fileName.length() - 4, fileName.length());
            if(final3.equals(".csv"))
            {
                System.out.println("It's a CSV file");  // Μνμ επαλήθευσης CSV file
                System.out.println(" ");                // Κενό

                String line="";
                BufferedReader br = null;
                String csvSplitBy = ",";                // Χαρακτήρας με τον οποίο θα χωρίσουμε τις λέξεις για το txt file μας αλλά και για τον πίνακα lines
                String lines[] = new String[100];       // Ορισμός του πίνακα Lines που θα υποδεχθεί το περιεχόμενο του csv φιλε ανα γραμμή όπως το διαβάζει
                //String id   [] = new String[100];
                //int linesCounter=0;                   // Αρχικοποίηση counter που θα μετράει τις γραμμές του αρχείου που θα διαβάσουμε

                // Try catch ώστε να μην σκάσει ο κώδικας, αν παρουσιαστεί πρόγλημα κατα την ανάγνωση του αρχείου
                try
                {
                    br = new BufferedReader(new FileReader(filePath)); // Κλήση του BufferReader ώστε να διβάσουμε το αρχείο

                    // όσο δεν τελειώνει το αρχείο κάνει loop
                    while ((line = br.readLine()) != null)
                    {
                        // Χρήση του κόμματος (' , ') ως seperator
                        System.out.println(line);       // Εμφάνηση της κάθε γραμμής του Πίνακα ώστε να βλέπουμε εάν το στάδιο της ανάγνωσης είναι σωστό
                        lines[linesCounter] = line;     // Καταχώριση των στιχείων της γραμμής που διαβάσαμε στον πίνακα lines
                        linesCounter++;                 // counter+1
                    }
                    System.out.println();               // Κενό
                    
                    // for loop για να γίνει η καρταχώριση των στοιχείων στον πίνακα id
                    for (int x=0; x<linesCounter; x++)
                    {
                        // Ορισμός πίνακα 2 διαστάσεων όπου θα σπάσουμε το String του πίνακα lines
                        String [] parts = lines[x].split(Pattern.quote(","));
                        id[0][x] = parts[0].trim();            // Ορισμός της πρώτης τιμής του String που σπάσαμε μέω του κόμματος (',') στον πίνακα id
                        id[1][x] = parts[1].trim();            // Ορισμός της δεύτερης τιμής του String που σπάσαμε μέω του κόμματος (',') στον πίνακα id

                        // if για να δούμε εάν η τρίτη στίλη του String που σπάσαμε υπάρχει ή θα είναι κενή μέσω του Length του πίνακα parts
                        if(parts.length==3)
                        {
                            id[2][x] = parts[2].trim();        // Ο πίνακας parts έχει 3η στίλη οπότε και την καταχωρούμε στον πίνακα id
                        }
                        else
                        {
                            id[2][x] = "null";          // Ο πίνακας parts ΔΕΝ έχει 3η στίλη οπότε καταχωρούμε στον πίνακα id την τιμή 'null'
                        }
                    }
                    // Kλήση Νέας Φόρμας        (CsvRead)
                    //new CsvRead().setVisible(true); // enable the form)
                    // Κλήση Φόρμας για Οπτικοποίηση του Αναγνωσμένου Αρχείου.
                    
                    this.dispose(); //  Κλείσημο Φόρμας
                    new ReadFileOutput().setVisible(true);  // enable the ReadFile form 
                    
                    // Mνμ για Σωστή Ανάγνωση Αρχείου (Χειριστής)
                    JOptionPane.showMessageDialog(null, "Η Ανάγνωση του Αρχείου: "+jTextField11.getText()+" έγινε με επιτυχία."); 
                    // Mνμ για Σωστή Ανάγνωση Αρχείου (Editor)
                    System.out.println("Η Ανάγνωση του Αρχείου: "+jTextField11.getText()+" έγινε με επιτυχία!!!");
                    System.out.println();                   // Κενό
                }
                //  FileNotFoundException thrown
                catch (FileNotFoundException e)
                {
                    // Mνμ για FileNotFoundException (Editor)
                    System.out.println("To αρχείο ("+jTextField11.getText()+") δεν βρέθηκε.");
                    System.out.println(e);                      // message for FileNotFoundException στον Editor
                    System.out.println();                       // Κενό
                    // message for FileNotFoundException στον Χρήστη
                    JOptionPane.showMessageDialog(null,"To αρχείο ("+jTextField11.getText()+") δεν βρέθηκε.","Alert",
                    JOptionPane.WARNING_MESSAGE);
                }
                //  IOException thrown
                catch (IOException e)
                {
                    // Mνμ για IOException (Editor)
                    System.out.println("Προέκυψε σφάλμα κατα το άνοιγμα του αρχείου ("+jTextField11.getText()+").");
                    System.out.println(e);                      // message for IOException στον Editor
                    System.out.println();                       // Κενό
                    // message for IOException στον Χρήστη
                    JOptionPane.showMessageDialog(null,"Προέκυψε σφάλμα κατα το άνοιγμα του αρχείου ("+jTextField11.getText()+").","Alert",
                    JOptionPane.WARNING_MESSAGE);
                }
                finally
                {
                    /*
                    // Κλείσημο του BufferReader
                    if (br != null)
                    {
                        try
                        {
                            br.close();
                        }
                        catch (IOException e)
                        {
                            System.out.println(e);
                        }
                    }
                    */
                }
            }
            else
            {
                System.out.println("It's NOT a CSV file");  // Μνμ ΜΗ σωστής επιλογής CSV file
                System.out.println(" ");                    // Κενό

                // Μνμ για μη σωστό επιλεγμένο αρχείο. Το αρχείο πρέπει υποχρεωτικά να είναι csv
                JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε αρχείο για μετατροπή (Υποχρεωτικά CSV)","Warning",
                JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        JFileChooser chooser = new JFileChooser();      // Κλήση jFileChooser
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();             // Επιλογή αρχείου που επιλέχθηκε απο τον Χρήστη
        String filepath = f.getAbsolutePath();          // Ορισμός του path απο το αρχείο που επιλέχθηκε απο τον Χρηστή στην μεταβλητή filepath
        String filename = f.getName();                  // Ορισμός του ονόματος του αρχείου που επιλέχθηκε απο τον Χρηστή στην μεταβλητή filename
        jTextField11.setText(filename);                 // Εμφάνηση της τιμής filename στο jTextField11
        jTextField12.setText(filepath);                 // Εμφάνηση της τιμής filepath στο jTextField12
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jToggleButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1KeyPressed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

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
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}