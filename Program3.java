
/*******************************************************************************
 * Programmer: Lee-Michael Owen CSC205 Program3 // Date:
 * February 22, 2016 Description: Sequential File Processing
 * and Arrays of Recrds (Terms in program are defined as
 * movie data) Input: User selects data to view and or to
 * quiz themselves on records from a text file. Output: an
 * Array of data in either record form and or as a
 * histogram.
 *******************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DataFile {
   public String     _movieName;
   public String     _directorName;
   public int        _moneyMade;
   public int        _movieBudget;
};
public class Program3 {

   public static Scanner userInput = new Scanner( System.in );

   public static void main( String[] args ) throws FileNotFoundException {
      // Builds array
      DataFile[] movieData = new DataFile [100];
      int dataSize = buildArray(movieData);
      boolean done = false;
      // Programs main menu
      do {
         switch (getMenuSelection()) {
         case '1':
            displayData( movieData, dataSize );
            break;
         case '2':
            userSelection( movieData, dataSize );
            break;
         case '3':
            giveQuiz( movieData, dataSize );
            break;
         case '4':
            displayHistogram( movieData, dataSize );
            break;
         case '5':
            done = true;
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 4...\n" );
            break;
         }
      } while ( !done );
      System.out.println( "Aplication terminating." );
   }

   // Builds array based on inputed text files
   private static int buildArray(DataFile[] movieData) {
      String fileName = "C:/Users/LeeMi/Desktop/LeeDataFile.txt";
      int arrayFilled = 0;
      Scanner scanFile;
      // ensures that there is a text file to be read
      try {
         File textFile = new File( fileName );
         scanFile = new Scanner( textFile );
         // Will keep checking text file for more data until
         // EOF string is caught
         do{
            movieData[arrayFilled] = new DataFile();
            movieData[arrayFilled]._movieName = scanFile.next();
            movieData[arrayFilled]._directorName = scanFile.next();
            movieData[arrayFilled]._moneyMade = scanFile.nextInt();
            movieData[arrayFilled]._movieBudget = scanFile.nextInt();
            arrayFilled++;
         }
         while ( movieData[arrayFilled - 1]._moneyMade!= 0); {
            arrayFilled--;
         }
         }
      catch (FileNotFoundException e) {
         System.out.println( "File Not Found" );
      }
      
      return arrayFilled;
   }

   // Method prints out data records in groups of ten and
   // will wait until
   // user is ready to read the next ten.
   private static void displayData( DataFile[] movieData, int dataSize ) {
      int howManyHaveBeenShown = 0;
      System.out.println( String.format( "\nMovie Name"
            + "                         Director Name"
            + "                      Money Made"
            + "           Movie Budget" ));
      for (int loopRun = 0; loopRun < dataSize; loopRun++){
         if(howManyHaveBeenShown%10 == 0 && howManyHaveBeenShown > 0){
            System.out.print( "\nDisplaying " + howManyHaveBeenShown + " of " + dataSize +", enter any key to continue. " );
            userInput.next();
            System.out.println(  );
         }
         howManyHaveBeenShown++;
         String movieSpaces = "";
         String directorSpaces = "";
         String profitSpaces = "";
         if ( movieData[loopRun]._movieName.length() < 35 ) {
            for ( int innerLoopRun = 0; innerLoopRun < (35
                  - movieData[loopRun]._movieName.length()); innerLoopRun++ ) {
               movieSpaces += " ";
            }
            if ( movieData[loopRun]._directorName.length() < 35 ) {
               for ( int innerLoopRun = 0; innerLoopRun < (35
                     - movieData[loopRun]._directorName.length()); innerLoopRun++ ) {
                  directorSpaces += " ";
               }
            }
            if (movieData[loopRun]._moneyMade > 1000000000){
               profitSpaces = "           ";
            }
            else if (movieData[loopRun]._moneyMade < 1000000000 && movieData[loopRun]._moneyMade > 100000000){
               profitSpaces = "            ";
            }
            else if (movieData[loopRun]._moneyMade < 100000000 && movieData[loopRun]._moneyMade > 10000000){
               profitSpaces = "             ";
            }
         }
         String stringToReturn = String
               .format( movieData[loopRun]._movieName + movieSpaces + movieData[loopRun]._directorName + directorSpaces
                     + movieData[loopRun]._moneyMade + profitSpaces + movieData[loopRun]._movieBudget );
         System.out.println( stringToReturn ); 
      }
      System.out.print( "\nDisplaying " + howManyHaveBeenShown + " of " + dataSize +", enter any key to return to the main menu. " );
      userInput.next();
   }
   // Allows user to select a record and then displays any
   // other information associated with it within the index
   private static void userSelection( DataFile[] movieData, int dataSize ) {
      int timesScanned = 0;
      int movieNotFound = -1;
      System.out.print(
            "\nWhat movie from the Movie Data File would you like information on? " );
      String movieName = userInput.next();
         for ( int loopRun = 0; loopRun < dataSize; loopRun++ ) {
            timesScanned++;
            System.out.println( timesScanned );
            if ( movieName.equalsIgnoreCase( movieData[loopRun]._movieName ) ) {
               System.out.println( String.format(
                     "\nMovie Name" + "                         Director Name"
                           + "                      Money Made"
                           + "           Movie Budget" ) );
               String movieSpaces = "";
               String directorSpaces = "";
               String profitSpaces = "";
               if ( movieData[loopRun]._movieName.length() < 35 ) {
                  for ( int innerLoopRun = 0; innerLoopRun < (35
                        - movieData[loopRun]._movieName
                              .length()); innerLoopRun++ ) {
                     movieSpaces += " ";
                  }
                  if ( movieData[loopRun]._directorName.length() < 35 ) {
                     for ( int innerLoopRun = 0; innerLoopRun < (35
                           - movieData[loopRun]._directorName
                                 .length()); innerLoopRun++ ) {
                        directorSpaces += " ";
                     }
                  }
                  if ( movieData[loopRun]._moneyMade > 1000000000 ) {
                     profitSpaces = "           ";
                  }
                  else if ( movieData[loopRun]._moneyMade < 1000000000
                        && movieData[loopRun]._moneyMade > 100000000 ) {
                     profitSpaces = "            ";
                  }
                  else if ( movieData[loopRun]._moneyMade < 100000000
                        && movieData[loopRun]._moneyMade > 10000000 ) {
                     profitSpaces = "             ";
                  }
               }
               String stringToReturn = String
                     .format( movieData[loopRun]._movieName + movieSpaces
                           + movieData[loopRun]._directorName + directorSpaces
                           + movieData[loopRun]._moneyMade + profitSpaces
                           + movieData[loopRun]._movieBudget );
               System.out.println( stringToReturn );
               movieNotFound = 1;
               loopRun = dataSize;
            }
         }
      if ( movieNotFound == -1 ) {
         System.out.println( "\n***Error: Movie Not Found***" );
      }
      System.out.print( "\nEnter any key to return to the main menu. " );
      userInput.next();
   }

   // Gives the user a test of the record data by asking
   // them who directed each movie that is asked.
   // User may end the test early by entering END
   // Either by user termination, or end of quiz,
   // information will be displayed telling
   // the User how many answers they got right or wrong
   private static void giveQuiz( DataFile[] movieData, int dataSize ) {
      boolean keepQuizzing = true;
      String usersAnswer = "";
      String endQuiz = "end";
      int answersRight = 0;
      int answersWrong = 0;
      int loopRun = 0;
      System.out.println(
            "\nQuiz time! If you wish to end the quiz before the end, enter END instead of an answer for any question." );
      while ( keepQuizzing ) {
         System.out.print( "\n" + movieData[loopRun]._movieName
               + " was directed by whom? " );
         usersAnswer = userInput.next();
         if ( usersAnswer.equalsIgnoreCase( endQuiz ) ) {
            keepQuizzing = false;
            System.out.println( "Ending Quiz" );
         }
         else if ( usersAnswer
               .equalsIgnoreCase( movieData[loopRun]._directorName ) ) {
            System.out.println( "Your answer was correct!" );
            answersRight++;
         }
         else {
            System.out.println( "\nYour answer was incorrect!" );
            System.out.println( "The correct answer was: " + movieData[loopRun]._directorName );
            answersWrong++;
         }
         loopRun++;
         if ( loopRun > movieData.length - 1 ) {
            keepQuizzing = false;
            System.out.println( "\nYou have reached the end of the quiz!" );
         }
      }
      System.out.println( "You had " + answersRight + " correct and "
            + answersWrong + " wrong." );
   }

   // Gathers parameters based on record variables into
   // order to break up a field of ints within
   // the data. Creates a histogram based on the data by
   // breaking it up into groups and then
   // counts how many fall within each group.
   private static void displayHistogram( DataFile[] movieData, int dataSize ) {
      int moneyMin = getMoneyMin( movieData, dataSize );
      int moneyMax = getMoneyMax( movieData, dataSize );
      int decadeRange = moneyMax - moneyMin;
      double decadeWidth = Math.ceil( decadeRange / 10);
      int temp[] = new int[dataSize-1];
      for ( int loopRun = 0; loopRun < dataSize; loopRun++ ) {
         int decade = (int) (movieData[loopRun]._moneyMade / decadeWidth);
         temp[decade] += 1;
      }
      System.out.println( "Displaying Histogram for Money Made" );
      System.out.println( "\nDecade:         Count:" );
      long temp2 = 0;
      for ( int loopRun = 0; loopRun < temp.length; loopRun++ ) {
         if ( temp2 <= moneyMax ) {
            temp2 += decadeWidth;
            System.out.print( temp2 + "               " + temp[loopRun] + " " );
            for ( int loopRunInner = 0; loopRunInner < temp[loopRun]; loopRunInner++ ) {
               System.out.print( "*" );
            }
            System.out.println();
         }
      }
   }

   private static int getMoneyMin( DataFile[] movieData, int dataSize ) {
      int moneyMin = movieData[0]._moneyMade;
      for ( int loopRun = 0; loopRun < dataSize; loopRun++ ) {
         if ( movieData[loopRun]._moneyMade < moneyMin ) {
            moneyMin = movieData[loopRun]._moneyMade;
         }
      }
      return moneyMin;
   }

   private static int getMoneyMax( DataFile[] movieData, int dataSize ) {
      int moneyMax = movieData[0]._moneyMade;
      for ( int loopRun = 0; loopRun < dataSize; loopRun++ ) {
         if ( movieData[loopRun]._moneyMade > moneyMax ) {
            moneyMax = movieData[loopRun]._moneyMade;
         }
      }
      return moneyMax;
   }

   // Present menu and get a selection from the user
   public static char getMenuSelection() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Display Movie Data " );
      System.out.println( "\t 2 - Select A Movie To Display " );
      System.out.println( "\t 3 - Take A Movie Quiz " );
      System.out.println( "\t 4 - Display Movie Histogram " );
      System.out.println( "\t 5 - Exit program" );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }
}
