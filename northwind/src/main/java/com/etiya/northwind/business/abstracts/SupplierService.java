package com.etiya.northwind.business.abstracts;

import java.util.List;


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
}
