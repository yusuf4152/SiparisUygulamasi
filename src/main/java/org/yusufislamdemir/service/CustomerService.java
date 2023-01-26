package org.yusufislamdemir.service;

import org.yusufislamdemir.entity.BaseInterface;
import org.yusufislamdemir.entity.Customer;
import org.yusufislamdemir.entity.Order;
import org.yusufislamdemir.repository.CustomerRepository;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService implements BaseService {

    // customer is added
    @Override
    public void add(BaseInterface baseInterface) {
        long count = CustomerRepository.customers.stream()
                .filter(customer -> customer.getId() == ((Customer) baseInterface).getId()).count();
        if (count > 0) {
            return;
        }
        CustomerRepository.customers.add((Customer) baseInterface);
    }

    // get all customers
    @Override
    public List<String> getAll() {
        return CustomerRepository.customers.stream()
                .map(Customer::toString).collect(Collectors.toList());
    }

    // gets customers with the letter C in their name
    public List<String> getCustomersByLetterC() {
        return CustomerRepository.customers.stream()
                .filter(customer -> customer.getName().contains("C"))
                .map(Customer::toString).collect(Collectors.toList());
    }

    //gets customers who signed up in June
    protected List<Customer> getCustomerByRegisteredInJune() {
        return CustomerRepository.customers.stream()
                .filter(customer -> customer.getRegisterDate().getMonth() == Month.JUNE)
                .collect(Collectors.toList());

    }
}
