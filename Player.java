
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Player{
    private int num;//������� ������
    private int score;//���� ��� ������
    /**
     * Constructor ��� ��� ���������� ��� ���� ������.
     * @param num
     */
    public Player(int num)
    {
        this.num=num;
        score=0;
    }
    /**
     * ��������� �� ���� ��� ���� ������.
     * @param newscore
     * @return �� ���������� ����.
     */
    public int  updatescore(int newscore)
    {
        return score+=newscore;
    }
}