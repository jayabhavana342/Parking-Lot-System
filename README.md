# Parking-Lot-System

admin
=====
1. SEARCH AND UPDATE PARKER (*)
2. MENU (making buttons - home, registercustomer , updaterates, logout) (a)

customer check-in
=================
3. Database slots population (s) - update after mehak finishes all slots for all levels

customer check-out
==================
1. all - integrate with map checkout function (s,b)

on checkout click -> update checkout time, number of days, billed amount(days*checkinrate), is_occupied 
	if frequent parker
		if apply rewards and text field is not empty
			update billed amount text filed 
			on click ok -> update checkout amount
					reward-- from parking user table
		else apply rewards and text field is empty
			update rewards for the user
			and make checkout amount = billed amount
	else
		billed amount=checkout amount
successfull checkoout -> after clicking ok go to main screen
	
final
======
1. field validation


-- To update Out time
update time_details set Out_Time = current_timestamp() where vehicle_ID = 1;

-- To select noOfDays
select datediff(Out_Time, In_Time) as 'noOfDays' from time_details where vehicle_ID = 1;


-- To update noOfDays
update time_details set noOfDays = 2 where vehicle_ID = 1;

-- To select checkIn rate
select check_in_rate from time_details where vehicle_ID = 1;

-- To update bill amount
update parking_vehicle_amount set bill_amount = noOfDays*check_in_rate  where vehicle_ID = 1;


-- To set is_ocupied as empty during check out
update parking_levels_slots set is_ocupied = 0 where id = 111;

-- To update checkout_amount
update parking_vehicle_amount set checkout_amount = 10 where vehicle_ID = 1;

-- To subtract as well as add rewards
update frequent_parking_users set rewards = 1 where phone = '616616616';