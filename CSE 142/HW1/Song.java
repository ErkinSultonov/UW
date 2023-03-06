// This program will produce as output a cumulative song,
// in which successive verses build on previous verses.



public class Song {
   public static void main(String[] args){
   
      // Beginning of fly (first) verse
      printBeginningFlyVerse();
      printEndOfVerse();
      // End of fly (first) verse
      
      System.out.println();
      
      // Beginning of spyder (second) verse
      printBeginningSpiderVerse();
      printMiddleSpiderFlyVerse();
      printEndOfVerse();
      // End of spyder (second) verse
      
      System.out.println();
      
      // Beginning of bird (third) verse
      printBeginningBirdVerse();
      printMiddleBirdSpiderVerse();
      printMiddleSpiderFlyVerse();
      printEndOfVerse();
      // End of bird (third) verse
      
      System.out.println();
      
      // Beginning of Cat (fourth) verse
      printBeginningCatVerse();
      printMiddleCatBirdVerse();
      printMiddleBirdSpiderVerse();
      printMiddleSpiderFlyVerse();
      printEndOfVerse();
      // End of Cat (fourth) verse
      
      System.out.println();
      
      // Beginning of Dog (fifth) verse
      printBeginningDogVerse();
      printMiddleDogCatVerse();
      printMiddleCatBirdVerse();
      printMiddleBirdSpiderVerse();
      printMiddleSpiderFlyVerse();
      printEndOfVerse();
      // End of Dog (fifth) verse
      
      System.out.println();
      
      // Beginning of Cow (sixth) verse
      printBeginningCowVerse();
      printMiddleCowDogVerse();
      printMiddleDogCatVerse();
      printMiddleCatBirdVerse();
      printMiddleBirdSpiderVerse();
      printMiddleSpiderFlyVerse();
      printEndOfVerse();
      // End of Cow (sixth) verse
      
      System.out.println();
      
      // Beginning of Horse (seventh) verse
      printHorseVerse();
      // End of Horse (seventh) verse
   } 
   
   // Outputs the begining of 1st verse, about a fly, when called in main() method.
   public static void printBeginningFlyVerse() {
      System.out.println("There was an old woman who swallowed a fly.");
   }
   
   // Outputs the begining of 2nd verse, about a spider, when called in main() method.
   public static void printBeginningSpiderVerse() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
   }
   
   // Outputs the begining of 3rd verse, about a bird, when called in main() method.
   public static void printBeginningBirdVerse() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
   }
   
   // Outputs the begining of 4th verse, about a cat, when called in main() method.
   public static void printBeginningCatVerse() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
   }
   
   // Outputs the begining of 5th verse, about a dog, when called in main() method.
   public static void printBeginningDogVerse() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
   }
   
   // Outputs the begining of 6th verse, about a cow, when called in main() method.
   public static void printBeginningCowVerse() {
      System.out.println("There was an old woman who swallowed a cow,");
      System.out.println("Who would allow to swallow a cow.");
   }
   
   // Outputs the middle part of 2nd verse,
   // about a spider and fly, when called in main() method.
   public static void printMiddleSpiderFlyVerse() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   // Outputs the middle part of 3rd verse,
   // about a bird and spider, when called in main() method.
   public static void printMiddleBirdSpiderVerse() {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   
   // Outputs the middle part of 4th verse,
   // about a cat and bird, when called in main() method.   
   public static void printMiddleCatBirdVerse() {
      System.out.println("She swallowed the cat to catch the bird,");
   }
   
   // Outputs the middle part of 5th verse,
   // about a dog and cat, when called in main() method.
   public static void printMiddleDogCatVerse() {
      System.out.println("She swallowed the dog to catch the cat,");
   }
   
   // Outputs the middle part of 6th verse,
   // about a cow and dog, when called in main() method.
   public static void printMiddleCowDogVerse() {
      System.out.println("She swallowed the cow to catch the dog,");
   }
   
   // Outputs the entire 7th verse scince it is unique,
   // about a horse, when called in main() method.
   public static void printHorseVerse() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   // Outputs the ending of every verse except 7th
   // when called in main() method.
   public static void printEndOfVerse() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
}
