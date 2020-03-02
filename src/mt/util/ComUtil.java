/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author John
 */
public class ComUtil {
    private static ComUtil mComUtil;
    public Dimension mDimension;    

    
    public static ComUtil getInstance() {
        if (mComUtil == null) {
            mComUtil = new ComUtil();
        }
        
        return mComUtil;
    }
    
    public Dimension getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }

    public static Rectangle getResize(Rectangle rectangle, float rateW, float rateH) {
        int x = (int) ((float) rectangle.x * rateW);
        int y = (int) ((float) rectangle.y * rateH);
        int width = (int) ((float) rectangle.width * rateW);
        int height = (int) ((float) rectangle.height * rateH);

        return new Rectangle(x, y, width, height);
    }

    public static Rectangle getResizeFixedPos(Rectangle rectangle, float rateW, float rateH) {
        int x = rectangle.x;//(int) ((float) rectangle.x * rateW);
        int y = rectangle.y;//(int) ((float) rectangle.y * rateH);
        int width = (int) ((float) rectangle.width * rateW);
        int height = (int) ((float) rectangle.height * rateH);

        return new Rectangle(x, y, width, height);
    }

    public static int getRatedNumber(int x, float rate) {
        int result = (int) ((float) x * rate);
        return result;
    }
    
}
