
import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {

  //  private static ArrayList<Player> players = new ArrayList<Player>();


    Boolean keepPlaying = true;

    public static String A = " ";
    public static String B = " ";
    public static String C = " ";
    public static String D = " ";
    public static String E = " ";
    public static String F = " ";
    public static String G = " ";
    public static String H = " ";
    public static String I = " ";


    Player player;

    public PlayGame(){
        rules();
        printBoard();
        while (keepPlaying){
            Play();
        }

    }

    public void Play() {

        // System.out.println(player.getName() + "");
        System.out.println("Choose a spot - write a number between 1 and 9");
        Scanner sc = new Scanner(System.in);
        int spotChosen = sc.nextInt();

            if (1 == spotChosen) {
                A = "X";
            } else if (2 == spotChosen){
                B = "X";
            } else if (3 == spotChosen){
                C = "X";
            }
        checkIfWinner();

        printBoard();

    }

    private void checkIfWinner() {
        if (A == B  && B == C){
            System.out.println("WE HAVE A WINNER!");
         //   player.increaseScore();
            keepPlaying = false;
        }
    }

    private static void printBoard(){
        System.out.println("Current board:");
        System.out.println(" " + A + " | " + B + " | " + C);
        System.out.println("---+---+---");
        System.out.println(" " + D + " | " + E + " | " + F);
        System.out.println("---+---+---");
        System.out.println(" " + G + " | " + H + " | " + I);
    }

    private static void rules(){
        System.out.println("To play the game you have to choose a number between 1 and 9.\n 1,2,3 is the numbers on the first row.\n If you choose number 5 you will mark the spot in the middle of the board.\n The goal is to get three in a row.\n Good luck!");
    }
}
