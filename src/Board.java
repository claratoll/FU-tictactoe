import java.util.ArrayList;

public class Board {
    private String[][] board;

    private int size;

    public Board(int size){
        this.size = size;
        this.board = new String[size][size];
        for (int row =0; row < size; row++){
            for (int col = 0; col < size; col++){
                board[row][col] = "";
            }
        }
    }

    public void printBoard(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String spot = board[row][col];
                System.out.print(spot.isEmpty() ? "[]" : spot);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }

    public Boolean markSpot(int row, int col, String letter) {
        String spot = board[row][col];
        if (spot.isEmpty()) {
            board[row][col] = letter;
            return true;
        }

        return false;
    }

    public String[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}
