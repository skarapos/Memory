
/**
 *
 * @author Sotiris Karapostolakis
 */
public class Person extends Player{
    private String name;//����� ��� ������
    /**
     * Constructor ��� ���������� ��� ������ �������.
     * @param numb
     * @param nam
     */
    public Person(int numb,String nam)
    {
        super(numb);
        name=nam;
    }
}