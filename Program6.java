/*******************************************************************************
 * Programmer: Lee-Michael Owen CSC205 Program 6 // Date: April 2016 
 * Description: Program that supports uses four priority queues to manage
 *    priorities for two name queues and two flight queues.
 * Input: User chooses between two teams to manipulate flight/name
 *    information.
 * Output: Displays information either deleted or inserted into the priority
 *    queues.
*******************************************************************************/
import java.util.Scanner;

public class Program6 {
   public static Scanner userInput = new Scanner( System.in );

   public static void main( String[] args ) {
      PriorityQueue nameA = new PriorityQueue();
      PriorityQueue nameB = new PriorityQueue();
      PriorityQueue flightC = new PriorityQueue();
      PriorityQueue flightD = new PriorityQueue();

      boolean done = false;
      do {
         System.out
               .println( "**Application to Manipulate Four Priority Queues**" );
         System.out
               .println( "**Select (A) to Manipulate Name Priority Queue A**" );
         System.out
               .println( "**Select (B) to Manipulate Name Priority Queue B**" );
         System.out.println(
               "**Select (C) to Manipulate Flight Priority Queue A**" );
         System.out.println(
               "**Select (D) to Manipulate Flight Priority Queue B**" );
         System.out
               .println( "-------------------------------------------------" );
         char queueToUse = userInput.next().charAt( 0 );
         switch (getMenuSelection()) {
         // Insertion method calls
         case '1':
            if ( queueToUse == 'A' || queueToUse == 'a' ) {
               insertName( nameA );
            }
            else if ( queueToUse == 'B' || queueToUse == 'b' ) {
               insertName( nameB );
            }
            else if ( queueToUse == 'C' || queueToUse == 'c' ) {
               insertFlight( flightC );
            }
            else if ( queueToUse == 'D' || queueToUse == 'd' ) {
               insertFlight( flightD );
            }
            else
               System.out.println( "You selected: " + queueToUse );
            break;
         // Deletion method calls
         case '2':
            if ( queueToUse == 'A' || queueToUse == 'a' ) {
               delete( nameA );
            }
            else if ( queueToUse == 'B' || queueToUse == 'b' ) {
               delete( nameB );
            }
            else if ( queueToUse == 'C' || queueToUse == 'c' ) {
               delete( flightC );
            }
            else if ( queueToUse == 'D' || queueToUse == 'd' ) {
               delete( flightD );
            }
            else
               System.out.println( "You selected: " + queueToUse );
            break;
         // Print calls
         case '3':
            if ( queueToUse == 'A' || queueToUse == 'a' ) {
               System.out.println( nameA );
            }
            else if ( queueToUse == 'B' || queueToUse == 'b' ) {
               System.out.println( nameB );
            }
            else if ( queueToUse == 'C' || queueToUse == 'c' ) {
               System.out.println( flightC );
            }
            else if ( queueToUse == 'D' || queueToUse == 'd' ) {
               System.out.println( flightD );
            }
            else
               System.out.println( "You selected: " + queueToUse );
            break;
         // Begins heap sort menu
         case '4':
            heapSort();
            break;
         case '5':
            done = true;
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 4...\n" );
         }
      } while ( !done );
      System.out.println( "Aplication terminating." );
   }

   public static char getMenuSelection() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Insert " );
      System.out.println( "\t 2 - Delete " );
      System.out.println( "\t 3 - Print " );
      System.out.println( "\t 4 - Heap Sort " );
      System.out.println( "\t 5 - Quit " );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

   public static void insertName( PriorityQueue queueToInsertTo ) {
      String firstName = "";
      String lastName = "";
      System.out.println( "What is the first name?" );
      firstName = userInput.next();
      System.out.println( "What is the last name?" );
      lastName = userInput.next();
      Name newName = new Name( firstName, lastName );
      queueToInsertTo.insertion( newName );
      System.out
            .println( firstName + " " + lastName + " was added to the queue." );
   }

   public static void insertFlight( PriorityQueue queueToInsertTo ) {
      System.out.println( "What is the name of the flight?" );
      String flightName = userInput.next();
      System.out.println( "What is the flight number?" );
      int flightNumber = userInput.nextInt();
      System.out.println( "What is the flight priority?" );
      int flightPriority = userInput.nextInt();
      System.out.println( "What time is the departure time?" );
      int departureTime = userInput.nextInt();
      Flight newFlight = new Flight( flightName, flightNumber, flightPriority,
            departureTime );
      queueToInsertTo.insertion( newFlight );
      System.out.println( "Flight: " + flightName );
      System.out.println( "Flight Number: " + flightNumber );
      System.out.println( "Flight Priority: " + flightPriority );
      System.out.println( "Flight Departure: " + departureTime );
      System.out.println( "Has been added to the queue." );
   }

   private static void delete( PriorityQueue queueToDeleteFrom ) {
      Link deletion = queueToDeleteFrom.deletion();
      if ( deletion != null ) {
         if ( deletion.data instanceof Name ) {
            System.out
                  .println( deletion.data + " was deleted from the queue." );
         }
         else {
            System.out.println(
                  "Flight Name: " + ((Flight) deletion.data).getAirLine() );
            System.out.println( "Flight Number: "
                  + ((Flight) deletion.data).getFlightNumber() );
         }
      }
      else
         System.out.println( "Queue is empty." );
   }

