package pojo;

public class CustomerPojo {
	
	private int idCustomer;
	private String name;
	private String surName;
	private String userName;
	private String passWord;
	private int streetNumber;
	private String address;
	private String zipcode;
	private int idbranch;
	
	
	public CustomerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerPojo(int idCustomer, String name, String surName, String userName, String passWord, int streetNumber,
			String address, String zipcode, int idbranch) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.surName = surName;
		this.userName = userName;
		this.passWord = passWord;
		this.streetNumber = streetNumber;
		this.address = address;
		this.zipcode = zipcode;
		this.idbranch = idbranch;
		
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
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

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public int getIdbranch() {
		return idbranch;
	}

	public void setIdbranch(int idbranch) {
		this.idbranch = idbranch;
	}

	@Override
	public String toString() {
		return "CustomerPojo [idCustomer=" + idCustomer + ", name=" + name + ", surName=" + surName + ", userName="
				+ userName + ", passWord=" + passWord + ", streetNumber=" + streetNumber + ", address=" + address
				+ ", zipcode=" + zipcode + ", idbranch=" + idbranch + "]";
	}
	
	

}
