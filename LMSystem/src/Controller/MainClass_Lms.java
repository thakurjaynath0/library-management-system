/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Encap_Lms;
import Impl.Impl_Lms;
import Interf.Interf_Lms;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jay
 */
public class MainClass_Lms extends JPanel implements ActionListener {

    Interf_Lms av = new Impl_Lms();
    JLabel id, name, authour, faculty, description, total;
    JTextField nametxt;
    JTextField authourtxt;
    JTextField idtxt;
    JTextField descriptxt;
    JTextField totaltxt;
    JComboBox facultytxt;
    JButton register;

    public MainClass_Lms() {
        id = new JLabel("Book Id:");
        name = new JLabel("Book Name:");
        authour = new JLabel("Book's Authour:");
        faculty = new JLabel("Faculty:");
        description = new JLabel("Description Of Book:");
        total = new JLabel("No. of Books:");
        idtxt = new JTextField();
        nametxt = new JTextField();
        authourtxt = new JTextField();
        descriptxt = new JTextField();
        totaltxt = new JTextField();
        String aa[] = {"SELECT", "PHYSICS", "CHEMISTRY", "BIOLOGY", "MATHEMATICS", "ENGLISH", "COMPUTER SCIENCE"};
        facultytxt = new JComboBox(aa);
        register = new JButton("Submit");

        setLayout(null);
        setSize(500, 500);
        setVisible(true);

        id.setBounds(30, 30, 120, 30);
        add(id);
        idtxt.setBounds(160, 30, 120, 30);
        add(idtxt);

        name.setBounds(30, 70, 120, 30);
        add(name);

        nametxt.setBounds(160, 70, 120, 30);
        add(nametxt);

        authour.setBounds(30, 110, 120, 30);
        add(authour);

        authourtxt.setBounds(160, 110, 120, 30);
        add(authourtxt);

        faculty.setBounds(30, 240, 120, 30);
        add(faculty);

        facultytxt.setBounds(160, 240, 120, 30);
        add(facultytxt);

        description.setBounds(30, 150, 120, 30);
        add(description);

        descriptxt.setBounds(160, 150, 120, 80);
        add(descriptxt);

        total.setBounds(30, 280, 120, 30);
        add(total);

        totaltxt.setBounds(160, 280, 120, 30);
        add(totaltxt);

        register.setBounds(30, 320, 100, 30);
        add(register);
        register.addActionListener(this);

    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            String id = idtxt.getText();
            String name = nametxt.getText();
            String authour = authourtxt.getText();
            String description = descriptxt.getText();
            String faculty = facultytxt.getSelectedItem().toString();
            int total = Integer.parseInt(totaltxt.getText());
            Encap_Lms enn = av.search(id);
            Encap_Lms en = new Encap_Lms(id, name, authour, faculty, description, total);
            if (enn != null) {

               if(av.updateTotal(enn.getTotal()+total, id)){
                JOptionPane.showMessageDialog(null, "Successfully Updated.");
               }
               else{
                                   
                JOptionPane.showMessageDialog(null, "Update Failed.");

               }

            } else {
                      
                if (av.register(en)) {

                    JOptionPane.showMessageDialog(null, "Registeration Successfull");
                } else {
                    JOptionPane.showMessageDialog(null, "Registeration Failed");

                }
            }
                
        }

    }
}
