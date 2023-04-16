package View;

import Model.User;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPage extends JFrame {
    User user;
    public MainMenuPage(User user) {
        this.user = user;
        setTitle("Main Menu");

        setSize(1000, 200);

        getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));


        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGamePage(user);
                dispose();
            }
        });
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContinuePage(user);
                dispose();
            }
        });
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LeaderBoardPage(user);
                dispose();
            }
        });
        JButton storeButton = new JButton("Store");
        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StorePage(user);
                dispose();
            }
        });
        JButton profileButton = new JButton("Profile");
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfilePage(user);
                dispose();
            }
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(continueButton);
        buttonPanel.add(leaderboardButton);
        buttonPanel.add(storeButton);
        buttonPanel.add(profileButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EntrancePage();
                dispose();
            }
        });

        backPanel.add(backButton);


        JPanel coinsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton coinsButton = new JButton("Coins");
        MainMenuPage tof = this;
        coinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(tof,"You have " + user.getTotalCoins() + " coins.");
            }
        });
        coinsPanel.add(coinsButton);

        bottomPanel.add(backPanel, BorderLayout.WEST);
        bottomPanel.add(coinsPanel, BorderLayout.EAST);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }
}
