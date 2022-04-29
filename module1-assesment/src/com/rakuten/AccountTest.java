package com.rakuten;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	Account account;
	String s;

	@Before
	public void init() {
		String name = "Harshith";
		String createdDate = "05/04/22";
		String city = "Mysore";
		String state = "Karnataka";
		String zipCode = "570023";
		String phoneNumber = "8310938186";
		String houseNumber = "453";
		String street = "Pary Lane";
		String type = "SAVINGS";
		String status = "ACTIVE";
		int balance=500;
		account = new Account(name, createdDate, city, state, zipCode, phoneNumber, houseNumber, street, type, status,balance);
		System.out.println(account.getDetails());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeDeposit() {
		account.deposit(-350);
	}
		
		
		@Test
		public void testDeposit() {
			account.deposit(350);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testOverWithdrawal() {
			account.withdraw(3500);
			
		}
		
		@Test
		public void testWithdrawal() {
			account.withdraw(350);
		}

	
		

}
