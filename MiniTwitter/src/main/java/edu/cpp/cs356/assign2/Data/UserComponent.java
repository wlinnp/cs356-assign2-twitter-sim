package edu.cpp.cs356.assign2.Data;

import edu.cpp.cs356.assign2.Data.Visitor.UserComponentVisitor;
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
    
    @Override
    public String toString() {
        return this.name;
    }

    public abstract void add(final UserComponent newUser);
    public abstract DefaultMutableTreeNode getEntireTree ();
    public abstract boolean hasUserComponent(final UserComponent user);
    public abstract UserComponent findUserWithName(final String user);
    public abstract double accept(final UserComponentVisitor userComponentVisitor);
}
