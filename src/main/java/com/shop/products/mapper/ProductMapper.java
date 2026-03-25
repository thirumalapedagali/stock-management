package com.shop.products.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.shop.products.dto.Product;
import com.shop.products.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	
	Product toDto(ProductEntity pe);
	
	
	ProductEntity toEntity(Product pe);
	

    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "id", ignore = true)
	void updateEntityFromDto(Product dto, @MappingTarget ProductEntity entity);

}
