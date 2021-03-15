/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvoptional1;

// Imports
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.OutputStreamWriter;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JOptionPane;
// END of Imports

public class Menu extends javax.swing.JFrame {
    
    // Τοπικές Μεταβλητές
        static int counterFound=0;                           // Counter θέσης που βρέθηκε
        static String id [][] = new String [3][50];          // Πίνακας που περιέχει τα χαρακτηριστικά της κάθε εγραφής του csv αρχείου 
        static int linesCounter;                             // Counter που έχει τον αριθμό των εγραφών του Αρχείου μας
        static String nullName[] = new String[50];           // Πρώτη στίλη του πίνακα id[][] των στοιχείων που έχουν null ώς τρίτη στίλη
        static String nullAtr[]  = new String[50];           // Δέυτερη στίλη του πίνακα id[][] των στοιχείων που έχουν null ώς τρίτη στίλη
        static int nullCounter=0;                            // counter για τον αριθμό των null θέσεων του πίνακα id
    // Τέλος Τοπικών Μεταβλητών
        
    // Constractor
    public Menu() {
        initComponents(); // initialise των Στοιχείων της Φόρμας
    }
    
    // Μέθοδος για το Button2 
    static void button2()
    {
        // if για να δούμε αν έχει γίνει το πρώτο βήμα (Ανάγνωση Αρχείου)
        if(linesCounter==0) // αν η μεταβλητή linesCounter είναι 0 τότε δεν έχει γίνει το πρώτο βήμα (Ανάγνωση Αρχείου)
        {
            // Μήνυμα στον Χρήστη
            JOptionPane.showMessageDialog(null,"Πρέπει να γίνει η Ανάγνωση Αρχείου πρώτα.","Alert",
            JOptionPane.WARNING_MESSAGE);
            // Μήνυμα στο Output
            System.out.println("Πρέπει να γίνει η Ανάγνωση Αρχείου πρώτα.");
            System.out.println();           // Κενό
        }
        else
        {
            new Export().setVisible(true);  // Εμφάνηση της Φόρμας Export για να γίνει η εξαγωγή του αρχείου (txt)
        }
    }
    // Τέλος μεθόδου για το Button2
    
    // Μέθοδος για το Button3 
    static void button3()
    {
        // if για να δούμε αν έχει γίνει το 2ο Βήμα (Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου)
        if(linesCounter==0)                // Εάν η μεταβλητή linesCounter είναι ίση με 0, τότε ΔΕΝ έχει γίνει το 1ο Βήμα (Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου)
        {
            // Μήνυμα στον Χρήστη
            JOptionPane.showMessageDialog(null,"Πρέπει να γίνει η Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου πρώτα.","Alert",
            JOptionPane.WARNING_MESSAGE);
            // Μήνυμα στο Output
            System.out.println("Πρέπει να γίνει η Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου πρώτα.");
            System.out.println();          //  Κενό
        }
        else if(counterFound==0)           // Εάν η μεταβλητή counterFound είναι ίσημε 0, τότε ΔΕΝ έχει γίνει η Εξαγωγή Αρχείου
        {
            // Μήνυμα στον Χρήστη
            JOptionPane.showMessageDialog(null,"Πρέπει να γίνει η Εξαγωγή Αρχείου πρώτα.","Alert",
            JOptionPane.WARNING_MESSAGE);
            // Μήνυμα στο Output
            System.out.println("Πρέπει να γίνει η Εξαγωγή Αρχείου πρώτα.");
            System.out.println();          // Κενό
        }
        else
        {
            new Search().setVisible(true);  //  Εμφάνηση της Φόρμας Search 
        }
    }
    // Τέλος μεθόδου για το Button3
    
    // Μέθοδος για το Button4 
    static void button4() throws IOException
    {
        // if για να δούμε αν έχει γίνει το 2ο Βήμα (Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου)
        if(linesCounter==0)               // Εάν η μεταβλητή linesCounter είναι ίση με 0, τότε ΔΕΝ έχει γίνει το 1ο Βήμα (Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου)
        {
            // Μήνυμα στον Χρήστη
            JOptionPane.showMessageDialog(null,"Πρέπει να γίνει η Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου πρώτα.","Alert",
            JOptionPane.WARNING_MESSAGE);
            // Μήνυμα στο Output
            System.out.println("Πρέπει να γίνει η Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου πρώτα.");
            System.out.println();          //  Κενό
        }
        else if(counterFound==0)           // Εάν η μεταβλητή counterFound είναι ίση με 0, τότε ΔΕΝ έχει γίνει η Εξαγωγή Αρχείου
        {
            // Μήνυμα στον Χρήστη
            JOptionPane.showMessageDialog(null,"Πρέπει να γίνει η Εξαγωγή Αρχείου πρώτα.","Alert",
            JOptionPane.WARNING_MESSAGE);
            // Μήνυμα στο Output
            System.out.println("Πρέπει να γίνει η Εξαγωγή Αρχείου πρώτα.");
            System.out.println();         // Κενό
        }
        else
        {
            exportDot(); // Κλήση μεθόδου για εξαγωγή αρχείου (dot)
        }
    }
    // Τέλος μεθόδου για το Button4
    
