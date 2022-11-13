package Bean;

public class UserBean {
	private int Acno;
	private String name;
	private int bal;
	private String mail;
	private String pass;
	private String mob;
	private String add;
	
	
	public int getAcno() {
		return Acno;
	}


	public void setAcno(int acno) {
		Acno = acno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBal() {
		return bal;
	}


	public void setBal(int bal) {
		this.bal = bal;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getMob() {
		return mob;
	}


	public void setMob(String mob) {
		this.mob = mob;
	}


	public String getAdd() {
		return add;
	}


	public void setAdd(String add) {
		this.add = add;
	}


	@Override
	public String toString() {
		return "UserBean [Acno=" + Acno + ", name=" + name + ", bal=" + bal + ", mail=" + mail + ", pass=" + pass
				+ ", mob=" + mob + ", add=" + add + "]";
	}
	
	
	
	
	
	
	

}
