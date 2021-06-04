package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.TranscationDetails;

public interface TranscationDetailsRepository extends JpaRepository<TranscationDetails,Long> {

}
