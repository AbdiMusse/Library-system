import java.util.Date;
/**
 * This is a test class to test if everything works as it should
 *
 * @author Abdi-rahman Musse
 * @version 4.6
 */
public class Main
{
    public Main()
    {
        //This creates a Library object called library
        Library library = new Library();
        
        //Generate a unique user ID
        String id_number = library.generateUserID("AB-");
        System.out.println(id_number+" is a unique 6-digit userID number.\n");
        
        //This reads a file using a String and stores the information in a HashMap
        library.readData("items_all.txt");
        //This prints out the name of the file
        System.out.println("You have selected the file: " + library.getFileName() + "\n");
        //Gets an item and prints out the details of that item
        LibraryItem li = library.getItem("LM003604");
        li.printDetails();
        
        //This reads a file using a String and stores the information in the ArrayList
        library.readData("users_with_id.txt");
        //This prints out the name of the file
        System.out.println("\nYou have selected the file: " + library.getFileName() + "\n");
        //Prints out the details of a user
        LibraryUser lu = library.getUser("AB-117599");  //Pre-made userID
        lu.printDetails();
        
        //prints out the number of days between the two dates that I have chosen 
        Date date1 = DateUtil.convertStringToDate("25-04-2018");
        Date date2 = DateUtil.convertStringToDate("18-05-2018");
        int daysBetween = DateUtil.daysBetween(date1, date2);
        System.out.println("\n"+daysBetween+" days between the two dates you I have chosen.\n");
        
        
        //Shows that the generateReservationNo() produces sequential numbers
        System.out.println("(sequentially generated reservation numbers)");
        int numberOfTimes = 5; String reservation_number = null;
        for (int i = 0; numberOfTimes > i; i++)
        {
            reservation_number = library.generateReservationNo();
            System.out.print(reservation_number+"\t");
        }
        System.out.println("\n");
        
        //Makes some successful and unsuccessful reservations and then print them out
        library.makeItemReservation("AB-117599","LM003553","10-06-2018",5);
        library.makeItemReservation("AB-800970","LM003873","13-06-2018",3);
        library.makeItemReservation("AB-838601","LM003553","13-06-2018",7);
        System.out.println();
        library.printItemReservations();
        //Write the successful reservations to a file 
        library.writeItemReservationData("Read-Write\\item_reservation.txt"); 
        //Prints all reservations between two given days
        library.printDiaryEntries("08-06-2018", "17-06-2018");
        System.out.println("=================================================================\n");
        //
        library.deleteItemReservation("000006");
        library.printItemReservations();
    }
}