public class Player {


    private String name;
    private int wins;


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
