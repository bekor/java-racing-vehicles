package com.car_race;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Vehicle> vehicles;
    static double isRaining = 0.3;
    static double breakdown = 0.05;

    public static boolean probability(double persentage){
        return Math.random() < persentage;
    }

    public static void createVehicles() throws Exception {
        vehicles = new ArrayList<Vehicle>();

        for(int i = 1; i < 11; i++){
            vehicles.add(new Car());
            vehicles.add(new Motorcycle());
            vehicles.add(new Truck());
        }
    }

    static void simulateRace(){
        for(int i = 1; i < 51; i++){
            boolean isSpeedLimited = probability(isRaining);
            boolean isRainingLimit = probability(isRaining);
            for(Object vehicle : vehicles) {
                if(vehicle instanceof Car) {
                    cars_movement(vehicle, isSpeedLimited);
                }
                else if(vehicle instanceof Motorcycle) {
                    motorcycle_movement(vehicle, isRainingLimit);
                }
                else if(vehicle instanceof Truck) {
                    truck_movement(vehicle);
                }
            }
        }
    }

    public static void printRaceResults(){
        String vehicle_name = "";
        int vehicle_distance = 0;
        String vehicle_type = "";
        for(Object vehicle : vehicles) {
            if(vehicle instanceof Car) {
                Car tmp_vehicle = (Car)vehicle;
                vehicle_type = "Car";
                vehicle_distance = tmp_vehicle.getDistanceTraveled();
                vehicle_name = tmp_vehicle.getName();
            }
            else if(vehicle instanceof Motorcycle) {
                Motorcycle tmp_vehicle = (Motorcycle)vehicle;
                vehicle_type = "Motorcycle";
                vehicle_distance = tmp_vehicle.getDistanceTraveled();
                vehicle_name = tmp_vehicle.getName();
            }
            else if(vehicle instanceof Truck) {
                Truck tmp_vehicle = (Truck) vehicle;
                vehicle_type = "Truck";
                vehicle_distance = tmp_vehicle.getDistanceTraveled();
                vehicle_name = tmp_vehicle.getName();
            }
            System.out.printf("%-20s %d %10s\n", vehicle_name, vehicle_distance, vehicle_type);
        }
    }

    public static void cars_movement(Object car, boolean isSpeedLimited){
        Car tmp_car = (Car)car;
        if (isSpeedLimited) {
            tmp_car.setSpeedLimit(70);
        }
        tmp_car.moveForAnHour();
        tmp_car.setSpeedLimit(111);
    }

    public static void motorcycle_movement(Object motor, boolean isSpeedLimited){
        Motorcycle tmp_motor = (Motorcycle)motor;
        if (isSpeedLimited) {
            tmp_motor.setSpeedLimit(isSpeedLimited);
            isSpeedLimited = !isSpeedLimited;
        }
        tmp_motor.moveForAnHour();
        tmp_motor.setSpeedLimit(isSpeedLimited);
    }

    public static void truck_movement(Object truck){
        boolean isBreakdown = probability(breakdown);
        Truck tmp_truck = (Truck) truck;
        if (isBreakdown) {
            tmp_truck.setBreakdownTurnsLeft(2);
        }
        tmp_truck.moveForAnHour();
    }

    public static void main(String[] args) throws Exception {
        createVehicles();
        simulateRace();
        printRaceResults();
    }
}
