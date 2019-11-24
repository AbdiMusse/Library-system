import java.util.*;
import java.io.*;
/**
 * This is a libraryUser Class that represents a user of the library
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class LibraryUser
{
    private String userID;
    private String surName;
    private String firstName;
    private String otherInitials;
    private String title;
    /**
     * Constructor for creating an empty LibraryUser object
     */
    public LibraryUser()
    {
        userID = null;
        surName = null;
        firstName = null;
        otherInitials = null;
        title = null;
    }
    
    /**
     * Extracts data from a file
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        userID = scanner.next();
        surName = scanner.next();
        firstName = scanner.next();
        otherInitials = scanner.next();
        title = scanner.next();
    }
    
    /**
     * Writes the data that is held by the object to a file
     * @param PrintWriter is used in the library Class
     */
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(userID+", "+surName+", "+
        firstName+", "+otherInitials+", "+title);
    }
    
    /**
     * Prints out the details of the libraryUser object
     */
    public void printDetails()
    {
        System.out.println("The customerID is " + userID);
        System.out.println("SurName: " + surName);
        System.out.println("First Name: " + firstName);
        System.out.println("Customer Initials: " + otherInitials);
        System.out.println("Title: " + title);
    }
    
    /**
     * @return The ID of the perosn using the library
     */
    public String getUserID()
    {
        return userID;
    }
    
    /**
     * @return The surName of the person using the library
     */
    public String getSurName()
    {
        return surName;
    }
    
    /**
     * @return The first name of the person using the library
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * @return The Initials of the person using the library
     */
    public String getInitials()
    {
        return otherInitials;
    }
    
    /**
     * @return The title of the person using the library
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Set the userID of the person
     * @param new user ID
     */
    public void setUserID(String newUserID)
    {
        userID = newUserID;
    }
    
    /**
     * Set the surName of the person
     * @param new surName
     */
    public void setSurName(String newSurName)
    {
        surName = newSurName;
    }
    
    /**
     * Set the First Name of the person
     * @param new first name
     */
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }
    
    /**
     * Set the Initials of the person
     * @param new Initials
     */
    public void setInitials(String newInitials)
    {
        otherInitials = newInitials;
    }
    
    /**
     * Set the title of the person
     * @param new title
     */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
}