    // Mέθοδος για εξαγωγή αρχείου (dot)
    static void exportDot() throws FileNotFoundException, IOException
    {
        // Μέθοδος Για Εξαγωγή Αρχείου (dot)
        File f = new File("c:\\Γενεαλογικό Δέντρο"); // path για το file που μας ενδιαφέρει
        // If που ψάχνει να δεί εάν υπάρχει το file μας
        if(f.isDirectory())
        {
            System.out.println("Υπάρχει ο φάκελος: '"+f+"'");       // Μνμ ότι υπάρχει ο φάκελος

            // Τελικό στάδιο δημιουργίας φακέλου
            // Write to the dot file
            
            try(BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\Γενεαλογικό Δέντρο\\Word File("+1+").dot"))))
            {
                out.write("digraph GoT {"); 
                out.newLine();
                out.write("rankdir=LR;");
                out.newLine();
                out.write("size=+8,5+".replace('+','"')); 
                out.newLine();
                out.write("node [shape = rectangle] [color=black];");
                out.newLine();
                for(int x=0; x<linesCounter; x++)
                {
                    if(id[2][x]!="null" && id[1][x]!="wife" && id[1][x]!="husband")
                    {
                        if(id[1][x].equals("wife") || id[1][x].equals("husband"))
                        {
                        }
                        else
                        {
                            String nameA = id[0][x];
                            String nameB = id[2][x];
                            String atr   = id[1][x];
                            String add   = "+"+nameA+"+ -> +"+nameB+"+ [label=+"+atr+"+];";
                            out.write(add.replace('+','"'));
                            out.newLine();
                        }
                    }
                }
                out.write("}");
                // Μήνυμα στον Χρήστη
                JOptionPane.showMessageDialog(null,"To αρχείο: Word File(1).dot δημιουργήθηκε στον φάκελο 'c:/Γεννεαλογικό Δέντρο'","Alert",
                JOptionPane.WARNING_MESSAGE);
                // Μήνυμα στο Output
                System.out.println("\"To αρχείο: Word File(1).dot δημιουργήθηκε στον φάκελο 'c:/Γεννεαλογικό Δέντρο'\"");
            }
            catch(Exception e)
            {
                // Μήνυμα στον Χρήστη
                JOptionPane.showMessageDialog(null,"Προέκυψε Σφάλμα κατα την δημιουργεία του Αρχείου: Word File(1).dot","Alert",
                JOptionPane.WARNING_MESSAGE);
                // Μήνυμα στο Output
                System.out.println("Προέκυψε Σφάλμα κατα την δημιουργεία του Αρχείου: Word File(1).dot");
                System.out.println();
            }
        }
        else
        {
            // Μήνυμα Λάθους (jOptionPane)
            JOptionPane.showMessageDialog(null,"ΔΕΝ Βρέθηκε ο φάκελος: '"+f+"'","Alert",
            JOptionPane.WARNING_MESSAGE);
            // Μήνυμα Λάθους (Editor)
            System.out.println("ΔΕΝ Βρέθηκε ο φάκελος: '"+f+"'");   
        }
        // Τέλος Δημιουργίας Αρχείου (dot)
        System.out.println();
    }
    // Τέλος μεθόδου για εξαγωγή αρχείου (dot)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        newOrder = new javax.swing.JButton();
        newOrder2 = new javax.swing.JButton();
        newOrder3 = new javax.swing.JButton();
        newOrder4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentHidden(evt);
            }
        });
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel2KeyTyped(evt);
            }
        });

        newOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder.setText("Ανάγνωση Αρχείου");
        newOrder.setAutoscrolls(true);
        newOrder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder.setFocusCycleRoot(true);
        newOrder.setFocusable(false);
        newOrder.setSelected(true);
        newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderActionPerformed(evt);
            }
        });

        newOrder2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder2.setText("Αναζήτηση Συγγένειας");
        newOrder2.setAutoscrolls(true);
        newOrder2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder2.setFocusCycleRoot(true);
        newOrder2.setFocusable(false);
        newOrder2.setSelected(true);
        newOrder2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrder2ActionPerformed(evt);
            }
        });

        newOrder3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder3.setText("Αποθήκευση Δεδομένων σε Αρχείο Τύπου DOT ");
        newOrder3.setAutoscrolls(true);
        newOrder3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder3.setFocusCycleRoot(true);
        newOrder3.setFocusable(false);
        newOrder3.setSelected(true);
        newOrder3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrder3ActionPerformed(evt);
            }
        });

        newOrder4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder4.setText("Ταξινόμιση Στοιχείων και Εξαγωγή Αρχείου");
        newOrder4.setAutoscrolls(true);
        newOrder4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder4.setFocusCycleRoot(true);
        newOrder4.setFocusable(false);
        newOrder4.setSelected(true);
        newOrder4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrder4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newOrder3, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(newOrder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newOrder4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(newOrder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(newOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(newOrder4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(newOrder2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(newOrder3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void newOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderActionPerformed
        
        //  Mέσω της κλήσης της συγκερκιμένης Μεθόδου απαντάμε στο Ερώτημα 2 της εργασίας 
        //      καθώς γίνεται η Ανάγνωση του CSV αρχείου απο την εφαρμογή μας, επιλογή του Csv αρχείου μέσω της φόρμας (αριστερό κλίκ στο κουμπί στην Θέση Αρχείου και επιλογή του Csv Αρχείου με ονομασία ReadFile.csv)
        //      αλλά και η φόρτωση των δεδομένων που εισάχθηκαν απο το Csv αρχείο μέσω του πατήματος του κουμπιού με ονομασία: Mετατροπή CSV Αρχείου
        
        new ReadFile().setVisible(true);   // Εμφάνηση της Φόρμας ReadFile για να διαβάσουμε το αρχείο που θα επιλεχτεί απο τον Χειριστή 
    }//GEN-LAST:event_newOrderActionPerformed

    private void newOrder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrder2ActionPerformed
        
        //  Mέσω της κλήσης της συγκερκιμένης Μεθόδου απαντάμε στο Ερώτημα 4 της εργασίας 
        //      Καθώς δέχεται σαν είσοδο 2 ονόματα και εμφανίζει την μεταξύ τους σχέση.
        //      Ο χειριστής επιλέγει το πρώτο όνομα του ατόμου που επιθυμεί απο το πρώτο Combo Box της φόρμας Search.java
        //      και το δεύτερο όνομα που επιθυμεί από το δεύτερο Combo Box της φόρμας Search.java
        //      Ενώ η αναζήτηση της συγκένοιας γίνεται μέσω του πατήματος του αριστερού κλίκ στο κουμπί Αναζήτηση Συγγένειας αφότου έχουν επιλεχθεί τα επιθυμειτά πρόσωπα
        
        button3(); // Mέθοδος για το Button3
    }//GEN-LAST:event_newOrder2ActionPerformed

    private void newOrder3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrder3ActionPerformed
            try {
                
                //  Mέσω της κλήσης της συγκερκιμένης Μεθόδου απαντάμε στο Ερώτημα 5 της εργασίας 
                //      καθώς μέσω του πατήματος του συγκεκριμένου κουμπιού δημιουργείτε ένα αρχείο τύπου Dot με ονομασία WordFile(1).dot
                //      στον τοπικό μας δίσκο c στον φάκελο Γεννεαλογικό Δέντρο (c:\Γεννεαλογικό Δέντρο\WordFile(1).dot)
                //      που περιέχει τις απαραίτητες εντολές οι οποίες μπορούν να οπτικοποιηθούν μέσω του GraphViz
                
                button4(); // Mέθοδος για το Button4
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_newOrder3ActionPerformed

    private void jPanel2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentHidden

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyTyped

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyTyped

    private void newOrder4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrder4ActionPerformed
        
        //  Mέσω της κλήσης της συγκερκιμένης Μεθόδου απαντάμε στο Ερώτημα 3 της εργασίας 
        //      καθώς γίνεται η ταξινόμιση των ανθρώπων σε λεξικογραφική σειρά, κατα την διάρκεια της αρχικοποίησης της φόρμας (Export.java)
        //      αλλά και η εξαγωγή αρχείου txt(Γενεαλογικό Δέντρο(1).txt), μέσω του πατήματος του κουμπιού Εξαγωγή Αρχείου Txt στην φόρμα Export.java    
        //      Kατα την διάρκεια της εξαγωγής δημιουργείτε στον τοπικάς μας δίσκο c ο φάκελος Γεννεαλογικό Δέντρο, εάν δεν υπάρχει είδη (c:\Γεννεαλογικό Δέντρο)
        //      και στην συνέχεια στον προηγούμενο φάκελο (c:\Γεννεαλογικό Δέντρο) δημιουργείται το txt αρχείο με ονομασία Γεννεαλογικό Δέντρο(1).txt 
        //      το οποίο περιέχει μία γραμμή για κάθε έναν άνθρωπο (όνομα και φύλο)
        
        button2(); // Mέθοδος για το Button2
    }//GEN-LAST:event_newOrder4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton newOrder;
    private javax.swing.JButton newOrder2;
    private javax.swing.JButton newOrder3;
    private javax.swing.JButton newOrder4;
    // End of variables declaration//GEN-END:variables
}
