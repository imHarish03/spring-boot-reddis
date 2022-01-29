package imHarish03.reddis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imHarish03.reddis.entity.Invoice;
import imHarish03.reddis.exception.InvoiceNotFoundException;
import imHarish03.reddis.repository.InvoiceRepository;
import imHarish03.reddis.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Override
	public Invoice saveInvoice(Invoice inv) {

		return invoiceRepo.save(inv);
	}

	@Override
	public Invoice updateInvoice(Invoice inv, Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));

		invoice.setInvAmount(inv.getInvAmount());
		invoice.setInvName(inv.getInvName());
		return invoiceRepo.save(invoice);
	}

	@Override
	public void deleteInvoice(Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoiceRepo.delete(invoice);
	}

	@Override
	public Invoice getOneInvoice(Integer invId) {
		Invoice invoice = invoiceRepo.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		return invoice;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		return invoiceRepo.findAll();
	}

}
