package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;

/**
 * @author william
 */
public class TotalUserVisitor implements UserComponentVisitor {

    @Override
    public double visit(User user) {
        return 1;
    }

    @Override
    public double visit(UserGroup userGroup) {
        double total = 0; 
        for (UserComponent each : userGroup.getFollowers()) {
            total += (each instanceof User) ? 1 : visit((UserGroup)each);
        }
        return total;
    }


}
