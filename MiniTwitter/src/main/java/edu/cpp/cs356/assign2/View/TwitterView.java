/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs356.assign2.View;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author william
 */
public class TwitterView extends JFrame {
    private final Object user;
    
    public TwitterView(final Object user) {
        this.user = user;
    }
    
    protected Object getUser() {
        return user;
    }
    @Override
    public String toString() {
        return user.toString();
    }
    
    protected void displayMessage(final String title, final String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
    }
}
