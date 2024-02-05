# Barbering-Shop
This Java program simulates the operation of a barber shop using a console-based interface. It models the arrival and service of both regular and VIP customers in a simple queue-based system.

#Overview
The BarberShop class encapsulates the logic for managing the barber shop's queue, handling customer arrivals, and serving customers. The program allows for the following events:

Regular (ORD) customer arrival
VIP customer arrival
Serving the next customer in the queue
Class Structure
Customer: Represent the entry point to the barber shop operations 
BarberShop: Represents the main class managing the barber shop's operations.

Attributes:
queue: LinkedList data structure representing the customer queue.
currentCustomer: Tracks the currently served customer.
ordCount, vipCount: Counters for regular and VIP customers, used to assign customer names.

Methods:
startShop(int event): Initiates different events such as customer arrivals and serving customers based on event codes.
addToQueue(String name, boolean isVip): Adds a customer to the queue, considering VIP status and queue capacity.
serveNextCustomer(): Serves the next customer in the queue.
isQueueFull(): Checks if the queue is full.
printState(String message, int eventNumber): Prints the current state of the barber shop, including the event, current customer, and queue status.

Event Codes
0: Serving the next customer
1: VIP customer arrival
2, 3: Regular customer arrival

How to Run
Compile and run the BarberShop class using a Java development environment or command-line tools.
Notes
The program is designed as a console application for demonstration purposes and can be extended to include additional features or integrated into a graphical user interface.
The simulation provides a basic representation of a barber shop's operation and can serve as a foundation for more complex modeling scenarios.