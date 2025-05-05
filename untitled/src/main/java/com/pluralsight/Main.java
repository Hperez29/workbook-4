package com.pluralsight;

public class Main {

    public static void main(String[] args) {
        // Test Room
        Room room = new Room(2, 150.0, false, false);
        System.out.println("Room available? " + room.isAvailable());

        // Test Reservation
        Reservation reservation = new Reservation("king", 3, true);
        System.out.println("Reservation Total: $" + reservation.getReservationTotal());

        // Test Employee
        Employee employee = new Employee("E001", "Alice", "Housekeeping", 20.0, 45.0);
        System.out.println("Total Pay: $" + employee.getTotalPay());
        System.out.println("Regular Hours: " + employee.getRegularHours());
        System.out.println("Overtime Hours: " + employee.getOvertimeHours());
    }
}