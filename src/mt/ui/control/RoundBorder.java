package mt.ui.control;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder{

    private Color color;
    private BasicStroke stroke = null;
    private RenderingHints hints;

    private int arcWidth = 15;
    private int arcHeight = 15;

    /** Constructor*/
    public RoundBorder() {
        color = new Color(4,22,36);
        stroke = new BasicStroke(0);//grosor del borde
        hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    }

    public RoundBorder( Color color, int value, int arcR) {
        this.color = color;
        stroke = new BasicStroke(value);
        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        arcWidth = arcR;
        arcHeight = arcR;
    }

    @Override
    public void paintBorder(Component c,Graphics g,int x, int y, int width, int height) {

        Graphics2D g2 = (Graphics2D) g;
        RoundRectangle2D round2D = new RoundRectangle2D.Double();
        if( stroke.getLineWidth()==0 )
        {
            round2D.setRoundRect(x, y, width, height, arcWidth, arcHeight);
        }
        else
        {
            round2D.setRoundRect(x, y, width, height, arcWidth, arcHeight);
        }

        //Polygon pointer = new Polygon();
        Area area = new Area(round2D);
        //area.add(new Area(pointer));
        g2.setRenderingHints(hints);

        Component parent  = c.getParent();
        if (parent!=null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0,0,width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }

        if( stroke.getLineWidth()>0 )
        {
            g2.setColor(color);
            g2.setStroke(stroke);
        }

        g2.draw(area);
    }

}