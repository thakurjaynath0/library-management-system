/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Jay
 */
import javax.swing.*;
public class logout extends JPanel implements ActionListener {
    JButton log;
    
    public logout(){
        log=new JButton("Logout");
        
        
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        
        log.setBounds(10, 10, 80, 30);
        add(log); 
        log.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==log)
        {
            new LoginPage();
            Component comp = SwingUtilities.getRoot(this);
            ((Window) comp).dispose();
        }
    }
  
}
