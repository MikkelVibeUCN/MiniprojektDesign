package tui;
import controller.LPController;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * LPUI handles user input related to LP's or Copy's
 * @author Mikkel
 */
public class LPUI
{
    private LPController lpController;
    private static LPUI instance;
    private LPUI() {
        lpController = LPController.getInstance();
    }
    
    public static LPUI getInstance() {
        if(instance == null) {
            instance = new LPUI();
        }
        return instance;
    }
    
    
    /**
     * findLPBarcodes() finds all the barcodes of the LPs the user wants to loan
     * @return ArrayList<String> with all the barcodes inside
     */
    public ArrayList<String> findLPBarcodes() {
        ArrayList<String> result = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        
        boolean hasAddedLP = false;
        boolean isCompleted = false;
        while(!isCompleted) {
            String introMessage = "Type an identifier of the LP or type \"quit\" to quit";
            if(hasAddedLP) {
                introMessage += " or type \"confirm\" to complete the loan";
            }
            System.out.println(introMessage);
            
            String lpIdentifier = keyboard.nextLine();
            if(lpIdentifier.toLowerCase().equals("quit")) {
                isCompleted = true;
            }
            else if(lpIdentifier.toLowerCase().equals("confirm")) {
                if(hasAddedLP) {
                    isCompleted = true;
                }
                else {
                    System.out.println("Can't confirm loan with no LP's");
                }
            }
            else {
                ArrayList<String> lpOptions = lpController.availableLPsInfoFromIdentifier(lpIdentifier);
                if(lpOptions.size() > 0) {
                    System.out.println("LP's matching your search: ");
                    for(String friendOption : lpOptions) {
                        System.out.println(friendOption);
                    }
                    String barcode = selectLPBarcode();
                    if(barcode == null) {
                        System.out.println("Quitting...");
                    }
                    else {
                        result.add(barcode);
                        hasAddedLP = true;
                    }
                }
                else {
                    System.out.println("No available LP's with the identifier: " + lpIdentifier + ".");
                }
            }
        }
        return result;
    }
    
    /**
     * selectLPBarcode() is a helper method that lets the user select which LP they want to loan from their search
     * @return the barcode of the LP they want to loan in String form or null if the method is quit before finding it
     */
    private String selectLPBarcode() {
        String barcode = null;
        Scanner keyboard = new Scanner(System.in);

        boolean isCompleted = false;
        while(!isCompleted) {
            System.out.println("Select one of the LP(s) by typing their barcode or quit by typing \"quit\".");
            String input = keyboard.nextLine();
            if(input.toLowerCase().equals("quit")) {
                isCompleted = true;
            }
            else {
                if(lpController.lpWithBarcodeExistsAndIsAvailable(input)) {
                    System.out.println("LP with barcode: " + input + " was selected");
                    barcode = input;
                    isCompleted = true;
                }
                else {
                    System.out.println("No available LPs with barcode: " + input + ".");
                }
            }
        }
        return barcode;
    }
    
    public void createTestLPs(String barcode, String title, String artist, String publicationDate, int copyAmount) {
        lpController.createLP(barcode, title, artist, publicationDate, copyAmount);
    }
}