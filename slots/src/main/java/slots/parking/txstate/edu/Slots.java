package slots.parking.txstate.edu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import maps.parking.txstate.edu.MapsUtil;
import maps.parking.txstate.edu.MapsUtil.Vertex;

/**
 * 
 * @author Mehak Agarwal
 *
 */

public class Slots {

	private static Display display;
	private static Shell shell;
	private static Image layout;
	private static GC gc;
	private static Map<String, String> bookingMap;// = new HashMap<Integer,String>();
	private static int level=1;
	private static Label lbl;
	private static Button dir;
	private static Combo srcSelect;
	private static Text vNumberTxt;
	private static VehicleType vtype;
	private static String vnumber;
	private static String slotNo;
	private static Label lbl_level;
	private static int source =1;
	private static boolean buttoninit= false;
	private static Map<String,Button> buttonMap = new HashMap<String, Button>();

	public static void main(String op) {
		init();

		if (op != null && SlotMain.SHOW_ALL_SLOTS_AVAILABLE.equals(op))
			showAllSlotsAvailable(gc, display, shell);

		if (op != null && SlotMain.SHOW_CAR_SLOTS_AVAILABLE.equals(op)) {
			vac_car_a(gc, display);
			vac_car_b(gc, display);
		}

		if (op != null && SlotMain.SHOW_BIKE_SLOTS_AVAILABLE.equals(op))
			vac_bike(gc, display);

		if (op != null && SlotMain.SHOW_BUS_SLOTS_AVAILABLE.equals(op))
			vac_bus(gc, display);

		destroy();
	}

