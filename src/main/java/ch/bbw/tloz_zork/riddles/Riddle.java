package ch.bbw.tloz_zork.riddles;

import ch.bbw.tloz_zork.locations.Dungeon;
import java.util.Scanner;


public class Riddle {
    private String question;
    private String answer;
    private String correctAnswer;

    public Riddle(String question, String answer, String correctAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }
    public void answerPrompt(Dungeon dungeon) {
        Scanner scanner = new Scanner(System.in);
        while (!dungeon.isCompleted()){
            System.out.println("❓" + question);
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("✅ You answered correctly!");
                dungeon.setCompleted(true);
            } else {
                System.out.println("❌ You answered incorrectly! Try again.");
            }
        }
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
