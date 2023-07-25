//Shou kang code
public class Users {
private String id;
private String name; 
private String password; 
private int roleIndex; 

public Users(String id, String password, String name,int roleIndex) {
	this.id = id;
	this.name = name; 
	this.password = password; 
	this.roleIndex = roleIndex; 
}

public String getID() {
	return id;
}

public String getName() {
	return name;
}

public String getPassword() {
	return password;
}

public int getRoleIndex() {
	return roleIndex;
}

public void setName(String name) {
	this.name = name;
}

public void setPassword(String password) {
	this.password = password;
}

public void setRoleIndex(int roleIndex) {
	this.roleIndex = roleIndex;
}

public void setID(String id) {
	this.id = id;
}



}
