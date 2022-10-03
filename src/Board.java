import java.util.ArrayList;
import java.util.Scanner;

public class Board {

   // private static int N;
  //  private static int x = 1;
  //  public static String[][] board = new String[size][size];

    private String tile;

    private static int size;

    private String board;

    public Board(String board) {
        this.board = board;
    }

    /*public String[][] getBoard() {
        return board;
    }
*/

    public Board(int size, String board) {
        this.size = size;
        this.board = board;
    }


    public static void createBoard() {
        System.out.println("Choose the size of the board game; 2x2, 3x3, 4x4 etc. \nWrite the number of how big your board should be:");
        Scanner sc = new Scanner(System.in);
        try {
            size = sc.nextInt();
            if (1 <= size){
                System.out.println("Board could not be created, please write a number larger than 1");
                size = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Invalid input; try again.");
        }

        //måste göra en reset här
        // board.clear();

      /*  for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "" + (x);
                x++;
                System.out.println("hejj");
            }
        }*/

        //create board
        for (int i = 0; i < size; i++) {
            //  board.add(" ");

        }
    }
    //här ska allt gällande skapandet av boarden ligga

    private static void printBoard(boolean keepPlaying) {

      /*  for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("[" + board[i][j] + "]" + " ");
            }*/

            if (keepPlaying) {
                System.out.println("Current board:");
            } else {
                System.out.println("WINNER BOARD");
            }


            // System.out.println(" " + board.get(0) + " | " + board.get(1) + " | " + board.get(2));
            // System.out.println("---+---+---");
            // System.out.println(" " + board.get(3) + " | " + board.get(4) + " | " + board.get(5));
            // System.out.println("---+---+---");
            // System.out.println(" " + board.get(6) + " | " + board.get(7) + " | " + board.get(8));
        }

    }

}