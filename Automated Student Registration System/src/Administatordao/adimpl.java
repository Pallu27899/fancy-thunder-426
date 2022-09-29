package Administatordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.AdministratorException;
import Utility.Db;
//import exeptions.AccountantException;


public class adimpl implements adintr{

	@Override
	public boolean login(String name, String password) throws AdministratorException {
		
	try (Connection conn=Db.connect()){
			
			PreparedStatement pst =conn.prepareStatement("select * from Administrator where username=? and password=?" );
			pst.setString(1, name);
			pst.setString(2, password);
			
			ResultSet rs=pst.executeQuery();
//			System.out.println(rs);
			if(rs.next()) {
//				System.out.println("hii");
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			throw new AdministratorException(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public String addCourse(String name,int fee,int dur) throws AdministratorException {
		// TODO Auto-generated method stub
		
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from course where coursename=? " );
			aaa.setString(1, name);

	     	ResultSet rs=aaa.executeQuery();
	     	if(rs.next()) {
//			System.out.println("hii");
	     		throw new AdministratorException("course already available");
			
	     	}else {
	     		
	     		PreparedStatement pst =conn.prepareStatement("insert into course(Coursename,fees,duration_days) values(?,?,?)" );
	    		pst.setString(1, name);
	    		pst.setInt(2, fee);
//	    		pst.setInt(3, seats);
	    		pst.setInt(3, dur);
	    		
	    		int x=pst.executeUpdate();
	    		
	    		if(x>0) {
	    			return "course insertion successfull";
	    		}else {
	    			throw new AdministratorException("some error accured");
	    		}
//			return false;
	     	}
				
				

				
			} catch (Exception e) {
				throw new AdministratorException(e.getMessage());
				// TODO: handle exception
			}
		
		
	}

	@Override
	public String feeupdate(String name, int nfee) throws AdministratorException {
		
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from course where coursename=? " );
			aaa.setString(1, name);
	
		 	ResultSet rs=aaa.executeQuery();
		 	if(rs.next()) {
		 		PreparedStatement pst =conn.prepareStatement("update course set fees=? where coursename=?" );
				pst.setInt(1, nfee);
				pst.setString(2, name);

				
				int x=pst.executeUpdate();
				
				if(x>0) {
					return "course fee upadated successfully";
				}else {
					throw new AdministratorException("some error accured");
				}	
		 	}else {
		 		
		 		throw new AdministratorException("no user found with this username");
		 		
		 	}			
				} catch (Exception e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}
		
	}

	@Override
	public String delb(String name, int batchNumber) throws AdministratorException {
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from course where coursename=? " );
			aaa.setString(1, name);
	
		 	ResultSet rs=aaa.executeQuery();
		 	if(rs.next()) {
		 		PreparedStatement sb =conn.prepareStatement(" delete from student_batch where bno2=?;" );
				sb.setInt(1, batchNumber);
//				sb.setString(2, name);
				
				int y=sb.executeUpdate();
		 		
		 		PreparedStatement pst =conn.prepareStatement("delete from batch where bno=? and cn2=?" );
				pst.setInt(1, batchNumber);
				pst.setString(2, name);
				
				int x=pst.executeUpdate();
				
				if(x>0) {
					return "course of that training session deleted successully";
				}else {
					throw new AdministratorException("some error accured");
				}	
		 	}else {
		 		
		 		throw new AdministratorException("no user found with this username");
		 		
		 	}			
				} catch (Exception e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}	
		
	
	
	}

	@Override
	public String cinfo(String name) throws AdministratorException {
		// TODO Auto-generated method stub
	try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from course where coursename=? " );
			aaa.setString(1, name);
		    
		 	ResultSet rs=aaa.executeQuery();
		 	if(rs.next()) {
//		 		
		 		return"course id : " +rs.getInt("cid")+" | "+" coursename : "+rs.getString("Coursename")+" | "+" Total Fee : "+rs.getInt("fees")+" | "+" Duration(days) : "+rs.getInt("duration_days");
		 		
		 	}else {
		 		
		 		throw new AdministratorException("no Course found with this Coursename");
		 		
		 	}			
				} catch (SQLException e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}	
	}

