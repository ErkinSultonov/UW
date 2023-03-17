// The Assassin Manager class represents a game called “Assassin.”
// In this game people kill (not really kill but catch or tag each other)
// their target person. Person who have been assassinated goes to 
// graveyard. Person who successfully assassinated his/her target, will 
// have new target and continues playing the game. The game is over 
// when only one "Assassin" remains alive.
//
// The Assassin Manager class is not sensitive to capitalization 
// of letters (it treats uppercase letters same as lowercase letters).

import java.util.*;

public class AssassinManager {

   private AssassinNode killRing;  // List of alive assassins (Kill ring)
   private AssassinNode graveyard; // List of dead assassins (Graveyard)
   
   
  /* 
   * Constructs a new list of assassins from given list of names.
   * @throws - IllegalArgumentException if given list is empty.
   * @param names - list of participants' names, to be used to
   *                add to list of assassins.
   */
   public AssassinManager(List<String> names) {
      if (names.isEmpty()) {
         throw new IllegalArgumentException();
      }
      for (int i = names.size() - 1; i >= 0; i--) {
         killRing = new AssassinNode(names.get(i), killRing);
      }
   }
   
   
  /* 
   * Displays names of the people in the kill ring, and who is stalking them.
   * When game is over it shows that person who won is stalking himself/herself.
   */
   public void printKillRing() {
      String verb = " is stalking ";
      String spaces = "    ";
      AssassinNode current = killRing;
      while (current.next != null) {
         System.out.println(spaces + current.name + verb + current.next.name);
         current = current.next;
      }
      System.out.println(spaces + current.name + verb + killRing.name);
   }
   
   
  /* 
   * Displays names of the people in graveyard, and by whom they were killed.
   * Ignores if no one "died."
   */
   public void printGraveyard() {
      if (graveyard != null) {
         String verb = " was killed by ";
         String spaces = "    ";
         AssassinNode current = graveyard;
         while (current != null) {
            System.out.println(spaces + current.name + verb + current.killer);
            current = current.next;
         }
      }
   }
   
   
  /* 
   * Searches given name from list of assassins who is currently allive (in kill ring).
   * @param name - name that is needs to be searched in the list of alive assassins.
   * @return - true if given name is in the list of alive assassins,
   *           false if not.
   */
   public boolean killRingContains(String name) {
      return consistsOf(name, killRing);
   }
   
   
  /* 
   * Searches given name from list of assassins who is currently "dead" (in graveyard).
   * @param name - name that is needs to be searched in the list of "dead" assassins.
   * @return - true if given name is in the list of "dead" assassins,
   *           false if not.
   */
   public boolean graveyardContains(String name) {
      return consistsOf(name, graveyard);
   }
   
   
  /* 
   * Checks whether game is over or not.
   * @return - true if only one assassin is currently allive,
   *           false if not.
   */
   public boolean gameOver() {
      return killRing.next == null;
   }
   
   
  /* 
   * Displays the name of winner. Winner is the player (or assassin) who survived.
   * @return - name of the winner, if game is over.
   *           null if game is not yet over.
   */
   public String winner() {
      if (gameOver()) {
         return killRing.name;
      }
      return null;
   }
   
   
  /* 
   * Searches the player with the given name and "kills" that specific assassin.
   * After "killing" transfers the killed assassin to graveyard (list of dead assassins).
   * @throws - IllegalStateException if game is over.
   * @throws - IllegalArgumentException if there is no player with given
               name in the list of alive assassins.
   * @param name - name of player who will be assassinated.
   */
   public void kill(String name) {
      if (gameOver()) {
         throw new IllegalStateException();
      } else if (!killRingContains(name)) {
         throw new IllegalArgumentException();
      }
      
      AssassinNode current = killRing;
      AssassinNode previous = graveyard;
      
      // Checks weather player is in the beggining of the list, or not. 
      if (current.name.equalsIgnoreCase(name)) {
         graveyard = killRing;
         while(current.next != null){
            current = current.next;
         }
         killRing.killer = current.name;
         // Removes player with given name from list of alive assassins
         killRing = killRing.next;
         
      } else {
         while (!current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
         }
         graveyard = current.next;
         graveyard.killer = current.name;
         // Removes player with given name from list of alive assassins
         current.next = current.next.next;
      }
      graveyard.next = previous;
   }
   
   
  /* 
   * Searches a player with a given name from given list of players.
   * @param name - the name of the player to be found in the list.
   * @param participants - list of players where the player is searched.
   * @return - true if given name is in the given list,
   *           false if not.
   */
   private boolean consistsOf(String name, AssassinNode participants) {
      AssassinNode current = participants;
      while (current != null) {
         if (current.name.equalsIgnoreCase(name)) {
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
}
