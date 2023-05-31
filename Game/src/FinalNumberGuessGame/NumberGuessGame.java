package FinalNumberGuessGame;


import java.util.Random;
import java.util.Scanner;

import Games.*;

import java.io.File;
import java.util.ArrayList;

public class NumberGuessGame implements Game {
       
       

    @Override
    public String getGameName() {
        // TODO Auto-generated method stub
        return ("NumberGuessGame");
    }

    @Override
    public void play() {
         // Ask for minimum integer
         Scanner AskforMin = new Scanner(System.in);
         System.out.println("What is your minimum integer?");
         //Check if input is integer
         if (AskforMin.hasNextInt()) {
             int min = AskforMin.nextInt();
             
             // Ask for Maxmimum integer
             Scanner AskforMax = new Scanner(System.in);
             System.out.println("What is your maximum integer?");

             // Check if input is integer
             if (AskforMax.hasNextInt()) {
                 int max = AskforMax.nextInt();

                     // Make Random Number using Min and Max
                     Random InitialNumber = new Random();
                     int int_random = InitialNumber.nextInt(max + 1 - min) + min;

                     // Prints the random number just so you can see the game works
                     System.out.println("Random integer value from " + min + " to " + (max) + " : " + int_random);

                     // Create ArrayList "NumbersList" to store all guesses
                     ArrayList<Integer> NumbersList = new ArrayList();

                     // Ask for Number
                     Scanner AskforNumber = new Scanner(System.in); // Create a Scanner object
                     System.out.println("Enter a number from " + min + " to " + max);

                      // Check if Input is Int.
                     while (true) {

                         // Check if input is an integer
                         if (AskforNumber.hasNextInt()) {
                             int NumberInput = AskforNumber.nextInt();

                             // Check if number is within Bounds
                             // Not within 0-100
                             if (NumberInput < min || NumberInput > max) {
                                 System.out.println("Integer is not within bounds. Pick between " + min + " to "+ max);
                             }

                             // Within 0-100
                             else {
                                 // Check if the Number is in the ArrayList

                                 // In ArrayList
                                 if (NumbersList.contains(NumberInput)) {
                                     AskforNumber.next();
                                     System.out.println("You have already used this number. Pick again");
                                 }

                                 // Not in ArrayList
                                 else {
                                     NumbersList.add(NumbersList.size(), NumberInput); // adds the number to ArrayList

                                     // If the there is a number that matches the random number
                                     if (NumberInput == int_random) {
                                         System.out.println("Correct! The number is " + int_random + ". You solved it in "
                                                 + NumbersList.size() + " tries!");
                                         break;
                                     }

                                     // When the input does not match the random number
                                     else {
                                         // Number too Low
                                         if (NumberInput < int_random) {
                                             System.out.println("Too Low! The number is greater than " + NumberInput);
                                         }

                                         // Number too high
                                         //if (NumberInput > int_random) {
                                         else{
                                             System.out.println("Too High! The number is less than " + NumberInput);
                                         }

                                     }

                                 }
                             }

                         }

                         // Input is not an integer
                         else {
                             AskforNumber.next();
                             System.out.println("Please enter a valid integer");
                         }
                     }
                 }
         
             // AskforMax is not and integer
             else{
                 AskforMax.next();
                 System.out.println("Please enter a valid integer");
             }

         }

         // AskforMin is not an integer
         else{
             AskforMin.next();
             System.out.println("Please enter a valid integer");

         }
    }


 }
