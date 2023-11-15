package controller;

import java.util.ArrayList;
import model.Copy;
import model.Friend;
import model.Loan;

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

    public ArrayList<Copy> getCopiesFromIdentifier(String identifier) {
        return lpController.getCopiesFromIdentifier(identifier);
    }

    public ArrayList<String> friendOptionsFromIdentifier(String identifier) {
        return friendController.friendMatches(identifier);
    }

    public boolean friendWithIdExists(int id) {
        return friendController.friendWithIdExists(id);
    }
    
    public boolean createLoanAndAddToFriend(int friendID, ArrayList<String> barcodes) {
        boolean success = false;
        ArrayList<Copy> copies = new ArrayList<>();
        
        Friend friend = friendController.getFriendFromId(friendID);
        if(friend != null) {
            for(String barcode : barcodes) {
                Copy currentCopy = lpController.getCopyFromBarcode(barcode);
                if(currentCopy != null) {
                    copies.add(currentCopy);
                    currentCopy.markLoan();
                }
            }
            
            if(copies.size() > 0) {
                Loan newLoan = new Loan(copies);
                friend.addLoan(newLoan);
                success = true;
            }
        }
        return success;
    }
}
