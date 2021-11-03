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
import java.awt.event.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class Registered extends JPanel {
    JTable tab;
    DefaultTableModel model= new DefaultTableModel();
    JScrollPane jsp;
    Interf_Lms dc= new Impl_Lms();
    
    public Registered()
    {
        tab=new JTable(model);
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        jsp=new JScrollPane(tab,v,h);
        
        setLayout(null);
        setSize(700,700);
        setVisible(true);
        
        add(jsp).setBounds(20,29, 650, 600);
        model.addColumn("Student Name");
        model.addColumn("Address");
        model.addColumn("Faculty");
        model.addColumn("Gender");
        model.addColumn("Phone Number");
        model.addColumn("Email");
        
         List<LoginEncap> list=dc.RegistergetAll();
        for (LoginEncap obj : list) {
           model.addRow(new Object[]{obj.getName(),obj.getAddress(),obj.getFaculty(),obj.getGender(),obj.getPhone(),obj.getEmail()});
        }
    }
    
}
