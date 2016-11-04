package edu.cpp.cs356.assign2.Data;

import edu.cpp.cs356.assign2.Data.Observer.Observer;
import edu.cpp.cs356.assign2.Data.Observer.Subject;
import edu.cpp.cs356.assign2.Data.Visitor.UserComponentVisitor;
import edu.cpp.cs356.assign2.Controller.TwitterController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.lang3.StringUtils;
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
        this.attach(this);
    }

    @Override
    public void add(final UserComponent newUser) {
        throw new UnsupportedOperationException("Cannot add user under user");
    }

    @Override
    public DefaultMutableTreeNode getEntireTree() {
        return new DefaultMutableTreeNode(this);
    }
    
    @Override
    public boolean hasUserComponent(final UserComponent user) {
        return (user instanceof User) && user.toString().equals(this.toString());
    }

    @Override
    public UserComponent findUserWithName(String user) {
        return user.equals(this.name) ? this : null;
    }
   
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
            if(StringUtils.isBlank(msg)) {
                msg = DEFAULT_MESSAGE;
            }
            msgBoard.add(new ImmutablePair(user.toString(), msg));
            TwitterController.getInstance().updateTweet(this, subject);
        }
    }
    
    public List<Pair<String, String>> getMessageBoard() {
        return msgBoard;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Subject Generic">
    private final Set<Observer> observers = new HashSet<>();
    
    @Override
    public final void attach(final Observer observer) {
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

    public List<String> getMessages() {
        return messages;
    }
    
    public void setMessage(final String msg) {
        messages.add(msg);
        notifyObservers();
    }
    
    public int getMessagesSize() {
        return messages.size();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Visitor">
    @Override
    public double accept(final UserComponentVisitor userComponentVisitor) {
        return userComponentVisitor.visit(this);
    }
    // </editor-fold>




    

    

    
    
    
}
