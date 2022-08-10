package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.suppliers.CreateRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.DeleteRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.UpdateRequestSupplier;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;

public interface SupplierService {

	List<SupplierListResponse> getAll();
	void add(CreateRequestSupplier createRequestSupplier);
	GetSupplierResponse getById(int supplierId);
	void delete(DeleteRequestSupplier deleteRequestSupplier);
	void update(UpdateRequestSupplier updateRequestSupplier);
	
//	List<Supplier> findSuppliersWithSort(String field);
//    Page<Supplier> findSuppliersWithPagination(int offset, int pageSize);
//    Page<Supplier> findSuppliersWithPaginationAndSorting(int offset, int pageSize, String field);
	
	  List<SupplierListResponse> getAllPages(int pageNo , int pageSize);
		 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
}
