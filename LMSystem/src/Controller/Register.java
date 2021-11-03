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
public class Register extends JFrame implements ActionListener {
    Interf_Lms dc=new Impl_Lms();
   JLabel name,address,phone,email,username,password,confirm,gender,faculty;
   JTextField nametxt;
   JTextField addresstxt;
   JTextField phonetxt;
   JTextField emailtxt;
   JTextField usernametxt;
   JPasswordField passwordtxt;
   JPasswordField confirmtxt;
   JRadioButton male,female,others;
   JComboBox facultytxt;
   JButton register;
   ButtonGroup bu;

    
    public Register()
    {
        
    name=new JLabel("Name:");
    address=new JLabel("Address:");
    phone=new JLabel("Phone No:");
    email=new JLabel("Email:");
    username=new JLabel("Username:");
    password=new JLabel("Password:");
    confirm=new JLabel("Confirm Password");
    gender=new JLabel("Gender:");
    faculty=new JLabel("Faculty:");
    nametxt=new JTextField();
    addresstxt=new JTextField();
    phonetxt=new JTextField();
    emailtxt=new JTextField();
    usernametxt=new JTextField();
    passwordtxt=new JPasswordField();
    confirmtxt=new JPasswordField();
    bu=new ButtonGroup();
    male=new JRadioButton("Male");
    female=new JRadioButton("Female");
    others=new JRadioButton("Others");
    String ar[]={"SELECT", "PHYSICS", "CHEMISTRY", "BIOLOGY", "MATHEMATICS", "ENGLISH", "COMPUTER SCIENCE"};
    facultytxt=new JComboBox(ar);
    register=new JButton("Register");
    
    
   setLayout(null);
   setSize(500,500);
   setVisible(true);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
  
   
  
name.setBounds(30, 30, 110, 30);
add(name);
nametxt.setBounds(150, 30, 100, 30);
add(nametxt);
address.setBounds(30, 65, 110, 30);
add(address);
addresstxt.setBounds(150, 65, 100, 30);
add(addresstxt);
phone.setBounds(30, 100, 110, 30);
add(phone);
phonetxt.setBounds(150, 100, 100, 30);
add(phonetxt);
email.setBounds(30, 135, 110, 30);
add(email);
emailtxt.setBounds(150, 135, 100, 30);
add(emailtxt);
username.setBounds(30, 170, 110, 30);
add(username);
usernametxt.setBounds(150, 170, 100, 30);
add(usernametxt);
password.setBounds(30, 205, 110, 30);
add(password);
passwordtxt.setBounds(150, 205, 100, 30);
add(passwordtxt);
confirm.setBounds(30, 240, 110, 30);
add(confirm);
confirmtxt.setBounds(150, 240, 100, 30);
add(confirmtxt);
bu.add(male);
bu.add(female);
bu.add(others);
gender.setBounds(30, 275, 80, 30);
add(gender);
male.setBounds(110, 275, 80, 30);
add(male);
female.setBounds(200, 275, 80, 30);
add(female);
others.setBounds(290, 275, 80, 30);
add(others);
faculty.setBounds(30, 310, 110, 30);
add(faculty);
facultytxt.setBounds(150, 310, 100, 30);
add(facultytxt);
register.setBounds(30, 350, 100, 30);
add(register);
register.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==register)
        {
              String name=nametxt.getText();
       String address=addresstxt.getText();
       String phone=phonetxt.getText();
       String email=emailtxt.getText();
       String username=usernametxt.getText();
       String pass=passwordtxt.getText();
      
       String gender=null;
       if(male.isSelected())
       {
           gender="male";
       }
       else if(female.isSelected())
       {
           gender="female";
       }
       else if(others.isSelected())
       {
           gender="others";
       }
       
       String fac=facultytxt.getSelectedItem().toString();
       String confirm=confirmtxt.getText(); 
       if(pass.equals(confirm))
       {
           LoginEncap en= new LoginEncap(0, name, address, phone, email, username, pass, gender, fac);
       
           if(dc.registerLog(en))
         {
           
            JOptionPane.showMessageDialog(null,"Register success");  
            new LoginPage();
            dispose();
                    
         }
         else
         {
            JOptionPane.showMessageDialog(null,"Register failed");  

         }
         }
        else
       {
          
           JOptionPane.showMessageDialog(null, "Password Unmatched.");
       }
       
       }
      
        }
    }
    

    

