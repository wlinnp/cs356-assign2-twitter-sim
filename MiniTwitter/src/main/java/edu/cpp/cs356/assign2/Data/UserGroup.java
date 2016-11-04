package edu.cpp.cs356.assign2.Data;

import edu.cpp.cs356.assign2.Data.Visitor.UserComponentVisitor;
import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
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

    /**
     *
     * @param newUser
     */
    @Override
    public void addChild(final UserComponent newUser) {
        followers.add(newUser);
    }
    
    @Override
    public DefaultMutableTreeNode createEntireTree () {
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode(this); 
        followers.stream().forEach((each) -> {
            treeRoot.add(each.createEntireTree());
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
