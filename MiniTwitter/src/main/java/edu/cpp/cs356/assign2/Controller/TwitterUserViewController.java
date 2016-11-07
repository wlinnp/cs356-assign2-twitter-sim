package edu.cpp.cs356.assign2.Controller;

import edu.cpp.cs356.assign2.Data.Observer.Observer;
import edu.cpp.cs356.assign2.Data.Observer.Subject;
import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.View.UserView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import org.apache.commons.lang3.tuple.Pair;

/**
 * This class is responsible to control the logic of
 * <p>
 * 1. following users.
 * 2. adding tweets.
 * 3. displaying tweets on respective views. 
 * <p>
 * @author wphyo
 */
public class TwitterUserViewController extends TwitterController {
    private static TwitterUserViewController INSTANCE;
    private static List<UserView> openedUserViews;
    public static TwitterUserViewController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TwitterUserViewController();
            openedUserViews = new ArrayList<>();

        }
        return INSTANCE;
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
        ((User)self).addFollower(getRoot().findUserWithName(idol));
        ((Subject)getRoot().findUserWithName(idol)).attach((Observer)self);
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
        return each.toString().equals(observer.toString()) || each.toString().equals(subject.toString());
    }
    
    public void addUserView(final UserView userView) {
        openedUserViews.add(userView);
    }
    
    public void removeUserView(final UserView userView) {
        openedUserViews.remove(userView);
    }
    
}
