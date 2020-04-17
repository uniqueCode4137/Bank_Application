package BAO;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Bank_Entities;

public class CustomerInfo_Bao {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		ArrayList<Bank_Entities> list = new ArrayList<Bank_Entities>();

		String acct_type = null;
		String fullName = null;
		BigInteger acctNo = null;
		float amt = 0;
		String currency = null;

		String decision;
		Boolean isAdd = false;
		boolean isValid = false;

		boolean yn = true;
		while (yn) {
			System.out.println("Do you want to create account or not ...?(y/n)");
			decision = in.next().toLowerCase();

			switch (decision) {
			case "y":
				yn = false;
				acct_type = getAccountType(in, isValid, acct_type);
				fullName = getFullName(isValid, fullName);
				acctNo = getAccount(in, isValid, acctNo);
				amt = getAmount(in, isValid, amt);
				currency = getCurrency(in, isValid, currency);
				break;

			case "n":
				yn = false;
				System.err.println("Thanks & have a good day......! ");
				break;

			default:
				boolean repeat = true;
				if (yn == false) {
					break;
				}
				while (repeat) {
					System.out.println("Do want to try again ...?(y/n)");
					decision = in.next().toLowerCase();

					switch (decision) {
					case "y":
						yn = true;
						repeat = false;
						break;

					case "n":
						yn = repeat = false;
						break;
					default:
						repeat = true;
					}
				}
				break;
			}

			Bank_Entities bank = new Bank_Entities(acct_type, fullName, acctNo, amt, currency);
			isAdd = bank != null ? list.add(bank) : null;

			if (bank.amt == 0) {
				return;
			}
			if (isAdd) {

				isAdd = false;
				System.out.println("Do you want to add more records..?(y/n) ");
				decision = in.next().toLowerCase();

				switch (decision) {
				case "y":
					yn = true;
					break;

				case "n":

					for (Bank_Entities be : list) {
						System.out.println("" + "\n" + "Name:- " + be.fullName + "\n" + "Account Type:- " + be.acct_type
								+ "\n" + "Account No:- " + be.acctNo + "\n" + "Amount:- " + be.amt + "\n"
								+ "Currency:- " + be.currency + "\n");
					}
					yn = false;
					break;
				default:
					break;
				}

			}

		}

	}

	public static float getAmount(Scanner in, boolean isValid, float amt) {

		do {
			// Get input amt
			System.out.println("Enter a amt number: ");
			if (in.hasNextFloat()) {
				amt = in.nextFloat();
				isValid = true;
			} else {
				System.err.println("Please give correct amount in number only ");
				isValid = false;
				in.next();
			}

		} while (!(isValid));
		return amt;
	}

	public static BigInteger getAccount(Scanner in, boolean isValid, BigInteger acctNo) {

		do {
			// Get input actt num
			System.out.println("Enter a account number: ");
			if (in.hasNextBigInteger()) {
				acctNo = in.nextBigInteger();
				String s = String.valueOf(acctNo);

				if (!s.matches("[0-9]{9,18}")) {
					System.err.println("Please enter account number between 9 to 20 digits... ");
					isValid = false;
				} else {
					isValid = true;
				}

			} else {

				System.err.println("Please give correct account number ");
				isValid = false;
				in.next();

			}
		} while (!(isValid));
		return acctNo;
	}

	public static String getAccountType(Scanner in, boolean isValid, String acct_type) {

		int acct_option;
		do {
			System.out.println("please select account type:- " + "\n" + " 1. Saving" + "\n" + " 2. Current");

			if (in.hasNextInt()) {
				acct_option = in.nextInt();
				if (acct_option == 1) {
					acct_type = "Saving";
				} else if (acct_option == 2) {
					acct_type = "Current";
				} else {
					System.err.println("you choose wrong option ");
					isValid = false;
					in.next();
				}
				isValid = true;
			} else {
				System.err.println("Please give correct input number ");
				isValid = false;
				in.next();
			}
		} while (!(isValid));
		return acct_type;

	}

	public static String getCurrency(Scanner in, boolean isValid, String currency) {

		do {
			System.out.println("Enter a currency:- ");
			if (in.hasNext()) {
				currency = in.next();
				if (!currency.chars().allMatch(Character::isLetter)) {
					System.err.println("Please entered valid currency ");
				}else {
					isValid = true;
					}
				
			} else {
				System.err.println("Please entered valid currency ");
				isValid = false;
				in.next();
			}
		} while (!(isValid));
		return currency.toUpperCase();

	}

	public static String getFullName(boolean isValid, String fullName) {

		do {
			System.out.println("Please enter a Firstname , MiddleName & Lastname separated by spaces");
			Scanner sc = new Scanner(System.in);

			if (sc.hasNext()) {
				fullName = sc.nextLine();
				isValid = true;
			} else {
				System.err.println("Please entered name ");
				isValid = false;
				sc.next();
			}
		} while (!(isValid));
		return fullName.toUpperCase();

	}
}
