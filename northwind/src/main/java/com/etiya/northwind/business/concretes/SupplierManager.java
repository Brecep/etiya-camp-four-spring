package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.dataAccess.absracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService {
	private SupplierRepository supplierRepository;

	public SupplierManager(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<SupplierListResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> responses = new ArrayList<>();
		for (Supplier supplier : result) {
			SupplierListResponse supplierListResponse = new SupplierListResponse();
			supplierListResponse.setSupplierId(supplier.getSupplierId());
			supplierListResponse.setCompanyName(supplier.getCompanyName());
			supplierListResponse.setContactName(supplier.getContactName());
			supplierListResponse.setContactTitle(supplier.getContactTitle());
			supplierListResponse.setAddress(supplierListResponse.getAddress());
			supplierListResponse.setCity(supplier.getCity());
			supplierListResponse.setRegion(supplier.getRegion());
			supplierListResponse.setPostalCode(supplier.getPostalCode());
			supplierListResponse.setCountry(supplier.getCountry());

			responses.add(supplierListResponse);
		}
		return responses;
	}

}