   private static void heapSort() {
      boolean done = false;
      PriorityQueue newQueue = new PriorityQueue();
      System.out.println( "\nHeap Sort for a Name Priority Queue " );
      do {
         switch (heapSortMenu()) {
         case '1':
            boolean doneInserting = false;
            System.out.println(
                  "\nWill Keep Requesting Names Until User Enters Quit" );
            while ( doneInserting == false ) {
               String firstName = "";
               String lastName = "";
               System.out.println( "\nWhat is the first name?" );
               firstName = userInput.next();
               if ( firstName.equalsIgnoreCase( "quit" ) == false ) {
                  System.out.println( "What is the last name?" );
                  lastName = userInput.next();
                  if ( lastName.equalsIgnoreCase( "quit" ) == false ) {
                     Name newName = new Name( firstName, lastName );
                     newQueue.insertion( newName );
                     System.out.println( firstName + " " + lastName
                           + " was added to the queue." );
                  }
                  else
                     doneInserting = true;
               }
               else
                  doneInserting = true;
            }
            break;
         case '2':
            while ( newQueue.isEmpty() == false ) {
               delete( newQueue );
            }
            break;
         case '3':
            done = true;
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 3...\n" );
         }
      } while ( done == false );
      System.out.println();
   }

   private static int heapSortMenu() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Insert Name" );
      System.out.println( "\t 2 - Delete Entire Queue" );
      System.out.println( "\t 3 - Quit " );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }
}

// Class for Priority Queue, uses prioritizable items
// (Names and Flight casted) and allows Program 6 class
// to insert and delete into the queue.
class PriorityQueue {
   private Link _head;

   public PriorityQueue() {
      _head = null;
   }

   public PriorityQueue(PriorityQueue queue) {
      PriorityQueue copy = queue;
   }

   public void insertion( Prioritizable item ) {
      Link add = new Link();
      Link current = _head;
      Link previous = null;
      Link finger = _head;
      add.data = item;
      while ( finger != null ) {
         if ( current.data.isHigherPriority( add.data ) ) {
            previous = current;
            current = current.next;
         }
         finger = finger.next;
      }
      add.next = current;

      if ( previous == null ) {
         _head = add;
      }
      else {
         previous.next = add;
      }
   }

   public Link deletion() {
      Link linkToDelete = null;
      if ( isEmpty() == false ) {
         linkToDelete = _head;
         _head = _head.next;
      }
      return linkToDelete;
   }

   public boolean isEmpty() {
      boolean isEmpty = false;
      if ( _head == null ) {
         isEmpty = true;
      }
      return isEmpty;
   }

   public String toString() {
      String stringToReturn = "";
      Link finger = new Link();
      finger = _head;
      while ( finger != null ) {
         stringToReturn += finger.data + "\n";
         finger = finger.next;
      }
      return stringToReturn;
   }
}

class Flight implements Prioritizable {
   private String _airLine;
   private int    _flightNumber;
   private int    _priorityCode;
   private int    _departureTime;

   public Flight(String airLine, int flightNumber, int priorityCode,
         int departureTime) {
      _airLine = airLine;
      _flightNumber = flightNumber;
      _priorityCode = priorityCode;
      _departureTime = departureTime;
   }

   public String getAirLine() {
      return _airLine;
   }

   public int getFlightNumber() {
      return _flightNumber;
   }

   public int getPriorityCode() {
      return _priorityCode;
   }

   public int getDepartureTime() {
      return _departureTime;
   }

   // When prioritizing for Flight, Priority Code takes
   // precendence.
   // if Priority Code == Priority Code then use departure
   // time.
   public boolean isHigherPriority( Prioritizable other ) {
      boolean result = false;
      if ( other instanceof Flight ) {
         Flight o = (Flight) other;
         if ( _priorityCode < o.getPriorityCode() ) {
            result = false;
         }
         else if ( _priorityCode > o.getPriorityCode() ) {
            result = true;
         }
         else {
            if ( _departureTime < o.getDepartureTime() ) {
               result = false;
            }
            else if ( _departureTime > o.getDepartureTime() ) {
               result = true;
            }
         }

      }
      return false;
   }
}

class Link {
   public Prioritizable data;
   public Link          next;
}

class Name implements Prioritizable {
   private String _firstName;
   private String _lastName;

   public Name(String firstName, String lastName) {
      _firstName = firstName;
      _lastName = lastName;
   }

   public String getFirstName() {
      return _firstName;
   }

   public String getLastName() {
      return _lastName;
   }

   // When prioritizing for Name, Last > First, if Last ==
   // Last
   // then use First Name.
   public boolean isHigherPriority( Prioritizable other ) {
      boolean result = false;
      if ( other instanceof Name ) {
         Name o = (Name) other;
         int priority = _lastName.compareTo( ((Name) other)._lastName );
         if ( priority < 0 ) {
            result = true;
         }
         else if ( priority > 0 ) {
            result = false;
         }
         else {
            priority = _firstName.compareTo( ((Name) other)._firstName );
            if ( priority < 0 ) {
               result = true;
            }
            else if ( priority > 0 ) {
               result = false;
            }
            else
               result = true;
         }
      }
      return result;
   }

   public String toString() {
      String stringToReturn = "";
      stringToReturn += _firstName + " " + _lastName;
      return stringToReturn;
   }
}

// Classes Name and Flight implement interface Prioritizable
interface Prioritizable {
   public boolean isHigherPriority( Prioritizable other );
}
