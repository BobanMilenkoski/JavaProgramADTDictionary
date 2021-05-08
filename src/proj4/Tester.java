package proj4;

// Boban Milenkoski
// CIS 2353
// Winter 2020
// Prof. John P. Baugh

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {
    
    
    
    public static void menu() {    
        System.out.println("Welcome the Faculty Directory Program");
        System.out.println("Use commands:"); 
        System.out.println("list all");            
        System.out.println("list DEPT_NAME");    
        System.out.println("add DEPT_NAME, FIRST LAST");
        System.out.println("remove DEPT_NAME, FIRST LAST");      
        System.out.println("exit");
    } 
     
    ADTDictionary dictionary; 
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) { 
         
        menu(); 
        String command;
         
         
         Tester tester = new Tester();
         tester.dictionary = new ADTDictionary();
         tester.dictionary.read();
         
        Scanner scanner;
        scanner = new Scanner(System.in);
         do{
             System.out.print(">>"); 
             command = scanner.nextLine().trim(); 
              if (!command.equals("exit")) {  
                   tester.action(command);
              }
              else{
                  System.out.println("Goodbye! Have a nice day!");
              }
         }
         while (!command.equalsIgnoreCase("exit"));
     }
      public void action(String command) {
          if (command.equalsIgnoreCase("LIST ALL")) { 
              dictionary.listAll();           
          }
          else if (command.toUpperCase().contains("LIST")) { 
              command = command.substring(5, command.length());
              dictionary.listDepartmentName(command);                   
          }
          else if (command.toUpperCase().contains("ADD")) { 
              command = command.substring(4, command.length());
               dictionary.add(command);
          }
          else if (command.toUpperCase().contains("REMOVE")) { 
               command = command.substring(6, command.length()); 
               dictionary.remove(command);
          }
      }
    
}
