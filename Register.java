package RailwayTicketManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register{
	String userName;
	String password;
	String email_id;
	String phone_no;
	static ArrayList <Admin> adminList = new ArrayList<Admin>();
	Scanner sc = new Scanner(System.in);
	public  void setuserName() {	
		this.userName = sc.next();
	}
	public void setPassword() {	
		this.password = sc.next();
	}

	public void setEmail() {
		this.email_id = sc.next();
	}
	public void setPhone_no() {
		this.phone_no = sc.next();
	}
	public   boolean isValidPassword() {
		//		String password = this.password;
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(password);
		boolean matchfound = matcher.find();
		return matchfound;
	}

	public  boolean isValidEmail() {
		//		String email = this.email_id;
		String regex ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(email_id);
		boolean matchfound = matcher.find();
		return matchfound;
	}

	public  boolean isValidPh() {
		//		String phone_number = this.phone_no;
		String regex = "\\d{10}";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(phone_no);
		boolean matchfound = matcher.find();
		return matchfound;
	}

	public void register() {
		boolean isValidPassword = true;
		System.out.println("enter user name:");
		setuserName();

		boolean isUserExist = false;
		for(Admin x : adminList) {
			if(x.getUserName().equals(userName)) {
				System.out.println("user already exist!");
				isUserExist = true;
				break;
			}	
		}
		
		if(!isUserExist) { 
			do {
				System.out.println("enter password");
				setPassword();
				if(isValidPassword()) {
					isValidPassword = false;
				}	
				else {
					System.out.println("weak password!!");
				}
			}while(isValidPassword);
			boolean isValidEmail = true;
			do {
				System.out.println("enter email-id");
				setEmail();
				if(isValidEmail()) {
					isValidEmail = false;
				}	
				else {
					System.out.println("invalid email format!!");
				}
			}while(isValidEmail);
			boolean isValidPhone = true;
			do {
				System.out.println("enter phone-no");
				setPhone_no();
				if(isValidPh() && phone_no.length() == 10) {
					isValidPhone = false;
				}	
				else {
					System.out.println("invalid phone number!!");
				}
			}while(isValidPhone);
			addUser();
		}

	}

	public void addUser() {
		Admin user = new Admin(userName, password, email_id, phone_no);
			adminList.add(user);
			System.out.println("account created");
	}
	public void create_user() {
		adminList.add(new Admin("allen","allen123","allen@gmail.com","123456"));
		adminList.add(new Admin("kelvin","kelvin123","kelvin@gmail.com","123456"));
	}
}
