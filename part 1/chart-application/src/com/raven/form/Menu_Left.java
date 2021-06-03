package com.raven.form;

import com.raven.component.Item_People;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends javax.swing.JPanel {

    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        menuList.setLayout(new MigLayout("fillx", "0[]0", "1[]1"));
        showPeople();
    }

    private void showPeople() {
        //  test data
        for (int i = 0; i < 8; i++) {
            menuList.add(new Item_People("People " + i), "wrap");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuButton1 = new com.raven.component.MenuButton();
        menuButton2 = new com.raven.component.MenuButton();
        menuButton3 = new com.raven.component.MenuButton();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(242, 242, 242));

        menu.setBackground(new java.awt.Color(229, 229, 229));
        menu.setOpaque(true);
        menu.setLayout(new javax.swing.BoxLayout(menu, javax.swing.BoxLayout.LINE_AXIS));

        menuButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/message_selected.png"))); // NOI18N
        menu.add(menuButton1);

        menuButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/group.png"))); // NOI18N
        menu.add(menuButton2);

        menuButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/box.png"))); // NOI18N
        menu.add(menuButton3);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuList)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuList)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private com.raven.component.MenuButton menuButton1;
    private com.raven.component.MenuButton menuButton2;
    private com.raven.component.MenuButton menuButton3;
    private javax.swing.JLayeredPane menuList;
    // End of variables declaration//GEN-END:variables
}
