import static org.junit.Assert.*;

import java.util.AbstractMap;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest { 
	//prepare test data - Yvonne//
	private Users Admin1;
	private Users Admin2;
	private Users Admin3;
	private Users Teacher1;
	private Users Teacher2;
	private Users Teacher3;
	private Users Student1;
	private Users Student2;
	private Users Student3;
	
	private Activity Acti1;
	private Activity Acti2;
	private Activity Acti3;
	
	private Applications apply1;
	private Applications apply2;
	private Applications apply3;
	
	private Roles Role1;
	private Roles Role2;
	private Roles Role3;
	
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
				

		userList = new ArrayList<Users>(); 
		Admin3 = new Users("A345", "2345", "Helen", 1); userList.add(Admin3);
		Teacher3 = new Users("T897","4562","Mark",2); userList.add(Teacher3);
		Student3 = new Users("S908", "3232", "Kate", 3); userList.add(Student3);
		
		activityList = new ArrayList<Activity>(); 
		Acti1 = new Activity(1.1,"sports","Football",25,"Open","T789","01/08/2023","15:00-17:00"); 
		Acti2 = new Activity(2.1,"uniformGroup","NCC SEA",60,"Open","T789","15/08/2023","14:00-17:00");
		Acti3 = new Activity(3.1,"performanceArts","Chinese Orchestra",45,"Close","T789","16/07/2023","15:00-18:00");
		
		roleList = new ArrayList<Roles>() ;
		Role1 = new Roles(1, "Admin") ; roleList.add(Role1);
		Role2 = new Roles(2, "Teacher") ; roleList.add(Role2);
		Role3 = new Roles(3, "Student") ; roleList.add(Role3);
		
		attendanceList = new ArrayList<Attendance>() ;
		attendance1 = new Attendance(1,"S555",1.1); 
		attendance2 = new Attendance(2,"S890",1.1,"Attended");
		attendance3 = new Attendance(3, "S555", 2.1);
		
		applicationList = new ArrayList<Applications>();
		apply1 = new Applications(1, 1.1, "S555");
		apply2 = new Applications(2, 1.1, "S890");
		apply3 = new Applications(3, 2.1, "S555"); //test whether if all can be shown instead of just under one activity ID
		
	}
	
	@Test
	public void testLogin() { //Edry, done//
		assertNotNull("test if there is an existing user arrayList to login from",userList);
		
		String userID = Admin3.getID();
		String password = Admin3.getPassword();
		Boolean login = false; 
		int options = 123;
		int role = Admin3.getRoleIndex();
		int roleCheck = 0;
		
		//Admin login
		AbstractMap.SimpleEntry<Integer,Boolean> Admintest = C206_CaseStudy.doLogin(userID,password,login,options,role,userList);
		roleCheck = Admintest.getKey();
		assertNotEquals(roleCheck,0); 
		assertEquals(roleCheck,1); 
		
		//Teacher login
		userID = Teacher3.getID();
		password = Teacher3.getPassword(); 
		role = Teacher3.getRoleIndex() ; 
		AbstractMap.SimpleEntry<Integer,Boolean>Teachertest = C206_CaseStudy.doLogin(userID,password,login,options,role,userList);
		//write the asserts
		roleCheck = Teachertest.getKey();
		assertNotEquals(roleCheck,0);
		assertEquals(roleCheck,2);
		
		//Student login
		userID = Student3.getID(); 
		password = Student3.getPassword(); 
		role = Student3.getRoleIndex() ; 
		AbstractMap.SimpleEntry<Integer,Boolean>StudentTest = C206_CaseStudy.doLogin(userID,password,login,options,role,userList);
		//write the asserts
		roleCheck = StudentTest.getKey();
		assertNotEquals(roleCheck,0);
		assertEquals(roleCheck,3);
		
		//error login, try to login with non existing userID and password.
		userID = "sdssdfs"; //replace with the teacher 3 follow admin login 
		password = "s,jbfj dsjfds"; //same as above
		role = Teacher3.getRoleIndex() ; //replace with the respective code.
		AbstractMap.SimpleEntry<Integer,Boolean>Teachertest2 = C206_CaseStudy.doLogin(userID,password,login,options,role,userList);
		roleCheck = Teachertest2.getKey();
		//write the asserts
		assertEquals(roleCheck,0);
		assertNotEquals(roleCheck,2);
		
	}
	
	@Test
	public void testAddUser() { //Shou Kang, done-//
		int newUserRole = Admin1.getRoleIndex();
		String newID = Admin1.getID();
		String newName = Admin1.getName();
		String newPassword = Admin1.getPassword();
		
		// Add an admin
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is now 1.", 4, userList.size());
		
		//Add a teacher
		newUserRole = Teacher1.getRoleIndex();
		newID = Teacher1.getID();
		newName = Teacher1.getName();
		newPassword = Teacher1.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is now 2.", 5, userList.size());
		
		//Add a student
		newUserRole = Student1.getRoleIndex();
		newID = Student1.getID();
		newName = Student1.getName();
		newPassword = Student1.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is now 3.", 6, userList.size());
		
		//error, wrong role test
		newUserRole = Admin2.getRoleIndex();
		newID = Student2.getID();
		newName = Student2.getName();
		newPassword = Student2.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
		
		//error, Invalid role
		newUserRole = 4; //non-existent role
		newID = Student2.getID();
		newName = Student2.getName();
		newPassword = Student2.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
		
		//error, duplicate entry
		newUserRole = Student1.getRoleIndex();
		newID = Student1.getID();
		newName = Student1.getName();
		newPassword = Student1.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
		
		//error, ID not up to standard
		newUserRole = Student2.getRoleIndex();
		newID = "S12"; //ID must be 4 characters 
		newName = Student2.getName();
		newPassword = Student2.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
		
		//error, Invalid name
		newUserRole = Student2.getRoleIndex();
		newID = Student2.getID(); 
		newName = "Mayr12312"; //name can only contain alphabets
		newPassword = Student2.getPassword();
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
		
		//error, password not up to standard
		newUserRole = Student2.getRoleIndex();
		newID = Student2.getID(); 
		newName = Student2.getName(); 
		newPassword = "123"; //password minimum is 4 characters
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
		
		//error, invalid password
		newUserRole = Student2.getRoleIndex();
		newID = Student2.getID(); 
		newName = Student2.getName(); 
		newPassword = "S12312"; //password can only contain numbers
		
		C206_CaseStudy.addUser(userList, newUserRole, newID, newName, newPassword);
		assertEquals("Test that the userlist size is still 3.", 6, userList.size());
	}
			
	@Test
    public void testViewAllUsers() { //Aliyah, Edry, done
        //Test if User List is not null but empty -boundary
        assertNotNull("Test if there is valid User arraylist to retrieve users", userList) ;
              
        String allUsers= C206_CaseStudy.displayAllUsers(roleList, userList);
        
        String testOutput = String.format("%-8s %4s","A345", "") ;
		testOutput += String.format("%-10s %4s","Helen", "") ;
		testOutput += String.format("%s", "Admin") ;
		
		testOutput += String.format("%-8s %4s","T897", "") ;
		testOutput += String.format("%-10s %4s","Mark", "") ;
		testOutput += String.format("%s", "Teacher") ;
		
		testOutput += String.format("%-8s %4s","S908", "") ;
		testOutput += String.format("%-10s %4s","Kate", "") ;
		testOutput += String.format("%s", "Student") ;
        
        assertEquals("Check that ViewAllUsers", testOutput, allUsers);
         

    } 
	
	@Test
	public void testRemoveUser() { //Marcus,Edry, done
		String userID = Student3.getID(); 

		boolean userFound = C206_CaseStudy.removeUser(userList, userID); 
		assertTrue("Test if user has been deleted successfully",userFound);
		
		
	}
	
	
	@Test
	public void testAddActivities(){ //Yvonne, done
		assertNotNull("Test if there is valid Activity arrayList to retrieve activities", activityList);
		assertEquals("Test that the Activity arrayList is empty,",0,activityList.size());
		String userID = "T789";
		double newDID = Acti1.getActivityID();
		String newType = Acti1.getType();
		String newName = Acti1.getName();
		int newMaxPax = Acti1.getMaxPax();
		String newDate = Acti1.getDate();
		String newTimeSlot = Acti1.getTimeSlot();
		
		C206_CaseStudy.addNewActivity(userID,activityList,newDID,newType,newName,newMaxPax,newDate,newTimeSlot);
		C206_CaseStudy.showAllActivities(activityList);
		
		assertEquals("Test that activity arrayList size is 1", 1, activityList.size());
		
	}
	
	@Test
	public void testdeleteActivities(){ //Yvonne, done
		assertNotNull("Test if there is valid Activity arrayList to retrieve activities", activityList);
		activityList.add(Acti1);
		assertEquals("Test that activity arrayList size is 1", 1, activityList.size());
		double activityInput = Acti1.getActivityID();
		boolean testDel = C206_CaseStudy.removeActivity(activityList, activityInput);
		assertTrue("Test that item has been deleted",testDel);
		assertEquals("Test that activity arrayList size is 0", 0, activityList.size());
		
		
	}
	
	
	@Test
	public void testViewAllActivities() { //Alex, Edry,done
		assertNotNull("Test if there is valid Activity arrayList to retrieve activities", activityList);
		assertEquals("Test that the Activity arrayList is empty,",0,activityList.size());
		activityList.add(Acti1);
		activityList.add(Acti2); 
		assertEquals("Test that activity arrayList size is 2", 2, activityList.size());
		
		String testCase = C206_CaseStudy.showAllActivities(activityList);
		
		String output = "";
		
		output = String.format("%-12s %4s",1.1,"") ;
		output += String.format("%-20s %4s","Football","") ;
		output += String.format("%-15s %4s","sports","") ;
		output += String.format("%-8s %4s",25,"") ;
		output += String.format("%-7s %4s","Open","") ;
		output += String.format("%-10s %4s","01/08/2023","") ;
		output += String.format("%-13s %4s","15:00-17:00","") ;
		output += String.format("%s","T789") ;
		
		output += String.format("%-12s %4s",2.1, "") ;
		output += String.format("%-20s %4s","NCC SEA", "") ;
		output += String.format("%-15s %4s","uniformGroup", "") ;
		output += String.format("%-8s %4s",60, "") ;
		output += String.format("%-7s %4s","Open","") ;
		output += String.format("%-10s %4s","15/08/2023","") ;
		output += String.format("%-13s %4s","14:00-17:00","") ;
		output += String.format("%s","T789") ;
		
		assertEquals("Test that the display is correct.",output,testCase);
	}
	
	@Test
	public void testViewApplicationStatus() { //Yvonne, done
		assertNotNull("Test if valid attendancelist to add to exist", applicationList);
		String userID = "T789";
		activityList.add(Acti1);
		userList.add(Teacher1);
		userList.add(Student1);
		applicationList.add(apply1);
		
		//test for teacher's output if correctly displayed.
		String testOutput = C206_CaseStudy.showApplications4Teach(userID, applicationList, activityList, userList);
		String output = String.format("%-18d%-15s%-15s %-15s %-15s %-15s\n", 1, 1.1 ,"Football","S555", "Lisa", "pending");
		
		assertEquals("Test that activity arrayList size is 1", 1, applicationList.size());
		assertEquals("Test that the display is correct.",output,testOutput);
		
		//test for student's output if correctly displayed
		String userID2 = "S555";
		String testOutput2 = C206_CaseStudy.showApplications4Student(userID2, applicationList, activityList, userList);
		String output2 = String.format("%-18d%-15s%-15s %-15s %-15s %-15s\n", 1, 1.1 ,"Football","S555", "Lisa", "pending");
		
		assertEquals("Test that activity arrayList size is 1", 1, applicationList.size());
		assertEquals("Test that the display is correct.",output2,testOutput2);
		
	}
	
	@Test
	public void testAcceptApplication() { //marcus, Shou Kang, done//
		assertNotNull("Test if there is a valid application arraylist", applicationList);
		
		activityList.add(Acti1);
		userList.add(Teacher1);
		userList.add(Student1);
		attendanceList.add(attendance1);
		applicationList.add(apply1);
		String userID = Teacher1.getID();
		int appliID = apply1.getAppId();
		
		C206_CaseStudy.chgAppliStatus(userID, appliID , activityList, applicationList, userList, attendanceList, "Y");
		String status = apply1.getStatus();
		assertEquals("Test if the application is approved","Approved",status);
		
	}
	
	@Test
	public void testRejectApplication() { //Aliyah, done
		assertNotNull("Test if valid applicationList exist", applicationList) ;
		
		activityList.add(Acti1);
		userList.add(Teacher1);
		userList.add(Student1);
		attendanceList.add(attendance1);
		applicationList.add(apply1);
		String userID = Teacher1.getID();
		int appliID = apply1.getAppId();
		
		C206_CaseStudy.chgAppliStatus(userID, appliID, activityList, applicationList, userList, attendanceList,"N") ;
		String status = apply1.getStatus();
		assertEquals("Rejected", status); 
	}
	
	@Test
	public void testMarkAttendance() { //Yvonne, done
		assertNotNull("Test if valid attendancelist to add to exist", attendanceList);
		String userID = Teacher1.getID();
		activityList.add(Acti1);
		userList.add(Teacher1);
		userList.add(Student1);
		attendanceList.add(attendance1);

		
		assertEquals("Test that the attendanceList is 1", 1, attendanceList.size());
		
		//Test if attendance is marked
		int attendanceID = attendance1.getAttendanceId();
		double activityID = attendance1.getActivityId();
			
		boolean test1 = C206_CaseStudy.markAttendance(userID,attendanceID,activityID, attendanceList, activityList, userList); 
		assertTrue("Test if the attendance has been marked",test1);
		

		// Test if reject a non existent attendance marking
		attendanceID = attendance2.getAttendanceId();
		activityID = attendance2.getActivityId();
		
		boolean test2 = C206_CaseStudy.markAttendance(userID,attendanceID,activityID, attendanceList, activityList, userList); 
		assertFalse("Test if the attendance has been marked",test2);

	}
	
	@Test
	public void testViewAttendance() { //Yvonne, done
		assertNotNull("Test if valid attendanceList exist", attendanceList);
		
		activityList.add(Acti1);
		userList.add(Teacher1);
		userList.add(Student1);
		attendanceList.add(attendance1);
		String userID = Student1.getID();
		assertEquals("Test that the attendanceList is not empty.", 1, attendanceList.size());
		
		// Attempt to retrieve the Attendance 
		String allAttendance= C206_CaseStudy.viewAttendanceRecord(userID, attendanceList, userList, activityList);
		String testOutput = String.format("%s %11s", "S555", "") ;
		testOutput += String.format("%-10s %7s", "Lisa", "") ;
		testOutput += String.format("%-18s %s","Football", "") ;
		testOutput += String.format("%-3s", "Not Attended" );
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allAttendance);
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
