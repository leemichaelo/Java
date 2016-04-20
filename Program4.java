/*******************************************************************************
 * Programmer: Lee-Michael Owen CSC205 Program 4 // Date: April 2015 
 * Description: Program that consists of a deque data structure that can be
 *    used to create queues and stacks. It uses these data structures to
 *    play a game of Top Trump.
 * Input: User chooses between data structures as well as insert/delete objects
 *    from them. And also play a game of top trump.
 * Output: Contents of the data structures and also the states of the 
 *    top trump game that is being played.
*******************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program4 {
   public static Scanner userInput = new Scanner( System.in );

   public static void main( String[] args ) {
      boolean done = false;
      do {
         switch (mainMenu()) {
         case '1':
            testTools();
            break;
         case '2':
            playTopTrump();
            break;
         case '3':
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

   //Main menu for application
   public static char mainMenu() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Test The Tools" );
      System.out.println( "\t 2 - Play Top Trump " );
      System.out.println( "\t 3 - Exit program" );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

   //Switch statement for the test tools option of main menu
   public static void testTools() {
      boolean done = false;
      do {
         switch (testMenu()) {
         case '1':
            stackCustomer();
            break;
         case '2':
            queueCustomer();
            break;
         case '3':
            done = true;
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 3...\n" );
            break;
         }
      } while ( !done );
      System.out.println( "Aplication terminating." );
   }

   //Menu for the test tools
   private static char testMenu() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Test A Stack" );
      System.out.println( "\t 2 - Test A Queue " );
      System.out.println( "\t 3 - Quit " );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

   //Switch statement for the stack option of test tools
   private static void stackCustomer() {
      Stack testStack = new Stack();
      boolean done = false;
      do {
         switch (stackMenu()) {
         case '1':
            int _id = -1;
            System.out.print( "Please Enter Customer Id to Insert" );
            _id = userInput.nextInt();
            testStack.push( _id );
            break;
         case '2':
            testStack.pop();
            break;
         case '3':
            if ( testStack.isEmpty() ) {
               System.out.println( "Stack is Empty" );
            }
            else
               System.out.println( "Stack is not Empty" );
            break;
         case '4':
            System.out.println( testStack.toString() );
            break;
         case '5':
            done = true;
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 5...\n" );
            break;
         }
      } while ( !done );
      System.out.println( "Aplication terminating." );

   }

   //Menu for the stack option of test tools
   private static char stackMenu() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Insert on Stack" );
      System.out.println( "\t 2 - Delete from Stack" );
      System.out.println( "\t 3 - Check if Stack is Empty" );
      System.out.println( "\t 4 - Print Stack" );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

   //Switch statement for the queue option of test tools
   public static void queueCustomer() {
      Queue testQueue = new Queue();
      boolean done = false;
      do {
         switch (queueMenu()) {
         case '1':
            int _id = -1;
            System.out.print( "Please Enter Customer Id to Insert" );
            _id = userInput.nextInt();
            testQueue.insert( _id );
            break;
         case '2':
            testQueue.delete();
            break;
         case '3':
            if ( testQueue.isEmpty() ) {
               System.out.println( "Queue is Empty" );
            }
            else
               System.out.println( "Queue is not Empty" );
            break;
         case '4':
            System.out.println( testQueue.toString() );
            break;
         case '5':
            done = true;
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 5...\n" );
            break;
         }
      } while ( !done );
      System.out.println( "Aplication terminating." );

   }

   //Menu for queue option of test tools
   private static char queueMenu() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Insert on Queue" );
      System.out.println( "\t 2 - Delete from Queue" );
      System.out.println( "\t 3 - Check if Stack is Empty" );
      System.out.println( "\t 4 - Print Stack" );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

   //Runs the top trump option of main menu
   public static void playTopTrump() {
      int _pNumCards = 0;
      int _cNumCards = 0;
      int _playersChoice = 0;
      int _computersChoice = 0;
      char _currentCatagory = '0';
      int _playerWins = 0;
      int _playerLoses = 0;
      int _ties = 0;
      boolean done = false;
      boolean cardsInTie = false;

      //Creates the deck from the Greek Hero class
      GreekHeroArray card = new GreekHeroArray();
      GreekHero[] deck = card.getCards();

      shuffle( deck );

      Queue shuffledDeck = new Queue();
      for ( int loopRun = 0; loopRun < deck.length; loopRun++ ) {
         shuffledDeck.insert( deck[loopRun] );
      }

      //Fills the players deck from the shuffled deck
      Queue playersHand = new Queue();
      for ( int loopRun = 0; loopRun < deck.length / 2; loopRun++ ) {
         playersHand.insert( shuffledDeck.delete() );
         _pNumCards++;
      }
      //Fills the computers deck from the shuffled deck
      Queue computersHand = new Queue();
      for ( int loopRun = 0; loopRun < deck.length; loopRun++ ) {
         computersHand.insert( shuffledDeck.delete() );
         _cNumCards++;
      }
      Queue tiedGame = new Queue();

      boolean playersTurn = true;
      GreekHero _playersCard;
      GreekHero _computersCard;
     
      //Will keep playing hands until either the players are out of cards or 
      //   the player ends the game
      do{
      _playersCard = (GreekHero) playersHand.delete();
      _pNumCards--;
      _computersCard = (GreekHero) computersHand.delete();
      _cNumCards--;

      //Runs when it is the players turn, and game always starts with the player
      if ( playersTurn ) {
         System.out.println( "\nIt is your turn: " );
         System.out.println( "Your Card Is:  \n" + _playersCard );

         switch (cardMenu()) {
         case '1':
            _playersChoice = _playersCard.getBravery();
            _currentCatagory = '1';
            break;
         case '2':
            _playersChoice = _playersCard.getWisdom();
            _currentCatagory = '2';
            break;
         case '3':
            _playersChoice = _playersCard.getStrength();
            _currentCatagory = '3';
            break;
         case '4':
            _playersChoice = _playersCard.getFerocity();
            _currentCatagory = '4';
            break;
         case '5':
            _playersChoice = _playersCard.getFearFactor();
            _currentCatagory = '5';
            break;
         default:
            System.out.println(
                  "Invalid menu selection.  Enter a value between 1 and 5...\n" );
            break;
         }
         if ( _currentCatagory == '1' ) {
            _computersChoice = _computersCard.getBravery();
         }
         else if ( _currentCatagory == '2' ) {
            _computersChoice = _computersCard.getWisdom();
         }
         else if ( _currentCatagory == '3' ) {
            _computersChoice = _computersCard.getStrength();
         }
         else if ( _currentCatagory == '4' ) {
            _computersChoice = _computersCard.getFerocity();
         }
         else
            _computersChoice = _computersCard.getFearFactor();
         playersTurn = false;
      }
      //Runs if it is the computers turn
      else {
         System.out.println( "It is the computers turn: " );
         System.out.println( "Your Card Is:  " + _playersCard );
         _computersChoice = _computersCard.getBravery();
         _currentCatagory = '1';
         
         if(_computersCard.getWisdom()>_computersChoice){
            _computersChoice = _computersCard.getWisdom();
            _currentCatagory = '2';
         }
         if(_computersCard.getStrength()>_computersChoice){
            _computersChoice = _computersCard.getStrength();
            _currentCatagory = '3';
         }
         if(_computersCard.getFerocity()>_computersChoice){
            _computersChoice = _computersCard.getFerocity();
            _currentCatagory = '4';
         }
         if(_computersCard.getFearFactor()>_computersChoice){
            _computersChoice = _computersCard.getFearFactor();
            _currentCatagory = '5';
         }
         if ( _currentCatagory == '1' ) {
            _playersChoice = _playersCard.getBravery();
         }
         else if ( _currentCatagory == '2' ) {
            _playersChoice = _playersCard.getWisdom();
         }
         else if ( _currentCatagory == '3' ) {
            _playersChoice = _playersCard.getStrength();
         }
         else if ( _currentCatagory == '4' ) {
            _playersChoice = _playersCard.getFerocity();
         }
         else
            _playersChoice = _playersCard.getFearFactor();
         playersTurn = true;
      }
      //If the computer wins, the players card and any cards in the tied game pile goes into its deck
      if ( _playersChoice < _computersChoice ) {
         System.out.println( "The computer played: \n" + _computersCard );
         System.out
               .println( "\nThe Player Lost With a Score of: " + _playersChoice );
         _playerLoses++;
         computersHand.insert( _playersCard );
         if (cardsInTie){
            computersHand.insert(tiedGame.delete());
            computersHand.insert(tiedGame.delete());
         }
      }
      //If the player wins, the computers card and any cards in the tied game pile goes into its deck
      else if ( _playersChoice > _computersChoice ) {
         System.out.println( "The computer played: \n" + _computersCard );
         System.out
               .println( "\nThe Player Won With a Score of: " + _playersChoice );
         _playerWins++;
         playersHand.insert( _computersCard );
         if (cardsInTie){
            playersHand.insert(tiedGame.delete());
            playersHand.insert(tiedGame.delete());
         }
      }
      //If the game is tied, the cards are added to the tied queue
      else {
         System.out.println( "The computer played: \n" + _computersCard );
         System.out.println(
               "\nThe Game Was Tied With A Score of: " + _playersChoice );
         _ties++;
         tiedGame.insert( _playersCard );
         tiedGame.insert( _computersCard );
         cardsInTie = true;
         }
         if ( _pNumCards == 0 || _cNumCards == 0 ) {
            done = true;
         }
         //Allows the user to end the game early, or if the players are out of cards the game ends
         else {
            System.out.println( "\nWould you like to play another hand?" );
            char keepPlayingorNot = userInput.next().charAt( 0 );
            if ( keepPlayingorNot == 'n' ) {
               done = true;
            } 
         }
      } while ( !done );
      System.out.println( "Game Over" );
      System.out.println( "You won a total of: " + _playerWins );
      System.out.println( "You lost a total of: " + _playerLoses );
      System.out.println( "And you tied a total of: " + _ties );
   }

   //Menu for the user to choose what stat they want to play
   private static char cardMenu() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Choose Bravery" );
      System.out.println( "\t 2 - Choose Wisdom" );
      System.out.println( "\t 3 - Choose Strength" );
      System.out.println( "\t 4 - Choose Ferocity" );
      System.out.println( "\t 5 - Choose Fear Factor" );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

   private static void shuffle( GreekHero[] deck ) {
      int firstHalf = 0;
      int secondHalf = 0;

      for ( int loopRun = 0; loopRun < deck.length; loopRun++ ) {
         firstHalf = (int) (deck.length * Math.random());
         secondHalf = (int) (deck.length * Math.random());
         GreekHero data = deck[firstHalf];
         deck[firstHalf] = deck[secondHalf];
         deck[secondHalf] = data;
      }
   }
}

class Customer {
   private String _name;
   private int    _id;

   public Customer(String name, int id) {
      _name = name;
      _id = id;
   }

   public String getName() {
      return _name;
   }

   public int getId() {
      return _id;
   }

   public String toString() {
      String stringToReturn = "";
      stringToReturn += "\nName: " + _name + "\nID: " + _id;
      return stringToReturn;
   }
}

//Class for a circular array called a deque. follows rules for both a stack and a queue
class Deque {
   private Object[]         _deque;
   private int              _front;
   private int              _back;
   private int              _arraySize;
   private static final int arrayAlloc = 5;

   // Initialize an empty deque.
   public Deque() {
      _deque = new Object[arrayAlloc];
      _arraySize = 0;
      _front = 3;
      _back = 2;
   }

   // Insert a given String on front of the deque.
   public void insertOnFront( Object objectToInsert ) {
      if (_arraySize == _deque.length){
         Object[] temp = new Object[ _arraySize + arrayAlloc ];
         int tempFront = _front;
         for(int loopRun = 1; loopRun <= _arraySize ; loopRun++){
             temp[loopRun] = _deque[tempFront];
             if(tempFront ==_deque.length - 1){
                tempFront = 0;
            }
            else{
               tempFront ++;
            }
         }
         _deque = temp;
         _front = 0;
         _deque[_front] = objectToInsert;
         _back = _arraySize - arrayAlloc;
     }
   
   else if(_front == 0){
      _front =  _deque.length - 1;
      _deque[_front] = objectToInsert;
   }
   
   else{
      _front--;
      _deque[_front] = objectToInsert;
   }
   
     _arraySize++;
 }
   // return(and delete) the String on the front of the
   // deque.
 public Object deleteFromFront(){
   Object deletedItem = _deque[_front];
     _deque[_front] = null;
     if(_front == _deque.length - 1){
         _front = 0;
     }
     else{
      _front = _front + 1;
     }
     _arraySize--;
     return deletedItem;
 }


   // Insert a given String on the back of the deque.
 public void insertOnBack(Object objectToInsert){
    if (_arraySize == _deque.length){
          Object[] temp = new Object[ _arraySize + arrayAlloc ];
          int tempFront = _front;
          for(int loopRun = 1; loopRun <= _arraySize ; loopRun++){
             temp[loopRun] = _deque[tempFront];
              if(tempFront == _deque.length - 1){
                tempFront = 0;
             }
             else{
                tempFront ++;
             }
          }
          _deque = temp;
          _front = 1;
          _back = _arraySize +1;
          _deque[_back] = objectToInsert;
      }
    else if(_back == _deque.length -1){
       _back = 0;
       _deque[_back] = objectToInsert;
    }
    else{
       _back++;
       _deque[_back] = objectToInsert;
    }
      _arraySize++;
  }

   // return(and delete) the String on the back of the
   // deque.
   public Object deleteFromBack() {
      Object objectToDelete = _deque[_back];
      _deque[_back] = null;
      if ( _back == 0 ) {
         _back = _deque.length - 1;
      }
      else {
         _back--;
      }
      _arraySize--;
      return objectToDelete;
   }

   // return true if the deque is empty, and false
   // otherwise.
   public boolean isEmpty() {
      boolean isEmpty = false;
      if ( _arraySize == 0 ) {
         isEmpty = true;
      }
      return isEmpty;
   }

   // return a string summering the entire contents of
   // the deque(from front to back).
   public String toString() {
      String stringToReturn = "";
      for ( int loopRun = 0; loopRun < _deque.length; loopRun++ ) {
         if (_deque[loopRun]!=null){
         stringToReturn += _deque[loopRun];
         }
      }
      return stringToReturn;
   }

   // return a String summarizing the entire contents of
   // deque storage (from array
   // index 0 to length - 1.
   public String toStore() {
      String stringToReturn = "";
      for ( int loopRun = 0; loopRun < _deque.length; loopRun++ ) {
         stringToReturn += _deque[loopRun];
      }
      return stringToReturn;
   }

   public void insertFrontFull() {
      Object[] temp = new String[_arraySize + arrayAlloc];
      int tempFront = _front;
      for ( int loopRun = 1; loopRun <= _arraySize; loopRun++ ) {
         temp[loopRun] = _deque[tempFront];
         if ( tempFront == _deque.length - 1 ) {
            tempFront = 0;
         }
         else {
            tempFront++;
         }
      }
      _deque = temp;
      _front = 0;
      _back = _arraySize - arrayAlloc;
   }

   public void insertBackFull() {
      Object[] temp = new String[_arraySize + arrayAlloc];
      int tempFront = _front;
      for ( int loopRun = 1; loopRun <= _arraySize; loopRun++ ) {
         temp[loopRun] = _deque[tempFront];

         if ( tempFront == _deque.length - 1 ) {
            tempFront = 0;
         }
         else {
            tempFront++;
         }
      }
      _deque = temp;
      _front = 1;
      _back = _arraySize + 1;
   }
}

//Uses functions from the Deque class to create a queue
class Queue {
   private Deque _queue;
   public Queue() {
      _queue = new Deque();
   }
   
   public void insert( Object objectToInsert ) {
      _queue.insertOnBack( objectToInsert );
   }
   
   public Object delete() {
      return _queue.deleteFromFront();
   }
   
   public boolean isEmpty() {
      return _queue.isEmpty();
   }

   public String toString() {
      return _queue.toString();
   }
}

//Uses functions from the Deque class to create a stack
class Stack {
   private Deque _stack;

   public Stack() {
      _stack = new Deque();
   }

   public void push( Object objectToInsert ) {
      _stack.insertOnFront( objectToInsert );
   }

   public Object pop() {
      return _stack.deleteFromFront();
   }

   public boolean isEmpty() {
      return _stack.isEmpty();
   }

   public String toString() {
      return _stack.toString();
   }
}

class GreekHero {
   private String _name;
   private int    _bravery;
   private int    _wisdom;
   private int    _strength;
   private int    _ferocity;
   private int    _fearFactor;

   /**
    * Constructor with parameters
    */
   public GreekHero(String name, int bravery, int wisdom, int strength,
         int ferocity, int fearFactor) {
      _name = name;
      _bravery = bravery;
      _wisdom = wisdom;
      _strength = strength;
      _ferocity = ferocity;
      _fearFactor = fearFactor;
   }

   /**
    * Accessor method for name
    *
    * @return _name
    */
   public String getName() {
      return _name;
   }

   /**
    * Accessor method for bravery
    *
    * @return _bravery
    */
   public int getBravery() {
      return _bravery;
   }

   /**
    * Accessor method for wisdom
    *
    * @return _wisdom
    */
   public int getWisdom() {
      return _wisdom;
   }

   /**
    * Accessor method for strength
    *
    * @return _strength
    */
   public int getStrength() {
      return _strength;
   }

   /**
    * Accessor method for ferocity
    *
    * @return _ferocity
    */
   public int getFerocity() {
      return _ferocity;
   }

   /**
    * Accessor method for fear facto0r
    *
    * @return _fearFactor
    */
   public int getFearFactor() {
      return _fearFactor;
   }

   /**
    * toString method
    *
    * @return string representation of a GreekHero
    */
   public String toString() {
      return "[" + _name + "]" + "(1)Bravery:" + _bravery + ", (2)Wisdom:"
            + _wisdom + ", (3)Strength:" + _strength + ", (4)Ferocity:"
            + _ferocity + ", (5)Fear Factor:" + _fearFactor;
   }
} // end class GreekHero()

