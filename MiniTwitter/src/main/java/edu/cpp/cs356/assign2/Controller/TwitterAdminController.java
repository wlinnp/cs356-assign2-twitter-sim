package edu.cpp.cs356.assign2.Controller;

import edu.cpp.cs356.assign2.Data.Visitor.TotalMessagesVisitor;
import edu.cpp.cs356.assign2.Data.Visitor.TotalUserGroupVisitor;
import edu.cpp.cs356.assign2.Data.Visitor.TotalUserVisitor;
import edu.cpp.cs356.assign2.Data.Visitor.PositiveMessagePercentageVisitor;
import edu.cpp.cs356.assign2.View.AdminView;
import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;
import javax.swing.SwingUtilities;

/**
 * Controller class
 * <p>
 * This class acts as a medium between Views and Data
 * <p>
 * This class usually performs 3 steps. 
 * <p>
 * 1. Admin View calls methods here based on click events. 
 * 2. After validations, this class will update respective data. 
 * 3. Update Views based on updated data.
 * <p>
 * @author william
 */
public class TwitterAdminController extends TwitterController {
    private static TwitterAdminController INSTANCE;

            
    /**
     * Create some existing users with root group as a base group
     */
    private void init() {
        UserComponent admin = new User("admin");
        UserComponent cs356 = new UserGroup("cs356");
        UserComponent william = new User("William");
        
        cs356.add(william);

        getRoot().add(admin);
        getRoot().add(cs356);
    }

    
    private TwitterAdminController() {
        init();
        SwingUtilities.invokeLater(() -> {
            AdminView admin = AdminView.getInstance();
            admin.setTree(getRoot().getEntireTree());
            admin.setTitle(admin.toString());
            admin.setVisible(true);
        });
    }
    
    /**
     * Singleton class to ensure there is only one controller. 
     * @return 
     */
    public static TwitterAdminController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TwitterAdminController();
            
        }
        return INSTANCE;
    }
    
    /**
     * @param userGroup object of the parent group where the new user is added. 
     * @param userName  name of the new user
     * @return status of result.
     */
    public int addUser(final Object userGroup, final String userName) {
        return add(userGroup, new User(userName));
    }
    
    /**
     * 
     * @param userGroup object of the group where the new user is added. 
     * @param userName  name of the new user group
     * @return status of result.
     */
    public int addUserGroup(final Object userGroup, final String userName) {
        return add(userGroup, new UserGroup(userName));
    }
    
    /**
     * Adding new user / user group to the tree
     * <p>
     * 1. Validations
     * 2. add new user / user group
     * 3. at the end, update tree view 
     * @param userGroup
     * @param userName abstract type
     * @return status of result
     * <p>
     * Details
     * 1 = empty user group 
     * 2 = user group is not valid type
     * 3 = user already exists
     * 0 = success; 
     */
    private int add(final Object userGroup, final UserComponent userName) {
        if (userGroup == null) {
            return 1;
        } else if (!(userGroup instanceof UserGroup)) {
            return 2;
        } else if (userName instanceof UserGroup && userName.toString().equals(getRoot().toString()) 
                || getRoot().hasUserComponent(userName)) {
            return 3;
        }
        ((UserGroup) userGroup).add(userName);
        AdminView.getInstance().setTree(getRoot().getEntireTree());
        return 0;
    }
    
    public String getTotalUser(final Object user) {
        return Double.toString(((UserComponent)user).accept(new TotalUserVisitor()));
    }
    
    public String getTotalUserGroup(final Object user) {
        return Double.toString(((UserComponent)user).accept(new TotalUserGroupVisitor()));
    }
    
    public String getTotalMessages(final Object user) {
        return Double.toString(((UserComponent)user).accept(new TotalMessagesVisitor()));
    }
    
    public String getPositiveMessagePercentage(final Object user) {
        return Double.toString(((UserComponent)user).accept(new PositiveMessagePercentageVisitor()));
    }
}
