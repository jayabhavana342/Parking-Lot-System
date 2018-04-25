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