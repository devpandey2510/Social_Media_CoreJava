package com.facebook.service;
import com.facebook.entity.*;

import java.util.ArrayList;

import com.facebook.dao.*;

public class FacebookService {

	public int createprofileServices(FacebookUser fb)throws Exception {
		// TODO Auto-generated method stub
		
		FacebookDao fd = new FacebookDao();
    	int i =fd.createProfileDao(fb);
    	return i;
	}
	
	public FacebookUser viewprofileServices(FacebookUser fb)throws Exception{
		FacebookDao fd = new FacebookDao();
		return fd.viewprofileDao(fb);
	}
	
	public int deleteprofileServices(FacebookUser fb)throws Exception {
		FacebookDao fd = new FacebookDao();
    	int i = fd.deleteprofileDao(fb);
    	return i;
	}

	public FacebookUser[] viewAllprofileServices()throws Exception {
		// TODO Auto-generated method stub
		FacebookDao fd = new FacebookDao();
		FacebookUser [] fb = new FacebookUser[10];
		fb= fd.viewAllprofileDao();
		return fb;
		
	}

	public int editprofileService(FacebookUser fb)throws Exception {
		// TODO Auto-generated method stub
		FacebookDao fd = new FacebookDao();
		int i = fd.editprofileDao(fb);
		return i;
	}

	public FacebookUser loginprofileService(FacebookUser fb)throws Exception {
	      FacebookDao fd = new FacebookDao();
		return fd.loginprofileDao(fb);
	}

	public ArrayList<FacebookUser> viewallprofileService()throws Exception {
		FacebookDao fd = new FacebookDao();
		ArrayList<FacebookUser> al = fd.viewallprofileDao();
		return al;
	}

	public ArrayList<FacebookUser> searchprofileService(FacebookUser fb)throws Exception {
		FacebookDao fd = new FacebookDao();
		ArrayList<FacebookUser> al = fd.searchprofileDao(fb);
		return al;
	}

	
}
