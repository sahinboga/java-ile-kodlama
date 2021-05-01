package oop_odev2;

public class Main {

	public static void main(String[] args) {
		
		Instructor instruc1= new Instructor(20,"Engin","Demirog","Kodlama IO",".Net Core");
		Instructor instruc2= new Instructor(21,"Sad�k","Turan","Udemy","Komple Uygulamal� Web Geli�tirme");
		
		Student student1= new Student(1,"�ahin","Bo�a","Ankara �niversitesi","Java + React");
		Student student2= new Student(2,"Yasin","Torun","Ankara �niversitesi","Java + React");
		Student student3= new Student(3,"Mutlu","Azar","Ankara �niversitesi","C# + Angular");
		
		UserManager userMng= new UserManager();
		userMng.add(student3);
		
		User[] users= {instruc1,instruc2,student1,student2,student3};
		
		userMng.addMultiple(users);
		
		userMng.delete(student1);
		
		InstructorManager instMng=new InstructorManager();
		instMng.addCourse(instruc2);
		
		StudentManager studentMng= new StudentManager();
		studentMng.takeCourse(student2);

	}

}
