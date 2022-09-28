package Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbrun {

	
	public static void main(String[] args) {
		
		try(Connection conn=Db.connect()) {
	    
			System.out.println("running");
//			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
