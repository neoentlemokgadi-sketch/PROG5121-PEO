/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cahtapppart1;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author neoen
 */
public class Part2prompt { 

    // this is my array list and it is used to store all the messages
    static ArrayList<String> storedMessages = new ArrayList<>();
    // this is my counter it keeps track how many messages i have sent or stored
    static int totalMessages = 0;

    public static void main(String[] args) {
        
        // i create the scanner to read what the user types
        Scanner scanner = new Scanner(System.in);
        
        // i create the random object to generate random numbers
        Random random = new Random();
        
        // i generate a random 10 digit number for the message ID
        long messageID = 1000000000L + random.nextInt(900000000);
          
        // this are the users prompts
        System.out.println("Welcome to the Message App");
        System.out.println("Your Message ID has been generated: " + messageID);
        
        // i ask the user to enter the recipient cell number
        System.out.println("Please enter the recipient cell number:");
        String cellNumber = scanner.nextLine();
        
        // i ask the user to enter their message
        System.out.println("Please enter your message:");
        String userMessage = scanner.nextLine();
        
        // i ask the user what they want to do with the message
        System.out.println("What would you like to do with your message?");
        System.out.println("1 - Send Message");
        System.out.println("2 - Disregard Message");
        System.out.println("3 - Store Message");
        
        // i read the users choice
        int choice = scanner.nextInt();
        
        // this code shows us how messages are handled
        if (choice == 1) {
            System.out.println("Message successfully sent.");
            totalMessages++; // increase count
        } else if (choice == 2) {
            System.out.println("Message disregarded.");
        } else if (choice == 3) {
            System.out.println("Message successfully stored.");
            storeMessage(messageID, cellNumber, userMessage);
            totalMessages++; // increase count
        } else {
            System.out.println("Invalid option.");
        }
        
        // this prints out the total number of messages processed
        System.out.println("Total messages processed: " + totalMessages);
    }
    
    // this method stores messages in a JSON-like format
    public static void storeMessage(long messageID, String recipient, String message){
        String jsonMessage = "{"
            + "\"MessageID\": \"" + messageID + "\", "
            + "\"Recipient\": \"" + recipient + "\", "
            + "\"Message\": \"" + message + "\""
            + "}";
        
        storedMessages.add(jsonMessage);
        System.out.println("Message stored in JSON format:");
        System.out.println(jsonMessage);
    }
}
  