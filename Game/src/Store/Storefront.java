package Store;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import Games.*;

public class Storefront implements Game {
    static ArrayList<Instrument> StoreSelection = new ArrayList(); // what store has
    static ArrayList<Instrument> InstrumentList = new ArrayList(); // what you have
    static Instrument Mic = new Instrument("Mic", 25, 1000);
    static Instrument Guitar = new Instrument("Guitar", 15, 500);
    static Instrument Drums = new Instrument("Drums", 5, 250);

    static Instrument newMic = new Instrument("New Mic", 1, 1000);
    static Instrument newGuitar = new Instrument("New Guitar", 2, 500);
    static Instrument newDrums = new Instrument("New Drums", 3, 250);

    static PlayerStats newPlayer = new PlayerStats(0, 1000);

    static Scanner Scanner = new Scanner(System.in);
    static Random rand = new Random();

    static int AddPercentages() {
        for (int i = 0; i < InstrumentList.size(); i++) {

            int totalPercentage = newPlayer.percentWin;
            totalPercentage += InstrumentList.get(i).percentIncrease;
            newPlayer.percentWin = totalPercentage;

        }
        System.out.println("The percent chance you win is now " + newPlayer.percentWin);
        return newPlayer.percentWin;

    }

    

    @Override
    public String getGameName() {
        // TODO Auto-generated method stub
       return("SuperStore");
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub

            // "go through each item in the list an 'get' its percentIncrease and add them
            // togetehr to equal percentWin " for loop
            // String StoreFront = Scanner.nextLine();
            StoreSelection.add(Mic);
            StoreSelection.add(Guitar);
            StoreSelection.add(Drums);
            System.out.println(
                    "Welcome to your new journey to become the greatest musician alive! What will be your first Instrument? A Mic? Guitar? or Drums? ");
            getChoices();
    
        }
    
        public static void getChoices() {
            for (int i = 0; i < StoreSelection.size(); i++) {
                System.out.println(StoreSelection.get(i).type);
            }
    
            String selection = Scanner.nextLine();
    
            Instrument instrument = null;
    
            for (int i = 0; i < StoreSelection.size(); i++) {
    
                if (selection.equals(StoreSelection.get(i).type)) {
    
                    instrument = StoreSelection.get(i);
                    // check if you have enough money
                    if (newPlayer.Balance < StoreSelection.get(i).cost) {
                        System.out.println("Sorry you don't have enough money to buy this item");
                        getChoices();
                    }
                    // add to list
                    InstrumentList.add(StoreSelection.get(i));
                    AddPercentages();
                    // Get the type and price then subtract the price from your balance
    
                    newPlayer.Balance = newPlayer.Balance - StoreSelection.get(i).cost;
                    BuyOrClub();
                } 
               
            }
            if (instrument == null) {
    
                System.out.println("Sorry you must type in the exact word. Please try again");
                getChoices();
            }
            
            
    
        }
    
        // Create array list to add instruments to
    
        // Check if input is integer
    
        // Go through whole StoreSelection list and if Scanner Storefront matches one of
        // the types, then add that item to the Instrument list and add its
        // percentIncrease to newPlayer percentWin
    
        // If it doesn't match then ask them to type in the exact word again
        // If it does match then add it to the list and subtract the cost from the
        // balance
        // If the balance is less than the cost then tell them they don't have enough
        // money and ask them to type in the exact word again
        // If the balance is greater than the cost then add the item to the list and
        // subtract the cost from the balance
        // If the balance is equal to the cost then add the item to the list and
        // subtract the cost from the balance
        // If the balance is less than the cost then tell them they don't have enough
        // money and ask them to type in the exact word again
    
        // Buy or Club
        public static void BuyOrClub() {
            System.out.println("Do you wish to go to buy more or go to the club? Your current balance is "
            + newPlayer.Balance + ". Type B or C"); // need to use scanner
            String BuyOrClub = Scanner.nextLine();
    
            if (BuyOrClub.equals("B")) {
                if (newPlayer.Balance < 250){
                    System.out.println("You don't have enough money to go to buy any more instruments. You need to go earn money at the club");
                    BuyOrClub();
                }
                System.out.println("Do you want a A Mic? Guitar? or Drums?");
                getChoices();
                
            }
            if (BuyOrClub.equals("C")) {
    
                // Club
    
                System.out.print("You are now at the club. You have a " + newPlayer.percentWin + " chance to earn $300. Do you wish to continue? Type y or n");
                String YesOrNo = Scanner.nextLine();
                if (YesOrNo.equals("y")) {
                    int roll = rand.nextInt(100);
    
                    if (roll < newPlayer.percentWin) {
                        if (newPlayer.Balance > 2000){
                            System.out.println("You have won the game! You have earned $300 and have a balance of " + newPlayer.Balance);
                            System.exit(0);
                        }
                        newPlayer.Balance = newPlayer.Balance + 300;
                        System.out.println("You played really well!");
                                        BuyOrClub();
                    } else {
                        System.out.println(
                                "You played terribly!");
                                        BuyOrClub();
                    }
                }
                if (YesOrNo.equals("n")) {
                    BuyOrClub();
                }
    
                else {
                    System.out.println("Sorry you must type in the exact word. Please try again");
                    BuyOrClub();
                }
    
            }
    
        }
    }

   
