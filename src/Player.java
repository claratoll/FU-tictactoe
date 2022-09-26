public class Player {


    private String name;
    private int wins;
    private int id;

    public String getLetter() {
        return letter;
    }

    private String letter;

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


    public void increaseScore() {
        wins++;
        System.out.println(wins);
    }
}
