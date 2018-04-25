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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import maps.parking.txstate.edu.MapsUtil;
import maps.parking.txstate.edu.MapsUtil.Vertex;
import parkinglot.controller.customer.CustomerChooseSlotsController;

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
	private static Map<String, String> bookingMap;
	private static int level = 1;
	private static Label lbl;
	private static Button dir;
	private static Button okButton;
	private static VehicleType vtype;
	private static String vnumber;
	private static String slotNo;
	private static Label lbl_level;
	public static String cardNumber;
	public static int cvv;
	public static String nameOnCard;
	private static int source = 1;
	private static boolean buttoninit = false;
	private static Map<String, Button> buttonMap = new HashMap<String, Button>();

	private static void destroy() {
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private static void init() {
		initMap();

		display = new Display();
		shell = new Shell(display);
		shell.setMaximized(true);
		shell.open();

		layout = new Image(display, "resources/images/layout.png");
		Image loc = new Image(display, "resources/images/location.gif");
		Image updown = new Image(display, "resources/images/updown.png");
		Image up1 = new Image(display, "resources/images/up1.png");
		Image up2 = new Image(display, "resources/images/up2.png");
		Image down1 = new Image(display, "resources/images/down1.png");
		Image down2 = new Image(display, "resources/images/down2.png");

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

		org.eclipse.swt.graphics.Font font = new Font(display, "Arial", 13, SWT.BOLD);
		lbl_level = new org.eclipse.swt.widgets.Label(shell, SWT.None);
		lbl_level.setBounds(1290, 550, 20, 20);

		lbl_level.setFont(font);
		lbl_level.setForeground(new Color(display, 150, 50, 0));

		lbl_level.setText("" + level);

		dir = new Button(shell, SWT.None);
		dir.setBounds(1250, 200, 100, 25);
		dir.setText("Get Directions");

		upb.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);

				if (level == 4)
					return;

				level++;
				lbl_level.setText("" + level);

				downb.setEnabled(true);
				if (level == 4) {
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
				if (level == 1)
					return;

				level--;
				lbl_level.setText("" + level);

				upb.setEnabled(true);

				if (level == 1) {
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

		CustomerChooseSlotsController controller = new CustomerChooseSlotsController();
		
		okButton = new Button(shell, SWT.None);
		okButton.setBounds(1250, 250, 100, 25);
		okButton.setText("ok");
		
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				
				System.out.println(vtype);
				
				switch (vtype) {
				

				case MOTORCYCLE:
					controller.enterDetailsIntoDB(cardNumber, cvv,
							nameOnCard, vnumber, "MOTORCYCLE", Integer.valueOf(slotNo));
					break;

				case CAR:
					controller.enterDetailsIntoDB(cardNumber, cvv,
							nameOnCard, vnumber, "CAR", Integer.valueOf(slotNo));
					break;

				case BUS:
					controller.enterDetailsIntoDB(cardNumber, cvv,
							nameOnCard, vnumber, "BUS", Integer.valueOf(slotNo));

					break;

				}
			}
		});

		dir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				super.widgetSelected(e);

				String no = ("" + slotNo + "").substring(2);

				List<MapsUtil.Vertex> path = MapsUtil.init(MapsUtil.v1, "P" + no);
				lbl.setText(lbl.getText() + "\n\nTime(mins) : " + (path.get(path.size() - 1).minDistance) / 25
						+ "\nDistance(ft) : " + path.get(path.size() - 1).minDistance);
				Vertex v = path.get(0);
				for (int i = 1; i < path.size(); i++) {
					gc.setForeground(new Color(display, 250, 33, 0));
					gc.setLineWidth(5);
					gc.drawLine(v.getX(), v.getY(), path.get(i).getX(), path.get(i).getY());
					v = path.get(i);
				}
				
				okButton.setEnabled(true);
			}
		});

		lbl = new org.eclipse.swt.widgets.Label(shell, SWT.None);
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

	public static void selectSlot(VehicleType vt, String vehicle_number, String cardNo, int cv, String name) {
		vtype = vt;
		vnumber = vehicle_number;
		cardNumber = cardNo;
		cvv = cv;
		nameOnCard = name;
		
		System.out.println(name);
		
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
		Image vac_c = new Image(display, "resources/images/vac_c.jpg");
		Image bus = new Image(display, "resources/images/bus.jpg");
		for (int i = 1; i < 7; i++) {
			String key = level + "3" + i;
			if (bookingMap.get(key) == null) {
				gc.drawImage(vac_c, 18 + i * 140, 600);
			} else {
				gc.drawImage(bus, 18 + i * 140, 600);
			}

		}
	}

	private static void select_bike() {
		Image bike_a = new Image(display, "resources/images/bike_a.jpg");
		Image bike_booked = new Image(display, "resources/images/bike_booked.jpg");
		for (int i = 1; i < 21; i++) {
			String key = level + "1" + i;
			if (bookingMap.get(key) == null) {
				gc.drawImage(bike_a, 242, 18 * i + 134);
			} else {
				gc.drawImage(bike_booked, 242, 18 * i + 134);
			}
		}

		for (int i = 1; i < 21; i++) {
			String key = level + "1" + (i + 20);
			if (bookingMap.get(key) == null) {
				gc.drawImage(bike_a, 395, 18 * i + 134);
			} else {
				gc.drawImage(bike_booked, 395, 18 * i + 134);
			}
		}
	}

	private static void select_car() {

		Image vac_b = new Image(display, "resources/images/vac_b.jpg");
		final Image car_b = new Image(display, "resources/images/car_b.jpg");
		final Image car_b_selected = new Image(display, "resources/images/car_b_selected.jpg");

		for (int i = 1; i < 49; i++) {
			final String key = level + "2" + i;
			final Button button = getButton("2" + i);
			if (!buttoninit) {
				button.setBounds(87 + 20 * i, 30, 15, 48);
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						super.widgetSelected(e);
						button.setImage(car_b_selected);
						slotNo = "" + level + button.getData("key");
						bookingMap.put(slotNo, vnumber);
						lbl.setText("Slot selected :" + key + "\n\nCar No." + vnumber);
						dir.setEnabled(true);
						persistMap();
					}
				});
			}

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

		Image vac_a = new Image(display, "resources/images/vac_a.jpg");
		Image car_a = new Image(display, "resources/images/car_a.jpg");
		Image car_a_selected = new Image(display, "resources/images/car_a_selected.jpg");
		Image car_c_selected = new Image(display, "resources/images/car_c_selected.jpg");
		Image car_c = new Image(display, "resources/images/car_c.jpg");

		for (int i = 1; i < 21; i++) {

			final String key = level + "2" + (50 + i);
			final Button button = getButton("2" + (50 + i));
			if (!buttoninit) {
				button.setBounds(35, 20 * i + 77, 43, 15);
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						super.widgetSelected(e);
						button.setImage(car_a_selected);
						slotNo = "" + level + button.getData("key");
						bookingMap.put(slotNo, vnumber);
						lbl.setText("Slot selected :" + key + "\n\nCar No." + vnumber);
						dir.setEnabled(true);
						persistMap();
					}
				});
			}

			if (bookingMap.get(key) == null) {
				button.setToolTipText("Select Slot: " + key);
				button.setImage(vac_a);
				button.redraw();
			} else {
				button.setImage(car_a);
				button.setBounds(35, 20 * i + 77, 43, 15);
				button.setToolTipText("Slot: " + key + "\nCar No.: " + bookingMap.get(key));
			}

		}

		for (int i = 1; i < 19; i++) {

			final String key = level + "2" + (70 + i);
			final Button button = getButton("2" + (70 + i));
			if (!buttoninit) {
				button.setBounds(180, 20 * i + 130, 43, 15);
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						super.widgetSelected(e);
						button.setImage(car_c_selected);
						slotNo = "" + level + button.getData("key");
						bookingMap.put(slotNo, vnumber);
						lbl.setText("Slot selected :" + key + "\n\nCar No." + vnumber);
						dir.setEnabled(true);
						persistMap();
					}
				});
			}

			if (bookingMap.get(key) == null) {
				button.setToolTipText("Select Slot: " + key);
				button.setImage(vac_a);
				button.redraw();
			} else {
				button.setImage(car_c);
				button.setBounds(180, 20 * i + 130, 43, 15);
				button.setToolTipText("Slot: " + key + "\nCar No.: " + bookingMap.get(key));
			}

			// gc.drawImage(vac_a, 180, 20 * i + 130);
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
		buttoninit = true;

	}

	private static Button getButton(String string) {
		Button b = buttonMap.get(string);
		if (b == null) {
			b = new Button(shell, SWT.NONE);
			b.setData("key", string);
			buttonMap.put(string, b);
		}
		return b;
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
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (f != null) {
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
		for (Map.Entry<String, String> entry : bookingMap.entrySet()) {
			if (entry.getValue().equals(vehicle_number)) {
				bookingMap.remove(entry.getKey());
				break;
			}
		}
		persistMap();
	}

	enum VehicleType {
		CAR, MOTORCYCLE, BUS
	}

	public static void selectSlot(String string, String text, String cardNo, int cvv, String nameOnCard) {
		// TODO Auto-generated method stub
		if (string.equalsIgnoreCase("CAR"))
			selectSlot(VehicleType.CAR, text, cardNo, cvv, nameOnCard);
		else if (string.equalsIgnoreCase("MOTORCYCLE"))
			selectSlot(VehicleType.MOTORCYCLE, text,  cardNo, cvv, nameOnCard);
		else if (string.equalsIgnoreCase("BUS"))
			selectSlot(VehicleType.BUS, text,  cardNo, cvv, nameOnCard);
	}
}
