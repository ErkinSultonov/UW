// This program will process an input file containing 
// the results of a personality test for a number of people
// and determine each person's Keirsey personality type

import java.util.*;
import java.io.*;

public class Personality {
   
   
   public static final int DIMENSIONS = 4;
   
   public static void main(String[] args) throws FileNotFoundException {
      
      // New Scanner variable
      Scanner console = new Scanner(System.in);
      String choice = "";
      
      // Introduction
      printIntro();
      
      // Input file name
      System.out.print("input file name? ");
      choice = console.nextLine();
      Scanner input = new Scanner(new File(choice));
      
      // Output file name
      System.out.print("output file name? ");
      choice = console.nextLine();
      PrintStream output = new PrintStream(new File(choice));
      
      // Keeps track of lines in the file
      while (input.hasNextLine()) {
         // Name of person  
         String name = input.nextLine();
         // Answers of personality test
         String answers = input.nextLine();
         
         // counts of answers (A and B)
         int[] countB = new int[DIMENSIONS];
         int[] countA = new int[DIMENSIONS];
         getCounts(answers, countA, countB);
         
         // percentage of B answers in each dimension
         int[] percentage = getPercentage(countA, countB);
         
         // Type of personality
         String personalityType = getPersonalityType(percentage);
         
         // Result for each person in the list
         output.println(name + ": " + Arrays.toString(percentage) + " = " + personalityType);
      }
      

   }
   
   // Outputs introduction for the program
   public static void printIntro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // Computes the A/B counts for each dimension
   //
   //    String answersLine - the String of answers for a particular person
   //    int[] countA - array for A answer counts
   //    int[] countB - array for B answer counts
   public static void getCounts(String answerLine, int[] countA, int[] countB) {
      
      for (int column = 0; column < answerLine.length(); column++) {
         char answer = answerLine.toLowerCase().charAt(column);
         if (column % 7 < 1) { // the first question in each group
            tallyAnswer(countA, countB, answer, 0);
         } else if (column % 7 < 3) { // the next two questions in each group
            tallyAnswer(countA, countB, answer, 1);
         } else if (column % 7 < 5) { // the next two questions in each group
            tallyAnswer(countA, countB, answer, 2);
         } else { // last two questions in each group
            tallyAnswer(countA, countB, answer, 3);
         }
      }
      
   }
   
   // Increments the appropriate counter in the given array for the given answer.
   //
   //    int[] countA - array of counts to tally in (A responses)
   //    int[] countB - array of counts to tally in (B responses)
   //    char answer - response to count
   //    int index - index of dimension to increment
   public static void tallyAnswer(int[] countA, int[] countB, char answer, int index) {
      if (answer == 'a') {
         countA[index]++;
      } else if (answer == 'b') {
         countB[index]++;
      }
   }
   
   // Calculates the percentage of B responses in each dimension
   // Returns an array of percentages of B for each dimension
   //
   //    int[] countA - array of counts for A responses 
   //    int[] countB - array of counts for B responses
   public static int[] getPercentage(int[] countA, int[] countB) {
      int[] percentageB = new int[DIMENSIONS];
      for(int slot = 0; slot < DIMENSIONS; slot++){
         percentageB[slot] = (int)Math.round(((double)countB[slot] * 100) /
                                             (countA[slot] + countB[slot]));
      }
      
      return percentageB;
   }
   
   // Identifies personality type according to percentage of B in each dimension
   // Returns personality types for particular person
   //
   //    int[] percentage - array of B percentage
   public static String getPersonalityType(int[] percentage) {
      // All personal types/dimensions
      String personalityType = "EISNTFJP";
      String result = "";
      
      for(int slot = 0; slot < DIMENSIONS; slot++){
         if (percentage[slot] > 50) { // number of B is more than 50%
            result += personalityType.charAt((slot * 2) + 1);
         } else if (percentage[slot] < 50) { // number of B is less than 50%
            result += personalityType.charAt(slot * 2);
         } else { // number of B is equal to 50%
            result += "X";
         }
      }
      
      return result;
   }
      
}
