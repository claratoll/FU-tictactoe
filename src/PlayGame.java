
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

enum Turn {

    Player,
    Player2,
}

public class PlayGame {

    private static ArrayList<Player> players = new ArrayList<Player>();

    Player player;

    private Turn turn =null;

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




    public PlayGame(){
        initialize();

        rules();
        printBoard();

        turn = Turn.values()[new Random().nextInt(Turn.values().length)];

        while (keepPlaying){
            Play();
        }
    }
    private static ArrayList<Player> initialize() {
        System.out.println("Welcome to tic tac toe");
        Scanner sc = new Scanner(System.in);
        int playerNum = 2;

        for (int i = 0; i < playerNum; i++) {
            System.out.println("Player " + (i + 1) + ", please write your name");
            String name = sc.nextLine();
            System.out.println(name + ", please write your letter you want to play with");
            String letter = sc.nextLine();
            players.add(new Player(name, letter, i));
        }


        return players;

    }


    public void Play() {

        Player player = turn == Turn.Player?players.get(0):players.get(1);




        // while true - loopa spelarna

        System.out.println(player.getName() + " choose a spot - write a number between 1 and 9");
        Scanner sc = new Scanner(System.in);
        int spotChosen = sc.nextInt();
        if (spotChosen < 1 || spotChosen > 9){
            System.out.println("Invalid input; re-enter your number");
            spotChosen = sc.nextInt();
        }


            if (1 == spotChosen) {
                A = player.getLetter();
            } else if (2 == spotChosen){
                B = player.getLetter();
            } else if (3 == spotChosen){
                C = player.getLetter();
            }
        checkIfWinner(player.getLetter());

        printBoard();

        turn = player.getId() == 0 ? Turn.Player2 : Turn.Player;

     /*   if (player.getId() == 0) {
            turn = Turn.Player2;
        } else {
            turn = Turn.Player;
        }*/

    }

    private void checkIfWinner(String letter) {

        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = A + B + C;
                    break;
                case 1:
                    line = D + E + F;
                    break;
                case 2:
                    line = G + H + I;
                    break;
                case 3:
                    line = A + D + G;
                    break;
                case 4:
                    line = B + E + H;
                    break;
                case 5:
                    line = C + F + I;
                    break;
                case 6:
                    line = A + E + I;
                    break;
                case 7:
                    line = C + E + G;
                    break;
            }

            if (line.equals(letter + letter + letter)){
                System.out.println("WE HAVE A WINNER! " + letter);
                keepPlaying = false;
                break;
            }
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
