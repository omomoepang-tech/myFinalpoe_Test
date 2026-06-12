/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpart123;

/**
 *
 * @author PC
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageClass {
    

// Part 1&2 variables
    private String recipientCell;
    private String messageText;
    
    // Static variables
    private static int totalMessagesSent = 0;
    private static List<String> sentMessagesLog = new ArrayList<>();
    
    //Part 3 static parallel arrays
    public static String[] sentMessages = new String[10];
    public static String[] disregardedMessages = new String[10];
    public static String[] storedMessages = new String[10];
    public static String[] messageHashes = new String[10];
    public static String[] messageIds = new String[10];
    public static String[] recipients = new String[10];
    public static int count = 0;
    
    //Testing text messages
    public static String[] testMessageText = {
        "Did you get the cake?",
        "Where are you? You are late! I asked you to be on time.",
        "Yohoooo, I am at your gate.",
        "It is dinner time!",
        "OK, I am leaving without you."
    };
    
    //Part 1&2 Methods
    public MessageClass(String recipientCell, String messageText) {
        this.recipientCell = recipientCell;
        this.messageText = messageText;
    }
    
    public MessageClass() {}
    
    public String getRecipientCell() {
        return this.recipientCell != null ? this.recipientCell: "+27123456789";
    }
    
    public String getMessageText() {
        return this.messageText != null ? this.messageText: "JSON Test";
    }
    
    public String getMessageId() {
        return "MSG" + (int)(Math.random() * 1000);
    }
    
    public String checkRecipientCell() {
        if (recipientCell.startsWith("+") || recipientCell.length() <= 12) {
            return "Valid Recipient";            
        }
        return "Invalid Recipient";
    }
    
    public String createMessageHash() {
        return "HASH_" + (messageText != null ? messageText.toUpperCase().replaceAll("\\s+", "") : "HELLOWORLD");
    }
    
    // Sent message action processing
    public String  SentMessages(int choice) {
        totalMessagesSent++;
        if(choice == 1) return "Message successfully sent";
        if(choice == 2) return "Messages deleted successfully";
        if(choice == 3) return "Messages successfully stored";
        return "Invalid choice";
    }
    
    //Print messages
    public String printMessages() {
        return "Recipient: " + recipientCell + "\nMesssage: " + messageText;
    }
    
    public static int returnTotalMessages() {
        return totalMessagesSent;
    }
    
    public void storeMessage()  {
        
    }
    
    //Part 3
    public static void populateTestData() {
        count = 0;
        
    //Total messages sent
    
    //Message 1 - SENT
    recipients[0] = "+27834557896"; messageIds[0] = "MSG001"; messageHashes[0] = "HASH001";
    sentMessages[0] = testMessageText[0]; disregardedMessages[0] = ""; storedMessages[0] = "";
    
    //Message 2 - STORED
    recipients[1] ="+27838884567"; messageIds[1] = "MSG002"; messageHashes[1] = "HASH002";
    sentMessages[1] = ""; disregardedMessages[1] = ""; storedMessages[1] = testMessageText[1];
            
    //Message 3 - DISREGARDED
    recipients[2] ="+27834448567"; messageIds[2] = "MSG003"; messageHashes[2] = "HASH003";
    sentMessages[2] = ""; disregardedMessages[2] = ""; storedMessages[2] = testMessageText[2];
    
    //Message 4 - SENT
    recipients[3] ="0838884567"; messageIds[3] = "MSG004"; messageHashes[3] = "HASH004";
    sentMessages[3] = ""; disregardedMessages[3] = ""; storedMessages[3] = testMessageText[3];
    
   //Message 5 - STORED
   recipients[4] ="+27838884567"; messageIds[4] = "MSG005"; messageHashes[4] = "HASH005";
   sentMessages[4] = ""; disregardedMessages[4] = ""; storedMessages[4] = testMessageText[4];
   
  count = 5;
    }
    
    //Display senders & recievers
    public static String displaySendersRecipients() {
        StringBuilder output = new StringBuilder("--- Senders & Recipients ---\n");
        for (int i = 0; i< count; i++) {
            if (messageIds[i] != null) {
                output.append("ID: ").append(messageIds[i]).append(" | Number: ").append(recipients[i]).append(testMessageText);
            }
        }
        return output.toString();
    }
        
        //Find the message
        public static String findLongestMessage() {
            String longest = "";
            for (int i = 0; i < count; i++) {
                if (messageIds[i] != null && testMessageText[i].length() > longest.length()) {
                        longest = testMessageText[i];
            }
        }
        return longest;
    }
     
    //Search ID
    public static String searchById(String searchId) {
        for (int i = 0; i < count; i++) {
            if (messageIds[i] != null && messageIds[i].equalsIgnoreCase(searchId)) {
                return "Recipient: " + recipients[i] + " | Message: " + testMessageText[i] ;
        }
    }
    return "Message ID not found.";
}

//Search Recipient
    public static List<String> searchByRecipient(String recipient) {
        List<String> results = new ArrayList<>();
         for (int i = 0; i < count; i++) {
             if (messageIds[i] != null && recipients[i].equals(recipient)) {
                 results.add(testMessageText[i]);
         }             
    }
    return results;
}
    
//Delete by hash code
public static String deleteMessageByHash(String hash) {
    for (int i = 0; i < count; i++) {
        if (messageHashes[i] != null && messageHashes[i].equals(hash)) {
            String deletedText = testMessageText[i];
            messageIds[i] = null;
            sentMessages[i] = null;
            storedMessages[i] = null;
            disregardedMessages[i] = null;
            messageHashes[i] = null;
            return "Message: \""+ deletedText + "\" successfully deleted.";
        }
    }
    return "Hash code match assignment record not found.";
}

//Status report layout ouput
public static String generateReport() {
StringBuilder report = new StringBuilder("==== FULL MESSAGES REPORT ===\n");
for (int i = 0; i < count; i++) {
    if (messageIds[i] != null) {
        report.append("Hash: ").append(messageHashes[i])
              .append(" | Recipient: ").append(recipients[i])
              .append(" | Message: ").append(testMessageText[i])
              .append("\n");
        }
    }  
    return report.toString();
}

//Test 1 processing
public static List<String> getSentMessagesOnly() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
        if (messageIds[i] != null && !sentMessages[i].isEmpty()) {
            list.add(testMessageText[i]);
       }
    }
    return list;
}
}
    
       
    
