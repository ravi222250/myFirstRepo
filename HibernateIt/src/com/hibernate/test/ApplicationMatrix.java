package com.hibernate.test;

public class ApplicationMatrix {
	
	 private static final long serialVersionUID = 8633415090390966715L;  
	
	private int serial_number;
	private String date_of_data;
	private String time_of_data;
	private int install_time;
	private int first_load_time;
	private int login_time;
	private int registration_time;
	
	
	public int getSerial_number() {
		return serial_number;
	}
	
	public void setSerial_number(int serialNumber) {
		serial_number = serialNumber;
	}
	
	public String getDate_of_data() {
		return date_of_data;
	}
	
	public void setDate_of_data(String dateOfData) {
		date_of_data = dateOfData;
	}
	public String getTime_of_data() {
		return time_of_data;
	}
	public void setTime_of_data(String timeOfData) {
		time_of_data = timeOfData;
	}
	public int getInstall_time() {
		return install_time;
	}
	public void setInstall_time(int installTime) {
		install_time = installTime;
	}
	public int getFirst_load_time() {
		return first_load_time;
	}
	public void setFirst_load_time(int firstLoadTime) {
		first_load_time = firstLoadTime;
	}
	public int getLogin_time() {
		return login_time;
	}
	public void setLogin_time(int loginTime) {
		login_time = loginTime;
	}
	public int getRegistration_time() {
		return registration_time;
	}
	public void setRegistration_time(int registrationTime) {
		registration_time = registrationTime;
	}
	
	
	

}
