package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntrancePage extends JFrame {
    public EntrancePage(){
        super("Super Mario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(820, 450);

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("EntrancePageBackground.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(null);
        CustomButton loginButton = new CustomButton("Login",300,25,200,100);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
        panel.add(loginButton);

        CustomButton signupButton = new CustomButton("Sign up", 20 , 275, 200, 100);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUpPage();
                dispose();
            }
        });
        panel.add(signupButton);

        CustomButton exitButton = new CustomButton("Exit", 580 , 275 , 200, 100);
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
