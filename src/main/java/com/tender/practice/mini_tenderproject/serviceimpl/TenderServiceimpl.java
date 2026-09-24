  	package com.tender.practice.mini_tenderproject.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tender.practice.mini_tenderproject.MiniTenderprojectApplication;
import com.tender.practice.mini_tenderproject.TenderStatusProjection.TenderStatusProjection;
import com.tender.practice.mini_tenderproject.controller.TenderController;
import com.tender.practice.mini_tenderproject.controller.tenderItemController;
import com.tender.practice.mini_tenderproject.dto.TenderBidOrganizationReportResponse;
import com.tender.practice.mini_tenderproject.dto.TenderItemViewResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusRequest;
import com.tender.practice.mini_tenderproject.dto.TenderStatusResponse;
import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.projection.TenderBidOrganizationReportProjection;
import com.tender.practice.mini_tenderproject.projection.TenderItemViewProjection;
import com.tender.practice.mini_tenderproject.repository.TenderRepository;
import com.tender.practice.mini_tenderproject.service.TenderService;

@Service
public class TenderServiceimpl implements TenderService{

    
  //  /*~~(Unable to determine parameter type)~~>*/private final controller.tenderItemController tenderItemController;

  //  private final MiniTenderprojectApplication miniTenderprojectApplication;

	private final TenderRepository tenderRepository;
	
	public TenderServiceimpl(TenderRepository tenderRepository) {

		this.tenderRepository = tenderRepository;
	
	//	this.miniTenderprojectApplication = miniTenderprojectApplication;
	}
	
	@Override
	public TenderResponse createTender(TenderRequest request) {
		Tender tender = Tender.builder()
						.tenderNumber(request.getTenderNumber())
						.title(request.getTitle())
						.description(request.getDescription())
						.status(request.getStatus())
						.organizationId(request.getOrganizationId())
						.publishDate(request.getPublishDate())
						.closingDate(request.getClosingDate())
						.estimatedValue(request.getEstimatedValue())
						.build();
		
		Tender saveTender = tenderRepository.save(tender);
		
		TenderResponse response = TenderResponse.builder()
									.id(saveTender.getId())
									.tenderNumber(saveTender.getTenderNumber())
									.title(saveTender.getTitle())
									.description(saveTender.getDescription())
									.status(saveTender.getStatus())
									.organizationId(saveTender.getOrganizationId())
									.publishDate(saveTender.getPublishDate())
									.closingDate(saveTender.getClosingDate())
									.estimatedValue(saveTender.getEstimatedValue())
									.build();
						
		return response;
	}
	

	@Override
	public TenderResponse getTenderById(Long id) {
		Tender tender =tenderRepository.findById(id).orElseThrow(() -> new RuntimeException("Tender Id Was Not Found :" + id));
		
		TenderResponse response = TenderResponse.builder()
										.id(tender.getId())
										.tenderNumber(tender.getTenderNumber())
										.title(tender.getTitle())
										.description(tender.getDescription())
										.status(tender.getStatus())
										.organizationId(tender.getOrganizationId())
										.publishDate(tender.getPublishDate())
										.closingDate(tender.getClosingDate())
										.estimatedValue(tender.getEstimatedValue())
										.build();
		
		return response;
										
										
	}

	@Override
	public List<TenderResponse> getAllTenders() {
		List<Tender> tender = tenderRepository.findAll();
		
		List<TenderResponse> responses =new ArrayList<>();
		
		for(Tender tenders : tender) {
				
			TenderResponse response = TenderResponse.builder()
										.id(tenders.getId())
										.tenderNumber(tenders.getTenderNumber())
										.title(tenders.getTitle())
										.description(tenders.getDescription())
										.status(tenders.getStatus())
										.organizationId(tenders.getOrganizationId())
										.publishDate(tenders.getPublishDate())
										.closingDate(tenders.getClosingDate())
										.estimatedValue(tenders.getEstimatedValue())
										.build();
			
										responses.add(response);
										
	/*	List<Tender> tender = tenderRepository.findAll();
		
		return tender.stream()
				.map(tender -> TenderResponse.builder()
						.id(tenders.getId())
						.tenderNumber(tenders.getTenderNumber())
						.title(tenders.getTitle())
						.description(tenders.getDescription())
						.status(tenders.getStatus())
						.organizationId(tenders.getOrganizationId())
						.publishDate(tenders.getPublishDate())
						.closingDate(tenders.getClosingDate())
						.estimatedValue(tenders.getEstimatedValue())
						.build())
				.toList();
	*/	
		}
		return responses;
	}

