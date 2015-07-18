import java.util.ArrayList;
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Cards_array {
    private ArrayList<Card> myarray1;
    private Card[] myarray2;
    private int len;
    /**
     * Constructor που δημιουργει μια ArrayList για τις καρτες που δημιουργουνται και εναν πινακα για την μνημη του υπολογιστη με μεγεθος την παραμετρο len.
     * @param len
     */
    public Cards_array(int len)
    {
        myarray2=new Card[len];
        myarray1=new ArrayList<>();
        this.len=len;
        for(int counter=0;counter<len;counter++)
        {
            myarray2[counter]=null;
        }
    }
    /**
     * Προσθετει στην ArrayList την καρτα p.
     * @param p
     */
    public void add_card(Card p)
    {
            myarray1.add(p);
    }
    /**
     * Αναζητει την καρτα που βρισκετε στο κελι e στην ArrayList.
     * @param e
     * @return Την καρτα.
     */
    public Card searchcard(int e)
    {
        return myarray1.get(e);
    }
    /**
     * Προσθετει την καρτα b στον πινακα της μνημης του υπολογιστη.
     * @param b
     */
    public void addmemcard(Card b)
    {
        for(int counter=0;counter<len;counter++)
        {
            if(myarray2[counter]==null)
            {
                myarray2[counter]=b;
                return;
            }    
        }
        for(int counter=0;counter<len;counter++)
        {
            myarray2[counter]=myarray2[counter+1];
            if(counter==len-1)
                myarray2[len-1]=b;
        }
    }
    /**
     * Αναζητει την καρτα με id g.
     * @param g
     * @return Την καρτα με id g,αλλιως null.
     */
    public Card searchmem(int g)
    {
        for(int counter=0;counter<len;counter++)
        {
            if(myarray2[counter].returnid()==g)
            {
                return myarray2[counter];
            }
        }
            return null;
    }
    /**
     * Διαγραφει την καρτα με id a απο την μνημη του υπολογιστη.
     * @param a
     */
    public void deletemem(int a)
    {
        int t=0;
        for (int counter=0;counter<len;counter++)
        {
            if(myarray2[counter].returnid()==a)
            {
                myarray2[counter]=null;
                t=counter;
            }
        }
        for(int counter=t;counter<len;counter++)
        {
            myarray2[counter]=myarray2[counter+1];
            if (counter==len-1)
                myarray2[len-1]=null;
        }
    }
}
