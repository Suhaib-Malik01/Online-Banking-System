package Bean;

public class UserBean {
	public String FirstName;
	public String LastName;
	public String Phone;
	public String age;
	public String email;
	public String Address;
	public String Gender;
	public String AadharNum;
	public String Password;
	
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAadharNum() {
		return AadharNum;
	}
	public void setAadharNum(String aadharNum) {
		AadharNum = aadharNum;
	}
	@Override
	public String toString() {
		return "UserBean [FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", email=" + email
				+ ", Address=" + Address + ", Gender=" + Gender + ", AadharNum=" + AadharNum + "]";
	}
	
	
	

}
