package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.DeleteRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.UpdateRequestOrderDetail;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService {

	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
		
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}



	@Override
	public List<OrderDetailListResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = result.stream().map(orderDetail->
		this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList());
		
		
		return response;
	}



	@Override
	public void add(CreateRequestOrderDetail createRequestOrderDetail) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().
				map(createRequestOrderDetail, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
	}



	@Override
	public void update(UpdateRequestOrderDetail updateRequestOrderDetail) {
		OrderDetail orderDetail = this.modelMapperService.forResponse().map(updateRequestOrderDetail, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
	}



	@Override
	public List<OrderDetailListResponse> getAllPages(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		List<OrderDetail> orderDetails = this.orderDetailRepository.findAll(pageable).getContent();
		List<OrderDetailListResponse> response = orderDetails.stream().map(orderDetail->
		this.modelMapperService.forResponse().map(orderDetail, OrderDetailListResponse.class)).collect(
				Collectors.toList());
		
		int currentPage = pageNo;
		int totalDatas = orderDetails.size();
		int totalPages = (int) Math.ceil(totalDatas/pageSize);
		
		return response;
	}



	@Override
	public Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type) {
		Pageable pageable=PageRequest.of(pageNo-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<OrderDetail> orderDetails =orderDetailRepository.findAll(pageable);
        response.put("totalElements",orderDetails.getTotalElements()) ;
        response.put("totalPages",orderDetails.getTotalPages());
        response.put("currentPage",orderDetails.getNumber()+1);
        response.put("customers",orderDetails.getContent().stream().map(orderDetail ->
                this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList()));

        return response ;
	}
	 public Sort sortType(String property,String type){
	        if(type.equals("desc"))
	            return Sort.by(property).descending();
	        else return Sort.by(property).ascending() ;

	    }



	@Override
	public void delete(DeleteRequestOrderDetail deleteRequestOrderDetail) {
		this.orderDetailRepository.deleteOrderDetailWithOrderIdAndProductId(deleteRequestOrderDetail.getOrderId(), deleteRequestOrderDetail.getProductId());
	
	}



	@Override
	public GetOrderDetailResponse getById(int orderId, int productId) {
		OrderDetail orderDetail = this.orderDetailRepository.getByOrderIdAndProductId(orderId, productId);
		GetOrderDetailResponse response = this.modelMapperService.forResponse().map(orderDetail, GetOrderDetailResponse.class);
		return response;
	}


//	@Override
//	public List<OrderDetail> findOrderDetailsWithSort(String field) {
//        return orderDetailRepository.findAll(Sort.by(Sort.Direction.ASC, field));
//
//	}
//
//
//
//	@Override
//	public Page<OrderDetail> findOrderDetailsWithPagination(int offset, int pageSize) {
//		 Page<OrderDetail> orderDetails = orderDetailRepository.findAll(PageRequest.of(offset, pageSize));
//	        return orderDetails;
//	}
//
//
//
//	@Override
//	public Page<OrderDetail> findOrderDetailsWithPaginationAndSorting(int offset, int pageSize, String field) {
//		Page<OrderDetail> orderDetails = orderDetailRepository.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.ASC, field)));
//        return orderDetails;
//	}





}
