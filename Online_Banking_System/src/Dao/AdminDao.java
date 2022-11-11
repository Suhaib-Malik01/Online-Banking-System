package Dao;

import Bean.AdminBean;

public interface AdminDao {
	
	public final String username = "admin";
	public final String password = "12345";
	
	public String adminLogin(String Username,String Password);
	

}
