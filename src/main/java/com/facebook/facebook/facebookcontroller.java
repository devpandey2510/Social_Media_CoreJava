package com.facebook.facebook;
import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;

import java.util.ArrayList;
import java.util.Scanner;


public class facebookcontroller {
	
	public void createProfile()throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		System.out.println("enter email");
		String email=sc.next();
		System.out.println("enter address");
		String address=sc.next();
		
		//we cannot access data base directly so we have to make a service class which will
		//provide a channel of comminication b/w DAO and controller
		FacebookService fs = new FacebookService();
		//we can not send concrete data so we have to follow DTO design pattern(Data transfer object)
		// so will make object for that by making an entity class,usually on name of table storedin database
		//so will make FacebookUser class just to send and receive data in object form
		FacebookUser fb = new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		int i = fs.createprofileServices(fb);
		
		if(i>0) {
				System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}
	}

	
	public void viewProfile()throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email to view profile");
		String email = sc.next();
		
		FacebookUser fb =new FacebookUser();
		fb.setEmail(email);
		
		FacebookService fs = new FacebookService();
		FacebookUser fb1 = fs.viewprofileServices(fb);
		
		if(fb1!=null) {
			System.out.println("Name is "+fb1.getName());
			System.out.println("Password is "+fb1.getPassword());
			System.out.println("Email is "+fb1.getEmail());
			System.out.println("Address is "+fb1.getAddress());
		}
		else {
			System.out.println("profile not found");
		}
		
	}

	
	public void editProfile() throws Exception{
		//System.out.println("Enter the email of profile you want to edit");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email to view profile");
		String email = sc.next();
		
		FacebookUser fb =new FacebookUser();
		fb.setEmail(email);
		
		FacebookService fs = new FacebookService();
		FacebookUser fb1 = fs.viewprofileServices(fb);
		
		if(fb1!=null) {
			System.out.println("As per our record your old profile is :");
			System.out.println("Name is "+fb1.getName());
			System.out.println("Password is "+fb1.getPassword());
			System.out.println("Email is "+fb1.getEmail());
			System.out.println("Address is "+fb1.getAddress());
			
			
			System.out.println("Enter What you want to edit");
			System.out.println("1.name");
			System.out.println("2.password");
			System.out.println("3.address");
			
			int c=sc.nextInt();
			
			switch(c){
			case 1:
				System.out.println("Enter new name");
				String newname = sc.next();
				fb1.setName(newname);
				break;
			case 2:
				System.out.println("Enter new password");
				String newpass = sc.next();
				fb1.setPassword(newpass);
				break;
			case 3:
				System.out.println("Enter new address");
				String newadd = sc.next();
				fb1.setAddress(newadd);
				break;
				default:
					System.out.println("Wrong choice:");
					
			}
			
			FacebookService fs1 = new FacebookService();
			int i = fs1.editprofileService(fb1);
			
			if(i>0) {
				System.out.println("profile edited");
			}
			else {
				System.out.println("profile could not edited");
			}
		}
		else {
			System.out.println("profile not found");
		}
		
		
	}

	public void deleteProfile()throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email to delete profile");
		String email = sc.next();
		
		FacebookUser fb =new FacebookUser();
		fb.setEmail(email);
		
		FacebookService fs = new FacebookService();
		int i = fs.deleteprofileServices(fb);
		
		if(i>0) {
			System.out.println("profile deleted");
		}
		else {
			System.out.println("profile could not deleted");
		}
	}

	public void searchProfile()throws Exception {
		System.out.println("Enter name to search profile");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		FacebookUser fb = new FacebookUser();
		fb.setName(name);
		
		FacebookService fs = new FacebookService();
		ArrayList<FacebookUser> al =fs.searchprofileService(fb);
		
		System.out.println("Profile with this names are:" + al.size());
		 
		for(FacebookUser fb1:al) {
			System.out.println("Name:" + fb1.getName());
			System.out.println("Password:"+fb1.getPassword());
			System.out.println("Email:"+fb1.getEmail());
			System.out.println("Address:"+fb1.getAddress());
		}
		
	}

	public void viewAllProfile()throws Exception {
		FacebookService fs = new FacebookService();
		ArrayList<FacebookUser> al = fs.viewallprofileService();
		
		System.out.println("Number of profiles are:" + al.size());
		
		for(FacebookUser fb:al) {
			System.out.println("**************");
			System.out.println("Name:"+fb.getName());
			System.out.println("Password:"+fb.getPassword());
			System.out.println("Email:"+fb.getEmail());
			System.out.println("Address:"+fb.getAddress());
		}
		
	}

	public void loginProfile()throws Exception {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to login ");
		String email=sc.next();
		System.out.println("enter password to login");
		String password=sc.next();
		
		FacebookUser fb = new FacebookUser();
		fb.setEmail(email);
		fb.setPassword(password);
		
		FacebookService fs = new FacebookService();
		FacebookUser fb1 = fs.loginprofileService(fb);
		
		if(fb1!=null) {
			System.out.println("Welcome Mr/Mrs."+ fb1.getName());
		}
		else {
			System.out.println("could not login");
		}
	}
}
