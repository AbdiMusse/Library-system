import java.util.*;
/**
 * This is a superClass of Book and Periodical
 * 
 * @author Abdi-rahman Muse
 * @version 4.6
 */
public abstract class PrintedItem extends LibraryItem
{
    private int noOfPages;
    private String publisher;
    /**
     * Constructor for creating an empty PrintedItem object
     */
    public PrintedItem()
    {
        super();
        noOfPages = 0;
        publisher = null;
    }

    /**
     * Extracts data from a file
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        noOfPages = scanner.nextInt();
        publisher = scanner.next();
        super.extractData(scanner);
    }
    
    /**
     * Prints out the details of each object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Number of pages: " + noOfPages + " pages");
        System.out.println("Publisher: " + publisher);
    }
    
    /**
     * @return The number of pages
     */
    public int getNoOfPages()
    {
        return noOfPages;
    }
    
    /**
     * @return The publishers name
     */
    public String getPublisher()
    {
        return publisher;
    }
    
    /**
     * Set the number of pages
     * @param New number
     */
    public void setNoOfPages(int newNumber)
    {
        noOfPages = newNumber;
    }
    
    /**
     * Set the name of the publisher
     * @param New name
     */
    public void setPublisherName(String newName)
    {
        publisher = newName;
    }
}