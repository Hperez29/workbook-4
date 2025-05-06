package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        String make = "Ford";
        String model = "Mustang";
        Car car1;
        car1 = new Car(make, model);
        System.out.println(car1.getSpeed());
        car1.accelerate(10);
        car1.accelerate(25);
        System.out.println(car1.getSpeed());
        car1.brake(10);
        System.out.println(car1.getSpeed());

    }
}