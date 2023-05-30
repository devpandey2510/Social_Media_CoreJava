package com.facebook.dao;
import com.facebook.entity.FacebookUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FacebookDao {
   public int createProfileDao(FacebookUser fb)throws Exception {
	   
		//jdbc java database connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","Dev");
		PreparedStatement ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
		ps.setString(1, fb.getName());
		ps.setString(2,fb.getPassword());
		ps.setString(3, fb.getEmail());
		ps.setString(4, fb.getAddress());
		
		int i=ps.executeUpdate();
		return i;
   }
   
   public FacebookUser viewprofileDao(FacebookUser fb)throws Exception{
	   FacebookUser fu=null;
	   
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
	   PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=?");
	   ps.setString(1, fb.getEmail());
	   ResultSet res =ps.executeQuery();
	   
	   if(res.next()) {
		    fu = new FacebookUser();
		    String n = res.getString(1);
		    String p = res.getString(2);
		    String e = res.getString(3);
		    String a = res.getString(4);
		    
		    fu.setName(n);
		    fu.setPassword(p);
		    fu.setEmail(e);
		    fu.setAddress(a);
		    		
	   }
	   
	   return fu;
   }
   
   public int deleteprofileDao(FacebookUser fb)throws Exception{
	   
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
	   PreparedStatement ps=con.prepareStatement("delete from facebookuser where email=?");
	   ps.setString(1, fb.getEmail());
	   int i=ps.executeUpdate();
		return i;
   }

public FacebookUser[] viewAllprofileDao()throws Exception {
	// TODO Auto-generated method stub
	FacebookUser fu[]= new FacebookUser[10];
	   
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
	   PreparedStatement ps=con.prepareStatement("select * from facebookuser");
	   //ps.setString(1, fb.getEmail());
	   ResultSet res =ps.executeQuery();
	   int i=0;
	   while(res.next()) {
		    String n = res.getString(1);
		    String p = res.getString(2);
		    String e = res.getString(3);
		    String a = res.getString(4);
		    
		    fu[i].setName(n);
		    fu[i].setPassword(p);
		    fu[i].setEmail(e);
		    fu[i].setAddress(a);
		    i++;
		        		
	   }
	   return fu;
}

public int editprofileDao(FacebookUser fb1)throws Exception {
	//jdbc java database connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","Dev");
			PreparedStatement ps=con.prepareStatement("update facebookuser set name=?,password=?,address=? where email=?");
			ps.setString(1, fb1.getName());
			ps.setString(2,fb1.getPassword());
			ps.setString(4, fb1.getEmail());
			ps.setString(3, fb1.getAddress());
			
			int i=ps.executeUpdate();
			return i;
}

public FacebookUser loginprofileDao(FacebookUser fb)throws Exception {
	FacebookUser fu=null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
	//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","Dev");
	PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? and password=?");
	ps.setString(1, fb.getEmail());
	ps.setString(2,fb.getPassword());
	
	ResultSet res = ps.executeQuery();
	
	if(res.next()) {
		fu = new FacebookUser();
		
		String n = res.getString(1);
		String p = res.getString(2);
		String e = res.getString(3);
		String a = res.getString(4);
		
		fu.setName(n);
		fu.setPassword(p);
		fu.setEmail(e);
		fu.setAddress(a);
	}
	return fu;
}

public ArrayList<FacebookUser> viewallprofileDao()throws Exception {
	ArrayList<FacebookUser> fl = new ArrayList<FacebookUser>();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
	//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","Dev");
	PreparedStatement ps=con.prepareStatement("select * from facebookuser");
	ResultSet res = ps.executeQuery();
	
	while(res.next()) {
		FacebookUser fu = new FacebookUser();
		String n = res.getString(1);
		String p = res.getString(2);
		String e = res.getString(3);
		String a = res.getString(4);
		
		fu.setName(n);
		fu.setPassword(p);
		fu.setEmail(e);
		fu.setAddress(a);
		
		fl.add(fu);
	}
	
	return fl;
}

public ArrayList<FacebookUser> searchprofileDao(FacebookUser fb)throws Exception {
	
	ArrayList<FacebookUser> fl = new ArrayList<FacebookUser>();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dev");
	//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","Dev");
	PreparedStatement ps=con.prepareStatement("select * from facebookuser where name=?");
	ps.setString(1,fb.getName());
	ResultSet res = ps.executeQuery();
	
	while(res.next()) {
		FacebookUser fu = new FacebookUser();
		String n = res.getString(1);
		String p = res.getString(2);
		String e = res.getString(3);
		String a = res.getString(4);
		
		fu.setName(n);
		fu.setPassword(p);
		fu.setEmail(e);
		fu.setAddress(a);
		
		fl.add(fu);
	}
	
	return fl;
}
   
}
