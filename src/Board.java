import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private static Board[][] board;

   // private static int N;
  //  private static int x = 1;
  //  public static String[][] board = new String[size][size];

    private String tile;

    private static int size;

   // private String board;

    public Board(String board) {
       // this.board = board;
    }

    /*public String[][] getBoard() {
        return board;
    }
*/

    public Board (){
        Board[][] board1 = board;
    }
    public Board(int size, String board) {
        this.size = size;
      //  this.board = board;
    }


    public static int createBoard(int size) {
    //    this.board =
        Board[][] boards = new Board[size][size];
        //  this.size = size;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Board();
            }
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
    //    for (int i = 0; i < size; i++) {
            //  board.add(" ");

    //    }

        return size;
    }
    //här ska allt gällande skapandet av boarden ligga

    private static void printBoard(boolean keepPlaying) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("[" + board[i][j] + "]" + " ");
            }

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



}}