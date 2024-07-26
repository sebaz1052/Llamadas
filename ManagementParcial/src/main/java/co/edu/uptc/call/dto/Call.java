package co.edu.uptc.call.dto;

public class Call {
    private String ownNumber;
    private String number;
    private int total;
    
    public Call(String ownNumber, String number, int total) {
        this.ownNumber = ownNumber;
        this.number = number;
        this.total = total;
    }
    public Call() {
    }
    public String getOwnNumber() {
		return ownNumber;
	}

	public void setOwnNumber(String ownNumber) {
		this.ownNumber = ownNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
    public String toString() {
        return "Call [ownNumber=" + ownNumber + ", number=" + number + ", total=" + total + "]";
    }
}