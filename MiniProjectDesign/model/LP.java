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

}
