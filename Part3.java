/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cahtapppart1;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author neoen
 */
public class Part3 {
    
    // i created arrays to store all the different types of messages
    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<Long> messageIDs = new ArrayList<>();
    static ArrayList<String> recipients = new ArrayList<>();
    
    // i created a counter to keep track of how many messages i have
    static int totalMessages = 0;
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // i populate my arrays with the test data from the assignment
        populateTestData();
        
        // i show the main menu to the user
        boolean running = true;
        while(running){
            System.out.println("\n--- Welcome to QuickChat ---");
            System.out.println("1 - Send Message");
            System.out.println("2 - Show Recent Messages");
            System.out.println("3 - Quit");
            System.out.println("4 - Stored Messages");
            System.out.println("Choose an option:");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if(choice == 1){
                sendMessage();
            } else if(choice == 2){
                displayReport();
            } else if(choice == 3){
                System.out.println("Goodbye!");
                running = false;
            } else if(choice == 4){
                storedMessagesMenu();
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
    
    // i populate the arrays with the test data from the assignment
    public static void populateTestData(){
        
        // test message 1
        sentMessages.add("Did you get the cake?");
        recipients.add("+27834557896");
        messageHashes.add("00:1:DIDCAKE?");
        messageIDs.add(1000000001L);
        
        // test message 2
        storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        recipients.add("+27838884567");
        messageHashes.add("00:2:WHERETIME.");
        messageIDs.add(1000000002L);
        
        // test message 3 - disregarded
        disregardedMessages.add("Yohoooo, I am at your gate.");
        recipients.add("+27834484567");
        messageHashes.add("00:3:YOHOOOOGATE.");
        messageIDs.add(1000000003L);
        
        // test message 4
        sentMessages.add("It is dinner time!");
        recipients.add("0838884567");
        messageHashes.add("00:4:ITTIME!");
        messageIDs.add(1000000004L);
        
        // test message 5
        storedMessages.add("Ok, I am leaving without you.");
        recipients.add("+27838884567");
        messageHashes.add("00:5:OKYOU.");
        messageIDs.add(1000000005L);
        
        totalMessages = 5;
    }
    
    // this method sends a new message
    public static void sendMessage(){
        
        // i generate a new message ID
        Random random = new Random();
        long messageID = 1000000000L + random.nextInt(900000000);
        
        System.out.println("Message ID: " + messageID);
        
        // i ask the user for the recipient number
        System.out.println("Enter recipient cell number:");
        String recipient = scanner.nextLine();
        System.out.println(checkRecipientCell(recipient));
        
        // i ask the user to type their message
        System.out.println("Enter your message:");
        String userMessage = scanner.nextLine();
        
        // i check if the message is within 250 characters
        if(userMessage.length() > 250){
            int over = userMessage.length() - 250;
            System.out.println("Message exceeds 250 characters by " + over + " please reduce the size.");
            return;
        }
        
        // i increase the total messages count
        totalMessages++;
        
        // i create the hash for this message
        String hash = createHash(userMessage, messageID, totalMessages);
        System.out.println("Message Hash: " + hash);
        
        // i ask the user what they want to do with the message
        System.out.println("What do you want to do with your message?");
        System.out.println("1 - Send Message");
        System.out.println("2 - Disregard Message");
        System.out.println("3 - Store Message");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if(choice == 1){
            sentMessages.add(userMessage);
            recipients.add(recipient);
            messageHashes.add(hash);
            messageIDs.add(messageID);
            System.out.println("Message successfully sent.");
        } else if(choice == 2){
            disregardedMessages.add(userMessage);
            System.out.println("Press 0 to delete the message.");
        } else if(choice == 3){
            storedMessages.add(userMessage);
            recipients.add(recipient);
            messageHashes.add(hash);
            messageIDs.add(messageID);
            storeMessageJSON(messageID, recipient, userMessage);
            System.out.println("Message successfully stored.");
        } else {
            System.out.println("Invalid option.");
        }
    }
    
    // this method creates the message hash
    public static String createHash(String message, long messageID, int numMessages){
        String[] words = message.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String firstTwo = String.valueOf(messageID).substring(0, 2);
        String hash = firstTwo + ":" + numMessages + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }
    
    // this method checks if the cell number is valid
    public static String checkRecipientCell(String cellNumber){
        if(cellNumber.startsWith("+") && cellNumber.length() <= 10){
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    
    // this method stores the message in JSON format
    public static void storeMessageJSON(long messageID, String recipient, String message){
        String jsonMessage = "{"
            + "\"MessageID\": \"" + messageID + "\", "
            + "\"Recipient\": \"" + recipient + "\", "
            + "\"Message\": \"" + message + "\""
            + "}";
        System.out.println("Message stored: " + jsonMessage);
    }
    
    // this method shows the stored messages menu
    public static void storedMessagesMenu(){
        System.out.println("\n--- Stored Messages Menu ---");
        System.out.println("1 - Display sender and recipient of all stored messages");
        System.out.println("2 - Display the longest stored message");
        System.out.println("3 - Search messages by recipient");
        System.out.println("4 - Delete a message using a hash");
        System.out.println("5 - Back to main menu");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if(choice == 1){
            displayStoredMessages();
        } else if(choice == 2){
            displayLongestMessage();
        } else if(choice == 3){
            searchByRecipient();
        } else if(choice == 4){
            deleteByHash();
        } else if(choice == 5){
            System.out.println("Going back to main menu.");
        } else {
            System.out.println("Invalid option.");
        }
    }
    
    // this method displays all stored messages with sender and recipient
    public static void displayStoredMessages(){
        System.out.println("\n--- Stored Messages ---");
        if(storedMessages.isEmpty()){
            System.out.println("No stored messages.");
        } else {
            for(int i = 0; i < storedMessages.size(); i++){
                System.out.println("Recipient: " + recipients.get(i));
                System.out.println("Message: " + storedMessages.get(i));
                System.out.println("---");
            }
        }
    }
    
    // this method displays the longest message
    public static void displayLongestMessage(){
        String longest = "";
        for(String msg : sentMessages){
            if(msg.length() > longest.length()){
                longest = msg;
            }
        }
        for(String msg : storedMessages){
            if(msg.length() > longest.length()){
                longest = msg;
            }
        }
        System.out.println("Longest message: " + longest);
    }
    
    // this method searches messages by recipient
    public static void searchByRecipient(){
        System.out.println("Enter recipient number to search:");
        String search = scanner.nextLine();
        boolean found = false;
        
        for(int i = 0; i < recipients.size(); i++){
            if(recipients.get(i).equals(search)){
                System.out.println("Message found: " + sentMessages.get(i));
                found = true;
            }
        }
        
        if(!found){
            System.out.println("No messages found for this recipient.");
        }
    }
    
    // this method deletes a message using a hash
    public static void deleteByHash(){
        System.out.println("Enter message hash to delete:");
        String hash = scanner.nextLine();
        boolean found = false;
        
        for(int i = 0; i < messageHashes.size(); i++){
            if(messageHashes.get(i).equals(hash)){
                System.out.println("Message: \"" + sentMessages.get(i) + "\" successfully deleted.");
                sentMessages.remove(i);
                messageHashes.remove(i);
                messageIDs.remove(i);
                recipients.remove(i);
                found = true;
                break;
            }
        }
        
        if(!found){
            System.out.println("Hash not found.");
        }
    }
    
    // this method displays a full report of all sent messages
    public static void displayReport(){
        System.out.println("\n--- Message Report ---");
        if(sentMessages.isEmpty()){
            System.out.println("No messages sent.");
        } else {
            for(int i = 0; i < sentMessages.size(); i++){
                System.out.println("Message Hash: " + messageHashes.get(i));
                System.out.println("Recipient: " + recipients.get(i));
                System.out.println("Message: " + sentMessages.get(i));
                System.out.println("---");
            }
        }
        System.out.println("Total messages: " + totalMessages);
    }
}
