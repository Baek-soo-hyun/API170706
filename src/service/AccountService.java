package service;

import java.util.Vector;

import domain.AccountBean;

public interface AccountService {
	public void createAccount(AccountBean accountBean);
	public Vector<AccountBean> accountList(); 
	public Vector<AccountBean> findByName(String name);
	public AccountBean findByAccountNum(String accountNum);
	public int countAccounts();
	public void updatePw(AccountBean accountBean);
	public void updateDeposit(AccountBean accountBean);
	public void updateWithdraw(AccountBean accountBean);
	public void deleteAccount(String accountNum);
}
