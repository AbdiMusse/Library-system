import java.util.*;
/**
 * This is a Periodical class that simulates an actual Periodical
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class Periodical extends PrintedItem
{
    private String publicationDate;
    /**
     * Constructor for creating an empty Periodical object
     */
    public Periodical()
    {
        super();
        publicationDate = null;
    }

    /**
     * Extracts the data from a file where Periodical data are present
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        publicationDate = scanner.next();
        super.extractData(scanner);
    }
    
    /**
     * Prints out the details of the periodical object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("publication date: " + publicationDate);
    }
    
    /**
     * @return The date of publication
     */
    public String getPublicationDate()
    {
        return publicationDate;
    }
    
    /**
     * Set a date of publication
     * @param new date
     */
    public void setPublicationDate(String newDate)
    {
        publicationDate = newDate;
    }
}