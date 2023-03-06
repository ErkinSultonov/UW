// This program will produce text art (ASCII art),
// in my case it is a house.



public class AsciiArt {
   public static void main(String[] args) {
   
      // Roof of the house
      printRoof();
      
      // First floor of the house
      printFirstFloor();
      
      // Basement of the house
      printBasement();
      
   }
   
   // Outputs roof part of the house.
   public static void printRoof() {
   
      // Number of rows for the roof of the house.
      for (int lineRoof = 1; lineRoof <= 6; lineRoof++){
      
         // Number of spaces for each row of the house. 
         for (int space = 1; space <= (-1) * lineRoof + 6; space++){
         
            System.out.print(" ");
            
         }
         
         // Number of plus signs for each row of the house.
         for (int plusSign = 1; plusSign <= 2 * lineRoof + 6; plusSign++){
         
            System.out.print("+");
            
         }
         
         System.out.println();
      }
   }
   
   // Outputs the first floor of the house.
   public static void printFirstFloor() {
   
      // Number of rows for the first floor of the house.
      for (int lineFirstFloor = 1; lineFirstFloor <= 4; lineFirstFloor++){
      
         // Left wall for each row.
         System.out.print(" |");
         
         // Number of minus signs for the first floor of the house.
         for (int minusSign = 1; minusSign <= 14; minusSign++){
         
            System.out.print("-");
            
         }
         
         // Right wall for each row.
         System.out.println("| ");
      }
   }
   
   // Outputs the basement of the house.
   public static void printBasement() {
   
      // Number of rows for the basement of the house.
      for (int lineBasement = 1; lineBasement <= 3; lineBasement++){
      
         // Left wall for each row.
         System.out.print(" |");
         
         // Number of hashtag signs for the first floor of the house.
         for (int hashtagSign = 1; hashtagSign <= 14; hashtagSign++){
         
            System.out.print("#");
            
         }
         
         // Right wall for each row.
         System.out.println("| ");
         
      }
   }
}
