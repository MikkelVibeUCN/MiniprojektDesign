package controller;
import model.LPContainer;
import model.Copy;
import model.LP;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class LPController
{
    private LPContainer lpContainer;
    private static LPController instance;
    private LPController() {
        lpContainer = LPContainer.getInstance();
    }

    public static LPController getInstance() {
        if(instance == null) {
            instance = new LPController();
        }
        return instance;
    }

    public ArrayList<String> availableLPsInfoFromIdentifier(String identifier) {
        return lpContainer.availableLPInfoFromIdentifier(identifier);
    }
    
    public boolean lpWithBarcodeExistsAndIsAvailable(String barcode) {
        return lpContainer.availableLPWithBarcodeExists(barcode);
    }
    
    public Copy getCopyFromBarcode(String barcode) {
        return lpContainer.getCopyFromBarcode(barcode);
    }
    
    public void createLP(String barcode, String title, String artist, String publicationDate, int copyAmount) {
        LP newLP = new LP(barcode, title, artist, publicationDate);
        
        for(int i = 0; i < copyAmount; i++) {
            Copy newCopy = new Copy(i * 33232 + 4);
            newLP.addCopyToList(newCopy);
        }
        
        lpContainer.addLP(newLP);
    }
    
}