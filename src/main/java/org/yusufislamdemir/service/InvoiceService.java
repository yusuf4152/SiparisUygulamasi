package org.yusufislamdemir.service;

import org.yusufislamdemir.entity.BaseInterface;
import org.yusufislamdemir.entity.Customer;
import org.yusufislamdemir.entity.InVoice;
import org.yusufislamdemir.repository.InvoiceRepository;

import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InvoiceService implements BaseService {

    private final CustomerService customerService;

    public InvoiceService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //added invoice
    @Override
    public void add(BaseInterface baseInterface) {
        InvoiceRepository.inVoices.add((InVoice) baseInterface);
    }

    //gets all invoices
    @Override
    public List<String> getAll() {
        return InvoiceRepository.inVoices.stream()
                .map(Object::toString).collect(Collectors.toList());
    }

    //get All Invoices By AmountGreaterThan1500
    public List<String> getAllByAmountGreaterThan1500() {
        return InvoiceRepository.inVoices.stream()
                .filter(inVoice -> inVoice.getAmount() > 1500)
                .map(InVoice::toString)
                .collect(Collectors.toList());
    }

    //gets the average of invoices greater than 1500
    public float getAverageOfAmountOver1500() {
        float totalAmount = getByAmountGreaterThanAmount(1500)
                .mapToInt(InVoice::getAmount)
                .sum();
        long size = getByAmountGreaterThanAmount(1500)
                .count();
        return totalAmount / size;
    }

    private Stream<InVoice> getByAmountGreaterThanAmount(int amount) {
        return InvoiceRepository.inVoices.stream()
                .filter(inVoice -> inVoice.getAmount() > amount);
    }

    //gets the customerName of invoices amount less 500
    public List<String> getCustomerNameByInvoiceAmountLessThan500() {
        return InvoiceRepository.inVoices.stream()
                .filter(inVoice -> inVoice.getAmount() < 500)
                .map(inVoice -> inVoice.getOrder().getCustomer().getName())
                .collect(Collectors.toList());
    }

    // get Total Invoice Registered By June Of Customer
    public long getTotalInvoiceRegisteredByJuneOfCustomer() {
        List<Customer> customers = customerService.getCustomerByRegisteredInJune();
        long total = 0;
        for (Customer customer : customers) {
            total += InvoiceRepository.inVoices.stream()
                    .filter(inVoice -> inVoice.getOrder().getCustomer() == customer)
                    .mapToInt(InVoice::getAmount)
                    .sum();
        }
        return total;
    }

    protected HashSet<String> getCompanySectorByInvoiceAmountLessThan750AndMonthOfJune() {
        HashSet<String> sectors = new HashSet<>();
        InvoiceRepository.inVoices.stream()
                .filter(inVoice -> inVoice.getAmount() < 750 && inVoice.getDateTime().getMonth() == Month.JANUARY)
                .map(inVoice -> inVoice.getCompany().getSector())
                .forEach(sectors::add);
        return sectors;
    }
}
