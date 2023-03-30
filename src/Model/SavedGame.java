package Model;

public class SavedGame {
    private int id;
    private Level lastLevel;
    private int totalScore;

    public SavedGame(int id, Level lastLevel, int totalScore) {
        setId(id);
        setLastLevel(lastLevel);
        setTotalScore(totalScore);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Level getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(Level lastLevel) {
        this.lastLevel = lastLevel;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
