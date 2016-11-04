package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;

/**
 * @author william
 */
public class TotalUserGroupVisitor implements UserComponentVisitor {

    @Override
    public double visit(User user) {
        return 0;
    }

    @Override
    public double visit(UserGroup userGroup) {
        double total = 1;
        for (UserComponent each : userGroup.getFollowers()) {
            if (each instanceof UserGroup) {
                total += visit((UserGroup)each);
            }
        }
        return total;
    }
    
}
