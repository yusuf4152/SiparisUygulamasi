package org.yusufislamdemir.service;

import org.yusufislamdemir.entity.BaseInterface;
import org.yusufislamdemir.entity.InVoice;
import org.yusufislamdemir.entity.Order;
import org.yusufislamdemir.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements BaseService {

    private final InvoiceService invoiceService;

    public OrderService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    //each time an order is added an inVoice
    // is automatically generated whose name is a combination of the order name and the customer name
    @Override
    public void add(BaseInterface baseInterface) {
        OrderRepository.orders.add((Order) baseInterface);
        InVoice invoice = new InVoice(InVoice.numberOfInvoice,
                ((Order) baseInterface).getName() + " " + ((Order) baseInterface).getCustomer().getName(),
                ((Order) baseInterface).getAmount(),
                (Order) baseInterface,((Order) baseInterface).getCompany());
        invoiceService.add(invoice);
    }

    // get all Orders
    @Override
    public List<String> getAll() {
        return OrderRepository.orders.stream()
                .map(Order::toString).collect(Collectors.toList());
    }

    //gets all orders of the customer whose id is given
    public List<String> getAllByCustomerId(int id) {
        return OrderRepository.orders.stream()
                .filter(order -> order.getCustomer().getId() == id)
                .map(Order::toString).collect(Collectors.toList());
    }
}
