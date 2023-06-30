package View;

import Model.SavedGame;
import Model.User;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewGamePage extends JFrame {
    User user;

    public NewGamePage(User user){
        this.user = user;
        setSize(500, 300);
        JPanel row1;
        if (user.getCurrentSavedGames()[0] == null){
            row1 = createRow("Save disk is empty",0);
        }
        else if (user.getCurrentSavedGames()[0].isSaveEnded()) {
            row1 = createRow("Save is finished",0);
        }
        else{
            row1 = createRow("Level : (" + user.getCurrentSavedGames()[0].getLastLevel() + ") section : ("+ (user.getCurrentSavedGames()[0].getLastSection() + 1) + "), character : (" + user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()].getCharacter().getCharacterName() + "), total Score : (" + user.getCurrentSavedGames()[0].getTotalScore()+") ",0);
        }
        JPanel row2;
        if (user.getCurrentSavedGames()[1] == null){
            row2 = createRow("Save disk is empty",1);
        }
        else if (user.getCurrentSavedGames()[1].isSaveEnded()) {
            row2 = createRow("Save is finished",1);
        }
        else{
            row2 = createRow("Level : (" + user.getCurrentSavedGames()[1].getLastLevel() + ") section : ("+ (user.getCurrentSavedGames()[1].getLastSection() + 1) + "), character : (" + user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()].getCharacter().getCharacterName() + "), total Score : (" + user.getCurrentSavedGames()[1].getTotalScore()+") ",1);
        }
        JPanel row3;
        if (user.getCurrentSavedGames()[2] == null){
            row3 = createRow("Save disk is empty",2);
        }
        else if (user.getCurrentSavedGames()[2].isSaveEnded()) {
            row3 = createRow("Save is finished",2);
        }
        else{
            row3 = createRow("Level : (" + user.getCurrentSavedGames()[2].getLastLevel() + ") section : ("+ (user.getCurrentSavedGames()[2].getLastSection() + 1) + "), character : (" + user.getCurrentSavedGames()[user.getSelectedSavedGameIndex()].getCharacter().getCharacterName() + "), total Score : (" + user.getCurrentSavedGames()[2].getTotalScore()+") ",2);

        }
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add(row1);
        contentPane.add(row2);
        contentPane.add(row3);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuPage(user);
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        contentPane.add(buttonPanel);


        setContentPane(contentPane);

        setVisible(true);
    }

    private JPanel createRow(String labelText, int index) {
        JPanel row = new JPanel();

        JLabel label = new JLabel(labelText);
        JButton button = new JButton("NEW GAME");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SavedGame newSavedGame = new SavedGame(user);
                SavedGame[] allCurrentSavedGames = user.getCurrentSavedGames();
                allCurrentSavedGames[index] = newSavedGame;
                user.setCurrentSavedGames(allCurrentSavedGames);
                user.setSelectedSavedGameIndex(index);
                try {
                    new GameFrame(user);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        row.add(label);
        row.add(button);

        return row;
    }
}
