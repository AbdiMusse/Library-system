import java.util.*;
/**
 * This is a CD class that simulates an actual CD
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class CD extends AudioVisual
{
    private int noOfTracks;
    private String artist;
    /**
     * Constructor for creating an empty CD object
     */
    public CD()
    {
        super();
        noOfTracks = 0;
        artist = null;
    }
    
    /**
     * Extracts the data from a file where cd data are present
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        artist = scanner.next();
        noOfTracks = scanner.nextInt();
        super.extractData(scanner);
    }
    
    /**
     * Prints out the details of the CD object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The CD has " + noOfTracks + " tracks");
        System.out.println("Arist name: " + artist);
    }
   
    /**
     * @return The name of the artist
     */
    public String getArtistName()
    {
        return artist;
    }
    
    /**
     * @return The number of tracks in the CD
     */
    public int getNoOfTracks()
    {
        return noOfTracks;
    }
    
    /**
     * Sets the name of the artist
     * @param New name
     */
    public void setArtistName(String newName)
    {
        artist = newName;
    }
    
    /**
     * Sets the number of tracks in the CD
     * @param New number
     */
    public void setNoOfTracks(int newNumber)
    {
        noOfTracks = newNumber;
    }
}