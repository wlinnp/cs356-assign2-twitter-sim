package edu.cpp.cs356.assign2.View;

import javax.swing.JOptionPane;

/**
 * @author william
 */
public class Utils {
    /**
     * Display Message
     * @param title
     * @param msg 
     */
    protected static void showMsg(final String title, final String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
    }
}
