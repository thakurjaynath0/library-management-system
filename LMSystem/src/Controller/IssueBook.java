/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Encap_Lms;
import Entities.EncapIssue;
import Impl.Impl_Lms;
import Interf.Interf_Lms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Jay
 */
public class IssueBook extends JPanel implements ActionListener {

    JLabel id, name, address, faculty, gender, phone, bookid, bookname;
    JTextField idtxt;
    JTextField nametxt;
    JTextField addresstxt;
    JComboBox facultytxt;
    JRadioButton male, female, others;
    JTextField phonetxt;
    JTextField bookidtxt;
    JTextField booknametxt;
    JButton issue;
    ButtonGroup bu;
    Interf_Lms av= new Impl_Lms();

    public IssueBook() {
        id = new JLabel("Student Id:");
        name = new JLabel("Name:");
        address = new JLabel("Address:");
        faculty = new JLabel("Faculty");
        gender = new JLabel("Gender:");
        phone = new JLabel("Phone No:");
        bookid = new JLabel("Book Id:");
        bookname = new JLabel("Book Name:");
        idtxt = new JTextField();
        nametxt = new JTextField();
        addresstxt = new JTextField();
        phonetxt = new JTextField();
        bookidtxt = new JTextField();
        booknametxt = new JTextField();
        String fac[] = {"SELECT", "PHYSICS", "CHEMISTRY", "BIOLOGY", "MATHEMATICS", "ENGLISH", "COMPUTER SCIENCE"};
        facultytxt = new JComboBox(fac);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");
        bu = new ButtonGroup();
        issue = new JButton("Issue Book");

        setLayout(null);
        setSize(500, 500);
        setVisible(true);

        id.setBounds(30, 30, 100, 30);
        add(id);
        idtxt.setBounds(140, 30, 100, 30);
        add(idtxt);
        name.setBounds(30, 70, 100, 30);
        add(name);
        nametxt.setBounds(140, 70, 100, 30);
        add(nametxt);
        address.setBounds(30, 110, 100, 30);
        add(address);
        addresstxt.setBounds(140, 110, 100, 30);
        add(addresstxt);
        faculty.setBounds(30, 150, 100, 30);
        add(faculty);
        facultytxt.setBounds(140, 150, 100, 30);
        add(facultytxt);
        bu.add(male);
        bu.add(female);
        bu.add(others);
        gender.setBounds(30, 190, 100, 30);
        add(gender);
        male.setBounds(140, 190, 80, 30);
        add(male);
        female.setBounds(230, 190, 80, 30);
        add(female);
        others.setBounds(320, 190, 80, 30);
        add(others);
        phone.setBounds(30, 230, 100, 30);
        add(phone);
        phonetxt.setBounds(140, 230, 100, 30);
        add(phonetxt);
        bookid.setBounds(30, 270, 100, 30);
        add(bookid);
        bookidtxt.setBounds(140, 270, 100, 30);
        add(bookidtxt);
        bookname.setBounds(30, 310, 100, 30);
        add(bookname);
        booknametxt.setBounds(140, 310, 100, 30);
        add(booknametxt);
        issue.setBounds(30, 360, 100, 30);
        add(issue);
        issue.addActionListener(this);

    }
    
    public static void main(String[] args) {
        try {
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 

        } catch (Exception e) {
        }
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == issue) {
            int stid = Integer.parseInt(idtxt.getText());
            String name = nametxt.getText();
            String address = addresstxt.getText();
            String faculty = facultytxt.getSelectedItem().toString();
            String gender = null;
            if (male.isSelected()) {
                gender = "male";
            } else if (female.isSelected()) {
                gender = "female";
            } else if (others.isSelected()) {
                gender = "others";
            }
            String phone = phonetxt.getText();
            String bookid = bookidtxt.getText();
            String bookname = booknametxt.getText();
            java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
            
            Encap_Lms enn = av.check(bookid);
            EncapIssue en = new EncapIssue(stid, name, address, faculty, gender, phone, bookid, bookname, date + "", null, "Not Returned");
            if (enn != null) {
                if (enn.getTotal() >= 1) {
                    if (av.checkStatus(stid, "Not Returned")) {
                        JOptionPane.showMessageDialog(null, "Please return the previous book to issue new book.");

                    } else {
                        if (av.issuebook(en)) {
                            int total = enn.getTotal() - 1;
                            if (av.updateTotal(total, bookid)) {
                                JOptionPane.showMessageDialog(null, "Book issued successfully.");

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Fail issuing requested book.");

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient amount of the book requested.");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Requested book not available.");

            }

        }

    }

}
