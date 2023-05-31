package BuzzfeedQuiz;
import java.io.File;
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

import Games.*;

public class Quiz implements Game{
    /**
 * @param args
 * @throws Exception
 */


    @Override
    public String getGameName() {
        // TODO Auto-generated method stub
       return("BuzzfeedQuiz");
    }

    @Override
    public void play() {
        int total_points = 0;

        // Create Categories
        Category plague = new Category("Plague", "You are introverted and enjoy your time alone." + "You'll have more fun alone");
        Category zombies = new Category("Zombie Apocalypse", "You are very extroverted and like the compnay of other people. You enjoy working with others.");

        Category Nuclear_Holocaust = new Category("Nuclear Holocast",
                "You adapt very well to any situation. Whether you must work with others or alone, you always find the best in every situation.");
        
        Question q1 = new Question("How would you spend your weekend?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer("Cooking at home", 0);
        q1.possibleAnswers[1] = new Answer("Paintball with friends",5);
        q1.possibleAnswers[2] = new Answer("Go to the movies", 2);

        Question q2 = new Question("What movie genre?");
        // Attach Answers to Questions
        q2.possibleAnswers[0] = new Answer("Rom-Com", 0);
        q2.possibleAnswers[1] = new Answer("Horror",5);
        q2.possibleAnswers[2] = new Answer("Superhero", 2);

        Question q3= new Question("Cats or dogs?");
        // Attach Answers to Questions
        q3.possibleAnswers[0] = new Answer("Cats", 0);
        q3.possibleAnswers[1] = new Answer("Dogs",5);
        q3.possibleAnswers[2] = new Answer("Either", 2);

        Question q4= new Question("What's your favorite season?");
        // Attach Answers to Questions
        q4.possibleAnswers[0] = new Answer("Winter", 0);
        q4.possibleAnswers[1] = new Answer("Summer",5);
        q4.possibleAnswers[2] = new Answer("Fall", 2);

        Question q5= new Question("What's your ideal workspace?");
        // Attach Answers to Questions
        q5.possibleAnswers[0] = new Answer("Office", 0);
        q5.possibleAnswers[1] = new Answer("Outside",5);
        q5.possibleAnswers[2] = new Answer("Wherever Wifi is", 2);


        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        Question[] qList = { q1, q2, q3, q4, q5 };
        for (Question q : qList)
         {
            int c = q.ask(sc);

            total_points = total_points + c;
           
           
        }
        

        if (0 <= total_points && total_points <= 4){
                System.out.println(plague);

        }

        if (19 <= total_points && total_points <=25){
                System.out.println(zombies);

        }

        if (4 < total_points && total_points <  9){
                System.out.println(Nuclear_Holocaust);

        }

        // Get most common category from the questions asked
        // Return Category
        Category[] cList = { plague, zombies, Nuclear_Holocaust };
        int[] counts = { plague.points, zombies.points, Nuclear_Holocaust.points};
        // these need to be in the same order or the points will be incorrect!
        int index = getMostPopularCatIndex(counts);
        System.out.println("If you were a board game, you would be " + cList[index].label + ". ");
        System.out.println(cList[index].description);

    }

    public static void gameIntro(Scanner sc) {
        // requires 1 to keep going
        System.out.println("Which Board Game Are You?");
        System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
        ErrorChecking.errorCheck(sc);
       
        
    }

    public static int getMostPopularCatIndex(int[] counts) {
        // returns the index that is the max
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public class ErrorChecking {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in); 
            errorCheck(sc);
        }

        public static int errorCheck(Scanner sc) {
    
            
            if(sc.hasNextInt()) {
                int input = sc.nextInt();
                System.out.println("This is a number");
                if (input != 1) {
                    System.out.println("Hey! this number is not what I wanted. Try again.");
                    return errorCheck(sc);
                } else {
                    System.out.println("Yay! This is what I expected");
                    return input;
                }
            } else {
                System.out.println("This is not a number. Discarding this input");
                sc.next(); // discarding the next input
                return errorCheck(sc);
            }
        }
    }
}
