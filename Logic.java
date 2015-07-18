import java.util.Random;
import javax.swing.JButton;
/**
 * @author Sotiris Karapostolakis
 */
public class Logic{
    public Logic(){}
    /**
     * Ελεγχει τις καρτες αν εχουν ιδια αξια για το παιχνιδι μεταξυ ανθρωπου-υπολογιστη.
     * @param f
     * @param x
     * @param p1
     * @param m1
     * @param order
     * @return Επιστρεφει το σκορ του παικτη η του υπολογιστη.
     */
    public int Run_game1(Card f,Card x,Player p1,Machine m1,boolean order)
    {
        if (order==false)
        {
            if (f.returnvalue()==x.returnvalue())
                return p1.updatescore(1);
            else if (((f.returnvalue()==0)&&(x.returnvalue()!=0))||((f.returnvalue()!=0)&&(x.returnvalue()==0)))
                return p1.updatescore(1);
            else
                return p1.updatescore(0);
        }
        else
        {
            if (f.returnvalue()==x.returnvalue())
                return m1.updatescore(1);
            else if (((f.returnvalue()==0)&&(x.returnvalue()!=0))||((f.returnvalue()!=0)&&(x.returnvalue()==0)))
                return m1.updatescore(1);
            else
                return m1.updatescore(0);
        }
    }
    /**
     * Ελεγχει τις καρτες αν εχουν ιδια αξια στο παιχνιδι μεταξυ ανθρωπων.
     * @param f
     * @param x
     * @param p1
     * @param p2
     * @param order
     * @return Το σκορ του καθε παικτη.
     */
    public int Run_game2(Card f,Card x,Player p1,Player p2, boolean order)
    {
        if (order==false)
        {
            if (f.returnvalue()==x.returnvalue())
                return p1.updatescore(1);
            else if (((f.returnvalue()==0)&&(x.returnvalue()!=0))||((f.returnvalue()!=0)&&(x.returnvalue()==0)))
                return p1.updatescore(1);
            else
                return p1.updatescore(0);
        }
        else
        {
            if (f.returnvalue()==x.returnvalue())
                return p2.updatescore(1);
            else if (((f.returnvalue()==0)&&(x.returnvalue()!=0))||((f.returnvalue()!=0)&&(x.returnvalue()==0)))
                return p2.updatescore(1);
            else
                return p2.updatescore(0);
        }
    }
    /**
     * Βρισκει την καρτα που θα διαλεξει ο υπολογιστης λαμβανοντας υποψιν την μνημη του υπολογιστη.
     * @param buttonagame
     * @param x
     * @param leng
     */
    public void machinecard(JButton buttonagame[],Cards_array x,int leng)
    {
        Random r2=new Random();
        int k=0;
        for(int counter=0;counter<leng;counter++)
        {
            if (x.searchmem(counter)==null)
                k++;
        }
        if (k==leng)
        {
            while(true)
            {
                int r=r2.nextInt(19);
                if (buttonagame[r].getIcon()==null)
                {
                    buttonagame[r].doClick();
                    return;
                }
            }
        }
        else 
            buttonagame[x.searchmem(0).returnid()].doClick();
    }
    /**
     * Ελέγχει εάν υπάρχουν υποψήφια δυνατά ζευγάρια έτσι ώστε να σταματήσει το παιχνίδι.
     * @param game
     * @param cv
     * @return 1 εάν δεν υπάρχουν υποψήφια δυνατά ζευγάρια 0 εαν υπαρχουν.
     */
    public boolean endgame (JButton game[],Cards_array cv)
    {
        for (int counter=0;counter<20;counter++)
        {
            if (game[counter].getIcon()==null)
            {
                for(int count=0;count<20;count++)
                {
                    if (count==counter)
                        continue;
                    if (game[count].getIcon()==null)
                    {
                        if ((cv.searchcard(count).returnvalue()==cv.searchcard(counter).returnvalue())||(cv.searchcard(count).returnvalue()==0)||(cv.searchcard(counter).returnvalue()==0))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * Ελέγχει εάν οι κάρτες δεν είναι ίδιες τοτε τις γυρναει αλλιως δεν κανει τιποτα.
     * @param game1
     * @param cv1
     * @param f1
     * @param x1
     */
    public void flip (JButton game1[],Cards_array cv1,int f1,int x1)
    {
        if((cv1.searchcard(f1).returnvalue()!=cv1.searchcard(x1).returnvalue())&&(cv1.searchcard(f1).returnvalue()!=0)&&(cv1.searchcard(x1).returnvalue()!=0))
        {
            game1[f1].setIcon(null);
            game1[x1].setIcon(null);
        }
    }
    /**
     * Ελέγχει εάν οι κάρτες του υπολογιστή δεν είναι ίδιες.Αν ναι τις γυρναει τις γυρνάει.
     * @param game2
     * @param cv2
     * @param f2
     * @param x2
     * @return ΤRUE εάν γύρισαν οι κάρτες,FALSE αν δεν γύρισαν.
     */
    public boolean flipcardmachine(JButton game2[],Cards_array cv2,int f2,int x2)
    {
        if((cv2.searchcard(f2).returnvalue()!=cv2.searchcard(x2).returnvalue())&&(cv2.searchcard(f2).returnvalue()!=0)&&(cv2.searchcard(x2).returnvalue()!=0))
        {
            game2[f2].setIcon(null);
            game2[x2].setIcon(null);
            return true;
        }
        else
            return false;
    }
}
