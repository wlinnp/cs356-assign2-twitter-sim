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
    
    public abstract void addChild(final UserComponent newUser);
    public abstract DefaultMutableTreeNode createEntireTree ();

    /**
     * Checks whether the user exists in the tree
     * @param user
     * @return
     */
    public abstract boolean hasUserComponent(final UserComponent user);
    public abstract UserComponent findUserWithName(final String user);
    @Override
    public String toString() {
        return this.name;
    }
    
    public abstract double accept(final UserComponentVisitor userComponentVisitor);
}
