/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserGroup;

/**
 *
 * @author wphyo
 */
public interface UserComponentVisitor {
    public double visit(final User user);
    public double visit(final UserGroup userGroup);

    
}
