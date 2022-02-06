package com.raven.swing;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
}
