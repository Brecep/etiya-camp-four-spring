package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.DeleteRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.UpdateRequestSupplier;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Product;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService {

	private SupplierRepository supplierRepository;
	private ModelMapperService modelMapperService;
	

	public SupplierManager(SupplierRepository supplierRepository,ModelMapperService modelMapperService) {
		this.supplierRepository = supplierRepository;
		this.modelMapperService = modelMapperService;
	}




	@Override
	public List<SupplierListResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> response = result.stream().map(supplier->
		this.modelMapperService.forResponse().map(supplier,SupplierListResponse.class)).collect(Collectors.toList());
		
		
		return response;
	}




	@Override
	public void add(CreateRequestSupplier createRequestSupplier) {

		Supplier supplier = this.modelMapperService.forRequest().
				map(createRequestSupplier, Supplier.class);
		this.supplierRepository.save(supplier);
	}




	@Override
	public GetSupplierResponse getById(int supplierId) {
		Supplier supplier = this.supplierRepository.getById(supplierId);
		GetSupplierResponse getSupplierResponse = this.modelMapperService.forResponse().map(supplier, GetSupplierResponse.class);	
		return getSupplierResponse;
	}




	@Override
	public void delete(DeleteRequestSupplier deleteRequestSupplier) {
		this.supplierRepository.deleteById(deleteRequestSupplier.getSupplierId());
		
	}




	@Override
	public void update(UpdateRequestSupplier updateRequestSupplier) {

		Supplier supplier = this.modelMapperService.forRequest().map(updateRequestSupplier, Supplier.class);
		this.supplierRepository.save(supplier);
	}




	

}
