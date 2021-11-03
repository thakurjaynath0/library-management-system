/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

import Entities.Encap_Lms;
import Entities.EncapIssue;
import Entities.LoginEncap;
import Interf.Interf_Lms;
import Util.DbConnection;
import java.sql.ResultSet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jay
 */
public class Impl_Lms implements Interf_Lms {
    DbConnection db=new DbConnection();

    @Override
    public boolean register(Encap_Lms en) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.con.prepareStatement("insert into book_list values(?,?,?,?,?,?)");
            ps.setString(1, en.getId());
            ps.setString(2, en.getName());
            ps.setString(3, en.getAuthour());
            ps.setString(4, en.getFaculty());
            ps.setString(5, en.getDescription());
            ps.setInt(6, en.getTotal());
            int x=ps.executeUpdate();
            if(x>0)
            {
                temp=true;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return temp;

    }

 
    @Override
    public Encap_Lms search(String id) {
        Encap_Lms en=null;
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from book_list where id=?");
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                en=new Encap_Lms(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getInt(6));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return en;
    }

   

    @Override
    public boolean updateTotal(int total, String id) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.con.prepareStatement("update book_list set total_number=? where id=? ");
            ps.setInt(1, total);
            ps.setString(2, id);
            int x=ps.executeUpdate();
            if(x>0)
            {
                temp=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
        
    }

    @Override
    public Encap_Lms check(String id) {
        Encap_Lms en=null;
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from book_list where id=?");
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                en=new Encap_Lms(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return en;
    }

    @Override
    public boolean checkStatus(int stid, String status) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from issue_book where studentid=? and status=?");
            ps.setInt(1, stid);
            ps.setString(2, status);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                temp=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public boolean issuebook(EncapIssue is) {
        boolean temp=false;
        try {
            PreparedStatement ps=db.con.prepareStatement("insert into issue_book values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, is.getStid());
            ps.setString(2, is.getName());
            ps.setString(3, is.getAddress());
            ps.setString(4, is.getFaculty());
            ps.setString(5, is.getGender());
            ps.setString(6, is.getPhone());
            ps.setString(7, is.getBookid());
            ps.setString(8, is.getBookname());
            ps.setString(9, is.getIssuedate());
            ps.setString(10, is.getReturndate());
            ps.setString(11, is.getStatus());
            int i=ps.executeUpdate();
            if(i>0){
                temp=true;
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return temp;
    }

    @Override
    public EncapIssue get(int id, String status) {
       EncapIssue ei=null;
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from issue_book where studentid=? and status=?");
            ps.setInt(1, id);
            ps.setString(2, status);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                ei=new EncapIssue(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return ei;
    }

    @Override
    public boolean updateIssue(int id, String date, String status) {
        boolean temp=false;
        try {
         PreparedStatement ps=db.con.prepareStatement("update issue_book set returndate=?,status=? where studentid=?");
         ps.setString(1, date);
         ps.setString(2, status);
         ps.setInt(3, id);
         int i=ps.executeUpdate();
         if(i>0){
             temp=true;
         }
        } catch (Exception e) {
        }
        return temp;
    }

    @Override
    public List<Encap_Lms> getAll() {
        List<Encap_Lms> li=new ArrayList<>();
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from book_list");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                li.add(new Encap_Lms(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return li;
    }

    @Override
    public List<EncapIssue> IssuegetAll() {
        List<EncapIssue> list= new ArrayList<>();
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from issue_book");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(new EncapIssue(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
        
    }

    @Override
    public LoginEncap login(String username) {
        LoginEncap en=null;
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from admin where username=?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                en=new LoginEncap(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return en;
    }

    @Override
    public LoginEncap getById(String username, String password) {
         LoginEncap en=null;
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from admin where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                PreparedStatement pst=db.con.prepareStatement("select * from userdetail where id=?");
                pst.setInt(1, rs.getInt(1));
                ResultSet rst=pst.executeQuery();
                if(rst.next())
                {
                    en=new LoginEncap(rst.getInt(1), rst.getString(2),  rst.getString(3),  rst.getString(4),  rst.getString(5),  rs.getString(1),  rs.getString(2), rst.getString(6), rst.getString(7));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return en;
    }

    @Override
    public boolean registerLog(LoginEncap ln) {
        
        boolean regis=false;
        try {
            PreparedStatement ps=db.con.prepareStatement("insert into userdetail values(null,?,?,?,?,?,?)");
            ps.setString(1,ln.getName());
            ps.setString(2,ln.getAddress());
            ps.setString(3,ln.getPhone());
            ps.setString(4,ln.getEmail());
            ps.setString(5,ln.getGender());
            ps.setString(6,ln.getFaculty());
            int x=ps.executeUpdate();
            if(x>0)
            {
                PreparedStatement pst=db.con.prepareStatement("insert into admin values(null,?,?)");
                pst.setString(1,ln.getUsername());
                pst.setString(2,ln.getPassword());
                int y=pst.executeUpdate();
                if(y>0)
                {
                    regis=true;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return regis;
    }

    @Override
    public List<LoginEncap> RegistergetAll() {
        List<LoginEncap> list=new ArrayList<>();
        try {
            PreparedStatement ps=db.con.prepareStatement("select * from userdetail");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            list.add(new LoginEncap(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
}

