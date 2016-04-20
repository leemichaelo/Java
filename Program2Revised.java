/*******************************************************************************
 * Programmer: Lee-Michael Owen CSC205 Program2 // Date: February 2015 
 * Description: Program that computes compound interest.
 * Input: User enters varies bank info to compute interest.
 * Output: Program computes user info to determine how much interest they would
 *    gain after a period of time, as well as how long it would take to reach 
 *    a goal.
*******************************************************************************/
import java.util.Scanner;

public class Program2Revised {
   public static Scanner userInput = new Scanner( System.in );

   public static void main( String[] args ) {
      //Variables lay outside of do while because they are not always required 
      // to be re-entered.
      System.out
            .println( "This program will predict the growth of a bank account "
                  + "due to compounded interest." );
      System.out.print( "\nEnter Annual Charge: " );
      double annualCharge = checkUserInputDouble( userInput.nextDouble() );
      System.out.print( "Enter Threshold: " );
      double threshold = checkUserInputDouble( userInput.nextDouble() );
      //Boolean used to either continue or end program.
      boolean endProgram = false;
      do {
         //Variables are included in do while because they must always be reentered
         // no matter how many times the program is rerun.
         System.out.print( "Enter Initial Bank Balance: " );
         double initialBalance = checkUserInputDouble( userInput.nextDouble() );
         System.out.print( "Enter Interest Rate: " );
         double interestRate = checkUserInputDouble( userInput.nextDouble() );
         System.out.print(
               "Enter Interest Period(I.E. 1 for daily, 2 for monthly, 3 for yearly: " );
         double interestPeriod = checkUserInputDouble( userInput.nextDouble() );
         String interestPeriodString = "Years";
         if (interestPeriod == 1){
            interestPeriodString = "Days";
         }
         else if (interestPeriod == 2){
            interestPeriodString = "Monthly";
         }
         double periodInterestRate = periodRate( interestRate, interestPeriod );
         double periodProcessingCharge = periodRate( annualCharge,
               interestPeriod );
         //Allows user to choose between two options, length and goal, as well as 
         // end the program prematurely. 
         switch (getMenuSelection()) {
         case '1':
            System.out.print( "How many " + interestPeriodString + " would you like to invest for?" );
            double investmentLength = checkUserInputDouble(
                  userInput.nextDouble() );
            boolean tableRequest = false;
            System.out
                  .print( "Would you like a table with your result? (y/n): " );
            char tableView = checkUserInputChar( userInput.next().charAt( 0 ) );
            System.out.println(  );
            if ( tableView == 'y' || tableView == 'Y' ) {
               tableRequest = true;
            }
            double newBalance = investmentOverTime( investmentLength,
                  initialBalance, periodInterestRate, periodProcessingCharge,
                  threshold, tableRequest );
            System.out.println( "\nYour Bank Balance Would Be: " + String.format( "%.2f", newBalance ) );
            break;
         case '2':
            System.out.print( "What goal would you like to reach?: " );
            investmentLength = checkUserInputDouble(
                  userInput.nextDouble() );
            System.out.println(  );
            tableRequest = false;
            System.out
                  .print( "Would you like a table with your result? (y/n): " );
            tableView = checkUserInputChar( userInput.next().charAt( 0 ) );
            if ( tableView == 'y' || tableView == 'Y' ) {
               tableRequest = true;
            }
            int periodsToReachGoal = investmentGoal( investmentLength,
                  initialBalance, periodInterestRate, periodProcessingCharge,
                  threshold, tableRequest );
            System.out.println( "\nIt would take a total of " + periodsToReachGoal + " peroids to reach your investment goal of " + investmentLength );
            break;
         case '3':
            endProgram = true;
            break;

         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 3...\n" );
            break;
         }
         //Prompt: keep annual charge and threshold.
         System.out.print(
               "\nWould you like to do another calculation? (With the same\n"
                     + " annual charge and threshold? (y/n)" );
         if ( userInput.next().charAt( 0 ) == 'n' ) {
            //Prompt: change annual charge and threshold.
            System.out
                  .print( "Would you like to do another calculation? (With a "
                        + " different\n annual charge and threshold? (y/n)" );
            if ( userInput.next().charAt( 0 ) == 'n' ) {
               endProgram = true;
            }
            //Variables are initialized outside of do while so must be
            // reentered here. 
            else if ( userInput.next().charAt( 0 ) == 'y' ) {
               annualCharge = checkUserInputDouble( userInput.nextDouble() );
               System.out.print( "Enter Threshold: " );
               threshold = checkUserInputDouble( userInput.nextDouble() );
            }
         }
      } while ( !endProgram );
      System.out.println( "\nAplication terminating." );
   }

   public static char getMenuSelection() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Balance after investment length" );
      System.out.println( "\t 2 - Time for balance to reach a goal" );
      System.out.println( "\t 3 - Exit program" );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }
   //Calculates how much money the user will make over a certain ammount
      //of time
   public static double investmentOverTime( double investmentLength,
         double initialBalance, double periodInterestRate,
         double periodProcessingCharge, double threshold,
         boolean tableRequest ) {
      
      double interest = 0;
      int peroidCounter = 1;
      double newBalance = initialBalance;
      
      for ( int loopRun = 0; loopRun < investmentLength; loopRun++ ) {
         interest = newBalance * periodInterestRate;
         newBalance = newBalance + interest;
         if ( newBalance < threshold ) {
            newBalance = newBalance - periodProcessingCharge;
         }
         if ( tableRequest ) {
            System.out.println( "Period " + peroidCounter
                  + " Your new balance: " + String.format( "%.2f", newBalance ) );
            peroidCounter++;
         }
      }
      return newBalance;
   }
   //Calculates how many periods it would take for the user to meet their goal
      //**NOTE** the investmentLength-1 is to account for rounding the decimal
      //places.
   public static int investmentGoal( double investmentLength,
         double initialBalance, double periodInterestRate,
         double periodProcessingCharge, double threshold,
         boolean tableRequest ) {
      
      double interest = 0;
      int peroidCounter = 1;
      double newBalance = initialBalance;
      
      while ( newBalance < investmentLength-1) {
         interest = newBalance * periodInterestRate;
         newBalance = newBalance + interest;
         if ( newBalance < threshold ) {
            newBalance = newBalance - periodProcessingCharge;
         }
         if ( tableRequest ) {
            System.out.println( "Period " + peroidCounter
                  + " Your new balance: " + String.format( "%.2f", newBalance ) );
            peroidCounter++;
         }
      }
      return peroidCounter-1;
   }
   //Divides the users annual rate by the entered period rate.
   public static double periodRate( double periodAmount,
         double interestPeriod ) {
      double periodInterestRate = periodAmount;

      if ( interestPeriod == 1 ) {
         periodInterestRate = periodAmount / 365;
      }
      else if ( interestPeriod == 2 ) {
         periodInterestRate = periodAmount / 12;
      }
      return periodInterestRate;
   }
   //Checks to ensure the user entered a number within the given range.
   public static double checkUserInputDouble( double checkInput ) {
      while ( checkInput < 0 ) {
         System.out
               .print( "Invalid number entered, please enter a positive number "
                     + "1..20..300..: " );
         checkInput = userInput.nextDouble();
      }
      return checkInput;
   }
   //Checks to ensure the user entered a character withing the given range.
   public static char checkUserInputChar( char checkInput ) {
      while ( checkInput != 'y') {
         System.out.print(
               "Invalid character entered, please try again... " + "y\n: " );
         checkInput = userInput.next().charAt( 0 );
      }
      return checkInput;
   }
}