	@Override
	public TenderResponse updateTenderResponse(Long id, TenderRequest request) {
		
		Tender tender = tenderRepository.findById(id).orElseThrow(() -> new RuntimeException("Tender Id Not Found :" + id));
		
						tender.setTenderNumber(request.getTenderNumber());
						tender.setTitle(request.getTitle());
						tender.setDescription(request.getDescription());
						tender.setStatus(request.getStatus());
						tender.setOrganizationId(request.getOrganizationId());
						tender.setPublishDate(request.getPublishDate());
						tender.setClosingDate(request.getClosingDate());
						tender.setEstimatedValue(request.getEstimatedValue());
						
			Tender updateTender =tenderRepository.save(tender);
			
			TenderResponse response = TenderResponse.builder()
					.id(updateTender.getId())
					.tenderNumber(updateTender.getTenderNumber())
					.title(updateTender.getTitle())
					.description(updateTender.getDescription())
					.status(updateTender.getStatus())					
					.organizationId(updateTender.getOrganizationId())
					.publishDate(updateTender.getPublishDate())
					.closingDate(updateTender.getClosingDate())
					.estimatedValue(request.getEstimatedValue())
					.build();
		
		return response;
	}

	private TenderResponse convertToresponsez(Tender tender) {
		return TenderResponse.builder()
				.id(tender.getId())
				.tenderNumber(tender.getTenderNumber())
				.title(tender.getTitle())
				.description(tender.getDescription())
				.status(tender.getStatus())
				.organizationId(tender.getOrganizationId())
				.publishDate(tender.getPublishDate())
				.closingDate(tender.getClosingDate())
				.estimatedValue(tender.getEstimatedValue())
				.build();
				
		
	}

	@Override
	public void deleteTenderById(Long id) {
		 
		 Tender tender = tenderRepository.findById(id).orElseThrow( () -> new RuntimeException("Id not Found :" + id));
		
		  deleteTenderById(id);
	}

	@Override
	public List<TenderResponse> getTenderByStatus(String status) {
		List<Tender> tender = tenderRepository.findTenderByStatus(status);
		
		List<TenderResponse> response = new ArrayList<>();
		
		for(Tender tenders:tender) {
			
			response.add(convertToresponsez(tenders));
		}
		return response;
	}

	@Override
	public List<TenderResponse> findTenderByTitle(String title) {
		List<Tender> tender =tenderRepository.findByTitleContainingIgnoreCase(title);
		
		List<TenderResponse> response=new ArrayList<>();
		
		for (Tender tenders:tender) {
			response.add(convertToresponsez(tenders));
			
			
		}
		return response;
	}

	@Override
	public List<TenderResponse> findTenderByTitleAndStatus(String title, String status) {
		List<Tender> tender= tenderRepository.findTenderByTitleAndStatus(title, status);
		
		List<TenderResponse> responses = new ArrayList<>();
		for(Tender tenders: tender) {
			
			responses.add(convertToresponsez(tenders));
			
		}
 	return responses;
	}

	@Override
	public List<TenderResponse> searchTenderByClosingWithInDays(int days) {
		LocalDate today = LocalDate.now();
	    LocalDate endDate = today.plusDays(days);
			List<Tender> tenders= tenderRepository.findOpenTenderByClosingWithInDays(today, endDate);
			List<TenderResponse> responses = new ArrayList<>();
			for(Tender tender: tenders) {
				
				responses.add(convertToresponsez(tender));
				
			}
	 	return responses;
		
	}

	@Override
	public TenderResponse submitTender(Long id) {

			Tender tender = tenderRepository.findById(id).orElseThrow(() -> new RuntimeException(" Tender Id Not Found :" + id ) );
			
			if(!tender.getStatus().equals("DRAFT")) {
				
				throw new  ResponseStatusException(HttpStatus.BAD_REQUEST , "Only Draft Tenders Can be submitted");
			}
			tender.setStatus("PENDING_APPROVAL");
			
			 	Tender saveTender  =  tenderRepository.save(tender);
			 	
			 	return TenderResponse.builder()
			 			.id(saveTender.getId())
			 			.tenderNumber(saveTender.getTenderNumber())
			 			.title(saveTender.getTitle())
			 			.description(saveTender.getDescription())
			 			.status(saveTender.getStatus())
			 			.organizationId(saveTender.getOrganizationId())
			 			.publishDate(saveTender.getPublishDate())
			 			.closingDate(saveTender.getClosingDate())
			 			.estimatedValue(saveTender.getEstimatedValue())
			 			.build();
	}

	@Override
	public List<TenderItemViewResponse> getTenderItemDtails() {
			List<TenderItemViewProjection> results = tenderRepository.getTenderItemDetails();
			
			
			
		return results.stream()
				.map(item -> new TenderItemViewResponse(
	                    item.getTenderId(),
	                    item.getTenderItemId(),
	                    item.getTenderName(),
	                    item.getPublishDate(),
	                    item.getQuantity(),
	                    item.getPrice()
	            ))
	            .toList();
	}

