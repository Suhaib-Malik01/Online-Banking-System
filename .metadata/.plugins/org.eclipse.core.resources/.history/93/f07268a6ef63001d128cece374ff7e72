package Dao;

import java.util.List;

import Bean.TransactionBean;
import Bean.UserBean;
import Exception.CustomerException;

public interface UserDao {
	
	public UserBean Login(String username, String password, int account)throws CustomerException; 
	
	public int Accountbal(int accountNumber) throws CustomerException;
	
	public int Deposit(int custACno, int amount) throws CustomerException; 
	
	public int Withdraw(int custACno, int amount) throws CustomerException;
	
	public List<TransactionBean> viewTransaction(int custAccountno) throws CustomerException;
}
