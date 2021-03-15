
package csvoptional1;

// Imports
    import static csvoptional1.Menu.counterFound;
    import static csvoptional1.Menu.id;
    import static csvoptional1.Menu.linesCounter;
    import static csvoptional1.Menu.nullAtr;
    import static csvoptional1.Menu.nullCounter;
    import static csvoptional1.Menu.nullName;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import javax.swing.JOptionPane;
// End of Imports

public class Export extends javax.swing.JFrame {
    
    // Μέθοδος Για Εξαγωγή Αρχείου (txt file)
    public void exportFile()
    {
        // Ψάχνουμε να βρούμε εάν υπάρχει το Directory στο οποίο θα δημιουργήσουμε το file μας
        File f = new File("c:\\Γενεαλογικό Δέντρο"); // path για το file που μας ενδιαφέρει
        // If που ψάχνει να δεί εάν υπάρχει το file μας
        if(f.isDirectory())
        {
            System.out.println("Υπάρχει ο φάκελος: '"+f+"'");       // Μνμ ότι υπάρχει ο φάκελος

            // Τελικό στάδιο δημιουργίας φακέλου
            // Write to the txt file
            try
            {
                // Όνομα αρχείου που ψάχνουμε να βρούμε αν υπάρχει
                File fileS = new File("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+1+").txt");
                // Ψάχνουμε να δούμε εάν υπάρχει το αρχείο ('Γεννεαλογικό Δέντρο(1).txt')
                // Το Αρχείο Υπαρχει ('Γεννεαλογικό Δέντρο(1).txt')
                if(fileS.exists())
                {
                    boolean found=false;    // boolean μεταβλητή (found) που θα γίνει True όταν βρούμε το σύνολο των Αρχείων που υπάρχουν στον φάκελο
                    int counter=0;          // Αθριστής με το σύνολο των Αρχείων που υπάρχουν στον φάκελο
                    
                    // For loop για να βρούμε τον Αθριστή των Αρχείων που υπάρχουν στον φάκελο 
                    for(int x=2; found!=true; x++)
                    {
                        // Ψάχνουμε να δούμε εάν υπάρχει το αρχείο ('Γεννεαλογικό Δέντρο(x).txt')
                        File file = new File("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+x+").txt");
                        if(file.exists())
                        {
                        }
                        else
                        {
                            found = true;   // Βρέθηκε το τελευταίο αρχείο (txt) που υπάρχει στον φάκελο ('c:/Γεννεαλογικό Δέντρο') 
                            counter = x;    // Αριθμός Αρχείων που υπάρχουν στον φάκελο ('c:/Γεννεαλογικό Δέντρο') 
                        }
                    }
                    // Δημιουργεία αρχείου ('Γενεαλογικό Δέντρο ("+counter+").txt')
                    File fileCreate= new File("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+counter+").txt",  "UTF-8");     
                    // Mήνυμα για Σωστή Δημιουργεία Αρχείου
                    System.out.println("Το αρχείο: Γενεαλογικό Δέντρο("+counter+").txt δημιουργήθηκε με Επιτυχία!!!");
                    try
                    {
                        // Εγραφή του αρχείου ('Γενεαλογικό Δέντρο ("+counter+").txt')
                        FileWriter fileWrite = new FileWriter("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+counter+").txt"); 
                        // For loop για εγραφή στο αρχείο των περιεχομένων των Πινάκων nullName Και nullAtr
                        for(int x=0; x<counterFound; x++)
                        {
                            // Καταχώριση στο αρχείο 
                            fileWrite.write(nullName[x]+" is a "+nullAtr[x]+"\n");
                        }
                        fileWrite.close();      // Κλείσιμο Αρχείου
                        System.out.println();   // Κενό   
                        this.dispose();         // Κλήσιμο Φόρμας
                        // Μήνυμα ότι καταχωρήθηκαν σωστά τα στοιχεία στο αρχείο (Editor)
                        System.out.println("Τα στοιχεία καταχωρήθηκαν με Επιτυχία στο αρχείο!!!");
                        // Μήνυμα ότι καταχωρήθηκαν σωστά τα στοιχεία στο αρχείο (jOptionPane)
                        JOptionPane.showMessageDialog(null, "Τα στοιχεία καταχωρήθηκαν με Επιτυχία στο αρχείο.");
                    }
                    // IOException thrown
                    catch(IOException e)
                    {
                        // Μήνυμα Λάθους (jOptionPane)
                        JOptionPane.showMessageDialog(null,"Προέκυψε Σφάλμα κατα την διαδικασία της Καταχώρισης των στοιχείων στο αρχείο: Γενεαλογικό Δέντρο("+counter+").txt","Alert",
                        JOptionPane.WARNING_MESSAGE);
                        // Μήνυμα Λάθους (Editor)
                        System.out.println("Προέκυψε Σφάλμα κατα την διαδικασία της Καταχώρισης των στοιχείων στο αρχείο: Γενεαλογικό Δέντρο("+counter+").txt");
                        System.out.println("Τα στοιχεία ΔΕΝ Καταχωρήθηκαν στο Αρχείο.");
                        // Εμφάνηση Λάθους
                        System.out.println(e);
                    }
                }
                // Το Αρχείο ΔΕΝ Υπαρχει ('Γεννεαλογικό Δέντρο(1).txt')
                else
                {
                    // Μήνυμα ότι ΔΕΝ υπάχρχει τουλάχιστον ένα Αρχείο --> Οπότε το αρχείο είναι κενό
                    System.out.println("O φάκελος: Γενεαλογικό Δέντρο (c:\\Γενεαλογικό Δέντρο) είναι κενός...");
                    // Δημιουργεία του πρώτου Αρχείου του Φακέλου ('Γενεαλογικό Δέντρο (1).txt')
                    File fileCreate= new File("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+1+").txt",  "UTF-8"); 
                    // Μήνυμα ότι δημιουργήθηκε το πρώτο αρχείο του φακέλου ('Γενεαλογικό Δέντρο (1).txt')
                    System.out.println("Το αρχείο: Γενεαλογικό Δέντρο("+1+").txt δημιουργήθηκε με Επιτυχία!!!");
                    
                    // Try - catch blocκ για να γράψουμε στο αρχείο
                    try
                    {
                        // Όνομα Αρχέιου που θα εγράψουμε
                        FileWriter fileWrite = new FileWriter("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+1+").txt");   
                        // For loop για εγραφή στο αρχείο των περιεχομένων των Πινάκων nullName Και nullAtr
                        for(int x=0; x<counterFound; x++)
                        {
                            // Καταχώριση στο αρχείο 
                            fileWrite.write(nullName[x]+" is a "+nullAtr[x]+"\n");
                        }
                        fileWrite.close();      // Κλείσιμο Αρχείου
                        System.out.println();   // Κενό   
                        this.dispose();         // Κλήσιμο Φόρμας
                        // Μήνυμα ότι καταχωρήθηκαν σωστά τα στοιχεία στο αρχείο (Editor)
                        System.out.println("Τα στοιχεία καταχωρήθηκαν με Επιτυχία στο αρχείο!!!");
                        // Μήνυμα ότι καταχωρήθηκαν σωστά τα στοιχεία στο αρχείο (jOptionPane)
                        JOptionPane.showMessageDialog(null, "Τα στοιχεία καταχωρήθηκαν με Επιτυχία στο αρχείο.");

                    }
                    // IOException thrown
                    catch(IOException e)
                    {
                        // Μήνυμα Λάθους (jOptionPane)
                        JOptionPane.showMessageDialog(null,"Προέκυψε Σφάλμα κατα την διαδικασία της Καταχώρισης των στοιχείων στο αρχείο: Γενεαλογικό Δέντρο("+1+").txt","Alert",
                        JOptionPane.WARNING_MESSAGE);
                        // Μήνυμα Λάθους (Editor)
                        System.out.println("Προέκυψε Σφάλμα κατα την διαδικασία της Καταχώρισης των στοιχείων στο αρχείο: Γενεαλογικό Δέντρο("+1+").txt");
                        System.out.println("Τα στοιχεία ΔΕΝ Καταχωρήθηκαν στο Αρχείο.");
                        // Εμφάνηση Λάθους
                        System.out.println(e);
                    }
                }
            }
            // Exception thrown
            catch (Exception e)
            {
                // Μήνυμα Λάθους (jOptionPane)
                JOptionPane.showMessageDialog(null,"Προέκυψε Σφάλμα κατα την διαδικασία της Δημιουργίας του αρχείου: Γενεαλογικό Δέντρο ","Alert",
                JOptionPane.WARNING_MESSAGE);
                // Μήνυμα Λάθους (Editor)
                System.out.println("Προέκυψε Σφάλμα κατα την διαδικασία της Δημιουργίας του αρχείου: Γενεαλογικό Δέντρο ");
                System.out.println("Το αρχείο ΔΕΝ δημιουργήθηκε");
                // Εμφάνηση Λάθους
                System.out.println(e);
            }
            // Τελος τελικού σταδίου δημιουργίας φακέλου
        }
        else
        {
            System.out.println("ΔΕΝ Υπάρχει ο φάκελος: '"+f+"'");   // Μνμ ότι ΔΕΝ υπάρχει ο φάκελος
            

            // try - catch block για Δημιουργεία Φακέλου
            try
            {
                Path path = Paths.get("c:\\Γενεαλογικό Δέντρο");                // PathName του Φακέλου που θα δημιουργήσουμε
                Files.createDirectories(path);                                  // Δημιουργεία του Φακέλου (Γεννεαλογικό Δέντρο)
                System.out.println("Επιτυχής Δημιουργία Φακέλου: '"+f+"'");     // Μνμ επιτυχής δημιουργίας του φακέλου (Γεννεαλογικό Δέντρο)
                System.out.println("O φάκελος: Γενεαλογικό Δέντρο (c:\\Γενεαλογικό Δέντρο) είναι κενός...");       // Μήνυμα ότι ο φάκελος είναι κενός ('Γενεαλογικό Δέντρο')
                File fileCreate= new File("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+1+").txt",  "UTF-8");     // Δημιουργεία του πρώτου Αρχείου ('Γενεαλογικό Δέντρο (1).txt')
                System.out.println("Το αρχείο: Γενεαλογικό Δέντρο("+1+").txt δημιουργήθηκε με Επιτυχία!!!");      // Μήνυμα Επιτυχής Δημιουρφγείας Αρχείου ('Γενεαλογικό Δέντρο (1).txt')
                
                // try - catch block για Εγραφή Στοιχείων στο Αρχείο ('Γενεαλογικό Δέντρο (1).txt')
                try
                {
                    // Όνομα Αρχείου που θα Εγράψουμε
                    FileWriter fileWrite = new FileWriter("c:\\Γενεαλογικό Δέντρο\\Γενεαλογικό Δέντρο("+1+").txt");   
                    // For loop για εγραφή στο αρχείο των περιεχομένων των Πινάκων nullName Και nullAtr
                    for(int x=0; x<counterFound; x++)
                    {
                        // Καταχώριση στο αρχείο 
                        fileWrite.write(nullName[x]+" is a "+nullAtr[x]+"\n");
                    }
                    fileWrite.close();      // Κλείσιμο Αρχείου
                    System.out.println();   // Κενό   
                    this.dispose();         // Κλήσιμο Φόρμας
                    // Μήνυμα ότι καταχωρήθηκαν σωστά τα στοιχεία στο αρχείο (Editor)
                    System.out.println("Τα στοιχεία καταχωρήθηκαν με Επιτυχία στο αρχείο!!!");
                    // Μήνυμα ότι καταχωρήθηκαν σωστά τα στοιχεία στο αρχείο (jOptionPane)
                    JOptionPane.showMessageDialog(null, "Τα στοιχεία καταχωρήθηκαν με Επιτυχία στο αρχείο.");
                }
                // IOException thrown
                catch(IOException e)
                {
                    // Μήνυμα Λάθους (jOptionPane)
                    JOptionPane.showMessageDialog(null,"Προέκυψε Σφάλμα κατα την διαδικασία της Καταχώρισης των στοιχείων στο αρχείο: Γενεαλογικό Δέντρο("+1+").txt","Alert",
                    JOptionPane.WARNING_MESSAGE);
                    // Μήνυμα Λάθους (Editor)
                    System.out.println("Προέκυψε Σφάλμα κατα την διαδικασία της Καταχώρισης των στοιχείων στο αρχείο: Γενεαλογικό Δέντρο("+1+").txt");
                    System.out.println("Τα στοιχεία ΔΕΝ Καταχωρήθηκαν στο Αρχείο.");
                    // Εμφάνηση Λάθους
                    System.out.println(e);
                }
            }
            // IOException thrown
            catch (IOException e)
            {
                // Μήνυμα Λάθους (jOptionPane)
                JOptionPane.showMessageDialog(null,"Aνεπιτυχής Δημιουργία Φακέλου: '"+f+"'","Alert",
                JOptionPane.WARNING_MESSAGE);
                // Μήνυμα Λάθους (Editor)
                System.err.println("Aνεπιτυχής Δημιουργία Φακέλου: '"+f+"'");   // Μνμ ΜΗ επιτυχής δημιουργίας του φακέλου (Γεννεαλογικό Δέντρο)
                System.out.println(e);                                          // Εμφάνησμ μνμ λάθους
            }
        }
        // Τέλος Δημιουργίας Αρχείου (txt)
        System.out.println();
    }
    // Τέλος Μεθόδου Για Εξαγωγή Αρχείου (txt file)
    
