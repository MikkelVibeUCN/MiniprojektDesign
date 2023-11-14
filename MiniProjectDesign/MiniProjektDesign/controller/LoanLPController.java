package controller;
import java.util.ArrayList;
import model.Copy;

/**
 * @author Mikkel
 */
public class LoanLPController
{
    private FriendController friendController;
    private LPController lpController;
    private static LoanLPController instance;
    private LoanLPController() {
        friendController = FriendController.getInstance();
        lpController = LPController.getInstance();
    }

    public static LoanLPController getInstance() {
        if(instance == null) {
            instance = new LoanLPController();
        }
        return instance;
    }

    public void createLoan() {

    }

    public ArrayList<Copy> getCopiesFromIdentifier(String identifier) {
        return lpController.getCopiesFromIdentifier(identifier);
    }

    public ArrayList<String> friendOptionsFromIdentifier(String identifier) {
        return friendController.friendMatches(identifier);
    }

    public boolean friendWithIdExists(int id) {
        return friendController.friendWithIdExists(id);
    }
}
