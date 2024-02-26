* Roccatagliatta Restaurant Reservation System
The project consists of a java application that handles online reservations of a restaurant called Roccatagliatta.

** Features
The Roccatagliatta Reservation System includes the following features:

*** For Customers
0. *View Available Tables*: Customers can check available tables by specifying date, time and number of guests.
1. *Create Reservation*: Customers can book a table by specifying the date, time, and number of guests.
2. *Modify Reservation*: Allows for the modification of an existing reservation.
3. *Cancel Reservation*: Provides the option to cancel a reservation.
4. *View Menu*: Customers can view the restaurant's menu.
5. *Special Requests*: Option to add special requests (e.g., dietary restrictions) to their reservation.

*** For Restaurant Staff
0. *Manage Reservations*: Staff can view, confirm, modify, or cancel reservations.
1. *Table Management*: Allocate tables efficiently based on reservation details and restaurant capacity. (@NOTE: perhaps for later)
2. *Customer Management*: Keep track of returning customers and their preferences.
3. *Menu Management*: Update the menu items, prices, and availability.

*** System Administration
0. *User Accounts and Roles*: Secure login for customers and staff with different access levels (e.g., waiter, manager).
1. *Data Analytics*: Insights into reservation patterns, popular times/days, and customer preferences. Only accessible for managers.
2. *Notifications*: Automated email notifications to customers for reservation confirmations, reminders, and changes.

** Technology Stack
- *Backend*: Java (JDK 17+), Spring Boot
- *Database*: MySQL
- *Virtualization*: Docker

** Getting Started
TODO

** Actions
For all of these actions, the user has to be already logged in.

*** Customer (for all of these, the customer needs to be logged in)
0. As a customer, I'd want to know what the restaurant offers to eat that day, so I need to be able to see the menu.
1. As a customer, I'd like to see if there's space available in the restaurant on a given day.
2. As a customer, I'd like to make a reservation on a given day, selecting an available time and menu option (*).
3. As a customer, once I made my reservation, I'd like to cancel it.
4. As a customer, once I made my reservation, I'd like to try and change the day or hour.
5. As a customer, the moment I do my reservation, I'd like to add a comment indicating that I'm allergic to something.

*** Staff

**** Waitress
0. As a waiter, I'd like to see who's coming in today, i.e, reservations. To prepare the corresponding tables, warn cooks, etc.
1. As a waiter, if someone calls and I pick up the phone, I want to register that reservation within the system, so I need to be able to create them.
2. As a waiter, if someone calls to cancel or modify their reservation, I need to be able to do it.

**** Manager
0. As a manager, I'd like to see customer statistics. For example, what are their preferences, what did they eat, etc, and take decisions based on that.
1. As a manager, I'd like to update menu items and/or prices. Perhaps, if there's an outage of some ingredients, also change availability of some menu options.

**** Admin
0. As an admin, I want all options available to me.
1. As an admin, I additionally want the option of "promote" a waitress to manager and viceversa.

* TO DO
- Continue with application.

- Handle cases where the json input is wrong in controllers. (LATER)
- Do Unit and Integration tests of them. (LATER)
- Functional tests. (LATER)
