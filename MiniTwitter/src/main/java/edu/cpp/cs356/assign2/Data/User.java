package edu.cpp.cs356.assign2.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Leaf class of Composite Pattern 
 * 
 * @author william
 */
public class User extends UserComponent implements Subject, Observer{
    private final Set<Observer> followings = new HashSet<>();
    private final List<String> messages = new ArrayList<>();
    private final Set<Observer> observers = new HashSet<>();
    
    public User(final String name) {
        super(name);
    }

    @Override
    public void add(final UserComponent newUser) {
        throw new UnsupportedOperationException("Cannot add user under user");
    }
    @Override
    public void get() {
        System.out.println(name);
    }

    @Override
    public DefaultMutableTreeNode createEntireTree() {
        return new DefaultMutableTreeNode(this);
    }
    
    @Override
    public boolean find(final UserComponent user) {
        return (user instanceof User) && user.toString().equals(this.toString());
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach((each) -> each.update (this));
    }

    @Override
    public void update(Subject subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserComponent findUserWithName(String user) {
        return user.equals(this.name) ? this : null;
    }
    
    public Set<Observer> getObservers() {
        return observers;
    }
}
