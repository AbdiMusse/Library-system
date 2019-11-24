import java.util.*;
/**
 * This is a superClass of CD and DVD
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public abstract class AudioVisual extends LibraryItem
{
    private int playTime;
    /**
     * Constructor for creating an empty AudioVisual object
     */
    public AudioVisual()
    {
        super();
        playTime = 0;
    }
    
    /**
     * Extracts data from a file
     * @param Scanner is used in the library Class
     */
    public void extractData(Scanner scanner)
    {
        playTime = scanner.nextInt();
        super.extractData(scanner);
    }
    
    /**
     * Prints out the details of each object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Play time: " + playTime + " minutes");
    }
    
    /**
     * @return The play time in minutes
     */
    public int getPlayTime()
    {
        return playTime;
    }
    
    /**
     * Set the play time in minutes
     * @param new time
     */
    public void setPlayTime(int newTime)
    {
        playTime = newTime;
    }
}