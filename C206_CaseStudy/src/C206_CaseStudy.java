import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*flow:
		 * 1.login -> show different menu choices
		 * 
		 * 1.1: admin: 
		 * -view all user list
		 * -add/update user -> input student/teacher/admin Id, pw, name, role(role list with role description and permissions) -> if user exist, ask if want to update each field
		 * -remove user -> removes related ccas -> confirmation screen 
		 * -Manage roles(maybe? else view all roles?) -> 1.add/change roles, 2. remove roles(confirmation to prevent accidently deletion) 
		 * 
		 * 1.2:teacher:
		 * -Activity Overview list(even those from other teachers,activity list)
		 * -manage activities(owned) ->1.view all activities 2.add/update activity (only can add their own)--> input activityName, dateStart, dateEnd, maxPax; autogen(amtDays, status(open/closed/draft), teacherID ,activityID, 3. remove activity(only can delete their own)
		 * -manage student applications[number of students waiting for approval] ->1.accept/reject students(shows list of students that applied and is of pending status)->will cycle through students/choose by queue index? accept/skip/reject? -> reason for rejection?
		 * -activity attendance -> 1. view all students(show all students it will show in a-z order by activity) -> show student name and id before cycling through activity and day attendance(P/AB/MC/-), 2.mark attendance ->input date(searches for activity for that teacher for that day, show student name and id, retrieves from attendance list based on student id,activity id,date)-> cycles through students to mark attendance
		 *
		 * 
		 * 1.3:student:
		 * -Activity Overview list(shows all)
		 * -apply for activities -> input activity ID (shows if application is allowed in case student did not notice)-> if succesfull will show that they have to wait for approval
		 * -application status/notifications(number of notifications) -> show applications and notifications(reminders)
		 * -attendance record -> show list of activites enrolled in and their attendance status and completion rate(generated%)
		 * 
		 */
		
		//to create:
		/*java class:
		 * 1.users
		 * 2.roles
		 * 3.activity
		 * 4.applications
		 * 5.attendance
		 * 
		 * arraylist:
		 * 1.userList (all users indexed with same fields refer to github flow section: 1.1 add/update user)
		 * 2.roleList (defines the roles with index and permissions)
		 * 3.activityList
		 * 4.applicationList
		 * 5.attendanceList
		 * 
		 */
		boolean login = false; 
		int options = 123;
		ArrayList<Users> userList = new ArrayList<Users>(); 
		
		while(options != -9) {
			
			if(login == false) {
				loginMenu();
				
				options = Helper.readInt("Enter Menu Option (type -9 to exit program) > ");
				
				if(options == 1) {
					
					String userID = Helper.readString("Enter user ID > ");
					
					if(validateUserID(userID, userList) == true) {
						
						String password = Helper.readString("Enter password > ");
						
						if(validatePassword(password, userList) == true) {
							
						}
						else {
							System.out.println("Invalid password");
						}
						
					}
					else {
						System.out.println("Invalid user ID");
					}
				}
			}

		}
		
	}
	
	// Shou Kang code
	public static void loginMenu(){
		System.out.println();
		Helper.line(45,"=");
		System.out.println("==== LOGIN MENU ====");
		Helper.line(45,"=");
		
		System.out.println("1. Login");
		System.out.println("-9. Exit program");
	}
	
	// Shou Kang code
	public static void adminMenu() {
		System.out.println();
		Helper.line(45,"=");
		System.out.println("==== ADMIN MENU ====");
		Helper.line(45,"=");
		
		System.out.println("1. View all users");
		System.out.println("2. Add user");
		System.out.println("3. Remove user");
		System.out.println("4. Update user information");
		System.out.println("5. Change user role");
		System.out.println("-8. Logout");
		System.out.println("-9. Exit program");
	}
	
	// Shou Kang code
	public static void teacherMenu() {
		System.out.println();
		Helper.line(45,"=");
		System.out.println("==== TEACHER MENU ====");
		Helper.line(45,"=");
		
		System.out.println("1. Activity overview");
		System.out.println("2. View activities posted by you");
		System.out.println("3. Create new activity");
		System.out.println("4. Delete activity");
		System.out.println("5. Approve activity registration");
		System.out.println("6. Mark attendance");
		System.out.println("-8. Logout");
		System.out.println("-9. Exit program");
	}
	
	// Shou Kang code
	public static void studentMenu() {
		System.out.println();
		Helper.line(45,"=");
		System.out.println("==== STUDENT MENU ====");
		Helper.line(45,"=");
		
		System.out.println("1. View all activities");
		System.out.println("2. Register for activity");
		System.out.println("3. View notifications");
		System.out.println("4. View attendance record");
		System.out.println("-8. Logout");
		System.out.println("-9. Exit program");
	}
	
	//Shou Kang code
	public static boolean validateUserID(String UID, ArrayList<Users>userList) {
		String userIDInput = UID;
		boolean found = false; 
		
		
		for(int i = 0; i < userList.size(); i++) {
			String userIDList = userList.get(i).getID();
			
			if(userIDInput.equals(userIDList)) {
				found = true; 
				break; 
			}
		}
		
		return found; 
	}
	
	//Shou Kang code
	public static boolean validatePassword(String password, ArrayList<Users>userList) {
		String passwordInput = password;
		boolean found = false; 
		
		
		for(int i = 0; i < userList.size(); i++) {
			String userPasswordList = userList.get(i).getID();
			
			if(passwordInput.equals(userPasswordList)) {
				found = true; 
				break; 
			}
		}
		
		return found; 
	}

}
