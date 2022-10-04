
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

enum Turn {
    Player,
    Player2,
}

public class Game {

    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<String> board = new ArrayList<String>();


    private Turn turn = null;
    Player player;

    Boolean startGame = true;
    Boolean booleanPlayGame = true;
    Boolean keepPlaying = true;


    public Game() {
        //the actual game method

        createPlayers();

        //checks if the game should run or quit
        while (keepPlaying) {
            //checks if there should be new players
            if (startGame) {
                createBoard();
                startGame = false;
            }


            printBoard(booleanPlayGame);

            turn = Turn.values()[new Random().nextInt(Turn.values().length)];

            //start the game
            Play();

            System.out.println("Do you want to play again? yes or no");
            Scanner sc = new Scanner(System.in);
            try {
                String answer = sc.nextLine();
                if (answer.equals("yes")) {
                    booleanPlayGame = true;

                    board.clear();
                    createBoard();
                    Play();

                } else {
                    System.out.println("Thank you for playing!");
                    keepPlaying = false;
                    //    System.out.println(player.getName() + " won!");
                }
            } catch (Exception e) {
                System.out.println("Please write 'yes' or 'no'");
            }

        }
    }

    public static ArrayList<Player> createPlayers() {
        //create players
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


    private void createBoard() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("How big do you want the board? 2x2, 3x3, 4x4 etc. Please write a number");
            int size = sc.nextInt();
            board = new Board(size);
        } catch (Exception e) {
            System.out.println("Invalid input; try again.");
        }
    }


    public void Play() {
        while (booleanPlayGame) {
            player = turn == Turn.Player ? players.get(0) : players.get(1);

            // while true - players choose which place they want to put their mark
            try {
                System.out.println(player.getName() + " choose a spot - write a number between 1 and 9");
                Scanner sc = new Scanner(System.in);
                int inputNumber = sc.nextInt();

                //checks if input is between 1-9 & if the place is free
                /*while (inputNumber < 1 || inputNumber > 9 || !Objects.equals(board.get(inputNumber - 1), " ")) {
                    System.out.println("Invalid input; re-enter your number");
                    inputNumber = sc.nextInt();
                }*/



        /*    } catch (Exception e) {
                System.out.println("Invalid input; try again.");
            }*/
        }

    }

    public void getWinner(){
        //jämföra cols

        //jämföra rows

        //jämföra diagonal
    }

}


