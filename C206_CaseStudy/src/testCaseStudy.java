import java.util.ArrayList;

public class testCaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//conduct tests here:
	
		 
		 ArrayList<Users> userList = new ArrayList<Users>(); 
			
			userList.add(new Users("S123","1234","Kelly",1)); //admin
			userList.add(new Users("S897","4562","Mark",2)); //teacher
			userList.add(new Users("S111","1111","Kelly",3)); //student
		
			System.out.print(userList.get(0).getName()+" "+
			userList.get(0).getPassword());
		

	}

}
