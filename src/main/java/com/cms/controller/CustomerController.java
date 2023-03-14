package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.entity.Customer;
import com.cms.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "home-page";
	}

	@GetMapping("/saveCustomer")
	public String saveCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping("/processCustomer")
	public String processCustomer(@ModelAttribute Customer customer, Model model) {
		customerService.saveOrUpdateCustomer(customer);
		return "redirect:/";
	}

	@GetMapping("/updateCustomers")
	public String updateCustomers(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute(customer);
		return "customer-form";
	}

	@GetMapping("/deleteCustomers")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
		customerService.deleteCustomer(id);
		return "redirect:/";
	}
}
