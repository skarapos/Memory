
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Person extends Player{
    private String name;//ονομα του παικτη
    /**
     * Constructor που δημιουργει τον παικτη ανθρωπο.
     * @param numb
     * @param nam
     */
    public Person(int numb,String nam)
    {
        super(numb);
        name=nam;
    }
}