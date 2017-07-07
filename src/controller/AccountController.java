package controller;

import java.util.Calendar;

import javax.swing.JOptionPane;

import domain.AccountBean;
import service.AccountService;
import serviceImpl.AccountServiceImpl;

public class AccountController {
	public static void main(String[] args) {
		AccountBean accountBean = null;
		AccountService accountService = new AccountServiceImpl();
		Calendar now = Calendar.getInstance();
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.exit "
					+ "1.create "
					+ "2.List "
					+ "3.findByName "
					+ "4.findByAccountNum "
					+ "5.countAccounts "
					+ "6.updatePw "
					+ "7.updateDeposit "
					+ "8.updateWithdraw "
					+ "9.deleteAccount")) {
			case "0" :
				return;
			case "1" :
				accountBean = new AccountBean();
				int randomNo = (int)(Math.random()*99999999 + 10000000);
				String[] arr = JOptionPane.showInputDialog("name/pw/id/ssn").split("/");
				String txdate = now.get(now.YEAR) + "/" + (now.get(now.MONTH) + 1) + "/" + now.get(now.DAY_OF_MONTH);
				accountBean.setName(arr[0]);
				accountBean.setPw(arr[1]);
				accountBean.setId(arr[2]);
				accountBean.setSsn(arr[3]);
				accountBean.setDeposit("0");
				accountBean.setTxdate(txdate);
				accountBean.setAccountNum(String.valueOf(randomNo));
				accountService.createAccount(accountBean);
				JOptionPane.showMessageDialog(null, "계좌 생성 완료");
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, accountService.accountList().toString());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null, accountService.findByName(JOptionPane.showInputDialog("Name for find")).toString());
				break;
			case "4" :
				JOptionPane.showMessageDialog(null, accountService.findByAccountNum(JOptionPane.showInputDialog("accountNum for find")).toString());
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, accountService.countAccounts());
				break;
			case "6" :
				accountBean = new AccountBean();
				accountBean.setAccountNum(JOptionPane.showInputDialog("your accountNum"));
				accountBean.setPw(JOptionPane.showInputDialog("accountNum for update pw"));
				accountService.updatePw(accountBean);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;
			case "7" :
				accountBean = new AccountBean();
				accountBean.setAccountNum(JOptionPane.showInputDialog("your accountNum"));
				accountBean.setDeposit(JOptionPane.showInputDialog("sum for deposit"));
				accountService.updateDeposit(accountBean);
				JOptionPane.showMessageDialog(null, "입금 완료");
				break;
			case "8" :
				accountBean = new AccountBean();
				accountBean.setAccountNum(JOptionPane.showInputDialog("your accountNum"));
				accountBean.setDeposit(JOptionPane.showInputDialog("sum for whithdraw"));
				accountService.updateWithdraw(accountBean);
				JOptionPane.showMessageDialog(null, "출금 완료");
				break;
			case "9" :
				accountService.deleteAccount(JOptionPane.showInputDialog("your accountNum"));
				JOptionPane.showMessageDialog(null, "계좌 해지 완료");
				break;
			}
		}
	}
}
