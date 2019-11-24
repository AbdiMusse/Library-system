import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * This is the Library Class that reporesents an actual library
 * It brings together all classes to perform several tasks such as 
 * reading/writing data from/to a file and making reservations.
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class Library
{
    private Map <String, LibraryItem> itemsMap;
    private Map <String, LibraryUser> userMap;
    private Map <String, ItemReservation> itemReservationMap;
    private HashSet<String> userIDs;
    private String fileName;
    private File dataFile;
    private Random random;
    private int totalUsers;
    private int newReservationNo;
    private Diary diary; 
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        itemsMap = new HashMap<String, LibraryItem>();
        userMap = new HashMap<String, LibraryUser>();
        itemReservationMap = new HashMap<String, ItemReservation>();
        userIDs = new HashSet<String>();
        fileName = null;
        dataFile = null;
        random = new Random();
        totalUsers = 0;
        newReservationNo = 1;
        diary = new Diary();
    }
    
    //Section 1 (Storing data)
    /**
     * Stores objects of LibraryItem to the HashMap
     * It can also store objects of its sub-type
     */
    private void storeLibraryItem(LibraryItem libraryItem)
    {
        itemsMap.put(libraryItem.getItemCode(), libraryItem);
    }
    
    /**
     * Stores objects of LibraryUser to the HashMap
     * It also gives the user a unique ID
     */
    private void storeLibraryUser(LibraryUser libraryUser)
    {
        if (libraryUser.getUserID().equals("unknown"))
        {
            libraryUser.setUserID(generateUserID("AB-"));
        }
        userMap.put(libraryUser.getUserID(), libraryUser);
    }
    
    /**
     * Stores objects of ItemReservation to the HashMap
     * It also add a reservation to the dairy class
     */
    private void storeItemReservation(ItemReservation itemReservation)
    {
        itemReservationMap.put(itemReservation.getReservationNo(), itemReservation);
        diary.addReservation(itemReservation);
    }
    
    //Section 2 (reading and writing data)
    /**
     * This method calls 2 other methods. One makes the FileDialog Box
     * appear and the other reads data from a file and store it in a HashMap
     */
    public void readData()
    {
        openDialog();
        readDataImplemnt();
    }
    
    /**
     * Allows us to open the fileDialog box
     * it also stores the full-name of the file in a field
     */
    private void openDialog()
    {
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame, "open", FileDialog.LOAD);
        fileBox.setVisible(true);
        String fullFileName = fileBox.getDirectory() + fileBox.getFile();
        fileName = fullFileName;
        dataFile = new File(fileName);
    }
    
    /**
     *  Reads data from a file through user input
     *  and stores it in the appropriate HashMap (used in test class)
     */
    public void readData(String file)
    {
        fileName = "Read-Write\\" + file;
        dataFile = new File(fileName);
        readDataImplemnt();
    }
    
    /**
     * Reads data from a file and stores it in the appropriate HashMap
     */
    private void readDataImplemnt()
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(dataFile);
        }
        catch (FileNotFoundException ex) {
            System.err.println("*** FileNotFoundException ***");
            System.err.println("The data file you have chosen does not exist");
            System.err.println("Please try again");
            fileName = null;
        }
        if ( scanner != null) {
            Scanner newScanner = null; 
            String typeOfData = null;
            LibraryItem li = null;
            while ( scanner.hasNextLine() ) {
                   String lineOfText = scanner.nextLine().trim();
                   if ( (! lineOfText.startsWith("//")) && (! lineOfText.isEmpty()) )
                   {
                       if (lineOfText.startsWith("[")) {
                           if (lineOfText.equalsIgnoreCase("[cd data]")) {
                               typeOfData = "cd data";
                           }
                           else if (lineOfText.equalsIgnoreCase("[dvd data]")) {
                               typeOfData = "dvd data";
                           }
                           else if (lineOfText.equalsIgnoreCase("[book data]")) {
                               typeOfData = "book data";
                           }
                           else if (lineOfText.equalsIgnoreCase("[periodical data]")) {
                               typeOfData = "periodical data";
                           }
                           else if (lineOfText.equalsIgnoreCase("[Library User Data]")) {
                               typeOfData = "Library User Data";
                           }
                           else {
                               typeOfData = "unknown data";
                           }
                       }
                       else {
                           newScanner = new Scanner(lineOfText);
                           newScanner.useDelimiter("[ ]*,[ ]*");
                           if (typeOfData.equals("cd data")) {
                               li = new CD();
                            }
                            else if (typeOfData.equals("dvd data")) {
                                li = new DVD();
                            }
                            else if (typeOfData.equals("book data")) {
                                li = new Book();
                            }
                            else if (typeOfData.equals("periodical data")) {
                                li = new Periodical();
                            }
                            else if (typeOfData.equals("Library User Data")) {
                                LibraryUser lu = new LibraryUser();
                                lu.extractData(newScanner);
                                storeLibraryUser(lu);
                            }
                            else if (typeOfData.equals("unknown data")) {
                                System.out.println("Unknown data.");
                            }
                           if (li != null) {
                               li.extractData(newScanner);
                               storeLibraryItem(li);
                               li = null;
                           }
                       }
                   }
            }
            newScanner.close();
            scanner.close();
        }
    }
    
    /**
     * Writes the data of library_user_data.txt to a file
     * Name and location of the file is chosen through the dialog Box
     */
    public void writeUserData()
    {
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame, "save", FileDialog.SAVE);
        fileBox.setVisible(true);
        String fullFileName = fileBox.getDirectory() + fileBox.getFile();
        PrintWriter pWriter = null;
        LibraryUser libraryUser = new LibraryUser();
        try {
            pWriter = new PrintWriter(fullFileName);
        }
        catch (FileNotFoundException ex) {
            System.err.println("*** FileNotFoundException ***");
            System.err.println("No file to write the data on");
            System.err.println("Please try again");
        }
        if (pWriter != null)
        {
            pWriter.println("// this is a comment, any lines that start with //");
            pWriter.println("// (and blank lines) should be ignored");
            pWriter.println("");
            pWriter.println("// New user data");
            pWriter.println("// data is customerID, surname, firstName, otherInitials, title");
            pWriter.println("");
            pWriter.println("[Library User Data]");
            pWriter.println("");
            for (LibraryUser lu : userMap.values())
            {
                lu.writeData(pWriter);
            }
            pWriter.close();
        }
    }
    
    /**
     * Reads a data from a file containing itemReservation 
     * details and stores it in the appropriate HashMap
     */
    public void readItemReservationData()
    {
        openDialog();
        Scanner scanner = null;
        try {
            scanner = new Scanner(dataFile);
        }
        catch (FileNotFoundException ex) {
            System.err.println("*** FileNotFoundException ***");
            System.err.println("The data file you have chosen does not exist");
            System.err.println("Please try again");
            fileName = null;
        }
        if ( scanner != null) {
            Scanner newScanner = null; 
            while ( scanner.hasNextLine() ) {
                String lineOfText = scanner.nextLine().trim();
                if ( (! lineOfText.startsWith("//")) && (! lineOfText.isEmpty()) && (! lineOfText.startsWith("[")))
                {
                    newScanner = new Scanner(lineOfText);
                    newScanner.useDelimiter("[ ]*,[ ]*");
                    ItemReservation itemReservation = new ItemReservation();
                    itemReservation.readData(newScanner);
                    storeItemReservation(itemReservation);
                }
            }
        }
    }
    
    /**
     * Writes data of ItemReservation to a file chosen by the user
     */
    public void writeItemReservationData(String fullFileName) 
    {
        fileName = "Read-Write\\" + fullFileName;
        //Frame myFrame = null;
        //FileDialog fileBox = new FileDialog(myFrame, "save", FileDialog.SAVE);
        //fileBox.setVisible(true);
        //String fullFileName = fileBox.getDirectory() + fileBox.getFile();
        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(fullFileName);
        }
        catch (FileNotFoundException ex) {
            System.err.println("*** FileNotFoundException ***");
            System.err.println("No file to write the data on");
            System.err.println("Please try again");
        }
        if (pWriter != null)
        {
            pWriter.println("// New user data");
            pWriter.println("// data is reservationID, itemCode, userID, startDate, noOfDays");
            pWriter.println("");
            pWriter.println("[Item Reservation data]");
            pWriter.println("");
            for (ItemReservation itemReservation : itemReservationMap.values())
            {
                itemReservation.writeData(pWriter);
            }
            pWriter.close();
        }
    }
    
    //Section 3 (Generation UserID)
    /**
     * Generates a unique random number for the user ID
     */
    public String generateUserID(String prefix)
    {
        String number = createRandomNumber(prefix); //method is below
        userIDs.add(number);  //store in a HashSet
        
        boolean added = false;
        while (added == false) {
            if (userIDs.size() == totalUsers) {
                number = createRandomNumber(prefix);
                userIDs.add(number);
            }
            else {
                totalUsers++;
                added = true;
            }
        }
        return number;
    }
    
    /**
     * Generates a random number with a specified prefix
     */
    private String createRandomNumber(String prefix)
    {
        int lenght = 6; String number = prefix;
        for (int i = 0; lenght > i; i++)
        {
            number += random.nextInt(10);
        }
        return number;
    }
    
    //Section 4 (To do with reservations)
    /**
     * Gives each reservation an id which is different
     * It also writes that number to a file
     * @return the reservation number
     */
    public String generateReservationNo()
    {
        int number = newReservationNo;
        String zero = "0";
        String stringNum = number + ""; //Change int to String to get length
        while (stringNum.length() != 6)
        {
            stringNum = zero+stringNum;
        }
        String fileName = "Read-Write\\number.txt";
        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(fileName);
        }
        catch (FileNotFoundException ex) {
            System.err.println("*** FileNotFoundException ***");
            System.err.println("No file to write the data on");
            System.err.println("Please try again");
        }
        if (pWriter != null)
        {
            pWriter.println(stringNum);
            pWriter.close();
        }
        
        newReservationNo++;
        return stringNum;
    }
    
    /**
     * Allows the user to make a reservation
     * Has several checks to make sure that the information given is correct
     * Also checks if the item is already reserved
     */
    public boolean makeItemReservation(String userID, String itemCode, String startDate, int noOfDays)
    {
        if (! userMap.containsKey(userID) ) {
            System.out.println("The user " + userID + " does not exist.");
            return false;
        }
        else if (! itemsMap.containsKey(itemCode) ) {
            System.out.println("The item Code " + itemCode + "does not exist.");
            return false;
        }
        else if ( DateUtil.isValidDateString(startDate) == false ) {
            System.out.println("The date formatting was wrong.");
            return false;
        }
        else if (noOfDays <= 0) {
            System.out.println("you can't reseve for "+noOfDays+ " days.");
            return false;
        }
        
        else {
            Date date = DateUtil.convertStringToDate(startDate);
            for(int day=1; day <= noOfDays; day++)
            {
                if (diary.getReservations(date) != null )
                {
                    System.out.println("Item "+itemCode+" Can't be reserved on "+startDate);
                    return false;
                }
                date = DateUtil.nextDate(date);
            }
      
            String number = generateReservationNo();
            ItemReservation itemReservation = new ItemReservation(number,itemCode,userID,startDate,noOfDays);
            
            storeItemReservation(itemReservation);
            return true;
        }
    }
    
    /**
     * Deletes the corresponding reservation from the reservation system 
     * @param reservation number which is to be deleted
     */
    public void deleteItemReservation(String reservationNo)
    {
        if (itemReservationMap.containsKey(reservationNo))
        {
            ItemReservation itemReservation = itemReservationMap.get(reservationNo);
            diary.deleteReservation(itemReservation);
            itemReservationMap.remove(reservationNo);
            System.out.println("Resevation number "+reservationNo+" has been removed from the system.");
        }
        else {
            System.out.println("Resevation number "+reservationNo+" does not exist.");
        }
    }
    
    //Section 5 (print Statments)
    /**
     * Prints out the details of the Objects held in the HashMap
     */
    public void printAllDetails()
    {
        if(itemsMap.isEmpty() && userMap.isEmpty()) {
            System.out.println("Both the itemsMap and the userMap are empty.\n");
        }
        else {
            if (itemsMap.isEmpty()) {
                System.out.println("The itemsMap is empty.\n");
            }
            else {
                System.out.println("[libraryItem Objects] \n");
                for (LibraryItem libraryItem : itemsMap.values())
                {
                    libraryItem.printDetails();
                    System.out.println();  //empty line between each object
                }
                System.out.println("The  itemsMap is now holding " + itemsMap.size() + " object.");
            }
            if (userMap.isEmpty()) {
                System.out.println("The userMap is empty.\n");
            }
            else {
                System.out.println("[libraryUser Objects] \n");
                for (LibraryUser libraryUser : userMap.values())
                {
                    libraryUser.printDetails();
                    System.out.println();  //empty line between each object
                }
                System.out.println("The  userMap is now holding " + userMap.size() + " object.");
            }
        }
    }
    
    /**
     * Prints out the details of the itemReservation Objects held in the HashMap
     */
    public void printItemReservations()
    {
        if (itemReservationMap.isEmpty()) {
            System.out.println("The itemReservationMap is empty.");
        }
        else {
            System.out.println("[itemReservation Objects] \n");
            for (ItemReservation itemReservation : itemReservationMap.values()){
                itemReservation.printDetails();
                System.out.println();       //empty line between each object
            }
            System.out.println("The  itemReservationMap is now holding " + itemReservationMap.size() + " object.");
        }
    }
    
    /**
     * Shows you everything that is reserved between two dates
     */
    public void printDiaryEntries(String startDate, String endDate)
    {
        diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
    }
    
    //Section 6 (accessor methods)
    /**
     * @return Name of the file that is selected
     */
    public String getFileName()
    {
        return fileName;
    }
    
    /**
     * @return Number of users who have ID
     */
    public int getTotalUsers()
    {
        return totalUsers;
    }
    
    /**
     * @return Number of the next avilable reservation number
     */
    public int getNewReservationNo()
    {
        return newReservationNo;
    }
    
    /**
     * @param itemCode which is the key of the HashMap
     * @return LibraryItem object with the specified item code
     */
    public LibraryItem getItem(String itemCode)
    {
        return itemsMap.get(itemCode);
    }
    
    /**
     * @param customerID which is the key of the HashMap
     * @return LibraryUser object with the specified customer ID
     */
    public LibraryUser getUser(String customerID)
    {
        return userMap.get(customerID);
    }
    
    /**
     * @param reservationNo which is the key of the HashMap
     * @return ItemReservation object with the specified reservation number
     */
    public ItemReservation getItemReservation(String reservationNo)
    {
        return itemReservationMap.get(reservationNo);
    }
}