
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
            players.add(new Player(name, letter));
        }

        } catch (Exception e) {
            System.out.println("Please write again.");
        }
        return players;
    }


    private void createBoard() {
        //create how big board the users want and send it to Board to create a board.
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

            while (true) {
                String answer = sc.nextLine();
                if (answer.equals("yes")) {
                    //Creating new board
                    createBoard();
                    break;

                } else if (answer.equals("no")) {
                    System.out.println("Thank you for playing!");
                    keepPlaying = false;

                    //check if there is an all-time winner
                    allTimeWinner();
                    break;
                } else {
                    System.out.println("Please write yes or no.");
                }
            }

        }
    }

    public void play() {
        while (booleanPlayGame) {
            int rowNumber;
            int colNumber;

            player = turn == Turn.Player ? players.get(0) : players.get(1);

            // while booleanPlayGame true - players choose which place they want to put their mark
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

                //if booleanPLayGame returns false - player earns a "win" and game breaks
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
        //collecting wins for each player
        int winPlayer1 = players.get(0).getWins();
        int winPlayer2 = players.get(1).getWins();

        //if else to check if there is a tie or which of the players that wins
        if (winPlayer1 > winPlayer2){
            player.setWinner(players.get(0).getName());
            System.out.println(player.getWinner() + " is the winner with  " + winPlayer1 + " wins!");
        } else if (winPlayer1 == winPlayer2){
            System.out.println("It's a tie!");
        } else {
            player.setWinner(players.get(1).getName());
            System.out.println(player.getWinner() + " is the winner with  " + winPlayer2 + " wins!");
        }
    }
}