class GreekHeroArray {
   private GreekHero[] cards;

   /**
    * Default constructor for the array of GreekHero cards
    */
   public GreekHeroArray() {
      cards = new GreekHero[] {
            // bravery, wisdom, strength, ferocity, fear
            // factor

            new GreekHero( "Achilles", 20, 48, 78, 14, 12 ),
            new GreekHero( "Medusa", 5, 30, 60, 12, 50 ),
            new GreekHero( "Chimera", 5, 10, 140, 20, 48 ),

            new GreekHero( "Polyphemus", 8, 18, 140, 15, 47 ),
            new GreekHero( "Cetus", 5, 14, 150, 16, 45 ),
            new GreekHero( "Zeus", 10, 100, 200, 8, 40 ),

            new GreekHero( "Minotaur", 12, 25, 138, 18, 40 ),
            new GreekHero( "Craeae", 6, 99, 30, 1, 40 ),
            new GreekHero( "Pegasus", 20, 20, 180, 9, 37 ),

            new GreekHero( "Siren", 3, 30, 160, 7, 36 ),
            new GreekHero( "Daphne", 10, 21, 47, 2, 30 ),
            new GreekHero( "Poseidon", 20, 90, 150, 15, 30 ),

            new GreekHero( "Theseus", 26, 38, 75, 10, 12 ),
            new GreekHero( "Odysseus", 30, 56, 65, 10, 11 ),
            new GreekHero( "Perseus", 26, 40, 70, 9, 10 ),

            new GreekHero( "Icarus", 18, 65, 50, 2, 9 ),
            new GreekHero( "Jason", 27, 39, 68, 8, 9 ),
            new GreekHero( "Oedipus", 26, 74, 63, 1, 7 ),

            new GreekHero( "Pandora", 10, 50, 32, 1, 5 ),
            new GreekHero( "Orpheus", 30, 51, 41, 4, 5 ),
            new GreekHero( "Sisyphus", 9, 80, 40, 3, 5 ),

            new GreekHero( "Ariadne", 29, 45, 40, 2, 3 ),
            new GreekHero( "Narcissus", 3, 50, 50, 8, 2 ),
            new GreekHero( "Aphrodite", 9, 49, 40, 6, 2 ),

            new GreekHero( "Trojan Horse", 0, 0, 185, 18, 29 ),
            new GreekHero( "Hermes", 18, 84, 100, 6, 29 ),
            new GreekHero( "Athene", 19, 85, 110, 5, 25 ),

            new GreekHero( "Prometheus", 22, 70, 37, 3, 24 ),
            new GreekHero( "Actaeon", 23, 20, 80, 3, 22 ),
            new GreekHero( "Heracles", 15, 55, 170, 13, 22 )

      };
   }

   /**
    * Accessor method to the array of GreekHero cards
    *
    * @return array of GreekHero cards created
    */
   public GreekHero[] getCards() {
      return cards;
   }

} // end class GreekHeroArray()
