//Edry code
public class Activity {
	
private int activityID;
private String type;
private String name;
private int totalCCAdays;
private int maxPax;
private String status;
private String teacherID;


public Activity(int activityID, String type ,String name, int totalCCAdays , int maxPax, String status, String teacherID) {
	this.activityID = activityID;
	this.type = type;
	this.name = name;
	this.totalCCAdays = totalCCAdays;
	this.maxPax = maxPax;
	this.status = status; //
	this.teacherID = teacherID;
	
	
}

public int getActivityID() {
	return activityID;
}

public String name() {
	return name;
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
public String getteacherID() {
	return teacherID;
	
	///////
}


}
