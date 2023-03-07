// This program will prompt a user for income and expense amounts,
// then calculates user's net monthly income and expense.


import java.util.*;

public class Budgeter {
   
   // Global constant DAYS_IN_MONTH
   public static final int DAYS_IN_MONTH = 31;
   
   public static void main(String[] args) {
      
      // New Scanner variable
      Scanner console = new Scanner(System.in);
      
      // Introduction message
      printIntro();
      
      // Income message
      double income = getIncomeOrExpence(console, "income");
      
      // Type of Expense: monthly or daily
      int expenseType = askExpenseType(console);
      
      // Expense message
      double expense = getIncomeOrExpence(console, "expense");
      
      // Total income and expense
      printTotal(expenseType, income, expense);
      
   }
   
   
   // Outputs an introduction to the program.
   public static void printIntro() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   // Reads in and computes the total amount of income or expence
   // Returns the total amount of income or expence
   //
   //   Scanner console - the Scanner to use for user input
   //   String text - the text (string) to be used in naming categories
   public static double getIncomeOrExpence(Scanner console, String text) {
      System.out.print("How many categories of " + text + "? ");
      int categoryNum = console.nextInt();
      double total = 0;
      
      // Keeps track of number of categories to be summed.
      for(int amountNum = 1; amountNum <= categoryNum; amountNum++) {
         System.out.print("    Next " + text + " amount? $");
         double amount = console.nextDouble();
         total += amount;
      }
      
      System.out.println();
      return total;
   }
   
   // Reads in a given number and
   // returns 1 or 2 based on user input:
   // will return 1 if user selected monthly expence,
   // and 2 if user selected daily expence
   //
   //   Scanner console - the Scanner to use for user input
   public static int askExpenseType(Scanner console) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int expenceType = console.nextInt();
      if (expenceType == 1) {
         return 1;
      } else {
         return 2;
      }
      
   }
   
   
   // Computes the total amount of income and expence with income categories
   // and expences
   //
   //   int expenseType - the integer number to be used to distinguish
   //   between income and expense
   //   double income - the real type number to be used in caculating total income
   //   double expense - the real type number to be used in caculating total expence
   public static void printTotal(int expenseType, double income, double expense) {
      
      // Initial value for total expense
      double totalExpense = 0;
      
      // Initial value for total expense per day
      double expensePerDay = 0;
      
      // Number of income per day
      double incomePerDay = income / DAYS_IN_MONTH;
      
      if (expenseType == 1) {
         totalExpense = expense;
         expensePerDay = expense / DAYS_IN_MONTH;
      } else if (expenseType == 2) {
         totalExpense = expense * DAYS_IN_MONTH;
         expensePerDay = expense;
      }
      
      System.out.println("Total income = $" + round(income) +
      " ($"+ round(incomePerDay) + "/day)");
      System.out.println("Total expenses = $" + round(totalExpense) +
      " ($"+ round(expensePerDay) + "/day)");
      System.out.println();
      
      // Difference between monthly income and monthly expense
      double difference = income - totalExpense;
      
      // Initial value for category
      String category = "";
      
      // Initial value for custom message
      String customMessage = "";
      
      
      if(difference <= 0 && difference > -250) {
         category = "spender";
         customMessage = "cookie";
      } else if (difference <= -250) {
         category = "big spender";
         customMessage = "bottle of water";
      } else if (difference > 0 && difference <= 250) {
         category = "saver";
         customMessage = "slice of pizza";
      } else if (difference > 250) {
         category = "big saver";
         customMessage = "whole pizza!";
      }
      
      // Initial value for first part of message
      String message1 = "";

      // Initial value for second part of message
      String message2 = "";

      if(difference <= 0) {
         message1 = "spent";
         message2 = "earned";
      } else if (difference > 0) {
         message1 = "earned";
         message2 = "spent";
      }
      
      System.out.println("You " + message1 + " $" + round( Math.abs(difference) ) +
      " more than you " + message2 + " this month.");
      System.out.println("You're a " + category + ".");
      System.out.println("You deserve a " + customMessage);
   }
   
   // Rounds a given number to two digits.
   // Returns the rounded number.
   //
   //    double number - the number to be rounded
   public static double round(double number) {
      return Math.round(number * 100.0) / 100.0;
   }
   
   
   
}
