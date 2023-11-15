package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class Copy
{
    private int serialNumber;
    private static int count;
    private String loanStartDate;
    private String loanEndDate;
    private double purchasePrice;
    
    public Copy(double purchasePrice) {
        serialNumber = count++;
        this.purchasePrice = purchasePrice;
        loanStartDate = "";
        loanEndDate = "";
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
