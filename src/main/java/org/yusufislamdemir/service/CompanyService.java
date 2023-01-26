package org.yusufislamdemir.service;

import org.yusufislamdemir.entity.BaseInterface;
import org.yusufislamdemir.entity.Company;
import org.yusufislamdemir.repository.CompanyRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService implements BaseService {

    private final InvoiceService invoiceService;

    public CompanyService(InvoiceService invoiceService) {
    this.invoiceService= invoiceService;
    }


    // add company
    @Override
    public void add(BaseInterface baseInterface) {

        CompanyRepository.companies.add((Company) baseInterface);
    }

    // get all companies
    @Override
    public List<String> getAll() {
        return CompanyRepository.companies.stream()
                .map(Company::toString)
                .collect(Collectors.toList());

    }
    // get sector name by Invoice Amount Less Than750 and month in june
    public HashSet<String> getCompanySectorByInvoiceAmountLessThan750AndMonthOfJune(){
        return invoiceService.getCompanySectorByInvoiceAmountLessThan750AndMonthOfJune();
    }
}
