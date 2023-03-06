// This program will produce a text figure
// that is look like Seattle's Space Needle.


public class SpaceNeedle {

   // Declaring global integer constant "SIZE"
   public static final int SIZE = 4;
   
      public static void main(String[] args) {
      
         // Outputs top part of Space Needle.
         printTop();
         
         // Outputs middle part of Space Needle.
         printMiddle();
         
         // Outputs bottom part of Space Needle.
         printBottom();
        
      }
      
      
      
      // Outputs the tip of the building.
      public static void printTip() {
      
         // Number of rows for the tip of the building.
         for (int lineTip = 1; lineTip <= SIZE; lineTip++) {
         
            // Number of spaces in each row for the tip of the building.
            for (int space = 1; space <= 3 * SIZE; space++) {
            
               System.out.print(" ");
               
            }
            
            // Walls for the tip of the building.
            System.out.println("||");
            
         }
         
      }
      
      
      
      // Outputs the roof part of the building.
      public static void printRoof() {
      
         // Number of rows for the roof part of the building.
         for (int lineRoof = 1; lineRoof <= SIZE; lineRoof++) {
             
            // Number of spaces in each row for the roof of the building.
            for (int space = 1; space <= (-3) * lineRoof + (3 * SIZE); space++) {
           
               System.out.print(" ");
               
            }
            
            // Left wall for roof of the building.
            System.out.print("__/");
            
            // Number of colons for the roof (left side).
            for (int colonLeft = 1; colonLeft <= 3 * lineRoof - 3; colonLeft++) {
               System.out.print(":");
            }
            
            // Middle walls for roof of the building.
            System.out.print("||");
            
            // Number of colons for the roof (right side).
            for (int colonRight = 1; colonRight <= 3 * lineRoof - 3; colonRight++) {
               System.out.print(":");
            }
            
            // Right wall for roof of the building.
            System.out.println("\\__");
            
         }
         
      }
      
      
      
      // Outputs the top part observation platform of the building.
      public static void printObservationPlatformTop() {
      
         // Left wall for observation platform.
         System.out.print("|");
         
            // Number of colons for observation platform.
            for (int quotationMarks = 1; quotationMarks <= 6 * SIZE; quotationMarks++) {
               System.out.print("\"");
            }
            
         // Right wall for observation platform.
         System.out.println("|");
      }
      
      
      
      // Outputs the bottom part observation platform of the building.
      public static void printObservationPlatformBottom() {
      
         // Number of rows for bottom part of observation platform.
         for (int lineBottom = 1; lineBottom <= SIZE; lineBottom++) {
            
            // Number of spaces in each row for bottom part of observation platform.
            for (int space = 1; space <= 2 * lineBottom - 2; space++) {
            
               System.out.print(" ");
               
            }
            
            // Left wall for bottom part of observation platform.
            System.out.print("\\_");
            
            // Number of "arrows" for bottom part of observation platform.
            for (int arrow = 1; arrow <= (-2) * lineBottom + ((3 * SIZE) + 1); arrow++) {
            
               System.out.print("/\\");
               
            }
            
            // Right wall for bottom part of observation platform.
            System.out.println("_/");
            
         }
         
      }
      
      
      
      // Outputs main frame of the building.
      public static void printMainFrame() {
      
         // Number of rows for the main frame.
         for (int lineFrame = 1; lineFrame <= SIZE * SIZE; lineFrame++) {
         
            // Number of spaces in each row for the main frame.
            for (int space = 1; space <= 2 * SIZE + 1; space++){
            
               System.out.print(" ");
               
            }
            
            // Number of percent walls of the main frame.
            for (int linePercent = 1; linePercent <= 2; linePercent++) {
            
               // Left wall of main frame.
               System.out.print("|");
               
                  // Number of percents for each wall.
                  for (int percent = 1; percent <= SIZE - 2; percent++) {
                     System.out.print("%");
                  }
                  
               // Right wall of main frame.
               System.out.print("|");
               
            }
            
            System.out.println();
         }
      }
      
      
      
      // Outputs top part of Space Needle. 
      public static void printTop() {
      
         printTip();
         
         printRoof();
         
         printObservationPlatformTop();
         
         printObservationPlatformBottom();
         
      }
      
      
      
      // Outputs middle part of Space Needle.
      public static void printMiddle() {
      
         printTip();
         
         printMainFrame();
         
      }
      
      
      
      // Outputs bottom part of Space Needle.
      public static void printBottom() {
      
         printRoof();
         
         printObservationPlatformTop();
         
      }
      
}
