package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.TranscationDetails;
import com.pack.repository.TranscationDetailsRepository;

@Service
public class TranscationDetailsService {

	
	@Autowired
	TranscationDetailsRepository transcationDetailsRepo;
	
	public TranscationDetails addTranscation(TranscationDetails transcationDetails) {
		return transcationDetailsRepo.save(transcationDetails);
		
	}
	
}
