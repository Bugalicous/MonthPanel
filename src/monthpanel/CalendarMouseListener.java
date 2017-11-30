/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthpanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import org.joda.time.DateTime;

/**
 *
 * @author bug
 */
public class CalendarMouseListener implements MouseListener{
    
    private DateTime inputDate;
    private JLabel label;
    
    public CalendarMouseListener(DateTime inputDate, JLabel label){
        this.inputDate = inputDate;
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("MouseEvent: " + inputDate.toString());
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
