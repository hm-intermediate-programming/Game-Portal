package BuzzfeedQuiz;

/*
 * This is an answer, that if selected, will show you what Category you are.
 */

public class Answer {
    String label;
    Category cat;
    int points = 0;

    Answer(String label, int points) {
        this.label = label; 
        this.points = points;
    }
}
