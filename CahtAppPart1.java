/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cahtapppart1;

import java.util.Scanner;

/**
 *
 * @author neoen
 */
public class CahtAppPart1 {

        
 
    
    
  static String[] username = new String[1];
    static String inputUsername;
    static String[] password = new String[1];
    static String inputPassword;
    static String[] cellNumber = new String[1];
    static String inputCellNumber;
    
    static boolean validUsername = false;
    static boolean validPassword = false;
    static boolean validCellNumber = false;
    static boolean loginSuccess = false;
    
    //Scanner object to read user input from the keyboard
    static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
        System.out.println("Welcome to Our Chat App");
        
        appRegistration();
    }
    
    public static void appRegistration(){
        inputUsernames();
    }
    
    public static void inputUsernames(){
        
        for(int a = 0; a < username.length; a++){
        System.out.println("""
                           Please enter username: 
                           (Must contain an underscore 
                           Be no more than 5 characters""");
            inputUsername = input.nextLine();
            
            if(inputUsername != null && inputUsername.contains("_") && inputUsername.length() <= 5){
                
                username[a] = inputUsername;//Username is valid
                validUsername = true;
            }
            else{
            System.out.println( "Invalid username.\nMust contain '_' and be 5 characters or less.");
            inputUsernames();
            }
        }
        
        if(validUsername){
            inputPasswords();
        }
    }
    
    public static void inputPasswords(){
        
        for(int a = 0; a < password.length; a++){
        System.out.println("""
                           Please enter your password: 
                           Must be atleast 8 characters long 
                           Contain a capital letter 
                           Contain a number 
                           Contain a special character""");
            inputPassword = input.nextLine();
            
            if(inputPassword != null && 
                    inputPassword.length() >8 &&
                    inputPassword.matches(".*[A-Z].*") &&
                    inputPassword.matches(".*[a-z].*") &&
                    inputPassword.matches(".*\\d.*") &&
                    inputPassword.matches(".*[^a-zA-Z0-9].*")){
                //Password is valid
                validPassword = true;
                password[a] = inputPassword;
            }
            else{
            System.out.println("""
                               Invalid password.
                               Must be at least 8 characters long
                               Contain a capital letter
                               Contain a number
                               Contain a special character""");
            inputPasswords();
            }
            
            if(validPassword){
                inputCellNumbers();
            }
        }
    }
    
    public static void inputCellNumbers(){
        
        for(int a = 0; a < cellNumber.length; a++){
            System.out.println("""
                               Please enter your cellphone number:
                               Must start with the international country code (e.g. +27)
                               Must contain digits only after the '+'
                               Must be no more than 10 digits long after the country code""");
            inputCellNumber = input.nextLine();
            
            if (inputCellNumber.startsWith("+") &&
            inputCellNumber.length() <= 12 &&                      
            inputCellNumber.substring(1).matches("\\d+")) {       

            validCellNumber = true;    
            cellNumber[a] = inputCellNumber;
            System.out.println("Registration completed.");

        } else {
            System.out.println("""
                               Invalid cell number.
                               Must start with the international country code (e.g. +27)
                               Must contain digits only after the '+'
                               Must be no more than 10 digits long""");
            
            inputCellNumbers();
        }
            
            if(validCellNumber){
                loginUsername();
            }
        }
    }
    
    public static void loginUsername(){
        
        System.out.println("LOGIN: "
                + "\nPlease enter your usename:");
        inputUsername = input.nextLine(); 
        
        loginPassword();
    }
    
    public static void loginPassword(){
        System.out.println("\nPlease enter your password:");
        inputPassword = input.nextLine();
        
        login();
    }
    
    public static void login(){
        
        for(int a = 0; a < username.length; a++){
            if(inputUsername.equals(username[a]) &&
                    inputPassword.equals(password[a])){
                
                loginSuccess = true;
                break;
            }
        }
            if(loginSuccess){
            System.out.println("Login successful");
        }else{
            System.out.println("Invalid username or password.");
            loginSuccess = false;
            loginUsername();
        }
    }
}
    

