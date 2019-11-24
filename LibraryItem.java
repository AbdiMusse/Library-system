import java.util.*;
/**
 * This is a superClass of AudioVisual and Printeditem
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public abstract class LibraryItem
{
    private String title;
    private String itemCode;
    private int cost;
    private int timesBorrowed;
    private boolean onLoan;
    /**
     * Constructor for creating an empty LibraryItem object
     */
    public LibraryItem()
    {
        title = null;
        itemCode = null;
        cost = 0;
        timesBorrowed = 0;
        onLoan = false;
    }
    
    /**
     * Extracts data from a file
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        title = scanner.next();
        itemCode = scanner.next();
        cost = scanner.nextInt();
        timesBorrowed = scanner.nextInt();
        onLoan = scanner.nextBoolean();
    }
    
    /**
     * Prints out the details of the object
     */
    public void printDetails()
    {
        System.out.println("Title: " + title);
        System.out.println();
        System.out.println("Item Code: " + itemCode);
        if (timesBorrowed == 1) {
            System.out.println("Borrowed: " + timesBorrowed + " time");
        }
        else {
            System.out.println("Borrowed: " + timesBorrowed + " times");
        }
        if (onLoan == true) {
            System.out.println(title + " is on loan");
        }
        else {
            System.out.println(title + " is not on loan");
        }
        System.out.println("Price = " + cost + "p" );
    }
    
    /**
     * @return The name of the title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @return The item code as a string
     */
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * @return The price in pennies(p)
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * @return Number of times the item has been borrowed
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }
    
    /**
     * @return Whether the item is on laon or not
     */
    public boolean checkOnLoan()
    {
        return onLoan;
    }
    
    /**
     * Set the name of the title
     * @param New title
     */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    /**
     * Set the item Code of the item
     * @param New itemCode
     */
    public void setItemCode(String newItemCode)
    {
        itemCode = newItemCode;
    }
    
    /**
     * Set the price of the item
     * @param New cost
     */
    public void setCost(int newCost)
    {
        cost = newCost;
    }
    
    /**
     * Set the number of times the item has been borrowed
     * @param New number
     */
    public void setTimesBorrowed(int number)
    {
        timesBorrowed = number;
    }
    
    /**
     * Set whether the item is borrowed or not
     * @param New value (true or flase)
     */
    public void setOnLoan(boolean newValue)
    {
        onLoan = newValue;
    }
}