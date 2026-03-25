package com.shop.farmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.farmer.dto.Farmer;
import com.shop.farmer.entity.FarmerEntity;

public interface FarmerRepository extends JpaRepository<FarmerEntity, Long>{
	
	
	FarmerEntity findByMobile(String mobile1);

	List<FarmerEntity> findByVillage(String village);
	
	

}
