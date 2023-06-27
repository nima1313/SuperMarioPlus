package Model;

import Model.Characters.*;
import Model.Characters.Character;

import java.util.ArrayList;

public class User {
    private int id;
    private String username,password;
    private SavedGame[] currentSavedGames;
    private int totalCoins;

    private int highScore = 0;

    private int selectedSavedGameIndex = 0;

    ArrayList<Character> characters = new ArrayList<>();
    private String currentCharacterName;

    public User(int id, String username, String password, SavedGame[] currentSavedGames, int totalCoins, ArrayList<Character> characters, String currentCharacterName) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setCurrentSavedGames(currentSavedGames);
        setTotalCoins(totalCoins);
        setCharacters(characters);
        setCurrentCharacterName(currentCharacterName);
    }

    public User(String username, String password){
        setId(Memory.allUsers.size());
        setUsername(username);
        setPassword(password);
        setCurrentSavedGames(new SavedGame[3]);
        setTotalCoins(0);
        makeNewCharacters();
        setCurrentCharacterName("Mario");
    }

    public void makeNewCharacters(){
        Mario mario = new Mario();
        Cario cario = new Cario();
        Jario jario = new Jario();
        Rario rario = new Rario();
        Sario sario = new Sario();
        this.characters.add(mario);
        this.characters.add(cario);
        this.characters.add(jario);
        this.characters.add(rario);
        this.characters.add(sario);
    }
    public Character getCurrentCharacter(){
        for (int i = 0 ; i < getCharacters().size();i++){
            if (getCurrentCharacterName().equals(getCharacters().get(i).getCharacterName())){
                return getCharacters().get(i);
            }
        }
        System.out.println("No character with that name was found");
        return null;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SavedGame[] getCurrentSavedGames() {
        return currentSavedGames;
    }

    public void setCurrentSavedGames(SavedGame[] currentSavedGames) {
        this.currentSavedGames = currentSavedGames;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(int totalCoins) {
        this.totalCoins = totalCoins;
    }

    public String getCurrentCharacterName() {
        return currentCharacterName;
    }

    public void setCurrentCharacterName(String currentCharacterName) {
        this.currentCharacterName = currentCharacterName;
    }

    public int getSelectedSavedGameIndex() {
        return selectedSavedGameIndex;
    }

    public void setSelectedSavedGameIndex(int selectedSavedGameIndex) {
        this.selectedSavedGameIndex = selectedSavedGameIndex;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

}
