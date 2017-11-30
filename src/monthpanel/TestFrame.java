package monthpanel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import org.joda.time.DateTime;

/**
 *
 * @author bug
 */
public class TestFrame extends JFrame{
    
    
    public TestFrame(){
        setTitle("Test Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MonthPanel mp = new MonthPanel(new DateTime());
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setContentPane(mp);
        pack();
    }
    
    public static void main(String[] args0){
        TestFrame tf = new TestFrame();
        tf.setVisible(true);
    }
    
}
