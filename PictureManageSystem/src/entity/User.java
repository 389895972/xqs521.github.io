package entity;

public class User extends Person {
    private String name;
    private String password;
    private String picture;
    private int age;
    private String sex;
	
    public User(String name, String password,String picture,int age,String sex) {
		super();
		this.name = name;
		this.password = password;
		this.picture=picture;
		this.age=age;
		this.sex=sex;
	}
    @Override
	public String toString() {
		//return "–’√˚:"+name+",√‹¬Î:"+password;
		return name+","+password+","+picture+","+age+","+sex;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
    
}
