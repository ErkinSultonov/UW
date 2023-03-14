// The Letter Inventory class represents a list of alphabetical
// characters in a given word or a combination of characters.

public class LetterInventory {
   public static final int LETTER_COUNTS = 26;

   private int size;            // current number of characters in the list
   private int[] inventoryData; // list of alphabetical characters
   
   
  /* 
   * Constructs an inventory (a count) of the alphabetic letters in a given
   * word or a combination of characters
   * @param data - combination of characters to be used to keep track of 
   *               number of times each alphabetical letter used in it
   */
   public LetterInventory(String data) {
      data = data.toLowerCase();
      inventoryData = new int[LETTER_COUNTS];
      for (int i = 0; i < data.length(); i++) {
         if (Character.isLetter(data.charAt(i))) {
            inventoryData[data.charAt(i) - 'a']++;
            size++;
         }
      }
   }
   
   
  /* 
   * Counts how many of given letter are in the inventory.
   * @throws - IllegalArgumentException if given character is non-alphabetic.
   * @param letter - character to be searched in inventory and 
   *                 given how many of it is in the inventory.
   * @return - how many of given letter are in the inventory. 
   */
   public int get(char letter) {
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      
      return inventoryData[letter - 'a'];
   }
   
   
  /* 
   * Sets the count for the given letter to the given value.
   * @throws - IllegalArgumentException if given character is non-alphabetic
   *           or given value is negative.
   * @param letter - character to be searched in inventory and 
   *                 set a given value.
   * @param value - integer value to be used to set a count to a given letter.
   */
   public void set(char letter, int value) {
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      size -= inventoryData[letter - 'a'];
      inventoryData[letter - 'a'] = value;
      size += value;
   }
   
   
  /* 
   * Displays the size of an inventory.
   * @return - current number of elements in the inventory.
   */
   public int size() {
      return size;
   }
   
   
  /* 
   * Checks emptiness of an inventory.
   * @return - true if inventory is empty, false if not.
   */
   public boolean isEmpty() {
      return size == 0;
   }
   
   
  /* 
   * Displays the inventory (list) of letters.
   * @return - a list of letters in inventory.
   */
   public String toString() {
      String outcome = "";
      for (int i = 0; i < inventoryData.length; i++) {
         for (int j = 0; j < inventoryData[i]; j++) {
            outcome += (char) (i + 'a');
         }
      }
      
      return "[" + outcome + "]";
   }
   
   
  /* 
   * Constructs a new inventory of letters that represents the combination
   * of this letter inventory and the other given letter inventory.
   * @param other - the given letter inventory to be added (combined) 
   *                with another letter inventory.
   * @return - a new letter inventory, which is a combination of two 
   *           letter inventories.
   */
   public LetterInventory add(LetterInventory other) {
      LetterInventory addition = new LetterInventory("");
      for (int i = 0; i < LETTER_COUNTS; i++) {
         char tempChar = (char) (i + 'a');
         int value = other.get(tempChar) + inventoryData[i];
         addition.set(tempChar, value);
      }
      
      return addition;
   }
   
   
  /* 
   * Constructs a new inventory of letters that represents the subtraction
   * of this letter inventory and the other given letter inventory
   * @param other - the given letter inventory to be subtracted 
   *                with another letter inventory
   * @return - a new letter inventory, which is difference (subtraction) of two
   *           letter inventories. Returns null if resulting count of letters
   *           is negative
   */
   public LetterInventory subtract(LetterInventory other){
      LetterInventory subtraction = new LetterInventory("");
      for (int i = 0; i < LETTER_COUNTS; i++) {
         char tempChar = (char) (i + 'a');
         int value = inventoryData[i] - other.get(tempChar);
         if (value < 0) {
            return null;
         }
         subtraction.set(tempChar, value);
      }
      
      return subtraction;
   }
}

