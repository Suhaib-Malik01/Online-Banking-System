package UseCase;

import java.util.*;

import Bean.UserBean;
import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.println("-----------------------" + "\n"
					 + "| 1.Login as Admin     |" + "\n" 
				     + "| 2.Signup as Customer |" + "\n"
					 + "| 3.Login as Customer  |" + "\n"
				     + "| 4.Exit               |" + "\n"
					 + "-----------------------");
			int n = sc.nextInt();
			if(n==1) {
				System.out.println("Enter Username: ");
				String Username = sc.next();
				System.out.print("Enter Password: ");
				String Password = sc.next();
				
				AdminDao admindao = new AdminDaoImpl();
				
				String msg = admindao.adminLogin(Username, Password);
				
				System.out.println(msg);
				
			}
			if(n==2) {
				UserBean user = new UserBean();
				
				System.out.println("Enter Your First Name: ");
				String firstName = sc.next();
				user.setFirstName(firstName);
				
				System.out.println("Enter Your Last Name: ");
				
				String LastName = sc.next();
				user.setLastName(LastName);
				
				System.out.println("Enter Your age: ");
				
				String age = sc.next();
				
				user.setAge(age);
				
				System.out.println("Enter Your address: ");
				
				String address = sc.next();
				user.setAddress(address);
				
				System.out.println("Enter Your email: ");
				
				String email = sc.next();
				
				user.setEmail(email);
				
				System.out.println("Select Gender");
				System.out.println("1.Male 2.female");
				String Gender = "";
				
				int g = sc.nextInt();
				
				Gender = (g==1 ? "Male" : "Female");
				
				user.setGender(Gender);
				
				System.out.println("Create password: ");
			    
				String pass = sc.next();
				user.setPassword(pass);
				
				System.out.println("Enter Your Phone Number: ");
				
				String Number = sc.next();
				
				user.setPhone(Number);
				
				
				System.out.println("Enter Your Aadhaar Number: ");
				
				String Anum = sc.next();
				
				user.setAadharNum(Anum);
				
				UserDao userdao = new UserDaoImpl();
				
				String msg = userdao.SignUp(user);
				
				System.out.println(msg);
				break;
				
			}else if(n==3) {
				
			}else if(n==4) {
				System.out.println("Thank You");
				break;
			}else {
				System.out.println("Enter Valid Input");
			}
		}
		
		
	}
	
	

}
