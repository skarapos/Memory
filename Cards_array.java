import java.util.ArrayList;
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Cards_array {
    private ArrayList<Card> myarray1;
    private Card[] myarray2;
    private int len;

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

    public void add_card(Card p)
    {
            myarray1.add(p);
    }

    public Card searchcard(int e)
    {
        return myarray1.get(e);
    }

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
