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
		 * -view all activities(Owned)
		 * -add/update activity (only can add their own) --> input activityName, maxDate, maxPax, status(open/closed/draft), teacherID ,activityID
		 * -remove activity(only can delete their own)
		 * -manage student applications[number of students waiting for approval] ->1.accept/reject students(shows list of students that applied and is of pending status)->will cycle through students, approve/reject
		 * -update attendance -> view all students(show all students it will show each activity's list of students ordered by attivity group) -> show activity name, student name and id before and adding of attendance, mark attendance ->input date(searches for activity for that teacher for that day, show student name and id, retrieves from attendance list based on student id,activity id,date)-> cycles through students to mark attendance
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
		 * 3.activity(Edry) : activityid(int), type(string), name(String) totalCCAdays(int), maxPax(int), status(String, open/closed),teacherid(str)
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
		
		//initialize the activityList, done by Edry 
		ArrayList<Activity> activityList = new ArrayList<Activity>(); 
		
		activityList.add(new Activity(01,"sports","Football",8,25,"Close","S897"));
		activityList.add(new Activity(02,"uniformGroup","NCC SEA",8,60,"Open","S897"));
		activityList.add(new Activity(03,"performanceArts","Chinese Orchestra",8,45,"Close","S897"));

		//type = sports, uniformGroup, performanceArts
		//totalDays = total cca days in a month, so if once a week will be 4 as in a month got four weeks. 
		//maxpax = maximum people for cca
		//teacher id must be from existing userid that have teacher's role
		
		
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
								//break;
							}
						}
						if(!login) {
							options =123;
							role =0;
							System.out.println("\nInvalid username or password");
						}
					
					
					
				}else {
					
					System.out.println("\nPlease enter a correct option");
					//break;
				}
				
			}   //Yvonne
				options = userMenus(role);
				if(options!=-8) {
				if(role == 1) { //admin
					switch(options) {
					case 1: //view all users code here, Aliyah
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 1>>
						System.out.print("admin1"); //<--this is just to test that it can reach this lvl before you start coding
						break;
					case 2: //add/update users code here, Shou Kang
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 2>>
						System.out.print("admin2"); //<--this is just to test that it can reach this lvl before you start coding
						break;
					case 3: //remove users code here,Marcus
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 3>>
						System.out.print("admin3"); //<--this is just to test that it can reach this lvl before you start coding
						break;
					case 4: //view all roles code here, Alex
						//<<Insert code here:>>
						
						
						
						//<<end of code for case 4>>
						System.out.print("admin4"); //<--this is just to test that it can reach this lvl before you start coding
						break;
						
					default: 
						
						if(options != -9) {
							System.out.println("\nPlease enter a proper option");
						}
						
						break; 
					}
					
					
				}else if(role == 2) {
					switch(options) { //teacher
					case 1: //Activity overview code here
						
						System.out.print("teach1");
						break;
					case 2: //view all activities they own code here
						System.out.print("teach2");
						break;
					case 3: //add/update activities(that they owned)code here
						System.out.print("teach3");
						break;
					case 4: //remove activities that they owned code here
						System.out.print("teach4");
						break;
					case 5: //manage student applications code here
						System.out.print("teach5");
						break;
					case 6: //update attendance code here
						System.out.print("teach6");
						break;
					default: 
						if(options != -9) {
							System.out.println("\nPlease enter a proper option");
						}
						break; 
					}
					
				}else if(role == 3) { //students
					switch(options) {
					case 1: //activity overview code here
						
						System.out.print("student1");
						break;
					case 2: //apply for activities code here
						System.out.print("student2");
						break;
					case 3: //application status code here
 						System.out.print("student3");
						break;
					case 4: //attendance record code here
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
		
		System.out.println("\nProgram Exited");
		
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
			System.out.println("2. View activities(Own)");
			System.out.println("3. Add/Update Activities");
			System.out.println("4. Remove activites");
			System.out.println("5. Manage Student's Applications");
			System.out.println("6. Mark Attendance");
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
