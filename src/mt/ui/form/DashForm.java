/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.ui.form;

import java.awt.Color;
import java.awt.MenuItem;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mt.listener.OnMenuItemListener;
import mt.ui.panel.ContentDashPanel;
import mt.ui.panel.ContentMyMatchPanel;
import mt.ui.panel.ContentReportPanel;
import mt.ui.panel.ContentTourPanel;
import mt.ui.panel.GamePanel;
import mt.ui.panel.MatchPanel;
import mt.ui.panel.MenuPanel;
import mt.ui.panel.TitlePanel;
import mt.ui.panel.TournamentPanel;
import mt.util.ComUtil;
import mt.util.Def;

/**
 *
 * @author John
 */
public class DashForm extends javax.swing.JFrame 
        implements OnMenuItemListener
{
    public static final int DEF_PANEL_WIDTH = 1280;
    public static final int DEF_PANEL_HEIGHT = 1018;


    public MenuPanel menuPanel;    
    public ContentDashPanel dashPanel;
    public ContentTourPanel tourPanel;
    public ContentReportPanel reportPanel;
    public ContentMyMatchPanel myMatchPanel;
    
    /**
     * Creates new form DashForm
     */
    public DashForm() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 984, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1272)/2, (screenSize.height-984)/2, 1272, 984);
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        int w = ComUtil.getRatedNumber(DEF_PANEL_WIDTH , Def.rateW);
        int h = ComUtil.getRatedNumber(DEF_PANEL_HEIGHT , Def.rateH);

        setSize(w, h);
        
        menuPanel = new MenuPanel();
        menuPanel.setBounds(Def.RT_PANEL_MENU);
        menuPanel.setPanelSize(Def.RT_PANEL_MENU.width, Def.RT_PANEL_MENU.height);        
        menuPanel.setOnMenuItemListener(this);
        menuPanel.selectMenuItem(Def.DEF_MENU_DASHBOARD);
        add(menuPanel);

        // Dashboard
        dashPanel = new ContentDashPanel();        
        add(dashPanel);

        // tournament list
        tourPanel = new ContentTourPanel();
        add(tourPanel);
        tourPanel.setVisible(false);

        // Match Report
        reportPanel = new ContentReportPanel();
        add(reportPanel);
        reportPanel.setVisible(false);

        // My Matches
        myMatchPanel = new ContentMyMatchPanel();
        add(myMatchPanel);
        myMatchPanel.setVisible(false);

        //tournamentPanel = new TournamentPanel();
        //tournamentPanel.setBounds(52, 652, 955, 366);
        //tournamentPanel.setPanelSize(955, 366);
        //tournamentPanel.testSample();
        //contentPanel.add(tournamentPanel);
        
        
        
        setLayout(null);
        setVisible(true);
        
    }    

    public void OnMenuItemSelected(int index) {
        boolean bDashboard = false;
        boolean bMyMatch = false;
        boolean bTour = false;
        boolean bReport = false;

        switch (index) {
            case Def.DEF_MENU_DASHBOARD:
                bDashboard = true;
                break;

            case Def.DEF_MENU_TOURNAMENT_LIST:
                bTour = true;
                break;

            case Def.DEF_MENU_MYMATCHES:
                bMyMatch = true;
                break;

            case Def.DEF_MENU_MATCH_REPORT:
                bReport = true;
                break;
        }

        dashPanel.setVisible(bDashboard);
        tourPanel.setVisible(bTour);
        reportPanel.setVisible(bReport);
        myMatchPanel.setVisible(bMyMatch);
        repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
