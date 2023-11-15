package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class Friend
{
    private String name;
    private String address;
    private String phone;
    private String city;
    private String postalCode;
    private ArrayList<Loan> loans;
    private int id;
    private static int count;
    
    /**
     * Constructor for Friend
     */
    public Friend(String name, String address, String phone, String city, String postalCode) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.postalCode = postalCode;
        id = count++;
        loans = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public int getId() {
        return id;
    }
    
    /**
     * Method parameters()
     * @return ArrayList of type String with all the parameters which can be searched by.
     */
    private ArrayList<String> parameters() {
        ArrayList<String> result = new ArrayList<>();
        
        result.add(name);
        result.add(address);
        result.add(phone);
        result.add(city);
        result.add(postalCode);
        
        return result;
    }
    
    /**
     * isMatch() checks if the parameter matches one of the friends attributes
     * @param identifier to check match on in string form
     * @return true if the parameter matches one of the attributes and false if it doesn't
     */
    public boolean isMatch(String identifier) {
        boolean result = false;
        int i = -1;
        ArrayList<String> parametersInFriend = parameters();
        while(!result && ++i < parameters().size()) {
            String currentParameter = parametersInFriend.get(i).toLowerCase();
            if(currentParameter.contains(identifier.toLowerCase())) {
                result = true;
            }
        }
        return result;
    }
    
    public void addLoan(Loan loan) {
        loans.add(loan);
    }
    
    /**
     * Method infoString() creates strings with information about the friend
     * @return String with information about the friend
     */
    public String infoString() {
        return "ID: " + id + ": This friend is " + name 
            + ", their address is " + address + ", " + city + ", " + postalCode
            + ", phone number " + phone;
    }
    

}
