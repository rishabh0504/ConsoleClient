package com.avalia.console.helper;

import java.io.BufferedReader;
import java.io.IOException;

import com.avalia.bank.Bank;
import com.avalia.bank.account.Account;

public class BankHelper {

	public static BankHelper INSTANCE = new BankHelper();

	public Double getTotalNoOfAccounts() {

		return Bank.INSTANCE.getTotalBalance();
	}

	public Double getTotalBalance() {
		return Bank.INSTANCE.getTotalBalance();
	}

	public String getName() {

		return Bank.INSTANCE.getName();
	}

	public void addNewAccount(BufferedReader br) throws NumberFormatException,
			IOException {

		System.out.println("Creating new Account.................");
		System.out.println("Please enter the initial amount in your account");
		double bal = Double.parseDouble(br.readLine());
		if (bal < Bank.MIN_BALANCE) {
			System.out.println("Initial amount should be more then 100....");
			return;
		}
		System.out.println("Please your Name");
		String name = br.readLine();

		System.out
				.println("Do you want to register address.Enter y for yes,n for no.");
		String choice = br.readLine();
		if (choice.equals("y")) {
			System.out.println("Enter house no.");
			String houseNo = br.readLine();
			System.out.println("Enter your pin no.");
			String pin = br.readLine();
			Account acc = Bank.INSTANCE.addNewAccount(bal, name, houseNo, pin);
			System.out.println("Account Created ");
			System.out.println(acc);
		}
		Account acc = Bank.INSTANCE.addNewAccount(bal, name);
		System.out.println("Account Created ");
		System.out.println(acc);

	}

	public void depositMoney(BufferedReader br) throws NumberFormatException,
			IOException {
		System.out.println("Enter the account no.");
		int accNum = Integer.parseInt(br.readLine());
		System.out.println("Please Enter Ammount to deposit : ");
		int amount = Integer.parseInt(br.readLine());
		Account acc = Bank.INSTANCE.depositMoney(accNum, amount);
		if (acc == null) {
			System.out.println("Invalid Account Number");
		} else {
			System.out.println("Deposit successfull.");
		}
	}

	public void withdrawMoney(BufferedReader br) throws NumberFormatException,
			IOException {
		System.out.println("Enter the account no.");
		int accNum = Integer.parseInt(br.readLine());
		System.out.println("Please Enter Ammount to withdraw");
		int amount = Integer.parseInt(br.readLine());
		Account acc = Bank.INSTANCE.withdrawMoney(accNum, amount);

		if (acc == null) {
			System.out.println("Invalid Account Number");
		} else {
			System.out.println("withdraw successfull");
		}
	}

	public void calculateInterest(BufferedReader br)
			throws NumberFormatException, IOException {
		System.out.println("Enter the account no.");
		int accNum = Integer.parseInt(br.readLine());
		Double interest = Bank.INSTANCE.calculateInterest(accNum);
		if (interest == null) {
			System.out.println("Invalid Account Number");
		} else {
			System.out.println("Interest is : " + interest);
		}

	}

	public void getFullDetail(BufferedReader br) throws NumberFormatException,
			IOException {
		System.out.println("Enter the account no.");
		int accNum = Integer.parseInt(br.readLine());
		Account acc = Bank.INSTANCE.getFullDetail(accNum);
		if (acc == null) {
			System.out.println("Invalid Account Number");
		} else {
			System.out.println(acc);
		}

	}

	public void checkBalance(BufferedReader br) throws NumberFormatException,
			IOException {
		System.out.println("Enter the account no.");
		int accNum = Integer.parseInt(br.readLine());
		Account acc = Bank.INSTANCE.checkBalance(accNum);
		if (acc == null) {
			System.out.println("Invalid Account Number");
		} else {
			System.out.println("your current balance is : " + acc.getBalance());
		}

	}

}
