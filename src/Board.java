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

    public Boolean checkWinner(int row, int col, String letter, Boolean booleanPlayGame){
        int countMove = 0;

        //check col
        for(int i = 0; i < size; i++){
            if(board[i][col] != letter)
                break;
            if(i == size-1){
                System.out.println("Col win");
                booleanPlayGame = false;
            }
        }

        //to check if it's a draw the moves are saved in countMove
        countMove++;

        //check row
        for(int i = 0; i < size; i++){
            if(board[row][i] != letter)
                break;
            if(i == size-1){
                System.out.println("row win");
                booleanPlayGame = false;
            }
        }

        //check diagonal
        if(row == col){
            for(int i = 0; i < size; i++){
                if(board[i][i] != letter)
                    break;
                if(i == size-1){
                    System.out.println("Diagonal win");
                    booleanPlayGame = false;
                }
            }
        }

        //check anti diagonal
        if(row + col == size - 1){
            for(int i = 0; i < size; i++){
                if(board[i][(size-1)-i] != letter)
                    break;
                if(i == size-1){
                    System.out.println("anti diagonal win");
                    booleanPlayGame = false;
                }
            }
        }

        //check draw
        if(countMove == (Math.pow(size, 2) - 1)){
            System.out.println("Draw! No Winners");
        }

        return booleanPlayGame;
    }
}
