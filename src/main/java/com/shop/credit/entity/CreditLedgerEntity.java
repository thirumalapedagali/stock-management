package com.shop.credit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="credit_ledger")
@Data
public class CreditLedgerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String farmerId;
	String sale_id;
	Double pendingAmount;
	LocalDate dueDate;
	String status;

}
