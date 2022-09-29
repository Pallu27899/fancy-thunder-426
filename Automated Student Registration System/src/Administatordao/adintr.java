package Administatordao;

import java.util.ArrayList;

import Exceptions.AdministratorException;

public interface adintr {

	public boolean login(String name,String password)throws AdministratorException;
	
	public String addCourse(String name,int fee,int dur)throws AdministratorException;
	public String feeupdate(String name,int nfee)throws AdministratorException;
	public String delb(String name,int batchNumber)throws AdministratorException;
	public String cinfo(String name)throws AdministratorException;
	public String cb(String name,int seats)throws AdministratorException;
	public String us(int bn,int seats)throws AdministratorException;
	public ArrayList<String> allD()throws AdministratorException;
	public String sa(String name,String Course)throws AdministratorException;
}
