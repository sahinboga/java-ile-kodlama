package opp_odev1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Category category1=new Category(1,"Donan�m");
		Category category2=new Category(2,"Proglamlama");
		
		Category[]categories= {category1,category2};
		
		System.out.println(categories[0].name +" i�in kursumuz bulunmamaktad�r.");
		System.out.println(categories[1].name +" i�in 3 adet kursumuz bulunmaktad�r.");

		
		Course course1=new Course(1,"C# + Angular","Engin Demirog","�cretsiz");
		Course course2=new Course(2,"Java + React","Engin Demirog","�cretsiz");
		Course course3=new Course(3,"Proglamlamaya Giri� ��in Temel Kurs","Engin Demirog","�cretsiz");
		
		Course[] courses= {course1,course2,course3};
		
		for(Course course:courses) {
			System.out.println(course.courseName);
		}
		
		Evaluation evlt=new Evaluation();
		evlt.evaluateOne(course1);
		
		evlt.evaluateTwo(course2);
		

	}

}
