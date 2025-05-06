package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private final String name;
    private final double payRate;
    private double hoursWorked;
    private Double punchInTime = null;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.name = name;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        double regularHours = getRegularHours();
        double overtimeHours = getOvertimeHours();
        return (regularHours * payRate) + (overtimeHours * payRate * 1.5);
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Manual punch in
    public void punchIn(double time) {
        if (punchInTime == null) {
            punchInTime = time;
            System.out.println(name + " punched in at " + time);
        } else {
            System.out.println(name + " is already punched in.");
        }
    }

    // System time punch in
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + now.getMinute() / 60.0;
        punchIn(time);
    }

    // Manual punch out
    public void punchOut(double time) {
        if (punchInTime != null) {
            double duration = time - punchInTime;
            if (duration > 0) {
                hoursWorked += duration;
                System.out.printf("%s punched out at %.2f (Worked %.2f hours)%n", name, time, duration);
            } else {
                System.out.println("Punch out time must be after punch in time.");
            }
            punchInTime = null;
        } else {
            System.out.println(name + " must punch in before punching out.");
        }
    }

    // System time punch out
    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + now.getMinute() / 60.0;
        punchOut(time);
    }
}