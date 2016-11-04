package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;

/**
 * @author william
 */
public class TotalMessagesVisitor implements UserComponentVisitor {

    @Override
    public double visit(User user) {
        return user.getMessagesSize();
    }

    @Override
    public double visit(UserGroup userGroup) {
        double total = 0;
        for (UserComponent each : userGroup.getFollowers()) {
            if (each instanceof User) {
                total += ((User)each).getMessagesSize();
            } else {
                total += visit((UserGroup)each);
            }
        }
        return total;
    }
    
}
