import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//commenting
		
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
		
		
		//initialize roleList, done by Aliyah /done
		ArrayList<Roles> roleList = new ArrayList<Roles>() ;
		
		roleList.add(new Roles(1, "Admin")) ;
		roleList.add(new Roles(2, "Teacher")) ;
		roleList.add(new Roles(3, "Student")) ;
		
		//initialize attendanceList, done by Alex
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>() ;

		
		//initialize applicationList, done by Marcus
		ArrayList<Applications> applicationList = new ArrayList<Applications>();
		
		applicationList.add(new Applications(1, 01, "S111"));
		applicationList.add(new Applications(2, 03, "S908"));
		
		
		boolean login = false; 
		int options = 123;
		int role = 0;
		String userID ="";
			
		login(userList, roleList, activityList, applicationList, attendanceList ,login, options, role, userID);
		
		System.out.println("\nProgram Exited");
		
	}

	//code done by Shou Kang and Yvonne
	public static void login(ArrayList<Users> userList, ArrayList<Roles> roleList, ArrayList<Activity> activityList, ArrayList<Applications> applicationList,ArrayList<Attendance> attendanceList, boolean login, int options,
			int role, String userID) {
		
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
					String password = Helper.readString("Enter password > ");
					
				
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
						userfound = removeUser(userList);
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
					case 1: //Browse activities code here, Alex,Edry
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 1>>
						System.out.print("teach1");
						break;
					case 2: //add activities(that they owned)code here, Aliyah
						//show activities that they owned first
						//<<Insert code here:>>
						showOwnActivties(userID, activityList) ;							
						
						addNewActivity(userID, activityList) ;
						//<<end of code for case 2>>
						System.out.print("teach2");
						break;
					case 3: //remove activities that they owned code here, Alex,Edry
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 3>>
						System.out.print("teach3");
						break;
					case 4: //manage student applications code here, Yvonne
						//<<Insert code here:>>
						System.out.println(String.format("\n******Student Applications******\n\n%-8s%-16s%-6s%-6s","Index","Activity Name","Student ID","Student Name","Status"));
						System.out.println(String.format("%-8s%-16s%-6s%-6s","-----","----","---","---","-----------"));
						
						
						//<<end of code for case 4>>
						System.out.print("teach4");
						break;
					case 5: //Remove applications code here, Shou Kang 
						//<<Insert code here:>>
						
					
						
						//<<end of code for case 5>>
						System.out.print("teach5");
						break;
						
					case 6: //Mark attendance code here, Marcus,Shou Kang
						//<<Insert code here:>>
						
						//-show list of activities own by the teacher
						//-ask what activity id the user wants
						//-shows list of students
						
						//<<end of code for case 6>>
						System.out.print("teach6");
						break;
					case 7: //Delete attendance code here, Shou Kang
						//<<Insert code here:>>
						
						
						
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
						
						
						
						//<<end of code for case 1>>
						System.out.print("student1");
						break;
					case 2: //apply for activities code here,Yvonne, Aliyah
						//<<Insert code here:>>
						
						//-ask what activity id they want, then we search the activityList if the activity id exist
						//-show confirmation screen
						
						//<<end of code for case 2>>
						System.out.print("student2");
						break;
					case 3: //view application status code here,Yvonne
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 3>>
 						System.out.print("student3");
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
	public static boolean removeUser(ArrayList<Users>userList) {
		boolean userfound = false;
		String idInput = Helper.readString("Enter User ID to be deleted > ");
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
		Helper.line(120, "-");
		
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
	
}
