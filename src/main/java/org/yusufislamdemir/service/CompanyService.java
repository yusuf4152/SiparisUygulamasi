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

    @Override
    public void add(BaseInterface baseInterface) {

        CompanyRepository.companies.add((Company) baseInterface);
    }

    @Override
    public List<String> getAll() {
        return CompanyRepository.companies.stream()
                .map(Company::toString)
                .collect(Collectors.toList());

    }
    public HashSet<String> getCompanySectorByInvoiceAmountLessThan750(){
        return invoiceService.getCompanySectorByInvoiceAmountLessThan750AndMonthOfJune();
    }
}
