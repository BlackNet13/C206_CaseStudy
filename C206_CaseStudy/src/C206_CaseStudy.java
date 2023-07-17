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
		 * 3.activity(Edry) : activityid(int), type(string), totalCCAdays(int), maxPax(int), status(String, open/closed),teacherid(str)
		 * 4.applications(Marcus) : applicationid(int), activityid(int),studentid(Str), status(string,start out as blank "", filled with approved/rejected) 
		 * 5.attendance(Alex) :  attendanceid(int), studentid(string), activityid(int),attended(int, days attended)
		 * 
		 * arraylist:
		 * 1.userList (all users indexed with same fields)~
		 * 2.roleList (defines the roles with index and name) /done
		 * 3.activityList ~
		 * 4.applicationList 
		 * 5.attendanceList
		 * 
		 */
		
		/*-------------------------------------*/
		
		//initialize all class objects here:
		
		
		//initialize the userList, done by Shou Kang, to create 1 more of each role
		ArrayList<Users> userList = new ArrayList<Users>(); 
		
		userList.add(new Users("S123","1234","Kelly",1)); //admin
		userList.add(new Users("S897","4562","Mark",2)); //teacher
		userList.add(new Users("S111","1111","Kelly",3)); //student
		
		//initialize the activityList, done by Edry, to create 1 or 2 more activity, activity id follow in numerical order
		ArrayList<Activity> activityList = new ArrayList<Activity>(); 
		//type = sports, uniformGroup, performanceArts
		//totalDays = total cca days in a month, so if once a week will be 4 as in a month got four weeks. 
		//maxpax = maximum people for cca
		//teacher id must be from existing userid that have teacher's role
		
		activityList.add(new Activity(1,"sports", 6, 15, "open","S897"));
		
		//initialize roleList, done by Aliyah /done
		ArrayList<Roles> roleList = new ArrayList<Roles>() ;
		
		roleList.add(new Roles(1, "Admin")) ;
		roleList.add(new Roles(2, "Teacher")) ;
		roleList.add(new Roles(3, "Student")) ;
		
		
		boolean login = false; 
		int options = 123;
		int role = 0;
		
		while(options != -9) {
			
			if(login == false) {
				loginMenu();
				
				options = Helper.readInt("Enter Menu Option (type -9 to exit program) > ");
				
				if(options == 1) {
					
					String userID = Helper.readString("Enter user ID > ");
					String password = Helper.readString("Enter password > ");
					
				
						//Yvonne
						for(int i = 0; i<userList.size(); i++) {
							if(userID.equals(userList.get(i).getID())&&password.equals(userList.get(i).getPassword())) {
								System.out.println("\nlogin successful");
								role = userList.get(i).getRoleIndex();
								login = true;
								break;
							}else {
								System.out.println("\nInvalid username or password");
								break;
							}
						}
					
					
					
				}
				
			}   //Yvonne
				options = userMenus(role);	
				switch(options) { //we will need to check for what role it is, since all users will use similar option numbers to access their options
				case 1:
					System.out.print("placeholder 1");
					break;
				case 2:
					System.out.print("placeholder 2");
					break;
				case -8:
					login =false;
					System.out.print("You have log out successfully");
					break;
				case -9:
					System.out.print("sys end");
					break;
			
				}
			

		}
		
		System.out.println("\nExit program");
		
	} //end of main
	
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
			System.out.println("2. Add/Update user");
			System.out.println("3. Remove user");
			System.out.println("4. View all roles");
			System.out.println("-8. Logout");
			System.out.println("-9. Exit program");
			System.out.println();
			
			options = Helper.readInt("Enter option number >");
			
			
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
			
			options = Helper.readInt("Enter option number >");
			
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
			
			options = Helper.readInt("Enter option number >");
		}
		return options;
	}
	

}
