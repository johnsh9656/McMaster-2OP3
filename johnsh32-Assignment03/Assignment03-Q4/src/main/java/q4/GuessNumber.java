package q4;
import java.util.Scanner;
import java.util.Random;

public class GuessNumber {

    private int maxTrials;
    private int randomNumber;
    private int currenetTrial;

    // constructor to initialize the game
    public GuessNumber(int maxTrials) {
        this.maxTrials = maxTrials;
        this.randomNumber = generateRandomNumber();
        this.currenetTrial = 0;
    }

    // return random int in [1, 100]
    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    // check guess, return (game over => true) or (continue game => false)
    private boolean guess(int userGuess) {
        currenetTrial++;

        if (userGuess > randomNumber) {
            System.out.println("The number is lower than "+userGuess+".");
        } else if (userGuess < randomNumber) {
            System.out.println("The number is higher than "+userGuess+".");
        } else {
            System.out.println("You successfully guessed the number!");
            return true;
        }

        if (currenetTrial >= maxTrials) {
            System.out.println("You have exhausted your trials.");
            return true;
        }

        return false;
    }

    // gameplay loop
    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (currenetTrial < maxTrials) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (guess(userGuess)) {
                break;
            }
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(10);
        game.play();
    }
}
