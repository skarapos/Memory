/**
 *
 * @author Sotiris Karapostolakis
 */
public class Card{
    private int id;
    private int value;
    /**
     * Constructor γαι την δημιουργια της καρτας.
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
     * @return Το id της καρτας.
     */
    public int returnid()
    {
        return id;
    }
    /**
     *
     * @return Την αξια της καρτας.
     */
    public int returnvalue()
    {
        return value;
    }
}