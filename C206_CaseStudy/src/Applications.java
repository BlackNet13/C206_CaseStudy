//Marcus code
public class Applications {
private int appId;
private double activityId;
private String studentId;
private String status;

public Applications(int appId, double activityId, String studentId, String status ) {
	this.appId = appId;
	this.activityId = activityId;
	this.studentId = studentId;
	this.status = status;
}

public Applications(int appId, double activityId, String studentId ) {
	this.appId = appId;
	this.activityId = activityId;
	this.studentId = studentId;
	this.status = "pending";
}

public int getAppId() {
	return appId;
}

public double getActivityId() {
	return activityId;
}

public String getStudentId() {
	return studentId;
}


public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}













	
	

}
