package tui;
import java.util.Scanner;
import controller.LoanLPController;
import java.util.ArrayList;

/**
 * LoanUI is the specific use case of creating loans
 *
 * @author Mogens Holm Iversen, opdateret af Mikkel
 * @version 0.1.0 Initial draft version 
 */
public class LoanUI{
    private LoanLPController loanLPController;
    private static LoanUI instance;

    private LoanUI() {
        loanLPController = LoanLPController.getInstance();
    }

    public static LoanUI getInstance() {
        if(instance == null) {
            instance = new LoanUI();
        }
        return instance;
    }

    public boolean createLoan(int friendID, ArrayList<String> barcodes) {
        return loanLPController.createLoanAndAddToFriend(friendID, barcodes);
    }
}