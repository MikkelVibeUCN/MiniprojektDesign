package tui;
import java.util.Scanner;
import controller.LoanLPController;
import java.util.ArrayList;

/**
 * Write a description of class LoanMenu here.
 *
 * @author Mogens Holm Iversen
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

    public void createLoan(int friendID) {
        Scanner keyboard = new Scanner(System.in);
        boolean isCompleted = false;

        while(!isCompleted) {
            // Input string to search for copies

            // Select a copy

            // Choose to add more copies or confirm

        }
    }
    private String getBarCode() {
        String barcode = null;
        
        boolean success = false;
        while(!success) {
            
        }
        return barcode;
    }
    
    
    private String getCopyInformationFromIdentifier(String identifier) {
        return null;

    }
}
