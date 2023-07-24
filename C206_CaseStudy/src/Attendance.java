//Alex code
public class Attendance {
private int attendanceId;
private String studentId;
private double activityId;
private String attended;


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
}
