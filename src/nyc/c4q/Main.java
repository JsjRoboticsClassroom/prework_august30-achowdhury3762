package nyc.c4q;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean notDone = true;
        while(notDone) {
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }


            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            promptPlayer("Do you want to play again?");
            String userAnswer = getInput();
            userAnswer = userAnswer.toLowerCase();
            while(true) {
                if (userAnswer.equals("yes") || userAnswer.equals("y")) {
                    notDone = true;
                    break;
                } else if (userAnswer.equals("no") || userAnswer.equals("n")) {
                    notDone = false;
                    break;
                } else {
                    System.out.println("Give me the right input");
                    userAnswer = getInput();
                }
            }
        }
    }

    public static void promptPlayer(String input){
        System.out.println(input);
    }

    public static String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
