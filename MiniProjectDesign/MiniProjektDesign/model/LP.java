package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class LP
{
    private ArrayList<Copy> copies;
    private String barcode;
    private String title;
    private String artist;
    private String publicationDate;

    public LP(String barcode, String title, String artist, String publicationDate) {
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
        copies = new ArrayList<>();
    }

    public void addCopyToList(Copy copyToAdd) {
        copies.add(copyToAdd);
    }

    public ArrayList<String> getParameters() {
        ArrayList<String> result = new ArrayList<>();

        result.add(barcode);
        result.add(title);
        result.add(artist);
        result.add(publicationDate);

        return result;
    }

    public boolean identifierMatchesLP(String identifier) {
        boolean result = false;
        int i = -1;
        ArrayList<String> parameters = getParameters();
        while(!result && ++i < parameters.size()) {
            String currentIdentifier = parameters.get(i);
            if(currentIdentifier.toLowerCase().contains(identifier.toLowerCase())) {
                result = true;
            }
        }
        return result;
    }

    public boolean hasAvailableCopy() {
        boolean result = false;
        int i = -1;
        while(!result && ++i < copies.size()) {
            Copy currentCopy = copies.get(i);
            if(currentCopy.isAvailableForLoan()) {
                result = true;
            }
        }
        return result;
    }

    public String getBarcode() {
        return barcode;
    }

    public ArrayList<Copy> getCopies() {
        return copies;
    }

    public String lpInfo() {
        return "Barcode: " + barcode + ", title of LP: " + title 
        + ", by " + artist + ", on " + publicationDate;
    }

    public Copy getAvailableCopy() {
        Copy result = null;
        int i = -1;
        boolean found = false;
        while(!found && ++i < copies.size()) {
            Copy currentCopy = copies.get(i);
            if(currentCopy.isAvailableForLoan()) {
                result = currentCopy;
                found = true;
            }
        }
        return result;
    }
}