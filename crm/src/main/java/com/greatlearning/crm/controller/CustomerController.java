package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/new")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();

		model.addAttribute("newCustomer", true);
		model.addAttribute("customer", customer);

		return "Customer-form";
	}

	@RequestMapping("/edit")
	public String showFormForEdit(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.findById(id);

		model.addAttribute("newCustomer", false);
		model.addAttribute("customer", customer);

		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer = null;

		if (id == 0) {
			customer = new Customer(firstName, lastName, email);
		} else {
			customer = customerService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}
		customerService.save(customer);

		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String showFormForAdd(@RequestParam("id") int id) {
		customerService.deleteById(id);

		return "redirect:/customers/list";
	}
}
