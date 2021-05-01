package oop_odev2;

public class Student extends User{
	String universityName;
	String courseNameTaken;
	
	public Student() {}
	public Student(int id,String firstName,String lastName,String universityName,String courseNameTaken) {
		super(id,firstName,lastName);
		
		this.universityName=universityName;
		this.courseNameTaken=courseNameTaken;
	}
}
