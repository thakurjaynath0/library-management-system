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
import java.awt.Component;
import java.awt.Window;
import javax.swing.*;
public class Call extends JFrame{
    
   JTabbedPane jt;
   
   
   
   public Call(){
       jt=new JTabbedPane();
       jt.addTab("Add book", new MainClass_Lms());
       jt.addTab("Issue book", new IssueBook());
       jt.addTab("Return book", new return_book());
       jt.addTab("Regsitered Students", new Registered());
       jt.addTab("View Stock", new viewStock());
       jt.addTab("View Issue histroy", new IssueTable());
       jt.addTab("Logout", new logout());
       
       add(jt);
       setVisible(true);
       setSize(500,500);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("Library Management System");
   }
    
   
}
