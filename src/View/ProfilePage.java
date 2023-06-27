package View;

import Model.Characters.Character;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame {
    User user;
    JLabel username;
    JLabel highScore;
    JLabel coins;
    ImageIcon MarioImage;
    ImageIcon CarioImage;
    ImageIcon JarioImage;
    ImageIcon RarioImage;
    ImageIcon SarioImage;
    CustomButton MarioSelectButton;
    CustomButton CarioSelectButton;
    CustomButton JarioSelectButton;
    CustomButton RarioSelectButton;
    CustomButton SarioSelectButton;
    public ProfilePage(User user){
        this.user = user;
        setTitle("Profile Page");
        setSize(1000,800);
        setResizable(false);
        username = new JLabel("username : " + user.getUsername());
        username.setBounds(50,20,200,40);
        add(username);
        highScore = new JLabel("highScore : " + user.getHighScore());
        highScore.setBounds(50,70,200,40);
        add(highScore);
        coins = new JLabel("coins : " + user.getTotalCoins());
        coins.setBounds(50,120,200,40);
        add(coins);
        for (int i = 0 ; i < user.getCharacters().size();i++){
            Character thisCharacter = user.getCharacters().get(i);
            if (thisCharacter.getCharacterName().equals("Mario")){
                MarioImage = thisCharacter.getTexture();
                JLabel image = new JLabel(MarioImage);
                image.setBounds(50+200, 110, 100,100);
                add(image);
                MarioSelectButton = new CustomButton("",30+200,200,140,40);
                MarioSelectButton.setFont(new Font("Arial", Font.PLAIN, 14));
                if (!thisCharacter.isUnlocked()){
                    MarioSelectButton.setEnabled(false);
                    MarioSelectButton.setText("Not purchased");
                }
                else if (!user.getCurrentCharacter().equals(thisCharacter)) {
                    MarioSelectButton.setEnabled(true);
                    MarioSelectButton.setText("Select");
                }
                else {
                    MarioSelectButton.setEnabled(false);
                    MarioSelectButton.setText("Selected");
                }
                MarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectCharacter(thisCharacter.getCharacterName());
                    }
                });
                add(MarioSelectButton);
            }
            if (thisCharacter.getCharacterName() == "Cario"){
                CarioImage = thisCharacter.getTexture();
                JLabel image = new JLabel(CarioImage);
                image.setBounds(200+200, 110, 100,100);
                add(image);
                CarioSelectButton = new CustomButton("",180+200,200,140,40);
                CarioSelectButton.setFont(new Font("Arial", Font.PLAIN, 14));
                if (!thisCharacter.isUnlocked()){
                    CarioSelectButton.setEnabled(false);
                    CarioSelectButton.setText("Not purchased");
                }
                else if (!user.getCurrentCharacter().equals(thisCharacter)) {
                    CarioSelectButton.setEnabled(true);
                    CarioSelectButton.setText("Select");
                }
                else {
                    CarioSelectButton.setEnabled(false);
                    CarioSelectButton.setText("Selected");
                }
                CarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectCharacter(thisCharacter.getCharacterName());
                    }
                });
                add(CarioSelectButton);
            }
            if (thisCharacter.getCharacterName() == "Jario"){
                JarioImage = thisCharacter.getTexture();
                JLabel image = new JLabel(JarioImage);
                image.setBounds(350+200, 110, 100,100);
                add(image);
                JarioSelectButton = new CustomButton("",330+200,200,140,40);
                JarioSelectButton.setFont(new Font("Arial", Font.PLAIN, 14));
                if (!thisCharacter.isUnlocked()){
                    JarioSelectButton.setEnabled(false);
                    JarioSelectButton.setText("Not purchased");
                }
                else if (!user.getCurrentCharacter().equals(thisCharacter)) {
                    JarioSelectButton.setEnabled(true);
                    JarioSelectButton.setText("Select");
                }
                else {
                    JarioSelectButton.setEnabled(false);
                    JarioSelectButton.setText("Selected");
                }
                JarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectCharacter(thisCharacter.getCharacterName());
                    }
                });
                add(JarioSelectButton);
            }
            if (thisCharacter.getCharacterName() == "Rario"){
                RarioImage = thisCharacter.getTexture();
                JLabel image = new JLabel(RarioImage);
                image.setBounds(500+200, 110, 100,100);
                add(image);
                RarioSelectButton = new CustomButton("",480+200,200,140,40);
                RarioSelectButton.setFont(new Font("Arial", Font.PLAIN, 14));
                if (!thisCharacter.isUnlocked()){
                    RarioSelectButton.setEnabled(false);
                    RarioSelectButton.setText("Not purchased");
                }
                else if (!user.getCurrentCharacter().equals(thisCharacter)) {
                    RarioSelectButton.setEnabled(true);
                    RarioSelectButton.setText("Select");
                }
                else {
                    RarioSelectButton.setEnabled(false);
                    RarioSelectButton.setText("Selected");
                }
                RarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectCharacter(thisCharacter.getCharacterName());
                    }
                });
                add(RarioSelectButton);
            }
            if (thisCharacter.getCharacterName() == "Sario"){
                SarioImage = thisCharacter.getTexture();
                JLabel image = new JLabel(SarioImage);
                image.setBounds(650+200, 110, 100,100);
                add(image);
                SarioSelectButton = new CustomButton("",630+200,200,140,40);
                SarioSelectButton.setFont(new Font("Arial", Font.PLAIN, 14));
                if (!thisCharacter.isUnlocked()){
                    SarioSelectButton.setEnabled(false);
                    SarioSelectButton.setText("Not purchased");
                }
                else if (!user.getCurrentCharacter().equals(thisCharacter)) {
                    SarioSelectButton.setEnabled(true);
                    SarioSelectButton.setText("Select");
                }
                else {
                    SarioSelectButton.setEnabled(false);
                    SarioSelectButton.setText("Selected");
                }
                SarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectCharacter(thisCharacter.getCharacterName());
                    }
                });
                add(SarioSelectButton);
            }



        }
        JButton backButton = new JButton("Back");
        backButton.setBounds(10,700,100,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuPage(user);
                dispose();
            }
        });
        add(backButton);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel jLabel1_1 = new JLabel("Name: ");
        jLabel1_1.setBounds(20,250,50,50);
        add(jLabel1_1);
        JLabel jLabel1_2 = new JLabel("Jump: ");
        jLabel1_2.setBounds(20,350,50,50);
        add(jLabel1_2);
        JLabel jLabel1_3 = new JLabel("Speed: ");
        jLabel1_3.setBounds(20,450,50,50);
        add(jLabel1_3);
        JLabel jLabel1_4 = new JLabel("Coin collection coefficiency:");
        jLabel1_4.setBounds(20,550,200,50);
        add(jLabel1_4);
        JLabel jLabel1_5 = new JLabel("Reload time: ");
        jLabel1_5.setBounds(20,650,100,50);
        add(jLabel1_5);

        JLabel jLabel2_1 = new JLabel("Mario");
        jLabel2_1.setBounds(20+260,250,50,50);
        add(jLabel2_1);
        JLabel jLabel2_2 = new JLabel("16");
        jLabel2_2.setBounds(20+270,350,50,50);
        add(jLabel2_2);
        JLabel jLabel2_3 = new JLabel("5");
        jLabel2_3.setBounds(20+270,450,50,50);
        add(jLabel2_3);
        JLabel jLabel2_4 = new JLabel("1");
        jLabel2_4.setBounds(20+270,550,50,50);
        add(jLabel2_4);
        JLabel jLabel2_5 = new JLabel("0.8s");
        jLabel2_5.setBounds(20+260,650,50,50);
        add(jLabel2_5);

        JLabel jLabel3_1 = new JLabel("Cario");
        jLabel3_1.setBounds(20+260+150,250,50,50);
        add(jLabel3_1);
        JLabel jLabel3_2 = new JLabel("16");
        jLabel3_2.setBounds(20+270+150,350,50,50);
        add(jLabel3_2);
        JLabel jLabel3_3 = new JLabel("4");
        jLabel3_3.setBounds(20+270+150,450,50,50);
        add(jLabel3_3);
        JLabel jLabel3_4 = new JLabel("2");
        jLabel3_4.setBounds(20+270+150,550,50,50);
        add(jLabel3_4);
        JLabel jLabel3_5 = new JLabel("1.0s");
        jLabel3_5.setBounds(20+260+150,650,50,50);
        add(jLabel3_5);

        JLabel jLabel4_1 = new JLabel("Jario");
        jLabel4_1.setBounds(20+260+150+150,250,50,50);
        add(jLabel4_1);
        JLabel jLabel4_2 = new JLabel("20");
        jLabel4_2.setBounds(20+270+150+150,350,50,50);
        add(jLabel4_2);
        JLabel jLabel4_3 = new JLabel("4");
        jLabel4_3.setBounds(20+270+150+150,450,50,50);
        add(jLabel4_3);
        JLabel jLabel4_4 = new JLabel("1");
        jLabel4_4.setBounds(20+270+150+150,550,50,50);
        add(jLabel4_4);
        JLabel jLabel4_5 = new JLabel("1.0s");
        jLabel4_5.setBounds(20+260+150+150,650,50,50);
        add(jLabel4_5);

        JLabel jLabel5_1 = new JLabel("Rario");
        jLabel5_1.setBounds(20+260+150+150+150,250,50,50);
        add(jLabel5_1);
        JLabel jLabel5_2 = new JLabel("16");
        jLabel5_2.setBounds(20+270+150+150+150,350,50,50);
        add(jLabel5_2);
        JLabel jLabel5_3 = new JLabel("4");
        jLabel5_3.setBounds(20+270+150+150+150,450,50,50);
        add(jLabel5_3);
        JLabel jLabel5_4 = new JLabel("1");
        jLabel5_4.setBounds(20+270+150+150+150,550,50,50);
        add(jLabel5_4);
        JLabel jLabel5_5 = new JLabel("0.5s");
        jLabel5_5.setBounds(20+260+150+150+150,650,50,50);
        add(jLabel5_5);

        JLabel jLabel6_1 = new JLabel("Sario");
        jLabel6_1.setBounds(20+260+150+150+150+150,250,50,50);
        add(jLabel6_1);
        JLabel jLabel6_2 = new JLabel("16");
        jLabel6_2.setBounds(20+270+150+150+150+150,350,50,50);
        add(jLabel6_2);
        JLabel jLabel6_3 = new JLabel("8");
        jLabel6_3.setBounds(20+270+150+150+150+150,450,50,50);
        add(jLabel6_3);
        JLabel jLabel6_4 = new JLabel("1");
        jLabel6_4.setBounds(20+270+150+150+150+150,550,50,50);
        add(jLabel6_4);
        JLabel jLabel6_5 = new JLabel("1.0s");
        jLabel6_5.setBounds(20+260+150+150+150+150,650,50,50);
        add(jLabel6_5);


    }
    private void selectCharacter(String name){
        user.setCurrentCharacterName(name);
        if (JarioSelectButton.getText().equals("Selected")){
            JarioSelectButton.setEnabled(true);
            JarioSelectButton.setText("Select");
        }
        if (CarioSelectButton.getText().equals("Selected")){
            CarioSelectButton.setEnabled(true);
            CarioSelectButton.setText("Select");
        }
        if (SarioSelectButton.getText().equals("Selected")){
            SarioSelectButton.setEnabled(true);
            SarioSelectButton.setText("Select");
        }
        if (RarioSelectButton.getText().equals("Selected")){
            RarioSelectButton.setEnabled(true);
            RarioSelectButton.setText("Select");
        }
        if (MarioSelectButton.getText().equals("Selected")){
            MarioSelectButton.setEnabled(true);
            MarioSelectButton.setText("Select");
        }
        if (name.equals("Mario")){
            MarioSelectButton.setEnabled(false);
            MarioSelectButton.setText("Selected");
        }
        if (name.equals("Jario")){
            JarioSelectButton.setEnabled(false);
            JarioSelectButton.setText("Selected");
        }
        if (name.equals("Rario")){
            RarioSelectButton.setEnabled(false);
            RarioSelectButton.setText("Selected");
        }
        if (name.equals("Cario")){
            CarioSelectButton.setEnabled(false);
            CarioSelectButton.setText("Selected");
        }
        if (name.equals("Sario")){
            SarioSelectButton.setEnabled(false);
            SarioSelectButton.setText("Selected");
        }
    }
}
