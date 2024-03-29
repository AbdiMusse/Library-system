import java.util.Date;
import java.util.Scanner;
import java.io.*;
/**
 * This Class allows a library user to borrow an item for a specified period 
 *
 * @author Abdi-rahman Musse 
 * @version 4.6
 */
public class ItemReservation
{
    private String reservationNo ;
    private String itemCode;
    private String userID;
    private Date startDate;
    private int noOfDays;
    /**
     * Constructor for objects of class ItemReservation
     */
    public ItemReservation(String reservationNo, String itemCode, String userID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemCode = itemCode;
        this.userID = userID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    /**
     * Constructor for creating an empty ItemReservation object
     */
    public ItemReservation()
    {
        reservationNo = null;
        itemCode = null;
        userID = null;
        startDate = null;
        noOfDays = 0;
    }
    
    /**
     * Reads data from a file
     * @param Scanner is used in the library Class
     */
    public void readData(Scanner scanner)
    {
        reservationNo = scanner.next();
        itemCode = scanner.next();
        userID = scanner.next();
        String date = scanner.next();
        startDate = DateUtil.convertStringToDate(date);
        noOfDays = scanner.nextInt(); 
    }
    
    /**
     * Writes the data that is held by the object to a file
     * @param PrintWriter is used in the library Class
     */
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(reservationNo+", "+itemCode+", "+userID+", "
        +DateUtil.convertDateToShortString(startDate)+", "+noOfDays);
    }
    
    /**
     * Prints out the details of the ItemReservation object
     */
    public void printDetails()
    {
        System.out.println("Reservation Number: " + reservationNo);
        System.out.println("Item code: " + itemCode);
        System.out.println("User ID: " + userID);
        System.out.println("Start Date: " + DateUtil.convertDateToShortString(startDate));
        System.out.println("Duration of the reservation : " + noOfDays);
    }
    
    /**
     * @return A string combining the reservationNo, customerId and itemID in an easily readable form 
     */
    public String toString()
    {
        return  "Reservation number: " + reservationNo +
                ", Customer ID: "+ userID +
                ", Item ID: " + itemCode;
    }
    
    /**
     * @return The reservation number of the item
     */
    public String getReservationNo()
    {
        return reservationNo;
    }
    
    /**
     * @return The item code of the item
     */
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * @return The user ID of the person making the reservation
     */
    public String getUserID()
    {
        return userID;
    }
    
    /**
     * @return The Date object that holds reference to the start date
     */
    public Date getStartDate()
    {
        return startDate;
    }
    
    /**
     * @return The number of days the item will be reserved for
     */
    public int getNoOfDays()
    {
        return noOfDays;
    }
    
    /**
     * Set the reservation number of the item
     * @param new reservation number
     */
    public void setReservationNo(String newNumber)
    {
        reservationNo = newNumber;
    }
    
    /**
     * Set the item code of the item
     * @param new item code
     */
    public void setItemCode(String newItemCode)
    {
        itemCode = newItemCode;
    }
    
    /**
     * Set the user ID of the person making the reservation
     * @param new user ID
     */
    public void setUserID(String newUserID)
    {
        userID = newUserID;
    }
    
    /**
     * Set the start date
     * @param new start date (formatting should be of short date pattern style)
     */
    public void setStartDate(String newStartDate)
    {
        startDate = DateUtil.convertStringToDate(newStartDate);
    }
    
    /**
     * Set the number of days the item will be reserved for
     * @param new number of days
     */
    public void setNoOfDays(int newNoOfDays)
    {
        noOfDays = newNoOfDays;
    }
}