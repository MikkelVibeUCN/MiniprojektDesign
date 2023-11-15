package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class LPContainer
{
    private ArrayList<LP> lps;
    private static LPContainer instance;

    private LPContainer() {
        lps = new ArrayList<>();
    }

    public static LPContainer getInstance() {
        if(instance == null) {
            instance = new LPContainer();
        }
        return instance;
    }

    /**
     * Method availableLPs() finds all the LPs who have available copies.
     * @return ArrayList of type LP with all LPs who have available copies
     */
    public ArrayList<LP> availableLPs() {
        ArrayList<LP> result = new ArrayList<>();
        for(LP lp : lps) {
            if(lp.hasAvailableCopy()) {
                result.add(lp);
            }
        }
        return result;
    }

    /**
     * availableLPInfoFromIdentifier() gets an arraylist of string with information about 
     * all the LPs with available copies that match the identifier
     * @param identifier is the identifier to search for
     * @return ArrayList of String type with information about the available LPs
     */

    public ArrayList<String> availableLPInfoFromIdentifier(String identifier) {
        ArrayList<String> lpInfoMatchingIdentifier = new ArrayList<>();
        for(LP lp : availableLPs()) {
            if(lp.identifierMatchesLP(identifier)) {
                lpInfoMatchingIdentifier.add(lp.lpInfo());
            }
        }
        return lpInfoMatchingIdentifier;
    }
    
    /**
     * availableLPWithBarcodeExists() finds out if the barcode has available copies attached to it
     * @param barcode the barcode to search for
     * @return true if it has at least one copy false if it doesn't
     */
    
    public boolean availableLPWithBarcodeExists(String barcode) {
        boolean found = false;
        int i = -1;
        while(!found && ++i < lps.size()) {
            LP currentLP = lps.get(i);
            if(currentLP.getBarcode().toLowerCase().equals(barcode.toLowerCase()) && currentLP.hasAvailableCopy()) {
                found = true;
            }
        }
        return found;
    }
    
    /**
     * getCopyFromBarcode finds the Copy with the barcode from the parameter
     * @param barcode the barcode to search for
     * @return object of Copy with the specified barcode
     */
    public Copy getCopyFromBarcode(String barcode) {
        Copy result = null;
        boolean found = false;
        int i = -1;

        while(!found && ++i < lps.size()) {
            LP currentLP = lps.get(i);
            if(currentLP.hasAvailableCopy()) {
                result = currentLP.getAvailableCopy();
                found = true;
            }
        }
        return result;
    }

    public void addLP(LP lp) {
        lps.add(lp);
    }

}