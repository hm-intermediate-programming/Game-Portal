package BuzzfeedQuiz;

import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[3];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category of the answer
    int ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    possibleAnswers[i].label);
        }
        int ans = ErrorChecking.errorCheck(sc);
        return possibleAnswers[ans - 1].points;
    }
  /* 
 * This is a demo of Handling errors in user input. 
 * Sorry for not having this prepared for class on 11/18 :(
 */
public class ErrorChecking {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        errorCheck(sc);
    }

    public static int errorCheck(Scanner sc) {
        System.out.println("I am expecting a number from 1 - 3!");
        
        if(sc.hasNextInt()) {
            int input = sc.nextInt();
            System.out.println("This is a number");
            if (input > 3 || input < 1) {
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


