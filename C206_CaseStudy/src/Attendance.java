//Alex code
public class Attendance {
private String activityName;
private String studentName;
private int studentId;
private int activityId;
private String date;
private int teacherID;
private String teacherName;
private boolean AttendanceStatus;

public Attendance(String activityName, String studentName, int studentId, int activityId, String date, int teacherID, String teacherName, boolean AttendanceStatus ) {
	this.activityName=activityName;
	this.studentName=studentName;
	this.studentId=studentId;
	this.activityId = activityId;
	this.date = date;
	this.teacherID = teacherID;
	this.teacherName=teacherName;
	this.AttendanceStatus=AttendanceStatus;
}
public String getactivityName() {
	return activityName;
}
public String getstudentName() {
	return studentName;
}
public int getstudentId() {
	return studentId;
}
public int getactivityId() {
	return activityId;
}
public String getdate() {
	return date;
}
public int getteacherID() {
	return teacherID;
}
public String getteacherName() {
	return teacherName;
}
public boolean getAttendanceStatus() {
	return AttendanceStatus;
}
}
