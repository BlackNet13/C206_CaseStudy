//Alex code
public class Attendance {
private int attendanceId;
private String studentId;
private double activityId;
private String attended;


public Attendance(int attendanceId,String studentId, double activityId) {
	this.attendanceId=attendanceId;
	this.studentId=studentId;
	this.activityId = activityId;
	this.attended = "not attended";
}

public Attendance(int attendanceId,String studentId, double activityId, String attended ) {
	this.attendanceId=attendanceId;
	this.studentId=studentId;
	this.activityId = activityId;
	this.attended = attended;
	
}
public int getattendanceId(){
	return attendanceId;
}
public double getactivityId() {
	return activityId;
}

public String getstudentId() {
	return studentId;
}

public String attended() {
	return attended;
}
public void setAttendanceId(int attendanceId) {
	this.attendanceId = attendanceId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public void setActivityId(double activityId) {
	this.activityId = activityId;
}
public void setAttended(String attended) {
	this.attended = attended;
}

}
