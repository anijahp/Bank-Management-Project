package pojo;

public class BranchPojo {
	
	private int idBranch;
	private String branchName;
	private int streetNumber;
	private String address;
	private String zipcode;
	
	
	public BranchPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchPojo(int idBranch, String branchName, int streetNumber, String address, String zipcode) {
		super();
		this.idBranch = idBranch;
		this.branchName = branchName;
		this.streetNumber = streetNumber;
		this.address = address;
		this.zipcode = zipcode;
		
	}

	public int getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(int idBranch) {
		this.idBranch = idBranch;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "BranchPojo [idBranch=" + idBranch + ", branchName=" + branchName + ", streetNumber=" + streetNumber
				+ ", address=" + address + ", zipcode=" + zipcode +  "]";
	}
	
	
}
