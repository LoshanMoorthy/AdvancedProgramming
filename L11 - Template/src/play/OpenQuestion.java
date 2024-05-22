package play;

import java.util.Scanner;

public class OpenQuestion extends Question {
    private String question;
    private String correctAnswer;

    public OpenQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    protected void displayQuestion() {
        System.out.println("Open Question: " + question);
    }

    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indtast dit svar: ");
        return scan.nextLine();
    }

    protected boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}
