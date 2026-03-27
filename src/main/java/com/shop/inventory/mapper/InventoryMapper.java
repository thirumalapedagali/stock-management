package com.shop.inventory.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.shop.inventory.dto.Inventory;
import com.shop.inventory.entity.InventoryEntity;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
	
	Inventory toDto(InventoryEntity e);
	
	InventoryEntity toEntity(Inventory i);
	
	@BeanMapping(ignoreByDefault = false)
	@Mapping(target = "id",ignore = true)
	void updateEntityFromDto(Inventory in,@MappingTarget  InventoryEntity e);

}
