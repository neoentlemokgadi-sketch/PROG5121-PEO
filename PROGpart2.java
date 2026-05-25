/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpart2;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author neoen
 */
public class PROGpart2  {

    // this is my counter it keeps track how many messages i have sent or stored
    static int totalMessages = 0;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // i create the random object to generate random numbers
        Random random = new Random();
        
        // this is my 10 digit difit random number generator
        long messageID = 1000000000L + random.nextInt(900000000);
          
        // this are the users outputs
        System.out.println("Welcome to the Message App");
        System.out.println("Your Message ID has been generated: " + messageID);
        
        // this is code is for phone numbers
        System.out.println("Please enter the recipient cell number:");
        String cellNumber = scanner.nextLine();
        
        // this asks the user to enter their message
        System.out.println("Please enter your message:");
        String userMessage = scanner.nextLine();
        
        // this coode asks users which option they want to select
        System.out.println("What would you like to do with your message?");
        System.out.println("1 - Send Message");
        System.out.println("2 - Disregard Message");
        System.out.println("3 - Store Message");
        
        // this reads the users choice
        int choice = scanner.nextInt();
        
        // this code shows us how messages are handled 
        if (choice == 1) {
            System.out.println("Message successfully sent.");
            totalMessages++; // increase count
        } else if (choice == 2) {
            System.out.println("Message disregarded.");
        } else if (choice == 3) {
            System.out.println("Message successfully stored.");
            totalMessages++; // increase count
        } else {
            System.out.println("Invalid option.");
        }
        
        // this prints out the total number of messages processed
        System.out.println("Total messages processed: " + totalMessages);
    }
}
