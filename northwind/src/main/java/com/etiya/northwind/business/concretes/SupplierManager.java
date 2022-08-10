package com.etiya.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.DeleteRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.UpdateRequestSupplier;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
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




	@Override
	public List<SupplierListResponse> getAllPages(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		List<Supplier> suppliers = this.supplierRepository.findAll(pageable).getContent();
		List<SupplierListResponse> response = suppliers.stream().map(supplier->
		this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class)).collect(
				Collectors.toList());
		
		int currentPage = pageNo;
		int totalDatas = suppliers.size();
		int totalPages = (int) Math.ceil(totalDatas/pageSize);
		
		return response;
	}




	@Override
	public Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type) {
		Pageable pageable=PageRequest.of(pageNo-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<Supplier> suppliers =supplierRepository.findAll(pageable);
        response.put("totalElements",suppliers.getTotalElements()) ;
        response.put("totalPages",suppliers.getTotalPages());
        response.put("currentPage",suppliers.getNumber()+1);
        response.put("customers",suppliers.getContent().stream().map(supplier ->
                this.modelMapperService.forResponse().map(supplier,SupplierListResponse.class)).collect(Collectors.toList()));

        return response ;
	}
	
	
	 public Sort sortType(String property,String type){
	        if(type.equals("desc"))
	            return Sort.by(property).descending();
	        else return Sort.by(property).ascending() ;

	
	
	}




//	@Override
//	public List<Supplier> findSuppliersWithSort(String field) {
//		 return  supplierRepository.findAll(Sort.by(Sort.Direction.ASC,field));
//
//	}
//
//
//
//
//	@Override
//	public Page<Supplier> findSuppliersWithPagination(int offset, int pageSize) {
//		  Page<Supplier> suppliers = supplierRepository.findAll(PageRequest.of(offset, pageSize));
//	        return  suppliers;
//	}
//
//
//
//
//	@Override
//	public Page<Supplier> findSuppliersWithPaginationAndSorting(int offset, int pageSize, String field) {
//		Page<Supplier> suppliers = supplierRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return  suppliers;
//	}




	

}
