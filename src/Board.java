import java.util.ArrayList;

public class Board {


    //här ska allt gällande skapandet av boarden ligga


    private static ArrayList<String> board = new ArrayList<>();


    public static void createBoard(){

        for (int i = 0; i < 10; i++) {
            board.add(" ");
        }

        System.out.println("Board created");

    }


}

