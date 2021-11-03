/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interf;

import Entities.Encap_Lms;
import Entities.EncapIssue;
import Entities.LoginEncap;
import java.util.List;

/**
 *
 * @author Jay
 */
public interface Interf_Lms {
    boolean register(Encap_Lms en);
    public Encap_Lms search(String id);
    public boolean updateTotal(int total,String id);
    public Encap_Lms check(String id);
    boolean checkStatus(int stid,String status);
    boolean issuebook(EncapIssue is);
    public EncapIssue get(int id,String status);
    boolean updateIssue(int id,String date,String status);
    List<Encap_Lms> getAll();
    List<EncapIssue> IssuegetAll();
    public LoginEncap login(String username);
    public LoginEncap getById(String username, String password);
    public boolean registerLog(LoginEncap ln);
    List<LoginEncap> RegistergetAll();
    
}
