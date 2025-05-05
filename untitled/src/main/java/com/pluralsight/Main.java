package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Room behavior test
        Room room = new Room(2, 150.0, false, false);
        room.checkIn();  // should mark as occupied and dirty
        room.checkOut(); // should mark as unoccupied, still dirty
        room.checkIn();  // should say not available
        room.cleanRoom(); // now clean
        room.checkIn();  // available again

        System.out.println();

        // Employee time tracking test
        Employee emp = new Employee("E002", "Bob", "Front Desk", 22.0, 0);
        emp.punchIn(9.0);
        emp.punchOut(17.5); // adds 8.5 hours
        System.out.println("Total hours: " + emp.getRegularHours() + ", Total pay: $" + emp.getTotalPay());
    }
}
