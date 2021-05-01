package opp_odev1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Category category1=new Category(1,"Donaným");
		Category category2=new Category(2,"Proglamlama");
		
		Category[]categories= {category1,category2};
		
		System.out.println(categories[0].name +" için kursumuz bulunmamaktadýr.");
		System.out.println(categories[1].name +" için 3 adet kursumuz bulunmaktadýr.");

		
		Course course1=new Course(1,"C# + Angular","Engin Demirog","Ücretsiz");
		Course course2=new Course(2,"Java + React","Engin Demirog","Ücretsiz");
		Course course3=new Course(3,"Proglamlamaya Giriþ Ýçin Temel Kurs","Engin Demirog","Ücretsiz");
		
		Course[] courses= {course1,course2,course3};
		
		for(Course course:courses) {
			System.out.println(course.courseName);
		}
		
		Evaluation evlt=new Evaluation();
		evlt.evaluateOne(course1);
		
		evlt.evaluateTwo(course2);
		

	}

}
