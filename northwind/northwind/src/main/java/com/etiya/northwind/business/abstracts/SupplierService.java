package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.suppliers.CreateRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.DeleteRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.UpdateRequestSupplier;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface SupplierService {

	DataResult<List<SupplierListResponse>> getAll();
	Result add(CreateRequestSupplier createRequestSupplier);
	DataResult<GetSupplierResponse> getById(int supplierId);
	Result delete(DeleteRequestSupplier deleteRequestSupplier);
	Result update(UpdateRequestSupplier updateRequestSupplier);
	
//	List<Supplier> findSuppliersWithSort(String field);
//    Page<Supplier> findSuppliersWithPagination(int offset, int pageSize);
//    Page<Supplier> findSuppliersWithPaginationAndSorting(int offset, int pageSize, String field);
	
	  DataResult<List<SupplierListResponse>> getAllPages(int pageNo , int pageSize);
		 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
}
