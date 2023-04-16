package View;

import Model.Memory;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderBoardPage extends JFrame {
    String columns[] = {"UserName", "HighScore"};
    public LeaderBoardPage(User user) {
        super("LeaderBoard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1200, 600);
        setLayout(null);
        Object data[][] = new Object[Memory.allUsers.size()][2];
        String names[] = new String[Memory.allUsers.size()];
        for (int i = 0; i < Memory.allUsers.size(); i++) names[i] = Memory.allUsers.get(i).getUsername();
        int highScores[] = new int[Memory.allUsers.size()];
        for (int i = 0; i < Memory.allUsers.size(); i++) highScores[i] = Memory.allUsers.get(i).getHighScore();
        for (int i = 0; i < Memory.allUsers.size(); i++) {
            for (int j = i; j < Memory.allUsers.size(); j++){
                if (highScores[i] < highScores[j]){
                    int temp = highScores[i];
                    highScores[i] = highScores[j];
                    highScores[j] = temp;

                    String temp2 = names[i];
                    names[i] = names[j];
                    names[j] = temp2;
                }
            }
        }
        for (int i = 0; i < Memory.allUsers.size(); i++) {
            data[i][0] = names[i];
            data[i][1] = highScores[i];
        }
        JTable table = new JTable(data, columns);
        table.setEnabled(false);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(20, 100, 1160, 500);
        add(jScrollPane);

        CustomButton backButton = new CustomButton("Back", 600 - 150, 10,300,80);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuPage(user);
                dispose();
            }
        });
        add(backButton);
        setVisible(true);
    }
}