    // Mέθοδος για να βρούμε ποιές καταχωρήσεις έχουν Null ώς τρίτη στίλη
    public void findNull()
    {
        nullCounter=0;
        for(int x=0; x<linesCounter; x++)
        {
            if(id[2][x]=="null")
            {
                nullCounter++;
            }
        }
        //String [] nullName = new String[nullCounter];       // Πίνακας με τις τιμές της πρώτης στίλης των εγραφών με null στην 3η στίλη
        //String [] nullAtr  = new String[nullCounter];       // Πίνακας με τις τιμές της δεύτερης στίλης των εγραφών με null στην 3η στίλη
        counterFound = 0;                               // Int value ώστε να τελειώσει νωρίτερα το loop σε περίπτωση που βρεθεί και το τελευταίο value που ψάχνουμε

        // For loop για να καταχωρηθούν τα στοιχεία που έχουν null value στην 3η τους σειρά
        for(int x=0; x<linesCounter ; x++)
        {
            if(id[2][x]=="null")
            {
                nullName[counterFound] = id[0][x];  // Ανάθεση της τιμής id[0][x] στην nullName[counterFound]
                nullAtr [counterFound] = id[1][x];  // Ανάθεση της τιμής id[1][x] στην nullAtr[counterFound]
                counterFound++;                     // counterFound+1
            }
        }
        // Κλήση Μεθόδου ταξινόμισης πίνακα(nullName) για εξαγωγή αρχείου
        order();
    }
    // Τέλος Mεθόδου για να βρούμε ποιές καταχωρήσεις έχουν Null ώς τρίτη στίλη
    
