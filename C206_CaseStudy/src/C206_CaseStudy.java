
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
		
		
	}

}
