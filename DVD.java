import java.util.*;
/**
 * This is a DVD calss that simulates an actual DVD
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class DVD extends AudioVisual
{
    private String director;
    /**
     * Constructor for creating an empty DVD object
     */
    public DVD()
    {
        super();
        director = null;
    }
    
    /**
     * Extracts the data from a file where dvd data are present
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        director = scanner.next();
        super.extractData(scanner);
    }
    
    /**
     * Prints out the details of the DVD object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Director name: " + director);
    }
    
    /**
     * @return The name of the director
     */
    public String getDirectorName()
    {
        return director;
    }
    
    /**
     * Set the name of the director
     * @param New name
     */
    public void setDirectorName(String newName)
    {
        director = newName;
    }
}