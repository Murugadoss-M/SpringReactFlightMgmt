package com.mmdoss.document;

public class Passenger {
	private String name;
	private char gender;
	private int age;
	private boolean isCheckedIn;
	private int seatNo;
	public Passenger() {
	}
	public Passenger(String name, char gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		isCheckedIn=false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isCheckedIn() {
		return isCheckedIn;
	}
	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public String toString() {
		return String.format("Passenger [name=%s, gender=%s, age=%s, isCheckedIn=%s, seatNo=%s]", name,
				gender, age, isCheckedIn, seatNo);
	}
	
}
