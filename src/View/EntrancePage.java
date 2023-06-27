package View;

import Model.*;
import Model.Characters.*;
import Model.Characters.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EntrancePage extends JFrame {
    public EntrancePage() {
        super("Super Mario");
        ReadData.readData();
        //THIS IS TOF (for transient parts of character class)

        for (int i = 0; i < Memory.allUsers.size(); i++) {
            ArrayList<Character> characters = Memory.allUsers.get(i).getCharacters();
            for (int j = 0; j < characters.size(); j++) {
                if (characters.get(j).getCharacterName().equals("Mario")) characters.set(j, new Mario());
                if (characters.get(j).getCharacterName().equals("Jario")) characters.set(j, new Jario());
                if (characters.get(j).getCharacterName().equals("Sario")) characters.set(j, new Sario());
                if (characters.get(j).getCharacterName().equals("Rario")) characters.set(j, new Rario());
                if (characters.get(j).getCharacterName().equals("Cario")) characters.set(j, new Cario());
            }
            SavedGame[] savedGames = Memory.allUsers.get(i).getCurrentSavedGames();
            for (int j = 0; j < savedGames.length; j++) {
                if (savedGames[j] == null) continue;
                Character character = savedGames[j].getCharacter();
                if (character.getCharacterName().equals("Mario")) character = new Mario();
                if (character.getCharacterName().equals("Jario")) character = new Jario();
                if (character.getCharacterName().equals("Sario")) character = new Sario();
                if (character.getCharacterName().equals("Rario")) character = new Rario();
                if (character.getCharacterName().equals("Cario")) character = new Cario();
                savedGames[j].setCharacter(character);
            }
            Memory.allUsers.get(i).setCurrentSavedGames(savedGames);
            Memory.allUsers.get(i).setCharacters(characters);
        }

        //           //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(820, 450);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("EntrancePageBackground.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(null);
        CustomButton loginButton = new CustomButton("Login", 300, 25, 200, 100);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
        panel.add(loginButton);

        CustomButton signupButton = new CustomButton("Sign up", 20, 275, 200, 100);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUpPage();
                dispose();
            }
        });
        panel.add(signupButton);

        CustomButton exitButton = new CustomButton("Exit", 580, 275, 200, 100);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        setContentPane(panel);
        //setLayout(null);
        setVisible(true);
    }

}