    // Μέθοδος ταξινόμισης πίνακα(nullName) για εξαγωγή αρχείου
    public void order()
    {
        for(int i=0; i<nullCounter; i++)           
        {
            for(int x=i+1; x<nullCounter; x++)
            {
                // Συγκρίνουμε την 1η στίλη
                if(nullName[i].compareTo(nullName[x])>0)
                {
                    // Αντιμετάθεση τιμών πίνακα nullName 
                    String temp = nullName[x];
                    nullName[x] = nullName[i];
                    nullName[i] = temp;
                    // Αντιμετάθεση τιμών πίνακα nullAtr 
                    temp = nullAtr[x];
                    nullAtr[x] = nullAtr[i];
                    nullAtr[i] = temp;
                }
            }
        }
        // Kλήση μεθόδου καταχώρισης τιμών σε λίστες
        init2();
    }
    // Τέλος Μεθόδο ταξινόμισης πίνακα(nullName) για εξαγωγή αρχείου
    
    // Μέθοδος για Καταχώριση τιμών στις Λίστες
    public void init2()
    {
        jList2.setSize(0,0);    // setSize (jList2)
        jList3.setSize(0,0);    // setSize (jList3)
        
        String [] resultsEpon1 = new String[nullCounter];     // Τοπικός Πίνακας μεγέθου όσου των τιμών του πίνακα id που έχουν Null 3η στίλη
        String [] resultsId    = new String[nullCounter];     // Τοπικός Πίνακας μεγέθου όσου των τιμών του πίνακα id που έχουν Null 3η στίλη
        
        jList2.setSize(1,nullCounter); // setSize της φόρμας (jList2) ίσο με τις τιμές που έχουν Null στην 3η στίλη
        jList3.setSize(1,nullCounter); // setSize της φόρμας (jList3) ίσο με τις τιμές που έχουν Null στην 3η στίλη
        
        // Τοποθέτιση τιμών αναζήτησης απο Πίνακες σε Λίστες
        for(int x=0; x<nullCounter; x++)
        {
            resultsEpon1[x]  = nullName[x];    // Τοποθέτιση Επωνυμιών Πίνακα στην αντίστοιχη Λίστα
            resultsId[x]     = nullAtr[x];     // Τοποθέτιση Τίτλων Πίνακα στην αντίστοιχη Λίστα
        }
        
        jList2.setListData(resultsEpon1);   // setListData με τις τιμές του αντίστοιχου πίνακα
        jList3.setListData(resultsId);      // setListData με τις τιμές του αντίστοιχου πίνακα
        System.out.println();
    }
    // Τέλος Μεθόδου για Καταχώριση τιμών στις Λίστες
    
