
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

enum Turn {
    Player,
    Player2,
}

public class PlayGame {

    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<String> board = new ArrayList<String>();

    Player player;

    private Turn turn = null;

    Boolean keepPlaying = true;


    public PlayGame() {
        initialize();

        rules();
        printBoard(keepPlaying);

        turn = Turn.values()[new Random().nextInt(Turn.values().length)];

        while (keepPlaying) {
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

        for (int i = 0; i < 10; i++) {
            board.add(" ");
        }

        return players;
    }


    public void Play() {

        Player player = turn == Turn.Player ? players.get(0) : players.get(1);


        // while true - loopa spelarna

        System.out.println(player.getName() + " choose a spot - write a number between 1 and 9");
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        try {
            if (inputNumber < 1 || inputNumber > 9) {
               System.out.println("Invalid input; re-enter your number");
                inputNumber = sc.nextInt();
            }
        } catch (Exception e){
            System.out.println("Invalid input; re-enter your number");
            inputNumber = sc.nextInt();
        }

        if (1 == inputNumber) {
            board.set(0, player.getLetter());
        } else if (2 == inputNumber) {
            board.set(1, player.getLetter());
        } else if (3 == inputNumber) {
            board.set(2, player.getLetter());
        } else if (4 == inputNumber) {
            board.set(3, player.getLetter());
        } else if (5 == inputNumber) {
            board.set(4, player.getLetter());
        } else if (6 == inputNumber) {
            board.set(5, player.getLetter());
        } else if (7 == inputNumber) {
            board.set(6, player.getLetter());
        } else if (8 == inputNumber) {
            board.set(7, player.getLetter());
        } else if (9 == inputNumber) {
            board.set(8, player.getLetter());
        }

        checkIfWinner(player.getLetter());
        printBoard(keepPlaying);


        turn = player.getId() == 0 ? Turn.Player2 : Turn.Player;

     /*   if (player.getId() == 0) {
            turn = Turn.Player2;
        } else {
            turn = Turn.Player;
        }*/

    }

    private void checkIfWinner(String letter) {

        for (int a = 0; a < 8; a++) {
            String winnerLine = null;

            switch (a) {
                case 0:
                    winnerLine = board.get(0) + board.get(1) + board.get(2);
                    break;
                case 1:
                    winnerLine = board.get(3) + board.get(4) + board.get(5);
                    break;
                case 2:
                    winnerLine = board.get(6) + board.get(7) + board.get(8);
                    break;
                case 3:
                    winnerLine = board.get(0) + board.get(3) + board.get(6);
                    break;
                case 4:
                    winnerLine = board.get(1) + board.get(4) + board.get(7);
                    break;
                case 5:
                    winnerLine = board.get(2) + board.get(5) + board.get(8);
                    break;
                case 6:
                    winnerLine = board.get(0) + board.get(4) + board.get(8);
                    break;
                case 7:
                    winnerLine = board.get(2) + board.get(4) + board.get(6);
                    break;
            }

            if (winnerLine.equals(letter + letter + letter)) {
                System.out.println("WE HAVE A WINNER! ");
                keepPlaying = false;
                break;
            }
        }
    }

    private static void printBoard(boolean keepPlaying) {
        if (keepPlaying) {
            System.out.println("Current board:");
        } else {
            System.out.println("WINNER BOARD");
        }

        System.out.println(" " + board.get(0) + " | " + board.get(1) + " | " + board.get(2));
        System.out.println("---+---+---");
        System.out.println(" " + board.get(3) + " | " + board.get(4) + " | " + board.get(5));
        System.out.println("---+---+---");
        System.out.println(" " + board.get(6) + " | " + board.get(7) + " | " + board.get(8));
    }

    private static void rules() {
        System.out.println("To play the game you have to choose a number between 1 and 9.\n 1,2,3 is the numbers on the first row.\n If you choose number 5 you will mark the spot in the middle of the board.\n The goal is to get three in a row.\n Good luck!");
    }
}
