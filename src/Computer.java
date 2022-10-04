import java.util.Random;

public class Computer extends Player{
    public Computer(String name, String letter, int id) {
        super(name, letter, id);
    }

    public void takeTurn (String[][] board, Player player){

    }


    @Override
    public String getLetter(){
        String letter = "X";
        return letter;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
       //     if (isValidMove(board, Integer.toString(computerMove))) {
                break;
           // }
        }
        System.out.println("Computer choose " + computerMove);
      //  placeMove(board, Integer.toString(computerMove), 'O');
    }

    public int createComputerTurn(){
        Random rand = new Random();
        int computerMove;
        computerMove = rand.nextInt(9) +1;

        return computerMove;
    }

}
