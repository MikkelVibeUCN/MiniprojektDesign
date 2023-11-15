package model;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.Date;

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
    
    public void markLoan() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
        
        LocalDateTime now = LocalDateTime.now();  
        loanStartDate = dtf.format(now);
        
        LocalDateTime tenDaysAfter = LocalDateTime.from(now).plusDays(10);
        loanEndDate = dtf.format(tenDaysAfter);
    }
}