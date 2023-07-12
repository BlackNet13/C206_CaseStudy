
public class Activity {
	
private int activityID;
private String type;
private int totalCCAdays;
private int maxPax;
private String status;
private int teacherID;


public Activity(int activityID, String type , int totalCCAdays , int maxPax, String status, int teacherID) {
	this.activityID = activityID;
	this.type = type;
	this.totalCCAdays = totalCCAdays;
	this.maxPax = maxPax;
	this.status = status; //
	this.teacherID = teacherID;
	
	
}

public int getActivityID() {
	return activityID;
}
public String getType() {
	return type;
}
public int gettotalCCAdays() {
	return totalCCAdays;
}
public int maxPax() {
	return maxPax;
}
public String getStatus() {
	return status;
}
public int getteacherID() {
	return teacherID;
	
	///////
}


}
