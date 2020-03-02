package mt.ui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import mt.ui.Manager;
import mt.ui.control.JTextFieldHintUI;
import mt.ui.control.RoundedCornerBorder;
import mt.ui.control.RoundedJTextField;
import mt.util.ComUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author John
 */
public class LoginForm extends javax.swing.JFrame {
    private RoundedJTextField roundedJTextField;
    
    private final String HINT_EMAIL = "Email ID";
    private final String HINT_PASSWORD = "Password";

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
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

        jPanel1 = new javax.swing.JPanel();
        jTextFieldName = new javax.swing.JTextField();
        jPasswordFieldPasswd = new javax.swing.JPasswordField();
        jButtonOK = new javax.swing.JButton();
        jLabelEarth = new javax.swing.JLabel();
        jLabelMark = new javax.swing.JLabel();
        jLabelOR = new javax.swing.JLabel();
        jLabelSignup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(2, 14, 26));

        jTextFieldName.setBackground(new java.awt.Color(7, 31, 49));
        jTextFieldName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(72, 94, 50));
        jTextFieldName.setMargin(new java.awt.Insets(10, 15, 10, 2));

        jPasswordFieldPasswd.setBackground(new java.awt.Color(7, 31, 49));
        jPasswordFieldPasswd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPasswordFieldPasswd.setForeground(new java.awt.Color(72, 94, 50));

        jButtonOK.setBackground(new java.awt.Color(42, 80, 78));
        jButtonOK.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonOK.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOK.setText("Login");
        jButtonOK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jLabelEarth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ico_earth.jpg"))); // NOI18N

        jLabelMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ico_mark_events.jpg"))); // NOI18N

        jLabelOR.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelOR.setForeground(new java.awt.Color(204, 204, 204));
        jLabelOR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOR.setText("OR");

        jLabelSignup.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelSignup.setForeground(new java.awt.Color(255, 255, 51));
        jLabelSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSignup.setText("S I G N  U P");
        jLabelSignup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelEarth, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabelMark, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(492, 492, 492)
                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(jLabelOR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(jLabelSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEarth, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabelMark, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(jLabelOR)
                .addGap(23, 23, 23)
                .addComponent(jLabelSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1280)/2, (screenSize.height-800)/2, 1280, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // TODO add your handling code here:
        doLogin();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void doLogin(){

        String name = jTextFieldName.getText();
        char[] passwd = jPasswordFieldPasswd.getPassword();
        String password = String.valueOf(passwd);

        if (name.isEmpty() || name.equals(HINT_EMAIL)) {
            jTextFieldName.requestFocus();
            //Util.getInstance().messageBox("waring", "please input the id.", "");
            showMessageDialog(null, "Please input the id.");
            return;
        } else if (password.isEmpty() || password.equals(HINT_PASSWORD)) {
            jPasswordFieldPasswd.requestFocus();
            showMessageDialog(null, "Please input the password.");
            return;
        }

        //name = "jpacker1337@gmail.com";
        //password = "Chasingdr3ams.";
        Manager.getInstance().doLogin(name, password);       
        
    }    
    
    private void init() {        
        
        jTextFieldName.setOpaque(false);        
        jTextFieldName.setBorder(new RoundedCornerBorder()); 
        
        final Color colorName = jTextFieldName.getForeground();
        jTextFieldName.addFocusListener(new FocusAdapter() {
            @Override  
            public void focusGained(FocusEvent e) {  
                jTextFieldName.setForeground(colorName);                
              if (jTextFieldName.getText().equals(HINT_EMAIL)) {
                jTextFieldName.setText("");  
              } else {  
                jTextFieldName.setText(jTextFieldName.getText());  
              }  
            }  

            @Override  
            public void focusLost(FocusEvent e) {  
              if (jTextFieldName.getText().equals(HINT_EMAIL)|| jTextFieldName.getText().length()==0) {
                jTextFieldName.setText(HINT_EMAIL);
                //jTextFieldName.setForeground(Color.GRAY);  
              } else {
                jTextFieldName.setForeground(colorName);  
                jTextFieldName.setText(jTextFieldName.getText());  
              }  
            }           
        });        
        
        jPasswordFieldPasswd.setOpaque(false);
        jPasswordFieldPasswd.setBorder(new RoundedCornerBorder());
        final char passwdChar = jPasswordFieldPasswd.getEchoChar();
        
        jPasswordFieldPasswd.addFocusListener(new FocusAdapter() {
            
            @Override  
            public void focusGained(FocusEvent e) {  
                jPasswordFieldPasswd.setForeground(colorName);
                jPasswordFieldPasswd.setEchoChar(passwdChar);
                String passwd = String.valueOf(jPasswordFieldPasswd.getPassword());
                if (HINT_PASSWORD.equals(passwd)) {
                    jPasswordFieldPasswd.setText("");  
                } else {  
                    jPasswordFieldPasswd.setText(passwd);  
                }
            }

            @Override  
            public void focusLost(FocusEvent e) {  
                String passwd = String.valueOf(jPasswordFieldPasswd.getPassword());
                if (passwd.equals(HINT_PASSWORD)|| passwd.length()==0) {
                    jPasswordFieldPasswd.setEchoChar((char) 0);
                    jPasswordFieldPasswd.setText(HINT_PASSWORD);
                    //jPasswordFieldPasswd.setForeground(Color.GRAY);  
                } else {
                    jPasswordFieldPasswd.setEchoChar(passwdChar);
                    jPasswordFieldPasswd.setForeground(colorName);  
                    jPasswordFieldPasswd.setText(passwd);  
                }  
            }
            
        });
        
        //
        jPasswordFieldPasswd.setEchoChar((char) 0);
        jPasswordFieldPasswd.setText(HINT_PASSWORD);
        
        // focus
        addWindowListener(new WindowAdapter() {
            
            public void windowOpened(WindowEvent e) {
                jButtonOK.requestFocus();
                
                // earth imgEarth
                ImageIcon icoEarth = (ImageIcon)jLabelEarth.getIcon();
                Image imgEarth = icoEarth.getImage();
                Image imgEarth2 = imgEarth.getScaledInstance(jLabelEarth.getWidth(), jLabelEarth.getHeight(), Image.SCALE_SMOOTH);
                jLabelEarth.setIcon(new ImageIcon(imgEarth2));
                
                // mark
                ImageIcon icoMark = (ImageIcon)jLabelMark.getIcon();
                Image imgMark = icoMark.getImage();
                Image imgMark2 = imgMark.getScaledInstance(jLabelMark.getWidth(), jLabelMark.getHeight(), Image.SCALE_SMOOTH);
                jLabelMark.setIcon(new ImageIcon(imgMark2));
            }
            
        });
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabelEarth;
    private javax.swing.JLabel jLabelMark;
    private javax.swing.JLabel jLabelOR;
    private javax.swing.JLabel jLabelSignup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPasswd;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
