/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author sagar koli
 */
public class variables {
    static String dbname="";
    static String url="jdbc:mysql://localhost:3306/";
    static String table="";
    static Connection c = null;
    static int cols=0;
    static ArrayList<String> arr=new ArrayList<>();
    static ArrayList<String> arr2=new ArrayList<>();
    static String query="CREATE TABLE "+table+"(id INTEGER not NULL, ";
    static Statement st;
    static int temp=0;
    static String dtype="";
    
     /*
        try {
                variables.c = DriverManager.getConnection(variables.url,"abc","abc");
                
            } catch (SQLException ex) {
                Logger.getLogger(new_popup.class.getName()).log(Level.SEVERE, null, ex);
            }
*/
}
