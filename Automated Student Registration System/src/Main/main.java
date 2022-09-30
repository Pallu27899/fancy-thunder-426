package Main;
import Administatordao.*;
import Exceptions.AdministratorException;
import Exceptions.StudentException;
import Studentdao.stuImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
		public static void main(String[] args) {	
		

	 System.out.println("welcome to automatic Student registration System");
		System.out.println("please select an option to  continue");
		System.out.println("1 : login as a Administrator");
		System.out.println("2 : login as a Student");
		System.out.println("3 : signup as a student");
		adimpl ad1=new adimpl();
		stuImpl st1 =new stuImpl();
		Scanner sc=new Scanner(System.in);
     int choice= sc.nextInt();
		if(choice==1) {
			
			System.out.println("enter administrator name");
			String name=sc.next();
			System.out.println("enter password");
			String pass=sc.next();
			try {
				boolean ans=ad1.login(name, pass);
				if(ans) {
					
//					System.out.println("i am in");
					System.out.println("welcome YOu are now in adminsitrator database");
					System.out.println("please select an option according to the operation you want to perform");
					System.out.println("1 : add a new course");
					System.out.println("2 : update fees of course");
					System.out.println("3 : delete a course from any training session");
					System.out.println("4 : Search information about a course.");
					System.out.println("5 : Create Batch under a course");
					System.out.println("6 : Allocate students in a Batch under a course.");
					System.out.println("7 : Update total seats of a batch.");
					System.out.println("8 : View the students of every batch. ");
					System.out.println("9 : Exit");
					
					int adc= sc.nextInt();
					
					
						
					
					
					
              while (adc!=9) {
            	  try {
					if(adc==1) {
						System.out.println("enter course name");
						String ncn=sc.next();
						System.out.println("enter fees structure for whole course");
						int fee=sc.nextInt();
//						System.out.println("enter total number of seats");
//						int seats=sc.nextInt();
						System.out.println("enter course duration (days)");
						int dur=sc.nextInt();
						
						String str=ad1.addCourse(ncn, fee, dur);
						System.out.println(str);

					}else if(adc==2) {
						System.out.println("enter course name");
						String ncn=sc.next();
						System.out.println("enter updated  fee of course");
						int fee=sc.nextInt();
						String str=ad1.feeupdate(ncn, fee);
						System.out.println(str);
						
					}
					else if(adc==3) {
						System.out.println("enter course name");
						String ncn=sc.next();
						System.out.println("enter batch Number");
						int bn=sc.nextInt();
						String str=ad1.delb(ncn, bn);
						System.out.println(str);
					}
					else if(adc==4) {
						System.out.println("enter course name");
						String ncn=sc.next();
						String str=ad1.cinfo(ncn);
						System.out.println(str);
					}
					else if(adc==5) {
						System.out.println("enter course name");
						String ncn=sc.next();
						System.out.println("enter Number of seats");
						int bn=sc.nextInt();
						String str=ad1.cb(ncn, bn);
						System.out.println(str);
					}else if(adc==6) {
						System.out.println("enter Student name");
						String ncn=sc.next();
						System.out.println("enter Course name");
						String cnc=sc.next();
						String str=ad1.sa(ncn,cnc);
						System.out.println(str);
					}
					else if(adc==7) {
						System.out.println("enter Batch Number");
						int bn=sc.nextInt();
						System.out.println("enter new Number of seats");
						int seats=sc.nextInt();
						String str=ad1.us(bn, seats);
						System.out.println(str);
					}else if(adc==8) {
						
						ArrayList<String> al1= ad1.allD();
						
						for(String i:al1) {
							System.out.println(i);
						}
					}
					else {
						System.out.println("please select a valid option");
					}
					System.out.println();
			
					System.out.println("please select an option according to the operation you want to perform");
					System.out.println("1 : add a new course");
					System.out.println("2 : update fees of course");
					System.out.println("3 : delete a course from any training session");
					System.out.println("4 : Search information about a course.");
					System.out.println("5 : Create Batch under a course");
					System.out.println("6 : Allocate students in a Batch under a course.");
					System.out.println("7 : Update total seats of a batch.");
					System.out.println("8 : View the students of every batch. ");
					System.out.println("9 : Exit");
					
					
				    adc= sc.nextInt();	
				    
            	  } catch (AdministratorException e) {
            		  System.out.println( e.getMessage());
            		 ;
            		  System.out.println("please select an option according to the operation you want to perform");
  					System.out.println("1 : add a new course");
  					System.out.println("2 : update fees of course");
  					System.out.println("3 : delete a course from any training session");
  					System.out.println("4 : Search information about a course.");
  					System.out.println("5 : Create Batch under a course");
  					System.out.println("6 : Allocate students in a Batch under a course.");
  					System.out.println("7 : Update total seats of a batch.");
  					System.out.println("8 : View the students of every batch. ");
  					System.out.println("9 : Exit");
					
  					
  				    adc= sc.nextInt();	
						// TODO: handle exception
					}
				}
              System.out.println("thanks for visiting");
				}else {
					System.out.println("incorrect username or password");
				}
			
			} catch (AdministratorException e) {
				
			System.out.println(e.getMessage());	
			
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
     
			
			
			
        }
		
		///////////////////////////////////////////////////////////////////
		else if(choice ==2) {
			System.out.println("enter username");
			String urn=sc.next();
			System.out.println("enter password");
			String pwd=sc.next();
			
			try {
				boolean str=st1.login(urn, pwd);
				
				if(str) {
					System.out.println();
					System.out.println("please select a operation you want to perform");
					System.out.println("1 : update credentials");
					System.out.println("2 : see all available course list and their seat availability.");
					System.out.println("3 : exit");
					int num=sc.nextInt();
					
					while(num !=3) {
						
						if(num==1) {
							
							String sl=st1.update(urn);
//							System.out.println(sl);
							System.out.println(sl);
						}
						else if(num==2){
						
							ArrayList<String> la1=st1.allC();
							for(String i:la1) {
								System.out.println(i);
							}
							
						}
							else {
						System.out.println("please select a valid option");	
						
						}
						System.out.println();
						System.out.println("please select a operation you want to perform");
						System.out.println("1 : update credentials");
						System.out.println("2 : see all available course list and their seat availability.");
						System.out.println("3 : exit");
						 num=sc.nextInt();
						
						
					}
					
					
				}else {
					System.out.println("incorrect username or password ");
				}
				
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
					//			String str=st1.update(name);
			
			
			
         }
		
		/////////////////////////////////////////////////////////////
		else if(choice ==3) {
			
			System.out.println("enter username ");
			String un=sc.next();
			System.out.println("create password");
			String cp=sc.next();
			System.out.println("Enter Student Gender M/F/O");
			String gen=sc.next();
			try {
				
				String str=st1.Signup(un, cp,gen);
				System.out.println(str);
				
			} catch (StudentException e) {
				// TODO Auto-generated catch block
			  System.out.println(e.getMessage());
			}
			
			
        }
		else{
			System.out.println("please select a valid option");
		}
		
		// TODO Auto-generated constructor stub
	}
	
}
