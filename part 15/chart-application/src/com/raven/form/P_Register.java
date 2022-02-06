package com.raven.form;

import com.raven.event.EventMessage;
import com.raven.event.PublicEvent;
import com.raven.model.Model_Message;
import com.raven.model.Model_Register;

public class P_Register extends javax.swing.JPanel {

    public P_Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdRegister = new javax.swing.JButton();
        cmdBackLogin = new javax.swing.JButton();
        txtRePassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("sansserif", 0, 30)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(87, 87, 87));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Register");

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        cmdRegister.setText("Register");
        cmdRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegisterActionPerformed(evt);
            }
        });

        cmdBackLogin.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(15, 128, 206));
        cmdBackLogin.setText("Back Login");
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackLoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Confirm Password");

        lbError.setFont(new java.awt.Font("sansserif", 0, 11)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 0, 0));
        lbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbError.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmdBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass)
                            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(txtRePassword)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitle)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBackLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbError)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackLoginActionPerformed
        PublicEvent.getInstance().getEventLogin().goLogin();
    }//GEN-LAST:event_cmdBackLoginActionPerformed

    private void cmdRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRegisterActionPerformed
        String userName = txtUser.getText().trim();
        String password = String.valueOf(txtPass.getPassword());
        String confirmPassword = String.valueOf(txtRePassword.getPassword());
        if (userName.equals("")) {
            txtUser.grabFocus();
        } else if (password.equals("")) {
            txtPass.grabFocus();
        } else if (!password.equals(confirmPassword)) {
            txtPass.grabFocus();
        } else {
            Model_Register data = new Model_Register(userName, password);
            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
                @Override
                public void callMessage(Model_Message message) {
                    if (!message.isAction()) {
                        lbError.setText(message.getMessage());
                    } else {
                        PublicEvent.getInstance().getEventMain().initChat();
                    }
                }
            });
        }
    }//GEN-LAST:event_cmdRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JButton cmdRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtRePassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
