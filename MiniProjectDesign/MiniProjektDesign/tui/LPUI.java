package tui;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class LPUI
{
    private LPController lpController;

    public LPUI() {
        lpController = LPController.getInstance();
    }

    public String findLPBarcode() {
        String barcode = null;
        Scanner keyboard = new Scanner(System.in);

        boolean isCompleted = false;
        while(!isCompleted) {
            System.out.println("Type an identifier of the LP or type \"quit\" to quit ");
            String lpIdentifier = keyboard.nextLine();

            if(lpIdentifier.equals("quit")) {
                isCompleted = true;
            }
            else {
                ArrayList<String> lpOptions = lpController.availableLPsInfoFromIdentifier(lpIdentifier);
                if(lpOptions.size() > 0) {
                    System.out.println("LP's matching your search: ");
                    for(String friendOption : lpOptions) {
                        System.out.println(friendOption);
                    }
                    //barcode = getFriendID();
                    if(barcode == null) {
                        System.out.println("Quitting...");
                    }
                    else {
                        System.out.println("LP selected.");
                    }
                    isCompleted = true;
                }
                else {
                    System.out.println("No available LPs with the identifier: " + lpIdentifier + ".");
                }
            }
        }
        return barcode;
    }

    private int getLPBarcode() {
        int id = -1;
        Scanner keyboard = new Scanner(System.in);

        boolean success = false;
        while(!success) {
            System.out.println("Select one of the friend(s) by typing their id or quit by typing \"quit\".");
            if(keyboard.hasNextInt()) {
                id = keyboard.nextInt();
                if(friendController.friendWithIdExists(id)) {
                    System.out.println("Friend with id: " + id + " was selected");
                    success = true;
                }
                else {
                    System.out.println("No friend with the id: " + id + " exists.");
                }
            }
            else if(keyboard.nextLine().equals("quit")) {
                success = true;
            }
        }
        return id;
    }
}
