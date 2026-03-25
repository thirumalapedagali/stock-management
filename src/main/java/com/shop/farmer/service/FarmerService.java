package com.shop.farmer.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.shop.farmer.dto.Farmer;
import com.shop.farmer.entity.FarmerEntity;
import com.shop.farmer.mapper.FarmerMapper;
import com.shop.farmer.repository.FarmerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmerService {

	private final FarmerRepository farmerRepository;
	
	private final FarmerMapper farmerMapper;
	
	public Farmer createFarmer(Farmer farmer) {
		FarmerEntity entity = farmerMapper.toEntity(farmer);
		FarmerEntity save = farmerRepository.save(entity);
		return farmerMapper.toDto(save);
	}

	public @Nullable List<Farmer> getAllFarmers() {
		List<FarmerEntity> all = farmerRepository.findAll();
		return all.stream().map(m->farmerMapper.toDto(m)).toList();
	}

	public @Nullable Farmer getFarmerById(Long id) {
		FarmerEntity byId = farmerRepository.findById(id).orElseThrow(()->new RuntimeErrorException(null, "Farmer not Found"));
		return farmerMapper.toDto(byId);
	}

	public Farmer updateFarmer(Long id, Farmer farmer) {
		FarmerEntity entity = farmerRepository.findById(id).orElseThrow(()-> new RuntimeErrorException(null, "Farmer not dounct"));
		farmerMapper.updateEntityFromDto(farmer,entity);
		FarmerEntity save = farmerRepository.save(entity);
		return farmerMapper.toDto(save);
	}

	public String deleteFarmer(Long id) {
		farmerRepository.deleteById(id);
		return "Farmer Deleted";
	}

	public Farmer findByMobile(String mobile) {
		FarmerEntity byId = farmerRepository.findByMobile(mobile);
		
		return farmerMapper.toDto(byId);
	}

	public @Nullable List<Farmer> findByVillage(String village) {
       List<FarmerEntity> all = farmerRepository.findByVillage(village);
		
		return all.stream().map(m->farmerMapper.toDto(m)).toList();
	}

}
