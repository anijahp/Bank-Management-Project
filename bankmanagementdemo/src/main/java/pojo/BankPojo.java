package pojo;

public class BankPojo {
	private String name;
	private int idBank;
	
	public BankPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankPojo(String name, int idBank) {
		super();
		this.name = name;
		this.idBank = idBank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdBank() {
		return idBank;
	}

	public void setIdBank(int idBank) {
		this.idBank = idBank;
	}

	@Override
	public String toString() {
		return "BankPojo [name=" + name + ", idBank=" + idBank + "]";
	}
	
	
}
