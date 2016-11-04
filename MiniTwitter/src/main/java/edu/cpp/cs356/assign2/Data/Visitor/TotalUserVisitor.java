/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;
import edu.cpp.cs356.assign2.Data.Visitor.UserComponentVisitor;

/**
 *
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
