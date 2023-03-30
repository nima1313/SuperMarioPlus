package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class User {
    private int id;
    private String username,password;
    private ArrayList<SavedGame> allSavedGames;
    private SavedGame[] currentSavedGames;
    private int totalCoins;

    ArrayList<Character> characters;
    private String currentCharacterName;

    public User(int id, String username, String password, ArrayList<SavedGame> allSavedGames, SavedGame[] currentSavedGames, int totalCoins, ArrayList<Character> characters, String currentCharacterName) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setAllSavedGames(allSavedGames);
        setCurrentSavedGames(currentSavedGames);
        setTotalCoins(totalCoins);
        setCharacters(characters);
        setCurrentCharacterName(currentCharacterName);
        Memory.allUsers.add(this);
    }

    public User(String username, String password){
        setId(Memory.allUsers.size());
        setUsername(username);
        setPassword(password);
        setAllSavedGames(new ArrayList<>());
        setCurrentSavedGames(new SavedGame[3]);
        setTotalCoins(0);
        makeNewCharacters();
        setCurrentCharacterName("Mario");
        Memory.allUsers.add(this);
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
                getCharacters().get(i).setCurrentPhase(1); //we always make the phase 1 before starting or continuing a new level
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

    public ArrayList<SavedGame> getAllSavedGames() {
        return allSavedGames;
    }

    public void setAllSavedGames(ArrayList<SavedGame> allSavedGames) {
        this.allSavedGames = allSavedGames;
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
}
