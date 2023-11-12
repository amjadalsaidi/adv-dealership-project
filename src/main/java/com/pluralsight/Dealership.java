package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    Scanner scanner =  new Scanner(System.in);

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public Vehicle getVehiclesByVinNumber(int vin) {
        List<Vehicle> sellingVehicle = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                sellingVehicle.add(vehicle);
                System.out.println("Vehicle found successfully!");
                return sellingVehicle.get(0);
            }
        }
        System.out.println("Wrong vin number, enter vaild vin number: !");
        vin = scanner.nextInt();
        return getVehiclesByVinNumber(vin) ;
    }



    public void ProcessSaleContract (String date, String name, String email , Vehicle  sellingVehicle){

        SalesContract salesContract = new SalesContract(date, name, email, sellingVehicle);
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(salesContract);
    }

    public void ProcessLeaseContract (String date, String name, String email , Vehicle  sellingVehicle){

        LeaseContract leaseContract = new LeaseContract(date, name, email, sellingVehicle);
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(leaseContract);
    }

}
