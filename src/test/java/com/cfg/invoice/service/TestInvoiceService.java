package com.cfg.invoice.service;

import com.cfg.invoice.entity.Invoice;
import com.cfg.invoice.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestInvoiceService {
    @InjectMocks
    private InvoiceService invoiceService;
    @Mock
    private InvoiceRepository invoiceRepository;
    @Test
    public void testCreateInvoice(){
        Invoice invoice=new Invoice(1,"DOC1","Initiated","Osuri",new Date());
        Mockito.when(invoiceRepository.save(Mockito.any(Invoice.class))).thenReturn(invoice);
        Invoice createdInvoice=invoiceService.createInvoice(invoice);
        assertEquals(1,createdInvoice.getInvoiceRef());
        assertEquals("DOC1",invoice.getDocumentNo());
    }
}
