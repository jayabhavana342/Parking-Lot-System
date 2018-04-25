# Parking-Lot-System

admin
=====
1. SEARCH AND UPDATE PARKER (*)
2. MENU (making buttons - home, registercustomer , updaterates, logout) (a)
3. POPULATE HOMEPAGE DATA (b)

customer check-in
=================
1. Available Bike Slots (b)
3. Database slots population (s) - update after mehak finishes all slots for all levels
4. while time details is updated fetch is_active rate and add it to check_in_rate field in timedetails.(b)

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