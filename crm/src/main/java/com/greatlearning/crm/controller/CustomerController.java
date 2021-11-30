package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.ICustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		List<Customer> customers = customerService.findAll();
		theModel.addAttribute("Customers", customers);
		return "Customers";
	}
}
