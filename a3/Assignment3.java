// Assignment #: 3
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: 10:30, tuesday thursday 
// Description: This class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.
import java.util.*;
public class Assignment3
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String movieName, nameOfDirector, lead, genre, ratingStr, yearStr;
       int rating, year;
       String line = new String();
       // instantiate a Movie object
       Movie movie1 = new Movie();
       printMenu();
       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);
       do  // will ask for user input
        {
            System.out.print("\nWhat action would you like to perform?\n");
            line = scan.nextLine();
            if (line.length() == 1)
            {
                input1 = line.charAt(0);
                input1 = Character.toUpperCase(input1);
                // matches one of the case statement
                switch (input1)
                {
                    case 'A':   //Add Movie
                        System.out.print("\nPlease enter the Movie information: ");
                        System.out.print("\nEnter the Movie name: ");
                        movieName = scan.nextLine();
                        movie1.setMovieName(movieName);
                        System.out.print("\nEnter the year of the movie: ");
                        yearStr = scan.nextLine();
                        year = Integer.parseInt(yearStr);
                        movie1.setYear(year);
                        System.out.print("\nEnter the name of Director: ");
                        nameOfDirector = scan.nextLine();
                        movie1.setNameOfDirector(nameOfDirector);
                        System.out.print("\nEnter its Lead actor/actress: ");
                        lead = scan.nextLine();
                        System.out.print("\nEnter its Genre: ");
                        genre = scan.nextLine();
                        System.out.print("\nEnter its Rating: ");
                        ratingStr = scan.nextLine();
                        rating = Integer.parseInt(ratingStr);
                        movie1.setSummary(lead, genre, rating);
                        break;
                    case 'D':   //Display Movie
                        System.out.print(movie1);
                        break;
                    case 'Q':   //Quit
                        break;
                    case '?':   //Display Menu
                        printMenu();
                        break;
                    default:
                        System.out.print("\nUnknown action");
                        break;
                }
          }
         else
          {
              System.out.print("\nUnknown action");
          }
        } while (input1 != 'Q' || line.length() != 1);
   }
  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Movie\n" +
                        "D\t\tDisplay Movie\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}