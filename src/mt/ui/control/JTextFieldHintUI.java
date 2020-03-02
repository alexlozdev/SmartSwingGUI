/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.ui.control;

/**
 *
 * @author John
 */
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;  
import java.awt.event.FocusListener;  
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTextFieldUI;  
import javax.swing.text.JTextComponent;

public class JTextFieldHintUI extends JTextField {  
    public JTextFieldHintUI(final String hint) {  
   
     setText(hint);  
     //setFont(lostFont);  
     setForeground(Color.GRAY);  
   
     this.addFocusListener(new FocusAdapter() {  
   
       @Override  
       public void focusGained(FocusEvent e) {  
         if (getText().equals(hint)) {  
           setText("");  
           //setFont(gainFont);  
         } else {  
           setText(getText());  
           //setFont(gainFont);  
         }  
       }  
   
       @Override  
       public void focusLost(FocusEvent e) {  
         if (getText().equals(hint)|| getText().length()==0) {  
           setText(hint);  
           //setFont(lostFont);  
           setForeground(Color.GRAY);  
         } else {  
           setText(getText());  
           //setFont(gainFont);  
           setForeground(Color.BLACK);  
         }  
       }  
     });  
   
   }  
}
