package com.example.tourista.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.tourista.entities.Bill;


public interface BillService {
    /// price , cin , cout , ---> expense


    //public String CalculateExpense(String price,String checkInDate , String checkOutDate);    
    public Map<String, String> CalculateExpense(String price,String days);    

    public Bill saveOrder(Bill bill);
}
