/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.ui.control;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;

/**
 *
 * @author John
 */
public class RoundedJTextField extends JTextField{
    private Shape shape;
    private int arcX = 5;
    private int arcY = 5;    
    
    public RoundedJTextField(int size) {
       super(size);
       setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
       g.setColor(getBackground());
       g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcX, arcY);
       super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
       g.setColor(getForeground());
       g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
       if (shape == null || !shape.getBounds().equals(getBounds())) {
          shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
       }
       return shape.contains(x, y);
    }
    
    public void setRoundSize(int arcX, int arcY) {
        this.arcX = arcX;
        this.arcY = arcY;
    }
}
