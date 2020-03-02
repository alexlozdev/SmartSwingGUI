/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import mt.ui.panel.ContentDashPanel;
import mt.ui.panel.GamePanel;
import mt.ui.panel.MatchPanel;
import mt.ui.panel.TitlePanel;

/**
 *
 * @author John
 */
public class Def {
    public static final int DEF_FORM_SPLASH = 0;
    public static final int DEF_FORM_LOGIN = 1;
    public static final int DEF_FORM_MAIN = 2;
    public static final int DEF_FORM_DASH = 3;

    public static final int DEF_MENU_DASHBOARD = 0;
    public static final int DEF_MENU_TOURNAMENT_LIST = 1;
    public static final int DEF_MENU_MATCH_REPORT = 2;
    public static final int DEF_MENU_MYMATCHES = 3;

    public static final int DEF_CORNER_RADIUS = 20;

    public static final int DEF_WND_WIDTH = 1280;
    public static final int DEF_WND_HEIGHT = 1018;

    public static Rectangle RT_PANEL_MENU = new Rectangle(0,0, 208, DEF_WND_WIDTH);
    public static Rectangle RT_PANEL_CONTENT = new Rectangle(208,0, ContentDashPanel.DEF_PANEL_WIDTH, ContentDashPanel.DEF_PANEL_HEIGHT);
    public static Rectangle RT_DASH_TITLE = new Rectangle(52,104, TitlePanel.DEF_PANEL_WIDTH, TitlePanel.DEF_PANEL_HEIGHT);

    public static Rectangle RT_MATCH1 = new Rectangle(52, 375, MatchPanel.DEF_PANEL_WIDTH, MatchPanel.DEF_PANEL_HEIGHT);
    public static Rectangle RT_MATCH2 = new Rectangle(550, 375, MatchPanel.DEF_PANEL_WIDTH, MatchPanel.DEF_PANEL_HEIGHT);

    public static Rectangle RT_GAME_TOUR_LIST = new Rectangle(52, 670, 300, 50);

    public static Rectangle RT_GAME_ITEM1 = new Rectangle(52, 726, GamePanel.DEF_PANEL_WIDTH, GamePanel.DEF_PANEL_HEIGHT);
    public static Rectangle RT_GAME_ITEM2 = new Rectangle(550, 726, GamePanel.DEF_PANEL_WIDTH, GamePanel.DEF_PANEL_HEIGHT);
    public static Rectangle RT_GAME_ITEM3 = new Rectangle(52, 848, GamePanel.DEF_PANEL_WIDTH, GamePanel.DEF_PANEL_HEIGHT);
    public static Rectangle RT_GAME_ITEM4 = new Rectangle(550, 848, GamePanel.DEF_PANEL_WIDTH, GamePanel.DEF_PANEL_HEIGHT);

    /////////////////////////////////////////////////////////////////////////

    public static float rateW = 1.0f;
    public static float rateH = 1.0f;

    public static void setRate(int curW, int curH) {
        rateW = (float) curW / (float) Def.DEF_WND_WIDTH;
        rateH = (float) curH / (float) Def.DEF_WND_HEIGHT;
    }

    public static void setRate(float p_rateW, float p_rateH) {
        rateW = p_rateW;
        rateH = p_rateH;
    }
    
}
