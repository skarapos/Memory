/**
 *
 * @author Sotiris Karapostolakis
 */
public class Card{
    private int id;
    private int value;
    /**
     * Constructor ��� ��� ���������� ��� ������.
     * @param id
     * @param value
     */
    public Card(int id,int value)
    {
        this.id=id;
        this.value=value;
    }
    /**
     *
     * @return �� id ��� ������.
     */
    public int returnid()
    {
        return id;
    }
    /**
     *
     * @return ��� ���� ��� ������.
     */
    public int returnvalue()
    {
        return value;
    }
}