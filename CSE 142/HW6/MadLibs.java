// This program will prompt the user to fill in
// placeholers in short stories (Mad Libs)
// and will output result for user

import java.io.*;
import java.util.*;

public class MadLibs {
   
   public static void main(String[] args) throws FileNotFoundException{
      
      // New Scanner variable
      Scanner console = new Scanner(System.in);
      
      // Introduction
      printIntro();
      
      // Willingness of the user to continue using program
      boolean again = true;
      
      String choice = "";
      
      // Keeps track if the user wants to continue or quit.
      while(again){
         
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         choice = console.nextLine();
         
         if(choice.equalsIgnoreCase("c")) { // When user choses to create mad-lib
            
            Scanner input = askFileName(console);
            System.out.print("Output file name: ");
            PrintStream output = new PrintStream(new File(console.nextLine()));
            System.out.println();
            createMadLib(input, output, console);
            
         } else if (choice.equalsIgnoreCase("v")) { // When user choses to view mad-lib
            
            Scanner input = askFileName(console);
            fileOutput(input);
            
         } else if (choice.equalsIgnoreCase("q")) { // When user choses to quit
            
            again = false;
            System.out.println();
         }
         
      }
      
   }
   
   // Outputs introduction for the program
   public static void printIntro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // Prompt for an input file until a file that exists is given.
   // Returns a Scanner connected to that file.
   //
   //    Scanner console - the Scanner to use for user input
   public static Scanner askFileName(Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: ");
      File inFile = new File(console.nextLine());
      
      // Keeps track wheather the file exists
      while (!inFile.exists()) {
         System.out.print("File not found. Try again: ");
         inFile = new File(console.nextLine());
      }
      return new Scanner(inFile);
   }
   
   
   // Prompts the user to fill in blanks (placeholders) in existing mad-libs
   //
   //    Scanner input - the Scanner to use for input file
   //    PrintStream output - the PrintStream to print output to
   //    Scanner console - the Scanner to use for user input
   public static void createMadLib(Scanner input, PrintStream output, Scanner console){
      
      // Keeps track of lines in the file
      while(input.hasNextLine()){
         String processLine = input.nextLine();
         Scanner line = new Scanner(processLine);
         String article = "";
         String result = "";
         
         // Keeps track of words (tokens) in the file
         while(line.hasNext()){
            String token = line.next();
            
            // looks for token which starts with "<" and ends with ">"
            if(token.startsWith("<") && token.endsWith(">")){
               
               token = token.substring(1, token.length() - 1).replace("-", " ");
               if(token.toLowerCase().charAt(0) == 'a' ||
               token.toLowerCase().charAt(0) == 'e' ||
               token.toLowerCase().charAt(0) == 'i' ||
               token.toLowerCase().charAt(0) == 'o' ||
               token.toLowerCase().charAt(0) == 'u'){
                  // changes indefinite article to "an"
                  // when placeholder begins with a vowel
                  article = "an";
               } else {
                  // changes indefinite article to "a"
                  // when placeholder does not begin with a vowel
                  article = "a";
               }
               System.out.print("Please type " + article + " " + token + ": ");
               String changeWord = console.nextLine();
               token = changeWord;
               
            }
            result += token + " ";
         }
         output.println(result);
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
      
   }
   
   // Outputs the file chosen by the user
   //
   //    Scanner input - the Scanner to use for input file
   public static void fileOutput(Scanner input) {
      System.out.println();
      // Keeps track of lines in the file
      while (input.hasNextLine()) {
         String line = input.nextLine();
         System.out.println(line);
      }
      System.out.println();
   }
   
}
