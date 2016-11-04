package edu.cpp.cs356.assign2.Data;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Component Base class for Composite Pattern
 * @author william
 */
public abstract class UserComponent {
    protected String name;
    

    public UserComponent(final String name) {
        this.name = name;
    }
    
    public abstract void addChild(final UserComponent newUser);

    public abstract DefaultMutableTreeNode createEntireTree ();
    public abstract boolean find(final UserComponent user);
    public abstract UserComponent findUserWithName(final String user);
    @Override
    public String toString() {
        return this.name;
    }
}
