
import java.util.ArrayList;
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

    Boolean booleanPlayGame = true;
    Boolean keepPlaying = true;


    public Game() {
        //creating players
        createPlayers();
        //Creating new board
        createBoard();
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

        } catch (Exception e) {
            System.out.println("Please write again.");
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

    public void startGame() {

        //checks if the game should run or quit
        while (keepPlaying) {

            turn = Turn.values()[new Random().nextInt(Turn.values().length)];

            //start the game
            play();

            System.out.println("Do you want to play again? yes or no");
            Scanner sc = new Scanner(System.in);
            try {
                String answer = sc.nextLine();
                if (answer.equals("yes")) {
                    //Creating new board
                    createBoard();

                } else {
                    System.out.println("Thank you for playing!");
                    keepPlaying = false;
                    allTimeWinner();
                }
            } catch (Exception e) {
                System.out.println("Please write 'yes' or 'no'");
            }
        }
    }

    public void play() {
        while (booleanPlayGame) {
            int rowNumber = 0;
            int colNumber = 0;

            player = turn == Turn.Player ? players.get(0) : players.get(1);

            // while true - players choose which place they want to put their mark
            try {
                System.out.println(player.getName() + " choose a spot - write a number between 1 and 9");
                Scanner sc = new Scanner(System.in);
                rowNumber = sc.nextInt() - 1;
                System.out.println(player.getName() + ", choose a col ");
                colNumber = sc.nextInt() - 1;

                if (board.markSpot(rowNumber, colNumber, player.getLetter())) {
                    // Only change turn if we were able to take the spot
                    turn = turn == Turn.Player ? Turn.Player2 : Turn.Player;
                } else {
                    System.out.println("This spot is taken.");
                }

                board.printBoard();

                if (!board.checkWinner(rowNumber, colNumber, player.getLetter(), booleanPlayGame)){
                    player.increaseScore();
                    break;
                }


            } catch (Exception e) {
                System.out.println("Invalid input; try again.");
            }
        }
    }

    public void allTimeWinner(){
    //    player = turn == Turn.Player ? players.get(0) : players.get(1);

        if (players.get(0).getWins() < players.get(1).getWins()){
            player.setWinner(player.getName());
        } else {
            player.setWinner(player.getName());
        }

        System.out.println(player.getWinner() + " is the winner with  " + player.getWins() + " wins!");
    }
}


