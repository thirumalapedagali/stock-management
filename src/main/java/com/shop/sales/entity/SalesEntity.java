package com.shop.sales.entity;

import java.time.LocalDate;

import com.shop.farmer.entity.FarmerEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="sales")
public class SalesEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="farmer_id")
	private FarmerEntity farmer;
	Double totalAmount;
	String paymentType;
	LocalDate saleDate;
	String createdBy;
	

}
