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
import Entities.Encap_Lms;
import Impl.Impl_Lms;
import Interf.Interf_Lms;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class viewStock extends JPanel {
  JTable tb;
  DefaultTableModel  model=new DefaultTableModel();
  JScrollPane jsp;
  Interf_Lms av= new Impl_Lms();
   public viewStock(){
       tb=new JTable(model);
       int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
       int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
       jsp=new JScrollPane(tb,v,h);
       setLayout(null);
       setSize(700,700);
       setVisible(true);
       
       add(jsp).setBounds(50,10,600,600);
       model.addColumn("Book Id");
       model.addColumn("Book Name");
       model.addColumn("Author");
       model.addColumn("Faculty");
       model.addColumn("Book Amount");
       
       
       
       List<Encap_Lms> list=av.getAll();
       for (Encap_Lms ob : list) {
       model.addRow(new Object[]{ob.getId(),ob.getName(),ob.getAuthour(),ob.getFaculty(),ob.getTotal()});
       }
   }
   
}
