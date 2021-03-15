/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvoptional1;

// Imports
    import static csvoptional1.Menu.counterFound;
    import static csvoptional1.Menu.id;
    import static csvoptional1.Menu.nullName;
    import java.util.ArrayList;
    import javax.swing.JOptionPane;
// END of Imports

public class Search extends javax.swing.JFrame {
    // Μεταβλητή για το εάν έχει βρεθεί σχέση
    static boolean foundRelation = false;
    
    // Μέθοδος ταξινόμισης πίνακα (id)
    private void orderId()
    {
        for(int i = 0; i < id.length; i ++)
        {
            for (int j = 0; j < id[i].length; j ++)
            {
                if(id[i][j] == null)
                {
                    id[i][j] = "zzzzzz" + String.valueOf(j);
                }    
                
            }
        }
        String temp = " "; // String για αντιμετάθεση
        for (int i = 0; i < id[0].length; i++)
        {
            for (int j = i + 1; j < id[0].length; j++) {
                if (id[0][i].compareTo(id[0][j])>0)
                {
                    // Αντιμετάθεση στοιχείων στον πίνακα id
                    temp = id[0][i];
                    id[0][i] = id[0][j];
                    id[0][j] = temp;
                    temp = id[1][i];
                    id[1][i] = id[1][j];
                    id[1][j] = temp;
                    temp = id[2][i];
                    id[2][i] = id[2][j];
                    id[2][j] = temp;
                }
            }
        }
    }
    // Τέλος μεθόδου ταξινόμισης πίνακα (id)
    
    // Μέθοδος για να βρούμε το φύλο 
    private String getSex(String name)
    {
        int temp =-1;
        int i = 0;
        String sex = "";
        do{
            if(name.equals(id[0][i]))
            {
                temp = i;       // Θέση
            }
            i++;
        }
        while((temp==-1)&&(i<id[0].length));
        
       do{
            if(id[1][temp].equalsIgnoreCase("man"))
            {
               sex = "man";     // Φύλο
            }
            else if(id[1][temp].equalsIgnoreCase("woman"))
            {
               sex = "woman";   // Φύλο
            }
            temp++;
       }
       while(name.equals(id[0][temp])); 
       // Επιστροφή του φύλου που βρέθηκε
       return sex;
    }
    
    // Μέθοδος για να δούμε εάν είναι ο πατέρας
    private String returnFather(String name) 
    {
        String father = "No father of "+name +" found";
        int i =0;
        String namesearching = "";
        ArrayList<Integer> possitions = new ArrayList<Integer>();
        // Βρίσκω σε ποιές θέσεις βρίσκεται το όνομα του οποίου το πατέρα ψάχνουμε  και τις αποθηκεύω σε μία λίστα
        do {
            namesearching = id[2][i];
            if(name.equals(id[2][i]))
            {
                possitions.add(i);
            }
            i++;
        }while(i < id[2].length);
        
        //Βρίσκω αν σε κάποιες από αυτές τις θέσεις στις αντίστοιχές τους στην μεσέα στήλη θπάρχει η λέξη πατέρς 
        for(int j : possitions )
        {
            if(id[1][j].equalsIgnoreCase("father"))//αν υπάρχει η λέξη πατέρς αποθηκεύουμε το όνομα του πατερα 
            {
                father = id[0][j];
            }
            
        }
        return father;
    }
    // Τέλος μεθόδου για να δούμε εάν είναι ο πατέρας 
    
    // Μέθοδος για να δούμε εάν είναι η μητέρα
    private String returnMother(String name) 
    {
        String mother = "No mother of "+name+" found";
        int i =0;
        String namesearching = "";
        ArrayList<Integer> possitions = new ArrayList<Integer>();
        //Βρίσκω σε ποιές θέσεις βρίσκεται το όνομα του οποίου το πατέρα ψάχνουμε και τις αποθηκεύω σε μία λίστα
        do{
            if(name.equals(id[2][i]))
            {
                namesearching = id[2][i];
                possitions.add(i);
            }
            i++;
        }while(i < id[2].length);
        
        //Βρίσκω αν σε κάποιες από αυτές τις θέσεις στις αντίστοιχές τους στην μεσέα στήλη θπάρχει η λέξη μητέρα 
        for(int j : possitions )
        {
            if(id[1][j].equalsIgnoreCase("mother"))//αν υπάρχει η λέξη πατέρς αποθηκεύουμε το όνομα της μητέρς 
            {
                mother = id[0][j];
            }   
        }
        return mother;
    }
    // Τέλος μεθόδου για να δούμε εάν είναι η μητέρα
    
