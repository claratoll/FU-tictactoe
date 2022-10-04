public class Player {


    //class
    //AI

    private static String name;
    private static int wins;
    private int id;
    private String winner;
    private String letter;


    public void setLetter(String letter) {
        this.letter = letter;
    }


    public String getWinner() {
        return winner;
    }


    public String getLetter() {
        return letter;
    }


    public int getId() {
        return id;
    }

    public Player(String name, String letter, int id) {
        this.name = name;
        this.letter = letter;
        this.id = id;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static void increaseScore() {
        wins++;
        System.out.println(name + " won with "+ wins + " wins!");
    }
}
