package co.edu.uptc.call.dto;

import co.edu.uptc.call.enums.Type;

public class CallDTO {

	private String number,ownNumber;
	private int minutoPrice,total,time,code;
	Type type;
	public CallDTO() {}

    public CallDTO(String number, int minutoPrice, int total, int time, Type type) {
        this.number = number;
        this.minutoPrice = minutoPrice;
        this.total = total;
        this.time = time;
        this.type = type;
    }

    public CallDTO(String ownNumber, String number, int total) {
        this.ownNumber = ownNumber;
        this.number = number;
        this.total = total;
    }
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getMinutoPrice() {
		return minutoPrice;
	}
	public void setMinutoPrice(int minutoPrice) {
		this.minutoPrice = minutoPrice;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public String getOwnNumber() {
		return ownNumber;
	}
	public void setOwnNumber(String ownNumber) {
		this.ownNumber = ownNumber;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "LLAMADA:  \n number=" + number + "\n precio por minuto=" + minutoPrice + "\n precio total=" + total + "\n tiempo=" + time
				+ "\n tipo de operador=" + type;
	}
	
}
