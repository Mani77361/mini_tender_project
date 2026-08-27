package com.tender.practice.mini_tenderproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tender.practice.mini_tenderproject.dto.TenderItemBulkRequest;
import com.tender.practice.mini_tenderproject.dto.TenderItemRequest;
import com.tender.practice.mini_tenderproject.dto.TenderItemResponse;
import com.tender.practice.mini_tenderproject.entity.TenderItem;
import com.tender.practice.mini_tenderproject.repository.TenderItemRepository;
import com.tender.practice.mini_tenderproject.service.TenderItemService;

@Service
public class TenderItemServiceImpl implements TenderItemService{
	
	private final TenderItemRepository tenderItemRepository;
	
	public TenderItemServiceImpl(TenderItemRepository tenderItemRepository) {
		
		this.tenderItemRepository = tenderItemRepository;
		
	}

	@Override
	public TenderItemResponse cerateTenderItem(TenderItemRequest request) {
		
		TenderItem tenderItem = new TenderItem();
		
		tenderItem.setTenderId(request.getTenderId());
		tenderItem.setItemName(request.getItemName());
		tenderItem.setDescription(request.getDescription());
		tenderItem.setQuantity(request.getQuantity());
		tenderItem.setUnit(request.getUnit());
		tenderItem.setUnitPrice(request.getUnitPrice());
		
		TenderItem saveTenderItem = tenderItemRepository.save(tenderItem);
		
		TenderItemResponse response = TenderItemResponse.builder()
									.tenderId(saveTenderItem.getTenderId())
									.itemName(saveTenderItem.getItemName())
									.description(saveTenderItem.getDescription())
									.quantity(saveTenderItem.getQuantity())
									.unit(saveTenderItem.getUnit())
									.unitPrice(saveTenderItem.getUnitPrice())
									.build();
		return response;
	}

	@Override
	public TenderItemResponse findTenderItemById(long id) {
		TenderItem tender = tenderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Tender Item Not Found :" + id));
	
	TenderItemResponse response =TenderItemResponse.builder()
									.tenderItemId(tender.getTenderId())
									.tenderId(tender.getTenderId())
									.itemName(tender.getItemName())
									.description(tender.getDescription())
									.quantity(tender.getQuantity())
									.unit(tender.getUnit())
									.unitPrice(tender.getUnitPrice())
									.build();
		return response;
	}

	@Override
	public List<TenderItemResponse> findAllTenderItem() {
		
		List<TenderItem> tenderItem = tenderItemRepository.findAll();
		
		List<TenderItemResponse> responses = new ArrayList<>();
		
		for(TenderItem tenderItems : tenderItem) {
			
			TenderItemResponse response = TenderItemResponse.builder()
							.tenderItemId(tenderItems.getTenderId())
							.tenderId(tenderItems.getTenderId())
							.itemName(tenderItems.getItemName())
							.description(tenderItems.getDescription())
							.quantity(tenderItems.getQuantity())
							.unit(tenderItems.getUnit())
							.unitPrice(tenderItems.getUnitPrice())
							.build();
							
			responses.add(response);
			
		}
		return responses;
	}

	@Override
	public TenderItemResponse updateTenderItem(Long id, TenderItemRequest request) {
		
		TenderItem  tender =  tenderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item id Not Found :" +id));
		
		tender.setTendrItemId(request.getTenderId());
		tender.setTenderId(request.getTenderId());
		tender.setItemName(request.getItemName());
		tender.setDescription(request.getDescription());
		tender.setQuantity(request.getQuantity());
		tender.setUnit(request.getUnit());
		tender.setUnitPrice(request.getUnitPrice());
		
		TenderItem saveTenderItem = tenderItemRepository.save(tender);
		
		TenderItemResponse response =  new TenderItemResponse();
		
		response.setTenderItemId(saveTenderItem.getTenderId());
		response.setTenderId(saveTenderItem.getTenderId());
		response.setItemName(saveTenderItem.getItemName());
		response.setDescription(saveTenderItem.getDescription());
		response.setQuantity(saveTenderItem.getQuantity());
		response.setUnit(saveTenderItem.getUnit());
		response.setUnitPrice(saveTenderItem.getUnitPrice());
		

		return response;
	}

	@Override
	public void updateBulkTenderItem(TenderItemBulkRequest request) {
		List<TenderItem> tender = tenderItemRepository.findAllById(request.getTenderItemId());
		 
		for(TenderItem  tenders : tender) {
			
			tenders.setDescription(request.getDescription());
			
		}
		tenderItemRepository.saveAll(tender);
	}

	@Override
	public void deleteById(Long id) {
		TenderItem trenderitem =  tenderItemRepository.findById(id).orElseThrow( () -> new RuntimeException("Tender Item Id Not Found :" + id));
		
		deleteById(id);
		
	}

}
