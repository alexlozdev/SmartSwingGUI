/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.ui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import mt.ui.control.CircleBorder;
import mt.ui.control.RoundedCornerBorder;
import mt.ui.control.RoundedPanel;
import mt.util.ComUtil;
import mt.util.Def;

/**
 *
 * @author John
 */
public class MatchPanel extends JPanel {

    //RoundedCornerBorder roundedCornerBorder = new RoundedCornerBorder();
    public static final int DEF_PANEL_WIDTH = 460;
    public static final int DEF_PANEL_HEIGHT = 240;
    private Rectangle rtContent = new Rectangle(24,52, 196,64);
    
    private int cornerRadius = 20;
    /**
     * Creates new form MatchPanel
     */
    public MatchPanel() {
        initComponents();
        jScrollPane1.setBorder(null);
    }

    public MatchPanel(String title, String content, String strButton, Image imgIcon, boolean bLive) {
        initComponents();
        jScrollPane1.setBorder(null);

        setTitle(title);
        setContent(content);
        setButton(strButton);
        setImageIcon(imgIcon);
        setLive(bLive);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabelButton = new javax.swing.JLabel();
        jLabelLive = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(4, 22, 36));
        setBorder(null);
        setLayout(null);

        jLabelTitle.setFont(new java.awt.Font("Dialog", 0, 16));
        jLabelTitle.setForeground(new java.awt.Color(155, 155, 155));
        jLabelTitle.setText("Your match");
        add(jLabelTitle);
        jLabelTitle.setBounds(30, 20, 210, 30);

        jLabelButton.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabelButton.setForeground(new java.awt.Color(170, 191, 53));
        jLabelButton.setText("Start");
        jLabelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jLabelButton);
        jLabelButton.setBounds(30, 180, 80, 30);

        jLabelLive.setBackground(new java.awt.Color(255, 53, 78));
        jLabelLive.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabelLive.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLive.setText("LIVE");
        jLabelLive.setOpaque(true);
        add(jLabelLive);
        jLabelLive.setBounds(320, 182, 50, 20);

        jLabelImage.setBackground(new java.awt.Color(4, 22, 36));
        jLabelImage.setForeground(new java.awt.Color(4, 22, 36));
        jLabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ico_match_sample.jpg"))); // NOI18N
        jLabelImage.setBorder(new CircleBorder());
        jLabelImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelImage.setIconTextGap(0);
        add(jLabelImage);
        jLabelImage.setBounds(260, 30, 170, 170);

        jTextAreaContent.setBackground(new java.awt.Color(4, 22, 36));
        jTextAreaContent.setColumns(8);
        jTextAreaContent.setEditable(false);
        jTextAreaContent.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jTextAreaContent.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaContent.setLineWrap(true);
        jTextAreaContent.setRows(3);
        jTextAreaContent.setText("Check and report scores");
        jTextAreaContent.setWrapStyleWord(true);
        jTextAreaContent.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaContent);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 210, 100);
    }// </editor-fold>//GEN-END:initComponents

    public void setPanelSize() {
        ImageIcon imgIcon = (ImageIcon)jLabelImage.getIcon();
        Image image = imgIcon.getImage();
        Image image2 = image.getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
        jLabelImage.setIcon(new ImageIcon(image2));        
    }

    public void refreshSize(Rectangle rtArea) {

        float rateW = Def.rateW;
        float rateH = Def.rateH;
        
        rtArea = ComUtil.getResize(rtArea, rateW, rateH);
        setBounds(rtArea);        

        Rectangle rtTitle = jLabelTitle.getBounds();
        Rectangle contentRect = rtContent;//jTextAreaContent.getBounds();
        Rectangle rtButton = jLabelButton.getBounds();
        Rectangle rtImage = jLabelImage.getBounds();
        Rectangle rtLive = jLabelLive.getBounds();

        rtTitle = ComUtil.getResize(rtTitle, rateW, rateH);
        contentRect = ComUtil.getResize(contentRect, rateW, rateH);
        rtButton = ComUtil.getResize(rtButton, rateW, rateH);
        rtImage = ComUtil.getResize(rtImage, rateW, rateH);
        rtLive = ComUtil.getResize(rtLive, rateW, rateH);

        jLabelTitle.setBounds(rtTitle);
        
        jTextAreaContent.setBounds(contentRect);

        jLabelButton.setBounds(rtButton);
        jLabelImage.setBounds(rtImage);
        jLabelLive.setBounds(rtLive);

        // image resize
        ImageIcon imgIcon = (ImageIcon)jLabelImage.getIcon();
        Image image = imgIcon.getImage();
        Image image2 = image.getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
        jLabelImage.setIcon(new ImageIcon(image2));

    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//
    }

    public void setTitle(String title) {
        jLabelTitle.setText(title);
    }

    public void setContent(String content) {
        jTextAreaContent.setText(content);
    }

    public void setButton(String strButton) {
        jLabelButton.setText(strButton);
    }

    public void setImageIcon(Image image) {
        jLabelImage.setIcon(new ImageIcon(image));
    }

    public void setLive(boolean bLive) {
        jLabelLive.setVisible(bLive);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelButton;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelLive;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaContent;
    // End of variables declaration//GEN-END:variables
}