package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class Coin {
	private int id;
	private String country;
	private String denomination;
	private int yearOfMinting;
	private BigDecimal curretntvValue;
	//private decimal currentValue;
	private Date acquiredDate;
	
	//No Args Constructor
	public Coin() {	
	}

	public Coin(int id, String country, String denomination, int yearOfMinting, BigDecimal curretntvValue,
			Date acquiredDate) {
		super();
		this.id = id;
		this.country = country;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.curretntvValue = curretntvValue;
		this.acquiredDate = acquiredDate;
	}
	
	//Second Cunstructor for Database where ID is auto incrementive
	public Coin( String country, String denomination, int yearOfMinting, BigDecimal curretntvValue,
			Date acquiredDate) {
		super();
		this.country = country;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.curretntvValue = curretntvValue;
		this.acquiredDate = acquiredDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getYearOfMinting() {
		return yearOfMinting;
	}

	public void setYearOfMinting(int yearOfMinting) {
		this.yearOfMinting = yearOfMinting;
	}

	public BigDecimal getCurretntvValue() {
		return curretntvValue;
	}

	public void setCurretntvValue(BigDecimal curretntvValue) {
		this.curretntvValue = curretntvValue;
	}

	public Date getAcquiredDate() {
		return acquiredDate;
	}

	public void setAcquiredDate(Date acquiredDate) {
		this.acquiredDate = acquiredDate;
	}

	
	public String toString() {
		return "Coin [id=" + id + ", country=" + country + ", denomination=" + denomination + ", yearOfMinting="
				+ yearOfMinting + ", curretntvValue=" + curretntvValue + ", acquiredDate=" + acquiredDate + "]";
	}

	
	
	

}
