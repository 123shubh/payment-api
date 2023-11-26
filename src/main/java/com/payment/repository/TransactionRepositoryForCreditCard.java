package com.payment.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.payment.entity.TransactionByCreditCard;

@Repository
public interface TransactionRepositoryForCreditCard extends JpaRepository<TransactionByCreditCard, Integer> {

	public Optional<TransactionByCreditCard> findByTransactionIdForPaymentByCreditCard(
			String transactionIdForPaymentByCreditCard);

	@Query(value = "SELECT max(serial_id_transaction_by_credit_card) FROM transaction_by_credit_card" ,nativeQuery = true)
	public int getRecentSerialIdTransactionByCreditCard();
	
}
