package parkinglot.model.customer;

public class ParkingVehicleAmountModel {
	private int id;
	private int vehicle_ID;
	private int frequent_parker_id;
	private float bill_amount;
	private float checkout_amount;

	public ParkingVehicleAmountModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParkingVehicleAmountModel(int id, int vehicle_ID, int frequent_parker_id, float bill_amount,
			float checkout_amount) {
		super();
		this.id = id;
		this.vehicle_ID = vehicle_ID;
		this.frequent_parker_id = frequent_parker_id;
		this.bill_amount = bill_amount;
		this.checkout_amount = checkout_amount;
	}

	public int getVehicle_ID() {
		return vehicle_ID;
	}

	public void setVehicle_ID(int vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}

	public float getCheckout_amount() {
		return checkout_amount;
	}

	public void setCheckout_amount(float checkout_amount) {
		this.checkout_amount = checkout_amount;
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
