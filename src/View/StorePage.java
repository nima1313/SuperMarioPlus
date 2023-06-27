package View;

import Model.Characters.Character;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StorePage extends JFrame {
    User user;
    JLabel name;
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
    public StorePage(User user){
        this.user = user;
        setTitle("Store Page");
        setSize(1000,900);
        setResizable(false);
        name = new JLabel("Store");
        name.setBounds(450,-50,200,200);
        name.setFont(new Font("Arial", Font.PLAIN, 50));
        add(name);
        updateCoins();

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
                    MarioSelectButton.setEnabled(true);
                    MarioSelectButton.setText("Buy");
                }
                else {
                    MarioSelectButton.setEnabled(false);
                    MarioSelectButton.setText("Acquired");
                }
                MarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buyCharacter(thisCharacter);
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
                    CarioSelectButton.setEnabled(true);
                    CarioSelectButton.setText("Buy");
                }
                else {
                    CarioSelectButton.setEnabled(false);
                    CarioSelectButton.setText("Acquired");
                }
                CarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buyCharacter(thisCharacter);
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
                    JarioSelectButton.setEnabled(true);
                    JarioSelectButton.setText("Buy");
                }
                else {
                    JarioSelectButton.setEnabled(false);
                    JarioSelectButton.setText("Acquired");
                }
                JarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buyCharacter(thisCharacter);
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
                    RarioSelectButton.setEnabled(true);
                    RarioSelectButton.setText("Buy");
                }
                else {
                    RarioSelectButton.setEnabled(false);
                    RarioSelectButton.setText("Acquired");
                }
                RarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buyCharacter(thisCharacter);
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
                    SarioSelectButton.setEnabled(true);
                    SarioSelectButton.setText("Buy");
                }
                else {
                    SarioSelectButton.setEnabled(false);
                    SarioSelectButton.setText("Acquired");
                }
                SarioSelectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buyCharacter(thisCharacter);
                    }
                });
                add(SarioSelectButton);
            }



        }
        JButton backButton = new JButton("Back");
        backButton.setBounds(10,800,100,30);
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
        JLabel jLabel1_6 = new JLabel("Price: ");
        jLabel1_6.setBounds(20,750,100,50);
        add(jLabel1_6);

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
        JLabel jLabel2_6 = new JLabel("----");
        jLabel2_6.setBounds(20+260,750,50,50);
        add(jLabel2_6);

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
        JLabel jLabel3_6 = new JLabel("40 coins");
        jLabel3_6.setBounds(10+260+150,750,50,50);
        add(jLabel3_6);

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
        JLabel jLabel4_6 = new JLabel("35 coins");
        jLabel4_6.setBounds(10+260+150+150,750,50,50);
        add(jLabel4_6);

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
        JLabel jLabel5_6 = new JLabel("30 coins");
        jLabel5_6.setBounds(10+260+150+150+150,750,50,50);
        add(jLabel5_6);

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
        JLabel jLabel6_6 = new JLabel("35 coins");
        jLabel6_6.setBounds(10+260+150+150+150+150,750,50,50);
        add(jLabel6_6);


    }
    private void buyCharacter(Character character){
        String name = character.getCharacterName();
        if (name.equals("Jario")){
            if (user.getTotalCoins() >= 35){
                JarioSelectButton.setEnabled(false);
                JarioSelectButton.setText("Acquired");
                user.setTotalCoins(user.getTotalCoins() - 35);
                unlockCharacter(character);
                updateCoins();
            }
            else{
                StorePage tof = this;
                JOptionPane.showMessageDialog(tof,"You have don't have enough coins");
            }

        }
        if (name.equals("Rario")){
            if (user.getTotalCoins() >= 35){
                RarioSelectButton.setEnabled(false);
                RarioSelectButton.setText("Acquired");
                user.setTotalCoins(user.getTotalCoins() - 30);
                unlockCharacter(character);
                updateCoins();
            }
            else {
                StorePage tof = this;
                JOptionPane.showMessageDialog(tof,"You have don't have enough coins");
            }
        }
        if (name.equals("Cario")){
            if (user.getTotalCoins() >= 40) {
                CarioSelectButton.setEnabled(false);
                CarioSelectButton.setText("Acquired");
                user.setTotalCoins(user.getTotalCoins() - 40);
                unlockCharacter(character);
                updateCoins();
            }
            else{
                StorePage tof = this;
                JOptionPane.showMessageDialog(tof,"You have don't have enough coins");
            }
        }
        if (name.equals("Sario")){
            if (user.getTotalCoins() >= 35) {
                SarioSelectButton.setEnabled(false);
                SarioSelectButton.setText("Acquired");
                user.setTotalCoins(user.getTotalCoins() - 35);
                unlockCharacter(character);
                updateCoins();
            }
            else{
                StorePage tof = this;
                JOptionPane.showMessageDialog(tof,"You have don't have enough coins");
            }
        }
    }
    private void updateCoins(){
        JPanel jPanel = new JPanel();
        coins = new JLabel("coins : " + user.getTotalCoins());
        coins.setFont(new Font("Arial", Font.PLAIN, 20));
        jPanel.setBounds(50,100,300,40);
        jPanel.add(coins);
        add(jPanel);
    }
    private void unlockCharacter(Character character){
        ArrayList<Character> characters = user.getCharacters();
        for (int i = 0 ; i < characters.size() ;i++){
            if (characters.get(i).equals(character)){
                characters.get(i).setUnlocked(true);
            }
        }
    }
}
