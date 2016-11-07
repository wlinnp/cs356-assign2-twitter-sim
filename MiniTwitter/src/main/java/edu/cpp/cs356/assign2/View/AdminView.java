package edu.cpp.cs356.assign2.View;

import edu.cpp.cs356.assign2.Controller.TwitterAdminController;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.apache.commons.lang3.StringUtils;

/**
 * @author william
 */
public class AdminView extends TwitterView {

    /**
     * Creates new form AdminView
     */
    private static AdminView INSTANCE;
    private final TwitterAdminController twitterController; 
    
    private AdminView() {
        super("Admin Control");
        twitterController = TwitterAdminController.getInstance();
        initComponents();
    }
    
    public static AdminView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdminView();
        }
        return INSTANCE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        treeAllUsers = new javax.swing.JTree();
        txtUser = new javax.swing.JTextField();
        btnAddUser = new javax.swing.JButton();
        txtGrp = new javax.swing.JTextField();
        btnAddGroup = new javax.swing.JButton();
        btnShowTotalUser = new javax.swing.JButton();
        btnShowTotalGrp = new javax.swing.JButton();
        btnShowTotalMsg = new javax.swing.JButton();
        btnShowPercentagePositive = new javax.swing.JButton();
        btnOpenUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(treeAllUsers);

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnAddGroup.setText("Add Group");
        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGroupActionPerformed(evt);
            }
        });

        btnShowTotalUser.setText("Show User Total");
        btnShowTotalUser.setOpaque(true);
        btnShowTotalUser.setPreferredSize(new java.awt.Dimension(72, 50));
        btnShowTotalUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTotalUserActionPerformed(evt);
            }
        });

        btnShowTotalGrp.setText("Show Group Total");
        btnShowTotalGrp.setOpaque(true);
        btnShowTotalGrp.setPreferredSize(new java.awt.Dimension(72, 50));
        btnShowTotalGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTotalGrpActionPerformed(evt);
            }
        });

        btnShowTotalMsg.setText("Show Messages Total");
        btnShowTotalMsg.setOpaque(true);
        btnShowTotalMsg.setPreferredSize(new java.awt.Dimension(72, 50));
        btnShowTotalMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTotalMsgActionPerformed(evt);
            }
        });

        btnShowPercentagePositive.setText("Show Positive Percentages");
        btnShowPercentagePositive.setOpaque(true);
        btnShowPercentagePositive.setPreferredSize(new java.awt.Dimension(72, 50));
        btnShowPercentagePositive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPercentagePositiveActionPerformed(evt);
            }
        });

        btnOpenUser.setText("Open User View");
        btnOpenUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnShowTotalUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGrp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(btnShowTotalMsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(btnShowTotalGrp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(btnShowPercentagePositive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                    .addComponent(btnOpenUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpenUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowTotalUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowTotalGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowTotalMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowPercentagePositive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * update the tree view
     * @param root Tree node with all users & groups
     */
    public void setTree (final DefaultMutableTreeNode root) {
        treeAllUsers.setModel(new DefaultTreeModel(root));
        treeAllUsers.setRootVisible(true);
        treeAllUsers.setShowsRootHandles(true);
        jScrollPane1.setViewportView(treeAllUsers);
    }
    
    /**
     * Validations
     * 1. User input must not be empty
     * 2. Tree must have node selected
     * @param input
     * @return validation result
     */
    private boolean addActionValidations(final String input) {
        if (StringUtils.isBlank(input)) {
            displayMessage("Error", "Text Field is empty");
            return false;
        } else {
            return isElementSelectedInTree();
        }
    }
    
    /**
     * User must select the base group to add to
     * @return Validation Result
     */
    private boolean isElementSelectedInTree() {
        if (treeAllUsers.getLastSelectedPathComponent() == null) {
            displayMessage("Error", "Parent User Group is not selected.");
            return false;
        }
        return true;
    }
    
    /**
     * Display error or success message based on status. 
     * @param status 
     */
    private void addActionResult(final int status) {
        switch (status) {
            case 1: displayMessage("Error", "Choose parent user group");
                break;
            case 2: displayMessage("Error", "Invalid chosen user group");
                break;
            case 3: displayMessage("Error", "Name & Type already existed");
                break;
            case 0: txtUser.setText("");
                displayMessage("Success", "Added!");
                break;
        }
    }
    
    /**
     * 1. check tree is selected.
     * 2. selected entry is user. 
     * @return validation result
     */
    private boolean openUserActionValidations() {
        if (isElementSelectedInTree()) {
            if (!twitterController.isUserType(convertSelectedTreeNode())) {
                displayMessage("Error", "Invalid user selection.");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    
    private Object convertSelectedTreeNode() {
        return ((DefaultMutableTreeNode)treeAllUsers.getLastSelectedPathComponent()).getUserObject();
    }
    
    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        if (addActionValidations(txtUser.getText())) {
            addActionResult(twitterController.addUser(convertSelectedTreeNode(), txtUser.getText()));
        }
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGroupActionPerformed
        if (addActionValidations(txtGrp.getText())) {
            addActionResult(twitterController.addUserGroup(convertSelectedTreeNode(), txtGrp.getText()));
        }
    }//GEN-LAST:event_btnAddGroupActionPerformed

    private void btnOpenUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenUserActionPerformed
        if (openUserActionValidations()) {
            Object selected = convertSelectedTreeNode();
            UserView user = new UserView(selected);
            user.setTitle(selected.toString());
            user.setVisible(true);
        }
    }//GEN-LAST:event_btnOpenUserActionPerformed

    private void btnShowTotalUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTotalUserActionPerformed
        if (isElementSelectedInTree()) {
            displayMessage("Total User", "Total Number of Users under selected Node is " + twitterController.getTotalUser(convertSelectedTreeNode()));
        }
    }//GEN-LAST:event_btnShowTotalUserActionPerformed

    private void btnShowTotalGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTotalGrpActionPerformed
        if (isElementSelectedInTree()) {
            displayMessage("Total User Group", "Total Number of Users under selected Node is " + twitterController.getTotalUserGroup(convertSelectedTreeNode()));
        }
    }//GEN-LAST:event_btnShowTotalGrpActionPerformed

    private void btnShowTotalMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTotalMsgActionPerformed
        if (isElementSelectedInTree()) {
            displayMessage("Total Messages", "Total Number of Messages under selected Node is " + twitterController.getTotalMessages(convertSelectedTreeNode()));
        }
    }//GEN-LAST:event_btnShowTotalMsgActionPerformed

    private void btnShowPercentagePositiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPercentagePositiveActionPerformed
        if (isElementSelectedInTree()) {
            displayMessage("Total Messages", "Percentage of Positive Messages under selected Node is " + twitterController.getPositiveMessagePercentage(convertSelectedTreeNode()));
        }
    }//GEN-LAST:event_btnShowPercentagePositiveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGroup;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnOpenUser;
    private javax.swing.JButton btnShowPercentagePositive;
    private javax.swing.JButton btnShowTotalGrp;
    private javax.swing.JButton btnShowTotalMsg;
    private javax.swing.JButton btnShowTotalUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree treeAllUsers;
    private javax.swing.JTextField txtGrp;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
