package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class Copy
{
    private int serialNumber;
    private String loanStartDate;
    private String loanEndDate;
    private double purchasePrice;
    
    public Copy(int serialNumber, double purchasePrice) {
        this.serialNumber = serialNumber;
        this.purchasePrice = purchasePrice;
    }
    
    public boolean isAvailableForLoan() {
        boolean result = false;
        if(loanEndDate.equals("")) {
            result = true;
        }
        return result;
    }
    
    public int getSerialNumber() {
        return serialNumber;
    }
}
