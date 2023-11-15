package tui;
import controller.LPController;
import java.util.Scanner;
import java.util.ArrayList;

/**
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

    public ArrayList<String> findLPBarcodes() {
        ArrayList<String> result = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        boolean isCompleted = false;
        while(!isCompleted) {
            System.out.println("Type an identifier of the LP or type \"quit\" to quit and \"confirm\" to complete the loan.");
            String lpIdentifier = keyboard.nextLine();
            
            if(lpIdentifier.toLowerCase().equals("quit")) {
                isCompleted = true;
            }
            else if(lpIdentifier.toLowerCase().equals("complete")) {
                isCompleted = true;
            }
            else {
                ArrayList<String> lpOptions = lpController.availableLPsInfoFromIdentifier(lpIdentifier);
                if(lpOptions.size() > 0) {
                    System.out.println("LP's matching your search: ");
                    for(String friendOption : lpOptions) {
                        System.out.println(friendOption);
                    }
                    String barcode = getLPBarcode();
                    if(barcode == null) {
                        System.out.println("Quitting...");
                        isCompleted = true;
                    }
                    else {
                        result.add(barcode);
                    }
                }
                else {
                    System.out.println("No available LPs with the identifier: " + lpIdentifier + ".");
                }
            }
        }
        return result;
    }

    private String getLPBarcode() {
        String barcode = null;
        Scanner keyboard = new Scanner(System.in);

        boolean success = false;
        while(!success) {
            System.out.println("Select one of the LPs(s) by typing their barcode or quit by typing \"quit\".");
            if(keyboard.nextLine().equals("quit")) {
                success = true;
            }
            else {
                String input = keyboard.nextLine();
                if(lpController.lpWithBarcodeExistsAndIsAvailable(input)) {
                    System.out.println("LP with barcode: " + input + " was selected");
                    success = true;
                }
                else {
                    System.out.println("No available LPs with barcode: " + input + ".");
                }
            }
        }
        return barcode;
    }
}