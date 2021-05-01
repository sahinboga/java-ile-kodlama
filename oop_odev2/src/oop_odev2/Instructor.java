package oop_odev2;

public class Instructor extends User {
	String companyName;
	String courseNameGiven;
	
	public Instructor() {}
	public Instructor(int id,String firstName,String lastName,String companyName,String courseNameGiven) {
		super(id,firstName,lastName);
		
		this.companyName=companyName;
		this.courseNameGiven=courseNameGiven;
	}
}
