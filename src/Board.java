import java.util.ArrayList;

public class Board {

    private String tile;
    private static int size;

    private String board;

    public Board(String board) {
        this.board = board;
    }

    public Board (int size, String board){
        this.size = size;
        this.board = board;
    }


    public static void createBoard() {
        //måste göra en reset här

        //create board
        for (int i = 0; i < size; i++) {
          //  board.add(" ");
        }
    }
    //här ska allt gällande skapandet av boarden ligga

    private static void printBoard(boolean keepPlaying) {
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

