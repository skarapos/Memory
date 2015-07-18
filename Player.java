
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Player{
    private int num;//αριθμος παικτη
    private int score;//σκορ του παικτη
    /**
     * Constructor για την δημιουργια του καθε παικτη.
     * @param num
     */
    public Player(int num)
    {
        this.num=num;
        score=0;
    }
    /**
     * Ανανεωνει το σκορ του καθε παικτη.
     * @param newscore
     * @return Το ανανεωμενο σκορ.
     */
    public int  updatescore(int newscore)
    {
        return score+=newscore;
    }
}