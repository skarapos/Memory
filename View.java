
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import java.util.Random;
/**
 * @author Sotiris Karapostolakis
 */

public class View extends JFrame{
	private GridBagConstraints constraints;
    private GridBagLayout layout;
    private ButtonGroup balbuttongroup;
    private ButtonGroup modebuttongroup;
    private ButtonGroup memorybuttongroup;
    private JRadioButtonMenuItem[] bal;
    private JRadioButtonMenuItem[] mode1;
    private JRadioButtonMenuItem[] mem;
    private JButton[] buttongame;
    private JButton newgame;
    private JButton confirm;
    private JMenu file;
    private JMenu edit;
    private JMenu balmenu;
    private JMenu modemenu;
    private JMenu memorymenu;
    private JMenuItem aboutitem;
    private JMenuItem instructions;
    private JMenuItem exit;
    private JMenuBar bar;
    private Cards_array v;//αντικειμενο για τους πινακες με τις καρτες και τις καρτες μνημης
    private Icon[] icon;//Πινακας με το συνολο των εικονων
    private Logic logic;//αντικειμενο για την λογικη του παιχνιδιου
    private JTextField textfield1;//textfield για το σκορ του πρωτου παικτη
    private JTextField textfield2;//textfield για το σκορ του δευτερου παικτη
    private JLabel label1;//label για το ονομα του πρωτου παικτη
    private JLabel label2;//label για το ονομα του δευτερου παικτη
    private JLabel label3;//label που δειχνει ποιανου σειρα ειναι
    private Person player1;
    private Person player2;
    private Machine machine;
    private boolean order1=false;//μεταβλητη που οταν ειναι false σημαινει οτι ειναι σειρα του πρωτου παικτη και οταν ειναι true σημαινει οτι ειναι σειρα του δευτερου παικτη
    private int f=-1;//μεταβλητη που δειχνει το id της πρωτης καρτας που αντιστοιχει στο πρωτο απο τα 2 κουμπια
    private int d=0;//μεταβλητη που μετραει το πληθος των κουμπιων περα του newgame που εχουν πατηθει και οταν φτασει στο 2 μηδενιζει
    private int length1=0;//μεταβλητη για το μεγεθος του πινακα μνημης
    private int f2=-1;//μεταβλητη που δειχνει το id της δευτερης καρτας που αντιστοιχει στο δευτερο κουμπι
    private int end=0;//μεταβλητη που βοηθαει στον τερματισμο του παιχνιδιου
    /**
     * Constructor ο οποιος δημιουργει το γραφικο περιβαλλον.
     */
    public View()
    {
        super("MEMORY GAME");
        setLayout(layout=new GridBagLayout());
        constraints=new GridBagConstraints();
        label1=new JLabel("Player 1 Score",SwingConstants.CENTER);
        label2=new JLabel("Player 2 Score",SwingConstants.CENTER);
        label3=new JLabel("MEMORY GAME",SwingConstants.CENTER);
        constraints.fill=GridBagConstraints.HORIZONTAL;
        addComponent(label1,1,0,2,1);
        addComponent(label2,1,2,2,1);
        addComponent(label3,0,1,2,1);
        textfield1=new JTextField(10);
        textfield2=new JTextField(10);
        addComponent(textfield1,2,0,2,1);
        addComponent(textfield2,2,2,2,1);
        logic=new Logic();
        icon=new ImageIcon[11];//πινακας με τις εικονες 
        icon[0]=new ImageIcon(getClass().getResource("0.jpg"));
        icon[1]=new ImageIcon(getClass().getResource("1.jpg"));
        icon[2]=new ImageIcon(getClass().getResource("2.jpg"));
        icon[3]=new ImageIcon(getClass().getResource("3.jpg"));
        icon[4]=new ImageIcon(getClass().getResource("4.jpg"));
        icon[5]=new ImageIcon(getClass().getResource("5.jpg"));
        icon[6]=new ImageIcon(getClass().getResource("6.jpg"));
        icon[7]=new ImageIcon(getClass().getResource("7.jpg"));
        icon[8]=new ImageIcon(getClass().getResource("8.jpg"));
        icon[9]=new ImageIcon(getClass().getResource("9.jpg"));
        icon[10]=new ImageIcon(getClass().getResource("10.jpg"));
        file=new JMenu("File");
        edit=new JMenu("Edit");
        aboutitem=new JMenuItem("Σχετικά...");
        instructions=new JMenuItem("Οδηγίες για σωστή χρήση του προγράμματος");
        exit=new JMenuItem ("Έξοδος");
        aboutitem.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        JOptionPane.showMessageDialog(View.this,"Δημιουργός:Sotiris Karapostolakis\nAEM:2125\nΈτος:2013\nΕλπίζω να το ευχαριστηθείτε!!!","Σχετικά",JOptionPane.PLAIN_MESSAGE);
                    }
                });
        instructions.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        JOptionPane.showMessageDialog(View.this, "Επιλέξετε πρώτα τον αριθμό των balander,το είδος παιχνιδιού\n και την μνήμη του υπολογιστή εάν πρόκειται για παιχνίδι μεταξύ ανθρώπου και υπολογιστη.\nΣτη συνέχεια πατήστε το πλήκτρο newgame.\nΣε κάθε επιλογή είτε αυτή αφορά παίκτη είτε αφορά τον υπολογιστή\nπρέπει να πατάτε το πλήκτρο confirm.","Οδηγίες για σωστή χρήση του προγράμματος" , JOptionPane.PLAIN_MESSAGE);
                    }
                });
        exit.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        System.exit(0);
                    }
                });
        file.add(aboutitem);
        file.add(instructions);
        file.add(exit);
        bar=new JMenuBar();
        setJMenuBar(bar);
        bar.add(file);
        bar.add(edit);
        ItemHandler itemhandler=new ItemHandler();
        String[] numofbal={"0","1","2","3","4","5","6","7"};
        balmenu=new JMenu("Αριθμός balander");
        bal=new JRadioButtonMenuItem[numofbal.length];
        balbuttongroup=new ButtonGroup();
        for(int counter=0;counter<bal.length;counter++)
        {
            bal[counter]=new JRadioButtonMenuItem(numofbal[counter]);
            balmenu.add(bal[counter]);
            balbuttongroup.add(bal[counter]);
        }
        bal[0].setSelected(true);
        edit.add(balmenu);
        edit.addSeparator();
        String[] modes={"Ανθρωπος-Ύπολογιστης","Ανθρωπος-Ανθρωπος"};
        modemenu=new JMenu("Είδος παιχνιδιού");
        mode1=new JRadioButtonMenuItem[modes.length];
        modebuttongroup=new ButtonGroup();
        for(int counter=0;counter<modes.length;counter++)
        {
            mode1[counter]=new JRadioButtonMenuItem(modes[counter]);
            modemenu.add(mode1[counter]);
            modebuttongroup.add(mode1[counter]);
        }
        mode1[0].setSelected(true);
        edit.add(modemenu);
        edit.addSeparator();
        String[] numofmem={"0","1","2","3","4","5","6"};
        memorymenu=new JMenu("Μνήμη υπολογιστή");
        mem=new JRadioButtonMenuItem[numofmem.length];
        memorybuttongroup=new ButtonGroup();
        for (int counter=0;counter<numofmem.length;counter++)
        {
            mem[counter]=new JRadioButtonMenuItem(numofmem[counter]);
            memorymenu.add(mem[counter]);
            memorybuttongroup.add(mem[counter]);
            mem[counter].addActionListener(itemhandler);
        }
        mem[0].setSelected(true);
        edit.add(memorymenu);
        v=new Cards_array(length1);
        buttongame=new JButton[20];
        constraints.fill=GridBagConstraints.BOTH;
        int row=4;
        int column=0;
        for(int z=0;z<20;z++)
        {
            buttongame[z]=new JButton();
            buttongame[z].setPreferredSize(new Dimension(70,70));
            addComponent(buttongame[z],row,column,1,1);
            if (column==3)
            {
                row++;
                column=0;
            }
            else
                column++;
        }
        confirm=new JButton("Confirm");
        newgame=new JButton("New Game");
        newgame.setPreferredSize(new Dimension(70,70));
        confirm.setPreferredSize(new Dimension(70,70));
        addComponent(newgame,10,0,2,1);
        addComponent(confirm,10,2,2,1);
        ButtonHandler handler=new ButtonHandler();
        newgame.addActionListener(handler);
        confirm.addActionListener(handler);
        for(int counter1=0;counter1<20;counter1++)        
        {
               buttongame[counter1].addActionListener(handler);
        }
    }
    /**
     * Τοποθετει το καθε component στο πανελ.
     * @param component
     * @param row1
     * @param column1
     * @param width1
     * @param height1 
     */
    private void addComponent(Component component,int row1,int column1,int width1,int height1)
    {
        constraints.gridx=column1;
        constraints.gridy=row1;
        constraints.gridwidth=width1;
        constraints.gridheight=height1;
        layout.setConstraints(component,constraints);
        add(component);
    }
    private class ItemHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            for(int counter=0;counter<mem.length;counter++)
            {
                if (mem[counter].isSelected())
                {
                    length1=counter;
                }
            }
        }
    }
    /**
     * Εδώ διαχειριζονται τα κλικ που γινονται στα κουμπια.Εαν γινει κλικ στο κουμπι newgame αναλογα με τον αριθμο καρτων balander 
     * δημιουργουνται τοσες καρτες balander και 16-(πληθος balander) κλασσικες καρτες.Επισης βλέπει το ειδος παιχνιδιου και αναλογα 
     * ζηταει ονοματα για τους παικτες.Αν πατηθει καποιο αλλο κουμπί πρωτου του newgame τοτε δεν συμβαινει τιποτα.Αν πατηθει καποιο 
     * κουμπι μετα το newgame,τοτε περιμενει να πατηθει δευτερο,και οταν πατηθει και το κουμπι confirm καλει μεσω της logic τη συναρτηση για την εκτελεση
     * παιχνιδιου.Οι κινησεις του υπολογιστη ειναι τυχαιες λαμβανοντας υποψιν του και την μνημη του.
     */
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if  (event.getSource()==newgame)
            {
                for(int counter1=0;counter1<20;counter1++)
                {
                    buttongame[counter1].setIcon(null);//γυρναει ολες τις καρτες 
                }
                end=0;
                if (mode1[0].isSelected())//Μολις πατηθει το newgame ζηταει ονομα παικτη και δημιουργει τα αντικειμενα για τον παικτη ανθρωπο και παικτη υπολογιστη
                {
                    String name=JOptionPane.showInputDialog("Ονόμασε τον παίκτη ");
                    player1=new Person(1,name);
                    label1.setText(name);
                    machine=new Machine(2);
                    label2.setText("Υπολογιστής");
                    label3.setText("Σειρά : "+name);
                    textfield1.setText("");
                    textfield2.setText("");
                }
                else if(mode1[1].isSelected())//μολις πατηθει το newgame ζηταει τα ονοματα παικτων και δημιουργει τα αντικειμενα για τους παικτες ανθρωπους
                {
                    String name1=JOptionPane.showInputDialog("Ονόμασε τον πρώτο παίκτη ");
                    String name2=JOptionPane.showInputDialog("Ονόμασε τον δεύτερο παίκτη ");
                    player1=new Person(1,name1);
                    label1.setText(name1);
                    player2=new Person(2,name2);
                    label2.setText(name2);
                    label3.setText("Σειρα : "+name1);
                    textfield1.setText("");
                    textfield2.setText("");
                }
                for (int counter=0;counter<bal.length;counter++)
                {
                    Random r1=new Random();//γεννητρια τυχαιων αριθμων για την δημιουργια καρτων.
                    int[] q={0,0,0,0,0,0,0,0,0,0,0};//πινακας οπου καθε κελι εκτος του μηδενος παιρνει μεχρι το 2 ενω το μηδεν παιρνει τιμες αναλογα με το πληθος των balander
                    int y;//μεταβλητη που παιρνει τον τυχαιο αριθμο
                    int t;
                    /**
                     * Η δημιουργια καρτων γινεται με την βοηθεια μιας Random μεταβλητης και του q πινακα.
                     */
                    if(bal[0].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            y=1+r1.nextInt(10);
                            t=0;
                            while(t!=1)//βρογχος που επαναλαμβανεται μεχρι ο τυχαιος αριθμος να ειναι σωστος
                            {
                                if (q[y]<2)//αν ο αριθμος των καρτων με τν ιδια αξια ειναι μικροτερος του δυο-απαιτουνται δυο για να δημιουργειται ζευγαρι-τοτε ειναι σωστος ο τυχαιος αριθμος
                                {
                                    cl_card m=new cl_card(k,y);//σε καθε δημιουργια καρτας το k ειναι το id και το y ειναι το value
                                    v.add_card(m);
                                    q[y]++;
                                    t=1;
                                }
                                else//αν οχι τοτε βρισκουμε αλλο τυχαιο αριθμο
                                {
                                    y=1+r1.nextInt(10);
                                }
                            }
                        }
                    }
                    else if (bal[1].isSelected())
                    {
                        for(int k=0;k<20;k++)    
                        {
                            if ((k==19)&&(q[0]==0))//Αν ο αριθμος των balander ειναι 0 τοτε στις 16-(αριθμος καρτων balander) τελευταιες επαναληψεις  δημιουργουνται τοσες καρτες balander οσο ειναι ο επιλεγμενος αριθμος 
                            {
                                bal_card m1=new bal_card(19,0);
                                v.add_card(m1);
                                q[0]++;
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<1))//γινεται ο ελεγχος για το υ και το κελι q[0] παιρνει τιμες μεχρι το πληθος των balander που θελει να εχει το παιχνιδι ο χρηστης
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                }
                            }
                        }
                    }
                    else if (bal[2].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            if (((k==18)||(k==19))&&((q[0]<2)))
                            {
                                bal_card m1=new bal_card(k,0);
                                v.add_card(m1);
                                q[0]++;    
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<2))
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }    
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                }
                            }
                        }
                    }
                    else if (bal[3].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            if (((k==17)||(k==18)||(k==19))&&(q[0]<3))
                            {
                                bal_card m1=new bal_card(k,0);
                                v.add_card(m1);
                                q[0]++;    
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<3))
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }    
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                }
                            }
                        }
                    }
                    else if (bal[4].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            if (((k==16)||(k==17)||(k==18)||(k==19))&&(q[0]<4))
                            {
                                bal_card m1=new bal_card(k,0);
                                v.add_card(m1);
                                q[0]++;    
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<4))
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }    
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                }
                            }
                        }                    
                    }
                    else if (bal[5].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            if (((k==15)||(k==16)||(k==17)||(k==18)||(k==19))&&(q[0]<5))
                            {
                                bal_card m1=new bal_card(k,0);
                                v.add_card(m1);
                                q[0]++;
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<5))
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }    
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                }
                            }
                        }
                    }
                    else if (bal[6].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            if (((k==14)||(k==15)||(k==16)||(k==17)||(k==18)||(k==19))&&(q[0]<6))
                            {
                                bal_card m1=new bal_card(k,0);
                                v.add_card(m1);
                                q[0]++;    
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<6))
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }   
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                } 
                            }
                        }
                    }
                    else if (bal[7].isSelected())
                    {
                        for(int k=0;k<20;k++)
                        {
                            if (((k==13)||(k==14)||(k==15)||(k==16)||(k==17)||(k==18)||(k==19))&&(q[0]<3))
                            {
                                bal_card m1=new bal_card(k,0);
                                v.add_card(m1);
                                q[0]++;    
                            }
                            else
                            {
                                y=r1.nextInt(11);
                                t=0;
                                while(t!=1)
                                {
                                    if ((y==0)&&(q[0]<7))
                                    {
                                        bal_card m1=new bal_card(k,0);
                                        v.add_card(m1);
                                        q[0]++;
                                        t=1;
                                    }    
                                    else if ((q[y]<2)&&(y!=0))
                                    {
                                        cl_card m=new cl_card(k,y);
                                        v.add_card(m);
                                        q[y]++;
                                        t=1;
                                    }
                                    else
                                    {
                                        y=r1.nextInt(11);
                                        t=0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if (event.getSource()==confirm)
            {
                int r;
                if(mode1[0].isSelected())
                {
                    if (order1==false)
                    {
                        if (d==2)//οταν γινει 2 σημαινει οτι εχουν επιλεγει 2 καρτες εχουν επιλεγει και πρεπει να γινει ο ελεγχος μεταξυ τους
                        {
                            textfield1.setText(""+logic.Run_game1(v.searchcard(f),v.searchcard(f2),player1,machine,order1));// ενημερωνεται το textfield μεσω της κλησης της Run Game1
                            logic.flip(buttongame,v,f,f2);
                            order1=!order1;
                            d=0;
                            f=-1;//αρχικοποιείται επειδή πατηθηκαν δυο κουμπια
                            f2=-1;//αρχικοποιείται επειδή πατηθηκαν δυο κουμπια
                            label3.setText(label2.getText());//αλλαγη σειρας
                            if (logic.endgame(buttongame,v))
                            {
                                JOptionPane.showMessageDialog(View.this, "Τελος παιχνιδιού", "ΤΕΛΟΣ", JOptionPane.PLAIN_MESSAGE);
                                end=1;
                                order1=false;
                            }
                        }
                        if (order1==true)//μετραει το πληθος των γυρισμενων καρτων και αν ειναι μικροτερος του 19 σταματαει ο υπολογιστης να επιλεγει καρτες
                        {
                            r=0;
                            for(int counter3=0;counter3<20;counter3++)
                            {
                                if(buttongame[counter3].getIcon()!=null)
                                    r++;
                            }
                            if (r<19)
                                logic.machinecard(buttongame, v, length1);//καλειται η machine card καθως ειναι σειρα του υπολογιστη
                        }
                    }
                    else 
                    {
                        if (d==2)
                        {
                            textfield2.setText(""+logic.Run_game1(v.searchcard(f),v.searchcard(f2),player1,machine,order1));
                            if (logic.flipcardmachine(buttongame,v,f,f2)==true)//αν οι καρτες δεν ειναι ιδιες τοτε αποθηκευονται στη μνημη
                            {
                                v.addmemcard(v.searchcard(f));
                                v.addmemcard(v.searchcard(f2));
                            }
                            else
                            {//αλλιως διαγραφονται οι καρτες απο την μνημη του υπολογιστη
                                if (v.searchmem(v.searchcard(f).returnid())!=null)
                                    v.deletemem(v.searchcard(f).returnvalue());
                                if (v.searchmem(v.searchcard(f2).returnid())!=null)
                                    v.deletemem(v.searchcard(f2).returnvalue());
                            }
                            order1=!order1;
                            label3.setText(label1.getText());
                            d=0;
                            f=-1;
                            f2=-1;
                            if (logic.endgame(buttongame,v))
                            {
                                JOptionPane.showMessageDialog(View.this, "Τελος παιχνιδιού", "ΤΕΛΟΣ", JOptionPane.PLAIN_MESSAGE);
                                end=1;
                                order1=false;
                            }
                        }
                    }
                }
                else if(mode1[1].isSelected())
                {
                    if (order1==false)
                    {
                        if (d==2)
                        {
                            textfield1.setText(""+logic.Run_game2(v.searchcard(f),v.searchcard(f2),player1,player2,order1));
                            logic.flip(buttongame,v,f,f2);
                            order1=!order1;
                            d=0;
                            f=-1;
                            f2=-1;
                            label3.setText(label2.getText());
                            if (logic.endgame(buttongame,v))
                            {
                                JOptionPane.showMessageDialog(View.this, "Τελος παιχνιδιού", "ΤΕΛΟΣ", JOptionPane.PLAIN_MESSAGE);
                                end=1;
                                order1=false;
                            }
                        }
                    }
                    else
                    {
                        if (d==2)
                        {
                            textfield2.setText(""+logic.Run_game2(v.searchcard(f),v.searchcard(f2),player1,player2,order1));
                            logic.flip(buttongame, v, f, f2);
                            order1=!order1;
                            d=0;
                            f=-1;
                            f2=-1;
                            label3.setText(label1.getText());
                            if (logic.endgame(buttongame,v))
                            {
                                JOptionPane.showMessageDialog(View.this, "Τελος παιχνιδιού", "ΤΕΛΟΣ", JOptionPane.PLAIN_MESSAGE);
                                end=1;
                                order1=false;
                            }
                        }
                    }  
                }
            }
            else
            {
                for (int x=0;x<20;x++)// ελεγχει ποιο κουμπι πατηθηκε
                {
                    int r;
                    if (event.getSource()==buttongame[x])
                    {   
                        if ((buttongame[x].getIcon()==null)&&(end!=1))
                        {
                            buttongame[x].setIcon(icon[(v.searchcard(x)).returnvalue()]);// αν ειναι κενο το κουμπι τοτε εμφανιζει την εικονα του κουμπιου
                            d++;
                            if (d==1)
                                f=x;
                            if (d==2)
                                f2=x;
                            if ((d==1)&&(mode1[0].isSelected())&&(order1==true))//μετραει το πληθος των γυρισμενων καρτων και αν ειναι μικροτερος του 20 σταματαει ο υπολογιστης να επιλεγει καρτες
                            {
                                f2=x;
                                r=0;
                                for(int counter2=0;counter2<20;counter2++)
                                {
                                    if(buttongame[counter2].getIcon()!=null)
                                        r++;
                                }
                                if (r<20)
                                    logic.machinecard(buttongame, v, length1);//καλειται η machine card καθως ειναι σειρα του υπολογιστη
                            }
                        }
                    }  
                }
            }
        }
    }
}
