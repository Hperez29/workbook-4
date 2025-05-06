package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // === Room behavior test ===
        Room room = new Room(2, 150.0, false, false);
        room.checkIn();      // Should succeed
        room.checkOut();     // Should mark as unoccupied and dirty
        room.checkIn();      // Should say not available
        room.cleanRoom();    // Clean it
        room.checkIn();      // Should succeed again

        System.out.println();

        // === Employee manual time tracking test ===
        Employee emp = new Employee("E002", "Bob", "Front Desk", 22.0, 0);
        emp.punchIn(9.0);
        emp.punchOut(17.5);  // Adds 8.5 hours
        System.out.printf("Manual Time - Regular: %.2f, Overtime: %.2f, Total Pay: $%.2f%n",
                emp.getRegularHours(), emp.getOvertimeHours(), emp.getTotalPay());

        System.out.println();

        // === Employee system time tracking test ===
        emp.punchIn();       // Uses current system time
        try {
            Thread.sleep(2000); // Simulate working for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emp.punchOut();      // Uses current system time

        System.out.printf("After System Punch - Regular: %.2f, Overtime: %.2f, Total Pay: $%.2f%n",
                emp.getRegularHours(), emp.getOvertimeHours(), emp.getTotalPay());
    }
}
