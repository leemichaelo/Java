/*******************************************************************************
 * Programmer: Lee-Michael Owen CSC205 Program 5 // Date: April 2015 
 * Description: Program that supports statistical analyses of baseball players
 *    in a hypothetical 'team'. This could be used for baseball fantasy leagues
 *    or Rotisserie Leauge Play.
 * Input: User chooses between two teams to manipulate team/employee
 *    information.
 * Output: Displays team employees information and statistics.
*******************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class testTeam {

   public static Scanner userInput = new Scanner( System.in );

   public static void main( String[] args ) {
      // Initiates Manager for Team A
      Manager managerMike = new Manager( "Mike", 100000, 5, 4, 3 );
      // Initiates Manager for Team A
      Manager managerBreeanna = new Manager( "Breanna", 100111, 1, 2, 3 );
      // Initiates Team A and gives it a manager
      Team teamA = new Team( managerMike );
      // Creates 4 new players to insert into Team A
      Pitcher Liam = new Pitcher( "Liam", 6, 5, 4, 3, 2, 1 );
      Pitcher Noah = new Pitcher( "Noah", 6, 5, 4, 3, 2, 1 );
      Batter LiamB = new Batter( "LiamB", 6, 5, 4, 3, 2, 1 );
      Batter NoahB = new Batter( "NoahB", 6, 5, 4, 3, 2, 1 );

      // Adds the new players into Team A
      teamA.addPlayer( Liam );
      teamA.addPlayer( Noah );
      teamA.addPlayer( LiamB );
      teamA.addPlayer( NoahB );
      Team teamB = new Team( managerBreeanna );

      boolean done = false;
      System.out.println( "**Application to Create a BaseBall Fantasy Team**" );
      System.out.println( "-------------------------------------------------" );
      // Do while to continuously ask the user if they want
      // to change or display values for the two teams.
      do {
         System.out
               .print( "\nWhich team would you like to manipulate? A or B: " );
         char teamToUse = userInput.next().charAt( 0 );
         switch (getMenuSelection()) {
         case '1':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               getManager( teamA );
            }
            else
               getManager( teamB );
            break;
         case '2':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               newManager( teamA );
            }
            else
               newManager( teamB );
            break;
         case '3':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               getPitcher( teamA );
            }
            else
               getPitcher( teamB );
            break;
         case '4':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               getBatters( teamA );
            }
            else
               getBatters( teamB );
            break;
         case '5':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               getNumOfPlayers( teamA );
            }
            else
               getNumOfPlayers( teamB );
            break;
         case '6':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               getNamedPlayer( teamA );
            }
            else
               getNamedPlayer( teamB );
            break;
         case '7':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               addPlayer( teamA );
            }
            else
               addPlayer( teamB );
            break;
         case '8':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               deletePlayer( teamA );
            }
            else
               deletePlayer( teamB );
            break;
         case '9':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               teamBattingAverage( teamA );
            }
            else
               teamBattingAverage( teamB );
            break;
         case 'A':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               totalRuns( teamA );
            }
            else
               totalRuns( teamB );
            break;
         case 'B':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               totalERA( teamA );
            }
            else
               totalERA( teamB );
            break;
         case 'C':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               totalStrikeOuts( teamA );
            }
            else
               totalStrikeOuts( teamB );
            break;
         case 'D':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               totalSalary( teamA );
            }
            else
               totalSalary( teamB );
            break;
         case 'E':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               teamValue( teamA );
            }
            else
               teamValue( teamB );
            break;
         case 'F':
            if ( teamToUse == 'A' || teamToUse == 'a' ) {
               printTeam( teamA );
            }
            else
               printTeam( teamB );
            break;
         case 'G':
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

   // Displays teams manager.
   public static void getManager( Team team ) {
      System.out.println( team.getManager() );
   }

   // Creates a new manager for a given team.
   public static void newManager( Team team ) {
      String name = "";
      int salary = 0;
      int yearsIn = 0;
      int carrerWins = 0;
      int carrerGames = 0;
      System.out.print( "\nManagers name? " );
      name = userInput.next();
      System.out.print( "Managers salary? " );
      salary = userInput.nextInt();
      System.out.print( "Mangers years of service? " );
      yearsIn = userInput.nextInt();
      System.out.print( "Managers carrer wins? " );
      carrerWins = userInput.nextInt();
      System.out.print( "Managers total games? " );
      carrerGames = userInput.nextInt();
      Manager newManager = new Manager( name, salary, yearsIn, carrerWins,
            carrerGames );
      team.setManager( newManager );
      System.out
            .println( "\nManager: " + name + " Has Been Added to the Team." );
   }

   // Displays the number of pitchers on a given team.
   private static void getPitcher( Team team ) {
      System.out.println(
            "\nThe number of pitchers on the team is " + team.getPitchers() );

   }

   // Displays the number of batters on a given team.
   private static void getBatters( Team team ) {
      System.out.println(
            "\nThe number of pitchers on the team is " + team.getBatters() );

   }

   // Displays the number of players on a given team.
   private static void getNumOfPlayers( Team team ) {
      System.out.println( "\nThe number of players on the team is "
            + team.getNumOfPlayers() );

   }

   // Displays the information for a player when given a
   // name.
   private static void getNamedPlayer( Team team ) {
      System.out.print( "\nWhich player would you like to view? " );
      String namedPlayer = userInput.next();
      System.out.println( "\n" + team.getNamedPlayer( namedPlayer ) );

   }

   // Adds a player to a given team.
   private static void addPlayer( Team team ) {
      System.out.println( "Would you like to add a Batter or a Pitcher? " );
      String playerToAdd = userInput.next();
      Batter newBatter;
      Pitcher newPitcher;
      if ( playerToAdd.equalsIgnoreCase( "Batter" ) ) {
         System.out.print( "Batters name? " );
         String name = userInput.next();
         System.out.print( "\nBatters salary? " );
         double salary = userInput.nextDouble();
         System.out.println( "\nBatters years of service? " );
         int yearsIn = userInput.nextInt();
         System.out.print( "\nBatters Number Of Games? " );
         int numberOfGames = userInput.nextInt();
         System.out.print( "\nBatters times at bat " );
         int atBats = userInput.nextInt();
         System.out.print( "\nBatters hits " );
         int hits = userInput.nextInt();
         System.out.print( "\nBatters Home Runs" );
         int homeRuns = userInput.nextInt();
         newBatter = new Batter( name, salary, yearsIn, numberOfGames, atBats,
               hits, homeRuns );
         team.addPlayer( newBatter );
      }
      else if ( playerToAdd.equalsIgnoreCase( "Pitcher" ) ) {
         System.out.print( "\nPitchers name? " );
         String name = userInput.next();
         System.out.print( "\nPitchers salary? " );
         double salary = userInput.nextDouble();
         System.out.println( "\nPitchers years of service? " );
         int yearsIn = userInput.nextInt();
         System.out.print( "\nPitchers Number Of Games? " );
         int numberOfGames = userInput.nextInt();
         System.out.print( "\nPitchers innings " );
         int innings = userInput.nextInt();
         System.out.print( "\nPitchers hits " );
         int earnedRuns = userInput.nextInt();
         System.out.print( "\nPitchers Home Runs" );
         int homeRuns = userInput.nextInt();
         newPitcher = new Pitcher( name, salary, yearsIn, numberOfGames,
               innings, earnedRuns, homeRuns );
         team.addPlayer( newPitcher );
      }
   }

   // Deletes a player given a name
   private static void deletePlayer( Team team ) {
      System.out.print( "\nWhich player would you like to delete? " );
      String namedPlayer = userInput.next();
      team.deletePlayer( namedPlayer );

   }

   // Displays the teams batting average.
   private static void teamBattingAverage( Team team ) {
      System.out.println(
            "\nThe Teams Batting Average is: " + team.teamBattingAverage() );

   }

   // Displays the teams total runs.
   private static void totalRuns( Team team ) {
      System.out.println(
            "\nThe Teams Total Home Runs is: " + team.totalHomeRuns() );

   }

   // Displays the teams total strike outs.
   private static void totalStrikeOuts( Team team ) {
      System.out.println(
            "\nThe Teams Total Strike Outs is: " + team.totalStrikeOuts() );

   }

   // Displays the teams total ERA.
   private static void totalERA( Team team ) {
      System.out.println( "\nThe Teams Total ERA is: " + team.totalERA() );

   }

   // Displays the teams total Salary.
   private static void totalSalary( Team team ) {
      System.out
            .println( "\nThe Teams Total Salary is: " + team.totalSalary() );
   }

   // Displays the teams total Value.
   private static void teamValue( Team team ) {
      System.out.println( "\nThe Teams Total Value is: " + team.teamValue() );
   }

   // Displays the teams information on an individual basis.
   private static void printTeam( Team team ) {
      System.out.println( "\n" + team.toString() );

   }

   // Present menu and get a selection from the user
   public static char getMenuSelection() {
      System.out.println( "\nChoose a task number from the following: " );
      System.out.println( "\t 1 - Display Manager " );
      System.out.println( "\t 2 - New Manager " );
      System.out.println( "\t 3 - Display Number of Pitchers on the Team " );
      System.out.println( "\t 4 - Display Number of Batters on the Team " );
      System.out.println( "\t 5 - Display Number of Players " );
      System.out.println( "\t 6 - Display Named Players Info " );
      System.out.println( "\t 7 - Add New Player " );
      System.out.println( "\t 8 - Delete Player " );
      System.out.println( "\t 9 - Display Batting Average " );
      System.out.println( "\t A - Display Team Runs " );
      System.out.println( "\t B - Display Team ERA " );
      System.out.println( "\t C - Display Team Strike Outs " );
      System.out.println( "\t D - Display Team Salary " );
      System.out.println( "\t E - Display Team Value " );
      System.out.println( "\t F - Display Team " );
      System.out.println( "\t G - Quit " );
      System.out.print( "Your selection: " );
      return userInput.next().charAt( 0 );
   }

}

class Team {

   private ArrayList<Player> _players;
   private Manager           _manager;
   private int               _pitchers = 0;
   private int               _batters  = 0;
   
   //Constructor that initializes an empty arrayIndex to hold Players
   // and also a given manager
   public Team(Manager manager) {
      _players = new ArrayList<Player>();
      _manager = manager;
   }
   
   //Returns the teams current manager
   public Manager getManager() {
      return _manager;
   }

   //Mutates the current Manager
   public void setManager( Manager manager ) {
      _manager = manager;
   }

   //Returns the teams number of pitchers
   public int getPitchers() {
      return _pitchers;
   }

   //Returns the teams number of batters
   public int getBatters() {
      return _batters;
   }

   //Returns the teams total number of players
   public int getNumOfPlayers() {
      return _players.size();
   }

   //Searches the team for a given player name then returns that Player
   public Player getNamedPlayer( String name ) {
      Player playerToReturn = null;
      while ( playerToReturn == null ) {
         for ( Player player : _players ) {
            if ( player.getName().equalsIgnoreCase( name ) ) {
               playerToReturn = player;
            }
         }
      }
      return playerToReturn;

   }

   //Adds a given player to the arraylist
   public void addPlayer( Player newPlayer ) {
      if ( newPlayer instanceof Pitcher ) {
         _pitchers++;
      }
      else if ( newPlayer instanceof Batter ) {
         _batters++;
      }
      _players.add( newPlayer );
   }

   //Deletes a player given a players name
   public void deletePlayer( String name ) {
      Player playerToDelete = null;
      while (playerToDelete == null){
         for ( Player player : _players ) {
            if ( player.getName().equalsIgnoreCase( name ) ) {
               playerToDelete = player;
            }
         }
      }
         _players.remove(playerToDelete);
   }

   //Returns the teams total batting average
   public double teamBattingAverage() {
      double playerAtBats = 0;
      double playerHits = 0;
      double batterAverage = 0;
      for ( Player player : _players ) {
         playerAtBats += player.getBats();
         playerHits += player.getHits();
      }
      batterAverage = playerAtBats / playerHits;
      return batterAverage;

   }

   //Returns the teams total home runs
   public int totalHomeRuns() {
      int totalRuns = 0;
      for ( Player player : _players ) {
         totalRuns += player.getHomeRuns();
      }
      return totalRuns;
   }

   //Returns the teams total ERA
   public double totalERA() {
      double ERA = 0;
      double earnedRuns = 0;
      double innings = 0;
      for ( Player player : _players ) {
         earnedRuns += player.getEarnedRuns();
         innings += player.getInnings();
      }
      ERA = earnedRuns / innings;
      return ERA;
   }

   //Returns the teams total strike outs
   public int totalStrikeOuts() {
      int totalStrikeOuts = 0;
      for ( Player player : _players ) {
         totalStrikeOuts += player.getStrikeOuts();
      }
      return totalStrikeOuts;
   }

   //Returns the teams total Salary
   public double totalSalary() {
      double totalSalary = 0;
      for ( Player player : _players ) {
         totalSalary += player.getSalary();
      }
      totalSalary += _manager.getSalary();
      return totalSalary;
   }

   //Returns the teams total value
   public double teamValue() {
      double teamValue = 0;
      for ( Player player : _players ) {
         teamValue += player.getValue();
      }
      return teamValue;
   }

   public String toString() {
      String stringToReturn = "";
      for ( Player player : _players ) {
         stringToReturn += player.toString();
      }
      return stringToReturn;
   }
}

//Parent class to Manager and Player
abstract class Employee {
   private String _name;
   private double _salary;
   private int    _yearsIn;

   //Constructor
   public Employee(String name, double salary, int yearsIn) {
      _name = name;
      _salary = salary;
      _yearsIn = yearsIn;
   }

   //Returns the Employees name
   public String getName() {
      return _name;
   }

   //Returns the Employees salary
   public double getSalary() {
      return _salary;
   }

   //Returns the Employees years of service
   public int getYearsIn() {
      return _yearsIn;
   }

   public String toString() {
      String stringToReturn = "Name: " + _name + "\nSalary: " + _salary
            + "\nYears of service: " + _yearsIn;
      return stringToReturn;
   }
}

class Manager extends Employee {
   private int _carrerWins;
   private int _carrerGames;

   public Manager(String name, double salary, int yearsIn, int carrerWins,
         int carrerGames) {
      //Super of Employee Constructor
      super( name, salary, yearsIn );
      _carrerWins = carrerWins;
      _carrerGames = carrerGames;
   }

   //Returns Managers carrer wins
   public int getCarrerWins() {
      return _carrerWins;
   }

   //returns Managers carrer games
   public int getCarrerGames() {
      return _carrerGames;
   }

   //Returns Managers win percentage
   public double winPercent() {
      double winPercent = _carrerWins / _carrerGames;
      return winPercent;
   }

   //Contains a super of the Employee Class toString
   public String toString() {
      String stringToReturn = "Manager info: " + super.toString()
            + " carrer wins: " + _carrerWins + " carrer games: " + _carrerGames;
      return stringToReturn;
   }
}

//
abstract class Player extends Employee {
   private int _numberOfGames;

   public Player(String name, double salary, int yearsIn, int numberOfGames) {
      //Super of Employee Class Constructor
      super( name, salary, yearsIn );
      _numberOfGames = numberOfGames;
   }

   //Returns the players total number of games
   public int getNumberOfGames() {
      return _numberOfGames;
   }

   //If player is a batter, method will return 0.
   // else if player is a pitcher, pitchers getInnings will be used.
   public int getInnings() {
      return 0;
   }

   //If player is a batter, method will return 0.
   // else if player is a pitcher, pitchers getEarnedRuns will be used.
   public int getEarnedRuns() {
      return 0;
   }

   //If player is a batter, method will return 0.
   // else if player is a pitcher, pitchers getStrikeOuts will be used.
   public int getStrikeOuts() {
      return 0;
   }

   //If player is a pitcher, method will return 0.
   // else if player is a batter, batter getBats will be used.
   public int getBats() {
      return 0;
   }

   //If player is a pitcher, method will return 0.
   // else if player is a batter, batter getHits will be used.
   public int getHits() {
      return 0;
   }

   //If player is a pitcher, method will return 0.
   // else if player is a batter, batter getHomeRuns will be used.
   public int getHomeRuns() {
      return 0;
   }

   //Allows player.getValue() to be called, which in then will morph
   // into either pitcher or batters getValue
   public abstract double getValue();

   //Contains super toString of Employee Class
   public String toString() {
      return super.toString() + "\nNumber of Games: " + _numberOfGames;
   }
}

class Pitcher extends Player {
   private int _innings    = 0;
   private int _earnedRuns = 0;
   private int _strikeOuts = 0;

   //Contains super of Player Class
   public Pitcher(String name, double salary, int yearsIn, int numberOfGames,
         int innings, int earnedRuns, int strikeOuts) {
      super( name, salary, yearsIn, numberOfGames );
      _innings = innings;
      _earnedRuns = earnedRuns;
      _strikeOuts = strikeOuts;
   }

   //Returns pitchers innings
   public int getInnings() {
      return _innings;
   }

   //Returns pitchers earned runs
   public int getEarnedRuns() {
      return _earnedRuns;
   }

   //Returns pitchers strike outs
   public int getStrikeOuts() {
      return _strikeOuts;
   }

   //Returns pitchers ERA
   public double ERA() {
      return (9 * _earnedRuns) / _innings;
   }

   //Returns pitchers value
   public double getValue() {
      double value = -(ERA() - 2) + (_strikeOuts - 200) / 200;
      return value;
   }

   //Contains super toString of Player Class
   public String toString() {
      return super.toString() + "\nPitching Info: " + "\nNumber of Innings: "
            + _innings + "\nNumber of Earned Runs: " + _earnedRuns
            + "\nNumber of Strike Outs: " + _strikeOuts;
   }
}

class Batter extends Player {
   private int _atBats;
   private int _hits;
   private int _homeRuns;

   //Contains super Constructor of Player Class
   public Batter(String name, double salary, int yearsIn, int numberOfGames,
         int atBats, int hits, int homeRuns) {
      super( name, salary, yearsIn, numberOfGames );
      _atBats = atBats;
      _hits = hits;
      _homeRuns = homeRuns;
   }

   //Returns batters bats
   public int getBats() {
      return _atBats;
   }

   //Returns batters hits
   public int getHits() {
      return _hits;
   }

   //Returns batters home runs
   public int getHomeRuns() {
      return _homeRuns;
   }

   //Returns batters average
   public double battingAverage() {
      return (_hits / _atBats);
   }

   //Returns batters value
   public double getValue() {
      double value = (battingAverage() - 0.3) / .3 + (_homeRuns - 50) / 50;
      return value;
   }

   //Contains super toString of Player Class
   public String toString() {
      return super.toString() + "\nBatting Info: " + "\nTimes at Bat: "
            + _atBats + "\nBumber of Hits: " + _hits + "\nNumber of Homeruns: "
            + _homeRuns;

   }
}
