package edu.cpp.cs356.assign2.View;

import edu.cpp.cs356.assign2.Controller.TwitterController;
import javax.swing.DefaultListModel;
import org.apache.commons.lang3.StringUtils;

/**
 * @author william
 */
public final class UserView extends javax.swing.JFrame {
    private final Object user;
    /**
     * Creates new form User
     * @param user
     */
    public UserView(final Object user) {
        this.user = user;
        System.out.println(user.toString());
        initComponents();
        setObservers(TwitterController.getInstance().getObservers(user));
    }
    /**
     * Set the followers list
     * @param model includes all followers
     */
    public void setObservers(final DefaultListModel model) {
        listObservers.setModel(model);
        jscObservers.setViewportView(listObservers);
    }
    
    public void setMessages() {
        
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
        jscObservers = new javax.swing.JScrollPane();
        listObservers = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnPostTweet = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMessages = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnFollowUser.setText("Follow User");
        btnFollowUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowUserActionPerformed(evt);
            }
        });

        listObservers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jscObservers.setViewportView(listObservers);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

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
        jScrollPane3.setViewportView(listMessages);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscObservers)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFollowUser, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(btnPostTweet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFollowUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscObservers, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPostTweet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            Utils.showMsg("Error", "Text Field is empty");
            return false;
        } else if (!TwitterController.getInstance().hasUser(input)) {
            Utils.showMsg("Error", "User does not exist");
            return false;
        }
        return true;
    }
    
    private void btnFollowUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowUserActionPerformed
        if (addActionValidations(txtUser.getText())) {
            TwitterController.getInstance().followUser(this, user, txtUser.getText());            
        }
    }//GEN-LAST:event_btnFollowUserActionPerformed
    private boolean postTweetActionValidations(final String input) {
        if (StringUtils.isBlank(input)) {
            Utils.showMsg("Error", "empty Tweet");
            return false;
        }
        return true;
    }
    private void btnPostTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostTweetActionPerformed
        System.out.println("Post Tweet");
    }//GEN-LAST:event_btnPostTweetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFollowUser;
    private javax.swing.JButton btnPostTweet;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JScrollPane jscObservers;
    private javax.swing.JList<String> listMessages;
    private javax.swing.JList<String> listObservers;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
