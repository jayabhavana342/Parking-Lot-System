package parkinglot.model.customer;

public class ParkingVehicleAmountModel {
	private int id;
	private String vehicle_ID;
	private int frequent_parker_id;
	private float bill_amount;

	public ParkingVehicleAmountModel() {
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

	public int getFrequent_parker_id() {
		return frequent_parker_id;
	}

	public void setFrequent_parker_id(int frequent_parker_id) {
		this.frequent_parker_id = frequent_parker_id;
	}

	public float getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}

}
