package com.cfg.invoice.service;

import com.cfg.invoice.entity.Invoice;
import com.cfg.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
