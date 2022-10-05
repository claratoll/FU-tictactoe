public class Player {

    private static String name;
    private static int wins;
    private int id;


    private String winner;
    private String letter;

    public int getWins() {
        return wins;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public String getLetter() {
        return letter;
    }

    public Player(String name, String letter) {
        this.name = name;
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void increaseScore() {
        wins++;
        System.out.println(name + " won with "+ wins + " wins!");
    }
}
