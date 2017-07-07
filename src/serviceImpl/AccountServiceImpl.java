package serviceImpl;

import java.util.Vector;

import domain.AccountBean;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	Vector<AccountBean> vec;
	public AccountServiceImpl() {
		vec = new Vector<AccountBean>(10,10);
	}
	@Override
	public void createAccount(AccountBean accountBean) {
		vec.add(accountBean);
	}

	@Override
	public Vector<AccountBean> accountList() {
		// 계좌 목록
		return vec;
	}

	@Override
	public Vector<AccountBean> findByName(String name) {
		// 이름으로 검색(동명이인 가능)
		Vector<AccountBean> temp = new Vector<AccountBean>(10,10);
		for(int i=0 ; i<vec.size() ; i++) {
			if(name.equals(vec.get(i).getName())) {
				temp.add(vec.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean accountBean = new AccountBean();
		for(int i=0 ; i<vec.size() ; i++) {
			if(accountNum.equals(vec.get(i).getAccountNum())) {
				accountBean = vec.get(i);
			}
		}
		return accountBean;
	}

	@Override
	public int countAccounts() {
		// 전체 계좌 수 
		return vec.size();
	}

	@Override
	public void updatePw(AccountBean accountBean) {
		// 비밀번호 변경
		for(int i=0 ; i<vec.size() ; i++) {
			if (accountBean.getAccountNum().equals(vec.get(i).getAccountNum())) {
				System.out.println(vec.get(i).toString());
				vec.get(i).setPw(accountBean.getPw());
				System.out.println(i);
				break;
			}
		}
	}

	@Override
	public void updateDeposit(AccountBean accountBean) {
		// 예금
		String preDeposit = findByAccountNum(accountBean.getAccountNum()).getDeposit();
		findByAccountNum(accountBean.getAccountNum()).setDeposit(String.valueOf(Integer.parseInt(accountBean.getDeposit()) + Integer.parseInt(preDeposit)));
	}

	@Override
	public void updateWithdraw(AccountBean accountBean) {
		// 출금
		String preDeposit = findByAccountNum(accountBean.getAccountNum()).getDeposit();
		findByAccountNum(accountBean.getAccountNum()).setDeposit(String.valueOf(Integer.parseInt(preDeposit) - Integer.parseInt(accountBean.getDeposit())));
	}

	@Override
	public void deleteAccount(String accountNum) {
		// 계좌 해지
		for(int i=0 ; i<vec.size() ; i++) {
			if(accountNum.equals(vec.get(i).getAccountNum())) {
				vec.remove(i);
				break;
			}
		}
	}

}
