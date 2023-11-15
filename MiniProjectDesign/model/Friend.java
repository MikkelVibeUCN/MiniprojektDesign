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

    public Friend(String name, String address, String phone, String city, String postalCode, int id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.postalCode = postalCode;
        this.id = id;
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
    
    private ArrayList<String> parameters() {
        ArrayList<String> result = new ArrayList<>();
        
        result.add(name);
        result.add(address);
        result.add(phone);
        result.add(city);
        result.add(postalCode);
        
        return result;
    }
    
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
    
    public String infoString() {
        return "ID: " + id + ": This friend is " + name 
            + ", their address is " + address + ", " + city + ", " + postalCode
            + ", phone number " + phone;
    }
    

}
