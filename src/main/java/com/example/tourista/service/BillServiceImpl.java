package com.example.tourista.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import com.example.tourista.entities.Bill;
import com.example.tourista.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public Map<String, String> CalculateExpense(String price, String days) {

        Map<String, String> expenseMap = new HashMap<>();
        long amount = Long.parseLong(price);
        Integer stayDuaration = Integer.parseInt(days);

        long totalCostWithoutTax = stayDuaration*amount;
        double totalCostWithTax =  totalCostWithoutTax + (0.12*totalCostWithoutTax);
        double tax = 0.12*totalCostWithoutTax;
        expenseMap.put("withOutTax", Long.toString(totalCostWithoutTax));
        expenseMap.put("withTax", Long.toString( Math.round(totalCostWithTax)));
        expenseMap.put("tax",Long.toString(Math.round(tax)));

        return expenseMap;
        
    }

    @Override
    public Bill saveOrder(Bill bill) {
        return billRepository.save(bill);
    }


}
