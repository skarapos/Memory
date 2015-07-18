import javax.swing.JFrame;

/**
 * @author Sotiris Karapostolakis
 */

public class Main {
    public static void main(String[] args) {
        View view=new View();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(350,560);
        view.setVisible(true);
    }
}