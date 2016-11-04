package edu.cpp.cs356.assign2.Data;

import edu.cpp.cs356.assign2.Controller.TwitterController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Leaf class of Composite Pattern 
 * 
 * @author william
 */
public class User extends UserComponent implements Subject, Observer{
    private final Set<UserComponent> followers = new HashSet<>();
    // <editor-fold defaultstate="collapsed" desc="User">
    public User(final String name) {
        super(name);
    }

    @Override
    public void addChild(final UserComponent newUser) {
        throw new UnsupportedOperationException("Cannot add user under user");
    }

    @Override
    public DefaultMutableTreeNode createEntireTree() {
        return new DefaultMutableTreeNode(this);
    }
    
    @Override
    public boolean find(final UserComponent user) {
        return (user instanceof User) && user.toString().equals(this.toString());
    }

    /**
     *
     * @param user
     * @return if name is the same, return user
     */
    @Override
    public UserComponent findUserWithName(String user) {
        return user.equals(this.name) ? this : null;
    }
    // for visitor, should have one method call accept
    // visitor have 2, user & group. 
    
    public String getLastMsg() {
        if (messages.isEmpty()) {
            return null;
        } else {
            return messages.get(messages.size() - 1);
        }
    }
    
    public void addFollower(final UserComponent idol) {
        followers.add((User)idol);
    }
    
    public Set<UserComponent> getFollowers() {
        return followers;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Observer">
    private final List<Pair<String, String>> msgBoard = new ArrayList<>();
    private static final String DEFAULT_MESSAGE = " says HI!";
    @Override
    public void update(Subject subject) {
        if (subject instanceof User) {
            User user = (User)subject;
            String msg = user.getLastMsg();
            if(msg == null) {
                msg = DEFAULT_MESSAGE;
            }
            msgBoard.add(new ImmutablePair(user.toString(), msg));
            System.out.println("Iam " + this.toString() + ". and my idol " + user.toString() + " posted this: " + msg);
            TwitterController.getInstance().updateTweet(this);
        }
    }
    public List<Pair<String, String>> getMessageBoard() {
        return msgBoard;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Subject Generic">
    private final Set<Observer> observers = new HashSet<>();
    @Override
    public void attach(final Observer observer) {
        observers.add(observer);
    }
    @Override
    public void detach(final Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        observers.stream().forEach((each) -> each.update (this));
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Subject Concrete">
    private final List<String> messages = new ArrayList<>();
    public void setMessage(final String msg) {
        messages.add(msg);
        notifyObservers();
    }
    // </editor-fold>


    

    

    
    
    
}
