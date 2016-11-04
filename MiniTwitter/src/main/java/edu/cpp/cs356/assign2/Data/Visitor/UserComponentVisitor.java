package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserGroup;

/**
 * @author wphyo
 */
public interface UserComponentVisitor {
    public double visit(final User user);
    public double visit(final UserGroup userGroup);
}