	@Override
	public String cb(String name,int seats) throws AdministratorException {
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from course where coursename=? " );
			aaa.setString(1, name);
	
		 	ResultSet rs=aaa.executeQuery();
		 	if(rs.next()) {
		 		PreparedStatement pst =conn.prepareStatement("insert into batch(cn2,seats) values(?,?)" );
		 		pst.setString(1, name);
				pst.setInt(2, seats);

				
				int x=pst.executeUpdate();
				
				if(x>0) {
					return "new batch successfully created for "+name+"course";
				}else {
					throw new AdministratorException("some error accured");
				}	
		 	}else {
		 		
		 		throw new AdministratorException("cant make a batch for this course : course not available");
		 		
		 	}			
				} catch (Exception e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}
		

	}

	@Override
	public String us(int bn,int seats) throws AdministratorException {

		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from batch where bno=?");
			aaa.setInt(1, bn);
	        
		 	ResultSet rs=aaa.executeQuery();
		 	if(rs.next()) {
		 		PreparedStatement pst =conn.prepareStatement("update batch set seats=? where bno=? " );
		 		pst.setInt(1, seats);
				pst.setInt(2, bn);

				int x=pst.executeUpdate();
				
				if(x>0) {
					return "Seats successfully updated for Batch Number "+bn;
				}else {
					throw new AdministratorException("some error accured");
				}	
		 	}else {
		 		
		 		throw new AdministratorException("no batch available for batch NUmber "+bn);
		 		
		 	}			
				} catch (Exception e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}
		

		
	}

	@Override
	public ArrayList<String> allD() throws AdministratorException {
		try (Connection conn=Db.connect()){
			
			ArrayList<String> al1=new ArrayList<>();
			PreparedStatement aaa =conn.prepareStatement("select bno,seats,sid,name,coursename,duration_days,fees,cid from batch inner join student inner join Student_batch inner join course on bno=bno2 and sid=sid2 and cn2=coursename ");
              
			boolean flag=true;
		 	ResultSet rs=aaa.executeQuery();
		 	while(rs.next()) {
		 	flag=false;
		 	
		 	al1.add(" Student ID : "+rs.getInt("sid")+" | "+" Student Name : "+rs.getString("name")+" | "+"course id : " +rs.getInt("cid")+" | "+" coursename : "+rs.getString("Coursename")+" | "+" Total Fee : "+rs.getInt("fees")+" | "+" Duration(days) : "+rs.getInt("duration_days")+" | "+" Batch Number : "+rs.getInt("bno"));
	 		

		 	}
		 	if(flag) {
		 		throw new AdministratorException("no data found");
		 		
		 	}else {
		 		return al1;
		 	}
				} catch (Exception e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}
		
	
		
		
//		 	}

}

	@Override
	public String sa(String name, String Course) throws AdministratorException {
		
		
		try (Connection conn=Db.connect()){
			
			PreparedStatement aaa =conn.prepareStatement("select * from course inner join batch where cn2=Coursename and coursename=? " );
			aaa.setString(1, Course);
		 	ResultSet rs=aaa.executeQuery();
		 	
		 	if(rs.next()) {
		 		
		 		
		 		
//		 		System.out.println("h1");
		 		PreparedStatement aab =conn.prepareStatement("select * from student where name=? " );
				aab.setString(1, name);
			 	ResultSet rsa=aab.executeQuery();
			 	
			 	if(rsa.next()) {
//			 		System.out.println("h2");
			 		PreparedStatement aac =conn.prepareStatement("select * from Student_batch inner join batch where bno2=bno and sid2=? and cn2=? " );
					aac.setInt(1,rsa.getInt("sid") );
					aac.setString(2,rs.getString("Coursename"));
				 	ResultSet rsc=aac.executeQuery();
				 	
                   boolean flag=true;
                   
			 		while(rsc.next()) {
			 			flag=false;
			 	        break;
			 		}
			 		if(flag){
//			 		System.out.println("h3");
			 			PreparedStatement ins =conn.prepareStatement("insert into Student_batch values(?,?)" );
						ins.setInt(1,rsa.getInt("sid") );
						ins.setInt(2,rs.getInt("bno"));
			 			
						int x=ins.executeUpdate();
						if(x>0) {
							return "Student alocated to course successfully";
						}
						else {
							throw new AdministratorException("error accured ");	
						}
						
			 			
			 		}
			 		else {			 			
			 			throw new AdministratorException("Student "+name+" already enrolled in "+Course);
			 		}
			 			
			 		}
					
					
			 	else {
			 		
			 		throw new AdministratorException("No student found for name : "+name);
			 		
			 	}
		 		
				
				
		}else {
		 		
		 		throw new AdministratorException("No batch found for course name  : "+Course);
		 		
		 	}			
				} catch (Exception e) {
					throw new AdministratorException(e.getMessage());
					// TODO: handle exception
				}
		

	
	}}
	
