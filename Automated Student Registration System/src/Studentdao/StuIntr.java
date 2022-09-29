package Studentdao;

import java.util.ArrayList;

import Exceptions.StudentException;

public interface StuIntr {
    public boolean login(String name,String pass)throws StudentException ;
	public String Signup(String name,String pass,String gender)throws StudentException ;
	public String update(String name)throws StudentException ;
	public ArrayList<String> allC()throws StudentException;
	
	
}
