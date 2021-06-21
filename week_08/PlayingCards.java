package week_08;

abstract class PlayingCards implements Comparable<PlayingCards> {

    private String player;
    private int number;

    protected PlayingCards(int number, String player) {
        this.number = number;
        this.player = player;
    }

    public int getNumber() {
        return number;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public abstract String select();

    @Override // 
    public int compareTo(PlayingCards o) {
        if (getNumber() > o.getNumber()) {
            return 1;
        } else if (getNumber() < o.getNumber()) {
            return -1;
        } else {
            return 0;
        }
    }
}
