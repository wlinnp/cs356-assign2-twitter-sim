package edu.cpp.cs356.assign2.View;

import edu.cpp.cs356.assign2.Controller.DisplayMessage;
import edu.cpp.cs356.assign2.Controller.TwitterUserViewController;
import javax.swing.DefaultListModel;
import org.apache.commons.lang3.StringUtils;

/**
 * @author william
 */
public final class UserView extends TwitterView {
    private final TwitterUserViewController twitterController; 

    public UserView(final Object user) {
        super(user);
        twitterController = TwitterUserViewController.getInstance();
        initComponents();
        twitterController.addUserView(this);
        updateFollowingPane(twitterController.getFollowings(user));
        updateMessagesPane(twitterController.getMsgBoard(user));
    }
    
    /**
     * Set the followers list
     * @param model includes all followers
     */
    public void updateFollowingPane(final DefaultListModel model) {
        listObservers.setModel(model);
        jScrollPaneObservers.setViewportView(listObservers);
    }
    
    public void updateMessagesPane(final DefaultListModel model) {
        listMessages.setModel(model);
        jScrollPaneMessages.setViewportView(listMessages);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        btnFollowUser = new javax.swing.JButton();
        jScrollPaneObservers = new javax.swing.JScrollPane();
        listObservers = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTweet = new javax.swing.JTextArea();
        btnPostTweet = new javax.swing.JButton();
        jScrollPaneMessages = new javax.swing.JScrollPane();
        listMessages = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnFollowUser.setText("Follow User");
        btnFollowUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowUserActionPerformed(evt);
            }
        });

        listObservers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneObservers.setViewportView(listObservers);

        txtTweet.setColumns(20);
        txtTweet.setRows(5);
        jScrollPane2.setViewportView(txtTweet);

        btnPostTweet.setText("Post Tweet");
        btnPostTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostTweetActionPerformed(evt);
            }
        });

        listMessages.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneMessages.setViewportView(listMessages);

        jLabel1.setText("Currently following");

        jLabel2.setText("Enter tweet here");

        jLabel3.setText("Message Board");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneObservers)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFollowUser, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(btnPostTweet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPaneMessages))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFollowUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneObservers, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPostTweet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * 1. text box is not empty
     * 2. such user exist. 
     * @param input
     * @return validation result
     */
    private boolean addActionValidations(final String input) {
        if (StringUtils.isBlank(input)) {
            displayMessage(DisplayMessage.EMPTY_TEXT_FIELD);
            return false;
        } else if (!twitterController.hasUser(input)) {
            displayMessage(DisplayMessage.NO_USER);
            return false;
        }
        return true;
    }
    
    private void btnFollowUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowUserActionPerformed
        if (addActionValidations(txtUser.getText())) {
            twitterController.followUser(this, getUser(), txtUser.getText());            
        }
    }//GEN-LAST:event_btnFollowUserActionPerformed
    
    private boolean postTweetActionValidations(final String input) {
        if (StringUtils.isBlank(input)) {
            displayMessage(DisplayMessage.EMPTY_TEXT_FIELD);
            return false;
        }
        return true;
    }
    
    private void btnPostTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostTweetActionPerformed
        if (postTweetActionValidations(txtTweet.getText())) {
            twitterController.processTweet(getUser(), txtTweet.getText());
        }
    }//GEN-LAST:event_btnPostTweetActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        twitterController.removeUserView(this);
    }//GEN-LAST:event_formWindowClosed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFollowUser;
    private javax.swing.JButton btnPostTweet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneMessages;
    private javax.swing.JScrollPane jScrollPaneObservers;
    private javax.swing.JList<String> listMessages;
    private javax.swing.JList<String> listObservers;
    private javax.swing.JTextArea txtTweet;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
