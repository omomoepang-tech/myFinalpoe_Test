/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalpart123;



/**
 *
 * @author PC
 */
import java.util.Scanner;
import java.util.List;

public class FinalPart123 {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
        MessageClass.populateTestData();
        
        while(true) {
            System.out.println("\n--- Main Message Menu ---");
            System.out.println("1. Send a Message");
            System.out.println("2. Disregard Message");
            System.out.println("3. Store Message Archive");
            System.out.println("4. Stored Messages Dashboard (Part 3)");
            System.out.println("5. Exit Application");
            System.out.println("Select an option");
            
            int choice = Integer.parseInt(input.nextLine().trim());
            
           
            if (choice == 5) {
                System.out.println("Exiting Application. Goodbye");
                break;
            }
            
            switch (choice) {
                case 1:
                  System.out.print("Enter Recipient Cell: ");
                  String cell = input.nextLine();
                  System.out.print("Enter Mesage Content Text: ");
                  String txt = input.nextLine();
                  MessageClass msgObj = new MessageClass(cell, txt);
                  System.out.println(msgObj.SentMessages(1));
                  break;
                case 2:
                  System.out.println("Feature 2 Execution completed.");
                  break;
                case 3:
                  System.out.println("Feature 3 Archived updated via JSON parser streams.");
                  break;
                case 4:
                  input.nextLine();
                  boolean back = false;
                  while (!back) {
                    System.out.println("\n--- Stored Messages Submenu ---");
                    System.out.println("a. Display the Senders/Recipients");
                    System.out.println("b. Display the Longest Message");
                    System.out.println("c. Search by Mrssage ID");
                    System.out.println("d. Search by Recipient number");
                    System.out.println("e. Delete message by Hash code");
                    System.out.println("f. Generate full report summary");
                    System.out.println("g. Return to main menu");
                    System.out.println("Choose execution action (a-g): ");
                    
                    String subChoice = input.nextLine().toLowerCase().trim();
                    System.out.println("\n[DEBUG] The computer recieved: '" + subChoice + "'");
                    switch (subChoice) {
                case "a":
                  System.out.println(MessageClass.displaySendersRecipients());
                  break;
                case "b":
                  System.out.println("Longest message found:\n\"" + MessageClass.findLongestMessage() + "\"");
                  break;
                case "c":
                  System.out.println("Enter target mesage Id to locate (e.g. MSG004): ");
                  String searchId = input.nextLine();
                  System.out.println(MessageClass.searchById(searchId));
                  break;
                case "d":
                  System.out.println("Enter target phone recipient number (+27......): ");
                  String recipient = input.nextLine();
                  List<String> matchMsgs = MessageClass.searchByRecipient(recipient);
                  if (matchMsgs.isEmpty()) {
                      System.out.println("No matching logs were found for that number");
                  }
                  else {
                    System.out.println("Found messages");
                    for (String msg : matchMsgs) 
                    System.out.println("_ " + msg);
                  }
                  break;
                case "e":
                  System.out.println("Enter a unique message Hash string to delete (e.g HASH002");
                  String targetHash = input.nextLine();
                  System.out.println(MessageClass.deleteMessageByHash(targetHash));
                  break;
                case "f":
                  System.out.println(MessageClass.generateReport());
                  break;
                case "g":
                     back = true;
                  break;
                default:
                  System.out.println("Invalid selection string choice");
                }
            }
            break;
         default:
            }
             System.out.println("Invalid selection choice index number reference");
            }        
        }
    }   
        
         
    

