package Bean;

public class AccountBean {
	private String accountNo;
	
	private String CustomerId;
	
	private Long balance;

	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountBean [accountNo=" + accountNo + ", CustomerId=" + CustomerId + ", balance=" + balance + "]";
	}
	
}