	private static void destroy() {
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static void init() {
		initMap();
		
		display = new Display();
		shell = new Shell(display);
		shell.setMaximized(true);
		shell.open();

		layout = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/layout.png");
		Image loc = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/location.gif");
		Image updown = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/updown.png");
		Image up1 = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/up1.png");
		Image up2 = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/up2.png");
		Image down1 = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/down1.png");
		Image down2 = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/down2.png");
		
		
		
		gc = new GC(shell);
		gc.drawImage(layout, 0, 0);
		gc.drawImage(loc, 60, 580);
		gc.drawImage(updown, 1260, 460);
		
		final Button upb = new Button(shell, SWT.PUSH);
		upb.setImage(up1);
		upb.setBounds(1283, 468, 30, 70);
		
		
		final Button downb = new Button(shell, SWT.PUSH);
		downb.setImage(down1);
		downb.setBounds(1283, 580, 30, 70);
		
		org.eclipse.swt.graphics.Font font=new Font(display,"Arial", 13, SWT.BOLD);
		lbl_level=new org.eclipse.swt.widgets.Label(shell, SWT.None);
		lbl_level.setBounds(1290, 550, 20, 20);
		
		lbl_level.setFont(font);
		lbl_level.setForeground(new Color(display, 150, 50, 0));
		
		lbl_level.setText(""+level);
		
		dir = new Button(shell, SWT.None);
		dir.setBounds(1250, 200,100,25);
		
		
		dir.setText("Get Directions");
		srcSelect = new Combo(shell, SWT.None);
		srcSelect.add("Source 1");
		srcSelect.add("Source 2");
		srcSelect.add("Source 3");
		srcSelect.add("Source 4");
		srcSelect.select(0);
		srcSelect.setBounds(1250, 180,100,25);
		
		vNumberTxt = new Text(shell, SWT.None);
		vNumberTxt.setBounds(1250, 160,100,25);
		
		upb.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				
				if(level==4)
					return; 
				
				level++;
				lbl_level.setText(""+level);
				
				
				downb.setEnabled(true);
				if(level==4) {
					upb.setEnabled(false);
				}
				
				switch (vtype) {

				case MOTORCYCLE:
					select_bike();
					break;
					
				case CAR:
					
					select_car();
					break;

				case BUS:
					select_bus();
					
					break;

				}
			}
		});
		
		downb.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				if(level == 1)
					return;
				
				level--;
				lbl_level.setText(""+level);
				
				upb.setEnabled(true);
				
				if(level==1) {
					downb.setEnabled(false);
				}
					
				
					
				switch (vtype) {

				case MOTORCYCLE:
					select_bike();
					break;
					
				case CAR:
					
					select_car();
					break;

				case BUS:
					select_bus();
					
					break;

				}
			}
		});
		
		
		dir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				String no = (""+slotNo+"").substring(2);
				List<MapsUtil.Vertex> path = MapsUtil.init(MapsUtil.v1,"P"+no);
				lbl.setText(lbl.getText()+"\n\nTime(mins) : "+(path.get(path.size()-1).minDistance)/25+"\nDistance(ft) : "+path.get(path.size()-1).minDistance);
				Vertex v = path.get(0);
				for(int i =1;i<path.size();i++) {
					gc.setForeground(new Color(display, 250, 33, 0));
					gc.setLineWidth(5);
					gc.drawLine(v.getX(), v.getY(), path.get(i).getX(), path.get(i).getY());
					v=path.get(i);
				}
			}
		});
		
		lbl=new org.eclipse.swt.widgets.Label(shell, SWT.None);
		lbl.setBounds(1210, 20, 500, 150);
		
		lbl.setFont(font);
		lbl.setForeground(new Color(display, 150, 50, 0));
	}

	private static void initMap() {
		File file = new File("map");
		FileInputStream f;
		ObjectInputStream s = null;
		try {
			f = new FileInputStream(file);

			s = new ObjectInputStream(f);

			bookingMap = (Map<String, String>) s.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bookingMap = new HashMap<String, String>();
			/*bookingMap.put(111, "bike1");
			bookingMap.put(115, "bike2");
			bookingMap.put(1128, "bike2");
			
			bookingMap.put(1251, "car1");
			bookingMap.put(1265, "car2");
			bookingMap.put(1268, "car3");
			bookingMap.put(12195, "car4");
			
			
			bookingMap.put(2253, "car5");
			bookingMap.put(2259, "car6");
			bookingMap.put(22192, "car7");
			bookingMap.put(22199, "car8");
			
			
			bookingMap.put(3258, "car9");
			bookingMap.put(3260, "car10");
			bookingMap.put(3267, "car11");
			bookingMap.put(32194, "car12");
			bookingMap.put(32195, "car13");
			
			
			bookingMap.put(42200, "car14");
			bookingMap.put(42202, "car15");
			bookingMap.put(42204, "car16");
			bookingMap.put(42206, "car17");
			bookingMap.put(42208, "car18");
			bookingMap.put(42210, "car19");
			
			bookingMap.put(132, "bus1");
			bookingMap.put(135, "bus2");*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (s != null)
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
	}

	private static void showAllSlotsAvailable(GC gc, Display display, Shell shell) {
		vac_car_a(gc, display);
		vac_car_b(gc, display);
		vac_bike(gc, display);
		vac_bus(gc, display);
	}

	private static void vac_bus(GC gc, Display display) {
		Image vac_c = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/vac_c.jpg");
		for (int i = 1; i < 7; i++) {
			gc.drawImage(vac_c, 18 + i * 140, 600);
		}
	}

	private static void vac_bike(GC gc, Display display) {
		Image bike_a = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/bike_a.jpg");
		
		for (int i = 1; i < 21; i++) {
			gc.drawImage(bike_a, 242, 18 * i + 134);
		}

		for (int i = 1; i < 21; i++) {
			gc.drawImage(bike_a, 395, 18 * i + 134);
		}
	}

	private static void vac_car_b(GC gc, Display display) {
		Image vac_b = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/vac_b.jpg");
		for (int i = 1; i < 49; i++) {
			gc.drawImage(vac_b, 87 + 20 * i, 30);
		}
		
	}

	private static void vac_car_a(GC gc, Display display) {
		Image vac_a = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/vac_a.jpg");
		for (int i = 1; i < 21; i++) {
			gc.drawImage(vac_a, 40, 20 * i + 77);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 180, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 445, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 595, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 656, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 815, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 877, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 1027, 20 * i + 130);
		}
		
	}

	public static void selectSlot(VehicleType vt, String vehicle_number) {
		vtype = vt;
		vnumber = vehicle_number;
		init();

		switch (vt) {

		case MOTORCYCLE:
			select_bike();
			break;

		case CAR:
			select_car();
			break;

		case BUS:
			select_bus();

			break;

		}

		destroy();
	}

	private static void select_bus() {
		Image vac_c = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/vac_c.jpg");
		Image bus = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/bus.jpg");
		for (int i = 1; i < 7; i++) {
			String key = level+"3"+i;
			if (bookingMap.get(key)==null) {
				gc.drawImage(vac_c, 18 + i * 140, 600);
			}else {
				gc.drawImage(bus, 18 + i * 140, 600);
			}
			
		}
	}

	private static void select_bike() {
		Image bike_a = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/bike_a.jpg");
		Image bike_booked = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/bike_booked.jpg");
		for (int i = 1; i < 21; i++) {
			String key = level+"1"+i;
			if (bookingMap.get(key)==null) {
				gc.drawImage(bike_a, 242, 18 * i + 134);
			}else {
				gc.drawImage(bike_booked, 242, 18 * i + 134);
			}
		}

		for (int i = 1; i < 21; i++) {
			String key =level+"1"+(i+20);
			if(bookingMap.get(key)==null) {
				gc.drawImage(bike_a, 395, 18 * i + 134);
			}else {
				gc.drawImage(bike_booked, 395, 18 * i + 134);
			}
		}
	}
	
	private static void select_car() {

		Image vac_b = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/vac_b.jpg");
		final Image car_b = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/car_b.jpg");
		final Image car_b_selected = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/car_b_selected.jpg");

		for (int i = 1; i < 49; i++) {
			final String key = level + "2" + i;
			final Button button = new Button(shell, SWT.NONE);
			button.setBounds(87 + 20 * i, 30, 15, 48);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					super.widgetSelected(e);
					button.setImage(car_b_selected);
					slotNo = key;
					bookingMap.put(slotNo, vnumber);
					lbl.setText("Slot selected :" + key + "\n\nCar No." + vnumber);
					dir.setEnabled(true);
					vNumberTxt.setText(vnumber);
					persistMap();
				}
			});

			if (bookingMap.get(key) == null) {
				button.setToolTipText("Select Slot: " + key);
				button.setImage(vac_b);
				button.redraw();
			} else {
				button.setImage(car_b);
				button.setBounds(87 + 20 * i, 30, 15, 48);
				button.setToolTipText("Slot: " + key + "\nCar No.: " + bookingMap.get(key));
			}

		}
		buttoninit = true;
		Image vac_a = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/vac_a.jpg");
		Image car_a = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/car_a.jpg");
		Image car_c = new Image(display, "C:\\home\\Mehak\\AdvSwEnggProj\\slots\\images/car_c.jpg");

		for (int i = 1; i < 21; i++) {
			String key = level + "2" + (50 + i);
			if (bookingMap.get(key) == null) {
				gc.drawImage(vac_a, 40, 20 * i + 77);
			} else {
				gc.drawImage(car_a, 40, 20 * i + 77);
			}
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 180, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 445, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 595, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 656, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 815, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 877, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {

			String key = level + "2" + (190 + i);
			if (bookingMap.get(key) == null) {
				gc.drawImage(vac_a, 1027, 20 * i + 130);
			} else {
				gc.drawImage(car_c, 1027, 20 * i + 130);
			}

		}

	}



	protected static void persistMap() {
		File file = new File("map");
		FileOutputStream f = null;
		ObjectOutputStream s = null;
		try {
			f = new FileOutputStream(file);

			s = new ObjectOutputStream(f);

			s.writeObject(bookingMap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(f!=null) {
				try {
					f.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}

	public static void checkOut(String vehicle_number) {
		
		initMap();
		for(Map.Entry<String, String> entry: bookingMap.entrySet()) {
			if(entry.getValue().equals(vehicle_number)) {
				bookingMap.remove(entry.getKey());
				break;
			}
		}
		persistMap();
	}
	
	public enum VehicleType{
		CAR,
		MOTORCYCLE,
		BUS
	}

}
