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
import Entities.Encap_Lms;
import Impl.Impl_Lms;
import Interf.Interf_Lms;
import javax.swing.*;
import java.awt.event.*;
public class return_book extends JPanel implements ActionListener{
JLabel name, address, faculty, gender, phone, bookid, bookname,idate;
    JTextField idtxt;
    JTextField nametxt;
    JTextField addresstxt;
    JComboBox facultytxt;
    JRadioButton male, female, others;
    JTextField phonetxt;
    JTextField bookidtxt;
    JTextField booknametxt,txtdate;
    
    JButton ret,search;
    ButtonGroup bu;
    Interf_Lms av = new Impl_Lms();
    
    
    public return_book(){
    
    
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
        idate=new JLabel("Issue Date:");
        txtdate=new JTextField();
        String fac[] = {"SELECT", "PHYSICS", "CHEMISTRY", "BIOLOGY", "MATHEMATICS", "ENGLISH", "COMPUTER SCIENCE"};
        facultytxt = new JComboBox(fac);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");
        bu = new ButtonGroup();
        ret = new JButton("Return Book");
        search = new JButton("search");
        
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        
        
        idtxt.setBounds(60,20,130,30);
        add(idtxt);
        search.setBounds(200,20,100,30); 
        add(search);
        search.addActionListener(this);
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
        idate.setBounds(30,350,100,30);
        txtdate.setBounds(140,350,100,30);
        add(idate);
        add(txtdate);
        ret.setBounds(30, 390, 100, 30);
        add(ret);
        ret.addActionListener(this);
        
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            int id=Integer.parseInt(idtxt.getText());
            EncapIssue aa=av.get(id, "Not Returned");
            if(aa!=null){
            nametxt.setText(aa.getName());
            addresstxt.setText(aa.getAddress());
            facultytxt.setSelectedItem(aa.getFaculty());
            if(aa.getGender().equals("male")){
                male.setSelected(true);
            }
            else if(aa.getGender().equals("female")){
                female.setSelected(true);
            }
            else if(aa.getGender().equals("others")){
                others.setSelected(true);
        }
            phonetxt.setText(aa.getPhone());
            bookidtxt.setText(aa.getBookid());
            booknametxt.setText(aa.getBookname());
            txtdate.setText(aa.getIssuedate());
    }
            else{
                JOptionPane.showMessageDialog(null, "No date found for ID "+id);
            }
        }
        
        
        if(e.getSource()==ret){
            java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
             int id=Integer.parseInt(idtxt.getText());
             if(av.updateIssue(id, date+"", "Returned")){
                 String bookid=bookidtxt.getText();
                 Encap_Lms el=av.search(bookid);
                 int total=el.getTotal()+1;
                 if(av.updateTotal(total, bookid)){
                     JOptionPane.showMessageDialog(null, "book returned Successfully");
                 }
             }
             else{
                 JOptionPane.showMessageDialog(null, "book returned failed");
             }

        }
        
    
}

}
