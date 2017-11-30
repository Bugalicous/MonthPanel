package monthpanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.joda.time.DateTime;

/** 
 *
 * @author bug
 */
public class MonthPanel extends JPanel {

    private DateTime inputDate;
    private final String[] monthNames = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"};
    private final int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final String[] dayInitials = {"S", "M", "Tu", "W", "Th", "F", "S"};
    private Dimension labelDimension = new Dimension(25, 20);
    private int weekCount;
    private int dayCount;
    private int newCount;

    
    /**
     * Constructor for the month, accepts DateTime object from JodaTime
     * @param inputDate Any day in the month desired as a DateTime object.
     */
    public MonthPanel(DateTime inputDate) {
        this.inputDate = inputDate;
        dayCount = 1;
        newCount = 1;
        weekCount = 1;
        JPanel monthPanel = new JPanel();
        BoxLayout boxLayoutMonthPanel = new BoxLayout(monthPanel, BoxLayout.LINE_AXIS);
        monthPanel.setLayout(boxLayoutMonthPanel);
        inputDate = inputDate.withDayOfMonth(1);
        BoxLayout boxLayout1 = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout1);
        JLabel monthNameLabel = new JLabel(monthNames[inputDate.getMonthOfYear() - 1]);
        monthNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton previousMonthButton = new JButton("<<");
        previousMonthButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               changeCurrentWorkingMonth(false);
           }
        });
        monthPanel.add(previousMonthButton);
        monthPanel.add(monthNameLabel);
        
        JButton nextMonthButton = new JButton(">>");
        nextMonthButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               changeCurrentWorkingMonth(true);
           }
        });
        monthPanel.add(nextMonthButton);
        
        
        
        this.add(monthPanel);
        JPanel daysPanel = new JPanel();
        BoxLayout boxLayout2 = new BoxLayout(daysPanel, BoxLayout.LINE_AXIS);
        daysPanel.setLayout(boxLayout2);
        for (int i = 0; i < dayInitials.length; i++) {
            JLabel label = new JLabel();
            label.setText(dayInitials[i]);
            label.setPreferredSize(labelDimension);
            label.setMaximumSize(labelDimension);
            label.setMinimumSize(labelDimension);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            daysPanel.add(label);
        }
        this.add(daysPanel);
        while (weekCount < 7) {
            if (weekCount == 1) {
                this.add(getWeekPanel(getFirstWeekNumbers(inputDate.getDayOfWeek()), true, false));
            } else if (dayCount + 7 > numberOfDays[inputDate.getMonthOfYear() - 1]) {
                int[] sendNumbers = new int[7];
                for (int i = 0; i < sendNumbers.length; i++) {
                    if (dayCount + i <= numberOfDays[inputDate.getMonthOfYear() - 1]) {
                        sendNumbers[i] = dayCount + i;
                    } else {
                        sendNumbers[i] = newCount;
                        newCount++;
                    }
                }
                this.add(getWeekPanel(sendNumbers, false, true));
            } else {
                int[] sendNumbers = new int[7];
                for (int i = 0; i < sendNumbers.length; i++) {
                    sendNumbers[i] = dayCount + i;
                }
                this.add(getWeekPanel(sendNumbers, false, false));
            }
            weekCount++;
        }
    }
    /**
     * Produces an array of numbers representing the dates of the first
     * week for the month in question.
     * @param leadingDays How many days should come before the first of the month.
     * @return int array with the end of the month numbers preceeding the first if necessary.
     */
    private int[] getFirstWeekNumbers(int leadingDays) {
        int[] theWeek = new int[7];
        int lastMonthDays = numberOfDays[inputDate.getMonthOfYear() - 2];
        int[] leadNumbers = new int[leadingDays];
        int count = 0;
        for (int i = leadNumbers.length; i > 0; i--) {
            leadNumbers[count] = lastMonthDays - i + 1;
            count++;
        }
        count = 1;
        for (int i = 0; i < leadNumbers.length; i++) {
            theWeek[i] = leadNumbers[i];
        }
        for (int i = leadNumbers.length; i < theWeek.length; i++) {
            theWeek[i] = count;
            count++;
        }
        return theWeek;
    }
    /**
     * Change the date of the working month forward or backward by 1.
     * @param forward True to change forward by 1 false to go backward.
     */
    private void changeCurrentWorkingMonth(boolean forward){
        if(forward){
            // Code to move month forward by 1.
            
            if(inputDate.getMonthOfYear()<12){
                // forward if it's not december yet.
            }else{
                // forward if you need to go into the next year because
                // it's december
            }
            
        }else{
            // Code to move month backward by 1.
            
            if(inputDate.getMonthOfYear()>1){
                // code to change date if it's not january
            }else{
                // code to change date in January because you need to go
                // to the previous year
            }
            
        }
    }
    /**
     * Generate a JPanel containing the days for the week in question.  Is set to 
     * automatically disable JLabels added to the Panel if days are fall-offs from the 
     * previous or next month in line.
     * @param input Integer array container the day numbers for the week.
     * @param firstWeek Whether this panel is the first week in the month.
     * @param lastWeek Whether this panel is the last week in the month.
     * @return JPanel containing days as labels, labels with mouse listeners in a box 
     * layout.
     */
    private JPanel getWeekPanel(int[] input, boolean firstWeek, boolean lastWeek) {
        JPanel panel = new JPanel();
        BoxLayout bl = new BoxLayout(panel, BoxLayout.LINE_AXIS);
        panel.setLayout(bl);
        for (int i = 0; i < input.length; i++) {
            JLabel label = new JLabel();
            if (input[i] == 0) {
                label.setText("-");
                label.setPreferredSize(labelDimension);
                label.setMinimumSize(labelDimension);
                label.setMaximumSize(labelDimension);
                panel.add(label);
            } else {
                label.setText("" + input[i]);
                label.setPreferredSize(labelDimension);
                label.setMinimumSize(labelDimension);
                label.setMaximumSize(labelDimension);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                if (firstWeek && input[i] > 7) {
                    label.setEnabled(false);
                }
                else if (lastWeek && input[i] < 20) {
                    label.setEnabled(false);
                }else{
                    DateTime forListener = inputDate.withDayOfMonth(input[i]);
                    CalendarMouseListener cml = new CalendarMouseListener(forListener, label);
                    label.addMouseListener(cml);
                }
                
                panel.add(label);
            }
            if (input[i] >= dayCount) {
                dayCount++;
            }
        }
        return panel;
    }

}
