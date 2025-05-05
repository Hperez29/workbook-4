package com.pluralsight;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double punchInTime = null; // Using wrapper to check if it's null

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        return (regularHours * payRate) + (overtimeHours * payRate * 1.5);
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // New behavior
    public void punchIn(double time) {
        if (punchInTime == null) {
            punchInTime = time;
            System.out.println(name + " punched in at " + time);
        } else {
            System.out.println(name + " is already punched in.");
        }
    }

    public void punchOut(double time) {
        if (punchInTime != null) {
            double duration = time - punchInTime;
            if (duration > 0) {
                hoursWorked += duration;
                System.out.println(name + " punched out at " + time + " (Worked " + duration + " hours)");
            } else {
                System.out.println("Punch out time must be after punch in time.");
            }
            punchInTime = null;
        } else {
            System.out.println(name + " must punch in before punching out.");
        }
    }
}