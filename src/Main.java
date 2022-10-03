
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to tic tac toe");
        System.out.println("To play the game you have to choose a number between 1 and 9.\n 1,2,3 is the numbers on the first row.\n If you choose number 5 you will mark the spot in the middle of the board.\n The goal is to get three in a row.\n Good luck!");

        Board board = new Board(" x");
    //    board.getBoard();
        board.createBoard();

       // new Game();



    }
}