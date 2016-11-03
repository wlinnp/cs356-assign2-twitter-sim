package edu.cpp.cs356.assign2.Controller;

import edu.cpp.cs356.assign2.Data.Observer;
import edu.cpp.cs356.assign2.Data.Subject;
import edu.cpp.cs356.assign2.View.AdminView;
import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;
import edu.cpp.cs356.assign2.View.UserView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author william
 */
public class TwitterController {
    private static TwitterController INSTANCE;
    private static List<UserView> openedUserViews;
    
    /**
     * Singleton class 
     * @return 
     */
    public static TwitterController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TwitterController();
            openedUserViews = new ArrayList<>();
        }
        return INSTANCE;
    }
    
    private static final UserComponent ROOT = new UserGroup("root");
    /**
     * Adding pre-existing user
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
     * Constructor
     */
    private TwitterController() {
        init();
        SwingUtilities.invokeLater(() -> {
            AdminView.getInstance().setTree(ROOT.createEntireTree());
            AdminView.getInstance().setVisible(true);
        });
    }
    /**
     * @param userGroup name of the group where the new user is added. 
     * @param userName  name of the new user
     * @return status
     */
    public int addUser(final Object userGroup, final String userName) {
        return add(userGroup, new User(userName));
    }
    /**
     * 
     * @param userGroup name of the group where the new user is added. 
     * @param userName  name of the new user group
     * @return status
     */
    public int addUserGroup(final Object userGroup, final String userName) {
        return add(userGroup, new UserGroup(userName));
    }
    
    /**
     * at the end, update tree view 
     * @param userGroup
     * @param userName abstract type
     * @return status
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
                || ROOT.find(userName)) {
            return 3;
        }
        ((UserGroup) userGroup).add(userName);
        AdminView.getInstance().setTree(ROOT.createEntireTree());
        return 0;
    }
    
    /**
     * Check whether the object is instance of User
     * @param user
     * @return boolean
     */
    public boolean isUser(final Object user) {
        return user != null && user instanceof User;
    }
    /**
     * Check user with that name exists
     * @param user
     * @return 
     */
    public boolean hasUser(final String user) {
        return (null != ROOT.findUserWithName(user));
    }
    
    public DefaultListModel getObservers(final Object user) {
        DefaultListModel model = new DefaultListModel();
        ((User)user).getFollowers().forEach(each -> model.addElement(each));        
        return model;
    }
    
    private String tweetTransformer(final Pair<String, String> each) {
        return each.getLeft() + " tweeted " + each.getRight();
    }
    
    public DefaultListModel getMsgBoard(final Object user) {
        DefaultListModel model = new DefaultListModel();
        ((User)user).getMessageBoard().forEach(each -> model.addElement(tweetTransformer(each)));        
        return model;
    }
    
    public void followUser(final UserView userView, final Object self, final String idol) {
        ((User)self).addFollower(ROOT.findUserWithName(idol));
        ((Subject)ROOT.findUserWithName(idol)).attach((Observer)self);
        userView.setObservers(getObservers(self));
    }
    
    public void processTweet(final Object user, final String tweet) {
        ((User)user).setMessage(tweet);
    }
    
    public void updateTweet(final Object observer) {
        openedUserViews.stream().forEach((each) -> {
            System.out.println(each.getName()+ " " + observer.toString());
            if (each.getName().equals(observer.toString())) {
                each.setMessages(getMsgBoard(observer));
            }
        });
    }
    
    public void addUserView(final UserView userView) {
        openedUserViews.add(userView);
    }
    
    public void removeUserView(final UserView userView) {
        openedUserViews.remove(userView);
    }
}
