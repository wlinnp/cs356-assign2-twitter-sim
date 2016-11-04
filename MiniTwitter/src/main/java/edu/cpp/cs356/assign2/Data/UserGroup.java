package edu.cpp.cs356.assign2.Data;

import edu.cpp.cs356.assign2.Data.Visitor.UserComponentVisitor;
import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Composite class of Composite pattern
 * <p>
 * User Group which has user & user group children
 * @author william
 */
public class UserGroup extends UserComponent {
    private final Set<UserComponent> followers = new HashSet<>();

    public Set<UserComponent> getFollowers() {
        return followers;
    }
    
    public UserGroup(String name) {
        super(name);
    }

    @Override
    public void add(final UserComponent newUser) {
        followers.add(newUser);
    }
    
    @Override
    public DefaultMutableTreeNode getEntireTree () {
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode(this); 
        followers.stream().forEach((each) -> {
            treeRoot.add(each.getEntireTree());
        });
        return treeRoot;
    }
    
    @Override
    public boolean hasUserComponent(final UserComponent user) {
        if ((user instanceof UserGroup) && user.toString().equals(this.toString())) {
            return true;
        } else {
            return followers.stream().anyMatch((each) -> (each.hasUserComponent(user)));
        }
    }

    @Override
    public UserComponent findUserWithName(String user) {
        for (UserComponent each : followers) {
            UserComponent result = each.findUserWithName(user);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    @Override
    public double accept(final UserComponentVisitor userComponentVisitor) {
        return userComponentVisitor.visit(this);
    }
}
