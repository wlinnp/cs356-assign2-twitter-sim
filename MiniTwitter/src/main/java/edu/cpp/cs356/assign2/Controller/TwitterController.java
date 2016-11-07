package edu.cpp.cs356.assign2.Controller;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;

/**
 * Twitter Base Controller, 
 * <p>
 * This class is responsible for creating pre-existing groups. 
 * <p>
 * @author wphyo
 */
public abstract class TwitterController {
    private static final UserComponent ROOT = new UserGroup("root");
 
    /**
     * Check whether the object is an instance of User class
     * @param user selected node from tree
     * @return T/F
     */
    public boolean isUserType(final Object user) {
        return user != null && user instanceof User;
    }
        
    public UserComponent getRoot() {
        return ROOT;
    }
    
    /**
     * Check user with that name exists
     * @param user selected node from tree
     * @return T/F
     */
    public boolean hasUser(final String user) {
        return (null != getRoot().findUserWithName(user));
    }
}
