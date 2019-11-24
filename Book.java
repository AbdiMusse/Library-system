import java.util.*;
/**
 * This is a Book class that simulates an actual book
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class Book extends PrintedItem
{
    private String author;
    private String isbn;
    /**
     * Constructor for creating an empty Book object
     */
    public Book()
    {
        super();
        author = null;
        isbn = null;
    }
    
    /**
     * Extracts the data from a file where book data are present
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        author = scanner.next();
        isbn = scanner.next();
        super.extractData(scanner);
    }
    
    /**
     * Prints out the details of the book object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
    
    /**
     * @return The name of the author
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * @return The isbn number
     */
    public String getISNBN()
    {
        return isbn;
    }
    
    /**
     * Sets new name for the author
     * @param new name
     */
    public void setAuthor(String newName)
    {
        author = newName;
    }
    
    /**
     * Sets new ISBN number for the user
     * @param new number
     */
    public void setISNBN(String number)
    {
        isbn = number;
    }
}