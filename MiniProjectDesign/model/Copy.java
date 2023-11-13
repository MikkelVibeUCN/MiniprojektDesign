package model;

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

}