    // Μέθοδος για να δούμε εάν είναι αδέρφια
    private ArrayList<String> returnSiblings(String name)
    {
        ArrayList<String> siblings = new ArrayList<String>();
        ArrayList<Integer> possitions = new ArrayList<Integer>();
        String father = "";
        father = returnFather(name);
        String mother = " ";
        mother = returnMother(name);
        int temp = 0;
        int i = 0;
        do
        {
            if(father.equals(id[0][i])||mother.equals(id[0][i]))
            {
                possitions.add(i);
            }
            i++;
        }while(i < id[0].length);
         
        siblingsLoop:
        for(int j : possitions)
        {
            if(id[1][j].trim().equalsIgnoreCase("father")||id[1][j].trim().equalsIgnoreCase("mother"))
            // Για να αποφύγω να έχω επανάληψη σε ονόματα
            {
                for(String a : siblings)
                {
                    if(a.equals(id[2][j])) 
                    {
                        continue siblingsLoop;
                    }
                }
                siblings.add(id[2][j]);
            } 
        }
        return siblings;    
    }
    // Τέλος μεθόδου για να δούμε εάν είανι αδέρφια
    
    // Μέθοδος για να δούμε εάν είναι γονέας
    private void searchIfParent(String name1, String name2)
    {
        if(returnFather(name2).equals(name1)||returnMother(name2).equals(name1))
        {
            if(getSex(name1).equals("man"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the father of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the father of "+name2);
                foundRelation = true;
            }
            else if(getSex(name1).equals("woman"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the mother of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the mother of "+name2);
                foundRelation = true;
            }
        }
    }
    // Τέλος μεθόδου για να δούμε εάν είναι γονέας
    
    // Μέθοδος για ζευγάρι
    private void searchIfMarried(String name1, String name2)
    {
        int temp =-1;
        int i = 0;
        //Εντοπίζω σε ποια θέση εντοπίζουμε για πρώτη φορα το όνομα αυτο στον πίνακα στην πρώτη στήλη[0]
        do{
            if(name1.equals(id[0][i]))
            {
                temp = i;
            }
            i++;
        }while((temp==-1)&&(i < id[0].length));

        //Ελέγχουμε αν βρίσκεται στην τρίτη στήλη του πίνακα το δεύτερο όνομα που ψάχνουμε στις θέσεις που στην πρώτη υπάρχει το όνομα του πρώτου 
        do
        {
            if(name2.equals(id[2][temp]))//ελέγχουμε αν ειναι το όνομα που ψάχνουμε
            {
                if(id[1][temp].equalsIgnoreCase("husband")||id[1][temp].equalsIgnoreCase("wife"))
                {
                    //ελέγχουμε αν είναι η συγγένεια που βρίσκει η μέθοδος
                    System.out.println(id[0][temp]+ " is the "+ id[1][temp]+" of "+id[2][temp]);
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, id[0][temp]+ " is the "+ id[1][temp]+" of "+id[2][temp]);
                    System.out.println();
                    foundRelation = true;   
                }
            }
        temp++;
        }while(name1.equals(id[0][temp]));
    }
    // Τέλος μεθόδου για ζευγάρι
  
    // Μέθοδος για παιδιά
    private void searchIfChild(String name1, String name2)
    {
        //Ελέγχουμε αν το όνομα του πατέρα του ονόματος που ψάχνουμε ειναι αυτο του δεύτερου προσώπου που διαλέγουμε
        if(returnFather(name1).equals(name2)||returnMother(name1).equals(name2))
        {
            if(getSex(name1).equals("man"))//αν το φύλλο της πρώτης επιλογής αντιστοιχει σε άντρας το ειναι γιος
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the son of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the son of "+name2);
                foundRelation = true;
            }
            else if(getSex(name1).equals("woman"))//αν το φύλλο της πρώτης γυναίκας αντιστοιχει σε γυναίκα το ειναι κόρη
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the daughter of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the daughter of "+name2);
                foundRelation = true;
            }
        }  
    }
    // Τέλος μεθόδου για παιδιά
    
    // Μέθοδος για αδέρφια
    private void searchIfSiblings(String name1,String name2)
    {
        int i = 0;
        if(returnFather(name1).equals(returnFather(name2))||returnMother(name1).equals(returnMother(name2)))
        {
            if(getSex(name1).equals("man"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the brother of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the brother of "+name2);
                foundRelation = true;
            }
            else if(getSex(name1).equals("woman"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the sister of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the sister of "+name2);
                foundRelation = true;
            }
        }
    }
    // Τέλος μεθόδου για αδέρφια
    
    // Μέθοδος για ξαδέρφια
    private void searchIfCousins(String name1, String name2)
    {
        String father1 = returnFather(name1);
        String father2 = returnFather(name2);
        String mother1 = returnMother(name1);
        String mother2 = returnMother(name2);
        ArrayList<String> sibs1 = returnSiblings(father1);//χρησιμοποιούμε την μέθοδο ανυτή για να μας επιστρέψει όλα τα δέρφια του πατέρα αυτού
        ArrayList<String> sibs2 = returnSiblings(mother1);//χρησιμοποιούμε την μέθοδο ανυτή για να μας επιστρέψει όλα τα δέρφια της μητέρας αυτού
        
        for(String i : sibs1)//Για όλες τα αδέρφια του πρώτου πατέρα
        {
            if(father2.equals(i)||mother2.equals(i))//ελέγχω αν κάποια από αυτά τα αδέρφια ειναι ο πατέρς του δέυτερου
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the cousin of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the cousin of "+name2);
                foundRelation = true;
            }
        }
        for(String i : sibs2)//Για όλες τα αδέρφια της πρώτης μητερας
        {
            if(father2.equals(i)||mother2.equals(i))//ελέγχω αν κάποια από αυτά τα αδέρφια ειναι ο πατέρς του δέυτερου
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the cousin of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the cousin of "+name2);
                foundRelation = true;
            }
        }
    }
    // Τέλος μεθόδου για ξαδέρφια
    
    // Μέθοδος για εγγόνια
    private void searchIfGrandChildren(String name1 , String name2)
    {
        String father1 = returnFather(name1);//βρίσκουμε τους γονείς του πρώτου προσώπου
        String mother1 = returnMother(name1);
        //ελέγχουμε αν ειναι το δεύτερο προσωπο ο πατέρας η η μητέρα του πατερα η της μητέρας του πρώτου προσώπου
        if(returnFather(father1).equals(name2)||returnMother(father1).equals(name2)||returnFather(mother1).equals(name2)||returnMother(mother1).equals(name2))
        {
            if(getSex(name1).equalsIgnoreCase("man"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the grandson of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the grandson of "+name2);
                foundRelation = true;
            }
            else if(getSex(name1).equalsIgnoreCase("woman"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1+ " is the granddaughter of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1+ " is the granddaughter of "+name2);
                foundRelation = true;
            }
        }
    }
    // Τέλος μεθόδου για εγγόνια
    
    // Μέθοδος για παπούδες
    private void searchIfGrandParents(String name1, String name2)
    {
        String father2 = returnFather(name2);//βρίσκουμε τους γονείς του πρώτου προσώπου
        String mother2 = returnMother(name2);
        String mother2_F = returnMother(father2);
        String father2_F = returnFather(father2);
        String mother2_M = returnMother(mother2);
        String father2_M = returnFather(mother2);
        //ελέγχουμε αν ειναι το πρώτο προσωπο ο πατέρας η η μητέρα του πατερα η της μητέρας του δεύτερου προσώπου
        if(father2_F.equals(name1)||mother2_F.equals(name1))
        {
           
            if(getSex(name1).equalsIgnoreCase("man"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the grandad of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the grandad of "+name2);
                foundRelation = true;
            }
            else if(getSex(name1).equalsIgnoreCase("woman"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the grandmother of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1+ " is the grandmother of "+name2);
                foundRelation = true;
            }
        }
        else if(father2_M.equals(name1)||mother2_M.equals(name1))
        {
           
            if(getSex(name1).equalsIgnoreCase("man"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the grandad of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1 + " is the grandad of "+name2);
                foundRelation = true;
            }
            else if(getSex(name1).equalsIgnoreCase("woman"))
            {
                // Mνμ για εμφάνηση σχέσης (JOptionPane)
                JOptionPane.showMessageDialog(null, name1 + " is the grandmother of "+name2);
                // Mνμ για εμφάνηση σχέσης (run)
                System.out.println(name1+ " is the grandmother of "+name2);
                foundRelation = true; 
            }   
        }
    }
    // Τέλος μεθόδου για παππούδες
    
    // Μέθοδος για θείους-θείες
    private void searchIfUncleAunt(String name1, String name2)
    {
        String father2 = returnFather(name2);
        String mother2 = returnMother(name2);
        ArrayList<String> sibsf = returnSiblings(father2);
        ArrayList<String> sibsm = returnSiblings(mother2);
        
        //ελέγχουμε αν είναι το πρώτο πρόσωπο αδερφός του πατέρα του δεύτερου
        for(String i : sibsf)
        {
            if(i.equals(name1))
            {
                if(getSex(name1).equalsIgnoreCase("man"))//ελέγχουμε το φύλλο
                {
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, name1 + " is the uncle of "+name2);
                    // Mνμ για εμφάνηση σχέσης (run)
                    System.out.println(name1+ " is the uncle of "+name2);
                    foundRelation = true;
                }
                else if(getSex(name1).equalsIgnoreCase("woman"))//ελέγχουμε το φύλλο
                {
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, name1 + " is the aunt of "+name2);
                    // Mνμ για εμφάνηση σχέσης (run)
                    System.out.println(name1 + " is the aunt of "+name2);
                    foundRelation = true;
                }
            }
        }
        //κάνουμε το ίδιο για τα αδέρφια της μητέρας
        for(String j : sibsm)
        {
            if(j.equals(name1))
            {
                if(getSex(name1).equalsIgnoreCase("man"))
                {
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, name1 + " is the uncle of "+name2);
                    // Mνμ για εμφάνηση σχέσης (run)
                    System.out.println(name1+ " is the uncle of "+name2);
                    foundRelation = true;
                }
                else if(getSex(name1).equalsIgnoreCase("woman"))
                {
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, name1 + " is the aunt of "+name2);
                    // Mνμ για εμφάνηση σχέσης (run)
                    System.out.println(name1 + " is the aunt of "+name2);
                    foundRelation = true;
                }
            }
        }  
    }
    // Τέλος μεθόδου για θείους-θείες
    
    // Μέθοδος για ανίψια
    private void searchIfNiblings(String name1 ,String name2)
    {
        String father1 = returnFather(name1);
        String mother1 = returnMother(name1);
        ArrayList<String> sibsf = returnSiblings(father1);
        ArrayList<String> sibsm = returnSiblings(mother1);
        
        //ελέγχουμε αν είναι το δεύτερο πρόσωπο αδερφός του πατέρα του πρώτου
        for(String i : sibsf)
        {
            if(i.equals(name2))
            {
                if(getSex(name1).equalsIgnoreCase("man"))
                {
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, name1 + " is the nephew of "+name2);
                    // Mνμ για εμφάνηση σχέσης (run)
                    System.out.println(name1+ " is the nephew of "+ name2);
                    foundRelation = true;
                }
                else if(getSex(name1).equalsIgnoreCase("woman"))
                {
                    // Mνμ για εμφάνηση σχέσης (JOptionPane)
                    JOptionPane.showMessageDialog(null, name1 + " is the niece of "+name2);
                    // Mνμ για εμφάνηση σχέσης (run)
                    System.out.println(name1 + " is the niece of "+name2);
                    foundRelation = true;
                }
            }
        }
    }
    // Τέλος μεθόδου για ανίψια
    
    // Μέθοδος για καμία σχέση
    private void relationNotFound()
    {
        // Mνμ για εμφάνηση σχέσης (JOptionPane)
        JOptionPane.showMessageDialog(null, "There was not found a possible relationship between the to selected people");
        // Mνμ για εμφάνηση σχέσης (run)
        System.out.println("There was not found a possible relationship between the to selected people");
    }
    // Τέλος μεθόδου για καμία σχέση
    
    
    // Αρχικοποίηση παιδίων φόρμας
    public void init2()
    {
        jComboBox1.setSize(0,0);    //  Αρχικοποίηση jComboBox1
        jComboBox2.setSize(0,0);    //  Αρχικοποίηση jComboBox2
        jComboBox1.setSize(1,counterFound); //  Αρχικοποίηση jComboBox1
        jComboBox2.setSize(1,counterFound); //  Αρχικοποίηση jComboBox2
        for(int x=0; x<counterFound; x++)
        {
            jComboBox1.addItem(nullName[x]); // γέμισμα comboBox1
            jComboBox2.addItem(nullName[x]); // γέμισμα comboBox1
        } 
    }
    // Τέλος αρχικοποίησης πεδίων φόρμας
    
    public Search() {
        initComponents();   // Initialise της φόρμας
        init2();            // Μέθοδος Initialise Φόρμας
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

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
        jTextField1.setText("Aναζήτιση Συγγένειας Ατόμων:");
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
        jTextField2.setText("Όνομα 1");
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
        jTextField3.setText("Όνομα 2");
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
        Final_Button_Enimerosi.setText("Αναζήτηση Συγγένειας");
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

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addGap(30, 30, 30)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
            // Μήνυμα αναζήτησης συγγένειας
            int reply = JOptionPane.showConfirmDialog(this,"Θέλετε να αναζητήσετε την συγγένεια μεταξύ των  "+jComboBox1.getSelectedItem()+" και  " +jComboBox2.getSelectedItem()+";",null,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(reply == JOptionPane.NO_OPTION)
            {
                //System.exit(0);
                this.dispose();
            }    
            else
            {
                String name1 = (String) jComboBox1.getSelectedItem();   //  Πρώτο όνομα που επιλέχθηκε
                String name2 = (String) jComboBox2.getSelectedItem();   //  Δεύτερο όνομα που επιλέχθηκε
                // if για να δούμε αν δεν έχει επιλεχθεί κάποιο απο τα ονόματα
                if(name1==null || name2==null)
                {
                    // Μήνυμα ΜΗ επιλογής κάποιου απο τα ονόματα (jOptionPane)
                    JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε 2 άτομα για να βρεθεί η Συγγένεια μεταξύ τους.","Alert",
                    JOptionPane.WARNING_MESSAGE);
                    // Μήνυμα ΜΗ επιλογής κάποιου απο τα ονόματα (Editor)
                    System.out.println("Παρακαλώ επιλέξτε 2 άτομα για να βρεθεί η Συγγένεια μεταξύ τους.");
                    System.out.println();
                }
                else if(name1==name2)
                {
                    // Μήνυμα επιλογής του ίδιου ατόμου (jOptionPane)
                    JOptionPane.showMessageDialog(null,"Επιλέξατε 2 φορές το ίδιο όνομα για αναζήτηση συγγένιας ("+name1+")","Alert",
                    JOptionPane.WARNING_MESSAGE);
                    // Μήνυμα επιλογής του ίδιου ατόμου (Editor)
                    System.out.println("Επιλέξατε 2 φορές το ίδιο όνομα για αναζήτηση συγγένιας ("+name1+")");
                    System.out.println();
                }
                else
                {
                    if(foundRelation == false)
                    {  
                        orderId();
                        /*
                        for( int i = 0; i < id[0].length; i++)
                        {
                            System.out.print(id[0][i]+" "+id[1][i]+" "+id[2][i]);
                            System.out.println();
                        } 
                        */
                        searchIfParent(name1,name2);
                        if(foundRelation == false)
                        {
                            searchIfMarried(name1 , name2);
                            if(foundRelation == false)
                            {
                                searchIfChild(name1 , name2);
                                if(foundRelation == false)
                                {
                                    searchIfSiblings(name1 , name2);
                                    if (foundRelation == false)
                                    {
                                        searchIfGrandParents(name1 , name2);
                                        if(foundRelation == false)
                                        {
                                            searchIfGrandChildren(name1 , name2);
                                            if(foundRelation == false)
                                            {
                                                searchIfCousins(name1 , name2);
                                                 if(foundRelation == false)
                                                {
                                                    searchIfNiblings(name1 , name2);
                                                    if(foundRelation == false)
                                                    {
                                                        searchIfUncleAunt(name1 , name2);
                                                        if(foundRelation == false)
                                                        {
                                                            relationNotFound();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }    
                }
            // Αρχικοποίηση της foundRelation 
            foundRelation=false;
            }
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
