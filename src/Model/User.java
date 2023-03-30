package Model;

import java.util.ArrayList;

public class User {
    private int id;
    private String username,password;
    private ArrayList<SavedGame> allSavedGames;
    private SavedGame[] currentSavedGames = new SavedGame[3];
    private int totalCoins;
    private String currentCharacter;


}
