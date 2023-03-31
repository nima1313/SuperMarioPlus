package View;

import Model.Memory;
import Model.User;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JFrame implements ActionListener {

    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton signupButton = new JButton("Sign up");
    JButton backButton = new JButton("Back");

    SignUpPage() {
        setTitle("Signup Form");
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

        signupButton.setBounds(170, 90, 80, 25);
        signupButton.addActionListener(this);
        panel.add(signupButton);

        backButton.setBounds(30,120,80,25);
        backButton.addActionListener(this);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String user = userField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean usernameAlreadyExists = false;
            for (int i = 0; i < Memory.allUsers.size(); i++){
                if (Memory.allUsers.get(i).getUsername().equals(user)){
                    usernameAlreadyExists = true;
                    break;
                }
            }
            if (usernameAlreadyExists){
                JOptionPane.showMessageDialog(this, "This username is already taken!");
            }
            else{
                if (user.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(this, "No field shall be empty");
                }
                else {
                    User newUser = new User(user,password);
                    Memory.allUsers.add(newUser);
                    new MainMenuPage(newUser);
                    dispose();
                }
            }

        } else if (e.getSource() == backButton) {
            new EntrancePage();
            dispose();
        }
    }
}