package com.avalia.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.avalia.console.helper.BankHelper;

public class Console {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {

			while (true) {
				System.out.println("Welcome to : "
						+ BankHelper.INSTANCE.getName());
				System.out.println("Total acccounts We have: "
						+ BankHelper.INSTANCE.getTotalNoOfAccounts());
				System.out.println("Total balance we have : "
						+ BankHelper.INSTANCE.getTotalBalance());
				System.out.println("Please Enter your choice.");
				System.out.println("1: Add Customer.");
				System.out.println("2: Deposite Money.");
				System.out.println("3: Withdraw Money.");
				System.out.println("4: Check Balance.");
				System.out.println("5: Calaculate Interest.");
				System.out.println("6: Check Detail.");
				System.out.println("7: Exit.");
				int choice = Integer.parseInt(br.readLine());

				switch (choice) {
				case 1: {
					BankHelper.INSTANCE.addNewAccount(br);
				}
					break;
				case 2:
					BankHelper.INSTANCE.depositMoney(br);

					break;
				case 3:
					BankHelper.INSTANCE.withdrawMoney(br);
					break;
				case 4:
					BankHelper.INSTANCE.checkBalance(br);
					break;
				case 5:
					BankHelper.INSTANCE.calculateInterest(br);
					break;
				case 6:
					BankHelper.INSTANCE.getFullDetail(br);
					break;
				case 7:
					System.exit(0);
					break;
				default:
					break;

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
