package edu.cpp.cs356.assign2.Controller;

import edu.cpp.cs356.assign2.Data.Observer.Observer;
import edu.cpp.cs356.assign2.Data.Observer.Subject;
import edu.cpp.cs356.assign2.Data.Visitor.TotalMessagesVisitor;
import edu.cpp.cs356.assign2.Data.Visitor.TotalUserGroupVisitor;
import edu.cpp.cs356.assign2.Data.Visitor.TotalUserVisitor;
import edu.cpp.cs356.assign2.View.AdminView;
import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;
import edu.cpp.cs356.assign2.Data.Visitor.PositiveMessagePercentageVisitor;
import edu.cpp.cs356.assign2.View.UserView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Controller class
 * <p>
 * This class acts as a medium between Views and Datas
 * <p>
 * This class usually performs 3 steps. 
 * <p>
 * 1. Views (admin & user) calls methods here based on click events. 
 * 2. After validations, this class will update respective data. 
 * 3. Update Views based on updated data.
 * <p>
 * @author william
 */
public class TwitterController {
    private static TwitterController INSTANCE;
    private static List<UserView> openedUserViews;
    private static final UserComponent ROOT = new UserGroup("root");

    private TwitterController() {
        init();
        SwingUtilities.invokeLater(() -> {
            AdminView admin = AdminView.getInstance();
            admin.setTree(ROOT.getEntireTree());
            admin.setTitle(admin.toString());
            admin.setVisible(true);
        });
    }
    
    /**
     * Singleton class to ensure there is only one controller. 
     * @return 
     */
    public static TwitterController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TwitterController();
            openedUserViews = new ArrayList<>();
        }
        return INSTANCE;
    }
    
    /**
     * Create some existing users with root group as a base group
     */
    private void init() {
        UserComponent admin = new User("admin");
        UserComponent cs356 = new UserGroup("cs356");
        UserComponent william = new User("William");
        
        ROOT.add(admin);
        ROOT.add(cs356);
        cs356.add(william);
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
        } else if (userName instanceof UserGroup && userName.toString().equals(ROOT.toString()) 
                || ROOT.hasUserComponent(userName)) {
            return 3;
        }
        ((UserGroup) userGroup).add(userName);
        AdminView.getInstance().setTree(ROOT.getEntireTree());
        return 0;
    }
    
    /**
     * Check whether the object is an instance of User class
     * @param user selected node from tree
     * @return T/F
     */
    public boolean isUserType(final Object user) {
        return user != null && user instanceof User;
    }
    
    /**
     * Check user with that name exists
     * @param user selected node from tree
     * @return T/F
     */
    public boolean hasUser(final String user) {
        return (null != ROOT.findUserWithName(user));
    }
    
    /**
     * 
     * @param user 
     * @return 
     */
    public DefaultListModel getFollowings(final Object user) {
        DefaultListModel model = new DefaultListModel();
        ((User)user).getFollowers().forEach(each -> model.addElement(each));        
        return model;
    }

    private String tweetTransformer(final Pair<String, String> each) {
        return each.getLeft() + " tweeted -> \" " + each.getRight() + "\"";
    }
    
    /**
     * Load all messages posted by the user's following users to user's view
     * @param user
     * @return 
     */
    public DefaultListModel getMsgBoard(final Object user) {
        DefaultListModel model = new DefaultListModel();
        ((User)user).getMessageBoard().forEach(each -> model.addElement(tweetTransformer(each)));        
        return model;
    }
    
    /**
     * 1. Add idol to self's follower list 
     * 2. Add self to idol's observer list
     * 3. Update Follower's view
     * @param userView
     * @param self
     * @param idol 
     */
    public void followUser(final UserView userView, final Object self, final String idol) {
        ((User)self).addFollower(ROOT.findUserWithName(idol));
        ((Subject)ROOT.findUserWithName(idol)).attach((Observer)self);
        userView.updateFollowingPane(getFollowings(self));
    }
    
    public void processTweet(final Object user, final String tweet) {
        ((User)user).setMessage(tweet);
    }
    
    /**
     * Find correct User View and update message board
     * @param observer 
     * @param subject
     */
    public void updateTweet(final Object observer, final Object subject) {
        openedUserViews.stream().forEach((each) -> {
            if (correctUserView(each, observer, subject)) {
                each.updateMessagesPane(getMsgBoard(observer));
            }
        });
    }
    
    /**
     * 
     * @param each each of opened User Views
     * @param observer
     * @param subject
     * @return opened User View belongs to observer or subject
     */
    private boolean correctUserView (final UserView each, final Object observer, final Object subject) {
        System.out.println(each.toString() + " " + observer.toString() + " " + subject.toString());
        return each.toString().equals(observer.toString()) || each.toString().equals(subject.toString());
    }
    
    public void addUserView(final UserView userView) {
        openedUserViews.add(userView);
    }
    
    public void removeUserView(final UserView userView) {
        openedUserViews.remove(userView);
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
