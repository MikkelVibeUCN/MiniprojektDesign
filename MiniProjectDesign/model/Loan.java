package model;
import java.util.ArrayList;

/**
 * @author Mikkel
 */
public class Loan
{
    private ArrayList<Copy> copiesInsideLoan;
    private int loanNumber;
    private static int loanCount = 0;
    public Loan(ArrayList<Copy> listOfCopies) {
        copiesInsideLoan = listOfCopies;
        loanNumber = ++loanCount;
    }
    
}
