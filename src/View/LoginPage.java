package View;

import Model.Memory;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");

    LoginPage() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        userLabel.setBounds(50, 20, 80, 25);
        panel.add(userLabel);

        userField.setBounds(140, 20, 165, 25);
        panel.add(userField);

        passwordLabel.setBounds(50, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField.setBounds(140, 50, 165, 25);
        panel.add(passwordField);

        loginButton.setBounds(170, 90, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(30,120,80,25);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EntrancePage();
                dispose();
            }
        });

        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String password = String.valueOf(passwordField.getPassword());
        boolean userExists = false;
        for (int i = 0 ; i < Memory.allUsers.size(); i++){
            if (Memory.allUsers.get(i).getUsername().equals(user)){
                userExists = true;
                break;
            }
        }
        if (userExists){
            for (int i = 0 ; i < Memory.allUsers.size(); i++){
                if (Memory.allUsers.get(i).getUsername().equals(user)){
                    if (Memory.allUsers.get(i).getPassword().equals(password)){
                        new MainMenuPage(Memory.allUsers.get(i));
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Invalid username or password.");
                    }
                    break;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
}
