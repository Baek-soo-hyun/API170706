package domain;

public class AccountBean {
	private String name, pw, id, deposit, txdate, ssn, accountNum;
	public final static String BANK_NAME = "KB국민은행";
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setTxdate(String txdate) {
		this.txdate = txdate;
	}
	public String getTxdate() {
		return txdate;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return ssn;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	
	public String toString() {
		return "계좌정보 [name : " + name + ", pw : " + pw + ", id : " + id + ", deposit : " + deposit + ", txdate : " + txdate + ", ssn : " + ssn + ", accountNum : " + accountNum + ", bankName : " + BANK_NAME + "]\n";
	}
}
