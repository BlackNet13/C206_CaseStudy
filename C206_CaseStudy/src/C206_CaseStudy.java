import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//commenting
		
		/*flow:
		 * 1.login -> show different menu choices
		 * 
		 * 1.1: admin: 
		 * -view all user list
		 * -add/update user -> input student/teacher/admin Id, pw, name, role(role list with role name) -> if user exist, ask if want to update each field
		 * -remove user -> removes related ccas -> confirmation screen 
		 * -View all roles
		 * 
		 * 1.2:teacher:
		 * -Activity Overview list(even those from other teachers,activity list)
		 * -manage activities(owned) ->1.view all activities 2.add/update activity (only can add their own)--> input activityName, maxDate, maxPax, status(open/closed/draft), teacherID ,activityID, 3. remove activity(only can delete their own)
		 * -manage student applications[number of students waiting for approval] ->1.accept/reject students(shows list of students that applied and is of pending status)->will cycle through students, approve/reject
		 * -activity attendance -> 1. view all students(show all students it will show each activity's list of students ordered by attivity group) -> show activity name, student name and id before and adding of attendance, 2.mark attendance ->input date(searches for activity for that teacher for that day, show student name and id, retrieves from attendance list based on student id,activity id,date)-> cycles through students to mark attendance
		 *
		 * 
		 * 1.3:student:
		 * -Activity Overview list(shows all)
		 * -apply for activities -> input activity ID (shows list of activities and their status(open/closed))-> if succesfull will show that they have to wait for approval
		 * -application status/notifications(number of notifications) -> show applications and notifications(reminders)
		 * -attendance record -> show list of activites enrolled in and their attendance status and completion rate(generated%)
		 * 
		 */
		
		//to create:
		/*java class:
		 * 1.users(Shou Kang) : userid(Str), pw(Str), name(Str), roleid(int)
		 * 2.roles(Aliyah) : roleid(int),rolename(str)
		 * 3.activity(Edry) : activityid(int), type(string), totalCCAdays(int), maxPax(int), status(String, open/closed),teacherid(Int)
		 * 4.applications(Marcus) : applicationid(int), activityid(int),studentid(Str), status(string,start out as blank "", filled with approved/rejected) 
		 * 5.attendance(Alex) :  attendanceid(int), studentid(int), activityid(int),attended(int, days attended)
		 * 
		 * arraylist:
		 * 1.userList (all users indexed with same fields refer to github flow section: 1.1 add/update user)
		 * 2.roleList (defines the roles with index and name)
		 * 3.activityList
		 * 4.applicationList
		 * 5.attendanceList
		 * 
		 */
		
		/*-------------------------------------*/
		
		//initialize all class objects here:
		
		
		//initialize the userList, done by Shou Kang
		ArrayList<Users> userList = new ArrayList<Users>(); 
		
		//initialize the activityList, done by Edry
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		
		//initialize roleList, done by Aliyah
		ArrayList<Roles> roleList = new ArrayList<Roles>() ;
		
		roleList.add(new Roles(1, "Admin")) ;
		roleList.add(new Roles(2, "Teacher")) ;
		roleList.add(new Roles(3, "Student")) ;
		
		
		boolean login = false; 
		int options = 123;
		
		while(options != -9) {
			
			if(login == false) {
				loginMenu();
				
				options = Helper.readInt("Enter Menu Option (type -9 to exit program) > ");
				
				if(options == 1) {
					
					String userID = Helper.readString("Enter user ID > ");
					String password = Helper.readString("Enter password > ");
					
					if(validateUserLogin(userID, password, userList)) {
						System.out.println("\nlogin successful");
					}
					else {
						System.out.println("\nInvalid username or password");
					}
				}
				
			}

		}
		System.out.println("\nExit program");
		
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
	public static void userMenus(int roleIndex) {
		if(roleIndex == 1) {
			System.out.println();
			Helper.line(45,"=");
			System.out.println("==== ADMIN MENU ====");
			Helper.line(45,"=");
			
			System.out.println("1. View all users");
			System.out.println("2. Add/Update user");
			System.out.println("3. Remove user");
			System.out.println("4. Change user role");
			System.out.println("-8. Logout");
			System.out.println("-9. Exit program");
			System.out.println();
		}
		else if(roleIndex == 2){
			System.out.println();
			Helper.line(45,"=");
			System.out.println("==== TEACHER MENU ====");
			Helper.line(45,"=");
			
			System.out.println("1. Activity overview");
			System.out.println("2. Manage Activites");
			System.out.println("3. Manage Student's Application");
			System.out.println("4. Mark Attendance");
			System.out.println("-8. Logout");
			System.out.println("-9. Exit program");
			System.out.println();
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
		}
	}
	
	
	
	//Shou Kang code, validation for login/
	public static boolean validateUserLogin(String userID, String password, ArrayList<Users>userList) {
		boolean permitted = false;
		String UIDinp = userID;
		String passinp = password;
		
		for(int i = 0; i < userList.size(); i++) {
			String UIDList = userList.get(i).getID();
			
			if(UIDinp.equals(UIDList)) {
				String passList = userList.get(i).getPassword();
				
				if(passinp.equals(passList)) {
					permitted = true;
					break; 
				}
			}
		}
		
		return permitted; 
	}
	

}
