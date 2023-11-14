package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class LPContainer
{
    private static LPContainer instance;
    private ArrayList<LP> lps;

    private LPContainer() {
        lps = new ArrayList<>();
    }

    public static LPContainer getInstance() {
        if(instance == null) {
            instance = new LPContainer();
        }
        return instance;
    }

    public ArrayList<Copy> findCopiesFromIdentifier(String identifier) {
        ArrayList<Copy> possibleCopies = new ArrayList<>();
        for(LP lp : lps) {
            if(lp.hasAvailableCopies()) {
                for(Copy copy : lp.getCopies()) {
                    if(copy.isAvailableForLoan()) {
                        possibleCopies.add(copy);
                    }
                }
            }
        }
        return possibleCopies;
    }
}
