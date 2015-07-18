import java.util.Random;
import javax.swing.JButton;
/**
 * @author Sotiris Karapostolakis
 */
public class Logic{
    public Logic(){}

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

    public void flip (JButton game1[],Cards_array cv1,int f1,int x1)
    {
        if((cv1.searchcard(f1).returnvalue()!=cv1.searchcard(x1).returnvalue())&&(cv1.searchcard(f1).returnvalue()!=0)&&(cv1.searchcard(x1).returnvalue()!=0))
        {
            game1[f1].setIcon(null);
            game1[x1].setIcon(null);
        }
    }

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
