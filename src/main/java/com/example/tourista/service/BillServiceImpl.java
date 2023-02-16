package com.example.tourista.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Override
    public String CalculateExpense(String price, String days) {
        // TODO Auto-generated method stub

        


        // LocalDate cin = LocalDate.parse(checkInDate);
        // LocalDate cout = LocalDate.parse(checkOutDate);
        long amount = Long.parseLong(price);
        Integer stayDuaration = Integer.parseInt(days);
        //long daysBetween = ChronoUnit.DAYS.between(cin, cout);
        //System.out.println(daysBetween);
        //String stayDuaration = Long.toString(daysBetween);
        

        long totalCostWithoutTax = stayDuaration*amount;
        double totalCostWithTax =  totalCostWithoutTax + (0.12*totalCostWithoutTax);
        return Double.toString(totalCostWithTax);
        
    }
    
}
