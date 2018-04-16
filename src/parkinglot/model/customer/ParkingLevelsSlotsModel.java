package parkinglot.model.customer;

public class ParkingLevelsSlotsModel {
	private int id;
	private int slot_id;
	private int level_id;
	private boolean is_ocupied;
	
	
	
	public ParkingLevelsSlotsModel() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSlot_id() {
		return slot_id;
	}



	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}



	public int getLevel_id() {
		return level_id;
	}



	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}



	public boolean isIs_ocupied() {
		return is_ocupied;
	}



	public void setIs_ocupied(boolean is_ocupied) {
		this.is_ocupied = is_ocupied;
	}
	
	

}
