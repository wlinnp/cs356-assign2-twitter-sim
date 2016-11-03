/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs356.assign2.Data;

/**
 *
 * @author wphyo
 */
public interface TwitterElementVisitor {
    public void visitTotalUser(final UserComponent root);
    public void visitTotalUserGroup(final UserComponent root);
    public void visitTotalMessages(final UserComponent root);
    public void visitPercentagePositiveMessage(final UserComponent root);
    
}
