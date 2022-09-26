import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Player> players = new ArrayList<Player>();


    public static void main(String[] args) {


        System.out.println("Welcome to tic tac toe");
        System.out.println("Player 1, please write your name");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();
        players.add(new Player(name1));
        System.out.println("Player 2, please write your name");
        String name2 = sc.nextLine();
        players.add(new Player(name2));


        new PlayGame();


    }
}