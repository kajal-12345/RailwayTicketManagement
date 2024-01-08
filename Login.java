package RailwayTicketManagement;

import java.util.Scanner;


public class Login {
	String name;
	String password;
	public  void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name");
		name = sc.next();
		System.out.println("Enter password");
		password = sc.next();
		if(checkCredential()) {
			System.out.println("login sucessful!");
		}
		else {
			System.out.println("invalid username or password,please try again!");
			login();
		}
	}
	public   boolean checkCredential() {
		boolean checkCredential = false ;
		for(int i = 0 ; i < Register.adminList.size();i++) {
			if(Register.adminList.get(i).getUserName().equals(name) && Register.adminList.get(i).getPassword().equals(password)) {
				checkCredential = true;
			}		

		}
		return checkCredential;
	}

}
