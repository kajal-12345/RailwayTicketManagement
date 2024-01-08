package RailwayTicketManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Home {
	Scanner sc = new Scanner(System.in);
	int user_age;
	boolean isValidpos;
	int index_of_element;
	int LastindexOfTicket;

	public void setPosition() {
		System.out.println("Enter position");
		Scanner sc = new Scanner(System.in);
		isValidpos = false;
		try {
			int pos = sc.nextInt();
			index_of_element = pos;
			if (index_of_element > 0 || index_of_element < Main.station.size()) {
				isValidpos = true;
			}
		} catch (InputMismatchException e) {
			System.out.println("invalid data type!");
			setPosition();
		}

	}

	public void addStation() {
		System.out.println("Enter station name");
		String station = sc.next();
		setPosition();
//         System.out.println(index_of_element);

		boolean isExist = false;
		for (int i = 0; i < Main.station.size(); i++) {
			if (Main.station.get(i).equalsIgnoreCase(station)) {
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			if (isValidpos) {
				try {
					Main.station.add(index_of_element - 1, station);
				} catch (IndexOutOfBoundsException x) {
//					System.out.println("invalid input!!");
//					addStation();
					Main.station.add(station);
				}
			} else {
				System.out.println("invalid data!");
				setPosition();
			}
//			Collections.sort(Main.station);
		} else {
			System.out.println("already exist!");
		}
	}

	public void setAge() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter age");
		try {
			int age = scan.nextInt();
			this.user_age = age;
			if (age <= 0 || age > 100) {
				System.out.println("invalid age");
				setAge();
			}
		} catch (InputMismatchException e) {
			System.out.println("please enter proper age!");
			setAge();
		}

	}

	public void add_station() {
		Main.station.add("ambernath");
		Main.station.add("ulhasnagar");
		Main.station.add("vitthalwadi");
		Main.station.add("kalyan");
		Main.station.add("thakurli");
		Main.station.add("dombivili");
		Main.station.add("kopar");
		Main.station.add("diva");
		Main.station.add("mumbra");
		Main.station.add("kalwa");
		Main.station.add("thane");
		Main.station.add("mulund");
//		Collections.sort(Main.station);
	}

	public void show_station() {
		for (String x : Main.station) {
			System.out.println(x);
		}
	}

	public void book_ticket() {

		System.out.println(Main.station + "\n");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter gender");
		String gender = sc.next();
		boolean isValidgender = false;
		if (gender.equalsIgnoreCase("female")) {
			isValidgender = true;
		} else if (gender.equalsIgnoreCase("male")) {
			isValidgender = true;
		} else if (gender.equalsIgnoreCase("other")) {
			isValidgender = true;
		}
		if (isValidgender) {
			setAge();
			System.out.println("Enter source :");
			String from_station = sc.next();
			System.out.println("Enter destination :");
			String to_station = sc.next();

			if (from_station.equalsIgnoreCase(to_station)) {
				System.out.println("source and destination cannot be same");
				book_ticket();
			} else {
				boolean isValidSource = false;
				for (int i = 0; i < Main.station.size(); i++) {
					if (Main.station.get(i).equalsIgnoreCase(from_station)) {
						isValidSource = true;
						break;
					}
				}
				boolean isValidDest = false;
				for (int i = 0; i < Main.station.size(); i++) {
					if (Main.station.get(i).equalsIgnoreCase(to_station)) {
						isValidDest = true;
						break;
					}
				}

				if (!isValidSource && !isValidDest) {
					System.out.println("Invalid station name");
					home();
				} else {
					double price = 0;
					int source_index = Main.station.indexOf(from_station);
					int dest_index = Main.station.indexOf(to_station);
					if (source_index < dest_index) {

						for (int i = source_index; i < dest_index; i++) {
							price += 5;
						}

					}

					else if (source_index > dest_index) {
						for (int i = source_index; i > dest_index; i--) {
							price += 5;
						}
					}
					System.out.println("original price   " + price);
					if (gender.equalsIgnoreCase("female") && user_age < 60) {
						price = price - price * 0.3;
					} else if (user_age >= 60) {
						price = price - price * 0.5;
					}
					Main.ticket.add(new Ticket(name, gender, user_age, from_station, to_station, price,
							(long) (Math.random() * 10000000000000000L)));
				}
			}

		} else {
			System.out.println("please enter proper gender!");
			book_ticket();
		}
		System.out
				.println("name    " + "gender    " + "age   " + "source   " + "destination    " + "price     " + "pnr");

		for (Ticket x : Main.ticket) {
			LastindexOfTicket = Main.ticket.lastIndexOf(x);
		}
		System.out.println(Main.ticket.get(LastindexOfTicket).name + "    " + Main.ticket.get(LastindexOfTicket).gender
				+ "       " + Main.ticket.get(LastindexOfTicket).age + "    "
				+ Main.ticket.get(LastindexOfTicket).from_station + "   "
				+ Main.ticket.get(LastindexOfTicket).to_station + "  " + Main.ticket.get(LastindexOfTicket).price + "  "
				+ Main.ticket.get(LastindexOfTicket).pnr);
	}

	public void show_ticket() {
		System.out
				.println("name    " + "gender    " + "age   " + "source   " + "destination    " + "price     " + "pnr");
		for (Ticket x : Main.ticket) {
			System.out.println(x.name + "    " + x.gender + "       " + x.age + "    " + x.from_station + "   "
					+ x.to_station + "  " + x.price + "  " + x.pnr);
		}
	}

	public void cancel_ticket() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pnr to cancel ticket");

		try {
			long pnr = sc.nextLong();
			boolean isvalidpnr = false;
			for (int x = 0; x < Main.ticket.size(); x++) {
				if (Main.ticket.get(x).pnr == pnr) {
					isvalidpnr = true;
					Main.ticket.remove(x);
					break;
				}
			}
			if (!isvalidpnr) {
				System.out.println("invalid pnr,please try again");
				cancel_ticket();
			}
		} catch (InputMismatchException e) {
			System.out.println("invalid data type!");
			cancel_ticket();
		}

	}

	public void home() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1:add station");
		System.out.println("Enter 2:show station");
		System.out.println("Enter 3:book ticket");
		System.out.println("Enter 4:show ticket");
		System.out.println("Enter 5:cancel ticket");
		System.out.println("Enter 6:logout");
		try {
			int input = sc.nextInt();
			switch (input) {
			case 1:
				addStation();
				home();
				break;
			case 2:
				System.out.println(Main.station);
//				show_station();
				System.out.println();
				home();
				break;
			case 3:
				book_ticket();
				home();
				break;
			case 4:
				show_ticket();
				home();
				break;
			case 5:
				cancel_ticket();
				home();
				break;
			case 6:
				Logout logout = new Logout();
				logout.logout();
				break;
			default:
				System.out.println("Invalid input!");
				home();
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid data type!");
			home();
		}
	}

}
