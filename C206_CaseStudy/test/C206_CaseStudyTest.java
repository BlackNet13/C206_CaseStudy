import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest { //Edry will be supervisor of junit test cases as he has more experience in this, he will check, help and prune
	//prepare test data - Yvonne
	private Users Admin1;
	private Users Admin2;
	private Users Teacher1;
	private Users Teacher2;
	private Users Student1;
	private Users Student2;
	
	private Activity Acti1;
	private Activity Acti2;
	private Activity Acti3;
	
	private Applications apply1;
	private Applications apply2;
	private Applications apply3;
	
	private ArrayList<Users> userList;
	private ArrayList<Activity> activityList; 
	private ArrayList<Roles> roleList;
	private ArrayList<Attendance> attendanceList;
	ArrayList<Applications> applicationList;

	@Before
	public void setUp() throws Exception {
		//prepare test data - Yvonne
		Admin1 = new Users("S123","1234","Kelly",1); //admin
		Admin2 = new Users("S456", "4567", "Meg", 1); //admin
		Teacher1 = new Users("S789","7890","Jake",2); //teacher
		Teacher2 = new Users("S0120", "0221", "Jake", 2); //teacher
		Student1 = new Users("S555","6666","Lisa",3); //student
		Student2 = new Users("S890", "2222", "Katy", 3); //student
		
		//to add date and time when class constructor is ready
		Acti1 = new Activity(1.1,"sports","Football",25,"Open","S897","01/08/2023","15:00-17:00");
		Acti2 = new Activity(2.1,"uniformGroup","NCC SEA",60,"Open","S897","15/08/2023","14:00-17:00");
		Acti3 = new Activity(3.1,"performanceArts","Chinese Orchestra",45,"Close","S897","16/07/2023","15:00-18:00");
		apply1 = new Applications(1, 01, "S555");
		apply2 = new Applications(2, 01, "S890");
		apply3 = new Applications(3, 02, "S555"); //test whether if all can be shown instead of just under one activity ID
		
		userList = new ArrayList<Users>(); 
		activityList = new ArrayList<Activity>(); 
		roleList = new ArrayList<Roles>() ;
		attendanceList = new ArrayList<Attendance>() ;
		applicationList = new ArrayList<Applications>();
		
	}
	
	@Test
	public void testLogin() { //Edry
		//boolean test similiar to resource centre test in testDoLoan
	}
	
	@Test
	public void testAddAdmin() { //Shou Kang
		//refer to resource centre test in testAddChromebook
		
	}
	
	@Test
	public void testAddTeacher() { //Shou Kang
		//refer to resource centre test in testAddChromebook
		
	}
	
	@Test
	public void testAddStudent() { //Shou Kang
		//refer to resource centre test in testAddChromebook
		
	}
	
	@Test
	public void testViewAllUsers() { //Aliyah
		//refer to resource centre test retrieveallCamcorder
	}
	
	@Test
	public void testRemoveAdmin() { //Marcus,Edry
		//hope edry can guide on this
		
	}
	
	@Test
	public void testRemoveTeacher() { //Marcus,Edry
		
		
	}
	
	@Test
	public void testRemoveStudent() { //Marcus,Edry
		
		
	}
	
	@Test
	public void testViewAllActivities() { //Alex, Edry
		//refer to resource centre test retrieveallCamcorder but might be more complex
	}
	
	@Test
	public void testViewApplicationStatus() { //Aliyah
		
	}
	
	@Test
	public void testAcceptApplication() { //Alex, Edry
		
	}
	
	@Test
	public void testRejectApplication() { //Aliyah
		
	}
	
	@Test
	public void testAddAttendance() { //Yvonne
		
	}
	
	@Test
	public void testViewAttendance() { //Yvonne
		
	}
	
	
	
	

	@After
	public void tearDown() throws Exception {
		//Yvonne
		Admin1 = null;
		Admin2 = null;
		Teacher1 = null;
		Teacher2 = null;
		Student1 = null;
		Student2 = null;
		Acti1 = null;
		Acti2 = null;
		Acti3 = null;
		apply1 = null;
		apply2 = null;
		apply3 = null;
		
		userList = null;
		activityList = null;
		roleList = null;
		attendanceList = null;
		applicationList = null;
	}

}
