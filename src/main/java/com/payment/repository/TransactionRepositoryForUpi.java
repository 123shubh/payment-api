package com.payment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.payment.entity.TransactionByUpi;

@Repository
public interface TransactionRepositoryForUpi extends JpaRepository<TransactionByUpi, Integer>{

	public Optional<TransactionByUpi> findByTransactionIdForPaymentByUpi(
			String transactionIdForPaymentByUpi);
	
	@Query(value = "SELECT max(serial_id_transaction_by_upi) FROM transaction_by_upi" ,nativeQuery = true)
	public int getRecentSerialIdTransactionByUpi();
}
