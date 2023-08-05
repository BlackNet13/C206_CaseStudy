import java.util.AbstractMap;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		/*flow:
		 * 1.login -> show different menu choices
		 * 
		 * 1.1: admin: 
		 * -view all user list(1st sprint)
		 * -add(1st sprint)/update(2nd sprint) user -> input student/teacher/admin Id, pw, name, role(role list with role name) -> if user exist, ask if want to update each field
		 * -remove user(1st sprint) -> removes related ccas -> confirmation screen 
		 * 
		 * 1.2:teacher:
		 * -Browse activity(1st sprint)(even those from other teachers,activity list) teacher name
		 * -add(1st sprint:)/update(2nd sprint) activity (only can add their own) --> input activityName, maxDate, maxPax, status(open/closed/draft), teacherID ,activityID
		 * -remove activity(1st sprint)(only can delete their own)
		 * -manage student applications(1st sprint:approved & viewing)[number of students waiting for approval] ->1.accept/reject students(shows list of students that applied and is of pending status)->will cycle through students, approve/reject
		 * -Remove student application(1st sprint: delete for both, will remove attendance as well if created)
		 * -Mark attendance(1st sprint: add) -> view all students(show all students it will show each activity's list of students ordered by activity group) -> show activity name, student name and id before and adding of attendance, mark attendance ->input date(searches for activity for that teacher for that day, show student name and id, retrieves from attendance list based on student id,activity id,date)-> cycles through students to mark attendance
		 * -Delete attendance(1st sprint: remove)
		 *
		 * 
		 * 1.3:student:
		 * -Browse activity(shows all)
		 * -apply for activities(1st sprint: add) -> input activity ID (shows list of activities and their status(open/closed))-> if successful will show that they have to wait for approval
		 * -application status(1st sprint: viewing)/notifications(number of notifications) -> show applications and notifications(reminders)
		 * -attendance record(1st sprint: view) -> show list of activities enrolled in and their attendance status and completion rate(generated%)
		 * 
		 */
		
		//to create:
		/*java class:
		 * 1.users(Shou Kang) : userid(Str), pw(Str), name(Str), roleid(int)
		 * 2.roles(Aliyah) : roleid(int),rolename(str)
		 * 3.activity(Edry) : activityid(double), type(string), name(String) totalCCAdays(int), maxPax(int), status(String, open/closed),teacherid(str), date(str), time(str)
		 * 4.applications(Marcus) : applicationid(int), activityid(double),studentid(Str), status(string,start as pending, filled with approved/rejected/pending) 
		 * 5.attendance(Alex) :  attendanceid(int), studentid(string), activityid(double),attended(String, Y or N)
		 * 
		 * arraylist: 
		 * 1.userList (all users indexed with same fields)~
		 * 2.roleList (defines the roles with index and name) /done
		 * 3.activityList ~
		 * 4.applicationList 
		 * 5.attendanceList
		 * 
		 */
		
		/*Perma updates:
		 * -remove admin's view all roles
		 * -remove admin's update function as it is sprint1
		 * -combine view all activities with add activities
		 * -default status for application will be pending.
		 * 
		 */
		
		/*-------------------------------------*/
		
		//initialize all class objects here:
		
		
		//initialize the userList, done by Shou Kang
		ArrayList<Users> userList = new ArrayList<Users>(); 
		
		userList.add(new Users("A123","1234","Kelly",1)); //admin
		userList.add(new Users("T897","4562","Mark",2)); //teacher 
		userList.add(new Users("S111","1111","Kelly",3)); //student
		userList.add(new Users("A345", "2345", "Helen", 1)); //admin
		userList.add(new Users("T567", "6543", "Jake", 2)); //teacher
		userList.add(new Users("S908", "3232", "Kate", 3)); //student
		userList.add(new Users("S121", "1234", "Shale", 3)); //student
		userList.add(new Users("S123", "1234", "Arnold", 3)); //student
		userList.add(new Users("S432", "1234", "Rika", 3)); //student
		userList.add(new Users("S324", "1234", "Marty", 3)); //student
		userList.add(new Users("S897", "1234", "Abigail", 3)); //student

		
		//initialize the activityList, done by Edry, add date, time
		ArrayList<Activity> activityList = new ArrayList<Activity>(); 
		
		activityList.add(new Activity(1.1,"sports","Football",25,"Open","T897","01/08/2023","15:00-17:00"));
		activityList.add(new Activity(1.2,"sports","Football", 25,"Open","T897","02/08/2023","14:00-16:00"));
		activityList.add(new Activity(2.1,"uniformGroup","NCC SEA",60,"Open","T567","15/08/2023","14:00-17:00"));
		activityList.add(new Activity(3.1,"performanceArts","Chinese Orchestra",45,"Close","T567","16/07/2023","15:00-18:00"));

		//type = sports, uniformGroup, performanceArts
		//totalDays = total cca days in a month, so if once a week will be 4 as in a month got four weeks. 
		//maxpax = maximum people for cca
		//teacher id must be from existing userid that have teacher's role
		
		
		//initialize roleList, done by Aliyah /done//
		ArrayList<Roles> roleList = new ArrayList<Roles>() ;
		
		roleList.add(new Roles(1, "Admin")) ;
		roleList.add(new Roles(2, "Teacher")) ;
		roleList.add(new Roles(3, "Student")) ;
		
		//initialize attendanceList, done by Alex
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>() ;
		attendanceList.add(new Attendance(1, "S123", 1.1));
		attendanceList.add(new Attendance(2, "S432", 1.2));
		attendanceList.add(new Attendance(3, "S324", 2.1));
		attendanceList.add(new Attendance(4, "S897", 3.1));
		
		
		
		//initialize applicationList, done by Marcus
		ArrayList<Applications> applicationList = new ArrayList<Applications>();
		applicationList.add(new Applications(1,1.1 ,"S123","Approved"));
		applicationList.add(new Applications(2,1.2,"S432","Approved"));
		applicationList.add(new Applications(3,2.1,"S324","Approved"));
		applicationList.add(new Applications(4,3.1,"S897","Approved"));
		applicationList.add(new Applications(5, 1.1, "S111"));
		applicationList.add(new Applications(6, 2.1, "S908"));
		applicationList.add(new Applications(7, 1.2, "S908"));
		applicationList.add(new Applications(8, 3.1, "S121"));
		
		
		
		boolean login = false; 
		int options = 123;
		int role = 0;
		String userID ="";
		String password ="";
		String idInpt = "0";
			
		login(userList, roleList, activityList, applicationList, attendanceList ,login, options, role, userID, password, idInpt);
		
		System.out.println("\nProgram Exited");
		
	}

	//code done by Shou Kang and Yvonne
	public static void login(ArrayList<Users> userList, ArrayList<Roles> roleList, ArrayList<Activity> activityList, ArrayList<Applications> applicationList,ArrayList<Attendance> attendanceList, boolean login, int options,
			int role, String userID, String password, String idInpt) {
		
		//for initializing of variable of new user, for junitTesting workaround
				int newUserRole = 0;
				String newID = "-";
				String newName = "-";
				String newPassword = "-";
		
		while(options != -9) {
				
			
			if(login == false) {
				loginMenu();
				
				options = Helper.readInt("Enter Menu Option (type -9 to exit program) > ");
				
				if(options == 1) {
					
					userID = Helper.readString("Enter user ID > ");
					password = Helper.readString("Enter password > ");
					
					AbstractMap.SimpleEntry<Integer,Boolean> pair =doLogin(userID,password,login,options,role,userList);
					role = pair.getKey();
					login = pair.getValue();

				}else if(options!= -9){
					System.out.println("\nPlease enter a correct option");
				}else{				
					break;
				}
				
			}   //Yvonne
				options = userMenus(role);
				if(options!=-8) {
				if(role == 1) { //admin
					switch(options) {
					case 1: //view all users code here, Aliyah, done//
						//<<Insert code here:>>
						
						displayAllUsers(roleList, userList) ;
						
						//<<end of code for case 1>>
						//System.out.print("admin1"); //<--this is just to test that it can reach this lvl before you start coding
						break;
					case 2: //add users code here, Shou Kang, Done//
						//<<Insert code here:>>
						addUser(userList,newUserRole, newID, newName, newPassword);

						//<<end of code for case 2>>
						break;
					case 3: //remove users code here,Marcus, done//
						//<<Insert code here:>>
						boolean userfound = true;
						displayAllUsers(roleList, userList) ;
						System.out.println();
						
						userfound = removeUser(userList,idInpt);
						if(!userfound) {
							System.out.println("Invalid userId!");
							
						}
						
						//<<end of code for case 3>>
//						System.out.print("admin3"); //<--this is just to test that it can reach this lvl before you start coding
						break;
						
					default: 
						
						if(options != -9) {
							System.out.println("\nPlease enter a proper option");
						}
						
						break; 
					}
					
					
				}else if(role == 2) {
					switch(options) { //teacher
					case 1: //Browse activities code here, Edry, Alex , done//
						//<<Insert code here:>>
						showAllActivities(activityList);
					
						//<<end of code for case 1>>
						//System.out.print("teach1");
						break;
					case 2: //add activities(that they owned)code here, Aliyah, error in addNewActivity
						//show activities that they owned first
						//<<Insert code here:>>
						showOwnActivties(userID, activityList) ;							
						
						addNewActivity(userID, activityList) ;
						//<<end of code for case 2>>
						//System.out.print("teach2");
						break;
					case 3: //remove activities that they owned code here, Alex,Edry, done//
						//<<Insert code here:>>
						showOwnActivties(userID, activityList) ;
						
						removeActivity(userID,activityList);
						
						
						//<<end of code for case 3>>
						//System.out.print("teach3");
						break;
					case 4: //manage student applications code here, Yvonne, done//
						//<<Insert code here:>>
						showApplications4Teach(userID, applicationList, activityList, userList);
						
						int appIdToChg = Helper.readInt("Please enter the application ID to change status > ");
						chgAppliStatus(userID, appIdToChg,activityList,applicationList,userList,attendanceList);
						
						
						//<<end of code for case 4>>
						//System.out.print("teach4");
						break;
					case 5: //Remove applications code here, Shou Kang 
						//<<Insert code here:>>

						showApplications4Teach(userID, applicationList, activityList, userList);
						int appIdToRemove = Helper.readInt("Please enter the application ID to remove > ");
						removeApplication(userID, appIdToRemove, activityList, applicationList);
						
						//<<end of code for case 5>>
						break;
						
					case 6: //Mark attendance code here, Marcus,Shou Kang,done//
						//<<Insert code here:>>
						
						showOwnActivties(userID, activityList) ;	
						double activityID = Helper.readDouble("Enter activity code > ");
						showAllStudentInActivity(userID, activityID, attendanceList, activityList, userList);
						int attendanceId = Helper.readInt("Enter attendance id > ");
						markAttendance(userID, attendanceId, activityID,attendanceList, activityList, userList);		
								
						//<<end of code for case 6>>
						break;
					case 7: //Delete attendance code here, Shou Kang
						//<<Insert code here:>>
						// it says delete but what we want to do here is just set it back to not attended, so if the status of the attendance is
						//already not attended , we will just show a message that says attendance have not been marked as attended instead
						
						
						//<<end of code for case 7>>
						System.out.print("teach7");
						break;
					default: 
						if(options != -9) {
							System.out.println("\nPlease enter a proper option");
						}
						break; 
					}
					
				}else if(role == 3) { //students
					switch(options) {
					case 1: //Browse activities code here, Alex
						//<<Insert code here:>>
						
						//just copy and paste: showAllAactivities(activityList);
						
						//<<end of code for case 1>>
						System.out.print("student1");
						break;
					case 2: //apply for activities code here,Yvonne//
						//<<Insert code here:>>
						showAllActivities(activityList);
						
						apply4Activity(activityList, applicationList, userID);
						
						//<<end of code for case 2>>
						//System.out.print("student2");
						break;
					case 3: //view application status code here,Yvonne
						//<<Insert code here:>>
						
						showApplications4Student(userID, applicationList, activityList, userList);
						
						//<<end of code for case 3>>
 						//System.out.print("student3");
						break;
					case 4: //view attendance record code here,Aliyah
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 4>>
						System.out.print("student4");
						break;
					default: 
						if(options != -9) {
							System.out.println("\nPlease enter a proper option");
						}
						break; 
				}
					
				}}else {
					login =false;
					System.out.print("You have log out successfully");
				}
				

		}
	}

	//Yvonne, apply for activity method for students
	public static void apply4Activity (ArrayList<Activity> activityList, ArrayList<Applications> applicationList,
			String userID) {
		double activityIDinpt = Helper.readDouble("Enter activity ID to apply >");
		
		for(int i = 0; i<activityList.size(); i++) {
			if(activityList.get(i).getActivityID() == activityIDinpt && activityList.get(i).getStatus().equals("Open")) {
				String activityName = activityList.get(i).getName();
				String confirm = Helper.readString("Confirm, Applying for " + activityIDinpt + " " + activityName + " ? (Y/N)").toUpperCase();
				if(confirm.equals("Y")) {
					applicationList.add(new Applications(applicationList.size(),activityIDinpt ,userID));
					System.out.println("\nYour application to " + activityIDinpt + " " + activityName + "has been submitted\n\nPlease wait for your teacher to approve");
				}else if(confirm.equals("N")) {
					System.out.println("Your application process has been cancelled");
				}
				
			}
		}
	}
	
	// Shou Kang code, login Menu
	public static void loginMenu(){
		System.out.println();
		Helper.line(45,"=");
		System.out.println("==== LOGIN MENU ====");
		Helper.line(45,"=");
		
		System.out.println("1. Login");
		System.out.println("-9. Exit program");
		System.out.println();
	}
	
	
	//Shou Kang code, userMenus
	public static int userMenus(int roleIndex) {
		int options = 0;
		if(roleIndex == 1) {
			System.out.println();
			Helper.line(45,"=");
			System.out.println("==== ADMIN MENU ====");
			Helper.line(45,"=");
			
			System.out.println("1. View all users");
			System.out.println("2. Add user"); //update was remove
			System.out.println("3. Remove user");
			System.out.println("-8. Logout");
			System.out.println("-9. Exit program");
			System.out.println();
			
			options = Helper.readInt("Enter option number > ");
			
			
		}
		else if(roleIndex == 2){
			System.out.println();
			Helper.line(45,"=");
			System.out.println("==== TEACHER MENU ====");
			Helper.line(45,"=");
			
			System.out.println("1. Activity overview");
			System.out.println("2. Add Activities"); //show activities and add as well
			System.out.println("3. Remove activites");
			System.out.println("4. Manage Student's Applications");
			System.out.println("5. Remove Student's Applications");
			System.out.println("6. Mark Attendance");
			System.out.println("7. Delete Attendance");
			System.out.println("-8. Logout");
			System.out.println("-9. Exit program");
			System.out.println();
			
			options = Helper.readInt("Enter option number > ");
			
		}
		else if(roleIndex == 3) {
			System.out.println();
			Helper.line(45,"=");
			System.out.println("==== STUDENT MENU ====");
			Helper.line(45,"=");
			
			System.out.println("1. View all activities");
			System.out.println("2. Register for activity");
			System.out.println("3. Application Status");
			System.out.println("4. View attendance records");
			System.out.println("-8. Logout");
			System.out.println("-9. Exit program");
			System.out.println();
			
			options = Helper.readInt("Enter option number > ");
		}
		return options;
	}
	
	//Aliyah code, displays userList
	public static void displayAllUsers(ArrayList<Roles> roleList, ArrayList<Users> userList) {
		System.out.println() ;
		Helper.line(45, "=");
		System.out.println("=======     USER LIST     =======");
		Helper.line(45, "=");
		System.out.println() ;
		
		String table = String.format("%s %5s", "User ID", " ") ;
		table += String.format("%s %5s", "User Name", " ") ;
		table += String.format("%s", "User Role") ;
		
		System.out.println(table) ;
		Helper.line(45, "-");
		
		for (int i = 0; i < userList.size(); i++) {
			Users u = userList.get(i) ;
			for (int j = 0; j < roleList.size(); j++) {
				Roles r = roleList.get(j) ;

				if (u.getRoleIndex() == r.getRoleID()) {					
					String roleName = r.getRoleName() ;
					
					String output = String.format("%-8s %4s", u.getID(), "") ;
					output += String.format("%-10s %4s", u.getName(), "") ;
					output += String.format("%s", roleName) ;
					
					System.out.println(output) ;
					break ;
				}
			}			
		}
		
	}	
	
	//Shou kang code
	public static boolean idChecker(ArrayList<Users> userList, String id) {
		boolean exist = false;
		
		for(int i = 0; i < userList.size(); i++) {
			String userListID = userList.get(i).getID();
			
			if(id.equals(userListID)) {
				exist = true;
				break; 
			}
		}
		
		return exist; 
	}
	
	//Shou kang code
	public static String regexReturn(int roleIndex) {
		String regex = "";
		
		switch(roleIndex) {
		
		case 1:
			regex = "[A][0-9]+";
			break;	
			
		case 2:
			regex = "[T][0-9]+";
			break;
			
		case 3:
			regex = "[S][0-9]+";
			break;
			
		default:	
			regex = "";
		}

		return regex; 

	}
	 //Shou Kang code

	public static void addUser(ArrayList<Users> userList , int newUserRole, String newID, String newName, String newPassword) {
		String nameRegex = "[a-zA-Z]+";
		String passwordChecker = "[0-9]+";
		
		if(newUserRole == 0) {
			newUserRole = Helper.readInt("Enter new user role > ");
		}
		
		
		String regex = regexReturn(newUserRole);
		
		if(!regex.equals("")) {
			if(newID.equals("-")) {
				newID = Helper.readString("Enter new users id > ");
			}
			newID = newID.toUpperCase();
			
			if(newID.length() == 4) {
				
				if(idChecker(userList, newID) == false) {
													
					if(newID.matches(regex)) {
						if(newName.equals("-")) {
							newName = Helper.readString("Enter the new user's name > ");
						}
						String nameChecker = newName.replace(" ", "");
					
						if(nameChecker.matches(nameRegex)) {
							if(newPassword.equals("-")) {
								newPassword = Helper.readString("Enter the new user's password > ");
							}
							
							if(newPassword.length() >= 4) {
							
								if(newPassword.matches(passwordChecker)) {
									userList.add(new Users(newID, newPassword, newName, newUserRole));
									System.out.println("\nNew user has been added");
								}
								else {
									System.out.println("\nInvalid password");
								}
							}
							else {
								System.out.println("\nInvalid password");
							}
						}
						else {
							System.out.println("\nPlease enter a proper name");
						}
					}
					else {
						System.out.println("\nInvalid id was entered");
					}
				}
				else {
					System.out.println("\nID already exists");
				}

			}
			else {
				System.out.println("\nInvalid id was entered");
			}
			
		}
		else {
			System.out.println("\nInvalid role was entered");
		}
	}
	
	//Marcus code, remove user
	public static boolean removeUser(ArrayList<Users>userList, String idInput) {
		boolean userfound = false;
		if(idInput == "0") {
			idInput = Helper.readString("Enter User ID to be deleted > ");
		}
		for (int i = 0; i< userList.size(); i++) {
			if (userList.get(i).getID().equalsIgnoreCase(idInput)) {
				userList.remove(i);
				System.out.println("Successfully deleted User with User ID " + idInput);
				userfound = true;
			}
			else {
				
				userfound = false;
			}
		}
		return userfound;
		
		
	}
	
	// Edry Code, show all Activities
	public static void showAllActivities( ArrayList<Activity> activityList) {
		System.out.println() ;
		Helper.line(45, "=");
		System.out.println("=======     ALL ACTIVITY LIST     =======");
		Helper.line(45, "=");
		System.out.println() ;
		
		String table = String.format("%s %5s", "Activity ID", " ") ;
		table += String.format("%s %11s", "Activity Name", " ") ;
		table += String.format("%s %11s", "Category", " ") ;
		table += String.format("%s %5s", "Max Pax", " ") ;
		table += String.format("%s %5s", "Status", " ") ;
		table += String.format("%s %10s", "Date", " ") ;
		table += String.format("%s %8s", "Time Slot", " ") ;
		table += String.format("%s", "Teacher ID") ;
		
		System.out.println(table);
		Helper.line(130, "-");
		
		for (int j = 0; j < activityList.size(); j++) {
			Activity a = activityList.get(j);
			
			
			String output = String.format("%-12s %4s", a.getActivityID(), "") ;
			output += String.format("%-20s %4s", a.getName(), "") ;
			output += String.format("%-15s %4s", a.getType(), "") ;
			output += String.format("%-8s %4s", a.getMaxPax(), "") ;
			output += String.format("%-7s %4s", a.getStatus(), "") ;
			output += String.format("%-10s %4s", a.getDate(), "") ;
			output += String.format("%-13s %4s", a.getTimeSlot(), "") ;
			output += String.format("%s", a.getTeacherID()) ;
			
			System.out.println(output) ;

		}
		
	}
	
	//Aliyah code, show all owned activities
	public static void showOwnActivties(String userID, ArrayList<Activity> activityList) {
		System.out.println() ;
		Helper.line(45, "=");
		System.out.println("=======       OWN ACTIVITY LIST       =======");
		Helper.line(45, "=");
		System.out.println() ;
		
		String table = String.format("%s %5s", "Activity ID", " ") ;
		table += String.format("%s %11s", "Activity Name", " ") ;
		table += String.format("%s %11s", "Category", " ") ;
		table += String.format("%s %5s", "Max Pax", " ") ;
		table += String.format("%s %5s", "Status", " ") ;
		table += String.format("%s %10s", "Date", " ") ;
		table += String.format("%s %8s", "Time Slot", " ") ;
		table += String.format("%s", "Teacher ID") ;
		
		System.out.println(table) ;
		Helper.line(130, "-");
		
			for (int j = 0; j < activityList.size(); j++) {
				Activity a = activityList.get(j) ;
				
				if (userID.equalsIgnoreCase(a.getTeacherID())) {

					String output = String.format("%-12s %4s", a.getActivityID(), "") ;
					output += String.format("%-20s %4s", a.getName(), "") ;
					output += String.format("%-15s %4s", a.getType(), "") ;
					output += String.format("%-8s %4s", a.getMaxPax(), "") ;
					output += String.format("%-7s %4s", a.getStatus(), "") ;
					output += String.format("%-10s %4s", a.getDate(), "") ;
					output += String.format("%-13s %4s", a.getTimeSlot(), "") ;
					output += String.format("%s", a.getTeacherID()) ;
					
					System.out.println(output) ;
				}
			}
		}
	
	//Aliyah code, adding new activity
	public static void addNewActivity(String userID, ArrayList<Activity> activityList) {
		for (int i = 0; i < activityList.size(); i++) {
			Activity a = activityList.get(i) ;
			Double newID = Helper.readDouble("\nEnter new activity ID > ") ;
			if (!newID.equals(a.getActivityID())) {
				String newType = Helper.readString("Enter new activity type > ") ;
				if ((newType.equalsIgnoreCase("sports")) || (newType.equalsIgnoreCase("uniformGroup")) || (newType.equalsIgnoreCase("performanceArts"))) {
					String newName = Helper.readString("Enter new activity name > ") ;
					if (!newName.equalsIgnoreCase(a.getName())) {
						int newMaxPax = Helper.readInt("Enter max pax for new activity > ") ;
						if ((newMaxPax >= 20) && (newMaxPax <=60)) {
							String newDate = Helper.readString("Enter new activity date (DD/MM/YYYY) > ") ;
							String newTimeSlot = Helper.readString("Enter new activity time start (HH:MM-HH:MM) > ") ;
														
							activityList.add(new Activity(newID, newType, newName, newMaxPax, "Open", userID, newDate, newTimeSlot));
							break ;
						}
						else {
							System.out.println("Please enter a valid activtiy ID.") ;
						}
					}
					else {
						System.out.println("Please enter a valid new activtiy name.") ;
					}
				}
				else {
					System.out.println("Please enter a valid activtiy type.") ;
				}
			}
			else {
				System.out.println("Please enter a valid activtiy ID.") ;
			}
		}
	}

	//Shou kang code, shows all applications under the teacher//
	public static void showApplications4Teach(String userId, ArrayList<Applications> applicationList, ArrayList<Activity> activityList, ArrayList<Users> userList) {
		String studentID = "";
		String teacherID = "";
		String userListID = "";
		String studentName = "";
		String status = "";
		int applicationID = 0;
		double activityListActID = 0;
		double applicationListActID = 0;
		
		System.out.println(String.format("\n******Student Applications******\n\n%-18s%-15s%-15s%-15s%-17s%-10s","Application ID","Activity ID","Activity Name","Student ID","Student Name","Status"));
		System.out.println(String.format("%-18s%-15s%-15s%-15s%-17s%-15s","--------------","-------------","-------------","----------","------------","------"));
		
		for(int i = 0; i < applicationList.size(); i++) {
			
			applicationID = applicationList.get(i).getAppId();
			applicationListActID = applicationList.get(i).getActivityId();
			studentID = applicationList.get(i).getStudentId();
			status = applicationList.get(i).getStatus();	
			
			for(int y = 0; y < activityList.size(); y++) {
				activityListActID = activityList.get(y).getActivityID();
				String activityListName = activityList.get(y).getName();				
				if(applicationListActID == activityListActID) {
					teacherID = activityList.get(y).getTeacherID();
					
					if(teacherID.equals(userId)) {
						
						for(int x = 0; x < userList.size(); x++) {
							userListID = userList.get(x).getID();
							if(userListID.equals(studentID)) {
								studentName = userList.get(x).getName();
								System.out.format("%-18d%-15s%-15s %-15s %-15s %-15s\n", applicationID, activityListActID ,activityListName,studentID, studentName, status);
							}
						}
					}
				}
			}
		}
	}
	
	//Yvonne, student's view of all application
	public static void showApplications4Student(String userID, ArrayList<Applications> applicationList, ArrayList<Activity> activityList, ArrayList<Users> userList) {
		
		String studentID = "";
		String userListID = "";
		String studentName = "";
		String status = "";
		int applicationID = 0;
		double activityListActID = 0;
		double applicationListActID = 0;
		
		String studName = "";
		for(int i = 0; i<userList.size(); i++ ) {
			if(userList.get(i).getID().equals(userID)) {
				studName = userList.get(i).getName();
			}
		}
		
		System.out.println(String.format("\n******"+ studName +"'s Activity Applications******\n\n%-18s%-15s%-15s%-15s%-17s%-10s","Application ID","Activity ID","Activity Name","Student ID","Student Name","Status"));
		System.out.println(String.format("%-18s%-15s%-15s%-15s%-17s%-15s","--------------","-------------","-------------","----------","------------","------"));
		
		for(int i = 0; i < applicationList.size(); i++) {
			
			applicationID = applicationList.get(i).getAppId();
			applicationListActID = applicationList.get(i).getActivityId();
			studentID = applicationList.get(i).getStudentId();
			status = applicationList.get(i).getStatus();	
			
			for(int y = 0; y < activityList.size(); y++) {
				activityListActID = activityList.get(y).getActivityID();
				String activityListName = activityList.get(y).getName();				
				if(applicationListActID == activityListActID) {
					
					if(studentID.equals(userID)) {
						
						for(int x = 0; x < userList.size(); x++) {
							userListID = userList.get(x).getID();
							if(userListID.equals(studentID)) {
								studentName = userList.get(x).getName();
								System.out.format("%-18d%-15s%-15s %-15s %-15s %-15s\n", applicationID, activityListActID ,activityListName,studentID, studentName, status);
							}
						}
					}
				}
			}
		}
	}
	
	//Yvonne, change the application status under manage applications
	public static void chgAppliStatus(String userId, int appId, ArrayList<Activity> activityList, ArrayList<Applications> applicationList, ArrayList<Users> userList, ArrayList<Attendance> attendanceList) {
		
		
		for(int i = 0 ; i < applicationList.size(); i++) {
			int applicationListStudID = applicationList.get(i).getAppId();
			if(appId == applicationListStudID) {
				double applicationListActID = applicationList.get(i).getActivityId();
				
				for(int y = 0; y < activityList.size(); y++) {
					double activityListActID = activityList.get(y).getActivityID();
					
					if(applicationListActID == activityListActID) {
						String cherID = activityList.get(y).getTeacherID();
						
						boolean taskComplete = false;
							String name = "";
							if(userId.equals(cherID)) {
								while(taskComplete == false ) {
									String statusChg = Helper.readString("Approve Application? (Y/N) or enter C to cancel").toUpperCase();
									if(statusChg.equals("Y")) {
										applicationList.get(i).setStatus("Approved");
										String stuID = applicationList.get(i).getStudentId();
										for(int a = 0; a<userList.size(); a++) {
											if(userList.get(a).getID()==stuID) {
												name = userList.get(a).getName();
											}
										}
										
										attendanceList.add(new Attendance(attendanceList.size(), stuID , activityListActID));
										
										System.out.println("Student " + name + "'s application has been approved");
										
										
										taskComplete = true;
									
									}else if(statusChg.equals("N")) {
										applicationList.get(i).setStatus("Rejected");
										String stuID = applicationList.get(i).getStudentId();
										for(int a = 0; a<userList.size(); a++) {
											if(userList.get(a).getID()==stuID) {
												name = userList.get(a).getName();
											}
										}
										System.out.println("Student " + name + "'s application has been rejected");
										taskComplete = true;
									}else if(statusChg.equals("C")){
										System.out.println("Changing of application status for student has been cancelled");
										taskComplete = true;
									}
								}
								
						}
						
					}
				}
			}
		}
		
	}
	
	//Shou Kang code, removes the applications that have already been approved/disapproved by the teacher 
	public static void removeApplication(String userId, int appId, ArrayList<Activity> activityList, ArrayList<Applications> applicationList) {
		
		boolean removed = false;
		
		for(int i = 0 ; i < applicationList.size(); i++) {
			int applicationListStudID = applicationList.get(i).getAppId();
			if(appId == applicationListStudID) {
				double applicationListActID = applicationList.get(i).getActivityId();
				
				for(int y = 0; y < activityList.size(); y++) {
					double activityListActID = activityList.get(y).getActivityID();
					
					if(applicationListActID == activityListActID) {
						String cherID = activityList.get(y).getTeacherID();
						
						if(userId.equals(cherID)) {
							applicationList.remove(i);
							removed = true;
						}
					}
				}
			}
		}
		if(removed) {
			System.out.println("\nApplication has been deleted successfully");
		}
		else {
			System.out.println("\nPlease enter a proper application ID");
		}
		
	}

	//Yvonne, doLogin modifier adapted for Junit testing
	public static AbstractMap.SimpleEntry<Integer, Boolean> doLogin(String userID, String password,Boolean login, int options, int role, ArrayList<Users> userList) {
		

			//Yvonne
			for(int i = 0; i<userList.size(); i++) {
				if(userID.equals(userList.get(i).getID())&&password.equals(userList.get(i).getPassword())) {
					System.out.println("\nlogin successful");
					role = userList.get(i).getRoleIndex();
					login = true;
					//break;
				}
			}
			if(!login) {
				options =123;
				role =0;
				System.out.println("\nInvalid username or password");
			}
			return new AbstractMap.SimpleEntry<>(role,login);
		}
	
	//Shou kang code
	public static void showAllStudentInActivity(String userID, double actIdInp, ArrayList<Attendance> attendanceList, ArrayList<Activity> activityList, ArrayList<Users> userList) {
		
		System.out.format("\n%-20s %-20s %-20s %-20s", "Attendance ID", "Student ID", "Student Name", "Attendance status");
		
		for(int i = 0; i < activityList.size(); i++) {
			String activityListCherId = activityList.get(i).getTeacherID();
			double activityListActId = activityList.get(i).getActivityID();
			
			if(activityListCherId.equals(userID)) {
				if(activityListActId == actIdInp) {
					for(int x = 0; x < attendanceList.size(); x++) {
						double attendanceListActId = attendanceList.get(x).getActivityId();
						String attendanceListStudId = attendanceList.get(x).getStudentId();
						int attendanceId = attendanceList.get(x).getAttendanceId();
						String status = attendanceList.get(x).getAttended();
						
						if(attendanceListActId == activityListActId) {
							for(int y = 0; y < userList.size(); y++) {
								String userListId = userList.get(y) .getID();
							
								if(userListId.equals(attendanceListStudId)) {
									String studentName = userList.get(y).getName();
								
									System.out.format("\n%-20d %-20s %-20s %-20s\n", attendanceId, userListId, studentName, status);
								}
							}
						}
					}
				}
			}
		}
	}
	//Marcus and Shou Kang, Mark attendance
	public static void markAttendance(String userID, int attendanceID, double actId,ArrayList<Attendance> attendanceList, ArrayList<Activity> activityList, ArrayList<Users> userList) {
		
		String studentName = "";
		boolean marked = false; 
		boolean markedAlr = false;
		for(int i = 0; i < activityList.size(); i++) {
			
			String activityListCherId = activityList.get(i).getTeacherID();
			double activityListActId = activityList.get(i).getActivityID();
			
			if(activityListCherId.equals(userID)) {
				
				if(activityListActId == actId) {
					
					for(int x = 0; x < attendanceList.size(); x++) {
						
						String attendanceListStudId = attendanceList.get(x).getStudentId();
						double attendanceListActId = attendanceList.get(x).getActivityId();
						int attendanceId = attendanceList.get(x).getAttendanceId();
						String status = attendanceList.get(x).getAttended();
						
						if(attendanceListActId == activityListActId) {
							if(attendanceId == attendanceID) {
								
								if(status.equalsIgnoreCase("Attended")) {
									markedAlr = true;
								}
								else {
									attendanceList.get(x).setAttended("Attended");
									for(int y = 0; y < userList.size(); y++) {
										String userListId = userList.get(y) .getID();
										if(userListId == attendanceListStudId) {
											studentName = userList.get(y).getName();
											marked = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(markedAlr) {
			System.out.println("This attendance has already been marked");
		}
		else if(marked) {
			System.out.println("Student " + studentName + " has been marked as present");
		}
		else {
			System.out.println("Please enter a valid attendance ID");
		}
	}
	public static boolean removeActivity(String userID,ArrayList<Activity> activityList) {
		boolean activityfound = false;
		double activityInput = Helper.readDouble("Enter activity to be deleted > ");
		for (int i = 0; i< activityList.size(); i++) {
			if (activityList.get(i).getActivityID()==activityInput) {
				activityList.remove(i);
				System.out.println("Successfully deleted a with  " + activityInput);
				activityfound = true;
			}
			else {
				
				activityfound = false;
			}
		}
		return activityfound;
		
		
	}
}