    public Export() {
        initComponents();   // Initialise της φόρμας
        findNull();          // Κλήση Μεθόδου που κάνει την ταξινόμιση του πίνακα id[][] 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Ταξινομημένα Στοιχεία Αρχείου:");
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

        Final_Button_Enimerosi.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Final_Button_Enimerosi.setText("Εξαγωγή Αρχείου Txt");
        Final_Button_Enimerosi.setAutoscrolls(true);
        Final_Button_Enimerosi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi.setFocusCycleRoot(true);
        Final_Button_Enimerosi.setFocusPainted(false);
        Final_Button_Enimerosi.setSelected(true);
        Final_Button_Enimerosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_EnimerosiActionPerformed(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setFocusable(false);
        jList2.setRequestFocusEnabled(false);
        jList2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Επωνυμία 1");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField2.setFocusable(false);
        jTextField2.setRequestFocusEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jList3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList3.setFocusable(false);
        jList3.setRequestFocusEnabled(false);
        jList3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jList3);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Ιδιότητα");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField3.setFocusable(false);
        jTextField3.setRequestFocusEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3)))
                .addGap(40, 40, 40)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed
        exportFile(); // Κλήση μεθόδου για Εξαγωγή txt Αρχείου
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jList2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jList2KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            java.util.logging.Logger.getLogger(Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Export.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Export().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
