//Edry code
public class Activity {
	
private double activityID;
private String type;
private String name;
//private int totalCCAdays;
private int maxPax;
private String status;
private String teacherID;
private String date;
private String timeSlot;


public Activity(double activityID, String type ,String name, int maxPax, String status, String teacherID,String date,String timeSlot) {
	this.activityID = activityID;
	this.type = type;
	this.name = name;
	//this.totalCCAdays = totalCCAdays;
	this.maxPax = maxPax;
	this.status = status; //
	this.teacherID = teacherID;
	this.date = date;
	this.timeSlot = timeSlot;
	
	
}

public double getActivityID() {
	return activityID;
}

public String name() {
	return name;
}

public String getType() {
	return type;
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
