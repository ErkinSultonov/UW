// This program will encrypt a message for secret transmission to another person.

import java.util.*;


public class EncryptionMachine {
   // Global constants ALPHABET and SHIFT
   public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
   public static final int SHIFT = 3;
   
   public static void main(String[] args) {
   
      // New Scanner variable
      Scanner userInput = new Scanner(System.in);
      
      // Introductary messege
      printIntroductaryMessage();    
      
      // Shared keyword message
      printSharedKeywordMessage(userInput); 
      
      // Word count message
      printWordCountMessage(userInput);
      
   }
   
   // Encrypts the message and outputs encrypted message.
   //    String plainText - the text (string) to be encrypted.
   public static void encrypting(String plainText) {
      
      // Number of letters in constant ALPHABET
      int alphabetLength = ALPHABET.length();
     
      // Keeps track of every letter in word
      for(int i = 0; i <= plainText.length() - 1; i++){
          System.out.print( ALPHABET.charAt( ( ALPHABET.indexOf( plainText.charAt(i) )
          + SHIFT) % alphabetLength ) );
      }
      
   }
   
   // Outputs introductary message.
   public static void printIntroductaryMessage() {
   
      System.out.println("Welcome to the CSE142 Encryption Machine!");
      System.out.println("The program lets you encrypt a message");
      System.out.println("with a key so your recipient can decrypt.");
      System.out.println();
      
   }

   // Outputs encrypted kewyword
   //    Scanner userInput - the text (string) to be encrypted.
   public static void printSharedKeywordMessage(Scanner userInput) {
      
      System.out.println("Encrypted messages use a shared keyword to decrypt.");
      System.out.print("  Enter key: ");
      String keyword = userInput.next();
      System.out.print("    \"" + keyword + "\"" + " has been encrypted to: ");
      encrypting(keyword);
      System.out.println();
      
   }
   
   // Outputs question message anout number of words.
   //    Scanner userInput - the number of words to be encrypted.
   public static void printWordCountMessage(Scanner userInput) {
      System.out.println();
      System.out.print("How many words are in your message? ");
      
      int wordCount = userInput.nextInt();
      
      // Keeps track of number of words to be encrypted. 
      for(int i = 1; i <= wordCount; i++) {
      
         System.out.print("  Next word: ");
         String word = userInput.next();
         System.out.print("    \"" + word + "\"" + " has been encrypted to: ");
         encrypting(word);
         System.out.println();
         
      }
      
      System.out.println();
      // Ending
      System.out.println("Message fully encrypted. Happy secret messaging!");
   }

}
