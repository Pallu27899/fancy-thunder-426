package Administatordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Exceptions.AdministratorException;
import Utility.Db;
//import exeptions.AccountantException;


public class adimpl implements adintr{

	@Override
	public boolean login(String name, String password) throws AdministratorException {
		
	try (Connection conn=Db.connect()){
			
			PreparedStatement pst =conn.prepareStatement("select * from Accountant where username=? and password=?" );
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

}
