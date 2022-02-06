package com.raven.component;

import com.raven.emoji.Emogi;
import com.raven.emoji.Model_Emoji;
import com.raven.main.Main;
import com.raven.swing.ScrollBar;
import com.raven.swing.WrapLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Panel_More extends javax.swing.JPanel {

    public Panel_More() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        add(panelHeader, "w 100%, h 30!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));    //  use warp layout
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
        //  test color
        add(ch, "w 100%, h 100%");
    }

    private JButton getButtonFile() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/link.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser ch = new JFileChooser();
                ch.showOpenDialog(Main.getFrames()[0]);
                //  Update next
            }
        });
        return cmd;
    }

    private JButton getEmojiStyle1() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emogi.getInstance().getImoji(1).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emogi.getInstance().getStyle1()) {
                    JButton c = new JButton(d.getIcon());
                    c.setName(d.getId() + "");
                    c.setBorder(new EmptyBorder(3, 3, 3, 3));
                    c.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    c.setContentAreaFilled(false);
                    panelDetail.add(c);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getEmojiStyle2() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emogi.getInstance().getImoji(21).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emogi.getInstance().getStyle2()) {
                    JButton c = new JButton(d.getIcon());
                    c.setName(d.getId() + "");
                    c.setBorder(new EmptyBorder(3, 3, 3, 3));
                    c.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    c.setContentAreaFilled(false);
                    panelDetail.add(c);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearSelected() {
        for (Component c : panelHeader.getComponents()) {
            if (c instanceof OptionButton) {
                ((OptionButton) c).setSelected(false);
            }
        }
    }
    private JPanel panelHeader;
    private JPanel panelDetail;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
