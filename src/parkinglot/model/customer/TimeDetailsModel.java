package parkinglot.model.customer;

import java.sql.Timestamp;

public class TimeDetailsModel {
	private int id;
	private String vehicle_ID;
	private Timestamp Out_Time;
	private int noOfDays;

	public TimeDetailsModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_ID() {
		return vehicle_ID;
	}

	public void setVehicle_ID(String vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}

	public Timestamp getOut_Time() {
		return Out_Time;
	}

	public void setOut_Time(Timestamp out_Time) {
		Out_Time = out_Time;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

}
