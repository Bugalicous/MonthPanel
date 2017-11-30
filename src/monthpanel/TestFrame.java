package monthpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.joda.time.DateTime;

/**
 *
 * @author bug
 */
public class TestFrame extends JFrame{
    
    private DateTime now = new DateTime();
    
    public TestFrame(){
        setTitle("Test Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        BoxLayout contentPaneLayout = new BoxLayout(contentPane, BoxLayout.LINE_AXIS);
        contentPane.setLayout(contentPaneLayout);
        MonthPanel mp = new MonthPanel(now);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        JButton left = new JButton("<<");
        JButton right = new JButton(">>");
        left.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               now=now.minusMonths(1);
               MonthPanel newMP = new MonthPanel(now);
               contentPane.removeAll();
               contentPane.add(left);
               contentPane.add(newMP);
               contentPane.add(right);
               revalidate();
           }
        });
        right.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               now = now.plusMonths(1);
               MonthPanel newMP = new MonthPanel(now);
               contentPane.removeAll();
               contentPane.add(left);
               contentPane.add(newMP);
               contentPane.add(right);
               revalidate();
           }
        });
        contentPane.add(left);
        contentPane.add(mp);
        contentPane.add(right);
        
        setContentPane(contentPane);
        pack();
    }
    
    public static void main(String[] args0){
        TestFrame tf = new TestFrame();
        tf.setVisible(true);
    }
    
}
