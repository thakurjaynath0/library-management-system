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
import Entities.EncapIssue;
import Impl.Impl_Lms;
import Interf.Interf_Lms;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class IssueTable extends JPanel {
    JTable tab;
    DefaultTableModel model= new DefaultTableModel();
    JScrollPane jsp;
    Interf_Lms dc= new Impl_Lms();
    
    public IssueTable()
    {
        tab=new JTable(model);
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        jsp=new JScrollPane(tab,v,h);
        
        setLayout(null);
        setSize(1000,700);
        setVisible(true);
        
        add(jsp).setBounds(20,29, 950, 600);
        model.addColumn("Student Id");
        model.addColumn("Student Name");
        model.addColumn("Address");
        model.addColumn("Faculty");
        model.addColumn("Gender");
        model.addColumn("Phone Number");
        model.addColumn("Book Id");
        model.addColumn("Book name");
        model.addColumn("Issue Date");
        model.addColumn("Return Date");
        model.addColumn("Status");
        
        List<EncapIssue> list=dc.IssuegetAll();
        for (EncapIssue obj : list) {
            model.addRow(new Object[]{obj.getStid(),obj.getName(),obj.getAddress(),obj.getFaculty(),obj.getGender(),obj.getPhone(),obj.getBookid(),obj.getBookname(),obj.getIssuedate(),obj.getReturndate(),obj.getStatus()});
        }
            
        }
    
   

}
