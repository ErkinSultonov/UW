// This program will allow the user to play a game 
// in which the program thinks of a random integer and 
// accepts guesses from the user until the user guesses the number correctly.


import java.util.*;

public class GuessingGame {
   
   // Global constant MAX_VALUE
   public static final int MAX_VALUE = 100;
   
   public static void main(String[] args) {
   
      // New Scanner variable
      Scanner console = new Scanner(System.in);
      
      // New Random variable
      Random random = new Random(42);
      
      boolean playAgain  = true;
      
      // Total games played
      int totalGames = 0;
      
      // Total guesses
      int totalGuesses = 0;
      
      int best = 2000000;
      
      // Custom Haiku intro
      printHaikuIntro();
      
      // Keeps track of times user want to play game again.
      while (playAgain) {
      
         totalGames++; // Total number of games
         
         // Number of guesses
         int guess = guesses(console, random);
         
         if (guess < best) { // Best game
            best = guess;
         }
         
         // Willingnes of the user to play once more
         boolean again = gamesNum(console);
         playAgain = again;
         
         // Total number of guesses
         totalGuesses += guess;
      }
      
      // Outputs overall results
      printResults(totalGuesses, totalGames, best);
      
      
   }
   
   // Outputs custom Haiku intro
   public static void printHaikuIntro(){
         System.out.println("Random one, two, three");
         System.out.println("You have to guess what number");
         System.out.println("I hidden from you");
   }
   
   // Reads in and verifies if user guessed the secret number
   // Returns the total amount of guesses
   //
   //   Scanner console - the Scanner to use for user input
   //   Random random - the number (int) to be a secret (random) number
   public static int guesses(Scanner console, Random random) {
   
      // Total number of guesses
      int totalNumberGuesses = 1;
      
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE +"...");
      
      // Random number from 1 to MAX_VALUE
      int spin = random.nextInt(MAX_VALUE) + 1;
      
      String plurality = "";
      
      boolean incorrectGuess = true;
      
      // Keeps track of times user inputed numbers.
      while (incorrectGuess) {
         System.out.print("Your guess? ");
         
         int guess = console.nextInt();
         
         
         if (guess > spin) { // secret number is less than guessed number
            System.out.println("It's lower.");
            totalNumberGuesses++;
         } else if(guess < spin) { // secret number is greated than guessed number
            System.out.println("It's higher.");
            totalNumberGuesses++;
         } else { // secret number is equal to guessed number           
            incorrectGuess = false;
         }
      }
      
      if (totalNumberGuesses != 1) {
         plurality = "es"; // in plural
      }

      System.out.println("You got it right in " + totalNumberGuesses +
                               " guess" + plurality + "!");
      
      return totalNumberGuesses;
   }
   
   // Reads in and verifies if user wants to play geam again
   // Returns true if user wats to play again, and false if he/she do not.
   //
   //   Scanner console - the Scanner to use for user input
   public static boolean gamesNum(Scanner console) {
      System.out.print("Do you want to play again? ");
      
      // inputed value to lower case
      String userInput = console.next().toLowerCase();
      boolean again = false;
      
      if (userInput.charAt(0) == 'y'){
         again = true; // when user wants to play again
      }
      
      return again;
   }
   
   // Outputs and calculates statistics of the game
   //
   //   int totalGuesses - amount of total guesses
   //   int totalGames - amount of total games
   //   int best - amount of best games
   public static void printResults (int totalGuesses, int totalGames, int best) {
      double realNumTotalGuesses = totalGuesses;
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("Total games   = " + totalGames);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.println("Guesses/game  = " + round(realNumTotalGuesses/totalGames));
      System.out.println("Best game     = " + best);
   }
   
   // Rounds a given number to two digits.
   // Returns the rounded number.
   //
   //    double number - the number to be rounded
   public static double round(double number) {
      return Math.round(number * 10.0) / 10.0;
   }
   
   
   
}
