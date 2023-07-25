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
	
	private Attendance attendance1;
	private Attendance attendance2;
	private Attendance attendance3;
	
	private ArrayList<Users> userList;
	private ArrayList<Activity> activityList; 
	private ArrayList<Roles> roleList;
	private ArrayList<Attendance> attendanceList;
	ArrayList<Applications> applicationList;

	@Before
	public void setUp() throws Exception {
		//prepare test data - Yvonne
		Admin1 = new Users("A123","1234","Kelly",1); //admin
		Admin2 = new Users("A456", "4567", "Meg", 1); //admin
		Teacher1 = new Users("T789","7890","Jake",2); //teacher
		Teacher2 = new Users("T0120", "0221", "Jake", 2); //teacher
		Student1 = new Users("S555","6666","Lisa",3); //student
		Student2 = new Users("S890", "2222", "Katy", 3); //student
		
		//to add date and time when class constructor is ready
		Acti1 = new Activity(1.1,"sports","Football",25,"Open","T897","01/08/2023","15:00-17:00");
		Acti2 = new Activity(2.1,"uniformGroup","NCC SEA",60,"Open","T897","15/08/2023","14:00-17:00");
		Acti3 = new Activity(3.1,"performanceArts","Chinese Orchestra",45,"Close","T897","16/07/2023","15:00-18:00");
		apply1 = new Applications(1, 01, "S555");
		apply2 = new Applications(2, 01, "S890");
		apply3 = new Applications(3, 02, "S555"); //test whether if all can be shown instead of just under one activity ID
		
		attendance1 = new Attendance(1,"S555",1.1,"Y");
		attendance2 = new Attendance(2,"S890",1.1,"Y");
		attendance3 = new Attendance(3, "S555", 2.1, "Y");
		
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
	public void testAddUser() { //Shou Kang
		int newUserRole = Admin1.getRoleIndex();
		String newID = Admin1.getID();
		String newName = Admin1.getName();
		String newPassword = Admin1.getPassword();
		
		
		// Add an admin
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is now 1.", 1, userList.size());
		
		//Add a teacher
		
		//Add a student
		
	}
	
	@Test
	public void testViewAllUsers() { //Aliyah
		//refer to resource centre test retrieveallCamcorder
	}
	
	@Test
	public void testRemoveUser() { //Marcus,Edry
		//hope edry can guide on this
		
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
		assertNotNull("Test if valid attendancelist to add to exist", attendanceList);
		assertEquals("Test that the attendanceList is empty.", 0, attendanceList.size());
		//C206_CaseStudy.addMethodName(attendanceList, attendance1); <- to be replace with method name, now methodName does not exist.
		assertEquals("Test that the attendanceList size is 1.", 1, attendanceList.size());
		
		// Add an item
		//C206_CaseStudy.addMethodName(attendanceList, attendance2);
		assertEquals("Test that the attendanceList size is now 2.", 2, attendanceList.size());
		assertSame("Test that attendance is added to the end of the list.", attendance2, attendanceList.get(1));

		// Add an item that already exists in the list
		//C206_CaseStudy.addMethodName(attendanceList, attendance2);
		assertEquals("Test that the attendanceList size is unchange.", 2, attendanceList.size());

		// Add an item that has missing detail
		Attendance att_Missing = new Attendance(2, "", 2.1,"Y");
		//C206_CaseStudy.addMethodName(attendanceList, att_Missing);
		assertEquals("Test that the attendanceList size is unchange.", 2, attendanceList.size());
	}
	
	@Test
	public void testViewAttendance() { //Yvonne
		assertNotNull("Test if valid attendanceList exist", attendanceList);
		assertEquals("Test that the attendanceList is empty.", 0, attendanceList.size());
		
		// Attempt to retrieve the attendanceList records 
		//String allAttendance= C206_CaseStudy.getAllMethod(attendanceList);
		String testOutput = "";
		
		// Test if the output is empty
		//assertEquals("Test that nothing is displayed", testOutput, allAttendance);
		
		//----------Test Case 2
		//C206_CaseStudy.addMethod(attendanceList, attendance1);
		//C206_CaseStudy.addMethod(attendanceList, attendance2);
		
		// Test that the list is not empty
		assertEquals("Test that attendanceList size is 2.", 2, attendanceList.size());
		// Attempt to retrieve the Attendance 
		//allAttendance= C206_CaseStudy.retrieveAllMethod(attendanceList);
		testOutput = String.format("%-10d %-30s %-10.2f %-10s\n",1, "S555", 1.1, "Y");
		testOutput += String.format("%-10d %-30s %-10.2f %-10s\n",2, "S890", 1.1, "Y");
		// Test that the details are displayed correctly
		//assertEquals("Test that the display is correct.", testOutput, allAttendance);
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
