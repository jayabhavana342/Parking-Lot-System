package slots.parking.txstate.edu;

import slots.parking.txstate.edu.Slots.VehicleType;

/***
 * 
 * @author Mehak Agarwal
 *
 */

public class SlotMain {
	
	public static final String SHOW_CAR_SLOTS_AVAILABLE = "SHOW_CAR_SLOTS_AVAILABLE";
	public static final String SHOW_BIKE_SLOTS_AVAILABLE = "SHOW_BIKE_SLOTS_AVAILABLE";
	public static final String SHOW_BUS_SLOTS_AVAILABLE = "SHOW_BUS_SLOTS_AVAILABLE";
	public static final String SHOW_ALL_SLOTS_AVAILABLE = "SHOW_ALL_SLOTS_AVAILABLE";

	public static void main(String[] args) {
		
		//Slots.main(null);
		
		//Slots.main(SHOW_ALL_SLOTS_AVAILABLE);

		//Slots.main(SHOW_BIKE_SLOTS_AVAILABLE);
		
		//Slots.main(SHOW_BUS_SLOTS_AVAILABLE);
		
		//Slots.main(SHOW_CAR_SLOTS_AVAILABLE);
		
		
		String vehicle_number = "CAR 0036";
		
		//Slots.selectSlot(VehicleType.MOTORCYCLE, vehicle_number);
		//Slots.selectSlot(VehicleType.BUS, vehicle_number);
		Slots.selectSlot(VehicleType.CAR, vehicle_number);
		
		//Slots.checkOut(vehicle_number);
		
		//SlotMain.selectSlot(VehicleType.MOTORCYCLE, vehicle_number);
		
		//SlotMain.selectSlot(VehicleType.BUS, vehicle_number);
		
		
		/*if(args!=null) {
			
			if("0".equals(args[0])) {
				Slots.main(null);
			}else if("1".equals(args[0])) {
				Slots.main(SHOW_ALL_SLOTS_AVAILABLE);
			}else if("2".equals(args[0])) {
				Slots.main(SHOW_BIKE_SLOTS_AVAILABLE);
			}else if("3".equals(args[0])) {
				Slots.main(SHOW_BUS_SLOTS_AVAILABLE);
			}else if("4".equals(args[0])) {
				Slots.main(SHOW_CAR_SLOTS_AVAILABLE);
			}else if("5".equals(args[0]) && "1".equals(args[1])) {
				//String vehicle_number = "CAR 0030";
				Slots.selectSlot(VehicleType.MOTORCYCLE, args[1]);
			}else if("5".equals(args[0]) && "2".equals(args[1])) {
				//String vehicle_number = "CAR 0030";
				Slots.selectSlot(VehicleType.CAR, args[2]);
			}else if("5".equals(args[0]) && "3".equals(args[1])) {
				//String vehicle_number = "CAR 0030";
				Slots.selectSlot(VehicleType.BUS, args[2]);
			}else if("6".equals(args[0])) {
				Slots.checkOut(args[1]);
			}
			
		}*/
		

	}
	
	public static void selectSlot(VehicleType vt, String vehicle_number) {
		Slots.selectSlot(vt, vehicle_number);
	}

}
