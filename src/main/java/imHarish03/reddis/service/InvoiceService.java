package imHarish03.reddis.service;

import java.util.List;

import imHarish03.reddis.entity.Invoice;

public interface InvoiceService {
	public Invoice saveInvoice(Invoice inv);

	public Invoice updateInvoice(Invoice inv, Integer invId);

	public void deleteInvoice(Integer invId);

	public Invoice getOneInvoice(Integer invId);

	public List<Invoice> getAllInvoices();

}
