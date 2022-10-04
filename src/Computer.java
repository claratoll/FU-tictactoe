import java.util.Random;

public class Computer extends Player{
    public Computer(String name, String letter, int id) {
        super(name, letter, id);
    }

    public void takeTurn (String[][] board, Player player){

        String letter = " ";

        int vertical = 0;
        int horizontal = 0;
        int diagonal = 0;
        boolean madeMove = false;

        // check if you can take a win horizontally
        for(int i = 0; i<3; i++){

            if(board[0][i].equals(board[1][i]) && board[0][i].equals(letter)){

                if(board[2][i] != player.getLetter() && board[2][i] != letter){
                    board[2][i] = letter;
                    madeMove = true;
                    return;
                }

            }

        }

        for(int i = 0; i<3; i++){

            if(board[2][i].equals(board[1][i]) && board[2][i].equals(letter)){

                if(board[0][i] != player.getLetter() && board[0][i] != letter){
                    board[0][i] = letter;
                    madeMove = true;
                    return;
                }

            }


        }



        // check if you can take a win horizontally
        for(int i = 0; i<3; i++){

            if(board[i][0].equals(board[i][1]) && board[i][0].equals(letter)){

                if(board[i][2] != player.getLetter() && board[i][2] != letter){
                    board[i][2] = letter;
                    madeMove = true;
                    return;
                }

            }

        }

        for(int i = 0; i<3; i++){

            if(board[i][2].equals(board[i][1]) && board[i][2].equals(letter)){

                if(board[i][0] != player.getLetter() && board[i][0] != letter){
                    board[i][0] = letter;
                    madeMove = true;
                    return;
                }

            }

        }


        // check if you can take a win diagonally bottom


        if(board[0][0].equals(board[1][1]) && board[0][0].equals(letter)){

            if(board[2][2] != player.getLetter() && board[2][2] != letter){
                board[2][2] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[2][2].equals(board[1][1]) && board[2][2].equals(letter)){

            if(board[0][0] != player.getLetter() && board[0][0] != letter){
                board[0][0] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[0][0].equals(board[1][1]) && board[0][0].equals(letter)){

            if(board[2][2] != player.getLetter() && board[2][2] != letter){
                board[2][2] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[0][2].equals(board[1][1]) && board[0][2].equals(letter)){

            if(board[2][0] != player.getLetter() && board[2][0] != letter){
                board[2][0] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[2][0].equals(board[1][1]) && board[2][0].equals(letter)){

            if(board[0][2] != player.getLetter() && board[0][2] != letter){
                board[0][2] = letter;
                madeMove = true;
                return;
            }
        }


        // BLOCKS!!!! //

        // check if you can block a win horizontally
        for(int i = 0; i<3; i++){

            if(board[0][i].equals(board[1][i]) && board[0][i].equals(player.getLetter())){
                if(board[2][i] != letter && board[2][i] != player.getLetter()){
                    board[2][i] = letter;
                    madeMove = true;
                    return;
                }

            }

        }

        for(int i = 0; i<3; i++){

            if(board[2][i].equals(board[1][i]) && board[0][i].equals(player.getLetter())){

                if(board[0][i] != letter && board[0][i] != player.getLetter()){
                    board[0][i] = letter;
                    madeMove = true;
                    return;
                }

            }


        }

        // check if you can block a win vertically


        for(int i = 0; i<3; i++){

            if(board[i][0].equals(board[i][1]) && board[i][0].equals(player.getLetter())){

                if(board[i][2] != letter && board[i][2] != player.getLetter()){
                    board[i][2] = letter;
                    madeMove = true;
                    return;
                }

            }

        }

        for(int i = 0; i<3; i++){

            if(board[i][2].equals(board[i][1]) && board[i][2].equals(player.getLetter())){

                if(board[i][0] != letter && board[i][0] != player.getLetter()){
                    board[i][0] = letter;
                    madeMove = true;
                    return;
                }

            }

        }

        for(int i = 0; i<3; i++){

            if(board[2][i].equals(board[1][i]) && board[2][i].equals(player.getLetter())){

                if(board[0][i] != letter && board[0][i] != player.getLetter()){
                    board[0][i] = letter;
                    madeMove = true;
                    return;
                }

            }

        }



        // check if you can block a win diagonally


        if(board[0][0].equals(board[1][1]) && board[0][0].equals(player.getLetter())){

            if(board[2][2] != letter && board[2][2] != player.getLetter()){
                board[2][2] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[2][2].equals(board[1][1]) && board[2][2].equals(player.getLetter())){

            if(board[0][0] != letter && board[0][0] != player.getLetter()){
                board[0][0] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[0][0].equals(board[1][1]) && board[0][0].equals(player.getLetter())){
            if(board[2][2] != letter && board[2][2] != player.getLetter()){
                board[2][2] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[0][2].equals(board[1][1]) && board[0][2].equals(player.getLetter())){

            if(board[2][0] != letter && board[2][0] != player.getLetter()){
                board[2][0] = letter;
                madeMove = true;
                return;
            }
        }

        if(board[2][0].equals(board[1][1]) && board[2][0].equals(player.getLetter())){

            if(board[0][2] != letter && board[0][2] != player.getLetter()){
                board[0][2] = letter;
                madeMove = true;
                return;
            }
        }

        // make random move if above rules dont apply
        int rand1 = 0;
        int rand2 = 0;

        while(!madeMove){

            rand1 = (int) (Math.random() * 3);
            rand2 = (int) (Math.random() * 3);

            if(board[rand1][rand2] != "x" && board[rand1][rand2] != "o"){
                board[rand1][rand2] = letter;
                madeMove = true;

            }

        }


    }

    @Override
    public String getLetter(){
        String letter = "X";
        return letter;
    }

   /* private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer choose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    } */


    public int createComputerTurn(){
        Random rand = new Random();
        int computerMove;
        computerMove = rand.nextInt(9) +1;

        return computerMove;
    }


}
