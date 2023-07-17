//Alex code
public class Attendance {
private int attendanceId;
private String studentId;
private int activityId;
private int daysAttended;
private int teacherID;

public Attendance(int attendanceId,String studentId, int activityId, int daysAttended ) {
	this.attendanceId=attendanceId;
	this.studentId=studentId;
	this.activityId = activityId;
	this.daysAttended = daysAttended;
	
}
public int getattendanceId(){
	return attendanceId;
}
public int getactivityId() {
	return activityId;
}

public String getstudentId() {
	return studentId;
}

public int daysAttended() {
	return daysAttended;
}
public int getteacherID() {
	return teacherID;
}


}
