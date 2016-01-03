package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import repository.CustomerRepository;
import beans.Customer;
import beans.CustomerContainer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/getCustomers")
	public CustomerContainer getCustomers(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		List<Customer> customers = new ArrayList<Customer>();
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
			customers.add(customer);
		}
		System.out.println("Name=" + name);
		CustomerContainer customerContainer = new CustomerContainer();
		customerContainer.setCustomerList(customers);

		return customerContainer;
	}
}