package RailwayTicketManagement;

public class Ticket {
	String name;
	String gender;
	int age;
String from_station;
String to_station;
double price;
long pnr;

Ticket(String name,String gender,int age,String from_station,String to_station,double price,long pnr){
	this.name = name;
	this.gender = gender;
	this.age = age;
	this.from_station = from_station;
	this.to_station = to_station;
	this.price = price;
	this.pnr = pnr;
}
}
