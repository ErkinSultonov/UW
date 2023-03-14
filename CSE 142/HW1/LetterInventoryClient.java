import java.util.*;
import java.io.*;

public class LetterInventoryClient{
   public static void main(String[] args) throws IOException{
      LetterInventory inventory1 = new LetterInventory("George W. Bush");
      LetterInventory inventory2 = new LetterInventory("Hillary Clinton");
      System.out.println(inventory1.subtract(inventory2));
      System.out.println(inventory1.toString());
   }
}
