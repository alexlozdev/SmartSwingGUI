/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.ui.panel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import mt.listener.OnMenuItemListener;
import mt.ui.form.DashForm;

/**
 *
 * @author John
 */
public class MenuPanel extends javax.swing.JPanel {
    public MenuItemPanel[] itemMenuPanel;
    final int itemCnt = 5;
    //public MenuItemPanel itemTournaments;
    //public MenuItemPanel itemMatchReport;
    //public MenuItemPanel itemMyMatchs;
    //public MenuItemPanel itemMyProfile;
    private OnMenuItemListener mOnMenuItemListener;

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
        //initComponents();
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

        jLabelMark = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ico_mark_main.jpg"))); // NOI18N
        jLabelMark.setText("jLabelMark");
        add(jLabelMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        setBackground(new Color(7,31,49));
        
        // mark
        jLabelMark = new javax.swing.JLabel();
        jLabelMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ico_mark_main.jpg"))); // NOI18N
        
        itemMenuPanel = new MenuItemPanel[itemCnt];
        for (int i = 0; i < itemCnt; i++) {
            itemMenuPanel[i] = new MenuItemPanel();
        }
        //itemDashboard = new MenuItemPanel();
        //itemTournaments = new MenuItemPanel();
        //itemMatchReport = new MenuItemPanel();
        //itemMyMatchs = new MenuItemPanel();
        //itemMyProfile = new MenuItemPanel();
        
    }
    
    public void setPanelSize(int w, int h) {
        
        // mark image
        ImageIcon icoMark = (ImageIcon)jLabelMark.getIcon();
        Image imgMark = icoMark.getImage();
        
        float rate = (float) imgMark.getHeight(this) / (float) imgMark.getWidth(this);
        int updateH = (int)(rate * w);
                 
        Image imgMark2 = imgMark.getScaledInstance(w, updateH, Image.SCALE_SMOOTH);
        jLabelMark.setBounds(0, 0, w, updateH);
        jLabelMark.setIcon(new ImageIcon(imgMark2));
        
        // items
        int itemH = 45;
        int itemLeft = 0;
        int itemW = w;
        int itemTop = updateH;
        int itemIterval = itemH / 2;
        
        itemMenuPanel[0].setPanelSize(w, itemH);
        itemMenuPanel[0].setBounds(itemLeft, itemTop, itemW, itemH);
        itemMenuPanel[0].setContent("Dashboard");
        ImageIcon img1 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Speedometer.png"));
        ImageIcon img2 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Speedometer_sel.png"));
        itemMenuPanel[0].setIcon(img1.getImage(), img2.getImage());
        ImageIcon imgBg = new javax.swing.ImageIcon(getClass().getResource("/resources/ico_menuItemSel.png"));
        itemMenuPanel[0].setBackgroundImage(imgBg.getImage());
        
        // Tournament List
        itemTop = itemTop + itemH + itemIterval;
        itemMenuPanel[1].setPanelSize(w, itemH);
        itemMenuPanel[1].setBounds(itemLeft, itemTop, itemW, itemH);
        itemMenuPanel[1].setContent("Tournament List");
        img1 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_List_View.png"));
        img2 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_List_View_sel.png"));
        itemMenuPanel[1].setIcon(img1.getImage(), img2.getImage());
        imgBg = new javax.swing.ImageIcon(getClass().getResource("/resources/ico_menuItemSel.png"));
        itemMenuPanel[1].setBackgroundImage(imgBg.getImage());
        
        // Match Report
        itemTop = itemTop + itemH + itemIterval;
        itemMenuPanel[2].setPanelSize(w, itemH);
        itemMenuPanel[2].setBounds(itemLeft, itemTop, itemW, itemH);
        itemMenuPanel[2].setContent("Match Report");
        img1 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Pie_Chart_Report.png"));
        img2 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Pie_Chart_Report_sel.png"));
        itemMenuPanel[2].setIcon(img1.getImage(), img2.getImage());
        imgBg = new javax.swing.ImageIcon(getClass().getResource("/resources/ico_menuItemSel.png"));
        itemMenuPanel[2].setBackgroundImage(imgBg.getImage());
        
        // My Matches
        itemTop = itemTop + itemH + itemIterval;
        itemMenuPanel[3].setPanelSize(w, itemH);
        itemMenuPanel[3].setBounds(itemLeft, itemTop, itemW, itemH);
        itemMenuPanel[3].setContent("My Matches");
        img1 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Game_Controller.png"));
        img2 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Game_Controller_sel.png"));
        itemMenuPanel[3].setIcon(img1.getImage(), img2.getImage());
        imgBg = new javax.swing.ImageIcon(getClass().getResource("/resources/ico_menuItemSel.png"));
        itemMenuPanel[3].setBackgroundImage(imgBg.getImage());
        
        // My profile
        itemTop = itemTop + itemH + itemIterval;
        itemMenuPanel[4].setPanelSize(w, itemH);
        itemMenuPanel[4].setBounds(itemLeft, itemTop, itemW, itemH);
        itemMenuPanel[4].setContent("My Profile");
        img1 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Male_User.png"));
        img2 = new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Male_User_sel.png"));
        itemMenuPanel[4].setIcon(img1.getImage(), img2.getImage());
        imgBg = new javax.swing.ImageIcon(getClass().getResource("/resources/ico_menuItemSel.png"));
        itemMenuPanel[4].setBackgroundImage(imgBg.getImage());        
       
        // mouse listener
        for (int i = 0; i < itemCnt; i++) {
            final int index = i;
            itemMenuPanel[index].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    selectMenuItem(index);
                    if (mOnMenuItemListener != null)
                        mOnMenuItemListener.OnMenuItemSelected(index);
                }
            });
            
        }
        
        add(jLabelMark);
        
        for (int i = 0; i < itemCnt; i++) {
            add(itemMenuPanel[i]);       
        }
        
        setLayout(null);
        setVisible(true);        
    }
    
    public void selectMenuItem(int index) {
        for (int i = 0; i < itemCnt; i++) {
            if (i == index) {
                itemMenuPanel[i].selectItem(true);                
            } else {
                itemMenuPanel[i].selectItem(false);                
            }
        }  
        
        //repaint();
        
    }

    public void setOnMenuItemListener(OnMenuItemListener onMenuItemListener) {
        mOnMenuItemListener = onMenuItemListener;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMark;
    // End of variables declaration//GEN-END:variables
}
