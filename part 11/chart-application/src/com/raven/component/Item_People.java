package com.raven.component;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Item_People extends javax.swing.JPanel {

    public Item_People(String name) {
        initComponents();
        lb.setText(name);
        init();
    }

    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.raven.swing.ImageAvatar();
        lb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profile.png"))); // NOI18N

        lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
