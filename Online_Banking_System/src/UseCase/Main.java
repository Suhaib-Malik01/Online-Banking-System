package UseCase;

import java.util.*;

import Bean.AccountBean;
import Bean.TransactionBean;
import Bean.UserBean;
import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
import Exception.AccountException;
import Exception.AccountantException;
import Exception.CustomerException;


public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.println("      Welcome To Bank of Future    ");
			System.out.println("------------------------------------"); 
			System.out.println("1. Accountant Login \n"
					+ "2. Customer Login \n");
			
			int c=sc.nextInt();
			
			
			switch(c) {
			case 1:
				System.out.println(" Login Accountant ");
				System.out.println("-------------------");
				System.out.println("Enter UserName: ");
				String Username = sc.next();
				System.out.print("Enter Password: ");
				String Password = sc.next();
				
				AdminDao admindao = new AdminDaoImpl();
				
				String msg = null;
				try {
					msg = admindao.adminLogin(Username, Password);
				} catch (AccountantException e1) {
					e1.printStackTrace();
				}
				
				System.out.println(msg);
				boolean Adminflag = false;
				if(msg.equals("Login Successfull")) {
					Adminflag = true;
				}else {
					continue;
				}
				while(Adminflag) {
					System.out.println("-----------------------------------------------------\r\n"
							+ "1. Add New Customer Account\n"
							+ "2. Delete the account\n"
							+ "3. View particular account details\n"
							+ "4. View all the account details\n"
							+ "7. View Transaction History for Customer\n"
							+ "8. exit\r\n"
							+"-------------------------------------------\n");
					
					int s = sc.nextInt();
					if(s==1) {
						System.out.println("New Account");
						System.out.println("-------------------------------");
						
						System.out.println("Enter Customer Name");
			 			String a2=sc.next();
			 			System.out.println("Enter Account Opening Balance");
			 			int a3=sc.nextInt();
			 			System.out.println("Enter Email");
			 			String a4=sc.next();
			 			System.out.println("Enter Password");
			 			String a5=sc.next();
			 			System.out.println("Enter Mobile number");
			 			String a6=sc.next();
			 			System.out.println("Enter Address");
			 			String a7=sc.next();
			 			
			 			
			 			int s1= 0;
						try {
							s1 = admindao.addCustomer(a2,a4,a5,a6,a7);
							try {
								admindao.addAccount(a3, s1);
							} catch (AccountException e) {
								e.printStackTrace();
							}
						} catch (CustomerException e) {
							e.printStackTrace();
						}
			 			if(s1!=0) {
			 				System.out.println("        Account Added");
			 				System.out.println("-------------------------------");
			 			}
					}
					if(s==2) {
						System.out.println("        Remove Account");
						System.out.println("-------------------------------");
						System.out.println("Enter Account No.");
						int ac=sc.nextInt();
						String x=null;
						try {
							x = admindao.removeAccount(ac);
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
						if(x!=null)
							System.out.println(x);
					}if(s==3) {
						System.out.println("       Customer Details");
						System.out.println("-------------------------------");
						System.out.println("Enter Customer Account No.");
						int ac=sc.nextInt();
						
						try {
							AccountBean res=admindao.getAccount(ac);
							
							if(res!=null) {
								System.out.println("******************************");
								System.out.println("Account No: " + res.getAccountNo());
								System.out.println("Balance: " + res.getBalance());
								System.out.println("Customer ID: " + res.getCustomerId());
								System.out.println("******************************");
								
							}else {
								System.out.println("Account does not Exist");
								System.out.println("---------------------------");
							}
						} catch (CustomerException e) {
							e.printStackTrace();
						}
						
					}
					if(s==4) {
						try {
							System.out.println("All Customer Details");
							System.out.println("-------------------------------");
							List<AccountBean> res=admindao.getAllcustomer();
							
							System.out.println(res);
		
							
						} catch (AccountException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}if(s==7) {
						UserDao user=new UserDaoImpl();
						System.out.println("Transaction History");
						System.out.println("---------------------------------");
						System.out.println("Enter Account No. ");
						int acount=sc.nextInt();
						List<TransactionBean> list=null;
						try {
							list=user.viewTransaction(acount); 
							if(list.size()==0) {
								System.out.println("Transaction not Found");
							}else {
								System.out.println("Account No.: "+list.get(0).getAccountNo());
								list.forEach(i->{
									System.out.println("---------------------------------------------");
									if(i.getDeposit()!=0)
										System.out.println("Amount Credit: "+i.getDeposit());
									if(i.getWithdraw()!=0)
										System.out.println("Amount Debit: "+i.getWithdraw());
								});
							}
							
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(s==8) {
						System.out.println("Thank you!");
						Adminflag=false;
						break;
					}
					
				}
				break;
			case 2: 
				System.out.println("Login Customer");
				System.out.println("--------------------------");
				System.out.println("Enter Email:");
				String username=sc.next();
				System.out.println("Enter Password");
				String password=sc.next();
				System.out.println("Enter Account No");
				int acno=sc.nextInt();
				
				UserDao user=new UserDaoImpl();
				
				try {
					UserBean cust = user.Login(username, password,acno);
					
					System.out.println("Welcome "+cust.getName());
					
					boolean m=true;
					
					while(m) {
						System.out.println("-------------------------------\r\n"
								+ "1. View Balance\n"
								+ "2. Deposit Money\n"
								+ "3. Withdraw Money\n"
								+ "4. View Transaction History\n"
								+ "99. exit\r\n"
								+"-------------------------------\n");

						
						int s=sc.nextInt();
						
						if(s==1) {
							System.out.println("            Balance          ");
							System.out.println("-------------------------------");

							System.out.println("Current Account Balance");
							System.out.println(user.Accountbal(acno)); 
							System.out.println("------------------------");
						}
						if(s==2) {
							System.out.println("           Deposite           ");
							System.out.println("-------------------------------");

							System.out.println("Enter Amount to Deposit");
							int a=sc.nextInt();
							user.Deposit(acno, a);
							System.out.println("Your Balance after Deposit");
							System.out.println(user.Accountbal(acno));
							System.out.println("----------------------------");
						}
						
						if(s==3) {
							System.out.println("          Withdrwal          ");
							System.out.println("-------------------------------");

							System.out.println("Enter Withdrawl amount");
							int a=sc.nextInt();
							try {
								user.Withdraw(acno, a);
								System.out.println("Your Balance after Withdrawl");
								System.out.println(user.Accountbal(acno));
								System.out.println("-----------------------------");
							}catch(CustomerException e) {
								System.out.println(e.getMessage());
							}
						}
						if(s==4) {
							List<TransactionBean> list=null;
							try {
								list= user.viewTransaction(acno);
							}catch(CustomerException e) {
								System.out.println(e.getMessage());
							}
							System.out.println("   Transaction History");
							System.out.println("-------------------------------");

							System.out.println("Account No.: " + list.get(0).getAccountNo());
							
							list.forEach(i->{
								System.out.println("----------------------------------------------------");
								if(i.getDeposit()!=0)
									System.out.println("Amount Credit: "+ i.getDeposit());
								if(i.getWithdraw()!=0)
									System.out.println("Amount Debit : "+ i.getWithdraw());
							});
							
						}
						if(s==99) {
							System.out.println("          Thank You!");
							System.out.println("-------------------------------");
							flag = false;
							m=false;
							break;
						}
						
						
					}
					break;
					
					
				} catch (CustomerException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			}
		}
	}

	

}
