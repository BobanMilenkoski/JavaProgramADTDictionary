package proj4;

// Boban Milenkoski

// Prof. John P. Baugh

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ADTDictionary {
    
     Map<String, List<String>> adtDictionary; 
     
     public void read (){
         try{
             File FacultyFile = new File ("C:\\faculty.txt");
             File DepartmentFile = new File ("C:\\departments.txt");
             Scanner FacultyScanner = new Scanner(FacultyFile);
             Scanner DepartmentScanner = new Scanner(DepartmentFile);
             
        adtDictionary = new HashMap<String, List<String>>(); 
            while (DepartmentScanner.hasNextLine()){
                String department = DepartmentScanner.nextLine().trim();
                adtDictionary.put(department, new ArrayList<String>());
            }
            while (FacultyScanner.hasNextLine()){
                String faculty = FacultyScanner.nextLine();
                String[] value = faculty.split(","); 
                adtDictionary.get(value[1].trim()).add(value[0]); 
            }
         }
          catch (FileNotFoundException e) {
              e.printStackTrace();
              
          }     
     }
     public void listAll(){
         for (String key : adtDictionary.keySet()) {  
             for (String value : adtDictionary.get(key)) {
                  System.out.println(value + ", " + key);
             }
         }
     }
     public void listDepartmentName(String department){
         if (null != adtDictionary.get(department)) {  
              for (String name : adtDictionary.get(department)) { 
                  System.out.println(name);
              }
         }
     }
     public void add(String value){
         String[] values = value.split(","); 
         String department = values[0].trim(); 
         String faculty = values[1].trim();  
        
         for (String name : adtDictionary.get(department)) {
             if (name.equalsIgnoreCase(faculty)) { 
                 System.out.println("Cannot add " + name + " BUS because they already exist there.");
                 return;
             }          
         }
         adtDictionary.get(department).add(faculty);
         System.out.println("Ok, added " +faculty);
     }
     public void remove (String value){
          String[] values = value.split(",");       
          String department = values[0].trim();
          String faculty = values[1].trim();
          adtDictionary.get(department).remove(faculty);
          System.out.println("OK, removed  " +faculty+ " from BUS");
          
     }
    
}
