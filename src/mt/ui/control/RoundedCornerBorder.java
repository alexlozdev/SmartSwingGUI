/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.ui.control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author John
 */
public class RoundedCornerBorder extends AbstractBorder {
    
    Color borderColor = new Color(43,82,79);
    Insets borderInsets = new Insets(10, 15, 10, 15);
    private static final Color ALPHA_ZERO = new Color(0x0, true);
    @Override public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setBackground(ALPHA_ZERO);

        //g2.setPaint(c.getBackground());
        //g2.fillRoundRect(x, y, width-2, height-2, 8, 8);

        // border
        g2.setPaint(borderColor);
        g2.drawRoundRect(x, y, width-2, height-2, 8, 8);

        g2.dispose();
    }

    @Override public Insets getBorderInsets(Component c) {
    return borderInsets;
    }

    public void setBorderColor(Color color) {
      borderColor = color;
    }

    public void setBorderInsets(int top, int left, int bottom, int right) {
      borderInsets = new Insets(top, left, bottom, right);
    }
 
}
