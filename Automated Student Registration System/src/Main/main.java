package Main;

import Administatordao.*;
import Exceptions.AdministratorException;

import java.util.Scanner;

public class main {

	
		public static void main(String[] args) {
			
		
		
		
	 System.out.println("welcome to Automatic Student registration System");
		System.out.println("please select an option to  continue");
		System.out.println("1 : login as a Administrator");
		System.out.println("2 : login as a Student");
		System.out.println("3 : signup as a student");
		adimpl ad1=new adimpl();
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
					System.out.println("please select an option according to the operation you want to perform");
					System.out.println("1 : add a new course");
					System.out.println("2 : update fees of course");
					System.out.println("3 : delete a course from any training session");
					System.out.println("4 : Search information about a course.");
					System.out.println("5 : Create Batch under a course");
					System.out.println("6 : Allocate students in a Batch under a course.");
					System.out.println("7 : Update total seats of a batch.");
					System.out.println("7 : Update total seats of a batch.");
					System.out.println("8 : View the students of every batch. ");
					
					int adc= sc.nextInt();
					
					if(adc==1) {
						
					}
					
					
					
				}else {
					System.out.println("incorrect username or password");
				}
			} catch (AdministratorException e) {
				
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     
			
			
			
        }
		
		
		else if(choice ==2) {
			
			
			
         }
		else if(choice ==3) {
			
			
			
        }
		else{
			System.out.println("please select a valid option");
		}
		
		// TODO Auto-generated constructor stub
	}
	
}
