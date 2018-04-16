package parkinglot.model.customer;

public class VehicleDetailsModel {
	private int id;
	private String vehicle_No;
	private String Vehicle_Type;
	private int slot_level_id;
	

	public VehicleDetailsModel() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getVehicle_No() {
		return vehicle_No;
	}


	public void setVehicle_No(String vehicle_No) {
		this.vehicle_No = vehicle_No;
	}


	public String getVehicle_Type() {
		return Vehicle_Type;
	}


	public void setVehicle_Type(String vehicle_Type) {
		Vehicle_Type = vehicle_Type;
	}


	public int getSlot_level_id() {
		return slot_level_id;
	}


	public void setSlot_level_id(int slot_level_id) {
		this.slot_level_id = slot_level_id;
	}
	
	

}
