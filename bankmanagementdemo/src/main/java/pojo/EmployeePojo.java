package pojo;

public class EmployeePojo {
	
	private int idEmployee;
	private String name;
	private String surName;
	private String position;
	private String userName;
	private String passWord;
	
	public EmployeePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePojo(int idEmployee, String name, String surName, String position, String userName, String passWord) {
		super();
		this.idEmployee = idEmployee;
		this.name = name;
		this.surName = surName;
		this.position = position;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "EmployeePojo [idEmployee=" + idEmployee + ", name=" + name + ", surName=" + surName + ", position="
				+ position + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
	
}
