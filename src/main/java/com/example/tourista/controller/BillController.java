package com.example.tourista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import com.example.tourista.service.BillService;

@CrossOrigin
@RestController
@RequestMapping("/bill")
public class BillController {
    
    @Autowired
    private BillService billService;

    @GetMapping("/calculate")
    public String calculateExpense(
        @RequestParam(value = "price", required = true) String price,
        @RequestParam(value = "checkInDate", required = true) String checkInDate,
        @RequestParam(value = "checkOutDate", required = true) String checkOutDate
    )
    
    {
           String bill =   billService.CalculateExpense(price, checkInDate, checkOutDate);
           System.out.println("total expense is : "+bill);
           return bill;
            
    }


}
