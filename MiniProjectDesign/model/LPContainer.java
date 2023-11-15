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

    public ArrayList<LP> availableLPs() {
        ArrayList<LP> result = new ArrayList<>();
        for(LP lp : lps) {
            if(lp.hasAvailableCopy()) {
                result.add(lp);
            }
        }
        return result;
    }

    public ArrayList<String> availableLPInfoFromIdentifier(String identifier) {
        ArrayList<String> lpInfoMatchingIdentifier = new ArrayList<>();
        for(LP lp : availableLPs()) {
            if(lp.identifierMatchesLP(identifier)) {
                lpInfoMatchingIdentifier.add(lp.lpInfo());
            }
        }
        return lpInfoMatchingIdentifier;
    }
    
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