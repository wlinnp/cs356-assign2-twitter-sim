package edu.cpp.cs356.assign2.Data.Visitor;

import edu.cpp.cs356.assign2.Data.User;
import edu.cpp.cs356.assign2.Data.UserComponent;
import edu.cpp.cs356.assign2.Data.UserGroup;
import java.util.Arrays;
import java.util.List;

/**
 * @author william
 */
public class PositiveMessagePercentageVisitor implements UserComponentVisitor {

    private static final List<String> POSITIVE_WORDS = Arrays.asList("good", "glad", "excellent", "great", "better", "bravo");
    
    private boolean isMessagePositive(final String lowerCaseString) {
        return POSITIVE_WORDS.stream().anyMatch((each) -> lowerCaseString.contains(each));
    }
    
    private double calculatePercentage(final double totalMsg, final int totalPositiveMsg) {
        double result = (totalPositiveMsg / totalMsg) * 100;
        return result;
    }
    
    private double roundTwoDecimal(final double result) {
        return (Math.round(result * 100)) / 100.00;
    }
    
    @Override
    public double visit(User user) {
        if (0 == user.getMessagesSize()) {
            return 0;
        }
        int totalPositiveMsg = 0;
        for (String each : user.getMessages()) {
            if (isMessagePositive(each.toLowerCase())) {
                totalPositiveMsg++;
            }
        }
        return roundTwoDecimal(calculatePercentage(user.getMessagesSize(), totalPositiveMsg));
    }

    @Override
    public double visit(UserGroup userGroup) {
        double totalMsg = userGroup.accept(new TotalMessagesVisitor());
        if (0 == totalMsg) {
            return 0;
        }
        int totalPositiveMsg = 0;
        for (UserComponent each : userGroup.getFollowers()) {
            totalPositiveMsg += (each instanceof User) ? 1 : visit((UserGroup)each);
        }
        return roundTwoDecimal(calculatePercentage(totalMsg, totalPositiveMsg));
    }

}
