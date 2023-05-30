package com.facebook.facebook;
import java.util.Scanner;
import com.facebook.facebook.facebookcontroller;

public class App
{
    public static void main( String[] args ) throws Exception
    {
	String s="y";
		
		while(s.equals("y")) {
		System.out.println("*************************MAIN MENU*****************************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to edit profile");
		System.out.println("press 4 to delete profile");
		System.out.println("press 5 to search profile");
		System.out.println("press 6 to view all profile");
		System.out.println("press 7 to login profile");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your choice");
		
		int c=sc.nextInt();
		
		facebookcontroller f1 = new facebookcontroller();
		
		switch(c) {
		case 1: f1.createProfile();
			break;
		case 2: f1.viewProfile();
			break;
		case 3: f1.editProfile();
			break;
		case 4: f1.deleteProfile();
			break;
		case 5: f1.searchProfile();
			break;
		case 6: f1.viewAllProfile();
			break;
		case 7: f1.loginProfile();
			break;
			default: System.out.println("wrong choice");
		}
		
		System.out.println("do you want to continue press y/n");
		s=sc.next();
		}
    }
}
