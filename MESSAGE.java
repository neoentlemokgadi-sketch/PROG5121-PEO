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
public class MESSAGE { 
    
    public static void main(String[] args) {
        Random random = new Random();//this is used to make up the random numbers
        long messageID = 1000000000L + random.nextInt(900000000);// i used long instead of int because int can not hold large number
        System.out.println("Message ID:" + messageID);      
        
        String ID = String.valueOf(messageID);//this converts the long numbers to a string so that we can check the lenght of the numbers
        if (ID.length() <= 10) {       //this if statement checks if the id numbers are less or equals to 10
            System.out.println("ID is valid");
        } else {
            System.out.println("ID is not valid");
        }
    }
    
    public static void sentMsgNumber() {
        ArrayList<Long> messageIDs = new ArrayList<>(); //this is my array list and it used to store all the message ids
        Random random = new Random();  // this is used to come up with my random number
        int count = 0;  //this is my counter it keeps track how many messages i have
        while (count < 90) {  
            long id = 1000000L + random.nextInt(900000);
            messageIDs.add(id);
            count++;
        }
    }
    
    //this code checks if the recipient cell number starts with an international code and the numbers are not more than 10 characters or less
    public static String recipientCellNumber(String recipientCellNumber){
        if(recipientCellNumber.startsWith("+27") && recipientCellNumber.length() <= 10){
            return "Cell phone number successfully captured.";
        } else {
            return "Ensure cell number is not more than 10 characters and contains an international code";  
        }
    }
 
    public static void message(String message){
        if(message.length() > 250){
            System.out.println("Please enter a message of less than 250 characters.");     
        } else {
            System.out.println("Message sent");
        }
    }
    
    public static void hashMessage(String message, long messageID, int numMessages){
        // this code shows that i splited the message into different words 
        String[] words = message.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        
        // this code collects the first two numbers of the ID numbers 
        String idNumbers = String.valueOf(messageID);
        String firstTwo = idNumbers.substring(0,2);
        
        // this code below joins everything together and makes it capital letters
        String hash = firstTwo + ":" + numMessages + ":" + firstWord + lastWord;
        System.out.println("00:0:HITHANKS:" + hash.toUpperCase());
    }
    
    public static void sentMsg(long messageID) {
        // this prints out the users ID
        System.out.println("Message ID generated: " + messageID);
        
        // this code asks the user options on what they want to select
        System.out.println("1 - Send Message");
        System.out.println("2 - Disregard Message");
        System.out.println("3 - Store Message");
        
        // i read the users choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
        // this code shows us how messages are stored
        if(choice == 1){
            System.out.println("Message successfully sent.");
        }else if(choice == 2){
            System.out.println("Press 0 to delete the message.");
        }else if(choice == 3){
            System.out.println("Message successfully stored.");
        }else{
            System.out.println("Invalid option.");
        }
    }
    
    // i convert the id to a string so i can check the length
    public static boolean checkMessageID(long messageID){
        String ID = String.valueOf(messageID); 
        if(ID.length() <= 10){
            return true;
        } else {
            return false;
        }
    }
    
}

