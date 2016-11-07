package edu.cpp.cs356.assign2.Controller;

/**
 *
 * @author wphyo
 */
public enum DisplayMessage {
    EMPTY_TEXT_FIELD ("Error", "Text Field is empty"), 
    NO_TREE_SELECTION ("Error", "Parent User Group is not selected."),
    WRONG_TREE_SELECTION ("Error", "Parent User Group is not selected."),
    DUPLICATE_USER ("Error", "Already exists! Choose a different name."), 
    WRONG_TYPE ("Error", "Invalid user selection."), 
    NO_USER ("Error", "User does not exist."), 
    TOTAL_USER ("Total User", "Total Number of Users under selected Node is "), 
    TOTAL_GROUP ("Total User Group", "Total Number of Users under selected Node is "), 
    TOTAL_MESSAGE ("Total Messages", "Total Number of Messages under selected Node is "), 
    TOTAL_PERCENTAGE ("Positive Percentages", "Percentage of Positive Messages under selected Node is "), 
    ADDED_USER ("Success", "Added!");

    private final String title;   // in kilograms
    private final String message; // in meters
    private DisplayMessage(final String title, final String message) {
        this.title = title;
        this.message = message;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getMessage() {
        return message;
    }
}
