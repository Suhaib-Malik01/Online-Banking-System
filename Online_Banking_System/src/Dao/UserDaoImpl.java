package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.TransactionBean;
import Bean.UserBean;
import Exception.CustomerException;
import utility.DBUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public UserBean Login(String username, String password, int account) throws CustomerException {
		
		UserBean cus = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
		PreparedStatement ps= conn.prepareStatement("select * from Customer c inner join Account a on c.custid=a.custid where custmail = ? and custpass = ? and custACno=?" );			
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, account);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int ac=rs.getInt("custACno");	
				String name=rs.getString("custname");
				int bal=rs.getInt("custbal");
				String mail= rs.getString("custmail");
				String pass= rs.getString("custpass");
				String mob=rs.getString("custmob");
				String add=rs.getString("custadd");
				
			cus=new UserBean();	
			
			
			cus.setAcno(ac);
			cus.setName(name);
			cus.setBal(bal);
			cus.setMail(mail);
			cus.setPass(pass);
			cus.setMob(mob);
			cus.setAdd(add);
				
				
			}else {
				throw new CustomerException("Invalid Username or password...");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		return cus;
	}
	

	@Override
	public int Accountbal(int accountNumber) throws CustomerException {
		int balance = 0;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("Select custbal from Account where custACno = ?" );			
				
				ps.setInt(1, accountNumber);
				
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					balance =rs.getInt("custbal");
				}
			
					
			} catch (SQLException e) {
				throw new CustomerException(e.getMessage());
			}
		return balance;
	}

	@Override
	public int Deposit(int custACno, int amount) throws CustomerException {
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update Account set custbal=custbal+? where custacno = ?" );			
				
				ps.setInt(1, amount);
				ps.setInt(2, custACno);
				
				int rs= ps.executeUpdate();
				
			if(rs>0) {
				PreparedStatement ps2=conn.prepareStatement("insert into Transaction values(?,?,0)");
				
				ps2.setInt(1, custACno);
				ps2.setInt(2, amount);
				
				int rs1=ps2.executeUpdate();
			}else {
				throw new CustomerException("Account not found");
			}
			
				
					
			} catch (SQLException e) {
				throw new CustomerException(e.getMessage());
			}
		return 0;
	}

	@Override
	public int Withdraw(int custACno, int amount) throws CustomerException {
		int total_bal= Accountbal(custACno);
		if(total_bal>=amount) {
			try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("update Account set custbal=custbal-? where custACno = ?" );			
					
					ps.setInt(1, amount);
					ps.setInt(2, custACno);
					
					int rs= ps.executeUpdate();
					
				if(rs>0) {
					PreparedStatement ps2=conn.prepareStatement("insert into Transaction values(?,0,?)");
					
					ps2.setInt(1, custACno);
					ps2.setInt(2, amount);
					
					int rs2=ps2.executeUpdate();
				}else {
					throw new CustomerException("Account not found");
				}
				
					
						
			} catch (SQLException e) {
					throw new CustomerException(e.getMessage());
			}
			
		}else {
			throw new CustomerException("Insufficient Balance");
		}
		
		return total_bal+amount;
		
	}

	@Override
	public List<TransactionBean> viewTransaction(int custAccountno) throws CustomerException {
		List<TransactionBean> list=new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from transaction where custAcno=?");
			ps.setInt(1, custAccountno);
			
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				int ac=rs.getInt("custACno");
				int dep=rs.getInt("deposit");
				int wid=rs.getInt("withdraw");
				TransactionBean ts = new TransactionBean();
				ts.setAccountNo(ac);
				ts.setDeposit(dep);
				ts.setWithdraw(wid);
				
				list.add(ts);
			}
//			if(list.size()==0) {
//				throw new CustomerException("Transaction not Found");
//			}
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		return list;
	}

	
	
	
	

}
