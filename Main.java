package RailwayTicketManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static ArrayList<String> station = new ArrayList<String>();
	static ArrayList<Ticket> ticket  = new ArrayList<Ticket>();
	Home home = new Home();
	public void adminChoice() {		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1: register");
			System.out.println("Enter 0: login");
			int input = sc.nextInt();
			switch(input) {
			case 1:Register register = new Register();	
			register.register();
			home.home();
			break;
			case 0:Login login = new Login();
			login.login();		
			home.home();
			break;
			default:System.out.println("invalid input!");
			adminChoice();
			break;
			}
		}catch(InputMismatchException e) {
			System.out.println("Invalid data type!");
			adminChoice();
		}
	}

	public static void main(String[] args) {
		Register register = new Register();
		register.create_user();
		Home home = new Home();
		home.add_station();
		Main main = new Main();
		main.adminChoice();
	}
}
