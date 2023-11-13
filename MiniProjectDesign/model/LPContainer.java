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
    
    
}

