package Model;

public class SavedGame {
    boolean saveEnded = false;
    private Level lastLevel;
    private int totalScore;
    private int remainingHearts = 3;
    private int currentLevelScore;
    private int currentLevelCoins;

    public SavedGame(int lastLevel,int lastSection, int totalScore, int remainingHearts,int currentLevelScore, int currentLevelCoins) {
        setLastLevel(levelMaker(lastLevel,lastSection));
        setTotalScore(totalScore);
        setRemainingHearts(remainingHearts);
        setCurrentLevelCoins(currentLevelCoins);
        setCurrentLevelScore(currentLevelScore);
    }

    public SavedGame(){
        setLastLevel(new Level1(0));
        setTotalScore(0);
        setRemainingHearts(3);
        setCurrentLevelCoins(0);
        setCurrentLevelScore(0);
    }
    public Level levelMaker(int lastLevel, int lastSection){
        if (lastLevel == 1){
            return new Level1(lastSection);
        }
        else return null;
        //TODO : Update this for the next phases
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

    public int getRemainingHearts() {
        return remainingHearts;
    }

    public void setRemainingHearts(int remainingHearts) {
        this.remainingHearts = remainingHearts;
    }

    public int getCurrentLevelScore() {
        return currentLevelScore;
    }

    public void setCurrentLevelScore(int currentLevelScore) {
        this.currentLevelScore = currentLevelScore;
    }

    public int getCurrentLevelCoins() {
        return currentLevelCoins;
    }

    public void setCurrentLevelCoins(int currentLevelCoins) {
        this.currentLevelCoins = currentLevelCoins;
    }

    public boolean isSaveEnded() {
        return saveEnded;
    }

    public void setSaveEnded(boolean saveEnded) {
        this.saveEnded = saveEnded;
    }
}
