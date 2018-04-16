package parkinglot.model.customer;

public class CardDetailsModel 
{
	private int id;
	private String vehicle_ID;
	private String card_No;
	private int cvv;
	private String name_on_card;
	
	

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



	public String getCard_No() {
		return card_No;
	}



	public void setCard_No(String card_No) {
		this.card_No = card_No;
	}



	public int getCvv() {
		return cvv;
	}



	public void setCvv(int cvv) {
		this.cvv = cvv;
	}



	public String getName_on_card() {
		return name_on_card;
	}



	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}



	public CardDetailsModel() {
		// TODO Auto-generated constructor stub
	}

}