	@Override
	public List<TenderStatusDetailsResponse> getTenderStatusOrStatus(List<String> statuses) {
	
		List<TenderStatusProjection> results = tenderRepository.findTenderStatusDetails(statuses);
		
		
		return results.stream()
				.map(tender -> TenderStatusDetailsResponse.builder()
						.tenderId(tender.getTenderId())
						.title(tender.getTitle())
						.description(tender.getDescribtion())
						.status(tender.getStatus())
						.tenderItemId(tender.getTenderItemId())
						.quantity(tender.getQuantity())
						.unit(tender.getUnit())
						.price(tender.getPrice())
						.build()
						)
				.toList();
						
			}

	@Override
	public List<TenderOrganizationResponse> getTenderOrganixzationDetails() {

		return tenderRepository.findTenderOrgaqnizationDetails();
		
		
	}

	@Override
	public TenderStatusResponse updateTenderStatus(long id, TenderStatusRequest request) {
		Tender tender = tenderRepository.findById(id).orElseThrow(() -> new RuntimeException(" Tende Id Not Fount Exception :" + id));
		
		 	tender.setStatus(request.getStatus());
		 	
		 	Tender saveStatus = tenderRepository.save(tender);
		 	
		 	TenderStatusResponse response = new TenderStatusResponse();
		 	
		 	response.setStatus(saveStatus.getStatus());

		
		return response;
	}

	@Override
	public List<TenderResponse> getTenderStatus(String status) {
		List<Tender> tenders = tenderRepository.findByStatus(status);
		
		List<TenderResponse> response = new ArrayList<>();
		
		for(Tender responses:tenders) {
			
			TenderResponse result = new TenderResponse();
			
			result.setStatus(responses.getStatus());
			
			response.add(result);
		}
		
		
		return response;
	}

	@Override
	public List<TenderResponse> getTenderTitle(String status) {
		 List<Tender> tenders = tenderRepository.findTenderByTitle(status);
		 
		 List<TenderResponse> responses = new ArrayList<>();
		 
		 for(Tender tender : tenders) {
			 
			 TenderResponse response = new TenderResponse();
			 
			 response.setTitle(tender.getTitle());
			 
			 responses.add(response);
		 }
		
		return responses;
	}

	@Override
	public List<TenderResponse> getTenderStatuses(List<String> statuses) {
		List<Tender> tenders =tenderRepository.findByStatuses(statuses);
		
		List<TenderResponse> responses =new ArrayList<>();
		
		for(Tender response : tenders) {
			
			TenderResponse result = new TenderResponse();
			
			result.setStatus(response.getStatus());
			
			responses.add(result);
			
		}
		
		
		return responses;
	}

	@Override
	public TenderResponse updateTenderStatus(Long id, String status) {
		Tender tender =tenderRepository.findById(id).orElseThrow(() -> new RuntimeException("Tender Id Not Found :" + id));
		
		
		tender.setStatus(status);
		
		Tender savedTender =  tenderRepository.save(tender);
		TenderResponse response =new TenderResponse();
		
		response.setId(savedTender.getId());
		response.setStatus(savedTender.getStatus());
		
		return response;
	}

	@Override
	public List<TenderResponse> gettenderStatus(String status) {
		
		List<Tender> tenders = tenderRepository.findStatus(status);
		
		List<TenderResponse> responses = new ArrayList<>();
		
		for(Tender tender : tenders) {
		
		TenderResponse response = new TenderResponse();
		
		response.setStatus(tender.getStatus());
		
		responses.add(response);
		}
		
		return responses;
	}

	@Override
	public List<TenderResponse> getstatuses(List<String> statuses) {
		
		List<Tender> tenders = tenderRepository.findStatuses(statuses);
		
		List<TenderResponse> responses = new ArrayList<>();
		
		for(Tender tender : tenders) {
			
			TenderResponse response = new TenderResponse();
			
			response.setStatus(tender.getStatus());
			
			responses.add(response);
			
			
		}
		
		return responses;
	}

	@Override
	public List<TenderBidOrganizationReportResponse> gettenderBidOrganizationreport(String status,
			BigDecimal estimatedValue) {
		
		List<TenderBidOrganizationReportProjection> result= tenderRepository.findTenderBidOrganizationReport(status, estimatedValue);
		
		
		return result.stream()
				.map(r -> new TenderBidOrganizationReportResponse(
															r.getTenderNumber(),
															r.getTitle(),
															r.getStatus(),
															r.getEstimatedValue(),
															r.getOrganizationName(),
															r.getDepartment(),
															r.getTotalItem(),
															r.getTotalBid(),
															r.getLowestBidAmount(),
															r.getHighestBidAmount()
															))
				.toList();
	}

	
	
	/*
	 * @Override public List<TenderResponse> getTenderByOrganizationId(Long id) {
	 * List<Tender> tenders =
	 * tenderRepository.getTenderCreatedByPerticularOrganization(id);
	 * 
	 * List<TenderResponse> responses = new ArrayList<>();
	 * 
	 * for(Tender tender : tenders) {
	 * 
	 * responses.add(convertToresponsez(tender)); }
	 * 
	 * return responses; }
	 */
	
}

// 1.Native + Object[] - get data form postgres directly an d and its convert to Dto response  logic in your service

//2.





