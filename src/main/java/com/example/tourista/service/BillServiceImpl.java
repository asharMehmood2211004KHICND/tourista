package com.example.tourista.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Override
    public String CalculateExpense(String price, String checkInDate, String checkOutDate) {
        // TODO Auto-generated method stub

        LocalDate cin = LocalDate.parse(checkInDate);
        LocalDate cout = LocalDate.parse(checkOutDate);
        long amount = Long.parseLong(price);

        long daysBetween = ChronoUnit.DAYS.between(cin, cout);
        String stayDuaration = Long.toString(daysBetween);

        long totalCostWithoutTax = daysBetween*amount;
        double totalCostWithTax =  totalCostWithoutTax + (0.12*totalCostWithoutTax);
        return Double.toString(totalCostWithTax);
        
    }
    
}
