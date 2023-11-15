package tui;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class MainMenu here.
 *
 * @author Mogens Holm Iversen
 * @version 0.1.0 Initial draft version 
 */
public class MainMenu {
    // instance variables 
    private LoanUI loanUI;
    private FriendUI friendUI;
    private LPUI lpUI;
    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu() {
        // initialise instance variables
        loanUI = LoanUI.getInstance();
        friendUI = FriendUI.getInstance();
        lpUI = LPUI.getInstance();
    }

    public void start() {
        mainMenu();
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                    System.out.println("Denne er ikke implementeret endnu");
                    break;
                case 2:
                    System.out.println("Denne er ikke implementeret endnu");
                    break;
                case 3:
                    createLoan();
                    break;
                case 9:
                    System.out.println("Denne er ikke implementeret endnu");
                    //createTestData();
                    break;
                case 0:
                    System.out.println("Tak for denne gang.");
                    running = false;
                    break;
                default:
                    System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
                    break;
            }
        }
    }

    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) LÃ¥nermenu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Udlånsmenu");
        System.out.println(" (9) Generer testdata");
        System.out.println(" (0) Afslut programmet");
        System.out.print("\n Vælg:");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }

    private void createLoan() {
        int friendID = friendUI.findFriendID();
        if(friendID != -1) {
            ArrayList<String> barcodes = lpUI.findLPBarcodes();
            if(friendID != -1 && barcodes.size() != 0) {
                if(loanUI.createLoan(friendID, barcodes)) {
                    System.out.println("An error has accoured please try again.");
                }
                else {
                    System.out.println("Loan created");
                }
            }
        }
    }

    private void createTestData(){
        

    }

}
