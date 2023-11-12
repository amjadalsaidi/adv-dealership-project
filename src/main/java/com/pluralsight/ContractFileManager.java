package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class ContractFileManager {

        public void saveContract(Contract contract)  {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "contracts.csv",true))){
                if(contract instanceof LeaseContract ) {
                    writer.write(String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|", "LEASE",
                            contract.getDate(), contract.getName(), contract.getEmail(), contract.getVehicle(), contract.getVehicle().getVin(),
                            contract.getVehicle().getYear(), contract.getVehicle().getMake(), contract.getVehicle().getModel(),
                            contract.getVehicle().getVehicleType(), contract.getVehicle().getColor(), contract.getVehicle().getOdometer(),
                            contract.getVehicle().getPrice(),
                            contract.getTotalPrice(), contract.getMonthlyPayment()));
                    writer.newLine();
                }
                    //Sales
                     else if (contract instanceof SalesContract){
                        writer.write(String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|","Sale",contract.getDate(), contract.getName(),contract.getEmail(),contract.getVehicle().getVin(),
                                contract.getVehicle().getYear(),contract.getVehicle().getMake(),contract.getVehicle().getModel(),
                                contract.getVehicle().getVehicleType(),contract.getVehicle().getColor(),contract.getVehicle().getOdometer(),
                                contract.getVehicle().getPrice(),
                                contract.getTotalPrice(), contract.getMonthlyPayment()));
                         writer.newLine();

                    }

                } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
