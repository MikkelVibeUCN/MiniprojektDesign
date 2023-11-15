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
                    createTestData();
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
        System.out.println(" (1) Lånermenu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Udlånsmenu");
        System.out.println(" (9) Generer testdata");
        System.out.println(" (0) Afslut programmet");
        System.out.print("\n Vælg:");

        int choice = -1;
        while(choice == -1) {
            try {
                choice = keyboard.nextInt();
            }
            catch (Exception e) {
                System.out.println("Input skal være et tal - prøv igen");
            }
        }
        return choice;
    }

    private void createLoan() {
        int friendID = friendUI.findFriendID();
        if(friendID != -1) {
            ArrayList<String> barcodes = lpUI.findLPBarcodes();
            if(friendID != -1 && barcodes.size() != 0) {
                if(loanUI.createLoan(friendID, barcodes)) {
                    System.out.println("Loan created");
                }
                else {
                    System.out.println("An error has accoured please try again.");
                }
            }
        }
    }

    private void createTestData(){
        lpUI.createTestLPs("3232sda23d", "Cool song", "Mikkel", "18/01/2003", 7);
        lpUI.createTestLPs("3dsa22a23d", "Hej med dig", "Seje mand", "18/01/2003", 5);
        lpUI.createTestLPs("23232dsa3d", "Mere end 1 klub", "Endnu sejere", "18/01/2003", 2);
        lpUI.createTestLPs("393937323d", "Cold fact", "Manden", "18/01/2003", 6);
        lpUI.createTestLPs("jdskja233d", "American heartbreak", "Ham", "18/01/2003", 1);
        lpUI.createTestLPs("kk322jsd3d", "Cool country", "Lasse", "18/01/2003", 9);
        lpUI.createTestLPs("082726dh3d", "Wild ones", "Mikkel", "18/01/2003", 7);
        lpUI.createTestLPs("dsaa232d3d", "Long time coming", "Seje mand", "18/01/2003", 4);
        lpUI.createTestLPs("lls8383n3d", "Traveler", "Endnu sejere", "18/01/2003", 3);
        lpUI.createTestLPs("ddjsa7323d", "O", "Manden", "18/01/2003", 1);
        lpUI.createTestLPs("3sdsk3333d", "Colden hour", "Ham", "18/01/2003", 2);
        lpUI.createTestLPs("84334dss3d", "Cry baby", "Ham", "18/01/2003", 22);

        friendUI.createFriend("Manden med det store ben", "Villavej 77", "21894367", "Aalborg", "9000");
        friendUI.createFriend("Nik", "Østerbro 1", "69694242", "Randers", "8900");
        friendUI.createFriend("Jay", "Østerbro 1", "42426969", "Randers", "8900");
        friendUI.createFriend("Rasmus Klunk", "Sommergade 10", "90566732", "Aalborg", "9000");
    }
}
