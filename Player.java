
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Player{
    private int num;
    private int score;

    public Player(int num)
    {
        this.num=num;
        score=0;
    }

    public int  updatescore(int newscore)
    {
        return score+=newscore;
    }
}
