package entity;

public class Admin extends Person{
    private String adminpassword;
    private String adminname;
    public String toString() {
    	return adminname+","+adminpassword;  	
    }
    public Admin(String adminname,String adminpassword) {
    	super();
    	this.adminname=adminname;
    	this.adminpassword=adminpassword;
    }
	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
   
}
