//Alex code
public class Attendance {
private int attendanceId;
private String activityName;
private String studentName;
private String studentId;
private int activityId;
private String date;
private int teacherID;
private String teacherName;

public Attendance(int attendanceId,String activityName, String studentName, String studentId, int activityId, String date, int teacherID, String teacherName ) {
	this.attendanceId=attendanceId;
	this.activityName=activityName;
	this.studentName=studentName;
	this.studentId=studentId;
	this.activityId = activityId;
	this.date = date;
	this.teacherID = teacherID;
	this.teacherName=teacherName;
	
}
public int getattendanceId(){
	return attendanceId;
}
public String getactivityName() {
	return activityName;
}
public String getstudentName() {
	return studentName;
}
public String getstudentId() {
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

}
