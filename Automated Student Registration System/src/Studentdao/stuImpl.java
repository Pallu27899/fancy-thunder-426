package Studentdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.AdministratorException;
import Exceptions.StudentException;
import Utility.Db;

public class stuImpl implements StuIntr {

	@Override
	public String Signup(String name, String pass,String gender) throws StudentException {
		
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from student where name=? " );
			aaa.setString(1, name);

	     	ResultSet rs=aaa.executeQuery();
	     	if(rs.next()) {

	     		throw new StudentException("user name already taken please select any other name");
			
	     	}else {
	     		
	     		PreparedStatement pst =conn.prepareStatement("insert into Student(name,password,gender) values(?,?,?)" );
	    		pst.setString(1, name);
	    		pst.setString(2, pass);
	    		pst.setString(3, gender);
	    		
	    		int x=pst.executeUpdate();
	    		
	    		if(x>0) {
	    			return "signup successfull";
	    		}else {
	    			throw new StudentException("some error accured");
	    		}

	     	}
				
			} catch (SQLException e) {
				throw new StudentException(e.getMessage());
				// TODO: handle exception
			}
		
	}

	@Override
	public String update(String name) throws StudentException {
		
		
		try (Connection conn=Db.connect()){
	
			Scanner sc=new Scanner(System.in);
			System.out.println();
			System.out.println("please select a operation you want to perform");
			System.out.println("1 : update username");
			System.out.println("2 : update password");
			System.out.println("3 : update gender");
			System.out.println("4 : exit");
			int n=sc.nextInt();
			while (n!=4) {
				
				if(n==1) {
					
					System.out.println("enter new name");
					String nname=sc.next();
					
					PreparedStatement aaa =conn.prepareStatement("select * from student where name=? " );
					aaa.setString(1, nname);

			     	ResultSet rs=aaa.executeQuery();
			     	if(rs.next()) {

			     		throw new StudentException("Cant update:user name already taken please select any other name");
					
			     	}else {
			     		
			     		PreparedStatement pst =conn.prepareStatement("update student set name=? where name=?" );
			    		pst.setString(1, nname);
			    		pst.setString(2, name);
			    		
			    		int x=pst.executeUpdate();
			    		
			    		if(x>0) {
			    			return "student name update successfull";
			    		}else {
			    			throw new StudentException("some error accured");
			    		}

			     	}
		
				}else if(n==2) {
					
					System.out.println("enter new password");
					String npass=sc.next();
					
			  	
			     		PreparedStatement pst =conn.prepareStatement("update student set password=? where name=?" );
			    		pst.setString(1, npass);
			    		pst.setString(2, name);
			    		
			    		int x=pst.executeUpdate();
			    		
			    		if(x>0) {
			    			return "password updated successfully";
			    		}else {
			    			throw new StudentException("some error accured");
			    		}				
				}else if(n==3) {
				
					  System.out.println("enter new gender value M/F/O");
					  String gen=sc.next();
					
			     		PreparedStatement pst =conn.prepareStatement("update student set gender=? where name=?" );
			    		pst.setString(1, gen);
			    		pst.setString(2, name);
			    		
			    		int x=pst.executeUpdate();
			    		
			    		if(x>0) {
			    			return "password updated successfully";
			    		}else {
			    			throw new StudentException("some error accured");
			    		}
					
				}
				else {
					
					System.out.println("please select a valid option");
					System.out.println();
					System.out.println("please select a operation you want to perform");
					System.out.println("1 : update username");
					System.out.println("2 : update password");
					System.out.println("3 : update gender");
					System.out.println("4 : exit");
					 n=sc.nextInt();
				}
	
			}
			
			
				
			} catch (SQLException e) {
				throw new StudentException(e.getMessage());
				// TODO: handle exception
			}
		return name;
		

		
	}

	@Override
	public boolean login(String name, String pass) throws StudentException {
try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from student where name=? and password=? " );
			aaa.setString(1, name);
			aaa.setString(2, pass);

	     	ResultSet rs=aaa.executeQuery();
	     	if(rs.next()) {
               
	     		return true;
			
	     	}else {
	     		
	     		return false;
//	     		throw new StudentException("user name already taken please select any other name");
	     		

	     	}
				
			} catch (SQLException e) {
				throw new StudentException(e.getMessage());
				// TODO: handle exception
			}
	
	}

	
	
	@Override
	public ArrayList<String> allC() throws StudentException {
		
		ArrayList<String> al2=new ArrayList<>();
		
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement(" select cid,coursename,duration_days,fees,sum(seats) from course inner join batch where cn2=coursename group by coursenAme" );

	     	ResultSet rs=aaa.executeQuery();
	     	
	     	boolean flag=true;
	     	while(rs.next()) {
           flag=false;
			
           al2.add("course id : " +rs.getInt("cid")+" | "+" coursename : "+rs.getString("Coursename")+" | "+" Total Fee : "+rs.getInt("fees")+" | "+" Duration(days) : "+rs.getInt("duration_days")+" | "+" Total Seats : "+rs.getInt("sum(seats)"));
	 		
           
	     	}
	     	
	     	if(flag) {
	     		throw new StudentException("no data found");
	     		
	     	}
	     	else {
	     		return al2;     	     		
	     		
	     		

	     	}
				
			} catch (SQLException e) {
				throw new StudentException(e.getMessage());
				// TODO: handle exception
			}
	  	
		
		
		
	}

}
