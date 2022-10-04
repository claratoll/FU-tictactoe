
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
                //varför ska det inte vara board med litet b?
              //  board.createBoard(size);
                startGame = false;
            }


            printBoard(booleanPlayGame);

            turn = Turn.values()[new Random().nextInt(Turn.values().length)];

            //start the game
            Play();

            System.out.println("Do you want to play again? yes or no");
            Scanner sc = new Scanner(System.in);
            try{
                String answer = sc.nextLine();
                if (answer.equals("yes")) {
                    booleanPlayGame = true;

                    board.clear();
                   // createBoard();
                    Play();

                } else {
                    System.out.println("Thank you for playing!");
                    keepPlaying = false;
                    //    System.out.println(player.getName() + " won!");
                }
            } catch (Exception e){
                System.out.println("Please write 'yes' or 'no'");
            }

        }
    }

    public static ArrayList<Player> createPlayers() {
        //create players
        int playerNum;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play against a computer or with friends?\n If Friends, write '1', if Computer, write '2'");
        int playChoice = scan.nextInt();
        if (playChoice == 2){
            playerNum = 1;
            Computer computer = new Computer("Computer", "X", 1);
        } else {
            playerNum = 2;
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < playerNum; i++) {
            System.out.println("Player " + (i + 1) + ", please write your name");
            String name = sc.nextLine();
            System.out.println(name + ", please write your letter you want to play with");
            String letter = sc.nextLine();
            players.add(new Player(name, letter, i));
        }
        return players;

    }

  /*  boolean placeMarker (int place, char marker){
        if ( ledig ){
            board[place - 1] = marker;
            return true;
        }

        return false
    }
*/


    private static void createBoard() {
         board.clear();


        System.out.println("Choose the size of the board game; 2x2, 3x3, 4x4 etc. \nWrite the number of how big your board should be:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        try {
            if (1 >= size){
                System.out.println("Board could not be created, please write a number larger than 1");
                size = sc.nextInt();
            } else {
                System.out.println("Creating board with " + size + " x " + size);
            }
        } catch (Exception e) {
            System.out.println("Invalid input; try again.");
        }



            board.add(size, " ");



      //  for (int i = 0; i < 10; i++) {
      //      board.add(" ");
     //   }
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
                while (inputNumber < 1 || inputNumber > 9 || !Objects.equals(board.get(inputNumber -1), " ")) {
                    System.out.println("Invalid input; re-enter your number");
                    inputNumber = sc.nextInt();
                }

           /*     while (!Objects.equals(board.get(inputNumber -1), " ") ){
                    System.out.println("Place already taken, choose another place.");
                    inputNumber = sc.nextInt();
                }*/
/*

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
*/
                checkIfWinner(player.getLetter().toString());
                printBoard(booleanPlayGame);


               // turn = player.getId() == 0 ? Turn.Player2 : Turn.Player;


                if (player.getId() == 0) {
                    turn = Turn.Player2;
                } else {
                    turn = Turn.Player;
                }


            } catch (Exception e) {
                System.out.println("Invalid input; try again.");
            }
        }

    }


    private void checkIfWinner(String letter) {

   /*     for (int a = 0; a < 8; a++) {
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
                player.increaseScore();
                booleanPlayGame = false;
                break;
            }
        }

    */
    }

    private static void printBoard(boolean keepPlaying) {
        if (keepPlaying) {
            System.out.println("Current board:");

            //loopa igenom size

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = "" + (x);
                    x++;
                    System.out.println("hejj");
                }
           /* System.out.println(" " + board.get(0) + " | " + board.get(1) + " | " + board.get(2));
            System.out.println("---+---+---");
            System.out.println(" " + board.get(3) + " | " + board.get(4) + " | " + board.get(5));
            System.out.println("---+---+---");
            System.out.println(" " + board.get(6) + " | " + board.get(7) + " | " + board.get(8));

       */

        }
    }
}