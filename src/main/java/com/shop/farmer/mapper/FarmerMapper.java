package com.shop.farmer.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.shop.farmer.dto.Farmer;
import com.shop.farmer.entity.FarmerEntity;

@Mapper(componentModel = "spring")
public interface FarmerMapper {

	Farmer toDto(FarmerEntity farmerEntity);

	FarmerEntity toEntity(Farmer farmer);

	@BeanMapping(ignoreByDefault = false)
	@Mapping(target = "id",ignore = true)
	void updateEntityFromDto(Farmer dto, @MappingTarget FarmerEntity entity);

}
