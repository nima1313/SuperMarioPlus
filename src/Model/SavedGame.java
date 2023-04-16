package Model;

public class SavedGame {
    boolean saveEnded = false;
    private Level lastLevel;
    private int totalScore;
    private int remainingHearts = 3;
    private int currentLevelScore;
    private int currentSectionCoins;
    Character character;

    public SavedGame(int lastLevel,int lastSection, int totalScore, int remainingHearts,int currentLevelScore, int currentSectionCoins, String characterName) {
        setLastLevel(levelMaker(lastLevel,lastSection));
        setTotalScore(totalScore);
        setRemainingHearts(remainingHearts);
        setCurrentSectionCoins(currentSectionCoins);
        setCurrentLevelScore(currentLevelScore);
        if (characterName.equals("Mario")) setCharacter(new Mario());
        if (characterName.equals("Rario")) setCharacter(new Rario());
        if (characterName.equals("Jario")) setCharacter(new Jario());
        if (characterName.equals("Cario")) setCharacter(new Cario());
        if (characterName.equals("Sario")) setCharacter(new Sario());
    }

    public SavedGame(User user){
        setLastLevel(new Level1(0));
        setTotalScore(0);
        setRemainingHearts(3);
        setCurrentSectionCoins(0);
        setCurrentLevelScore(0);
        setCharacter(user.getCurrentCharacter());
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

    public int getCurrentSectionCoins() {
        return currentSectionCoins;
    }

    public void setCurrentSectionCoins(int currentSectionCoins) {
        this.currentSectionCoins = currentSectionCoins;
    }

    public boolean isSaveEnded() {
        return saveEnded;
    }

    public void setSaveEnded(boolean saveEnded) {
        this.saveEnded = saveEnded;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
