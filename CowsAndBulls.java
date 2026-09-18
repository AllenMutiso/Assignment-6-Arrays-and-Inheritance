// Allen Mutiso MTSALL002
// 15 September 2026
// Cows and Bulls implements the logic for a cows and bulls guessing game.

public class CowsAndBulls {
    public final static int NUM_DIGITS = 4;
    public final static int MAX_VALUE = 9876;
    public final static int MIN_VALUE = 1234;
    public final static int MAX_GUESSES = 10;
    private NumberPicker picker;
    private int remainingGuesses = 10; 
    private int secretNumber = 0;
    private boolean correctyGuessed = false;

    public CowsAndBulls(int seed) {
        picker = new NumberPicker(seed, 1, 9);
        for (int i = 0; i < 4; i += 1) {
            secretNumber = (secretNumber * 10) + picker.nextInt(); 
        }
    }

    /*
    Obtain the number of guesses remaining.
    */
    public int guessesRemaining () {
        return remainingGuesses;
    }

    /*
    Evaluates a guess that the mystery number is guessNumber, returning the outcome in the form
    of a Result object. Decrements guesses remaining.
    Assumes that game is not over.
    */
    public Result guess(int guessNumber) {
        int bulls = NumberUtils.countMatches(guessNumber, secretNumber);
        int cows = NumberUtils.countIntersect(guessNumber, secretNumber);
        if (secretNumber == guessNumber) {
            correctyGuessed = true;
        }
        cows = cows - bulls;
    
        Result result = new Result(cows, bulls);
        remainingGuesses = remainingGuesses - 1;
        return result;
    }
    /*
    End the game, returning the secretNumber
    */
    public int giveUp() {
        correctyGuessed = true;
        return secretNumber;
    }

    /*
    End the game, returning the secretNumber
    */
    public boolean gameOver () {
        return (correctyGuessed || remainingGuesses == 0);
    }
}