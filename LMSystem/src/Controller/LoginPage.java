/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Jay
 */
import Entities.LoginEncap;
import Impl.Impl_Lms;
import Interf.Interf_Lms;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    JLabel username, password;
    JTextField usernametxt;
    JPasswordField passwordtxt;
    JButton login;
    JButton register;
    Interf_Lms dc = new Impl_Lms();

    public LoginPage() {
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        usernametxt = new JTextField();
        passwordtxt = new JPasswordField();
        login = new JButton("Login");
        register = new JButton("New User? Register here");

        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        username.setBounds(30, 30, 80, 30);
        add(username);
        usernametxt.setBounds(110, 30, 100, 30);
        add(usernametxt);
        password.setBounds(30, 70, 80, 30);
        add(password);
        passwordtxt.setBounds(110, 70, 100, 30);
        add(passwordtxt);
        login.setBounds(30, 130, 80, 30);
        add(login);
        login.addActionListener(this);
        register.setBounds(30, 170, 140, 30);
        add(register);
        register.addActionListener(this);

    }

    public static void main(String[] args) {
        new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String username = usernametxt.getText();
            String password = passwordtxt.getText();
            LoginEncap en = dc.login(username);
            if (en == null) {
                JOptionPane.showMessageDialog(null, username + "not found.");
            } else {
                LoginEncap enn = dc.getById(username, password);
                if (enn != null) {
                    JOptionPane.showMessageDialog(null, "Welcome to home page ");
                    new Call();
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed.");
                }
            }

        }

        if (e.getSource() == register) {
            new Register();
            dispose();
        }
    }

}
