package opp_odev1;

public class Course {
	public Course() {}
	
	public Course(int id,String courseName, String instructor, String detail) {
		this.id=id;
		this.courseName=courseName;
		this.instructor=instructor;
		this.detail=detail;
	}
	
	int id;
	String courseName;
	String instructor;
	String detail;

}
