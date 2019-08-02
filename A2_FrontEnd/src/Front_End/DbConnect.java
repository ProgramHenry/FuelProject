/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front_End;

import java.sql.*;


public class DbConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DbConnect(String typeofconnect){
        
        if (typeofconnect == "login"){
        
            try{
                Class.forName("com.mysql.jdba.Driver");
            
                con = DriverManager.getConnection("jdba:mysql://localhost:3306/users","jshenry","Jonathan1!");
                st = con.createStatement();
        
            }catch(Exception ex){
                System.out.println("Error: "+ex);
            }   
        }
        
        if (typeofconnect == "register"){
        
            try{
                Class.forName("com.mysql.jdba.Driver");
            
                con = DriverManager.getConnection("jdba:mysql://localhost:3306/qforms","jshenry","Jonathan1!");
                st = con.createStatement();
        
            }catch(Exception ex){
                System.out.println("Error: "+ex);
            }   
        }
        
    }
    
    public boolean userentry(String username, String password){
    
    return true;
    }
    
    public boolean dataentry(String username,String fullname,String A1,String A2, String City, String Zip){
        
        try{
            
            String query = "insert into qforms(username,name,address1,address2,city,zip)values(?,?,?,?,?,?)";
            
            System.out.println("Entering data into database");
            
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1,username);
            st.setString(3,fullname);
            st.setString(4, A1);
            st.setString(5, A2);
            st.setString(6, City);
            st.setString(7, Zip);
            return true;
            
        }catch(Exception e){
            return false;
        }
    
    }
    
    public boolean verifylogin(String username, String password){ // FIX the verification login function after we set up the database
        try{
            
            String query = "select * from users";
            rs = st.executeQuery(query);
            System.out.println("Record from Users Database");
            while(rs.next()){
                String uname = rs.getString("username");
                String pword = rs.getString("password");
                System.out.println("Username:"+uname+" Password:"+pword);
            }
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
}
        
    

