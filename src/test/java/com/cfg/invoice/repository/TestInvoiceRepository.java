package com.cfg.invoice.repository;

import com.cfg.invoice.entity.Invoice;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestInvoiceRepository {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    @Rollback(value = false)
    @Order(1)
    public void testCreateInvoice(){
        Invoice invoice=new Invoice();
       // invoice.setInvoiceRef(1);
        invoice.setDocumentNo("DOC1");
        invoice.setStatus("Initiated");
        invoice.setCreatedBy("Osuri");
        invoice.setCreatedDate(new Date());
        Invoice createdInvoice=invoiceRepository.save(invoice);
        assertEquals(1,createdInvoice.getInvoiceRef());
    }

    @Test
    @Rollback(value = false)
    @Order(2)
    public void testReadInvoice(){
        Invoice invoice=invoiceRepository.findById(1).get();
        assertEquals("Osuri",invoice.getCreatedBy());
        assertEquals("DOC1",invoice.getDocumentNo());
    }
}
