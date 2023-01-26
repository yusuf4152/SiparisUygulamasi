package org.yusufislamdemir;

import org.yusufislamdemir.entity.Company;
import org.yusufislamdemir.entity.Customer;
import org.yusufislamdemir.entity.InVoice;
import org.yusufislamdemir.entity.Order;
import org.yusufislamdemir.service.CompanyService;
import org.yusufislamdemir.service.CustomerService;
import org.yusufislamdemir.service.InvoiceService;
import org.yusufislamdemir.service.OrderService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        InvoiceService invoiceService = new InvoiceService(customerService);
        OrderService orderService = new OrderService(invoiceService);
        CompanyService companyService= new CompanyService(invoiceService);
;        Customer customer2 = new Customer(2, "Ceyhun", "demir", LocalDate.of(2020, 6, 12));
        Customer customer1 = new Customer(1, "yusuf", "demir");
        Customer customer3 = new Customer(3, "Ceyhun", "demir", LocalDate.of(2020, 6, 12));
        Company company= new Company(1," a sirketi","yazılım");
        Order order1 = new Order(1, "siparis 1", customer1,250,company);
        Order order2= new Order(2,"siapris2",customer2,500,company);
        Order order3= new Order(3,"siparis3",customer3,400,company);
        customerService.add(customer1);
        customerService.add(customer2);
        customerService.add(customer3);
        orderService.add(order1);
        orderService.add(order2);
        orderService.add(order3);
        companyService.add(company);
        System.out.println("tüm müşteriler: " + customerService.getAll());
        System.out.println("içinde c harfi olan müşteriler: " + customerService.getCustomersByLetterC());
        System.out.println("sistemdeki tüm siparişler: " + orderService.getAll());
        System.out.println("bir müşterinin siparişleri: " + orderService.getAllByCustomerId(customer1.getId()));
        System.out.println("sistemdeki tüm faturalar: " + invoiceService.getAll());
        System.out.println("sistemdeki 1500 tl üstü faturalar: " + invoiceService.getAllByAmountGreaterThan1500());
        System.out.println("sistemdeki 1500 tl üstü faturaların ortalaması: " + invoiceService.getAverageOfAmountOver1500());
        System.out.println("sistemdeki 500 tl altı faturalara sahip olan müşteriler: "+invoiceService.getCustomerNameByInvoiceAmountLessThan500());
        System.out.println("haziranda kayıt olan müşterilerin toplam faturaları:"+ invoiceService.getTotalInvoiceRegisteredByJuneOfCustomer());
        System.out.println("haziran ayında 750 tl altı fatularsı olan firmaların sektörleri: "+ companyService.getCompanySectorByInvoiceAmountLessThan750());
    }
}